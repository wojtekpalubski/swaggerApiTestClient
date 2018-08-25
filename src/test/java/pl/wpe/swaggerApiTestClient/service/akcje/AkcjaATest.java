package pl.wpe.swaggerApiTestClient.service.akcje;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;
import pl.wpe.swaggerApiTestClient.service.slowniki.SlownikAService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AkcjaATest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void operacja_test1() {
        String teskst = "tekst";
        AkcjaA am = Mockito.mock(AkcjaA.class);
        when(am.odwroc(anyString())).thenReturn("R" + teskst);
        AkcjaA a = AkcjaA.valueOf(teskst);
        assertEquals("R" + teskst + teskst, a.operacja(teskst));
    }

    @Test
    public void wykonaj_test1() throws IOException {
        String kod = "nazwa1";

        AkcjaA akcjaA = AkcjaA.valueOf(kod);
        SlownikAService sa = mock(SlownikAService.class);
        when(sa.getSlownikA()).thenReturn(genSlownikAJson());
//        when(sa.getSlownikA()).thenReturn(genSlownikA());

        akcjaA.setSlownikAService(sa);

        String res = akcjaA.wykonaj();
        assertNotNull(res);
        assertThat(res, is(String.class));
        assertThat(res, is(kod));

    }

    private List<SlownikAItem> genSlownikA() throws IOException {
        List<SlownikAItem> slownik = new ArrayList<>();
        slownik.add(new SlownikAItem(1L, "nazwa1", "opis1"));
        slownik.add(new SlownikAItem(2L, "nazwa2", "opis2"));
//        slownik.addAll(genSlownikAJson());
        return slownik;
    }

    private List<SlownikAItem> genSlownikAJson() throws IOException {
        List<SlownikAItem> slownik = new ArrayList<>();

        ObjectMapper om = new ObjectMapper();
//        slownik=om.readValue(SlownikAJsonText,ArrayList.class);
        slownik=om.readValue(SlownikAJsonText,om.getTypeFactory().constructCollectionType(
                List.class, SlownikAItem.class));
        return slownik;
    }
    String SlownikAJsonText="[{\"id\":1,\"nazwa\":\"nazwa1\",\"opis\":\"opis1\"},{\"id\":2,\"nazwa\":\"nazwa2\",\"opis\":\"opis2\"}]";
}