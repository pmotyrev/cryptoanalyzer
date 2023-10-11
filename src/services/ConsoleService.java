package services;

import constants.Constants;
import validators.ClientsChoiceValidator;
import validators.FileValidator;
import validators.KeyValidator;
import validators.PathValidator;
import java.util.Scanner;

public class ConsoleService {
    private static final Scanner consoleScanner = new Scanner(System.in);
    private static final String WELCOME_MENU_MESSAGE = """

            Welcome to CryptoAnalyzer
             ™ JavaRush && P.Motyrev

            Please enter the number of option what you want to do:
            1 enter to: encrypt your file
            2 enter to: decrypt your file using key
            3 enter to: hack encrypted file \uD83D\uDE0E
            4 enter to: hack encrypted file using statistics \uD83D\uDE0E \uD83D\uDE0E \uD83D\uDE0E
            0 enter to: EXIT""";
    private static final String INVALID_NUMBER_MASSAGE = "You entered invalid number. Please try again.";
    private static final String INVALID_PATH_MASSAGE = "This path is invalid. Please enter valid file's path";
    private static final String FORBIDDEN_PATH_MASSAGE = "This path is FORBIDDEN. Please enter another file's path";
    private static final String INVALID_KEY_MASSAGE = "You entered invalid key. Please try again";
    private static final String SUCCESS_MASSAGE = "Cryprion is success \uD83D\uDE0E";
    private static final String ASKED_KEY = "Please enter the key from 1 to " + (Constants.ALPHABET.length-1);
    private static final String ASKED_SOURCE_FILE_PATH = "Please enter the path for source file";
    private static final String ASKED_RESULT_FILE_PATH = "Please enter the path for result file";
    private static final int FIRST_WELCOME_MENU_NUMBER = 0;
    private static final int LAST_WELCOME_MENU_NUMBER = 4;

    public void run() {
        System.out.println(WELCOME_MENU_MESSAGE);
        new CryptoService(this, getMainMenuChoice()).run();
        System.out.println(SUCCESS_MASSAGE);
    }

    /**
     * using fileValidator and pathValidator gets from user the correct file path.
     * @param isResult - if it is true uses for asking result path, if it false uses for asking source path
     * @param pathValidator - validator for the path that check that path is correct
     * @param fileValidator - validator for the file that check that path is correct
     * @return String with correct path.
     */
    public String getPathFromUser(boolean isResult, PathValidator pathValidator, FileValidator fileValidator) {

        if (isResult) {
            System.out.println(ASKED_RESULT_FILE_PATH);
        } else {
            System.out.println(ASKED_SOURCE_FILE_PATH);
        }

        while (true) {
            String path = consoleScanner.nextLine();
            if (pathValidator.isForbiddenPath(path)) {
                System.out.println(FORBIDDEN_PATH_MASSAGE);
            } else if (fileValidator.isPathCorrect(path)) {
                return path;
            } else {
                System.out.println(INVALID_PATH_MASSAGE);
            }
        }
    }

    /**
     * using keyValidator gets from user the correct key for cryption.
     * @param keyValidator - validator for the key that check that path is correct
     * @return valid key.
     */
    public int getKeyFromUser(KeyValidator keyValidator) {
        System.out.println(ASKED_KEY);
        while (true) {
            String stringKey = consoleScanner.nextLine();
            try {
                int key = Integer.parseInt(stringKey);
                if (keyValidator.isValid(key)) {
                    return key;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(INVALID_KEY_MASSAGE);
        }
    }

    /**
     * using clientsChoiceValidator gets from user the correct menu choice.
     * @return int user selection from menu
     */
    private int getMainMenuChoice() {
        while (true) {
            String menuChoice = consoleScanner.nextLine();
            if (new ClientsChoiceValidator().isValid(menuChoice,
                    FIRST_WELCOME_MENU_NUMBER, LAST_WELCOME_MENU_NUMBER)) {
                return Integer.parseInt(menuChoice);
            }else {
                System.out.println(INVALID_NUMBER_MASSAGE);
            }
        }
    }
}
