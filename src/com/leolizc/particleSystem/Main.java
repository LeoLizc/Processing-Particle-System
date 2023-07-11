package com.leolizc.particleSystem;

import processing.core.PApplet;

public class Main extends PApplet {
    SimpleParticleSystem particleSystem;

    public static void main(String[] args) {
        PApplet.main("com.leolizc.particleSystem.Main");
    }

    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        particleSystem = new SimpleParticleSystem(this, width / 2f, height / 2f);
    }

    @Override
    public void draw() {
        background(255);

        particleSystem.addParticle();
        particleSystem.run();
    }
}
