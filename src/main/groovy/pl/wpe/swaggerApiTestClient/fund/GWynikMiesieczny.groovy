package pl.wpe.swaggerApiTestClient.fund

import groovy.json.JsonBuilder
import groovy.transform.Canonical
import groovy.xml.MarkupBuilder

@Canonical
class GWynikMiesieczny implements WynikiInterface {
    private final Integer numerOkresu;
    private final Integer wplaconaSkladka;
    private final Integer poprzednieSkladki;
    private final Double oprocentowanie;
    private final Double kapitalPoczatkowy;

    GWynikMiesieczny(Integer numerOkresu, Integer wplaconaSkladka, Integer poprzednieSkladki, Double oprocentowanie, Double kapitalPoczatkowy) {
        this.numerOkresu = numerOkresu
        this.wplaconaSkladka = wplaconaSkladka
        this.poprzednieSkladki = poprzednieSkladki
        this.oprocentowanie = oprocentowanie
        this.kapitalPoczatkowy = kapitalPoczatkowy
    }

    Double getKapitalKoncowy() {
        getPrzyrostSkladki() + getPrzyrostKapitalu()
    }

    Double getPrzyrostSkladki() {
        wplaconaSkladka + wplaconaSkladka * oprocentowanie / 100
    }

    Double getPrzyrostKapitalu() {
        kapitalPoczatkowy + kapitalPoczatkowy * oprocentowanie / 100
    }

    Integer getSumaSkladek() {
        poprzednieSkladki + wplaconaSkladka

    }

    String printOkres() {
        "Okres: $numerOkresu, procenty: $oprocentowanie, skladka: $wplaconaSkladka, kapital pocz.: $kapitalPoczatkowy, kapital koncowy: " + getKapitalKoncowy()
    }

    String asXML() {
        def builder = new MarkupBuilder()
        builder.wynikOkresu(numerOkresu: this.numerOkresu, oprocentowanie: this.oprocentowanie) {
            oprocentowanie this.oprocentowanie
            skladka this.wplaconaSkladka
            kapitalKoncowy this.kapitalKoncowy
            sumaSkladek this.sumaSkladek
        }
    }

    String asJson() {
        def builder = new JsonBuilder()
        builder(["numerOkresu": this.numerOkresu, "oprocentowanie": this.oprocentowanie, "skladka": this.wplaconaSkladka, "sumaSkladek": this.sumaSkladek, "kapitalKoncowy": this.kapitalKoncowy])
    }


    @Override
    List<Double> getWyniki() {
        return null
    }

    @Override
    void addWynik(Double wynik) {
        println("groovy dodaje ${wynik}")
    }
}
