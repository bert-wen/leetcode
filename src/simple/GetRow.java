package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: GetRow
 * @author: Sveinn
 * @description: 杨辉三角2(利用滚动数组求解，定义一个临时的数组)
 * @date: 2023/1/3 18:30
 * @version: 1.0
 */
public class GetRow {
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList<>();
        for (int i=0;i<=rowIndex;i++){
            List<Integer> cur=new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j==0 || j==i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre=cur;
        }
        return pre;
    }
}
