package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: RomanToInt
 * @author: Sveinn
 * @description: TODO
 * @date: 2022/12/21 22:27
 * @version: 1.0
 */
public class RomanToInt {
    public static void main(String[] args) {
        int iv = romanToInt("V");
        System.out.println(iv);
    }
    public static int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ant=0;
        for (int i=0;i<s.length();i++){
            int value= map.get(s.charAt(i));
            if (i<s.length()-1 && value<map.get(s.charAt(i+1))){
               ant-=value;
            }else {
                ant+=value;
            }
        }
        return ant;
    }

}
