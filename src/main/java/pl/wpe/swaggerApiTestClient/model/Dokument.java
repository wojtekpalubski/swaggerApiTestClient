package pl.wpe.swaggerApiTestClient.model;

import java.util.Objects;

public class Dokument {
    private Long id;
    private DanePersonalne danePersonalne;
    private Adres adresZamieszkania;
    private Adres adresKorespondencyjny;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dokument)) return false;
        Dokument dokument = (Dokument) o;
        return Objects.equals(getId(), dokument.getId()) &&
                Objects.equals(getDanePersonalne(), dokument.getDanePersonalne()) &&
                Objects.equals(getAdresZamieszkania(), dokument.getAdresZamieszkania()) &&
                Objects.equals(getAdresKorespondencyjny(), dokument.getAdresKorespondencyjny());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDanePersonalne(), getAdresZamieszkania(), getAdresKorespondencyjny());
    }

    @Override
    public String toString() {
        return "Dokument{" +
                "id=" + id +
                ", danePersonalne=" + danePersonalne +
                ", adresZamieszkania=" + adresZamieszkania +
                ", adresKorespondencyjny=" + adresKorespondencyjny +
                '}';
    }

    public Adres getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(Adres adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }

    public Adres getAdresKorespondencyjny() {
        return adresKorespondencyjny;
    }

    public void setAdresKorespondencyjny(Adres adresKorespondencyjny) {
        this.adresKorespondencyjny = adresKorespondencyjny;
    }

    public Dokument(Long id, DanePersonalne danePersonalne, Adres adresZamieszkania, Adres adresKorespondencyjny) {
        this.id = id;
        this.danePersonalne = danePersonalne;
        this.adresZamieszkania = adresZamieszkania;
        this.adresKorespondencyjny = adresKorespondencyjny;
    }

    public Dokument() {
    }

    public Dokument(Long id, DanePersonalne danePersonalne) {
        this.id = id;
        this.danePersonalne = danePersonalne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DanePersonalne getDanePersonalne() {
        return danePersonalne;
    }

    public void setDanePersonalne(DanePersonalne danePersonalne) {
        this.danePersonalne = danePersonalne;
    }

}
