package validators;
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
        try {
            int intChoice = Integer.parseInt(usersChoice);
            return (intChoice >= firstMenuNumber && intChoice <= lastMenuNumber);
        } catch (Exception e) {
            return false;
        }
    }
}
