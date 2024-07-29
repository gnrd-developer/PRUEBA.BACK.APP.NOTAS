import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;


public class ProfileDAO {

    public boolean crearProfile(Profile profile)
    {
        boolean resultado = false;
        try {
            Connection conn=Conexion.getConexion();
            String query="INSERT into postgres.public.profile (usuario_id, mail, name, country_id, region, commune, phone_prefix_id, phone, photo) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, profile.getUsuario_id());
            ps.setString(2, profile.getMail());
            ps.setString(3, profile.getName());
            ps.setInt(4, profile.getCountry_id());
            ps.setString(5, profile.getRegion());
            ps.setString(6, profile.getCommune());
            ps.setInt(7, profile.getPhone_prefix_id());
            ps.setInt(8, profile.getPhone());
            ps.setString(9, profile.getPhoto());
            resultado=ps.executeUpdate()==1;
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resultado;
    }    
    
    public Profile mostrar()
    {
        Profile profile=null;
        try
        {
            Connection conn = Conexion.getConexion();
            String consulta = "SELECT * FROM postgres.public.profile WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(consulta);
            int usuario_id = 1;            
            preparedStatement.setInt(1, usuario_id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
                profile= new Profile(rs.getInt(1),rs.getInt(2),rs.getString(3),
                rs.getString(4),rs.getInt(5),rs.getString(6), rs.getString(7),
                rs.getInt(8),rs.getInt(9),rs.getString(10));
                
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profile;
    }

    public Boolean Modificar(Profile profile)
    {
        boolean resultado = false;
        try {
            Connection conn = Conexion.getConexion();
            String consulta_2 = "UPDATE postgres.public.profile SET mail=?, name=?, country_id=?, region=?, commune=?, phone_prefix_id=?, phone=?, photo=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(consulta_2);
            ps.setString(1, profile.getMail());
            ps.setString(2, profile.getName());
            ps.setInt(3, profile.getCountry_id());
            ps.setString(4, profile.getRegion());
            ps.setString(5, profile.getCommune());
            ps.setInt(6, profile.getPhone_prefix_id());
            ps.setInt(7, profile.getPhone());
            ps.setString(8, profile.getPhoto());
            ps.setInt(9, profile.getId());
            resultado=ps.executeUpdate()==1;
            ps.close();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(null);
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(null);
        }
        return resultado;

    }

    public boolean deleteProfile()
    {
        boolean resultado=false;
        try {
            Connection conn=Conexion.getConexion();
            String consulta_3="DELETE FROM postgres.public.profile WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(consulta_3);
            int id_profile = 1;
            ps.setInt(1, id_profile);
            resultado=ps.executeUpdate()==1;
            ps.close();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(null);
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(null);
        }
        return resultado;
    }
        
}