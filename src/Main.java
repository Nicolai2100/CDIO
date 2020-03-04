import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        RemoteEV3 ev3;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);

        }

        ev3 = new RemoteEV3(bricks[0].getIPAddress());
        ev3.setDefault();

        // create two motor objects to control the motors.
        UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.B);
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.C);

        // set motors to 50% power.
        motorA.setPower(50);
        motorB.setPower(50);

        // wait 2 seconds.
        Delay.msDelay(2000);

        // stop motors with brakes on.
        motorA.stop();
        motorB.stop();

        // free up motor resources.
        motorA.close();
        motorB.close();

        Sound.beepSequence(); // we are done.



    }
}