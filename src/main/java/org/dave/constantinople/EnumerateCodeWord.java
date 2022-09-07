package org.dave.constantinople;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.*;

public class EnumerateCodeWord {
    public EnumerateCodeWord() {

    }
// This Array sorting logic was done by Jess. Thanks Jess you Rock.
    public String enumerateCodeWord(String codeWord, int date, String sortedCodeWord) {
        int index = 0;
        ArrayList<Character> seenList = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        char[] codeWordArray = codeWord.toCharArray();

        Map<Character, Integer> hash = new Hashtable<>();
        char[] sortedArray = sortedCodeWord.toCharArray();
        for (char c : sortedArray) {
            if (!hash.containsKey(c)) {
                hash.put(c, index + 1);
            }
            index++;
        }

        for (char c : codeWordArray) {
            if (!seenList.contains(c)) {
                finalList.add(hash.get(c));
            }
            else {
                hash.put(c, (hash.get(c) + 1));
                finalList.add(hash.get(c));
            }
            seenList.add(c);
        }

        String finalString = (finalList.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t"));
        finalString = finalString.replaceAll("\\s+","");
        BigInteger finalBigInteger = new BigInteger(finalString);
        BigInteger day = new BigInteger(String.valueOf(date));
        finalBigInteger = (finalBigInteger.multiply(day));
        return finalBigInteger.toString();
    }
}
