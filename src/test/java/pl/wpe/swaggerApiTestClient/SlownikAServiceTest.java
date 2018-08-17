package pl.wpe.swaggerApiTestClient;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;
import pl.wpe.swaggerApiTestClient.service.slowniki.SlownikAService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SlownikAServiceTest {

    @InjectMocks
    SlownikAService slownikAService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void pobierzSlownik_test(){
        Mockito.when(restTemplate.getForObject("http://localhost:8081/api/v1/slownik/A", List.class))
                .thenReturn(mockSlownikA());
        System.out.println(slownikAService.pobierzSlownik());
    }

    @Test
    public void pobierzSlownik_test2(){
        Mockito.when(slownikAService.pobierzSlownik())
                .thenReturn(mockSlownikA());
        System.out.println(slownikAService.pobierzSlownik());
    }
    @Test
    public void pobierzSlownik_test3(){
        Mockito.when(slownikAService.pobierzSlownik())
                .thenReturn(mockSlownikA2());
        System.out.println(slownikAService.pobierzSlownik());
        System.out.println(slownikAService.zliczSlownik());
        assertThat(slownikAService.zliczSlownik(), Matchers.is(4));
        assertThat(slownikAService.zliczSlownik(), is(4));
//        assertThat(slownikAService.pobierzSlownik(), iterableWithSize(4));
//        assertThat(slownikAService.pobierzSlownik(), hasItem(new SlownikAItem(4L,"n42","o42")));
    }

    public List<SlownikAItem> mockSlownikA(){
        System.out.println("pobieram slownik A");
        return Arrays.asList(
                new SlownikAItem(1L,"n1","o1"),
                new SlownikAItem(2L,"n2","o2"),
                new SlownikAItem(3L,"n3","o3"),
                new SlownikAItem(4L,"n4","o4")
        );
    }
    public List<SlownikAItem> mockSlownikA2(){
        System.out.println("pobieram slownik A2");
        return Arrays.asList(
                new SlownikAItem(1L,"n1","o1"),
                new SlownikAItem(2L,"n2","o2"),
                new SlownikAItem(3L,"n3","o3"),
                new SlownikAItem(4L,"n42","o42")
        );
    }
}
