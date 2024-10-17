class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        for(char c : s.toCharArray()) {
            switch (c) {
                case 'p':
                case 'P':
                    pCnt++;
                    break;
                case 'y':
                case 'Y':
                    yCnt++;
                    break;
            }
        }
        return pCnt == yCnt;
    }
}