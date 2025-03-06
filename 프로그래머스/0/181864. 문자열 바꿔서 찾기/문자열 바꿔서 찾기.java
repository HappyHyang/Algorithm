class Solution {
    public int solution(String myString, String pat) {
        char[] swapped = new char[myString.length()];
        for (int i = 0; i < myString.length(); i++) {
            swapped[i] = (myString.charAt(i) == 'A') ? 'B' : 'A';
        }
        return new String(swapped).contains(pat) ? 1 : 0;
    }
}
