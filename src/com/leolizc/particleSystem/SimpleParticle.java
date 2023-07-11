package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class SimpleParticle extends Particle {

    public SimpleParticle(PVector position) {
        super(position);
    }

    @Override
    public void render(PApplet p) {
        p.stroke(0, lifeSpan);
        p.fill(0, lifeSpan);
        // check if p is a 3D sketch
        if (p.g instanceof processing.opengl.PGraphics3D) {
            p.pushMatrix();
            p.translate(position.x, position.y, position.z);
            p.sphere(5);
            p.popMatrix();
        } else {
            p.ellipse(position.x, position.y, 10, 10);
        }
    }

    @Override
    public Particle copy() {
        return new SimpleParticle(position.copy());
    }
}
