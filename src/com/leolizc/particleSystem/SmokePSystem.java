package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class SmokePSystem extends ParticleSystem {

    protected PVector wind;

    public SmokePSystem(PApplet p, float x, float y) {
        super(p, new PVector(x, y));
        wind = new PVector(0, 0);
    }

    @Override
    public void run() {
        super.run();
        applyForce(wind);
    }

    @Override
    public void addParticle() {
        Particle particle = new SmokeParticle(p, position);
        particles.add(particle);
    }

    public PVector getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = new PVector(wind, 0);
    }
}
