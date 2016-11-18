/**
 * Created by C0d3man on 11/17/16.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeElementSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List result = new ArrayList<List>();
        if(nums==null)
            return result;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if((i>0)&&(nums[i]==nums[i-1]))
                continue;
            for(int j=i+1;j<nums.length-1;j++){
                if((j>i+1)&&(nums[j]==nums[j-1]))
                    continue;
                int index = Arrays.binarySearch(nums,j+1,nums.length,-(nums[i]+nums[j]));
                if(index>=0){
                    List set = new ArrayList<Integer>();
                    set.add(nums[i]);
                    set.add(nums[j]);
                    set.add(nums[index]);
                    result.add(set);
                }

            }
        }
        return result;
    }
}
