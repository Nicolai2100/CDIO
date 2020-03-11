import lejos.utility.Delay;

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
        float range = Beast.getSensorUS().getRange();


        drivingMethods.driveContinuously();
        int i = 0;
        while (i < 5) {
            while (range > 0.12) {
                System.out.println("Range: " + range * 100);
                Delay.msDelay(100);
                range = Beast.getSensorUS().getRange();
            }
            drivingMethods.turn90DGRight();
            drivingMethods.stopDriving();
            drivingMethods.driveContinuously();
            i++;
            range = Beast.getSensorUS().getRange();


        }
        drivingMethods.closeDriving();


        //close all ports
        try {
            Beast.getSensorUS().close();
            Beast.getMotorB().close();
            Beast.getMotorC().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}