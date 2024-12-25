class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        String hiddenPart = "*".repeat(length - 4);
        String visiblePart = phone_number.substring(length - 4);
        return hiddenPart + visiblePart;
    }
}