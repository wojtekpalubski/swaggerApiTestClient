package pl.wpe.swaggerApiTestClient.fund;

import org.springframework.beans.factory.annotation.Autowired;

public class Zbiorka {
    @Autowired
    private WynikiInterface wyniki;

    private Integer skladka;

    public void setSkladka(Integer skladka) {
        this.skladka = skladka;
    }

    public void setWyniki(WynikiInterface wyniki) {
        this.wyniki = wyniki;
    }

    public Double wylicz(){
        Double wynik=0.0;
        Integer skumulowanaSkladka=0;
        Integer nrMiesiaca=1;
        for(Double oprocentowanieMiesieczne:wyniki.getWyniki()){
            Double miesiecznyPrzyrostSkladki=skladka+skladka*oprocentowanieMiesieczne/100;
            Double kumulacjaPop=wynik+wynik*oprocentowanieMiesieczne/100;
            skumulowanaSkladka+=skladka;
            wynik=kumulacjaPop+miesiecznyPrzyrostSkladki;

            Double przyrost=wynik-skumulowanaSkladka;
            Double zyskProc=przyrost/skumulowanaSkladka*100;
            String kom=String.format("Wynik w miesiacu %3d: %5.2f%s, skladka w miesiacu: %6.2f, kapital na pocz. mies: %8.2f, skumulowany na koniec mies: %8.2f, wplacone skladki: %d, zysk %.2f (%.2f)%s",
                    nrMiesiaca,oprocentowanieMiesieczne,"%", miesiecznyPrzyrostSkladki, kumulacjaPop, wynik,skumulowanaSkladka, przyrost, zyskProc,"%");
//            System.out.println("Wynik w miesiacu: "+d+"%, skladka w miesiacu: "+mies+", kapital na pocz. mies: "+kumulacja+", skumulowany na koniec mies: "+(kumulacja+mies));
            System.out.println(kom);
            nrMiesiaca++;
        }

        GWynikMiesieczny gWynikMiesieczny=new GWynikMiesieczny(0,100,0,3.0/12,0.0);
        gWynikMiesieczny.addWynik(5.3);
        System.out.println("Gwynik: "+gWynikMiesieczny.getKapitalKoncowy());
        return wynik;
    }
}
