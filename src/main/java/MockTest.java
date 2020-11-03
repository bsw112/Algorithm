
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MockTest {

    public static void main(String[] args) {
        MockTest module = new MockTest();
        int [] result = module.solution(new int[]{1,2,3,4,5});
        for(int val : result) System.out.println(val + " ");
    }

    int pattern1(int index) {
        return (index % 5) + 1;
    }

    int pattern2(int index) {
        int[] pattern = {2, 1, 2, 3, 2, 4, 2, 5};
        return pattern[index % pattern.length];
    }

    int pattern3(int index) {
        int[] pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        return pattern[index % pattern.length];
    }


    public int[] solution(int[] answers) {

        Integer[] report = new Integer[3];
        Arrays.fill(report, 0);

        for (int i = 0; i < answers.length; ++i) {
            if (pattern1(i) == answers[i])
                report[0]++;
            if(pattern2(i) == answers[i])
                report[1]++;
            if(pattern3(i) == answers[i])
                report[2]++;
        }

        int max = Arrays.stream(report).max(Integer::compareTo).get();

        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0; i<report.length; ++i)
        {
            if(report[i].equals(max))
                result.add(i+1);
        }


        return result.stream().mapToInt(i ->i).toArray();

    }
}
