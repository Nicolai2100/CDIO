import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.Sound;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        RemoteEV3 ev3;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info: bricks){
            System.out.println();
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);
        }

        ev3 = new RemoteEV3(bricks[0].getIPAddress());
        ev3.setDefault();



    }
}