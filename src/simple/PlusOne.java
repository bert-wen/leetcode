package simple;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: PlusOne
 * @author: Sveinn
 * @description: TODO
 * @date: 2023/1/2 17:52
 * @version: 1.0
 */
public class PlusOne {
    public static void main(String[] args) {
        int []nums={9,9,9};
        int[] ints = plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] plusOne(int[] digits) {
        //转换思路从后面开始思考
        for (int i = digits.length-1; i >=0; --i) {
            if (digits[i]==9){
                digits[i]=0;
            }else {
                digits[i]+=1;
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
