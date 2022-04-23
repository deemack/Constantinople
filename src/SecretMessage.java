import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class SecretMessage {
    private final Map<Character, Integer> alphabetMap= new Hashtable<>();
    private String codeWord = "";
    private int dayOfMonth = 0;
    private String messageToEncode = "";
    private ArrayList<Character> messageToEncodeAsCharArray;
    private ArrayList<Character> messageEncoded = new ArrayList<>();



    public Map<Character, Integer> getAlphabetMap() {
        return alphabetMap;
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

    public void startProgram() {
        int index = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMap.put(c, index);
            index++;
        }
        System.out.println(getAlphabetMap());

        GetUserInput userInput = new GetUserInput();
        codeWord = userInput.getString("Enter your Code Word.");
        dayOfMonth = Integer.parseInt(userInput.getInt("Enter day of month."));
        messageToEncode = userInput.getString("Enter your message.");
        messageToEncodeAsCharArray = (wordCharArray(messageToEncode));

        SortString sort = new SortString();
        String sortedCodeWord = sort.sortString(codeWord);

        EnumerateCodeWord enumerCode = new EnumerateCodeWord();
        System.out.println(enumerCode.enumerateCodeWord(codeWord, dayOfMonth, sortedCodeWord));

        System.out.println(messageToEncodeAsCharArray);

    }
    //converts a string to a char array without any spaces
    public ArrayList<Character> wordCharArray(String word) {
        ArrayList<Character> charArray = new ArrayList<>();
        for (char c : word.trim().replaceAll("\\s+","").toCharArray()) {
            charArray.add(c);
        }
        return charArray;
    }

    //creates ArrayList<Character> from a passed Arraylist<Character> with letters incremented by
    //value in enumeratedCodeWord
    //public ArrayList<Character>


}
