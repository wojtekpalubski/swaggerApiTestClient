package pl.wpe.swaggerApiTestClient.service.akcje;

import org.springframework.beans.factory.annotation.Autowired;
import pl.wpe.swaggerApiTestClient.model.SlownikAItem;
import pl.wpe.swaggerApiTestClient.service.slowniki.SlownikAService;

import java.util.List;
import java.util.Objects;

public class AkcjaA {
    private final String KOMUNIKAT;

    @Autowired
    private SlownikAService slownikAService;

    private AkcjaA(String KOMUNIKAT) {
        this.KOMUNIKAT = KOMUNIKAT;
    }

    public static AkcjaA valueOf(String komunikat){
        return new AkcjaA((komunikat));
    }

    public String getKOMUNIKAT() {
        return KOMUNIKAT;
    }

    String operacja(String tekst) {
        return odwroc(this.getKOMUNIKAT()+tekst);
    }

    String odwroc(String tekst) {
        return "R" + tekst;
    }

    String wykonaj(){
        List<SlownikAItem> sa=slownikAService.getSlownikA();
        SlownikAItem slownikAItem=sa.stream()
//                .peek(System.out::println)
                .filter(s->s.getNazwa().equals(getKOMUNIKAT()))
//                .peek(System.out::println)
                .findFirst()
                .orElse(new SlownikAItem(-1L,"nic","nic"));

        String ret=slownikAItem.getNazwa();
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AkcjaA)) return false;
        AkcjaA akcjaA = (AkcjaA) o;
        return Objects.equals(getKOMUNIKAT(), akcjaA.getKOMUNIKAT());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getKOMUNIKAT());
    }

    public void setSlownikAService(SlownikAService slownikAService) {
        this.slownikAService = slownikAService;
    }
}
