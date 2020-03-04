import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, Exception {

        RemoteEV3 ev3;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);

        }

        ev3 = new RemoteEV3(bricks[0].getIPAddress());
        ev3.setDefault();

        // create motor objects to control the motor.
        //UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
        RMIRegulatedMotor rmiMotorA = ev3.createRegulatedMotor("D", 'M');
        //EV3MediumRegulatedMotor mMotor = new EV3MediumRegulatedMotor(MotorPort.D);
        //NXTRegulatedMotor mMotor = new NXTRegulatedMotor(MotorPort.D);

        // set motors to 50% power.
        //motorA.setPower(20);
        //mMotor.setSpeed(20);
        rmiMotorA.setSpeed(1000);
        rmiMotorA.forward();
        //mMotor.forward();
        //motorD.setPower(20);
        Delay.msDelay(1500);

        //motorA.setPower(-20);
        rmiMotorA.backward();
        //mMotor.backward();
        //motorD.setPower(-20);
        Delay.msDelay(2000);
        rmiMotorA.forward();
        Delay.msDelay(500);

        // stop motors with brakes on.
        //motorA.stop();
        //mMotor.stop();
        //motorD.stop();
        rmiMotorA.stop(false);

        // free up motor resources.
        //motorA.close();
        //mMotor.close();
        rmiMotorA.close();
        //motorD.close();

        Sound.beepSequence(); // we are done.


    }
}