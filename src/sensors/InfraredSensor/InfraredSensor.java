package sensors.InfraredSensor;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;

public class InfraredSensor implements RangeFinder {

    EV3IRSensor sensor;
    SampleProvider sampleProvider;
    float[] sample;

    public InfraredSensor(Port port) {
        sensor = new EV3IRSensor(port);
        sampleProvider = sensor.getDistanceMode();
        sample = new float[sampleProvider.sampleSize()];
    }


    @Override
    public float getRange() {
        sampleProvider.fetchSample(sample, 0);
        return sample[0];
    }

    @Override
    public float[] getRanges() {
        sampleProvider.fetchSample(sample, 0);
        return sample;
    }

    public void close() {
        sensor.close();
    }
}
