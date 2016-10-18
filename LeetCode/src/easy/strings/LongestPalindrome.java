package easy.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int lngth = 0;
        if(s!=null){
            HashMap<Character,Integer> letterMap = new HashMap<>();
            //1. construct map of letters
            for(int i=0; i < s.length(); i++){
                char c = s.charAt(i);
                if(letterMap.containsKey(c)){
                    letterMap.put(c,(letterMap.get(c)+1));
                }else{
                    letterMap.put(c, 1);
                }
            }// end for

            Iterator itr = letterMap.entrySet().iterator();
            boolean hasOdd = false;
            while(itr.hasNext()){
                Map.Entry<Character,Integer> pair = (Map.Entry)itr.next();
                if(pair.getValue()%2 == 0)
                    lngth = lngth + pair.getValue();
                else{
                    hasOdd = true;
                    lngth = lngth + (pair.getValue() - 1 );
                }
            }// end while
            if(hasOdd)
                lngth++;
        }// end if

        return lngth;
    }
}
