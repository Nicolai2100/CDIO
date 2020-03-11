package Beast;

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

public class Beast {
    private static Beast instance = null;
    private static RemoteEV3 beast = null;
    private static UnregulatedMotor motorB;
    private static UnregulatedMotor motorC;
    private static UnregulatedMotor motorD;
    private static UltraSonicSensor ultraSonicSensor;

    private static BrickInfo[] bricks = BrickFinder.discover();
    private static String IPAddress = "";
    private static EV3UltrasonicSensor sampleProvider;

    public static float critialRange = 0.2f;

    private Beast() {
        try {
            for (BrickInfo info : bricks) {
                System.out.println(info.getIPAddress());
                Brick brick = new RemoteEV3(info.getIPAddress());
                brick.getAudio().systemSound(0);
            }
            beast = new RemoteEV3(bricks[0].getIPAddress());
            motorB = new UnregulatedMotor(MotorPort.B);
            motorC = new UnregulatedMotor(MotorPort.C);
            //motorD = beast.createRegulatedMotor("D", 'M');
            motorD = new UnregulatedMotor(MotorPort.D);

            ultraSonicSensor = new UltraSonicSensor(SensorPort.S4);


            beast.setDefault();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fandt ikke brick på nettet, prøv igen!");
            System.out.println("Ps, dette skal håndteres bedre");
        }
    }

    public static Beast getInstance() {
        if (instance == null) {
            instance = new Beast();
        }
        return instance;
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
            motorD.setPower(100);
            Delay.msDelay(1500);
           // Delay.msDelay(1000);

            //return to default
            motorD.backward();
            Delay.msDelay(1500);
            //motorD.forward();
            //Delay.msDelay(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dispose() {
        motorB.close();
        motorC.close();
        motorD.close();
        ultraSonicSensor.close();
    }
}