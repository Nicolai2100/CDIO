import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UltraSonicDemo {

    static RemoteEV3 ev3;
    static BrickInfo[] bricks;
    static Brick brick;

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        float range;

        bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println();
            brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);
        }

        ev3 = new RemoteEV3(bricks[0].getIPAddress());
        ev3.setDefault();

        Sound.beepSequenceUp();    // giver lyd, når der er connection
        UltraSonicSensor sensor = new UltraSonicSensor(SensorPort.S4);

        // Metodekald til motorer. Fra Motor-branch.
        DrivingMethods driving = new DrivingMethods();

        range = sensor.getRange();


        System.out.println("Range: " + range*100);


/*
        boolean robotIsRunning = true;
        while(robotIsRunning){
            if (range > 0){

            }
        }

 */
        // free up resources.
        sensor.close();
    }
}