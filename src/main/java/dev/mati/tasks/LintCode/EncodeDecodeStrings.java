package dev.mati.tasks.LintCode;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        List<String> input = List.of("lint","code","love","you");
        String encoded = encode(input);
        decode(encoded);
    }
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        char suffix = '#';
        for (String word: strs) {
            encoded.append(word.length()).append(suffix);
            for(int i = 0; i < word.length(); i++) {
                encoded.append(word.charAt(i));
            }
        }
        return encoded.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> decoded = new LinkedList<String>();
        int sequenceLength = 0;
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(Character.compare(str.charAt(i),'#') == 0) {
                sequenceLength = Integer.parseInt(word.toString());
                word.delete(0, word.length());
                for(int j = 0; j < sequenceLength && i + 1< str.length(); j++) {
                    i++;
                    word.append(str.charAt(i));
                }
                decoded.add(word.toString());
                word.delete(0,word.length());
            } else {
                word.append(str.charAt(i));
            }
        }
        return decoded;
    }
}
