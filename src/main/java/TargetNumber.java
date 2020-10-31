public class TargetNumber {

    public static void main(String[] args) {
        TargetNumber module = new TargetNumber();
        System.out.println(module.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer += dfs(0, target, numbers, 0, Integer.toString(numbers[0]));

        return answer;
    }

    int dfs(int start, int target, int[] numbers, int currentIndex, String massage) {

        if (currentIndex == numbers.length) {
            if (start == target) {
                System.out.println(massage);
                return 1;
            }

            return 0;
        }

        int cnt = 0;
        cnt += dfs(start + numbers[currentIndex], target, numbers, currentIndex + 1, massage + "+" + Integer.toString(numbers[currentIndex]));
        cnt += dfs(start - numbers[currentIndex], target, numbers, currentIndex + 1, massage + "-" + Integer.toString(numbers[currentIndex]));
        return cnt;

    }


}
