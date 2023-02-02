package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: test
 * @className: Test
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/16 17:13
 * @version: 1.0
 */
public class Test {


    public static void main(String[] args) {
        List<List<Integer>> listList=new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int j=0;j<10;j++){
            list.add(j);
        }
        List<List<Integer>> listList1 = addList(listList, list);
        System.out.println(listList1);

    }
    public static List<List<Integer>> addList(List<List<Integer>> listList,List<Integer> list){
        listList.add(list);
        return listList;
    }
    @org.testng.annotations.Test
    public void test() throws MalformedURLException {
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
    }
}
