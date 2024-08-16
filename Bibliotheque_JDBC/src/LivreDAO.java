import java.util.List;

public interface LivreDAO {
    public void ajouterLivre(Livre livre);
    public void supprimerLivre(int id);
    public void modifierLivre(Livre livre);
    public Livre getLivreById(int id);
    public List<Livre> getTousLesLivres();
}
