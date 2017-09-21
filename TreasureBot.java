
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class TreasureBot extends Robot
{
    public int beepers;
    public TreasureBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findTreasure() {
        while (beepers != 5) {
        moveToClue();
        readClue();
        if (beepers == 5) {
            turnOff();
        }
        putBackClue();
    }
}
public void moveToClue() {
        while (!nextToABeeper()) {
            move();
        }
    }
public void readClue() {
        while (nextToABeeper()) {
            pickBeeper();
            beepers++;
            if (beepers == 1) {
                while (!facingNorth()) {
                    turnLeft();
                }
            }
            else if (beepers == 2) {
                while (!facingEast()) {
                    turnLeft();
                }
            }
            else if (beepers == 3) {
                while (!facingSouth()) {
                    turnLeft();
                }
            }
            else if (beepers == 4) {
                while (!facingWest()) {
                    turnLeft();
                }
            }
        }
    }
public void putBackClue() {
        while (beepers > 0) {
            putBeeper();
            beepers--;
        }
        move();
    }
}

