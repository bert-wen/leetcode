package test;

/**
 * @projectName: leetcode
 * @package: test
 * @className: MergArray
 * @author: Sveinn
 * @description: TODO
 * @date: 2022/12/4 13:00
 * @version: 1.0
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] num1={1,2};
        int[] num2={3,4};
//        int[] merge = merge(num1, num2);
//        for (int i=0;i<merge.length;i++){
//            System.out.println(merge[i]);
//        }
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);

    }
    public static int [] merge(int [] num1,int [] num2){
        int m=num1.length-1;
        int n=num2.length-1;
        int k=num1.length+num2.length-1;
        int [] arr=new int [k+1];
        while (m>=0 && n>=0){
            if (num1[m]>=num2[n]){
               arr[k--]=num1[m--];
            }else {
                arr[k--]=num2[n--];
            }
        }
        while (m>=0){
            arr[k--]=num1[m--];
        }
        while (n>=0){
            arr[k--]=num2[n--];
        }
        return arr;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length-1;
        int n=nums2.length-1;
        int k=nums1.length+nums2.length-1;
        int sum=k+1;
        double result;
        int[] arr=new int [sum];
        while(m>=0 && n>=0){
            if(nums1[m]>=nums2[n]){
                arr[k--]=nums1[m--];
            }else{
                arr[k--]=nums2[n--];
            }
        }
        while(m>=0){
            arr[k--]=nums1[m--];
        }
        while(n>=0){
            arr[k--]=nums2[n--];
        }
        if(sum%2==0){
            result=(arr[sum/2]+arr[sum/2-1])/2.0;
        }else{
            result=arr[sum/2];
        }
        return result;
    }
}
