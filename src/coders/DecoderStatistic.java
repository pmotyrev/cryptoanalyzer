package coders;

import constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DecoderStatistic extends CoderWithKey {
    public static final String CANT_DECRYPT = "Sorry, but I can't decrypt this file. Try another option";
    public static final Map<String, Double> EXAMPLE_STATISTIC_WORDS_MAP = new HashMap<>() {{
        put("и", 0.2);
        put("не", 0.1);
        put("что", 0.07);
        put("он", 0.07);
    }};
    public static final Map<String, Double> MAP_STATISTIC_WORDS = new HashMap<>() {{
        put("и", 0.0);
        put("не", 0.0);
        put("что", 0.0);
        put("он", 0.0);
    }};

    public DecoderStatistic(String originText, int key, boolean isEncrypt) {
        super(originText, key, isEncrypt);
    }

    /**
     * @return String - decryption text
     *  Take String originText and decrypt it using word usage statistics
     *  "и" frequency of use 0.2
     *  "не" frequency of use 0.1
     *  "что" frequency of use 0.07
     *  "он" frequency of use 0.07
     */
    public String decryption() {
        while (true) {
            int counter = 0;
            String decryptionText = cryption();
            countWordsStatistic(decryptionText);
            for (Map.Entry<String, Double> statisticsWordsEntries : MAP_STATISTIC_WORDS.entrySet()) {
                if (statisticsWordsEntries.getValue() >=
                        EXAMPLE_STATISTIC_WORDS_MAP.get(statisticsWordsEntries.getKey())) {
                    counter++;
                }
            }
            if (counter >= 4) {
                return decryptionText;
            }
            prepareValuesForNextIteration();
        }
    }

    /**
     * increases by 1 variable key
     * if key >= Constants.ALPHABET.length stop decryption and show CANT_DECRYPT massage
     * resets the statistics of found words in the text
     */
    private void prepareValuesForNextIteration() {
        key++;
        MAP_STATISTIC_WORDS.put("и", 0.0);
        MAP_STATISTIC_WORDS.put("не", 0.0);
        MAP_STATISTIC_WORDS.put("что", 0.0);
        MAP_STATISTIC_WORDS.put("он", 0.0);
        if (key >= Constants.ALPHABET.length) {
            System.out.println(CANT_DECRYPT);
            System.exit(0);
        }
    }

    /**
     * @param decryptionText
     * Counts the number of words ["и", "не", "что", "он"] found in the text decryptionText
     */
    private void countWordsStatistic(String decryptionText) {
        StringTokenizer stringTokenizer = new StringTokenizer(decryptionText, " .,!?:-'/\\\"«»`", false);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (MAP_STATISTIC_WORDS.containsKey(token)) {
                double value = MAP_STATISTIC_WORDS.get(token) + 1;
                MAP_STATISTIC_WORDS.put(token, value);
            }
        }
    }
}
