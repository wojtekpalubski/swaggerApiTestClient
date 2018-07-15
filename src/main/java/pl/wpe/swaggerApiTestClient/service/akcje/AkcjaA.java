package pl.wpe.swaggerApiTestClient.service.akcje;

import java.util.Objects;

public class AkcjaA {
    private final String KOMUNIKAT;

    private AkcjaA(String KOMUNIKAT) {
        this.KOMUNIKAT = KOMUNIKAT;
    }

    public static AkcjaA valueOf(String komunikat){
        return new AkcjaA((komunikat));
    }

    public String getKOMUNIKAT() {
        return KOMUNIKAT;
    }

    protected String operacja(String tekst) {
        return odwroc(this.getKOMUNIKAT()+tekst);
    }

    String odwroc(String tekst) {
        return "R" + tekst;
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
}
