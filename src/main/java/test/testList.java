package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @projectName: leetcode
 * @package: test
 * @className: testList
 * @author: WenHui
 * @description: TODO
 * @date: 2023/2/15 11:13
 * @version: 1.0
 */
public class testList {
    public static void main(String[] args) {
        List<Long> list1=new ArrayList<>();
        List<Long> list2=new ArrayList<>();
        for (long i=0;i<=4000;i++){
            list1.add(i);
        }
        for (long i=1;i<=400;i++){
            list2.add(i*8);
        }

        long l = System.currentTimeMillis();
        List<Long> collect = list1.parallelStream().filter(list2::contains).collect(Collectors.toList());
        long l1 = System.currentTimeMillis();
        long t1 = System.currentTimeMillis();
        int count=0;
        Set<Long> set=new HashSet<>(list2);
        for (Long aLong : list1) {
            if (set.contains(aLong)){
                count++;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println(collect.size());
        System.out.println(count);
        System.out.println(l1-l);
        System.out.println(t2-t1);

    }

    public static int  getCount (List<Long> l1, List<Long> l2){
        int  threadCount = Runtime.getRuntime().availableProcessors();
        int blockSize =l1.size() / threadCount; // 计算每个线程处理的数据块大小
        int blockSize2 =l2.size() / threadCount;
        List<List<Long>> subLists1 = new ArrayList<>();
        List<List<Long>> subLists2 = new ArrayList<>();

// 将数据划分为多个子集
        for (int i = 0; i < threadCount; i++) {
          int  fromIndex = i * blockSize;
           int  toIndex = (i == threadCount - 1) ? l1.size()-1 : (i + 1) * blockSize;
            List<Long> longs = l1.subList(fromIndex, toIndex);
            subLists1.add(longs);
            int fromIndex2 = i * blockSize2;
            int toIndex2 = (i == threadCount - 1) ? l1.size()-1 : (i + 1) * blockSize2;
            subLists2.add(l2.subList(fromIndex2, toIndex2));
        }

        AtomicInteger count = new AtomicInteger(); // 统计相同元素的数量
        List<Thread> threads = new ArrayList<>();
// 开启多个线程处理子集
        for (int i = 0; i < threadCount; i++) {
            List<Long> subList1 = subLists1.get(i);
            List<Long> subList2 = subLists2.get(i);
            Thread thread = new Thread(() -> {
                for (Long num1 : subList1) {
                    for (Long num2 : subList2) {
                        if (num1.equals(num2)) {
                            count.incrementAndGet();
                            break;
                        }
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }

// 等待所有线程处理完毕
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      return count.get();
    }
}
