package pl.wpe.swaggerApiTestClient.model;

import lombok.ToString;

@ToString
public class SlownikAItem {
    private Long id;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    private String nazwa;
    private String opis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SlownikAItem() {
    }

    public SlownikAItem(Long id, String nazwa, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
    }
}
