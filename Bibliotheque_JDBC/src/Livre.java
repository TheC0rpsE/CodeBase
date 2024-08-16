public class Livre {
    private int id;
    private String titre;
    private String auteur ;
    private int annee_publication;
    private boolean disponible;
    

    Livre(int id , String titre, String auteur, int annee, boolean disponible){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee_publication = annee;
        this.disponible = disponible;
    }


    Livre(){
        this.id = -1;
        this.titre = "";
        this.auteur = "";
        this.annee_publication = -1;
        this.disponible = false;
    }

    public void setAnnee_publication(int annee_publication) {
        this.annee_publication = annee_publication;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee_publication() {
        return annee_publication;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void afficheInfoLivre(){
        System.out.println("id : " + getId() + " | titre : " + getTitre() + " | auteur : " + getAuteur() + " | année de publication : " +  getAnnee_publication() + " | disponible : " + isDisponible());
    }
}
