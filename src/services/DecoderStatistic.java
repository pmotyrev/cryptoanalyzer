package services;

import constants.Constants;

import java.util.Map;
import java.util.StringTokenizer;

public class DecoderStatistic extends CoderWithKey {
    public DecoderStatistic(String originText) {
        super(originText, 0, true);
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
        int counter = 0;

        while (true) {
            String decryptionText = this.cryption();
            countStatisticInDescriptionText(decryptionText);
            for (Map.Entry<String, Double> statisticsWordsEntries : Constants.COUNTING_STATISTIC_WORDS_MAP.entrySet()) {
                if (statisticsWordsEntries.getValue() >=
                        Constants.EXAMPLE_STATISTIC_WORDS_MAP.get(statisticsWordsEntries.getKey())) {
                    counter++;
                }
            }
            if (counter >= 4) {
                return decryptionText;
            }
            counter = 0;
            prepareValueForNextIteration();
        }
    }

    /**
     * increases by 1 variable key
     * if key >= Constants.ALPHABET.length stop decryption and show CANT_DECRYPT massage
     * resets the statistics of found words in the text
     */
    private void prepareValueForNextIteration() {
        key++;
        Constants.COUNTING_STATISTIC_WORDS_MAP.put("и", 0.0);
        Constants.COUNTING_STATISTIC_WORDS_MAP.put("не", 0.0);
        Constants.COUNTING_STATISTIC_WORDS_MAP.put("что", 0.0);
        Constants.COUNTING_STATISTIC_WORDS_MAP.put("он", 0.0);
        if (key >= Constants.ALPHABET.length) {
            System.out.println(Constants.CANT_DECRYPT);
            System.exit(0);
        }
    }

    /**
     * @param decryptionText
     * Counts the number of words ["и", "не", "что", "он"] found in the text decryptionText
     */
    private void countStatisticInDescriptionText(String decryptionText) {
        StringTokenizer stringTokenizer = new StringTokenizer(decryptionText, " .,!?:-'/\\\"«»`", false);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (Constants.COUNTING_STATISTIC_WORDS_MAP.containsKey(token)) {
                double value = Constants.COUNTING_STATISTIC_WORDS_MAP.get(token) + 1;
                Constants.COUNTING_STATISTIC_WORDS_MAP.put(token, value);
            }
        }
    }
}
