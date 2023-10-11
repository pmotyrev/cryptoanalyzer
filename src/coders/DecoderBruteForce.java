package coders;

public class DecoderBruteForce extends CoderWithKey {
    private int validAmountGaps;
    private int invalidAmountGaps;

    public DecoderBruteForce(String originText, int key, boolean isEncrypt) {
        super(originText, key, isEncrypt);
    }

    /**
     * @return String - decryption text
     * Count amount of gapes after characters'.', ',', '?', '!', '-' , ':'
     * if amount of gapes more than 66,66% the file is considered decrypted
     */
    @Override
    public String decryption() {
        while (true) {
            String decryptionText = cryption();
            round(decryptionText);
            if (validAmountGaps > invalidAmountGaps * 2) {
                return decryptionText;
            } else {
                key++;
                validAmountGaps = 0;
                invalidAmountGaps = 0;
            }
        }
    }

    /**
     * @param decryptionText
     * Count amount valid and invalid gapes after characters'.', ',', '?', '!', '-' , ':'
     * if is doesn't have the gape after these characters the gape is considered invalid
     */
    private void round(String decryptionText) {
        for (int i = 0; i < decryptionText.length() - 1; i++) {
            if (decryptionText.charAt(i) == '.' || decryptionText.charAt(i) == ',' ||
                    decryptionText.charAt(i) == '?' || decryptionText.charAt(i) == '!' ||
                    decryptionText.charAt(i) == '-' || decryptionText.charAt(i) == ':') {
                if (decryptionText.charAt(i + 1) == ' ') {
                    validAmountGaps++;
                } else {
                    invalidAmountGaps++;
                }
            }
        }
    }
}
