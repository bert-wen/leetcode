package simple;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: NumDifferentIntegers
 * @author: Sveinn
 * @description: TODO
 * @date: 2022/12/6 20:46
 * @version: 1.0
 */
public class NumDifferentIntegers {
    @Test
    public void test() {
       String word = "a123bc34d8ef34";
        int i = numDifferentIntegers(word);
        System.out.println(i);
    }
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set s=new HashSet<String>();
        int j=0;
        int p=0;
        int n=chars.length;
        while (j<n){
            while (j<n && !Character.isDigit(chars[j])){
                j++;
            }
            p=j;
            while (p<n && Character.isDigit(chars[p])){
                p++;
            }
            while (p-j>1 && chars[j]=='0') {
                j++;
            }
            s.add(word.substring(j,p));
            j=p;
        }

       return s.size();
    }
}
