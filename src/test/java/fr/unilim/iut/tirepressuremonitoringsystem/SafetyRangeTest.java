package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SafetyRangeTest {
	@Test
	void doit_renvoyer_true_avec_une_valeur_dans_un_intervalle(){
		SafetyRange safetyRange = new SafetyRange(10,35);
		assertTrue(safetyRange.contains(15));
		assertFalse(safetyRange.contains(140));
	}
	@Test
	void doit_renvoyer_false_avec_une_valeur_externe_a_un_intervalle(){
		SafetyRange safetyRange = new SafetyRange(10,35);
		assertTrue(safetyRange.doesNotContain(150));
		assertFalse(safetyRange.doesNotContain(14));
	}
}
