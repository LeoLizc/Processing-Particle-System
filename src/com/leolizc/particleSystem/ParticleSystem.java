package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.LinkedList;
import java.util.ListIterator;

public abstract class ParticleSystem {
    PVector position;
    LinkedList<Particle> particles;
    PApplet p;

    public ParticleSystem(PApplet p, PVector position) {
        this.p = p;
        this.position = position.copy();
        this.particles = new LinkedList<>();
    }

    public abstract void addParticle();

    public void run() {
        ListIterator<Particle> iterator = particles.listIterator();
        while (iterator.hasNext()) {
            Particle particle = iterator.next();
            particle.render(p);
            particle.updatePhysics();
            if (particle.isDead()) {
                iterator.remove();
            }
        }
    }

    public void applyForce(PVector force) {
        for (Particle particle : particles) {
            particle.applyForce(force);
        }
    }
}
