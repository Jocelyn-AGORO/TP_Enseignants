package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testEstSousService() {
		untel.ajouteEnseignement(java, 50, 50, 50);
		untel.ajouteEnseignement(uml, 50, 50, 50);
		Enseignant unAutre = new Enseignant("autre", "autre@gmail.com");
		unAutre.ajouteEnseignement(java, 20, 10, 10);
		assertFalse(untel.enSousService());
		assertTrue(unAutre.enSousService());
	}

	@Test
	public void testResteAPlanifier(){
		untel.ajouteEnseignement(uml, 10, 20, 10);
		untel.ajouterIntervention(inter1CM);//realise 4 heures de CM de uml
		untel.ajouterIntervention(inter1TD);//realise 5 heures de TD de uml
		untel.ajouterIntervention(inter1TP);//realise 6 heures de TP de uml

		assertEquals(10-(4), untel.resteAPlanifier(uml, TypeIntervention.CM),
				"L'enseignant doit maintenant avoir 6 heures à planifier pour l'UE 'uml'");

		assertEquals(20-(5), untel.resteAPlanifier(uml, TypeIntervention.TD),
				"L'enseignant doit maintenant avoir 15 heures à planifier pour l'UE 'uml'");
		assertEquals(10-(6), untel.resteAPlanifier(uml, TypeIntervention.TP),
				"L'enseignant doit maintenant avoir 4 heures à planifier pour l'UE 'uml'");

	}

}
