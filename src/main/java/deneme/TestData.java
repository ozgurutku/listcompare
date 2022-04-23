package deneme;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestData {

    List<TestElma> elmas =new ArrayList<>();
    List<TestArmut> armuts = new ArrayList<>();

    public List<TestElma> getElmas() {
        return elmas;
    }

    public void setElmas(List<TestElma> elmas) {
        this.elmas = elmas;
    }

    public List<TestArmut> getArmuts() {
        return armuts;
    }

    public void setArmuts(List<TestArmut> armuts) {
        this.armuts = armuts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Data data = (Data) o;
        return Objects.equals(elmas, data.elmas) && Objects.equals(armuts, data.armuts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elmas, armuts);
    }
}
