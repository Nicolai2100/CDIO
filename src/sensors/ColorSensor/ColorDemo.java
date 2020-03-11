package sensors.ColorSensor;

import lejos.hardware.*;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ColorDemo
{
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RemoteEV3 ev3;
        BrickInfo[] bricks = BrickFinder.discover();

        for (BrickInfo info : bricks) {
            System.out.println(info.getIPAddress());
            Brick brick = new RemoteEV3(info.getIPAddress());
            brick.getAudio().systemSound(0);
        }

        ColorSensor colorSensor = new ColorSensor(SensorPort.S2);

        System.out.println("ColorSensor kører..");
        Sound.beepSequenceUp();    // ColorSensor er klar


        Delay.msDelay(1000);

        colorSensor.setColorIdMode();
        colorSensor.setFloodLight(false);


        boolean run  = true;
        while (run) {
            System.out.println(ColorSensor.colorName(colorSensor.getColorID()));
            Delay.msDelay(250);
        }
        colorSensor.close();
    }
}

