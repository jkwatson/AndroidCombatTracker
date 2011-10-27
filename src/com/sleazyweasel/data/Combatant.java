package com.sleazyweasel.data;

import java.io.Serializable;

public class Combatant implements Serializable{
    private String name;
    private int armorClass;
    private int fortitude;
    private int reflex;
    private int will;
    private int maxHp;
    private int currentHp;

    public Combatant(String name, int armorClass, int fortitude, int reflex, int will, int maxHp, int currentHp) {
        this.name = name;
        this.armorClass = armorClass;
        this.fortitude = fortitude;
        this.reflex = reflex;
        this.will = will;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }

    public String getName() {
        return name;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getFortitude() {
        return fortitude;
    }

    public int getReflex() {
        return reflex;
    }

    public int getWill() {
        return will;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setName(String name) {
        this.name = name;
    }
}
