package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    enum encryptionType {
        Caesar,
        Vigenere
    }
    public encryptionType selectedEncryptionType;

    public int caesarDisplacement = 3;

    public static void main(String[] args) {
        Main main = new Main();
        main.runProgram();
    }
    public void runProgram()
    {
        System.out.println("Running encryption/decryption program..");
        askForCipherType();
    }
    public void askForCipherType()
    {
        System.out.println(ANSI_BLUE + "Please enter a cipher type." + ANSI_RESET);
        System.out.println(ANSI_RED + "1" + ANSI_BLUE + ": Caesar cipher" + ANSI_RESET);
        System.out.println(ANSI_RED + "2" + ANSI_BLUE + ": Vigenère cipher" + ANSI_RESET);
        System.out.println(ANSI_RED + "0" + ANSI_BLUE + ": Exit program" + ANSI_RESET);
        System.out.print(ANSI_RED + "Enter" + ANSI_RESET + " a " + ANSI_BLUE + "cypher type: " + ANSI_RESET);
        boolean answered = false;
        while (!answered)
        {
            System.out.println(ANSI_BLUE + "What cipher do you want to use?" + ANSI_RESET);
            String answer;
            answer = sc.nextLine();
            switch (answer) {
                case "1" -> {
                    System.out.println(ANSI_BLUE + "Picked Caesar cipher." + ANSI_RESET);
                    selectedEncryptionType = encryptionType.Caesar;
                    answered = true;
                }
                case "2" -> {
                    System.out.println(ANSI_RED + "Picked Vigenère cipher." + ANSI_RESET);
                    selectedEncryptionType = encryptionType.Vigenere;
                    answered = true;
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
    public void askEncryptOrDecrypt()
    {
        System.out.println("Do you want to encrypt or decrypt?");

    }
    public void setCaesarDisplacement()
    {
        System.out.print("Enter how much do you want to displace the letters?: ");
    }
    public String encryptCaesarCipher(String text, int displacement)
    {
        System.out.print("Enter text to be encrypted by the Caesar Cipher: ");
        sc.nextLine();

        String encryptedText = "";

        for (int i = 0; i < text.length(); i++)
        {
            // encrypt letter
            encryptedText = "";
        }

        return encryptedText;
    }
    public String decryptCaesarCipher(String text, int displacement)
    {
        System.out.print("Enter text to be decrypted by the Caesar Cipher: ");
        sc.nextLine();

        String decryptedText = "";

        for (int i = 0; i < text.length(); i++)
        {
            // decrypt letter
            decryptedText = "";
        }

        return decryptedText;
    }
}
