package pl.wpe.swaggerApiTestClient.model;

import java.util.List;
import java.util.Objects;

public class DokumentDto {
    private int status;
    private List<Dokument> dokumenty;

    public DokumentDto() {
    }

    @Override
    public String toString() {
        return "DokumentDto{" +
                "status=" + status +
                ", dokumenty=" + dokumenty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DokumentDto)) return false;
        DokumentDto that = (DokumentDto) o;
        return getStatus() == that.getStatus() &&
                Objects.equals(getDokumenty(), that.getDokumenty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getDokumenty());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Dokument> getDokumenty() {
        return dokumenty;
    }

    public void setDokumenty(List<Dokument> dokumenty) {
        this.dokumenty = dokumenty;
    }
}
