package sensors.ColorSensor;

import lejos.hardware.*;
import lejos.hardware.port.SensorPort;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.Color;
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

        ColorSensor color = new ColorSensor(SensorPort.S2);

        System.out.println("Color Demo");
        //Lcd.print(2, "Press to start");

       // Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.


        Delay.msDelay(1000);

        color.setRedMode();
        color.setFloodLight(Color.WHITE);
        color.setFloodLight(true);


        Delay.msDelay(1000);


        color.setRGBMode();
        color.setFloodLight(Color.WHITE);

        Color rgb;

        while(true) {
            rgb = color.getColor();
            System.out.println("Color:" + color.colorName(color.getColorID()));
        }

    }
}
