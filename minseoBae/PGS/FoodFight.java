package Programmers;

public class FoodFight {
    public static void main(String[] args) {
        int[] foods = {1, 3, 4, 6};
        System.out.println(solution(foods));
    }
    public static String solution(int[] foods) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < foods.length; i++) {
            for(int j = 0; j < foods[i] / 2; j++) {
                sb.append(i);
            }
        }

        return sb.toString() + "0" + sb.reverse().toString();
    }
}