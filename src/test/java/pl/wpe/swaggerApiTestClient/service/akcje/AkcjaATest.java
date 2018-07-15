package pl.wpe.swaggerApiTestClient.service.akcje;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
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

}