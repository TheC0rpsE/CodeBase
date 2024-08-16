import java.util.List;

public class Bibliotheque {
    private LivreDAOimpl LivreDAO;

    // Constructeur
    Bibliotheque() {
        LivreDAO = new LivreDAOimpl();
        }

    public void ajouterLivre(Livre livre){
        LivreDAO.ajouterLivre(livre);
    }   

    public void supprimerLivre(int id ){
        LivreDAO.supprimerLivre(id);
    }

    public void modifierLivre(Livre livre){
        LivreDAO.modifierLivre(livre);
    }

    public Livre getLivreById(int id){
        return LivreDAO.getLivreById(id);
    }

    public List<Livre> getTousLesLivres(){
       return LivreDAO.getTousLesLivres();
    }
    

}
