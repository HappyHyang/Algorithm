import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>();
        for (String str : s1) {
            set1.add(str);
        }
        
        Set<String> set2 = new HashSet<>();
        for (String str : s2) {
            set2.add(str);
        }
        
        set1.retainAll(set2);
        return set1.size();
    }
}