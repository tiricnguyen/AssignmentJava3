/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package serviec.impl;

import java.util.List;
import model.GiangVien;
import reprository.GiangVienRepository;
import service.ServiceGiangVien;

public class GiangVienRepositoryImpl implements ServiceGiangVien {

    private GiangVienRepository gvRepository = new GiangVienRepository();

    @Override
    public List<GiangVien> getAll() {
        return gvRepository.getAll();
    }

    @Override
    public List<GiangVien> update(List<GiangVien> list, GiangVien gv ,String id) {
        int chek = gvRepository.update(gv,id);
        list = gvRepository.getAll();
        return list;
    }

    @Override
    public List<GiangVien> sortDiemTB() {
          return gvRepository.sortDiemTB();
    }

    @Override
    public List<GiangVien> top3() {
        return gvRepository.top3();
    }
}
