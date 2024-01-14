package io.github.amdyep.speedyrandom.core;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public final class SpeedyRandomSeedless extends Random {
    private final ThreadLocalRandom tlRandom = ThreadLocalRandom.current();

    public SpeedyRandomSeedless() {
        // no-op
    }

    @Override
    public void setSeed(long seed) {
        // no-op
    }

    @Override
    public void nextBytes(byte[] bytes) {
        this.tlRandom.nextBytes(bytes);
    }

    @Override
    public int nextInt() {
        return this.tlRandom.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        return this.tlRandom.nextInt(bound);
    }

    @Override
    public long nextLong() {
        return this.tlRandom.nextLong();
    }

    @Override
    public boolean nextBoolean() {
        return this.tlRandom.nextBoolean();
    }

    @Override
    public float nextFloat() {
        return this.tlRandom.nextFloat();
    }

    @Override
    public double nextDouble() {
        return this.tlRandom.nextDouble();
    }

    @Override
    public double nextGaussian() {
        return this.tlRandom.nextGaussian();
    }

    @Override
    public IntStream ints() {
        return this.tlRandom.ints();
    }

    @Override
    public IntStream ints(long streamSize) {
        return this.tlRandom.ints(streamSize);
    }

    @Override
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return this.tlRandom.ints(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return this.tlRandom.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs() {
        return this.tlRandom.longs();
    }

    @Override
    public LongStream longs(long streamSize) {
        return this.tlRandom.longs(streamSize);
    }

    @Override
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return this.tlRandom.longs(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return this.tlRandom.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles() {
        return this.tlRandom.doubles();
    }

    @Override
    public DoubleStream doubles(long streamSize) {
        return this.tlRandom.doubles(streamSize);
    }

    @Override
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return this.tlRandom.doubles(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return this.tlRandom.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }
}
