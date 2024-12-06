class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] member : db) {
            if (member[0].equals(id_pw[0])) {
                return member[1].equals(id_pw[1]) ? "login" : "wrong pw";
            }
        }
        return "fail";
    }
}