import java.util.ArrayList;

public class Poketmon {

    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length / 2;
        //몇 종류가 있느냐?

        ArrayList<Integer> poketmons = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i)
        {
            if(!poketmons.contains(nums[i]))
                poketmons.add(nums[i]);
        }


        return Math.min(pick, poketmons.size());
    }
}
