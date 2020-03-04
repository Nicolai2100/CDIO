import lejos.hardware.*;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    static EV3LargeRegulatedMotor lEFT_MOTOR;

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {


        // Detecting EV3 Brick

        RemoteEV3 ev3 = null;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);

        }
        if (bricks.length == 1) {
            ev3 = new RemoteEV3(bricks[0].getIPAddress());
            ev3.setDefault();
            Sound.beep();
            Sound.beep();
        }

        RMIRegulatedMotor leftMotor = ev3.createRegulatedMotor("B", 'L');
        leftMotor.setSpeed(2000);
        leftMotor.forward();

        Delay.msDelay(2000);
        leftMotor.stop(true);
        leftMotor.close();



//        RMIRegulatedMotor rightMotor = ev3.createRegulatedMotor("C", 'L');
        ///  RMIRegulatedMotor hightMotor = ev3.createRegulatedMotor("B", 'L');
        /*leftMotor.setSpeed(-50);
        leftMotor.forward();*/
        //  rightMotor.setSpeed(-50);
        //rightMotor.forward();

        /*hightMotor.setSpeed(-50);
        hightMotor.forward();*/

/*

        leftMotor.stop(true);
        rightMotor.stop(true);
*/



/*        lEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort. A);
        lEFT_MOTOR = new EV3LargeRegulatedMotor(MotorPort. A);



        lEFT_MOTOR.setSpeed(200);
        Delay.msDelay(2000);
        lEFT_MOTOR.stop();
        lEFT_MOTOR.close();*/


//        Button.LEDPattern(4);     // flash green led and

        //lEFT_MOTOR.setSpeed(200);
        //  ev3.s Sound.beepSequenceUp();   // make sound when ready.


//        RemoteEV3 ev3 = (RemoteEV3) BrickFinder.getDefault();


        Sound.beepSequence(); // we are done.

/*

        RMIRegulatedMotor leftMotor = ev3.createRegulatedMotor("B", 'L');
        RMIRegulatedMotor rightMotor = ev3.createRegulatedMotor("C", 'L');*/
/*
        leftMotor.setSpeed(-50);
        leftMotor.forward();
        rightMotor.setSpeed(-50);
        rightMotor.forward();*/

     /*   leftMotor.stop(true);
        rightMotor.stop(true);*/

    }
}