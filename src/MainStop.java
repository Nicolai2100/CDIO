import Rod.ExceptionNoIpFound;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainStop {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ExceptionNoIpFound {

        Beast.getMotorB().close();
        Beast.getMotorC().close();
        Beast.getSensorUS().close();
    }
}