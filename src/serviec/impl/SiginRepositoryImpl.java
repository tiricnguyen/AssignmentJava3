/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package serviec.impl;

import java.util.List;
import model.Sigin;
import reprository.SigInRepository;
import service.SeviceSigin;

/**
 *
 * @author Admin
 */
public class SiginRepositoryImpl implements SeviceSigin {

    private SigInRepository siginRpo = new SigInRepository();

    @Override
    public List<model.Sigin> getAll() {
        return siginRpo.getAll();
    }

    

   

}
