package chap_01;

import java.util.ArrayList;
import java.util.List;

public class 옹알이 {
    static class Solution {
        public int solution(String[] babbling) {
            List<String> find = new ArrayList<>();
            find.add("aya");
            find.add("ye");
            find.add("woo");
            find.add("ma");
            int count = 0;
            for(String x : babbling){
                StringBuilder sb = new StringBuilder();
                for(char d : x.toCharArray()){
                    sb.append(d);
                    if(find.contains(sb.toString())) sb= new StringBuilder();
                }
                count += sb.length()==0?1:0;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] babbling1 = {"aya", "yee", "u", "maa", "wyeoo"};
        String[] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        System.out.println(solution.solution(babbling1)); // 출력: 1
        System.out.println(solution.solution(babbling2)); // 출력: 3

    }
}

