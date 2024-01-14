package io.github.amdyep.speedyrandom.core;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public final class SpeedyRandomSeedable extends Random {
    private final ThreadLocalRandom tlRandom = ThreadLocalRandom.current();
    private Random seededRandom;
    private boolean hasSeed;

    public SpeedyRandomSeedable() {
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

    @Override
    public IntStream ints() {
        return hasSeed ? this.internalSeededRandom().ints() : this.tlRandom.ints();
    }

    @Override
    public IntStream ints(long streamSize) {
        return hasSeed ? this.internalSeededRandom().ints(streamSize) : this.tlRandom.ints(streamSize);
    }

    @Override
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return hasSeed ? this.internalSeededRandom().ints(randomNumberOrigin, randomNumberBound) :
                this.tlRandom.ints(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return hasSeed ? this.internalSeededRandom().ints(streamSize, randomNumberOrigin, randomNumberBound) :
                this.tlRandom.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs() {
        return hasSeed ? this.internalSeededRandom().longs() : this.tlRandom.longs();
    }

    @Override
    public LongStream longs(long streamSize) {
        return hasSeed ? this.internalSeededRandom().longs(streamSize) : this.tlRandom.longs(streamSize);
    }

    @Override
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return hasSeed ? this.internalSeededRandom().longs(randomNumberOrigin, randomNumberBound) :
                this.tlRandom.longs(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return hasSeed ? this.internalSeededRandom().longs(streamSize, randomNumberOrigin, randomNumberBound) :
                this.tlRandom.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles() {
        return hasSeed ? this.internalSeededRandom().doubles() : this.tlRandom.doubles();
    }

    @Override
    public DoubleStream doubles(long streamSize) {
        return hasSeed ? this.internalSeededRandom().doubles(streamSize) : this.tlRandom.doubles(streamSize);
    }

    @Override
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return hasSeed ? this.internalSeededRandom().doubles(randomNumberOrigin, randomNumberBound) :
                this.tlRandom.doubles(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return hasSeed ? this.internalSeededRandom().doubles(streamSize, randomNumberOrigin, randomNumberBound) :
                this.tlRandom.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }
}
