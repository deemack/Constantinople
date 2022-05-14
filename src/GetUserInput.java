package org.dave.jartoexe;

public class GetUserInput {
    public GetUserInput() {

    }

    public String getString(String message) {
        Input input = new Input();
        Validation valid = new Validation();
        boolean proceed = false;
        String userInput = "";

        do {
            userInput = input.acceptStringInput(message);
            if (valid.isBlank(userInput)) {
                System.out.println("Input cannot be blank.");
            }
            else if (!valid.onlyAlpha(userInput)) {
                System.out.println("You must only use letters of the alphabet.");
            }
            else {
                proceed = true;
            }
        } while (!proceed);
        return userInput;
    }

    public String getInt(String message) {
        Input input = new Input();
        Validation valid = new Validation();
        boolean proceed = false;
        String userInput = "";

        do {
            userInput = (input.acceptStringInput(message));
            if (valid.isBlank(userInput)) {
                System.out.println("Day of month cannot be blank. ");
                continue;
            }
            if (valid.isNotInt(userInput)) {
                System.out.println("Day of month must be a number. ");
                continue;
            }
            if (valid.isOutOfRange(userInput)) {
                System.out.println("Valid days are 1 through to 31. ");
                continue;
            }
            else {
                proceed = true;
            }
        } while (!proceed);
        return userInput;
    }

    /*public String userInputPadded(String userInput) {
        while (userInput.length() %)
    }*/


}
