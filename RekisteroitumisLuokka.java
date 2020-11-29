import java.util.Scanner;

/**
 * RekisteroitymisLuokka.java
 * Kehitysymparistot projektin ohjelman osa
 *
 * @author Matti Hänninen
 * @version 1.00 2020.1.11.
 */

 // Maaritellaan luokka
 class RekisteroitymisLuokka extends BMI {

    // Maaritetaan attribuutit
    protected String userRealName;
    protected String userName;
    protected String userPassword;
    protected boolean accountLocked = false;

    // Oletuskonstruktori
    RekisteroitymisLuokka() {
    }
    
    // Konstruktori jolle valitetaan parametrina kayttajen perustiedot
    RekisteroitymisLuokka(double weight, double height, double BMI, String returnvalue, String newName, String newUser, String newPassword, boolean accountLocked) {
        super (weight, height, BMI, returnvalue);
        userRealName = newName;
        userName = newUser;
        userPassword = newPassword;
        this.accountLocked = accountLocked;
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
    // Metodi joka palauttaa kayttajan kayttajatunnuksen
    String getUserName() {
        return userName;
    }
    // Metodi joka asettaa kayttajan kayttajatunnuksen
    public void setUserName(String newUser) {
        userName = newUser;
    }
    // Metodi joka palauttaa kayttajan tilin statuksen
    boolean getAccountStatus() {
        return accountLocked;
    }
    // Metodi joka asettaa kayttajan tilin statuksen
    public void setAccountStatus(boolean newAccountLocked) {
        accountLocked = newAccountLocked;
    }
    // Metodi joka palauttaa kayttajan salasanan
    String getPassword() {
        return userPassword;
    }
    // Metodi joka asettaa kayttajan salasanan
    public void setPassword(String newPassword) {
        userPassword = newPassword;
    }
    //////////////////////////////////////////////////////////////////

    // Metodi joka tulostaa kayttajan painon ja painoindeksin
    public String toString() {
        return "Paino: " + getWeight() + " Painoindeksi: " + (Math.round(getBMIValue() * 100) / 100.00) + " " + getBMI();
    }

    // Metodi joka kysyy tiedot kayttajalta
    public void askUserInputs() {
        Scanner input = new Scanner(System.in);
        System.out.println("Rekisteroituminen sovellukseen. Anna tietosi:");
        System.out.print("Kayttajatunnus: ");
        setUserName(input.nextLine());
        System.out.print("Salasana: ");
        setPassword(input.nextLine());
        System.out.print("Nimi: ");
        setRealName(input.nextLine());
        System.out.print("Pituus (muodossa 1,87): ");
        setHeight(input.nextDouble());
        input.nextLine();       // Enter
        System.out.print("Paino (muodossa 80,50): ");
        setWeight(input.nextDouble());
        input.nextLine();       // Enter
    }
 }
