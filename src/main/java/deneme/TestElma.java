package deneme;

import java.util.Objects;

public class TestElma {
    public TestElma(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String field1;
    public String field2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Elma elma = (Elma) o;
        return Objects.equals(field1, elma.field1) && Objects.equals(field2, elma.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
    }
}
