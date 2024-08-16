import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LivreDAOimpl implements LivreDAO {
    
    private Connection ConnexionDB() {
        try {
            return DriverManager.getConnection("jdbc:mariadb://" + url, user, mdp);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void ajouterLivre(Livre livre) {
        Connection con = ConnexionDB();
        try {
            String query = "INSERT INTO Livres (titre, auteur, annee_publication, disponible) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(2, livre.getTitre());
            pstmt.setString(3, livre.getAuteur());
            pstmt.setInt(4, livre.getAnnee_publication());
            pstmt.setBoolean(5, livre.isDisponible());
            pstmt.executeUpdate();
            System.out.println("Ajout du livre " + livre.getTitre() +" validé.");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public Livre getLivreById(int id) {
        Connection con = ConnexionDB();
        Livre livre = null;
        try {
            String query = "SELECT * FROM Livres WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                livre = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"), rs.getInt("annee_publication"), rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return livre;
    }

    @Override
    public List<Livre> getTousLesLivres() {
        Connection con = ConnexionDB();
        List<Livre> listeLivres = new ArrayList<>();
        try {
            String query = "SELECT * FROM Livres";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Livre livre = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"), rs.getInt("annee_publication"), rs.getBoolean("disponible"));
                listeLivres.add(livre);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return listeLivres;
    }

    @Override
    public void modifierLivre(Livre livre) {
        Connection con = ConnexionDB();
        try {
            String query = "UPDATE Livres SET titre = ?, auteur = ?, annee_publication = ?, disponible = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, livre.getTitre());
            pstmt.setString(2, livre.getAuteur());
            pstmt.setInt(3, livre.getAnnee_publication());
            pstmt.setBoolean(4, livre.isDisponible());
            pstmt.setInt(5, livre.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void supprimerLivre(int id) {
        Connection con = ConnexionDB();
        try {
            String query = "DELETE FROM Livres WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
