package pl.wpe.swaggerApiTestClient.service.slowniki;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class SlownikAService {
    private List<SlownikAItem> slownikA;
    private Instant ostatniaAktualizacja;

    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    private void initSlownik() {
        if (slownikA == null) {
            log.info("slownikA tworze nowy slownik");
            slownikA = new ArrayList<>();
            odswiezSlownik();
        }
    }

    @Bean
    private List<SlownikAItem> getSlownikA() {
//        if (slownikA == null) {
//            slownikA = new ArrayList<>();
//            odswiezSlownik();
//        }
        Instant teraz = Instant.now();
        Duration minelo = Duration.between(ostatniaAktualizacja, teraz);
        log.info("SlownikA od odswiezenia minelo " + minelo.toMinutes() + " minut lub " + minelo.getSeconds() + " sekund");
        int czasSlownika = 1;
        if (minelo.toMinutes() >= czasSlownika) {
            log.info("SlownikA Od ostatniej aktualizacji minelo wiecej niz " + czasSlownika + " minut");
            odswiezSlownik();
        }
        log.info("SlownikA oddaje pozycji: " + slownikA.size());
        return slownikA;
    }

    private void odswiezSlownik() {
        Long pozycja = (long) slownikA.size() + 1;
        SlownikAItem item = new SlownikAItem();
        item.setId(pozycja);
        item.setNazwa("A" + pozycja.toString());
        item.setOpis("AO" + pozycja.toString());
        slownikA.add(item);
        ostatniaAktualizacja = Instant.now();
        log.info("SlownikA Do slownika A dodano: " + item);
    }

    public SlownikAItem getSlownikAbyId(Long id) {
        Optional<SlownikAItem> item = getSlownikA().stream().filter(s -> s.getId().equals(id)).findFirst();
        return item.orElseGet(SlownikAItem::new);
    }

    public SlownikAItem getSlownikAbyNazwa(String nazwa) {
        System.out.println("nazwa = [" + nazwa + "]");
        System.out.println("SlownikAService.getSlownikAbyNazwa");
        Optional<SlownikAItem> item = getSlownikA().stream().filter(s -> s.getNazwa().equals(nazwa)).findFirst();
        return item.orElse(new SlownikAItem());
//        if (item.isPresent()) {
//            return item.get();
//        } else {
//            return new SlownikAItem();
//        }
    }

    public List pobierzSlownik(){
        return restTemplate.getForObject("http://localhost:8081/api/v1/slownik/A", List.class);
    }

    public int zliczSlownik(){
        System.out.println("Zliczam pozycje slownika A");
        return pobierzSlownik().size();
    }
}
