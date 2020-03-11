package UltrasonicSensor;

import lejos.robotics.SampleProvider;

public class Distance extends UltraSonicAbstractClass {
    float[] sample;

    public Distance(SampleProvider source) {
        super(source);
        sample = new float[sampleSize];
    }

    public float distance() {
        super.fetchSample(sample, 0);
        return sample[0];
    }
}

