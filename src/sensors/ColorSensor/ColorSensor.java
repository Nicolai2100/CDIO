package sensors.ColorSensor;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.ColorDetector;
import lejos.robotics.ColorIdentifier;

/**
 * https://stemrobotics.cs.pdx.edu/node/4576?root=4196
 * https://github.com/stemrobotics/EV3-Exercises/blob/master/ColorSensor.java
 */
public class ColorSensor implements ColorDetector, ColorIdentifier
{
    EV3ColorSensor sensor;
    float[] sample;

    public ColorSensor(Port port)
    {
        sensor = new EV3ColorSensor(port);
        setFloodLight(false);
    }


    public void setColorIdMode()
    {
        sensor.setCurrentMode("ColorID");
        sample = new float[sensor.sampleSize()];
    }

    public void setRGBMode()
    {
        sensor.setCurrentMode("RGB");
        sample = new float[sensor.sampleSize()];
    }

    @Override
    public int getColorID()
    {
        sensor.fetchSample(sample, 0);
        return (int) sample[0];
    }

    @Override
    public Color getColor()
    {
        sensor.fetchSample(sample, 0);
        return new Color((int)(sample[0] * 255), (int)(sample[1] * 255), (int)(sample[2] * 255));
    }


    public void close()
    {
        sensor.close();
    }

    public void setFloodLight(boolean on)
    {
        sensor.setFloodlight(on);
    }


    public void setFloodLight(int color)
    {
        sensor.setFloodlight(color);
    }

    //Alle farver har en specifik int, fx white = 6
    public static String colorName(int color)
    {
        switch (color)
        {
            case Color.NONE:
                return "None";

            case Color.BLACK:
                return "Black";

            case Color.BLUE:
                return "Blue";

            case Color.BROWN:
                return "Brown";

            case Color.CYAN:
                return "Cyan";

            case Color.DARK_GRAY:
                return "Dark Gray";

            case Color.GRAY:
                return "Gray";

            case Color.GREEN:
                return "Green";

            case Color.LIGHT_GRAY:
                return "Light Gray";

            case Color.MAGENTA:
                return "Magenta";

            case Color.ORANGE:
                return "Orange";

            case Color.RED:
                return "Red";

            case Color.WHITE:
                return "White";
        }
        return "";
    }
}