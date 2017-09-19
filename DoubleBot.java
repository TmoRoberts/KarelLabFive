


import kareltherobot.*;

/**
 * Write a description of class Template here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleBot extends Robot
{
    // instance variables - replace the example below with your own
    public int beepers;
    public int amount;
    /**
     * Constructor for objects of class Template
     */
     public DoubleBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }

    public void doubleBeepers(){
        moveToBeepers();
        pickBeepers();
        putBeepersBack();
        putDoubleBeepers();
    }
    public void moveToBeepers() {
        while (!nextToABeeper()) {
            move();
        }
    }
    public void pickBeepers() {
        while (nextToABeeper()) {
            pickBeeper();
            beepers++; 
        }
    }
    public void putBeepersBack() {
        for (int i = 0; i < beepers; i++) {
            putBeeper();
        }
        move();
    }
    public void putDoubleBeepers() {
        for (int j = 0; j < beepers*2; j++) {
            putBeeper();
        }
        move();
    }
    }

