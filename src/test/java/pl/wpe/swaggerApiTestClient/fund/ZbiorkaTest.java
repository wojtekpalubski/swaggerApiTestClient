package pl.wpe.swaggerApiTestClient.fund;

import org.junit.Test;

//import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class ZbiorkaTest {

    @Test
    public void format(){
        Double d1 =1.0;
        System.out.println(String.format("d1=%05.2f%s",d1,"%"));
    }

    @Test
    public void ZbiorkaNN_1mies(){
        Zbiorka zbiorka=new Zbiorka();
        zbiorka.setSkladka(100);
        zbiorka.setWyniki(getNN_1mies());

        assertThat(zbiorka.wylicz(),is(101.0));
    }
    @Test
    public void ZbiorkaNN_1mies_ujemny(){
        Zbiorka zbiorka=new Zbiorka();
        zbiorka.setSkladka(100);
        zbiorka.setWyniki(getNN_1mies_ujemny());

        assertThat(zbiorka.wylicz(),is(99.0));
    }
    @Test
    public void ZbiorkaNN_2mies(){
        Zbiorka zbiorka=new Zbiorka();
        zbiorka.setSkladka(100);
        zbiorka.setWyniki(getNN_2mies());

        assertThat(zbiorka.wylicz(),is(203.01));
    }
    @Test
    public void ZbiorkaNN_5mies(){
        Zbiorka zbiorka=new Zbiorka();
        zbiorka.setSkladka(100);
        zbiorka.setWyniki(getNN_5mies());

        assertThat(zbiorka.wylicz(),is(closeTo(504.68,0.02)));
    }
    @Test
    public void ZbiorkaLokata3proc(){
        Zbiorka zbiorka=new Zbiorka();
        zbiorka.setSkladka(100);
        zbiorka.setWyniki(getLokata3proc());

        assertThat(zbiorka.wylicz(),is(closeTo(504.68,0.02)));
    }

    public WynikiInterface getNN_1mies(){
        WynikiNN wynikiNN=new WynikiNN();
        wynikiNN.addWynik(1.0);
        return wynikiNN;
    }
    public WynikiInterface getNN_1mies_ujemny(){
        WynikiNN wynikiNN=new WynikiNN();
        wynikiNN.addWynik(-1.0);
        return wynikiNN;
    }
    public WynikiInterface getNN_2mies(){
        WynikiNN wynikiNN=new WynikiNN();
        wynikiNN.addWynik(1.0);
        wynikiNN.addWynik(1.0);
        return wynikiNN;
    }
    public WynikiInterface getNN_5mies(){
        WynikiNN wynikiNN=new WynikiNN();
        wynikiNN.addWynik(1.0);
        wynikiNN.addWynik(1.0);
        wynikiNN.addWynik(-1.0);
        wynikiNN.addWynik(-2.5);
        wynikiNN.addWynik(3.0);
        return wynikiNN;
    }
    public WynikiInterface getLokata3proc(){
        WynikiNN wynikiNN=new WynikiNN();
        Double procMies=3.0/12;
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        wynikiNN.addWynik(procMies);
        return wynikiNN;
    }
}