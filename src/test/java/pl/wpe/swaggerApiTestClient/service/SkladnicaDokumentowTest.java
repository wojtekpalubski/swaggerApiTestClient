package pl.wpe.swaggerApiTestClient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.wpe.swaggerApiTestClient.model.DanePersonalne;
import pl.wpe.swaggerApiTestClient.model.Dokument;
import pl.wpe.swaggerApiTestClient.model.DokumentDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SkladnicaDokumentowTest {

    @Test
    public void znajdzDokument_test1() throws IOException {
        SkladnicaDokumentow skladnicaDokumentow=spy(SkladnicaDokumentow.class);

        when(skladnicaDokumentow.getDokumenty()).thenReturn(genDokumentyJson());

        Dokument znaleziony=skladnicaDokumentow.znajdzDokument(1L);
        assertNotNull(znaleziony);
        assertThat(znaleziony.getDanePersonalne().getImie(),is("imie1"));
    }
    @Test
    public void odbierzDokument_test1() throws IOException {
        SkladnicaDokumentow skladnicaDokumentow=spy(SkladnicaDokumentow.class);

        when(skladnicaDokumentow.pobierzDokumenty()).thenReturn(genDokumentyDtoJson());

        Dokument znaleziony=skladnicaDokumentow.odbierzDokument(1L);
        assertNotNull(znaleziony);
        assertThat(znaleziony.getDanePersonalne().getImie(),is("imie1"));
    }
    @Test
    public void odbierzDokument_test2_miasto() throws IOException {
        SkladnicaDokumentow skladnicaDokumentow=spy(SkladnicaDokumentow.class);

        when(skladnicaDokumentow.pobierzDokumenty()).thenReturn(genDokumentyDtoJson());

        Dokument znaleziony=skladnicaDokumentow.odbierzDokument(1L);
        assertNotNull("Nie znaleziono dokumentu",znaleziony);
        assertNotNull("Nie znaleziono adresu korespondencyjnego",znaleziony.getAdresKorespondencyjny());
        assertThat(znaleziony.getDanePersonalne().getImie(),is("imie1"));
        assertThat(znaleziony.getAdresKorespondencyjny().getMiasto(),is("Lublin"));
    }
    @Test
    public void odbierzDokument_test3_ulica() throws IOException {
        SkladnicaDokumentow skladnicaDokumentow=spy(SkladnicaDokumentow.class);

        when(skladnicaDokumentow.pobierzDokumenty()).thenReturn(genDokumentyDtoJson());

        Dokument znaleziony=skladnicaDokumentow.odbierzDokument(2L);
        assertNotNull("Nie znaleziono dokumentu",znaleziony);
        assertNotNull("Nie znaleziono adresu zamieszkania",znaleziony.getAdresZamieszkania());
        assertThat(znaleziony.getDanePersonalne().getImie(),is("imie2"));
        assertThat(znaleziony.getAdresZamieszkania().getUlica(),is("Botaniczna"));
    }

    @Deprecated
    private List<Dokument> genDokumenty(){
        List<Dokument> dokumenty=new ArrayList<>();
        dokumenty.add(new Dokument(1L, new DanePersonalne("imie1","nazwisko1")));
        dokumenty.add(new Dokument(2L, new DanePersonalne("imie2","nazwisko2")));
        return dokumenty;
    }
    private List<Dokument> genDokumentyJson() throws IOException {
        List<Dokument> dokumenty=new ArrayList<>();
        ObjectMapper om = new ObjectMapper();
        dokumenty=om.readValue(dokumentyJson,om.getTypeFactory().constructCollectionType(
                List.class, Dokument.class));
        return dokumenty;
    }
    private DokumentDto genDokumentyDtoJson() throws IOException {
        DokumentDto dokumenty=new DokumentDto();
        ObjectMapper om = new ObjectMapper();
        dokumenty=om.readValue(dokumentyDtoJson,DokumentDto.class);
        return dokumenty;
    }

    String dokumentyJson="[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"danePersonalne\": {\n" +
            "      \"imie\": \"imie1\",\n" +
            "      \"nazwisko\": \"nazwisko2\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"danePersonalne\": {\n" +
            "      \"imie\": \"imie2\",\n" +
            "      \"nazwisko\": \"nazwisko2\"\n" +
            "    }\n" +
            "  }\n" +
            "]";

    String dokumentyDtoJson="{\n" +
            "  \"status\": 0,\n" +
            "  \"dokumenty\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"danePersonalne\": {\n" +
            "        \"imie\": \"imie1\",\n" +
            "        \"nazwisko\": \"nazwisko2\"\n" +
            "      },\n" +
            "      \"adresZamieszkania\":null,\n" +
            "      \"adresKorespondencyjny\":{\n" +
            "        \"miasto\":\"Lublin\",\n" +
            "        \"ulica\":\"Herbera\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"danePersonalne\": {\n" +
            "        \"imie\": \"imie2\",\n" +
            "        \"nazwisko\": \"nazwisko2\"\n" +
            "      },\n" +
            "      \"adresZamieszkania\":{\n" +
            "        \"ulica\":\"Botaniczna\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}