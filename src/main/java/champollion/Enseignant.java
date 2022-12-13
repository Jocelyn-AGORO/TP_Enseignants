package champollion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static java.lang.Math.round;

public class Enseignant extends Personne {

    private List<ServicePrevu> ensignements;
    private List<Intervention> interventionsPlanifiees;
    public Enseignant(String nom, String email) {
        super(nom, email);
        this.ensignements = new ArrayList<>();
        this.interventionsPlanifiees = new ArrayList<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int totalHeures = 0;
        for(ServicePrevu service : ensignements) {
            totalHeures += (service.getVolumeCM()*1.5+ service.getVolumeTD()+ service.getVolumeTP()*0.75);
        }
        return round(totalHeures);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int totalHeureUe = 0;
        for(ServicePrevu service : ensignements) {
            if(service.getUe().equals(ue)) {
                totalHeureUe += (int) round(service.getVolumeCM()*1.5+ service.getVolumeTD()+ service.getVolumeTP()*0.75);
            }
        }
        return round(totalHeureUe);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        this.ensignements.add(new ServicePrevu(this, ue , volumeCM, volumeTD, volumeTP));
    }

    public boolean enSousService() {
        return heuresPrevues() < 192;
    }

    public void ajouterIntervention(Intervention inter) {
        this.interventionsPlanifiees.add(inter);
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int totalIntervention = 0;
        int totalPourType = 0;
        for(Intervention intervention : interventionsPlanifiees) {
            if (intervention.getMatiere().equals(ue) && intervention.getType() == type){
                totalIntervention += intervention.getDuree();
            }
        }
        for(ServicePrevu service: ensignements) {
            if(service.getUe().equals(ue)){
                totalPourType += service.getTotalFor(type);
            }
        }
        return (totalPourType - totalIntervention);
    }
}
