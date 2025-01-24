import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] info = term.split(" ");
            termsMap.put(info[0], Integer.parseInt(info[1]));
        }

        int currentDate = convertDateToInt(today);

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyInfo = privacies[i].split(" ");
            if (convertDateToInt(privacyInfo[0]) + (termsMap.get(privacyInfo[1]) * 28) <= currentDate) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int convertDateToInt(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
