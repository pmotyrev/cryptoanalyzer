package services;

import constants.Constants;
import validators.FileValidator;
import validators.KeyValidator;
import validators.PathValidator;

public class CryptoService {
    private final int clientsMainMenuChoice;
    private final ConsoleService consoleService;
    private String pathResult;
    private String text;

    public CryptoService(ConsoleService consoleService, int clientsMainMenuChoice) {
        this.consoleService = consoleService;
        this.clientsMainMenuChoice = clientsMainMenuChoice;
    }

    public void run() {
        if (clientsMainMenuChoice != 0) {
            initialize();
        }
        welcomeMenuChoice(clientsMainMenuChoice);
    }

    private void initialize() {
        String pathSource = consoleService.getPathFromUser(false, new PathValidator(), new FileValidator());
        pathResult = consoleService.getPathFromUser(true, new PathValidator(), new FileValidator());
        text = new FileService().readText(pathSource);
    }

    private void welcomeMenuChoice(int clientsChoice) {
        switch (clientsChoice) {
            case 0 -> System.exit(0);
            case 1 -> encryptionWithKey();
            case 2 -> decryptionWithKey();
            case 3 -> decryptionBruteForce();
            case 4 -> decryptionStatistic();
        }
    }

    private void encryptionWithKey() {
        int key = consoleService.getKeyFromUser(new KeyValidator());
        String result = new CoderWithKey(text, key, true).cryption();
        writeResultToFile(result);
    }

    private void decryptionWithKey() {
        int key = consoleService.getKeyFromUser(new KeyValidator());
        String result = new CoderWithKey(text, key, false).cryption();
        writeResultToFile(result);
    }

    private void decryptionBruteForce() {
        String result = new DecoderBruteForce(text).decryption();
        writeResultToFile(result);
    }

    private void decryptionStatistic() {
        String result = new DecoderStatistic(text).decryption();
        writeResultToFile(result);
    }

    private void writeResultToFile(String result) {
        new FileService().writeText(pathResult, result);
        System.out.println(Constants.SUCCESS);
    }


}
