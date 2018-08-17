package pl.wpe.swaggerApiTestClient.fund;

import lombok.Getter;

@Getter
public class WynikMiesieczny {
    private final Integer numerMiesiaca;
    private final Integer wplaconaSkladka;
    private final Integer poprzednieSkladki;
    private final Double oprocentowanie;
    private final Double kapitalPoczatkowy;

    public WynikMiesieczny(Integer numerMiesiaca, Integer wplaconaSkladka, Integer poprzednieSkladki, Double oprocentowanie, Double kapitalPoczatkowy) {
        this.numerMiesiaca = numerMiesiaca;
        this.wplaconaSkladka = wplaconaSkladka;
        this.poprzednieSkladki = poprzednieSkladki;
        this.oprocentowanie = oprocentowanie;
        this.kapitalPoczatkowy = kapitalPoczatkowy;
    }

    Double getMiesiecznyPrzyrostSkladki() {
        return wplaconaSkladka + wplaconaSkladka * oprocentowanie / 100;
    }

    Double getMiesiecznyPrzyrostKapitalu() {
        return kapitalPoczatkowy + kapitalPoczatkowy * oprocentowanie / 100;
    }

    Double getKapitalWynikowy() {
        return getMiesiecznyPrzyrostKapitalu() + getMiesiecznyPrzyrostSkladki();
    }

    Double getPrzyrost() {
        return getKapitalWynikowy() - getSumaSkladek();
    }

    Double getZyskProc() {
        return getPrzyrost() / getSumaSkladek() * 100;
    }

    Integer getSumaSkladek() {
        return poprzednieSkladki + wplaconaSkladka;
    }

    @Override
    public String toString() {
        return String.format("Wynik po miesiacu %3d: %5.2f%s, przyrost skladki: %6.2fzl, kapital poczatkowy: %8.2fzl, kapital koncowy: %8.2fzl, suma skladek: %dzl, zysk %.2fzl (%.2f)%s",
                numerMiesiaca, oprocentowanie, "%", getMiesiecznyPrzyrostSkladki(), kapitalPoczatkowy, getKapitalWynikowy(),
                getSumaSkladek(), getPrzyrost(), getZyskProc(), "%");
    }
}
