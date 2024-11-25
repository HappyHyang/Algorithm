class Solution {
    public String solution(String my_string) {
        StringBuilder output = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            output.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        return output.toString();
    }
}