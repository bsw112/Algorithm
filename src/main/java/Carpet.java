public class Carpet {

    public static void main(String[] args) {
        Carpet module = new Carpet();
        int[] result = module.solution(24, 24);
        for(int var : result)
            System.out.print(var + " ");

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int sum = brown + yellow;

        for(int i =0; i < sum; ++i)
            for(int j =0; j < sum; ++j)
            {
                if(i * j == sum)
                {
                    if(i >= j && i >=3 && j >= 3 && i >= ( yellow / (j - 2)) + 2)
                        return new int[]{ i, j};

                }
            }
        return answer;
    }

}
