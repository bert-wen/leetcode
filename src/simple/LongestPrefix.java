package simple;

/**
 * @description: 最长公共前缀
 * @title: LongestPrefix
 * @email: 2046641767@qq.com
 * @projectName: leetcode
 * @author: Sveinn
 * @date: 2022/7/4 19:28
 */
public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestPreFix(strs);
        System.out.println(s);
    }

    public static String longestPreFix(String[] str) {
        //把第一个字符串当做是最长公共字符串，如果不是再截取
        if (str.length == 0) {
            return "";
        }
        String ant = str[0];
        for (int i = 1; i < str.length; i++) {
            int j = 0;
            for (; j < ant.length() && j < str[i].length(); j++) {
                if (ant.charAt(j) != str[i].charAt(j)) {
                    break;
                }
            }
            //subString是左闭右开的
            ant = ant.substring(0, j);
            if (ant.equals("")) {
                return ant;
            }
        }
        return ant;
    }
}
