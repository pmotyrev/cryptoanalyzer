package services;

import constants.Constants;
import validators.ClientsChoiceValidator;
import validators.FileValidator;
import validators.KeyValidator;
import validators.PathValidator;

import java.util.Scanner;

public class ConsoleService {
    private static final Scanner consoleScanner = new Scanner(System.in);

    public void run() {
        System.out.println(Constants.WELCOME_MENU_MESSAGE);
        new CryptoService(this, getMainMenuChoice()).run();
    }

    /**
     * using fileValidator and pathValidator gets from user the correct file path.
     * @param isResult - if it is true uses for asking result path, if it false uses for asking source path
     * @param pathValidator - validator for the path that check that path is correct
     * @param fileValidator - validator for the file that check that path is correct
     * @return String with correct path.
     */
    public String getPathFromUser(boolean isResult, PathValidator pathValidator, FileValidator fileValidator) {
        boolean isNotForbidden = false;
        String path = "";
        askAboutPath(isResult);

        while (!isResult || !isNotForbidden) {
            path = consoleScanner.nextLine();
            if (pathValidator.isForbiddenPath(path)) {
                System.out.println(Constants.FORBIDDEN_PATH);
                continue;
            } else {
                isNotForbidden = true;
            }
            if (isResult || fileValidator.isPathCorrect(path)) {
                isResult = true;
            } else {
                System.out.println(Constants.INVALID_PATH);
            }
        }
        return path;
    }

    /**
     * using keyValidator gets from user the correct key for cryption.
     * @param keyValidator - validator for the key that check that path is correct
     * @return valid key.
     */
    public int getKeyFromUser(KeyValidator keyValidator) {
        int key;
        System.out.println(Constants.ASKED_KEY);
        while (true) {
            String stringKey = consoleScanner.nextLine();
            try {
                key = Integer.parseInt(stringKey);
                if (keyValidator.isValid(key)) {
                    return key;
                }
            } catch (Exception e) {
                System.out.println("Something go wrong");
            }
            System.out.println(Constants.INVALID_KEY);
        }
    }

    /**
     * using clientsChoiceValidator gets from user the correct menu choice.
     * @return int user selection from menu
     */
    private int getMainMenuChoice() {
        while (true) {
            String menuChoice = consoleScanner.nextLine();
            ClientsChoiceValidator clientsChoiceValidator = new ClientsChoiceValidator();
            if (clientsChoiceValidator.isValid(menuChoice,
                    Constants.FIRST_WELCOME_MENU_NUMBER, Constants.LAST_WELCOME_MENU_NUMBER)) {
                return Integer.parseInt(menuChoice);
            }
        }
    }

    private static void askAboutPath(boolean isResult) {
        if (isResult) {
            System.out.println(Constants.ASKED_RESULT_FILE_PATH);
        } else {
            System.out.println(Constants.ASKED_SOURCE_FILE_PATH);
        }
    }
}
