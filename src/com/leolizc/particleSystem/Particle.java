package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;

public abstract class Particle {
    float lifeSpan;
    PVector position;
    PVector velocity;
    PVector acceleration;
    PVector[] forces;//acceleration is an always applied force

    public Particle(PVector position) {
        this.position = position.copy();
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(0, 0.05f);
        this.lifeSpan = 255;
        this.forces = new PVector[10];
    }

    public abstract void render(PApplet p);

    public void applyForce(PVector force) {
        for (int i = 0; i < forces.length; i++) {
            if (forces[i] == null) {
                forces[i] = force.copy();
                return;
            }
        }
    }

    public void updatePhysics() {
        PVector acceleration = this.acceleration.copy();
        for (PVector force : forces) {
            if (force != null) {
                acceleration.add(force);
            }
        }
        velocity.add(acceleration);
        position.add(velocity);
        lifeSpan -= 2.0;
        // Remember that this.acceleration is an always applied force
        // so, we don't need to reset it
        Arrays.fill(forces, null);

    }

    public boolean isDead() {
        return lifeSpan < 0.0;
    }

    public abstract Particle copy();
}
