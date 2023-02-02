package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: test
 * @className: NameList
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/16 20:02
 * @version: 1.0
 */
public class NameList
{
    private List names = new ArrayList();
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + "");
        }
    }

    public static void main(String[]args)
    {
        final NameList sl = new NameList();
        for (int i = 0; i < 2; i++)
        {
            new Thread()
            {
                public void run()
                {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            } .start();
        }
    }
}
//public class NameList {
//    private List<String> names = new ArrayList();
//    public synchronized void add(String name) {
//        names.add(name);
//    }
//    public synchronized void printAII() {
//        for (int i = 0; i < names.size(); i++) {
//            System.out.print(names.get(i) + " ");
//        }
//    }
//    public static void main(String[] args) throws InterruptedException {
//        final NameList sl = new NameList();
//        Thread t1 = new Thread() {
//            public void run() {
//                sl.add("A");
//                sl.add("B");
//                sl.add("C");
//                sl.printAII();
//            }
//        };
//        t1.start();
//        Thread t2 = new Thread() {
//            public void run() {
//                sl.add("A");
//                sl.add("B");
//                sl.add("C");
//                sl.printAII();
//            }
//        };
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch(InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println();
//        sl.printAII();
//    }
//}
