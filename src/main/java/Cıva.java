import java.util.Objects;

public class Cıva {
    public String c;
    public String d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cıva cıva = (Cıva) o;
        return c.equals(cıva.c) && d.equals(cıva.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, d);
    }

    public Cıva(String c, String d) {
        this.c = c;
        this.d = d;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }


}
