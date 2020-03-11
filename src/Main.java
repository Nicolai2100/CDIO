import Rod.ExceptionNoIpFound;
import Beast.Beast;
import lejos.hardware.Sound;
import lejos.utility.Delay;

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
        drive.driveContinuously();
        Delay.msDelay(20000);
        Beast.dispose();

    }
}