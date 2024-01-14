package io.github.amdyep.speedyrandom.core;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpeedyRandom extends Random {
    private final ThreadLocalRandom tlRandom = ThreadLocalRandom.current();
    private Random seededRandom;
    private boolean hasSeed;

    public SpeedyRandom() {
        // no-op
    }

    @Override
    public synchronized void setSeed(long seed) {
        if (this.seededRandom == null) this.seededRandom = new Random(seed);
        else this.seededRandom.setSeed(seed);
        this.hasSeed = true;
    }

    @Override
    public void nextBytes(byte[] bytes) {
        if (this.hasSeed) this.internalSeededRandom().nextBytes(bytes);
        else this.tlRandom.nextBytes(bytes);
    }

    @Override
    public int nextInt() {
        return hasSeed ? this.internalSeededRandom().nextInt() : this.tlRandom.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        return hasSeed ? this.internalSeededRandom().nextInt(bound) : this.tlRandom.nextInt(bound);
    }

    @Override
    public long nextLong() {
        return hasSeed ? this.internalSeededRandom().nextLong() : this.tlRandom.nextLong();
    }

    @Override
    public boolean nextBoolean() {
        return hasSeed ? this.internalSeededRandom().nextBoolean() : this.tlRandom.nextBoolean();
    }

    @Override
    public float nextFloat() {
        return hasSeed ? this.internalSeededRandom().nextFloat() : this.tlRandom.nextFloat();
    }

    @Override
    public double nextDouble() {
        return hasSeed ? this.internalSeededRandom().nextDouble() : this.tlRandom.nextDouble();
    }

    @Override
    public double nextGaussian() {
        return hasSeed ? this.internalSeededRandom().nextGaussian() : this.tlRandom.nextGaussian();
    }

    private Random internalSeededRandom() {
        if (this.seededRandom == null) this.seededRandom = new Random();
        return this.seededRandom;
    }
}
