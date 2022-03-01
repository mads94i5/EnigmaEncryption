package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    enum encryptionType {
        Caesar,
        Vigenere
    }

    public char[] chars = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å' };

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\033[0;32m";

    public encryptionType selectedEncryptionType;
    public int selectedCaesarDisplacement;

    public Scanner sc;

    public static void main(String[] args) {
        Main main = new Main();
        main.runProgram();
    }
    public void runProgram() {
        System.out.println("Running encryption/decryption program..");
        sc = new Scanner(System.in);
        askForCypherType();
    }
    public void askForCypherType() {
        System.out.println("Please enter a cypher type." + ANSI_RESET);
        System.out.println(ANSI_RED + "1" + ANSI_BLUE + ": Caesar cypher" + ANSI_RESET);
        System.out.println(ANSI_RED + "2" + ANSI_BLUE + ": Vigenère cypher" + ANSI_RESET);
        System.out.println(ANSI_RED + "0" + ANSI_BLUE + ": Exit program" + ANSI_RESET);
        boolean answered = false;
        while (!answered)
        {
            System.out.print(ANSI_RED + "Enter" + ANSI_RESET + " a " + ANSI_BLUE + "cypher type: " + ANSI_RESET);
            String answer;
            answer = sc.nextLine();
            switch (answer) {
                case "1" -> {
                    System.out.println(ANSI_GREEN + "Picked Caesar cypher." + ANSI_RESET);
                    selectedEncryptionType = encryptionType.Caesar;
                    answered = true;
                    setEncryptOrDecrypt();
                }
                case "2" -> {
                    System.out.println(ANSI_GREEN + "Picked Vigenère cypher." + ANSI_RESET);
                    selectedEncryptionType = encryptionType.Vigenere;
                    answered = true;
                    setEncryptOrDecrypt();
                }
                case "0" -> {
                    System.out.println(ANSI_RED + "Exiting encryption/decryption program." + ANSI_RESET);
                    answered = true;
                }
            }
            if (!answered)
            {
                System.out.println(ANSI_YELLOW + "You can only enter '" + ANSI_RED + "1" + ANSI_YELLOW + "', '" + ANSI_RED + "2" + ANSI_YELLOW + "' or '" + ANSI_RED + "0" + ANSI_YELLOW + "'. You entered: " + ANSI_RED + answer + ANSI_YELLOW + ". Try again." + ANSI_RESET);
            }
        }
    }
    public void setEncryptOrDecrypt() {
        System.out.println("Do you want to encrypt or decrypt?");
        System.out.println(ANSI_RED + "1" + ANSI_BLUE + ": Encrypt" + ANSI_RESET);
        System.out.println(ANSI_RED + "2" + ANSI_BLUE + ": Decrypt" + ANSI_RESET);
        System.out.println(ANSI_RED + "0" + ANSI_BLUE + ": Exit menu" + ANSI_RESET);
        boolean answered = false;
        while (!answered)
        {
            System.out.print(ANSI_RED + "Enter" + ANSI_RESET + " an " + ANSI_BLUE + "action: " + ANSI_RESET);
            String answer;
            answer = sc.next();
            switch (answer) {
                case "1" -> {
                    System.out.println(ANSI_GREEN + "Picked Encryption." + ANSI_RESET);
                    answered = true;
                    switch (selectedEncryptionType) {
                        case Caesar -> {
                            setCaesarDisplacement();
                            setCaesarEncryptionString();
                        }
                        case Vigenere -> {
                            // call Vigenere encryption

                        }
                    }
                }
                case "2" -> {
                    System.out.println(ANSI_GREEN + "Picked Decryption." + ANSI_RESET);
                    answered = true;
                    switch (selectedEncryptionType) {
                        case Caesar -> {
                            setCaesarDisplacement();
                            setCaesarDecryptionString();
                        }
                        case Vigenere -> {
                            // call Vigenere decryption

                        }
                    }

                }
                case "0" -> {
                    System.out.println(ANSI_RED + "Exiting encryption/decryption menu." + ANSI_RESET);
                    answered = true;
                    askForCypherType();
                }
            }
            if (!answered)
            {
                System.out.println(ANSI_YELLOW + "You can only enter '" + ANSI_RED + "1" + ANSI_YELLOW + "', '" + ANSI_RED + "2" + ANSI_YELLOW + "' or '" + ANSI_RED + "0" + ANSI_YELLOW + "'. You entered: " + ANSI_RED + answer + ANSI_YELLOW + ". Try again." + ANSI_RESET);
            }
        }
    }
    public void setCaesarDisplacement() {
        System.out.print("Enter how much do you want to displace the letters?: ");
        selectedCaesarDisplacement = sc.nextInt();
    }
    public void setCaesarEncryptionString() {
        System.out.print("Enter text to be encrypted by the Caesar cypher: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toUpperCase();
        System.out.println(ANSI_GREEN + "Encrypted text: " + ANSI_RESET + encryptCaesarCypher(text, selectedCaesarDisplacement));
        askToRunAgain();
    }
    public String encryptCaesarCypher(String text, int displacement) {
        String encryptedText = "";
        for (int i = 0; i < text.length(); i++)
        {
            if (displacement + convertToNumber(text.charAt(i)) < chars.length) {
                encryptedText += convertToLetter(convertToNumber(text.charAt(i)) + displacement);
            }
            else {
                int newPlacement = (convertToNumber(text.charAt(i)) + displacement) - chars.length;
                encryptedText += convertToLetter(newPlacement);
            }
        }
        return encryptedText;
    }
    public int convertToNumber(char ch) {
        int returnValue = -1;
        for (int i = 0; i < chars.length; i++)
        {
            if (ch == chars[i])
            {
                returnValue = i;
            }
        }
        return returnValue;
    }
    public char convertToLetter(int number) {
        return chars[number];
    }
    public void setCaesarDecryptionString() {
        System.out.print("Enter text to be decrypted by the Caesar cypher: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toUpperCase();
        System.out.println(ANSI_GREEN + "Decrypted text: " + ANSI_RESET + decryptCaesarCypher(text, selectedCaesarDisplacement));
        askToRunAgain();
    }
    public String decryptCaesarCypher(String text, int displacement) {
        String decryptedText = "";
        for (int i = 0; i < text.length(); i++)
        {
            if (convertToNumber(text.charAt(i)) - displacement >= 0) {
                decryptedText += convertToLetter(convertToNumber(text.charAt(i)) - displacement);
            }
            else {
                int newPlacement = (convertToNumber(text.charAt(i)) - displacement) + chars.length;
                decryptedText += convertToLetter(newPlacement);
            }
        }
        return decryptedText;
    }
    public void askToRunAgain() {
        boolean answeredYesNo = false;
        while (!answeredYesNo)
        {
            System.out.printf(ANSI_BLUE + "Do you want to run the program again? (" + ANSI_RED + "Y" + ANSI_BLUE + "/" + ANSI_RED + "N" + ANSI_BLUE + "): " + ANSI_RESET);
            String yesNo = sc.next();
            if ((yesNo.equals("Y")) || (yesNo.equals("y")))
            {
                System.out.println(ANSI_GREEN + "Ok. Restarting program." + ANSI_RESET);
                answeredYesNo = true;
                runProgram();
            }
            else if ((yesNo.equals("N")) || (yesNo.equals("n")))
            {
                System.out.println(ANSI_RED + "Exiting program." + ANSI_RESET);
                answeredYesNo = true;
            }
            if (!answeredYesNo)
            {
                System.out.println(ANSI_YELLOW + "You can only enter '" + ANSI_RED + "Y" + ANSI_YELLOW + "' or '" + ANSI_RED + "N" + ANSI_YELLOW + "'. You entered: " + ANSI_RED + yesNo + ANSI_YELLOW + ". Try again." + ANSI_RESET);
            }
        }
    }
}
