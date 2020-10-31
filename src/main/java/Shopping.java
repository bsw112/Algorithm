import java.lang.reflect.Array;
import java.util.Arrays;

public class Shopping {

    public static void main(String[] args) {

        Shopping module = new Shopping();
        System.out.println(module.solution(6, new int[][]{{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}}));
    }

    public String solution(int n, int[][] delivery) {
        char[] answer = new char[n];

        Arrays.fill(answer, '?');

        for (int[] order : delivery) {
            if (order[2] == 1) {
                answer[order[0] - 1] = 'O';
                answer[order[1] -1] = 'O';
            }
        }

        for (int[] order : delivery) {
            if (order[2] == 0) {
                if (answer[order[0] -1] == 'O')
                    answer[order[1] -1] = 'X';
                else if(answer[order[1] -1] == '0')
                    answer[order[0] - 1] = 'X';
            }
        }


//        for (int[] order : delivery) {
//            if (order[2] == 0) {
//                if (answer[order[0] -1] == 'X' && answer[order[1] -1] != '0')
//                    answer[order[1] -1] = '?';
//                else if(answer[order[1] - 1] == 'X' && answer[order[0] -1 ] != '0')
//                    answer[order[0] - 1] = '?';
//            }
//        }

        StringBuilder result = new StringBuilder();
        for (char c : answer) {
            result.append(c);
        }

        return result.toString();
    }
}
