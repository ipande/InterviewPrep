package easy.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    private static final Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    private static Boolean isVowel(char c){
        return vowels.contains(c);
    }

    public static String reverseVowels(String s) {

        if(s!=null){
            char[] sArray = s.toCharArray();
            for(int i=0 , j=s.length()-1; i <= j;){
                char frntChar = sArray[i];
                char backChar = sArray[j];

                if(isVowel(frntChar) && isVowel(backChar)){
                    // swap
                    sArray[i++] = backChar;
                    sArray[j--] = frntChar;
                }
                else if(isVowel(frntChar))
                    j--;
                else if(isVowel(backChar))
                    i++;
                else {
                    i++;
                    j--;
                }
            }// end for
            s = new String(sArray);
        }// end if
        return s;
    }

    public static void main(String[] args) {
        reverseVowels("aA");
    }
}
