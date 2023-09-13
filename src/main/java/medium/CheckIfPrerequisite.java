package medium;

import java.util.*;

public class CheckIfPrerequisite {
    public static void main(String[] args) {
        int numCourses = 2;
        int [][]prerequisites = {{1,0}}, queries = {{0,1},{1,0}};
        List<Boolean> booleans = checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(booleans);
        List<Boolean> booleans1 = checkIfPrerequisite1(numCourses, prerequisites, queries);
        System.out.println(booleans1);
    }
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
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
        Queue<Integer> queen = new ArrayDeque<Integer>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queen.offer(key);
            }
        }
        boolean[][] isPre = new boolean[numCourses][numCourses];
        while (!queen.isEmpty()){
            Integer current = queen.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(current)) {
                continue;
            }
            for (Integer next : adj.get(current)) {
                isPre[current][next]=true;
                for (int i = 0; i < numCourses; i++) {
                    isPre[i][next] = isPre[i][next] | isPre[i][current];
                }
                inDegree.put(next,inDegree.get(next)-1);
                // 如果有入度为零的就加入队列
                if (inDegree.get(next) == 0){
                    queen.offer(next);
                }
            }
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }
    public static List<Boolean> checkIfPrerequisite1(int numCourses, int[][] prerequisites, int[][] queries) {
        // 1.课号和对应的入度
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<Integer>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            g[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int ne : g[cur]) {
                isPre[cur][ne] = true;
                for (int i = 0; i < numCourses; ++i) {
                    isPre[i][ne] = isPre[i][ne] | isPre[i][cur];
                }
                --indgree[ne];
                if (indgree[ne] == 0) {
                    queue.offer(ne);
                }
            }
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

}
