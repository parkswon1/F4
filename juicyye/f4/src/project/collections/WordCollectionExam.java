package project.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCollectionExam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> box = new ArrayList<>();
        Word word = new Word("",0);
        int wordCount = 0;

        System.out.println("==========단어 입력 시스템================");
        System.out.println("======종료하시려면 quit를 입력해주세요======");

        while(true){
            System.out.print("입력 하실 단어: ");
            String input = scanner.next();

            if (input.equals("quit")) {
                System.out.println("단어 입력시스템을 종료합니다");
                break;
            } else{
                box.add(input);
                wordCount += input.length();
                if(word.getMax() < input.length()) {
                    word = new Word(input, input.length());
                }
            }
        }

        System.out.println("입력하신 단어의 개수는: "+ box.size()+"  |  글자 수의 합: "+ wordCount);
        System.out.println("가장 긴 단어 " + word.getWord() + "의 길이: " + word.getMax());
    }

    static class Word{
        private String word;
        private int max;

        public Word(String word, int max) {
            this.word = word;
            this.max = max;
        }

        public String getWord() {
            return word;
        }

        public int getMax() {
            return max;
        }
    }
}
