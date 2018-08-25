package pl.wpe.swaggerApiTestClient.service;

import pl.wpe.swaggerApiTestClient.model.Dokument;
import pl.wpe.swaggerApiTestClient.model.DokumentDto;

import java.util.Collections;
import java.util.List;

public class SkladnicaDokumentow {

    public Dokument znajdzDokument(Long id){
        return getDokumenty().stream()
                .filter(d->d.getId().equals(id))
                .findFirst().orElse(null);
    }
    public Dokument odbierzDokument(Long id){
        return pobierzDokumenty().getDokumenty().stream()
                .filter(d->d.getId().equals(id))
                .findFirst().orElse(null);
    }

    List<Dokument> getDokumenty(){
        return Collections.emptyList();
    }

    DokumentDto pobierzDokumenty(){
        return null;
    }
}
