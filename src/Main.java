import lejos.hardware.*;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.lcd.TextLCD;
import lejos.remote.ev3.RemoteEV3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {


        /*LCD.drawString("Enter to Exit", 0, 2);
        Button.ENTER.waitForPressAndRelease();
        get EV3 brick
        EV3 ev3brick = (EV3) BrickFinder.getLocal();
        IMock evMock = new MockImpl();*/

/*        LCD.clear();
        LCD.drawString("First EV3 Program", 0, 5);
        Button.waitForAnyPress();
        LCD.clear();
        LCD.refresh();
                EV3 ev3brick;

        try {
            if (BrickFinder.getLocal() != null) {
                ev3brick = (EV3) BrickFinder.getLocal();
            } else {
                ev3brick = new MockImpl();
            }
        } catch (UnsatisfiedLinkError e) {
            ev3brick = new MockImpl();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // instantized LCD class for displaying and Keys // class for buttons
        Keys buttons = ev3brick.getKeys();
        TextLCD lcddisplay = ev3brick.getTextLCD();
        // drawing text on the LCD screen based on
        // coordinates
        lcddisplay.drawString("HelloWorld", 2, 4);
        // exit program after any button pressed
        buttons.waitForAnyPress();

*/


        RemoteEV3 ev3 = new RemoteEV3("192.168.43.206");
        ev3.setDefault();
        Sound.beep();
        Sound.beep();

        Sound.beep();

        Sound.beep();

        Sound.beep();

        Sound.beep();


/*
        RemoteEV3 ev3 = null;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            */
/*Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);*//*

        }
        if (bricks.length == 1) {
            ev3 = new RemoteEV3(bricks[0].getIPAddress());
            ev3.setDefault();
            Sound.beep();
        }
*/



    }
}