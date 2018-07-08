package pl.wpe.swaggerApiTestClient;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wpe.swaggerApiTestClient.service.SlownikAService;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@RunWith(SpringRunner.class)
public class SlownikAServiceWiremockTest {
    @InjectMocks
    SlownikAService slownikAService;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort());

    @Test
    public void pobierzSlownik_wiremoct_test1(){
//        Mockito.when(slownikAService.pobierzSlownik())
//                .thenReturn(mockSlownikA());

//        stubFor(get(urlEqualTo("http://localhost:8081/api/v1/slownik/A"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("[{\"id\":1,\"nazwa\":\"A1\",\"opis\":\"Pozycja A1\"},{\"id\":2,\"nazwa\":\"A2\",\"opis\":\"Pozycja A2\"}]")));
//        System.out.println(slownikAService.zliczSlownik());
    }
}
