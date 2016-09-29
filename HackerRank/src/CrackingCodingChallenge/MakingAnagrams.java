package CrackingCodingChallenge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {
        if(first !=null && second!=null){
            HashMap<Character,Integer> fMap = new HashMap<>();
            for(int i=0; i < first.length(); i++){
                char c = first.charAt(i);
                if(fMap.containsKey(c))
                    fMap.put(c,(fMap.get(c)+1));
                else
                    fMap.put(c,1);
            } // end for building charCountMap

            int numNeeded = 0;
            for(int i=0; i < second.length(); i++){
                char c = second.charAt(i);
                if(fMap.containsKey(c)){
                    int curr = fMap.get(c);
                    curr--;
                    if(curr < 0)
                        numNeeded++;
                    fMap.put(c,curr);
                }
                else
                    numNeeded++;
            } // end for counting mismatches

            Iterator it = fMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                int diff = (Integer) pair.getValue();
                if((Integer) pair.getValue() > 0) {
                    numNeeded = diff + numNeeded;
                }
            }
            return numNeeded;
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(numberNeeded(a, b));
    }

}
