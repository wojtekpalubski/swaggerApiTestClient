package pl.wpe.swaggerApiTestClient.fund

class GWynikMiesieczny implements WynikiInterface {
    private final Integer numerMiesiaca;
    private final Integer wplaconaSkladka;
    private final Integer poprzednieSkladki;
    private final Double oprocentowanie;
    private final Double kapitalPoczatkowy;

    GWynikMiesieczny(Integer numerWiesiaca,Integer wplaconaSkladka,Integer poprzednieSkladki,Double oprocentowanie,Double kapitalPoczatkowy){
        this.numerMiesiaca=numerWiesiaca
        this.wplaconaSkladka=wplaconaSkladka
        this.poprzednieSkladki=poprzednieSkladki
        this.oprocentowanie=oprocentowanie
        this.kapitalPoczatkowy=kapitalPoczatkowy
    }

    Double getKapitalKoncowy(){
        kapitalPoczatkowy+wplaconaSkladka
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
