package programmers.hash;

import java.util.HashSet;

public class Programmers2 {
    private boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<>();

        boolean answer = true;
        loop: for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];

            for (int j = 1; j < s.length(); j++){
                hashSet.add(s.substring(0, j));
            }

            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) continue;

                if(hashSet.contains(phone_book[j])){
                    answer = false;
                    break loop;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Programmers2().solution(new String[]{"119", "97674223", "1195524421"}));
    }
}
