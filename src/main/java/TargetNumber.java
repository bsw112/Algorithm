public class TargetNumber {

    //https://programmers.co.kr/learn/courses/30/lessons/43165
    //결국 모든 경우의수를 탐색한다.

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

        //모든 숫자를 사용했고
        if (currentIndex == numbers.length) {
            //답이면
            if (start == target) {
                System.out.println(massage);
                //가능한 경우의 수 하나 추가
                return 1;
            }

            return 0;
        }

        int cnt = 0;
        //더한경우 (왼쪽노드)
        cnt += dfs(start + numbers[currentIndex], target, numbers, currentIndex + 1, massage + "+" + Integer.toString(numbers[currentIndex]));
        //뺀경우 (오른쪽노드)
        cnt += dfs(start - numbers[currentIndex], target, numbers, currentIndex + 1, massage + "-" + Integer.toString(numbers[currentIndex]));
        return cnt;

    }


}
