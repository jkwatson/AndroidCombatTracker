package com.sleazyweasel;

import com.sleazyweasel.data.Combatant;
import com.sleazyweasel.data.ObjectRoot;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ObjectRootTest {
    
    @Test
    public void testNextInitiative_empty() throws Exception {
        ObjectRoot testClass = new ObjectRoot();
        testClass.nextInitiative();
        assertEquals(0, testClass.getCombatants().size());
    }

    @Test
    public void testNextInitiative() throws Exception {
        ObjectRoot testClass = new ObjectRoot();
        testClass.addCombatant(new Combatant("John", 2, 3, 4, 5, 6, 7));
        testClass.addCombatant(new Combatant("Heidi", 2, 3, 4, 5, 6, 7));
        testClass.nextInitiative();
        assertEquals(2, testClass.getCombatants().size());
        assertEquals("John", testClass.getCombatants().get(1).getName());
        assertEquals("Heidi", testClass.getCombatants().get(0).getName());
    }
}
