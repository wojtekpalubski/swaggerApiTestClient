package pl.wpe.swaggerApiTestClient.controller;

import pl.wpe.swaggerApiTestClient.model.SlownikAItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UslugaAControllerTest {

    public void operacjaA(){

    }

    private List<SlownikAItem> genSlownikA(){
        List<SlownikAItem> slownik=new ArrayList<>();
        slownik.add(new SlownikAItem(1L, "nazwa1","opis1"));
        slownik.add(new SlownikAItem(2L, "nazwa2","opis2"));
        return slownik;
    }

}