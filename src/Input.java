package org.dave.jartoexe;

import java.util.Scanner;

public class Input {
    public Input() {

    }
    public String acceptStringInput(String displayMessage) {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        return console.nextLine();
    }

    public int acceptIntegerInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String input = console.nextLine();
        return Integer.parseInt(input);
    }


}
