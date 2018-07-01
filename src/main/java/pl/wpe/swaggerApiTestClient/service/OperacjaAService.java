package pl.wpe.swaggerApiTestClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacjaAService {
    @Autowired
    SlownikAService slownikA;

    public String operacjaA(String nazwa) {
        return "OperacjaA " + nazwa +" "+slownikA.getSlownikAbyNazwa(nazwa).getOpis();
    }
}
