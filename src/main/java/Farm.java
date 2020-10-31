import java.util.Scanner;

public class Farm {

    /*
    작물 0,1,2 가 있다. 입력으로는 0,1,2 가 심어진 땅이 주어진다.
    작물들이 형성하는 밭의 갯수는 몇개인가.
    예) 답이 2,1,2 면 0으로 이루어진 밭이 2개, 1으로 이루어진 밭이 1개, 2로 이루어진 밭이 2개.

    그룹을 찾는 문제다.
    visited가 중요한 문제다.
     */
    public static void main(String[] args) {
        Farm module = new Farm();
        int[] result =module.solution(new int[][]{{0,0, 1}, {2,2,1}, {0,0,0}});
        //int[] result =module.solution(new int[][]{{0,0,0, 1}, {1,1,1,1}, {2,2,2,1}, {0,0,0,2}});

        for(int val : result)
            System.out.print(val + " ,");
    }

    int dfs(int i, int j, int[][] data, boolean[][] visited) {

        //방문한다.
        visited[i][j] = true;
//
//        Scanner scan = new Scanner(System.in);
//        scan.nextLine();
//
//        //디버깅
//        for(int x = 0; x<visited.length; ++x)
//        {
//            for(int y = 0; y<visited.length; ++y)
//                System.out.print(visited[x][y] + "\t");
//            System.out.println();
//        }


        //주위 사방면에 대한 인덱스
        int[][] index = {{Math.max(i - 1, 0), j}, {i, Math.max(j - 1, 0)}, {i, Math.min(j + 1, data.length - 1)}, {Math.min(i + 1, data.length - 1), j}};
        for (int k = 0; k < 4; ++k) {
            //방문했던 곳은 무시
            if (visited[index[k][0]][index[k][1]])
                continue;
            //만약 현재 데이터와 사방면 중 어느 한곳의 데이터가 일치하면
            if (data[index[k][0]][index[k][1]] == data[i][j])
            {
                //그 방향으로 분신을 보내서 똑같은 일을 시킨다. 분신의 답은 여기로 들어온다. blocking이다.
                int crop = dfs(index[k][0], index[k][1], data, visited);

                //모든 자식들로 가는 루트를 방문해야되기 때문에 리턴하면 안됨.
//                if(crop > 0)
//                    return crop;
            }
        }

        // 현재 데이터와 사방면 중 어느 한곳도 데이터가 일치하는 곳이 없다.
        //분신이 답한다. "여긴 막다른 길이에요! 제 데이터는 이것입니다"->호출자(분신일 수 있음)이 그대로 상위 분신에게 전달->
        //오리지널이 호출자(solution)에게 전달. (분기가 있으므로 여러 분신이 한 분신에게 return 함)
        return data[i][j];

    }


    public int[] solution(int[][] v) {
        int[] answer = new int[3];
        boolean[][] visited = new boolean[v.length][v.length];

        //모든 데이터에 대해서 사방면 탐색 함수를 재귀로 돌린다.
        for(int i = 0; i<v.length; ++i)
            for(int j = 0; j<v.length; ++j)
            {
                //방문했던 곳은 방문하지 않는다.
                if(visited[i][j])
                    continue;

                int group = dfs(i, j, v, visited);
                if(group >= 0)
                    answer[group]++;
            }


        return answer;
    }
}
