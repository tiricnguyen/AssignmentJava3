/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import java.util.List;
import model.DaoTao;

public interface ServiceDaoTao {

    List<DaoTao> getAll();

    List<DaoTao> add(List<DaoTao> list, DaoTao dt);

    List<DaoTao> update(List<DaoTao> list, DaoTao dt, String id);

    List<DaoTao> delete(List<DaoTao> list, String ma);

    List<DaoTao> find(List<DaoTao> list, String ma);

    List<DaoTao> search(String name, String id);

   
}
