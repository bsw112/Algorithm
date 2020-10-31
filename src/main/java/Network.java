public class Network {

    int[] nodes;

    public static void main(String[] args) {
        Network module = new Network();
        int result = module.solution(5,
                new int[][]{{1, 1, 0, 1, 0}, {1, 1, 0, 1, 0}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0}, {0,0,0,0,1}});
        System.out.println(result);
    }

    private int getParent(int computer) {
        if (computer == nodes[computer])
            return computer;
        return getParent(nodes[computer]);
    }


    public int solution(int n, int[][] computers) {

        nodes = new int[computers.length];


        for (int i = 0; i < computers.length; ++i)
            for (int j = computers.length - 1; j >= 0; --j) {
                if (computers[i][j] == 1)
                    nodes[i] = j;
            }


        int[] countArr = new int[computers.length];
        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = getParent(i);
            countArr[nodes[i]]++;
        }

        int result = 0;
        for(int val : countArr)
        {
            if(val != 0)
                ++result;
        }

        return result;
    }
}
