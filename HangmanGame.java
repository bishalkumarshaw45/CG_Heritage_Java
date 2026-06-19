import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int wins = 0;
    static int losses = 0;

    static String[][] wordData = {
            {"JAVA", "Programming Language"},
            {"PYTHON", "Programming Language"},
            {"JAVASCRIPT", "Programming Language"},
            {"COMPILER", "Programming Tool"},
            {"DATABASE", "Data Storage"},
            {"ALGORITHM", "Computer Science"},
            {"INTERFACE", "OOP Concept"},
            {"INHERITANCE", "OOP Concept"},
            {"ENCAPSULATION", "OOP Concept"},
            {"POLYMORPHISM", "OOP Concept"},
            {"ABSTRACTION", "OOP Concept"},
            {"EXCEPTION", "Java Concept"},
            {"MULTITHREADING", "Java Concept"},
            {"FRAMEWORK", "Software Development"},
            {"VARIABLE", "Programming Term"},

            {"KEYBOARD", "Computer Hardware"},
            {"MONITOR", "Computer Hardware"},
            {"PROCESSOR", "Computer Hardware"},
            {"ANDROID", "Operating System"},
            {"WINDOWS", "Operating System"},
            {"LINUX", "Operating System"},
            {"GITHUB", "Code Hosting Platform"},
            {"SERVER", "Networking"},
            {"CLOUD", "Internet Technology"},
            {"SECURITY", "Cybersecurity"},

            {"ELEPHANT", "Animal"},
            {"DOLPHIN", "Animal"},
            {"GIRAFFE", "Animal"},
            {"PENGUIN", "Animal"},
            {"CHEETAH", "Animal"},
            {"KANGAROO", "Animal"},
            {"CROCODILE", "Animal"},
            {"BUTTERFLY", "Animal"},
            {"SQUIRREL", "Animal"},
            {"ZEBRA", "Animal"},

            {"CRICKET", "Sport"},
            {"FOOTBALL", "Sport"},
            {"TENNIS", "Sport"},
            {"BADMINTON", "Sport"},
            {"BASKETBALL", "Sport"},
            {"VOLLEYBALL", "Sport"},

            {"INDIA", "Country"},
            {"JAPAN", "Country"},
            {"BRAZIL", "Country"},
            {"GERMANY", "Country"},
            {"AUSTRALIA", "Country"},
            {"CANADA", "Country"},

            {"GALAXY", "Space"},
            {"GRAVITY", "Science"},
            {"MOLECULE", "Chemistry"},
            {"PHYSICS", "Science Subject"},

            {"CHOCOLATE", "Food"},
            {"PIZZA", "Food"},
            {"NOTEBOOK", "Everyday Object"},
            {"UMBRELLA", "Everyday Object"},
            {"BICYCLE", "Vehicle"},
            {"AIRPORT", "Place"},
            {"LIBRARY", "Place"}
    };

    public static void main(String[] args) {

        char playAgain;

        do {
            playGame();

            System.out.println("\n========== SCOREBOARD ==========");
            System.out.println("Wins   : " + wins);
            System.out.println("Losses : " + losses);
            System.out.println("================================");

            System.out.print("\nPlay again? (Y/N): ");
            playAgain = scanner.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\nThanks for playing Hangman!");
        scanner.close();
    }

    static void playGame() {

        int difficulty = chooseDifficulty();

        int randomIndex = random.nextInt(wordData.length);

        String secretWord = wordData[randomIndex][0];
        String category = wordData[randomIndex][1];

        char[] displayWord = new char[secretWord.length()];

        for (int i = 0; i < displayWord.length; i++) {
            displayWord[i] = '_';
        }

        String guessedLetters = "";

        // Reveal first letter as a hint
        char hintLetter = secretWord.charAt(0);

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == hintLetter) {
                displayWord[i] = hintLetter;
            }
        }

        guessedLetters += hintLetter + " ";

        boolean wordGuessed = false;

        System.out.println("\n=================================");
        System.out.println("       WELCOME TO HANGMAN");
        System.out.println("=================================");
        System.out.println("Category : " + category);
        System.out.println("Hint     : The word starts with '" + hintLetter + "'");
        System.out.println();

        while (difficulty > 0 && !wordGuessed) {

            System.out.print("Word: ");
            for (char ch : displayWord) {
                System.out.print(ch + " ");
            }

            System.out.println("\nLives Left      : " + difficulty);
            System.out.println("Guessed Letters : " + guessedLetters);

            System.out.print("Enter a letter: ");
            String input = scanner.next().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single alphabet letter.\n");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.indexOf(guess) != -1) {
                System.out.println("You already guessed '" + guess + "'.\n");
                continue;
            }

            guessedLetters += guess + " ";

            boolean found = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    displayWord[i] = guess;
                    found = true;
                }
            }

            if (found) {
                System.out.println("Correct guess!\n");
            } else {
                difficulty--;
                System.out.println("Wrong guess!\n");
            }

            wordGuessed = true;

            for (char ch : displayWord) {
                if (ch == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        if (wordGuessed) {
            wins++;

            System.out.print("\nWord: ");
            for (char ch : displayWord) {
                System.out.print(ch + " ");
            }

            System.out.println("\n\nCongratulations! You guessed the word: " + secretWord);

        } else {
            losses++;

            System.out.println("\nGame Over!");
            System.out.println("The word was: " + secretWord);
        }
    }

    static int chooseDifficulty() {

        while (true) {

            System.out.println("\nChoose Difficulty Level");
            System.out.println("1. Easy   (8 lives)");
            System.out.println("2. Medium (6 lives)");
            System.out.println("3. Hard   (4 lives)");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    return 8;

                case 2:
                    return 6;

                case 3:
                    return 4;

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}