import java.util.*;


public class SecretMessage {
    private final Map<Character, Integer> alphabetMap= new Hashtable<>();
    private final Map<Integer, Character> alphabetMapNumIndex= new Hashtable<>();
    private String codeWord = "";
    private String codeWordAsNumber;
    private int dayOfMonth = 0;
    private String messageToEncode = "";
    private String messageToDecode = "";
    private ArrayList<Character> messageToEncodeAsCharArray;
    private ArrayList<Character> messageEncoded = new ArrayList<>();



    public Map<Character, Integer> getAlphabetMap() {
        return alphabetMap;
    }

    public Map<Integer, Character> getAlphabetMapNumIndex() {
        return alphabetMapNumIndex;
    }

    public String getMessageToEncode() {
        return messageToEncode;
    }
    public ArrayList<Character> getMessageToEncodeAsCharArray() {
        return messageToEncodeAsCharArray;
    }

    public String getCodeWord() {
        return codeWord;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void createAlphabetMap() {
        int index = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMap.put(c, index);
            index++;
        }
    }

    public void createAlphabetMapNumIndex() {
        int index = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMapNumIndex.put(index, c);
            index++;
        }
    }
    public void startProgram() {
        createAlphabetMap();
        createAlphabetMapNumIndex();
        boolean choiceMade = false;

        GetUserInput userInput = new GetUserInput();
        codeWord = userInput.getString("Enter the Code Word:");
        codeWord = codeWord.toLowerCase();
        dayOfMonth = Integer.parseInt(userInput.getInt("Enter day of month:"));

        do {
            String choice = (userInput.getString("Type ENCODE to encode a message and DECODE to decode a message. "));
            if (choice.equals("ENCODE")) {
                Encode();
                choiceMade = true;
            }
            else if (choice.equals("DECODE")) {
                Decode();
                choiceMade = true;
            }
        } while (choiceMade == false);
    }

    public void Encode() {
        GetUserInput userInput = new GetUserInput();
        messageToEncode = userInput.getString("Enter your message:");
        messageToEncodeAsCharArray = (wordCharArray(messageToEncode));
        SortString sort = new SortString();
        String sortedCodeWord = sort.sortString(codeWord);
        EnumerateCodeWord enumerCode = new EnumerateCodeWord();
        codeWordAsNumber = (enumerCode.enumerateCodeWord(codeWord, dayOfMonth, sortedCodeWord));
        encodedMessage(messageToEncodeAsCharArray);
        System.out.println("Your encoded message is\n" + messageEncodedAsString(messageEncoded).stripLeading());
    }

    public void Decode() {
        GetUserInput userInput = new GetUserInput();
        messageToEncode = userInput.getString("Enter your message:");
        messageToEncode = messageToEncode.replaceAll("\\s+","");
        messageToEncode = messageToEncode.toLowerCase();
        messageToEncodeAsCharArray = (wordCharArray(messageToEncode));
        SortString sort = new SortString();
        String sortedCodeWord = sort.sortString(codeWord);
        EnumerateCodeWord enumerCode = new EnumerateCodeWord();
        codeWordAsNumber = (enumerCode.enumerateCodeWord(codeWord, dayOfMonth, sortedCodeWord));
        DecodedMessage(messageToEncodeAsCharArray);
        System.out.println("Your decoded message is:\n" + messageEncoded.toString().replace(",", "").replace("[", "").replace("]", "").trim().replace(" ", ""));
    }
    //converts a string to a char array without any spaces
    public ArrayList<Character> wordCharArray(String word) {
        ArrayList<Character> charArray = new ArrayList<>();
        for (char c : word.trim().replaceAll("\\s+","").toCharArray()) {
            charArray.add(c);
        }
        return charArray;
    }

    public int letterToNumber(Character letter) {
        return alphabetMap.get(letter);
    }
    public Character NumberToLetter(int number) {
        if (number > 26) {
            number = number % 26;
        }
        if (number < 1) {
            number = number + 26;
        }
        return alphabetMapNumIndex.get(number);
    }
    //creates the encoded ArrayList<Character> from a passed Arraylist<Character> with letters incremented by
    //value in enumeratedCodeWord
    public void encodedMessage(ArrayList<Character> preEncodedMessage) {
        ListIterator<Character> i = preEncodedMessage.listIterator();
        char[] codeWordDigits = codeWordAsNumber.toCharArray();
        int codeWordIndex = 0;
            for (char c : preEncodedMessage) {
                int letterToNumber = letterToNumber(c);
                if (codeWordIndex > (codeWordDigits.length - 1)) {
                    codeWordIndex = codeWordIndex % (codeWordDigits.length);
                }
                int codeNumber = codeWordDigits[codeWordIndex] - '0';
                messageEncoded.add(NumberToLetter(letterToNumber + codeNumber));
                codeWordIndex++;
            }
    }

    public void DecodedMessage(ArrayList<Character> preEncodedMessage) {
        ListIterator<Character> i = preEncodedMessage.listIterator();
        char[] codeWordDigits = codeWordAsNumber.toCharArray();
        int codeWordIndex = 0;
        for (char c : preEncodedMessage) {
            int letterToNumber = letterToNumber(c);
            if (codeWordIndex > (codeWordDigits.length - 1)) {
                codeWordIndex = codeWordIndex % (codeWordDigits.length);
            }
            int codeNumber = codeWordDigits[codeWordIndex] - '0';
            messageEncoded.add(NumberToLetter(letterToNumber - codeNumber));
            codeWordIndex++;
        }
    }
    public String messageEncodedAsString(ArrayList<Character> messageEncoded) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (char c : messageEncoded) {
            if (index % 5 == 0) {
                str.append(" ");
                str.append(c);
            }
            else {
                str.append(c);
            }
            index++;
        }
        return str.toString();
    }


}
