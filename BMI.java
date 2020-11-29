/**
 * BMI.java
 * Kehitysymparistot projektin ohjelman osa
 *
 * @author Leevi Meriläinen, Matti Hänninen
 * @version 1.00 2020.11.11.
 */
public class BMI {
    //Attribuutit
    protected double weight;
    protected double height;
    protected double BMI;
    protected String returnvalue;
    

    public BMI() {
    }

    public BMI(double weight, double height, double BMI, String returnvalue) { //Paino ja pituus arvot asetetaan mistä BMI arvoa myös haetaan
        this.weight = weight;
        this.height = height;
        this.BMI = BMI;
        this.returnvalue = returnvalue;
    }

    public String getBMI() {
        this.BMI = weight / height / height; //Laskutoimitus, joka antaa painoindeksiarvon.
    
        if (BMI < 18.5) {
            this.returnvalue = "Henkilö on alipainoinen."; //Syötetään käyttäjälle painoindeksiarvoa vastaava terveystila.
            return returnvalue;
        }
        if (BMI >= 18.5 && BMI <= 25) {
            this.returnvalue = "Henkilö on normaalipainoinen.";
            return returnvalue;
        }
        if (BMI >= 25.1 && BMI <= 30) {
            this.returnvalue = "Henkilö on lievästi ylipainoinen";
            return returnvalue;
        }
        if (BMI >= 30.1 && BMI <= 35) {
            this.returnvalue = "Henkilö on merkittävästi ylipainoinen";
            return returnvalue;
        }
        if (BMI >= 35.1 && BMI <= 40) {
            this.returnvalue = "Henkilö on vaikeasti ylipainoinen";
            return returnvalue;
        }
        if (BMI > 40) {
            this.returnvalue = "Henkilö on sairaaloisesti ylipainoinen";
            return returnvalue;
        }
        this.returnvalue = "Painoa tai pituutta ei ole asetettu.";
        return returnvalue;
    }

        // Metodi joka palauttaa kayttajan pituuden
        double getHeight() {
            return height;
        }
        // Metodi joka asettaa kayttajan pituuden
        public void setHeight(double newHeight) {
            height = newHeight;
        }
        // Metodi joka palauttaa kayttajan painon
        double getWeight() {
            return weight;
        }
        // Metodi joka asettaa kayttajan painon
        public void setWeight(double newWeight) {
            weight = newWeight;
        }
        // Metodi joka asettaa kayttajan painon
        public void setBMI(double newWeight, double newHeight) {
            BMI = newWeight / newHeight / newHeight;
        }
        
        // Metodi joka palauttaa kayttajan BMI lukuna
        double getBMIValue() {
            return BMI;
        }
}
