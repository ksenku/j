package ru.ku.jungle.model;

public class Snake {
    private int health = 100;
    private int energy = 100;
    private final double preyEnergyFactor = 3.1;

    public void setHealth (int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getPreyEnergyFactor() {
        return this.preyEnergyFactor;
    }
}
