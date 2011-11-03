package com.sleazyweasel.data;

import java.io.Serializable;

public class Combatant implements Serializable{
    private String name;
    private Integer armorClass;
    private Integer fortitude;
    private Integer reflex;
    private Integer will;
    private Integer maxHp;
    private Integer currentHp;

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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getFortitude() {
        return fortitude;
    }

    public void setFortitude(Integer fortitude) {
        this.fortitude = fortitude;
    }

    public Integer getReflex() {
        return reflex;
    }

    public void setReflex(Integer reflex) {
        this.reflex = reflex;
    }

    public Integer getWill() {
        return will;
    }

    public void setWill(Integer will) {
        this.will = will;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public Integer getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(Integer currentHp) {
        this.currentHp = currentHp;
    }
}
