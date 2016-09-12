package easy;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        else{
            boolean prevZ = false;
            int zptr = 0;

            // move all non-zeros to the beginning
            for(int i=0; i < nums.length; i++){
                if(nums[i] == 0){
                    prevZ = true;
                    if(zptr == 0 && !prevZ) zptr = i;
                } // end if
                else {
                    if(prevZ){
                        prevZ = false;
                    }
                    nums[zptr++] = nums[i];
                } // end else
            } // end for #1

            // copy zeros at the end
            for(int i = zptr; i < nums.length; i++){
                nums[zptr++] = 0;
            } // end for #2
        } // end else
    }

    public static void main(String[] args) {
        //int[] num = {0,1,0};
        int[] num = {0,1,3,0,12};
        moveZeroes(num);
        System.out.println("after moving zeros: " + Arrays.toString(num));
    }
}
