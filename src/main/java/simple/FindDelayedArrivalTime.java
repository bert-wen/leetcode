package simple;

/**
 *  计算列车到站时间
 */
public class FindDelayedArrivalTime {
    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(13, 11));
    }
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime)%24;
    }
}
