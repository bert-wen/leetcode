package simple;

/**
 * @projectName: leetcode
 * @package: simple
 * @className: CaptureForts
 * @author: WenHui
 * @description: 最多可以摧毁的敌人城堡数目
 * @date: 2023/9/2 20:28
 * @version: 1.0
 */
public class CaptureForts {
    public static void main(String[] args) {
        int []forts = {0,0,-1,1};
        int i = captureForts(forts);
        System.out.println(i);
    }
    public static int captureForts(int[] forts) {
        int pre=-1;
        int ans=0;
        for (int i = 0; i < forts.length; i++) {
           if (forts[i]==-1 || forts[i]==1){
               if (pre>=0 && forts[i]!=forts[pre]){
                   ans=Math.max(ans,Math.abs(i-pre)-1);
               }
               pre=i;
           }

        }
        return ans;

    }
}
