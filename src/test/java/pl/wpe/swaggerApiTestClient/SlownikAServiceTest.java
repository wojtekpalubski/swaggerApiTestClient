package pl.wpe.swaggerApiTestClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;
import pl.wpe.swaggerApiTestClient.service.SlownikAService;

import java.util.Arrays;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.junit.Assert.assertEquals;

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
                .thenReturn(mockSlownikA());
        System.out.println(slownikAService.zliczSlownik());
        assertEquals(mockSlownikA().size(), 4);
    }

    public List<SlownikAItem> mockSlownikA(){
        return Arrays.asList(
                new SlownikAItem(1l,"n1","o1"),
                new SlownikAItem(2l,"n2","o2"),
                new SlownikAItem(3l,"n3","o3"),
                new SlownikAItem(4l,"n4","o4")
        );
    }
}
