import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        GlobalParams globals = ObjectBuilder.createGlobalParams();
        globals.setPrevCoordsShip1(-1, -1);

        /*for (int i = 0; i < 40; i++) {
            System.err.println(in.nextLine());
        }*/

        initGlobalParams(in, globals);
        while (true) {
            RoundParams params = ObjectBuilder.createRoundParams();
            initRoundParams(in, params);

            Coord firstShipChkPnt = globals.checkpoints.get(params.playerShipOne.nextChkPoint - 1);
            int desiredX1 = firstShipChkPnt.x;
            int desiredY1 = firstShipChkPnt.y;

            Coord secondShipChkPnt = globals.checkpoints.get(params.playerShipTwo.nextChkPoint - 1);
            int desiredX2 = secondShipChkPnt.x;
            int desiredY2 = secondShipChkPnt.y;

            int speed = 100;
            if (globals.prevCoords1.x != -1) {
                desiredX1 = new Double(firstShipChkPnt.x - 3.3 * params.playerShipOne.speed.vx).intValue();
                desiredY1 = new Double(firstShipChkPnt.y - 3.3 * params.playerShipOne.speed.vy).intValue();

                desiredX2 = new Double(secondShipChkPnt.x - 3.3 * params.playerShipTwo.speed.vx).intValue();
                desiredY2 = new Double(secondShipChkPnt.y - 3.3 * params.playerShipTwo.speed.vy).intValue();
            }
            globals.setPrevCoordsShip1(params.playerShipOne.location.x, params.playerShipOne.location.y);
            globals.setPrevCoordsShip2(params.playerShipTwo.location.x, params.playerShipTwo.location.y);

            System.out.println(desiredX1 + " " + desiredY1 + " " + speed);
            System.out.println(desiredX2 + " " + desiredY2 + " " + speed);
        }
    }

    private static void initRoundParams(Scanner in, RoundParams params) {
        String shipDetails = in.nextLine();
        addShipDetails(params.playerShipOne, shipDetails);

        shipDetails = in.nextLine();
        addShipDetails(params.playerShipTwo, shipDetails);

        shipDetails = in.nextLine();
        addShipDetails(params.enemyShipOne, shipDetails);

        shipDetails = in.nextLine();
        addShipDetails(params.enemyShipTwo, shipDetails);
    }

    private static void addShipDetails(Ship ship, String shipDetails) {
        String[] details = shipDetails.split(" ");
        ship.location = ObjectBuilder.createCoord();
        ship.location.x = Integer.valueOf(details[0]);
        ship.location.y = Integer.valueOf(details[1]);
        ship.speed = ObjectBuilder.createSpeed();
        ship.speed.vx = Integer.valueOf(details[2]);
        ship.speed.vy = Integer.valueOf(details[3]);
        ship.angle = Integer.valueOf(details[4]);
        ship.nextChkPoint = Integer.valueOf(details[5]);
    }

    private static void initGlobalParams(Scanner in, GlobalParams params) {
        params.laps = in.nextInt();
        System.err.println("Laps: " + params.laps);
        int nrOfCheckPoints = in.nextInt();
        System.err.println("Nr. of points: " + nrOfCheckPoints);
        params.checkpoints = new ArrayList<Coord>();
        for (int i = 0; i < nrOfCheckPoints; i++) {
            Coord chkPoint = ObjectBuilder.createCoord();
            chkPoint.x = in.nextInt();
            chkPoint.y = in.nextInt();
            params.checkpoints.add(chkPoint);
        }
    }

    private static class ObjectBuilder {
        private static final Player instance;
        static {
            instance = new Player();
        }

        public static RoundParams createRoundParams() {
            RoundParams params = instance.new RoundParams();
            return params;
        }

        public static Speed createSpeed() {
            Speed params = instance.new Speed();
            return params;
        }

        public static GlobalParams createGlobalParams() {
            GlobalParams params = instance.new GlobalParams();
            return params;
        }

        public static Coord createCoord() {
            Coord coord = instance.new Coord();
            return coord;
        }
    }

    private class RoundParams {
        private Ship playerShipOne;
        private Ship playerShipTwo;
        private Ship enemyShipOne;
        private Ship enemyShipTwo;

        private RoundParams() {
        }
    }

    private class GlobalParams {
        public List<Coord> checkpoints;

        private Coord      prevCoords1;
        private Coord      prevCoords2;
        private int        laps;

        public void setPrevCoordsShip1(int x, int y) {
            prevCoords1 = new Coord(x, y);
        }

        public void setPrevCoordsShip2(int x, int y) {
            prevCoords2 = new Coord(x, y);
        }
    }

    private class Coord {

        private int x;
        private int y;

        public Coord() {
        }

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Ship {
        private Coord location;
        private Speed speed;
        private int   angle;
        private int   nextChkPoint;
    }

    private class Speed {
        private int vx;
        private int vy;
    }
}