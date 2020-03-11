import Rod.ExceptionNoIpFound;
import lejos.hardware.Sound;

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
        DrivingMethods drive = new DrivingMethods();
        // drive.driveInCircle(10);
        drive.driveTest();
        Sound.beepSequence(); // we are done.

        Beast.dispose();
    }
}