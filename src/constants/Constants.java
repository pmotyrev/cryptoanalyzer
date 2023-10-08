package constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Constants {
    public static final char[] ALPHABET = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н',
            'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
            'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' ', ',', '.', '-', '!', '?', '"', ':'};
    public static final Map<Character, Integer> MAP_ALPHABET = convert();
    public static final String[] forbiddenDirectories = {"bash_history", "bash_logout", "bash_profile", "bashrc",
            "gtkrc", "login", "logout", "profile", "viminfo", "wm_style", "Xdefaults", "Xresources", "xinitrc",
            "xsession", "dev", "etc", "proc", "var", "bin", "boot", "home", "lib", "mnt", "proc", "root", "sbin",
            "tmp", "usr", "var"};
    public static final Set<String> setForbiddenDirectories = new HashSet<>(Arrays.asList(forbiddenDirectories));
    public static final String WELCOME_MENU_MESSAGE = """

            Welcome to CryptoAnalyzer
             ™ JavaRush && P.Motyrev

            Please enter the number of option what you want to do:
            1 enter to: encrypt your file
            2 enter to: decrypt your file using key
            3 enter to: hack encrypted file \uD83D\uDE0E
            4 enter to: hack encrypted file using statistics \uD83D\uDE0E \uD83D\uDE0E \uD83D\uDE0E
            0 enter to: EXIT""";

    public static final String NOT_NUMBER = "You entered not number. Please try again.";
    public static final String INVALID_NUMBER = "You entered invalid number. Please try again.";
    public static final String ASKED_SOURCE_FILE_PATH = "Please enter the path for source file";
    public static final String ASKED_RESULT_FILE_PATH = "Please enter the path for result file";
    public static final String INVALID_PATH = "This path is invalid. Please enter valid file's path";
    public static final String FORBIDDEN_PATH = "This path is FORBIDDEN. Please enter another file's path";
    public static final String ASKED_KEY = "Please enter the key";
    public static final String INVALID_KEY = "You entered invalid key. Please try again";
    public static final String SUCCESS = "Cryprion is success \uD83D\uDE0E";
    public static final String CANT_DECRYPT = "Sorry, but I can't decrypt this file. Try another option";
    public static final int FIRST_WELCOME_MENU_NUMBER = 0;
    public static final int LAST_WELCOME_MENU_NUMBER = 4;
    public static final Map<String, Double> EXAMPLE_STATISTIC_WORDS_MAP = new HashMap<>() {{
        put("и", 0.2);
        put("не", 0.1);
        put("что", 0.07);
        put("он", 0.07);
    }};
    public static final Map<String, Double> COUNTING_STATISTIC_WORDS_MAP = new HashMap<>() {{
        put("и", 0.0);
        put("не", 0.0);
        put("что", 0.0);
        put("он", 0.0);
    }};
    private static Map<Character, Integer> convert() {
        Map<Character, Integer> mapAlphabet = new HashMap<>();
        for (int i = 0; i < ALPHABET.length; i++) {
            mapAlphabet.put(ALPHABET[i], i);
        }
        return mapAlphabet;
    }
}
