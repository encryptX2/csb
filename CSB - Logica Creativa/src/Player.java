import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        GlobalParams globalParams = getGlobalParams(in);

        // game loop
        while (true) {
            processStage(in, globalParams);

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("BOMB 6 5");
        }
    }

    private static void processStage(Scanner in, GlobalParams globalParams) {
        RoundParams roundParams = initRoundParams(in);

    }

    private static GlobalParams getGlobalParams(Scanner in) {
        GlobalParams params = new GlobalParams();
        params.setLaps(in.nextInt());
        System.err.println("Laps: " + params.getLaps());
        int nrOfCheckPoints = in.nextInt();
        System.err.println("Nr. of points: " + nrOfCheckPoints);
        params.checkpoints = new ArrayList<Coord>();
        for (int i = 0; i < nrOfCheckPoints; i++) {
            Coord chkPoint = new Coord();
            chkPoint.setX(in.nextInt());
            chkPoint.setY(in.nextInt());
            params.checkpoints.add(chkPoint);
        }
        return params;
    }

    private static RoundParams initRoundParams(Scanner in) {
        RoundParams params = new RoundParams();
        String shipDetails = in.nextLine();
        params.setPlayerShipOne(getShip(shipDetails));

        shipDetails = in.nextLine();
        params.setPlayerShipTwo(getShip(shipDetails));

        shipDetails = in.nextLine();
        params.setEnemyShipOne(getShip(shipDetails));

        shipDetails = in.nextLine();
        params.setEnemyShipTwo(getShip(shipDetails));
        return params;
    }

    private static Ship getShip(String shipDetails) {
        Ship ship = new Ship();
        String[] details = shipDetails.split(" ");
        ship.setLocation(new Coord());
        ship.getLocation().setX(Integer.valueOf(details[0]));
        ship.getLocation().setY(Integer.valueOf(details[1]));
        ship.setSpeed(new SpeedVector());
        ship.getSpeed().setVx(Integer.valueOf(details[2]));
        ship.getSpeed().setVy(Integer.valueOf(details[3]));
        ship.setAngle(Integer.valueOf(details[4]));
        ship.setNextChkPoint(Integer.valueOf(details[5]));
        return ship;
    }
}

class Coord {

    private int x;
    private int y;

    public Coord() {
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class GlobalParams {
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

    public Coord getPrevCoords1() {
        return prevCoords1;
    }

    public void setPrevCoords1(Coord prevCoords1) {
        this.prevCoords1 = prevCoords1;
    }

    public Coord getPrevCoords2() {
        return prevCoords2;
    }

    public void setPrevCoords2(Coord prevCoords2) {
        this.prevCoords2 = prevCoords2;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }
}

class Ship {
    private Coord       location;
    private SpeedVector speed;
    private int         angle;
    private int         nextChkPoint;

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord location) {
        this.location = location;
    }

    public SpeedVector getSpeed() {
        return speed;
    }

    public void setSpeed(SpeedVector speed) {
        this.speed = speed;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getNextChkPoint() {
        return nextChkPoint;
    }

    public void setNextChkPoint(int nextChkPoint) {
        this.nextChkPoint = nextChkPoint;
    }
}

class SpeedVector {
    private int vx;
    private int vy;

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
}

class RoundParams {
    private Ship playerShipOne;
    private Ship playerShipTwo;
    private Ship enemyShipOne;
    private Ship enemyShipTwo;

    public Ship getPlayerShipOne() {
        return playerShipOne;
    }

    public void setPlayerShipOne(Ship playerShipOne) {
        this.playerShipOne = playerShipOne;
    }

    public Ship getPlayerShipTwo() {
        return playerShipTwo;
    }

    public void setPlayerShipTwo(Ship playerShipTwo) {
        this.playerShipTwo = playerShipTwo;
    }

    public Ship getEnemyShipOne() {
        return enemyShipOne;
    }

    public void setEnemyShipOne(Ship enemyShipOne) {
        this.enemyShipOne = enemyShipOne;
    }

    public Ship getEnemyShipTwo() {
        return enemyShipTwo;
    }

    public void setEnemyShipTwo(Ship enemyShipTwo) {
        this.enemyShipTwo = enemyShipTwo;
    }
}