/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package model;

/**
 *
 * @author Admin
 */
public class GiangVien {

    private String id, name;
    private float en, it, pe, avg;

    public GiangVien() {
    }

    public GiangVien(String id, String name, float en, float it, float pe, float avg) {
        this.id = id;
        this.name = name;
        this.en = en;
        this.it = it;
        this.pe = pe;
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getEn() {
        return en;
    }

    public void setEn(float en) {
        this.en = en;
    }

    public float getIt() {
        return it;
    }

    public void setIt(float it) {
        this.it = it;
    }

    public float getPe() {
        return pe;
    }

    public void setPe(float pe) {
        this.pe = pe;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

}
