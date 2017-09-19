
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class DangerousBot extends Robot
{
    public int beepers;
    public DangerousBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void choosePile() {
        countPile();
        putBeepersBack();
        chooseRoom();
        pickSafePile();
    }
    public void countPile() {
        while (nextToABeeper()) {
            pickBeeper();
            beepers++;
        }
    }
    public void putBeepersBack() {
        for (int i = 0; i < beepers; i++) {
            putBeeper();
        }
    }
    public void chooseRoom() {
        if (beepers % 2 == 0) {
            turnRight();
            move();
        }
        else {
            turnLeft();
            move();
        }
    }
    public void pickSafePile() {
        while (nextToABeeper()) {
            pickBeeper();
        }
        if (facingEast()) {
            turnLeft();
            turnLeft();
            move();
        }
        else {
            turnRight();
            turnRight();
            move();
        }
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}

