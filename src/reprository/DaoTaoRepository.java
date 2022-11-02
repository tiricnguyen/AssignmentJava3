/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package reprository;

import model.DaoTao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DaoTaoRepository {

    List<DaoTao> listDt = new ArrayList<>();

    public List<DaoTao> getAll() {
        try {
            String query = "select * from daoTao";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            listDt.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String sex = rs.getString(4);
                String date = rs.getString(5);
                String address = rs.getString(6);
                String note = rs.getString(7);
                listDt.add(new DaoTao(id, name, phone, sex, date, address, note));

            }
            rs.close();
            ps.close();
            con.close();
            return listDt;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int add(DaoTao dt) {
        try {
            String query = "insert into daoTao values(?,?,?,?,?,?,?)";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, dt.getId());
            ps.setString(2, dt.getName());
            ps.setString(3, dt.getPhone());
            ps.setString(4, dt.getSex());
            ps.setString(5, dt.getDateOfBirth());
            ps.setString(6, dt.getAddress());
            ps.setString(7, dt.getNote());

            String query2 = "insert into GiangVien(student_id) values(?)";

            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1, dt.getId());

            if (ps.executeUpdate() > 0 && ps2.executeUpdate() > 0) {
                return 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public int update(DaoTao dt, String id) {
        try {
            String sql = "update daoTao set name=? , phone=? , sex=? , dateOfBirth=? , address=? , note=? where student_id=?";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dt.getName());
            ps.setString(2, dt.getPhone());
            ps.setString(3, dt.getSex());
            ps.setString(4, dt.getDateOfBirth());
            ps.setString(5, dt.getAddress());
            ps.setString(6, dt.getNote());
            ps.setString(7, id);

            if (ps.executeUpdate() > 0) {
                return 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public int delete(String ma) {
        try {
            String sql = "delete from GiangVien where student_id = ? delete from daoTao where student_id = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ma);
            ps.setString(2, ma);

            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public int find(String ma) {
        try {
            String sql = "select * from daoTao where student_id = ?";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ma);

            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public List<DaoTao> search(String name, String id) {
        try {
            String sql = "select * from DaoTao where name like ? or student_id like ? ";
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + id + "%");

            ResultSet rs = ps.executeQuery();
            listDt.clear();
            while (rs.next()) {
                listDt.add(new DaoTao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
            ps.close();
            con.close();
            return listDt;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
