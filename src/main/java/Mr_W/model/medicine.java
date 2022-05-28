package Mr_W.model;
import Mr_W.model.drug;

public class medicine {
    String id;
    drug drug;
    int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public drug getDrug() {
        return drug;
    }

    public void setDrug(drug drug) {
        this.drug = drug;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
