/**
 * PainoOyPainonLaskuOhjelma.java
 *
 * Pääohjelma PainoOyPainonLaskuOhjelma
 * Kehitysymparistot projektin paaohjelma
 * Riippuvuudet: RekisteroitumisLuokka.java
 * 
 * @author Matti Hänninen, Miikka Kojo, Leevi Merilainen, Miro Kuosmanen
 * @version 1.00 2020.2.11.
 */


public class PainoOyPainonLaskuOhjelma {

    public static void main (String [] args) {

        // Luodaan rekisteroitynyt testikayttaja
        RekisteroitymisLuokka Kayttaja1 = new RekisteroitymisLuokka("Mauri Pekkarinen", 182.50, 85.50, "Mare47", "MaurinSalasana1234");

        // Testitulostus
        System.out.println(Kayttaja1);
    }
}