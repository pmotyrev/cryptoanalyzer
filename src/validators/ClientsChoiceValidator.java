package validators;

import constants.Constants;

public class ClientsChoiceValidator {
    /**
     * @param usersChoice - String value from user to check
     * @param firstMenuNumber - int value first menu number
     * @param lastMenuNumber - int value last menu number
     * @return true if usersChoice number between firstMenuNumber and lastMenuNumber.
     * If usersChoice not number or entered number less than firstMenuNumber or more than
     * lastMenuNumber the method return false.
     */
    public boolean isValid(String usersChoice, int firstMenuNumber, int lastMenuNumber) {
        int intChoice;
        try {
            intChoice = Integer.parseInt(usersChoice);
        } catch (Exception e) {
            System.out.println(Constants.NOT_NUMBER);
            return false;
        }
        if (intChoice < firstMenuNumber || intChoice > lastMenuNumber) {
            System.out.println(Constants.INVALID_NUMBER);
            return false;
        }
        return true;
    }
}
