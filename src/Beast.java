import Rod.ExceptionNoIpFound;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;
import sensors.UltrasonicSensor.UltraSonicSensor;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Beast extends RemoteEV3 {
    private static RemoteEV3 beast = null;
    private static UnregulatedMotor motorB;
    private static UnregulatedMotor motorC;
    private static RMIRegulatedMotor motorD;
    private static UltraSonicSensor ultraSonicSensor;

    private static BrickInfo[] bricks = BrickFinder.discover();
    private static String IPAddress = "";
    private static EV3UltrasonicSensor sampleProvider;

    public static float critialRange = 0.2f;

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
                motorD = beast.createRegulatedMotor("D", 'M');

                ultraSonicSensor = new UltraSonicSensor(SensorPort.S4);


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
        if (range1 - range2 > 0.01) {
            System.out.println("Sidder fast!");
            return false;
        }
        return true;
    }

    public static void grabAndLift() {
        try {
            // Grab and lift
            motorD.setSpeed(1000);
            motorD.forward();
            Delay.msDelay(1500);

            //return to default
            motorD.backward();
            Delay.msDelay(2000);
            motorD.forward();
            Delay.msDelay(500);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void dispose() throws RemoteException {
        motorB.close();
        motorC.close();
        motorD.close();
        ultraSonicSensor.close();
    }
}