package pl.wpe.swaggerApiTestClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacjaBService {
    @Autowired
    SlownikAService slownikA;

    public String operacjaB(String nazwa) {
        return "OperacjaB slownikA dla " + nazwa +": "+slownikA.getSlownikAbyNazwa(nazwa).getOpis();
    }
}
