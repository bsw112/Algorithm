import java.util.Arrays;

public class Cut {

    //https://programmers.co.kr/learn/courses/30/lessons/42748
    public static void main(String[] args) {
        Cut module = new Cut();
        module.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; ++i) {
            int[] copyArr = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(copyArr);
            answer[i] = copyArr[commands[i][2] - 1];
        }
        return answer;
    }

}
