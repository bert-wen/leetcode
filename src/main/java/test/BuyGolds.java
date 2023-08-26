package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @projectName: leetcode
 * @package: test
 * @className: BuyGolds
 * @author: WenHui
 * @description: TODO
 * @date: 2023/3/14 18:52
 * @version: 1.0
 */
public class BuyGolds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expectCost= scanner.nextInt();
        String golds = scanner.next();
        int total = getGolds(expectCost, golds);
        System.out.println(total);
    }
    public static int getGolds(int expectCost,String gold){
        int totalCost=0;
        int[] s = Arrays.stream(gold.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        for (int i=0;i<s.length;i++){
            totalCost+=s[i];
            if (totalCost>expectCost){
                totalCost-=s[i];
                break;
            }
        }
        return totalCost;
    }
}
