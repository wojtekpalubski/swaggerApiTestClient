package pl.wpe.swaggerApiTestClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;
import pl.wpe.swaggerApiTestClient.service.operacje.OperacjaAService;
import pl.wpe.swaggerApiTestClient.service.operacje.OperacjaBService;

import java.util.List;

@RestController("/api/v1")
public class UslugaAController {

    @Autowired
    OperacjaAService operacjaA;

    @Autowired
    OperacjaBService operacjaB;

    @GetMapping("/operacjaB/{nazwa}")
    public String operacjaB(@PathVariable("nazwa") String nazwa) {
        System.out.println("Wywolano /operacjaB/{nazwa}");
        return operacjaB.operacjaB(nazwa);
    }

    @GetMapping("/operacjaA/{nazwa}")
    public String operacjaA(@PathVariable("nazwa") String nazwa) {
        System.out.println("Wywolano /operacjaA/{nazwa}");
        return operacjaA.operacjaA(nazwa);
    }

    @GetMapping("/operacjaA")
    public List<SlownikAItem> operacjaAslownik() {
        System.out.println("Wywolano /operacjaA");
        return operacjaA.operacjaSlownikA();
    }
}
