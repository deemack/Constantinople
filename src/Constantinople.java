public class Constantinople {

    public static void main(String[] args) {
        splash();
        SecretMessage secretMessage = new SecretMessage();
        secretMessage.startProgram();
        //System.out.println(secretMessage.getMessageToEncodeAsCharArray());
        //System.out.println(secretMessage.getAlphabetMap().get('f'));
        pressAnyKeyToContinue();
    }
    private static void pressAnyKeyToContinue()
    {
        System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void splash() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("-                               C H A P M A N S    C O D E                                      -");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("-  Greetings, you can use this program to encode and decode messages.                           -");
        System.out.println("-  To encode a message, choose a Code Word, and use the day of the month.                       -");
        System.out.println("-  For example: Code Word = constantinople, day of the month = 8.                               -");
        System.out.println("-  Similarly, to decode a message, you must use the same Code Word that was used to encode it,  -");
        System.out.println("-  as well as the same day on which it was it encoded.                                          -");
        System.out.println("-------------------------------------------------------------------------------------------------\n");
    }
}
