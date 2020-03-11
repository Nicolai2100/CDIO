import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import sun.org.mozilla.javascript.internal.EcmaError;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ExceptionNoIpFound {
        try {
            Beast.getBeast();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        //Kører på port B og C
        DrivingMethods drivingMethods = new DrivingMethods();


        drivingMethods.driveContinuously();
        Delay.msDelay(200);
        drivingMethods.turn90DGRight();
        drivingMethods.stopDriving();


        //close all ports
        try{
            Beast.getMotorB().close();
            Beast.getMotorC().close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}