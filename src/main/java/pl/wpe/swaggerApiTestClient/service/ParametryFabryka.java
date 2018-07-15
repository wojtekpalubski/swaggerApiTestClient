package pl.wpe.swaggerApiTestClient.service;

import org.hibernate.validator.internal.util.CollectionHelper;
import org.springframework.stereotype.Component;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;

import java.util.List;

@Component
public class ParametryFabryka {

    public static List<SlownikAItem> getListaSlownikAItem(int ilosc){
        List<SlownikAItem> lista=CollectionHelper.newArrayList(ilosc);
        for (int i=0; i<ilosc; i++){
            lista.add(new SlownikAItem((long) i, String.valueOf(i), String.valueOf(i)));
        }

        return lista;
    }

    public static String getPowtorkiSlowa(String slowo, int ilosc){
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<ilosc; i++){
            sb.append(slowo);
        }

        return sb.toString();
    }
}
