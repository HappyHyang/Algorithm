import java.io.*;

class Solution {
    public int solution(int i, int j, int k) {
        StringBuilder builder = new StringBuilder();
        for (int num = i; num <= j; num++) {
            builder.append(num);
        }
        int totalLength = builder.length();
        int exceptLength = builder.toString().replace(Integer.toString(k), "").length();
        
        return totalLength - exceptLength;
    }
}