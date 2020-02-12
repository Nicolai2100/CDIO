import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.lcd.TextLCD;

public class Main {

    public static void main(String[] args) {


        LCD.clear();
        LCD.drawString("First EV3 Program", 0, 5);
        Button.waitForAnyPress();
        LCD.clear();
        LCD.refresh();
    /*        LCD.drawString("Enter to Exit", 0, 2);
        Button.ENTER.waitForPressAndRelease();*/

        // get EV3 brick

//		EV3 ev3brick = (EV3) BrickFinder.getLocal();

        //	Mock evMock = new MockBrick();

        EV3 ev3brick;
        if (BrickFinder.getLocal() != null) {
            ev3brick = (EV3) BrickFinder.getLocal();
        }else {
            ev3brick = new MockBrick();
        }




        // instantized LCD class for displaying and Keys // class for buttons
        Keys buttons = ev3brick.getKeys();
        TextLCD lcddisplay = ev3brick.getTextLCD();
        // drawing text on the LCD screen based on
        // coordinates
        lcddisplay.drawString("HelloWorld", 2, 4);
        // exit program after any button pressed
        buttons.waitForAnyPress();

    }
}