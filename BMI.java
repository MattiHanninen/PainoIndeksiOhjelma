/**
 * BMI.java
 * Kehitysymparistot projektin ohjelman osa
 *
 * @author Leevi Meriläinen
 * @version 1.00 2020.11.11.
 */
class BMI {
    //Attribuutit
    double weight;
    double height;
    double BMI;
    String returnvalue;

    public BMI(double weight, double height) { //Paino ja pituus arvot asetetaan mistä BMI arvoa myös haetaan mahdollisesti(?)
        this.weight = weight;
        this.height = height;
    }

    String getBMI() {
        this.BMI = weight / height / weight; //Laskutoimitus, joka antaa painoindeksiarvon.
    
        if (BMI < 18.5) {
            this.returnvalue = System.out.println("Henkilö on alipainoinen."); //Syötetään käyttäjälle painoindeksiarvoa vastaava terveystila.
            return returnvalue;
        }
        if (BMI >= 18.5 && BMI <= 25) {
            this.returnvalue = System.out.println("Henkilö on normaalipainoinen.");
            return returnvalue;
        }
        if (BMI >= 25.1 && BMI <= 30) {
            this.returnvalue = System.out.println("Henkilö on lievästi ylipainoinen");
            return returnvalue;
        }
        if (BMI >= 30.1 && BMI <= 35) {
            this.returnvalue = System.out.println("Henkilö on merkittävästi ylipainoinen");
            return returnvalue;
        }
        if (BMI >= 35.1 && BMI <= 40) {
            this.returnvalue = System.out.println("Henkilö on vaikeasti ylipainoinen");
            return returnvalue;
        }
        if (BMI > 40) {
            this.returnvalue = System.out.println("Henkilö on sairaaloisesti ylipainoinen");
            return returnvalue;
        }
        this.returnvalue = System.out.println("Painoa tai pituutta ei ole asetettu.");
        return returnvalue;
    }
}
