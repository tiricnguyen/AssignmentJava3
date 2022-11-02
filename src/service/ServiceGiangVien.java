/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import java.util.List;
import model.GiangVien;

public interface ServiceGiangVien {

    List<GiangVien> getAll();

    List<GiangVien> update(List<GiangVien> list, GiangVien gv, String id);

    List<GiangVien> sortDiemTB();

    List<GiangVien> top3();
}
