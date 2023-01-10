package simple;

/**
 * @description: 回文数
 * @title: IsPalindrome
 * @email: 2046641767@qq.com
 * @projectName: leetcode
 * @author: Sveinn
 * @date: 2022/6/22 14:05
 */
public class IsPalindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(12321);
        System.out.println(palindrome);
    }
    //12321
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int value=x;
        int temp=1;
        while(value>=10){
            temp*=10;
            value/=10;
        }
        while (x!=0){
            if (x%10!=x/temp){
                return false;
            }
            x=x%temp/10;
            temp=temp/100;
        }
        return  true;
    }
}
