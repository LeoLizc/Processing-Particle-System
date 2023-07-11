package com.leolizc.particleSystem;

import processing.core.PVector;

import java.util.LinkedList;
import java.util.ListIterator;

public abstract class ParticleSystem {
    PVector position;
    LinkedList<Particle> particles;

    public ParticleSystem(PVector position){
        this.position = position.copy();
        this.particles = new LinkedList<Particle>();
    }

    public abstract void addParticle();

    public void run(){
        ListIterator<Particle> iterator = particles.listIterator();
        while(iterator.hasNext()){
            Particle particle = iterator.next();
            particle.render();
            particle.updatePhysics();
            if(particle.isDead()){
                iterator.remove();
            }
        }
    }

    public void applyForce(PVector force){
        for(int i = 0; i < particles.size(); i++){
            particles.get(i).applyForce(force);
        }
    }
}
