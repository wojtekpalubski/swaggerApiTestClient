package pl.wpe.swaggerApiTestClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;
import pl.wpe.swaggerApiTestClient.service.ParametryFabryka;

import java.util.List;

public class ParametryFabrykaTest {

    @Autowired
    ParametryFabryka fabryka;

    @Test
    public void fabryka_test1(){
        List<SlownikAItem> lista1= ParametryFabryka.getListaSlownikAItem(2);
        System.out.println(lista1.hashCode());
        List<SlownikAItem> lista2= ParametryFabryka.getListaSlownikAItem(2);
        System.out.println(lista2.hashCode());

        System.out.println(ParametryFabryka.getPowtorkiSlowa("asdf", 2));
        System.out.println(ParametryFabryka.getPowtorkiSlowa("werewrw", 5));
    }
}
