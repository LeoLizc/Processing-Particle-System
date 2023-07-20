package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class CustomColorParticle extends Particle {

    int color;

    public CustomColorParticle(PApplet p, PVector position) {
        super(p, position);
        color = p.color(255, 0, 0);
    }

    public CustomColorParticle(PApplet p, PVector position, int color) {
        super(p, position);
        this.color = color;
    }

    @Override
    public void render() {
        canvas.noStroke();
        canvas.fill(color, lifeSpan);

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
        return new CustomColorParticle(canvas, position, color);
    }
}
