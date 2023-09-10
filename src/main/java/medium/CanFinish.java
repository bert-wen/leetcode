package medium;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: medium
 * @className: CanFinish
 * @author: WenHui
 * @description: 课程表
 *  拓扑排序【，把一个 有向无环图 转成 线性的排序 就叫 拓扑排序】
 * @date: 2023/9/9 22:37
 * @version: 1.0
 */
public class CanFinish {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 初始化map，让每个课程的入度都设为0
        for(int i=0;i<numCourses;i++){
            inDegree.put(i,0);
        }
        // 2.依赖关系, 依赖当前课程的后序课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 初始化入度和依赖关系
        for (int[] prerequisite : prerequisites) {
            // (3,0), 想学3号课程要先完成0号课程, 更新3号课程的入度和0号课程的依赖(邻接表)
            int current=prerequisite[1];
            int next=prerequisite[0];
            inDegree.put(next,inDegree.get(next)+1);
            if (!adj.containsKey(current)){
                adj.put(current,new ArrayList<>());
            }
            adj.get(current).add(next);
        }
        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> queen = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queen.offer(key);
            }
        }
        while (!queen.isEmpty()){
            Integer current = queen.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(current)) {
                continue;
            }
            List<Integer> integers = adj.get(current);
            for (Integer integer : integers) {
                inDegree.put(integer,inDegree.get(integer)-1);
                // 如果有入度为零的就假如队列
                if (inDegree.get(integer) == 0){
                    queen.offer(integer);
                }
            }
        }
        // 4.遍历入队, 如果还有课程的入度不为0, 返回fasle
        for (int key: inDegree.keySet()){
            if (inDegree.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}
