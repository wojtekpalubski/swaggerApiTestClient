package pl.wpe.swaggerApiTestClient.model;

import java.util.Objects;

public class DanePersonalne {
    private String imie;
    private String nazwisko;
    private String nazwiskoRodowe;

    public DanePersonalne() {
    }

    public DanePersonalne(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "DanePersonalne{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nazwiskoRodowe='" + nazwiskoRodowe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DanePersonalne)) return false;
        DanePersonalne that = (DanePersonalne) o;
        return Objects.equals(getImie(), that.getImie()) &&
                Objects.equals(getNazwisko(), that.getNazwisko()) &&
                Objects.equals(getNazwiskoRodowe(), that.getNazwiskoRodowe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImie(), getNazwisko(), getNazwiskoRodowe());
    }

    public String getNazwiskoRodowe() {
        return nazwiskoRodowe;
    }

    public void setNazwiskoRodowe(String nazwiskoRodowe) {
        this.nazwiskoRodowe = nazwiskoRodowe;
    }
}
