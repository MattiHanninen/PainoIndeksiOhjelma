
/**
 * PainoOyPainonLaskuOhjelma.java
 *
 * Paaohjelma PainoOyPainonLaskuOhjelma
 * Kehitysymparistot projektin paaohjelma
 * Riippuvuudet: RekisteroitumisLuokka.java BMI.java
 * 
 * @author Matti Hänninen, Miikka Kojo, Leevi Meriläinen, Miro Kuosmanen
 * @version 1.00 2020.2.11.
 */
import java.util.*;
import java.io.*;

public class PainoOyPainonLaskuOhjelma {

    public static void main(String[] args) {

        // Luodaan rekisteroitynyt testikayttaja
        RekisteroitymisLuokka kayttaja1 = new RekisteroitymisLuokka(85.50, 1.82, 0, "", "Mauri Pekkarinen", "Mare47", "MaurinSalasana1234", false);
        RekisteroitymisLuokka kayttaja2 = new RekisteroitymisLuokka();

        // Luodaan lista kayttajia varten.
        ArrayList<Object> userDataBase = new ArrayList<>();
        userDataBase.add(kayttaja1);
        userDataBase.add(kayttaja2);

        // Luodaan Scanner
        Scanner input = new Scanner(System.in);


        // Merkkijonomuuttujia tiedostoa varten
        String fileName = "";
        String fileDate = "";
        String fileWeightAndBMI = "";
        String readFileLine;

        // Muuttujia
        int passwordAttempts = 3;
        double weightAverage = 0;
        double weightAveragePrint = 0;
        double weightCount = 0;
        double bmiAverage = 0;
        double bmiAveragePrint = 0;
        double bmiCount = 0;

        // Uusi Date olio paivamaaran saantiin
        Date date = new Date();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Luodaan ohjelman valikkorakenne
        // Paavalikko

        System.out.println("Tervetuloa kayttamaan Paino Oy painoindeksiohjelmaa.");
        System.out.println("Paavalikko.\nValitse toiminto:\n1. Luo uusi kayttaja.\n2. Kirjaudu jarjestelmaan.\nJokin muu merkki. Lopeta.");

        // Paavalikon ohjaus
        char mainOptionInput = input.next().charAt(0);
        input.nextLine(); // Enter

        while (mainOptionInput == '1' || mainOptionInput == '2') {
            switch (mainOptionInput) {
                // Kayttajan rekisteroityminen
                case '1':
                    kayttaja2.askUserInputs();
                    System.out.println("Uusi kayttaja henkilolle " + kayttaja2.getRealName() + " luotu.\n");
                    System.out.println("Paavalikko.\nValitse toiminto:\n1. Luo uusi kayttaja.\n2. Kirjaudu jarjestelmaan.\nJokin muu merkki. Lopeta.");
                    mainOptionInput = input.next().charAt(0);
                    input.nextLine(); // Enter
                    break;

                // Kayttajan kirjautuminen
                case '2':
                    System.out.println("Kirjautuminen.\nMikali kayttajaa ei loydy, palataan paavalikkoon.\nKayttajatunnus: ");
                    String userNameInput = input.nextLine();


                    // Jos kayttaja loytyy
                    if (userNameInput.equals(kayttaja2.getUserName()) && kayttaja2.getAccountStatus() == false) {

                        System.out.println("Salasana: ");
                        String userPasswordInput = input.nextLine();
                        if (userPasswordInput.equals(kayttaja2.getPassword())) {
                            System.out.println("Salasana oikein!\nTervetuloa " + kayttaja2.getRealName() + "\n");

                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            // Sisempi valikko Paavalikon Case 2 sisalla
                            System.out.println("Valitse toiminto jonka haluat suorittaa.\n1. Kirjaa tuloksia.\n2. Tulosta tuloksia.\nJokin muu merkki. Palaa paavalikkoon.");

                            // Sisemman valikon ohjaus
                            char optionInput = input.next().charAt(0);
                            input.nextLine(); // Enter


                            while (optionInput == '1' || optionInput == '2') {
                            switch (optionInput) {
                                // Tulosten kirjaaminen
                                case '1':
                                    fileName = kayttaja2.getUserName() + ".txt";

                                    // Tallennetaan kayttajan tulokset omaan tiedostoon
                                    // Luodaan ohjelmalohko tekstin kirjoittamista varten
                                    try {

                                        // Luodaan oliot tiedoston kirjoittamista varten, ja luodaan/muokataan tekstitiedosto
                                        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

                                        // Kysytaan painoa
                                        System.out.println("Anna tamanhetkinen painosi (muodossa 80,50): ");
                                        kayttaja2.setWeight(input.nextDouble());
                                        kayttaja2.setBMI(kayttaja2.getWeight(), kayttaja2.getHeight());
                                        weightAverage = weightAverage + kayttaja2.getWeight();
                                        bmiAverage = bmiAverage + kayttaja2.getBMIValue();
                                        weightCount = weightCount + 1.0;
                                        bmiCount = bmiCount + 1.0;
                                        weightAveragePrint = weightAverage / weightCount;
                                        bmiAveragePrint = bmiAverage / bmiCount;
                                        // Kirjoitetaan tiedot tekstitiedostoon
                                        fileDate = "Date " + date.toString();
                                        fileWriter.write(fileDate + ".");
                                        fileWriter.newLine();
                                        fileWeightAndBMI = kayttaja2.toString();
                                        fileWriter.write(fileWeightAndBMI);
                                        fileWriter.newLine();
                                        // Suljetaan tiedosto
                                        fileWriter.close();
                                    }

                                    // Otetaan kiinni mahdolliset syote- ja tulostusvirtoihin liittyvat poikkeukset, tulostetaan virheilmoitus ja lopetataan ohjelma
                                    catch (FileNotFoundException e) {
                                        System.out.println("ERROR: File not found.");
                                        System.exit(1);
                                    }

                                    catch (IOException e) {
                                        System.out.println("ERROR: Input or print failure. Shutting down.");
                                        System.exit(1);
                                    } catch (Exception e) {
                                        System.out.println("ERROR: Unknown failure. Shutting down.");
                                        System.exit(1);
                                    }

                                    System.out.println("Uusi tulos kirjattu kayttajalle " + kayttaja2.getUserName() + "\n");
                                    System.out.println("Valitse toiminto jonka haluat suorittaa.\n1. Kirjaa tuloksia.\n2. Tulosta tuloksia.\nJokin muu merkki. Palaa paavalikkoon.");
                                    optionInput = input.next().charAt(0);
                                    input.nextLine(); // Enter

                                    // Case 1 break
                                    break;
                                // Tulosten tulostaminen
                                case '2':

                                    // Muuttuja haun avuksi, boolean oletus etta ei loydy
                                    boolean dateFound = false;
                                    // Kayttajan tietojen lukeminen tiedostosta
                                    try {

                                        // Luodaan olio tiedostosta lukemista varten
                                        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

                                        System.out.println("\nPaivamaarat joille on kirjattuja tietoja: ");

                                        while ((readFileLine = fileReader.readLine()) != null) {

                                            // Verrataan tiedoston date hakua, tulostetaan tiedot jos loytyy
                                            if (readFileLine.contains("Date")) {

                                                System.out.println(readFileLine);
                                                String[] dateSearch = readFileLine.split(".");

                                                if (Arrays.asList(dateSearch).contains("Date")) {
                                                    System.out.println(readFileLine);
                                                }
                                            }
                                        }
                                        // Suljetaan tiedosto
                                        fileReader.close();
                                    }

                                    // Otetaan kiinni mahdolliset syote- ja tulostusvirtoihin liittyvat poikkeukset, tulostetaan virheilmoitus ja lopetataan ohjelma
                                    catch (IOException e) {
                                        System.out.println("ERROR: Input or print failure. Shutting down.");
                                        System.exit(1);
                                    } catch (Exception e) {
                                        System.out.println("ERROR: Unknown failure. Shutting down.");
                                        System.exit(1);
                                    }

                                    try {

                                        System.out.println("\nValitse aikavali, jolta haluat tulostaa tiedot.");
                                        // Luodaan olio tiedostosta lukemista varten
                                        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

                                        dateFound = false;

                                        System.out.println("Anna alkupaiva (muodossa Nov 27, Dec 08 jne.): ");
                                        String dateFrom = input.nextLine();
                                        System.out.println("Anna loppupaiva (muodossa Nov 27, Dec 08 jne.): ");
                                        String dateUntil = input.nextLine();
                                        System.out.println("\nTekemasi kirjaukset valitsemaltasi aikavalilta:\n");

                                        while ((readFileLine = fileReader.readLine()) != null) {

                                            // Verrataan kayttajan paivamaaria, tulostetaan tiedot jos loytyy
                                            if (readFileLine.contains(dateFrom) || readFileLine.contains(dateUntil)) {
                                                System.out.println(readFileLine);
                                                System.out.println(fileReader.readLine());

                                                // Jos loytyy, vaihdetaan boolean true
                                                dateFound = true;

                                                System.out.println("Painotietojen keskiarvo: " + weightAveragePrint);
                                                System.out.println("Painoindeksien keskiarvo: " + (Math.round(bmiAveragePrint * 100) / 100) + "\n");
                                            }
                                        }

                                        // Jos haettua ID ei loydy
                                        if (dateFound == false) {
                                            System.out.println("Paivamaaratietoa ei loytynyt.\n");
                                        }

                                        // Suljetaan tiedosto
                                        fileReader.close();
                                    }

                                    // Otetaan kiinni mahdolliset syote- ja tulostusvirtoihin liittyvat poikkeukset, tulostetaan virheilmoitus ja lopetataan ohjelma
                                    catch (IOException e) {
                                        System.out.println("ERROR: Input or print failure. Shutting down.");
                                        System.exit(1);
                                    } catch (Exception e) {
                                        System.out.println("ERROR: Unknown failure. Shutting down.");
                                        System.exit(1);
                                    }

                                    System.out.println("Valitse toiminto jonka haluat suorittaa.\n1. Kirjaa tuloksia.\n2. Tulosta tuloksia.\nJokin muu merkki. Palaa kirjautumisikkunaan.");
                                    optionInput = input.next().charAt(0);
                                    input.nextLine(); // Enter

                                // Sisemman valikon Case 2 break
                                break;
                                
                                default:
                                    System.out.println("Palataan paavalikkoon.");
                                    System.out.println("Paavalikko.\nValitse toiminto:\n1. Luo uusi kayttaja.\n2. Kirjaudu jarjestelmaan.\nJokin muu merkki. Lopeta.");
                                    mainOptionInput = input.next().charAt(0);
                                    input.nextLine(); // Enter

                                } // While loop lopetus optionInput
                            }
                        }
                        else {
                            passwordAttempts--;
                            System.out.println("Virheellinen salasana.\nYrityksia jaljella " + passwordAttempts + "\n");
                            if (passwordAttempts == 0) {
                                System.out.println("\nLiian monta virheellista yritysta. Tilisi lukittiin.\n");
                                kayttaja2.setAccountStatus(true);
                                System.out.println("Palataan paavalikkoon.");
                                System.out.println("Paavalikko.\nValitse toiminto:\n1. Luo uusi kayttaja.\n2. Kirjaudu jarjestelmaan.\nJokin muu merkki. Lopeta.");
                                mainOptionInput = input.next().charAt(0);
                                input.nextLine(); // Enter
                            }
                        }
                    }
                    // Jos kayttajaa ei loydy
                    else {
                       System.out.println("Kayttajatunnusta ei loytynyt, tai tilisi saattaa olla lukittu.\nPalataan paavalikkoon.\n");
                       System.out.println("Paavalikko.\nValitsetoiminto:\n1. Luo uusi kayttaja.\n2. Kirjaudu jarjestelmaan.\nJokin muu merkki. Lopeta.");
                       mainOptionInput = input.next().charAt(0);
                       input.nextLine(); // Enter
                    }
                
                    // Paavalikon Case 2 break
                    break;
                    default:
                    System.out.println("\nKiitos ohjelman kaytosta.\nPaino Oy toivottaa sinut tervetulleeksi uudelleen.");
                 
            } // Paavalikon switch case lopetus
        } // While loop lopetus mainOptionInput
        System.out.println("\nKiitos ohjelman kaytosta.\nPaino Oy toivottaa sinut tervetulleeksi uudelleen.");
    }
}