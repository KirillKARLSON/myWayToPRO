package Algorythms;



/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
*/


import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class DeleteDuplicatesFromSortArr {
    public static void main(String[] args) {

        int [] f = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = removeDupl(f);
        System.out.println(k);

    }

    public static int removeDupl(int[] nums){

        TreeSet <Integer> bufSet = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            bufSet.add(nums[i]);
        }

        int f = 0;
        for (Integer a: bufSet){
            System.out.print(a+" ");
            nums[f] = a;
            f++;
        }


        System.out.println();
        System.out.println(Arrays.toString(nums));

        //System.out.println(Arrays.toString(nums));



        return bufSet.size();
    }
}
