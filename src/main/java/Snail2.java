import java.util.ArrayList;
import java.util.Arrays;

public class Snail2 {

    public static void main(String[] args) {
        Snail2 module = new Snail2();
        Arrays.stream(module.solution(4)).forEach(System.out::println);
    }



    public int[] solution(int n) {
        int[][] answer = new int[n][n];

        int x = -1,  y = -1;
        int val = 0;
        int loopCnt = n;
        while(loopCnt > 0)
        {
            for(int i =0; i<loopCnt; ++i)
            {
                answer[++y][Math.max(x, 0)] = ++val;
            }

            --loopCnt;

            for( int i =0; i<loopCnt; ++i)
            {
                if(x < 0)
                    ++x;
                answer[y][++x] = ++val;
            }


            --loopCnt;

            for(int i =0; i<loopCnt; ++i)
            {
                answer[--y][--x] = ++val;
            }

            --loopCnt;
        }


        ArrayList<Integer> result = new ArrayList<>();
        for (int[] arr : answer)
            for (int num : arr) {
                if (num != 0)
                    result.add(num);
            }

        return result.stream().mapToInt(i -> i).toArray();
    }


}
