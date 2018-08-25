package pl.wpe.swaggerApiTestClient.model;

import java.util.Objects;

public class Adres {
    private String miasto;
    private String ulica;

    public Adres() {
    }

    public Adres(String miasto, String ulica) {
        this.miasto = miasto;
        this.ulica = ulica;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adres)) return false;
        Adres adres = (Adres) o;
        return Objects.equals(getMiasto(), adres.getMiasto()) &&
                Objects.equals(getUlica(), adres.getUlica());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMiasto(), getUlica());
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
}
