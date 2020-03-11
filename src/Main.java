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

        DrivingMethods drivingMethods = new DrivingMethods();
        drivingMethods.driveTest(Beast.getMotorB(), Beast.getMotorC() );

    }
}