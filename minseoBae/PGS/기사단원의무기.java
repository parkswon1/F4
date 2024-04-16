package Programmers;

public class 기사단원의무기 {
    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
    }
        public static int solution(int number, int limit, int power) {
            int answer = 0;

            for (int i = 1; i <= number; i++) {
                int numDivisors = countDivisors(i);
                if (numDivisors <= limit) {
                    answer += numDivisors;
                } else {
                    answer += power;
                }
            }

            return answer;
        }

        // 약수 개수를 세는 함수
        private static int countDivisors(int n) {
            int count = 0;
            int sqrt = (int) Math.sqrt(n);

            for (int i = 1; i <= sqrt; i++) {
                if (n % i == 0) {
                    // 제곱수인 경우 중복을 피하기 위해 1을 더해줍니다.
                    if (n / i == i) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }

            return count;
        }
}
