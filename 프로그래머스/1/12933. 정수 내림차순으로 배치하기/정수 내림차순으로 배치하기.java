import java.util.*;

class Solution {
    public long solution(long n) {
        String number = Long.toString(n);
        char[] arr = number.toCharArray();
        Arrays.sort(arr);
        StringBuilder answer = new StringBuilder(new String(arr));
        answer.reverse();
        return Long.parseLong(answer.toString());
    }
}