package programmers.heap;

import java.util.PriorityQueue;

public class Programmers1 {
    private int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (Integer scov : scoville) {
            priorityQueue.offer(scov);
        }

        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            int minimum = priorityQueue.poll();
            if(minimum >= K) {
                priorityQueue.offer(minimum);
                break;
            }
            if (priorityQueue.isEmpty()) {
                answer = -1;
                break;
            }
            int secondMin = priorityQueue.poll();

            int mixValue = minimum + (secondMin * 2);
            answer++;
            priorityQueue.offer(mixValue);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Programmers1().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
