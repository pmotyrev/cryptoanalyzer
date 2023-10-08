package validators;

import constants.Constants;

public class KeyValidator {
    /**
     * @param key - int value of key cryprion to check.
     * @return true if key is between 0 and the length of the Constants.ALPHABET.length.
     */
    public boolean isValid(int key) {
        return key > 0 && key < Constants.ALPHABET.length;
    }
}
