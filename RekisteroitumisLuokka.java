/**
 * RekisteroitymisLuokka.java
 * Kehitysymparistot projektin ohjelman osa
 *
 * @author Matti Hänninen
 * @version 1.00 2020.1.11.
 */

 // Maaritellaan luokka
 class RekisteroitymisLuokka {

    // Maaritetaan attribuutit
    String userRealName;
    double userHeight;
    String userName;
    String userPassword;

    // Maaritellaan taulukkoattribuutti kayttajatietojen tallentamista varten. 100 paikkaa oletuksena. VAIN HAHMOTTELUA VARTEN, EI VIELA TOIMINNASSA.
    private RekisteroitymisLuokka [] UserDatabase = new RekisteroitymisLuokka[100];

    // Oletuskonstruktori
    RekisteroitymisLuokka() {
    }
    
    // Konstruktori jolle valitetaan parametrina kayttajen perustiedot
    RekisteroitymisLuokka(String newName, double newHeight, String newUser, String newPassword) {
        userRealName = newName;
        userHeight = newHeight;
        userName = newUser;
        userPassword = newPassword;
    }

    // Luodaan aksessorit ja mutaattorit (getterit ja setterit) attribuuteille

    // Metodi joka palauttaa kayttajan oikean nimen
    String getRealName() {
        return userRealName;
    }
    // Metodi joka asettaa kayttajan oikean nimen
    public void setRealName(String newName) {
        userRealName = newName;
    }
    // Metodi joka palauttaa kayttajan pituuden
    double getHeight() {
        return userHeight;
    }
    // Metodi joka asettaa kayttajan pituuden
    public void setHeight(double newHeight) {
        userHeight = newHeight;
    }
    // Metodi joka palauttaa kayttajan kayttajatunnuksen
    String getUserName() {
        return userName;
    }
    // Metodi joka asettaa kayttajan kayttajatunnuksen
    public void setUserName(String newUser) {
        userName = newUser;
    }
    // Metodi joka palauttaa kayttajan salasanan
    String getPassword() {
        return userPassword;
    }
    // Metodi joka asettaa kayttajan salasanan
    public void setPassword(String newUserPassword) {
        userPassword = newUserPassword;
    }

    //////////////////////////////////////////////////////////////////

    // Metodi joka tulostaa kayttajan perustiedot, salasanaa lukuunottamatta
    public String toString() {
        return "Kayttajatunnus: " + getUserName() + "\n" +
            "Nimi: " + getRealName() + "\n" +
            "Pituus: " + getHeight();
    }
    
 }
