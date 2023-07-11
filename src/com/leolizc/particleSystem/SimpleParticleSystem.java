package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class SimpleParticleSystem extends ParticleSystem {
    public SimpleParticleSystem(PApplet p, float x, float y) {
        super(p, new PVector(x, y));
    }

    @Override
    public void addParticle() {
        Particle particle = new SimpleParticle(position);
        particle.velocity.set(p.random(-1, 1), p.random(-2, 0));
        particles.add(particle);
    }
}
