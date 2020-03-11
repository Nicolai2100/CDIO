package Rod;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ExceptionNoIpFound extends Exception {

    public ExceptionNoIpFound() {

    }


    public String toString() {

        return "CustomException";
    }

}
