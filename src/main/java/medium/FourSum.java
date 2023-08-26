package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: FourSum
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/6 13:52
 * @version: 1.0
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> listList = fourSum(nums,  -294967296);
        System.out.println(listList);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList=new ArrayList<>();
        if(nums == null || nums.length <4){
            return listList;
        }
        Arrays.sort(nums);
        for (int first=0;first<nums.length-3;first++){
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            //因为是按排序的数据如果前面小的数据都比目标值大那么后面的数就一定不可能等于目标值
            if ((long)nums[first]+nums[first+1]+nums[first+2]+nums[first+3]>target){
                break;
            }
            //如果第一个数和最后三个最大的数相加都比目标值更小那么前面的数也不可能等于目标值
            if ((long)nums[first]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target){
                continue;
            }
            for (int second=first+1;second<nums.length-2;second++){
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                if ((long)nums[first]+nums[second]+nums[second+1]+nums[second+2]>target){
                    break;
                }
                if ((long)nums[first]+nums[second]+nums[nums.length-1]+nums[nums.length-2]<target){
                    continue;
                }
                int third=second+1;
                int four=nums.length-1;
                while (third<four){
                    //注意计算过程中可能会出现越界的情况整型数据
                   long value=(long)nums[first]+nums[second]+nums[third]+nums[four];
                    if(value==target){
                        listList.add(Arrays.asList(nums[first], nums[second], nums[third], nums[four]));
                        while (third<four && nums[third]==nums[third+1]){
                            third++;
                        }
                        third++;
                        while (four>third && nums[four]==nums[four-1]){
                            four--;
                        }
                        four--;
                    }
                    else if (value<target){
                        third++;
                    }else {
                        four--;
                    }
                }
            }
        }
        return listList;
    }


}
