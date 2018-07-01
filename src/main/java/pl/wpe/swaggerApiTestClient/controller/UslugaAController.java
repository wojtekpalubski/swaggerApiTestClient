package pl.wpe.swaggerApiTestClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.wpe.swaggerApiTestClient.service.OperacjaAService;
import pl.wpe.swaggerApiTestClient.service.OperacjaBService;

@RestController("/api/v1")
public class UslugaAController {

    @Autowired
    OperacjaAService operacjaA;

    @Autowired
    OperacjaBService operacjaB;

    @GetMapping("/operacjaB/{nazwa}")
    public String operacjaB(@PathVariable("nazwa") String nazwa) {
        return operacjaB.operacjaB(nazwa);
    }

    @GetMapping("/operacjaA/{nazwa}")
    public String operacjaA(@PathVariable("nazwa") String nazwa) {
        return operacjaA.operacjaA(nazwa);
    }
}
