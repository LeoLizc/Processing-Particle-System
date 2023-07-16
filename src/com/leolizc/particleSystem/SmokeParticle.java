package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class SmokeParticle extends Particle {

    public SmokeParticle(PApplet p, PVector position) {
        super(p, position);

        // set 0 acceleration
        acceleration.mult(0);

        // set a random velocity
        velocity.set(p.randomGaussian() * 0.15f, p.randomGaussian() * 0.1f - 1);

    }

    @Override
    public void render() {
        canvas.noStroke();
        canvas.fill(230f, lifeSpan);

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
    public SmokeParticle copy() {
        return new SmokeParticle(canvas, position.copy());
    }
}
