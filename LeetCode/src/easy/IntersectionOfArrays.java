package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        else {
            Set<Integer> num1Unique = new HashSet<Integer>();

            //1. build a hashset of all elements in nums1
            for(int i=0; i < nums1.length; i++){
                num1Unique.add(nums1[i]);
            }

            ArrayList<Integer> interList = new ArrayList<Integer>();
            for(int i=0; i < nums2.length; i++){
                if(num1Unique.contains(nums2[i])){
                    num1Unique.remove(nums2[i]);
                    interList.add(nums2[i]);
                }
            }
            int[] intarr = new int[interList.size()];
            for(int i=0; i<interList.size(); i++){
                intarr[i] = interList.get(i);
            }
            return intarr;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(intersection(num1, num2)));

    }
}
