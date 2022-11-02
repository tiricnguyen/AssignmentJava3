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

import model.GiangVien;

/**
 *
 * @author Admin
 */
public class GiangVienRepository {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    List<GiangVien> listGv = new ArrayList<>();

    public List<GiangVien> getAll() {
        try {
            String sql = "select daoTao.student_id , daoTao.name , en,it,java,  round((AVG(en+it+java)/3),2) as DiemTB from daoTao join GiangVien on daoTao.student_id = GiangVien.student_id group by daoTao.student_id , daoTao.name , en,it,java";
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            listGv.clear();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                float en = rs.getFloat(3);
                float ja = rs.getFloat(4);
                float sq = rs.getFloat(5);
                float avg = rs.getFloat(6);
                listGv.add(new GiangVien(id, name, en, ja, sq, avg));
            }
            rs.close();
            ps.close();
            con.close();
            return listGv;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public int update(GiangVien gv, String id) {
        try {
            String sql = "update GiangVien set en=?,it=?,java=? where student_id=?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);

            ps.setFloat(1, gv.getEn());
            ps.setFloat(2, gv.getIt());
            ps.setFloat(3, gv.getPe());

            ps.setString(4, id);

            if (ps.executeUpdate() > 0) {
                return 1;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public List<GiangVien> sortDiemTB() {
        try {
            String sql = "select GiangVien.student_id, name ,en,it,java ,round((AVG(en+it+java)/3),2) as diemTB from GiangVien join DaoTao on GiangVien.student_id = DaoTao.student_id group by GiangVien.student_id,name,en,it,java order by diemTB asc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            listGv.clear();

            while (rs.next()) {

                listGv.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
            }
            rs.close();
            ps.close();
            con.close();
            return listGv;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<GiangVien> top3() {
        try {
            String sql = "select top 3 GiangVien.student_id, name ,en,it,java ,round((AVG(en+it+java)/3),2) as diemTB from GiangVien join DaoTao on GiangVien.student_id = DaoTao.student_id group by GiangVien.student_id,name,en,it,java order by diemTB desc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            listGv.clear();

            while (rs.next()) {
                listGv.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
            }
            rs.close();
            ps.close();
            con.close();
            return listGv;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
