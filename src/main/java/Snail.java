import java.util.ArrayList;
import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
        Snail module = new Snail();
        Arrays.stream(module.solution(6)).forEach(System.out::println);
    }

    //포기..
    //https://programmers.co.kr/learn/courses/30/lessons/68645



    //end는 마지막열의 숫자갯수
    void recursive(int start, int end, int val, int[][] answer) {

        if (start >= end - 1)
            return;

        answer[start][start/2] = val;
        ++val;

        //마지막줄 바로 전까지만
        for (int i = start + 1; i < end - 1; ++i) {
            answer[i][start/2] = val;
            answer[i][i - start /2] = val + (end - start) * 3 - 4;
            ++val;
        }

        //마지막줄 채우기
        for (int i = start / 2; i < end - start / 2; ++i)
            answer[end - 1][i] = val++;

        recursive(start + 2, end - 1, ((end -1) * 2 + end), answer);

    }

    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        recursive(0, n, 1, answer);

        ArrayList<Integer> result = new ArrayList<>();
        for (int[] arr : answer)
            for (int val : arr) {
                if (val != 0)
                    result.add(val);
            }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
