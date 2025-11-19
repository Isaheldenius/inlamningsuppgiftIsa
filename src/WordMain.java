import java.util.Scanner;

public class WordMain {
    public static void main(String[] args) {

        // Skanner för att ta in text från användaren
        Scanner scanner = new Scanner(System.in);

        // Nytt objekt till klassen Logic som räknar raderna och tecken
        WordLogic countChar = new WordLogic();

        // Inmatning av text från användaren
        System.out.print("Skriv en rad text: ");
        boolean userText = countChar.userCount(scanner.nextLine());
        while (userText) {
            System.out.print("Skriv en till rad: ");
            userText = countChar.userCount(scanner.nextLine());
        }

        // Skriver ut antal tecken och rader
        System.out.println("Antal rader: " + countChar.getLines());
        System.out.println("Antal tecken: " + countChar.getCharacters());
        System.out.println("Antal ord: " + countChar.getWords());
        if (countChar.getLongestWord().length() > 0) {
            String[] longestWordArray = countChar.getLongestWords();
            if (longestWordArray.length <= 1)
                System.out.println("Det längsta ordet är: " + longestWordArray[0]);
            else {
                System.out.print("Det längsta orden är: ");
                for (int i = 0; i < longestWordArray.length; i++) {
                    System.out.print(longestWordArray[i] + " ");
                }
            }

        }


    }
}
