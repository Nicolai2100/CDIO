import Rod.ExceptionNoIpFound;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.geometry.Point;
import lejos.utility.Delay;
import sensors.InfraredSensor.InfraredSensor;
import sensors.UltrasonicSensor.UltraSonicSensor;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Beast extends RemoteEV3 {
    private static RemoteEV3 beast = null;
    private static UnregulatedMotor motorB;
    private static UnregulatedMotor motorC;
    private static UltraSonicSensor ultraSonicSensor;
    private static InfraredSensor infraredSensor;

    private static BrickInfo[] bricks = BrickFinder.discover();
    private static String IPAddress = "";
    private static EV3UltrasonicSensor sampleProvider;

    public static float critialRange = 0.2f;

    public static ArrayList<Port> ports = new ArrayList<>();

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

                motorB = new UnregulatedMotor(MotorPort.B);
                motorC = new UnregulatedMotor(MotorPort.C);
                ultraSonicSensor = new UltraSonicSensor(SensorPort.S4);
                infraredSensor = new InfraredSensor();

                ports.add(MotorPort.B);
                ports.add(MotorPort.C);
                ports.add(SensorPort.S4);

                beast.setDefault();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("Fandt ikke brick på nettet, prøv igen!");
                System.out.println("Ps, dette skal håndteres bedre");
            }
        }
        return beast;
    }

    public static UnregulatedMotor getMotorB() {
        return motorB;
    }

    public static UnregulatedMotor getMotorC() {
        return motorC;
    }

    public static UltraSonicSensor getSensorUS() {
        return ultraSonicSensor;
    }

    public static boolean hasNoForwardMotion() {
        float range1 = ultraSonicSensor.getRange();
        Delay.msDelay(100);
        float range2 = ultraSonicSensor.getRange();
        if (range1 - range2 < 0.01) {
            System.out.println("Sidder fast!");
            return true;
        }
        return false;
    }
}