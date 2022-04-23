package deneme;

import java.util.ArrayList;
import java.util.List;

public class Data {

    List<Elma> elmas = new ArrayList<>();
    List<Armut> armuts = new ArrayList<>();

    public List<Elma> getElmas() {
        return elmas;
    }

    public void setElmas(List<Elma> elmas) {
        this.elmas = elmas;
    }

    public List<Armut> getArmuts() {
        return armuts;
    }

    public void setArmuts(List<Armut> armuts) {
        this.armuts = armuts;
    }
}
