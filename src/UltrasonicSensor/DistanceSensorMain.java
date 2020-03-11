package UltrasonicSensor;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class DistanceSensorMain {

    //DifferentialPilot pilot;
    Distance ultrasonic;

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

       /* RemoteEV3 ev3;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);

        */

            new DistanceSensorMain();
        }
    public DistanceSensorMain() throws RemoteException, NotBoundException, MalformedURLException {
        RemoteEV3 ev3;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);
            Port s4 = brick.getPort("S4");
            EV3UltrasonicSensor us = new EV3UltrasonicSensor(s4);
            ultrasonic = new Distance(us.getMode("Distance")); //Will give us the sampleProvider

            while (true) {
                Delay.msDelay(2);
                float distance = ultrasonic.distance();
                if (distance < 0.3) {
                    Motor.B.forward();
                } else if (distance > 0.4) {
                    Motor.B.backward();
                } else {
                    Motor.B.stop();
                }
            }
        }
    }
}
