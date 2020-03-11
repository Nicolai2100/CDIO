import Rod.ExceptionNoIpFound;
import Beast.Beast;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ExceptionNoIpFound {
        try {
            Beast.getInstance();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        //Kører på port B og C
        DrivingMethods drive = new DrivingMethods();
        drive.driveInCircle(10);

        //close all ports
/*        try {
            Beast.Beast.getSensorUS().close();
            Beast.Beast.getMotorB().close();
            Beast.Beast.getMotorC().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  */  }
}