package com.sleazyweasel.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectRoot implements Serializable{
    private List<Combatant> combatants = new ArrayList<Combatant>();

    public void addCombatant(Combatant combatant) {
        combatants.add(combatant);
    }

    public List<Combatant> getCombatants() {
        return new ArrayList<Combatant>(combatants);
    }

    public void nextInitiative() {
        if (combatants.size() > 0) {
            Combatant combatant = combatants.remove(0);
            combatants.add(combatant);
        }
    }
}
