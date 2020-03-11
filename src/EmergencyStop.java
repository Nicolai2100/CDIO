import Rod.ExceptionNoIpFound;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class EmergencyStop {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ExceptionNoIpFound {
            Beast.dispose();
    }
}