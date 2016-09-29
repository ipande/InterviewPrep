package easy;

import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if((ransomNote == null || magazine == null))
            return false;
        else {
            HashMap<Character,Integer> magIndex = new HashMap<Character,Integer>();

            //1. Build the magazine index
            for(int i = 0; i < magazine.length(); i++){
                char currChar = magazine.charAt(i);
                if(!magIndex.containsKey(currChar)) magIndex.put(currChar,1);
                else{
                    magIndex.put(currChar,(magIndex.get(currChar)+1));
                }
            }

            //2. go through the ransomeNote and see if we have enough chars
            for(int i = 0; i < ransomNote.length(); i++){
                char currChar = ransomNote.charAt(i);
                if(!magIndex.containsKey(currChar)) return false;
                else {
                    int currLtrCnt = magIndex.get(currChar);
                    currLtrCnt--;
                    if(currLtrCnt < 0)
                        return false;
                    else
                        magIndex.put(currChar,currLtrCnt);
                }// end else
            }// end for
            return true;
        }
    }

    public static void main(String[] args) {
        String ransom = "aa";
        String magazine = "baa";
        if(canConstruct(ransom,magazine))
            System.out.println("passed the test");
        else
            System.out.println("Failed!");
    }
}
