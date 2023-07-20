package com.leolizc.particleSystem;

import processing.core.PApplet;
import processing.core.PVector;

public class CustomColorParticle extends Particle{
    public CustomColorParticle(PApplet p, PVector position) {
        super(p, position);
    }

    @Override
    public void render() {

    }

    @Override
    public Particle copy() {
        return null;
    }
}
