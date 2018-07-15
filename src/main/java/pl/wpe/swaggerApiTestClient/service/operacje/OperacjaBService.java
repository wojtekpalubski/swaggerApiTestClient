package pl.wpe.swaggerApiTestClient.service.operacje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pl.wpe.swaggerApiTestClient.service.slowniki.SlownikAService;

@Service
@ComponentScan(basePackages = "pl.wpe.swaggerApiTestClient.service")
public class OperacjaBService {
    @Autowired @Qualifier("slownikAService")
    SlownikAService slownikA;

    public String operacjaB(String nazwa) {
        return "OperacjaB slownikA dla " + nazwa +": "+slownikA.getSlownikAbyNazwa(nazwa).getOpis();
    }
}
