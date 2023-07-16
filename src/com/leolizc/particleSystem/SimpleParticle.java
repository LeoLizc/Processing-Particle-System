package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class SimpleParticle extends Particle {

    public SimpleParticle(PApplet p, PVector position) {
        super(p, position);
    }

    @Override
    public void render() {
        canvas.stroke(0, lifeSpan);
        canvas.fill(0, lifeSpan);
        // check if canvas is a 3D sketch
        if (canvas.g instanceof processing.opengl.PGraphics3D) {
            canvas.pushMatrix();
            canvas.translate(position.x, position.y, position.z);
            canvas.sphere(5);
            canvas.popMatrix();
        } else {
            canvas.ellipse(position.x, position.y, 10, 10);
        }
    }

    @Override
    public Particle copy() {
        return new SimpleParticle(canvas, position.copy());
    }
}
