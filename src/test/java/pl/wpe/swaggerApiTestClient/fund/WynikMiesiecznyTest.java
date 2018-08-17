package pl.wpe.swaggerApiTestClient.fund;

import org.junit.Test;

import static org.junit.Assert.*;

public class WynikMiesiecznyTest {

    @Test
    public void miesiac1(){
        WynikMiesieczny wynikMiesieczny=new WynikMiesieczny(1, 100, 0, 3.0/12, 0.0);
        System.out.println(wynikMiesieczny);
//        System.out.println(wynikMiesieczny.getMiesiecznyPrzyrostSkladki()+" "+wynikMiesieczny.getKapitalWynikowy());
    }
    @Test
    public void miesiac2(){
        WynikMiesieczny wynikMiesieczny=new WynikMiesieczny(2, 100, 100, 3.0/12, 100.25);
        System.out.println(wynikMiesieczny);
//        System.out.println(wynikMiesieczny.getMiesiecznyPrzyrostSkladki()+" "+wynikMiesieczny.getKapitalWynikowy());
    }
}