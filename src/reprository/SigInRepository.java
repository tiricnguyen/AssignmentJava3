/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package reprository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Sigin;

/**
 *
 * @author Admin
 */
public class SigInRepository {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    List<Sigin> listS = new ArrayList<>();

    public List<Sigin> getAll() {
        try {
            String sql = "select * from USERS";
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            listS.clear();
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String role = rs.getString(3);
              
                listS.add(new Sigin(user, pass, role));

            }
            return listS;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

 
}
