/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package serviec.impl;

import java.util.List;
import model.DaoTao;
import reprository.DaoTaoRepository;

/**
 *
 * @author Admin
 */
public class DaoTaoRepositoryImpl implements service.ServiceDaoTao {

    private DaoTaoRepository repository = new DaoTaoRepository();

    @Override
    public List<DaoTao> getAll() {
        return repository.getAll();
    }

    @Override
    public List<DaoTao> add(List<DaoTao> list, DaoTao dt) {
        int check = repository.add(dt);
        list = repository.getAll();
        return list;
    }

    @Override
    public List<DaoTao> delete(List<DaoTao> list, String ma) {
        int check = repository.delete(ma);
        list = getAll();
        return list;
    }

    @Override
    public List<DaoTao> update(List<DaoTao> list, DaoTao dt, String id) {

        int check = repository.update(dt, id);
        list = repository.getAll();
        return list;
    }

    @Override
    public List<DaoTao> find(List<DaoTao> list, String ma) {
        int check = repository.find(ma);
        list = getAll();
        return list;
    }

    @Override
    public List<DaoTao> search(String name, String id) {
        return repository.search(name, id);

    }

}
