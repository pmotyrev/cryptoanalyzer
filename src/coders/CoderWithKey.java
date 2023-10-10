package coders;

import constants.Constants;
import java.util.HashMap;
import java.util.Map;

public class CoderWithKey {
    protected final String originText;
    protected boolean isEncrypt;
    protected int key;
    private static final Map<Character, Integer> MAP_ALPHABET = convert();


    public CoderWithKey(String originText, int key, boolean isEncrypt) {
        this.originText = originText;
        this.key = key;
        this.isEncrypt = isEncrypt;
    }

    public CoderWithKey(String originText) {
        this.originText = originText;
    }

    private static Map<Character, Integer> convert() {
        Map<Character, Integer> mapAlphabet = new HashMap<>();
        for (int i = 0; i < Constants.ALPHABET.length; i++) {
            mapAlphabet.put(Constants.ALPHABET[i], i);
        }
        return mapAlphabet;
    }

    /**
     * @return String with encrypted or decrypted text.
     * If param isEncrypt - true, the method does encryption, else decryption.
     * Method does encryption and decryption text in param originText using param key
     * according to the Caesar code algorithm.
     */
    public String cryption() {
        StringBuilder sb = new StringBuilder();
        int oldPosition;

        if (!isEncrypt) {
            key = -key;
        }

        for (int i = 0; i < originText.length(); i++) {
            if (MAP_ALPHABET.get(originText.charAt(i)) != null) {
                oldPosition = MAP_ALPHABET.get(originText.charAt(i));
                sb.append(Constants.ALPHABET[getPositionInAlphabet(oldPosition)]);
            } else {
                sb.append(originText.charAt(i));
            }

        }

        return sb.toString();
    }

    /**
     * @param oldPosition - number of the old position
     * @return int number with new position of character.
     */
    private int getPositionInAlphabet(int oldPosition) {
        if (oldPosition + key < 0) {
            return oldPosition + key + Constants.ALPHABET.length;
        } else if (oldPosition + key >= Constants.ALPHABET.length) {
            return (oldPosition + key) - Constants.ALPHABET.length;
        } else {
            return oldPosition + key;
        }
    }

}
