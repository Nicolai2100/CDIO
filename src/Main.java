import lejos.hardware.Sound;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    static RMIRegulatedMotor motorA, motorB, motorC, motorD;

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        RemoteEV3 ev3 = new RemoteEV3("192.168.43.206");
        ev3.setDefault();

        Sound.twoBeeps();

    }
}