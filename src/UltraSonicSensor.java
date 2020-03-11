import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;
import sun.management.Sensor;

public class UltraSonicSensor implements RangeFinder
{
    EV3UltrasonicSensor sensor;
    SampleProvider sampleProvider;
    float [] sample;


    public UltraSonicSensor(Port port)
    {
        sensor = new EV3UltrasonicSensor(port);
        sampleProvider = sensor.getDistanceMode();
        sample = new float[sampleProvider.sampleSize()];
    }

    @Override
    public float getRange()
    {
        sampleProvider.fetchSample(sample, 0);
        return sample[0];
    }


    @Override
    public float[] getRanges()
    {
        sampleProvider.fetchSample(sample, 0);
        return sample;
    }

    public void close() {
        sensor.close();
    }
}
