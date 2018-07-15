package pl.wpe.swaggerApiTestClient;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.HttpResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import pl.wpe.swaggerApiTestClient.service.slowniki.SlownikAService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SwaggerApiTestClientApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SlownikAServiceWiremockTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8081));
//    SlownikAService slownikAService=new SlownikAService();
    @InjectMocks
    SlownikAService slownikAService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void pobierzSlownik_wiremoct_test1() throws IOException {
//        Mockito.when(slownikAService.pobierzSlownik())
//                .thenReturn(null);

        stubFor(get(urlEqualTo("/api/v1/slownik/A"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"id\":1,\"nazwa\":\"A1\",\"opis\":\"Pozycja A1\"},{\"id\":2,\"nazwa\":\"A2\",\"opis\":\"Pozycja A2\"}]")
                )
        );


        System.out.println("###################" + slownikAService.pobierzSlownik());
        System.out.println("###################" + slownikAService.zliczSlownik());

//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet request = new HttpGet("http://localhost:8080//api/v1/slownik/A");
//        HttpResponse httpResponse = httpClient.execute(request);
//        String stringResponse = convertHttpResponseToString(httpResponse);
//        System.out.println("###################"+stringResponse);
    }

    private String convertHttpResponseToString(HttpResponse httpResponse) throws IOException {
        InputStream inputStream = httpResponse.getEntity().getContent();
        return convertInputStreamToString(inputStream);
    }

    private String convertInputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String string = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return string;
    }
}
