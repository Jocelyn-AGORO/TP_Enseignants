package champollion;

public class ServicePrevu {
    private Enseignant enseignant;
	private UE ue;

    private int volumeCM;

    private int volumeTD;

    private int volumeTP;
    public ServicePrevu(Enseignant enseignant, UE ue, int volumeCM, int volumeTD, int volumeTP) {
        this.enseignant = enseignant;
        this.ue = ue;
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }
    public int getTotalFor(TypeIntervention type) {
        int total = 0;
        switch (type){
            case CM:
                total = getVolumeCM();
            break;
            case TD:
                total = getVolumeTD();
            break;
            case TP:
                total = getVolumeTP();
            break;
        }
        return total;
    }
}
