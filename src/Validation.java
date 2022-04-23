public class Validation {
    public Validation() {

    }

    public boolean isBlank(String input) {
        return input.trim().length() == 0;
    }

    public boolean isNotInt(String input) {
        try{
            int inputInt = Integer.parseInt(input);
            return false;
        }catch (NumberFormatException ex) {
            return true;
        }
    }

    public boolean isOutOfRange(String input) {
        return ((Integer.parseInt(input.trim()) > 31) || (Integer.parseInt(input.trim()) < 1));
    }
}
