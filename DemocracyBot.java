
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class DemocracyBot extends Robot
{
    public int beepers;
    public DemocracyBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void fixBallots() {
        for (int i = 0; i < 5; i++) {
            move();
            checkBallotBoxes();
        }
        
    }
    public void moveDownAisle() {
        while (!nextToABeeper()) {
            move();
            checkBallotBoxes();
        }
    }
    public void checkBallotBoxes() {
        if (nextToABeeper()) {
            turnLeft();
            move();
            if (nextToABeeper()) {
                beepers++;
                turnLeft();
                turnLeft();
                move();
            }
            else {
                placeBallots();
            }
            move();
            if (nextToABeeper()) {
                beepers--;
                turnLeft();
                turnLeft();
                move();
                turnRight();
            }
            else {
                placeBallots();
            }
            while (beepers != 0) {
                beepers--;
            }
        }
        if (!nextToABeeper()) {
            turnLeft();
            move();
            if (nextToABeeper()) {
                while (nextToABeeper()) {
                    pickBeeper();
                }
                turnLeft();
                turnLeft();
                move();
            }
            else {
                turnLeft();
                turnLeft();
                move();
            }
            move();
            if (nextToABeeper()) {
                while (nextToABeeper()) {
                    pickBeeper();
                }
                turnRight();
                turnRight();
                move();
            }
            else {
                turnRight();
                turnRight();
                move();
            }
            turnRight();
        }
    }
    public void cleanUp() { 
        if (!nextToABeeper()) {
            turnLeft();
            move();
            if (nextToABeeper()) {
                pickBeeper();
                turnLeft();
                turnLeft();
                move();
            }
            else {
                turnLeft();
                turnLeft();
                move();
            }
            move();
            if (nextToABeeper()) {
                pickBeeper();
                turnRight();
                turnRight();
                move();
            }
            else {
                turnRight();
                turnRight();
                move();
            }
            turnRight();
            move();
        }
    }
      public void placeBallots() {
        while (!nextToABeeper()) {
        putBeeper();
    }
    }
      public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}

