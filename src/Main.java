import lejos.hardware.BrickFinder;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException {


        // Detecting EV3 Brick
        RemoteEV3 ev3 = (RemoteEV3) BrickFinder.getDefault();

        // Creating objects for motor and IR sensor
        RMIRegulatedMotor leftMotor = ev3.createRegulatedMotor("B", 'L');
        RMIRegulatedMotor rightMotor = ev3.createRegulatedMotor("C", 'L');

        leftMotor.setSpeed(-50);
        leftMotor.forward();
        rightMotor.setSpeed(-50);
        rightMotor.forward();

        leftMotor.stop(true);
        rightMotor.stop(true);

    }
}