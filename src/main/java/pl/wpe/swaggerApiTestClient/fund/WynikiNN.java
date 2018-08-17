package pl.wpe.swaggerApiTestClient.fund;

import java.util.ArrayList;
import java.util.List;

public class WynikiNN implements WynikiInterface {
    private List<Double> wyniki=new ArrayList<>();

    @Override
    public List<Double> getWyniki() {
        return wyniki;
    }

    @Override
    public void addWynik(Double wynik) {
        wyniki.add(wynik);
    }
}
