package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class SmokeParticle extends Particle {

    PImage texture;

    public SmokeParticle(PApplet p, PVector position) {
        super(p, position);

        // set 0 acceleration
        acceleration.mult(0);

        // set a random velocity
        velocity.set(p.randomGaussian() * 0.2f, p.randomGaussian() * 0.09f - 1);

        // generate a random texture using perlin noise 2D
        texture = p.createImage(40, 40, PApplet.ARGB);

        texture.loadPixels();
        // use a random offset to generate a different texture
        float scale = 0.08f;
        float offset = p.random(1000);
        for (int i = 0; i < texture.pixels.length; i++) {
            int x = i % texture.width;
            int y = i / texture.width;
            float n = p.noise(x * scale + offset, y * scale + offset);

            // distance from the center
            float d = PApplet.dist(x, y, texture.width / 2f, texture.height / 2f);

            //alpha depends on the distance from the center and the noise value
            float alpha = PApplet.map(d, 0, texture.width / 2f, 220, 0) * n;

            // set the pixel color
            float c = PApplet.map(n, 0, 1, 200, 100);
            texture.pixels[i] = p.color(c, alpha);
        }
        texture.updatePixels();
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
            // use the texture to draw the particle
            canvas.tint(255, lifeSpan);

            //scale the texture
            canvas.pushMatrix();
            canvas.translate(position.x, position.y);
            canvas.scale(PApplet.map(lifeSpan, 0, 255, 2, 1));
            canvas.image(texture, 0, 0);
            //canvas.ellipse(position.x, position.y, 10, 10);
            canvas.popMatrix();
        }
    }

    @Override
    public SmokeParticle copy() {
        return new SmokeParticle(canvas, position.copy());
    }
}
