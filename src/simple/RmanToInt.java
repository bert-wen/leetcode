package simple;

import java.util.HashMap;

/**
 * @description: 阿拉伯数字转罗马数字
 * @title: romanToInt
 * @email: 2046641767@qq.com
 * @projectName: leetcode
 * @author: Sveinn
 * @date: 2022/6/22 16:46
 */
public class RmanToInt {
    public static void main(String[] args) {
        int vii = rmanToInt("MCMXCIV");
        System.out.println(vii);
    }
    public static int  rmanToInt(String rman){
        HashMap<Character,Integer> map= new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] array = rman.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        int num=0;
        for (int i = 0; i < array.length; i++) {
            int value=map.get(array[i]);
            if (i<array.length-1&&value<map.get(array[i+1])){
                num-=value;
            }else {
                num+=value;
            }
        }
        return num;
    }
}
