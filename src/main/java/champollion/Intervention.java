package champollion;

import java.time.LocalDate;

public class Intervention {
    private Enseignant intervenant;
    private UE matiere;

    private Salle lieu;
    private TypeIntervention type;
    private LocalDate debut;

    private int duree;

    private boolean annulee = false;

    private int heureDebut;

    public Intervention(Enseignant intervenant, UE matiere, TypeIntervention type, LocalDate debut, int duree, int heureDebut) {
        this.intervenant = intervenant;
        this.matiere = matiere;
        this.type = type;
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
    }

    public Enseignant getIntervenant() {
        return intervenant;
    }

    public UE getMatiere() {
        return matiere;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void annuler() {
        this.annulee = true;
    }

    public boolean estAnnulee() {
        return annulee;
    }

}
