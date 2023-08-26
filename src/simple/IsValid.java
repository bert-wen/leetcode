package simple;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: IsValid
 * @author: WenHui
 * @description: TODO
 * @date: 2023/3/15 14:55
 * @version: 1.0
 */
public class IsValid {
    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println(valid);
    }
    public static boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                if (stack.peek()!=map.get(aChar) || stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }else {
               stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }
}
