package programmers;

import java.util.HashMap;

public class Programmers1 {
    public String solution(String[] participant, String[] completion) {
        HashMap hashMap = new HashMap<String, Integer>();

        for (String s : completion) {
            if (hashMap.get(s) == null) {
                hashMap.put(s, 1);
            } else {
                hashMap.put(s, (Integer)hashMap.get(s) + 1);
            }
        }

        String answer = "";
        for (String s: participant) {
            if (hashMap.get(s) == null || hashMap.get(s).equals(0)) {
                answer = s;
                break;
            } else {
                hashMap.put(s, (Integer)hashMap.get(s) - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"leo", "kiki"};
        System.out.println(new Programmers1().solution(participant, completion));
    }
}

