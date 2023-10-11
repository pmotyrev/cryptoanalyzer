package services;

import coders.CoderWithKey;
import coders.DecoderBruteForce;
import coders.DecoderStatistic;
import validators.FileValidator;
import validators.KeyValidator;
import validators.PathValidator;

public class CryptoService {
    private final int clientsMainMenuChoice;
    private final ConsoleService consoleService;
    private String pathResult;
    private String text;
    private int key;

    public CryptoService(ConsoleService consoleService, int clientsMainMenuChoice) {
        this.consoleService = consoleService;
        this.clientsMainMenuChoice = clientsMainMenuChoice;
    }

    public void run() {
        if (clientsMainMenuChoice != 0) {
            initialize();
        }
        welcomeMenuChoice();
    }

    private void initialize() {
        String pathSource = consoleService.getPathFromUser(false, new PathValidator(), new FileValidator());
        pathResult = consoleService.getPathFromUser(true, new PathValidator(), new FileValidator());
        text = new FileService().readText(pathSource);
        if (clientsMainMenuChoice == 1 || clientsMainMenuChoice == 2){
            key = consoleService.getKeyFromUser(new KeyValidator());
        }
    }

    private void welcomeMenuChoice() {
        switch (clientsMainMenuChoice) {
            case 0 -> System.exit(0);
            case 1 -> cryption(new CoderWithKey(text, key, true));
            case 2 -> cryption(new CoderWithKey(text, key, false));
            case 3 -> cryption(new DecoderBruteForce(text, key, true));
            case 4 -> cryption(new DecoderStatistic(text, key, true));
        }
    }

    private void cryption(CoderWithKey coder) {
        String result = coder.decryption();
        new FileService().writeText(pathResult, result);
    }
}
