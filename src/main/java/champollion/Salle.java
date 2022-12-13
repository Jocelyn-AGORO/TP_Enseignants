package champollion;

import java.util.ArrayList;
import java.util.List;

public class Salle {

    List<Intervention> occupations;
    private String intitule;

    private int capacite;

    public Salle(String intitule, int capacite) {
        this.intitule =  intitule;
        this.capacite = capacite;
        this.occupations =  new ArrayList<>();
    }

    public String getIntitule() {
        return intitule;
    }

    public int getCapacite() {
        return capacite;
    }

}
