package UltrasonicSensor;

import lejos.robotics.SampleProvider;

public abstract class UltraSonicAbstractClass implements SampleProvider {
    protected final SampleProvider source;
    protected final int sampleSize;


    public UltraSonicAbstractClass(SampleProvider source) {
        int sampleSize1;
        this.source = source;
        sampleSize1 = sampleSize1 = source.sampleSize();
        this.sampleSize = sampleSize1;
    }

    public int sampleSize(){
        return sampleSize;
    }

    public void fetchSample(float[] sample, int offset){
        source.fetchSample(sample, offset);
    }
}
