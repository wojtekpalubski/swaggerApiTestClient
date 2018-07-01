package pl.wpe.swaggerApiTestClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "pl.wpe.swaggerApiTestClient.service")
public class OperacjaBService {
    @Autowired @Qualifier("slownikAService")
    SlownikAService slownikA;

    public String operacjaB(String nazwa) {
        return "OperacjaB slownikA dla " + nazwa +": "+slownikA.getSlownikAbyNazwa(nazwa).getOpis();
    }
}
