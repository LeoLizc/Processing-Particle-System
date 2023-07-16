package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class TemplatedParticleSystem extends ParticleSystem {

    Particle template;

    public TemplatedParticleSystem(PApplet p, float x, float y) {
        super(p, new PVector(x, y));
        template = new SimpleParticle(p, position);
    }

    public TemplatedParticleSystem(PApplet p, float x, float y, Particle template) {
        super(p, new PVector(x, y));
        this.template = template;
    }

    public void setTemplate(Particle template) {
        this.template = template;
        this.template.position = position.copy();
    }

    @Override
    public void addParticle() {
        Particle particle = template.copy();
        particle.velocity.set(p.random(-1, 1), p.random(-2, 0));
        particles.add(particle);
    }
}
