public class Constantinople {

    public static void main(String[] args) {
        SecretMessage secretMessage = new SecretMessage();
        secretMessage.startProgram();
        System.out.println(secretMessage.getMessageToEncodeAsCharArray());
        System.out.println(secretMessage.getAlphabetMap().get('f'));
    }

}
