import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.remote.ev3.RemoteEV3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Beast extends RemoteEV3 {
    public static RemoteEV3 beast = null;
    private static BrickInfo[] bricks = BrickFinder.discover();
    private static String IPAddress = "";

    private Beast(String host) throws RemoteException, MalformedURLException, NotBoundException {
        super(host);
    }

    public static RemoteEV3 getBeast() throws RemoteException, MalformedURLException, ExceptionNoIpFound, NotBoundException {
        if (beast == null) {
            try {
                for (BrickInfo info : bricks) {
                    System.out.println(info.getIPAddress());
                    Brick brick = new RemoteEV3(info.getIPAddress());
                    brick.getAudio().systemSound(0);
                }
                beast = new RemoteEV3(bricks[0].getIPAddress());
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("Fandt ikke brick på nettet, prøv igen!");
                System.out.println("Ps, dette skal håndteres bedre");
            }
        }
        return beast;
    }
}