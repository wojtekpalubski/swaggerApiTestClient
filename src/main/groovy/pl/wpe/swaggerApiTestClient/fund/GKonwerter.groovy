package pl.wpe.swaggerApiTestClient.fund

import groovy.xml.MarkupBuilder
class GKonwerter {

    static def Wynik2XML(GWynikMiesieczny wynikMiesieczny){
        def builder = new MarkupBuilder()
        builder.wynik{
            kapitalKoncowy{
                wynikMiesieczny.kapitalKoncowy
            }
            sumaSkladek{
                wynikMiesieczny.sumaSkladek
            }
            kapitalkoncowy{
                wynikMiesieczny.kapitalKoncowy
            }
        }
    }
}
