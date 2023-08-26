package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: Generate
 * @author: Sveinn
 * @description: 杨辉三角（递归）
 * @date: 2023/1/3 17:02
 * @version: 1.0
 */
public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j==0 || j==i){
                    list.add(1);
                }else {
                    list.add(listList.get(i-1).get(j-1)+listList.get(i-1).get(j));
                }
            }
            listList.add(list);
        }
        return listList;
    }

}
