package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Particle {
    float lifeSpan;
    PVector position, velocity, acceleration;

    public Particle(PVector position) {
        this.position = position.copy();
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(0, 0.05f);
        this.lifeSpan = 255;
    }

    public abstract void render(PApplet p);

    public void updatePhysics() {
        velocity.add(acceleration);
        position.add(velocity);
        lifeSpan -= 2.0;
    }

    public boolean isDead() {
        return lifeSpan < 0.0;
    }

    public void applyForce(PVector force) {
        acceleration.add(force);
    }

    public abstract Particle copy();
}
