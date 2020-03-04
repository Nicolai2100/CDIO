import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ExceptionNoIpFound {
        try {
            Beast.getBeast().setDefault();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // create two motor objects to control the motors.
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
        UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);

        DrivingMethods drivingMethods = new DrivingMethods();
        //drivingMethods.driveBackAndForth(motorB, motorC);
        drivingMethods.driveTest(motorB, motorC);

    }
}