import java.util.LinkedList;
import java.util.Queue;

public class Programmers_기능개발 {
    static int[] progresses = {96, 94};
    static int[] speeds = {3, 3};
    public static void main(String[] args) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0; i<progresses.length; i++) {
            double tmpDay = (double)((100.0-progresses[i])/speeds[i]);
            int leftDay = (int)Math.ceil(tmpDay);

            q.add(leftDay);
        }

        int cnt = 0;
        int j = 0;

        while(!q.isEmpty()) {
            j++;
            while(j >= q.peek()) {
                q.poll();
                cnt++;
                if(q.isEmpty()) {
                    break;
                }
            }
            if(cnt != 0) {
                System.out.print(cnt + " ");
                cnt = 0;
            }
        }
    }
}
