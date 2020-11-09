public class Network2 {

    //https://programmers.co.kr/learn/courses/30/lessons/43162
    //dfs든 bfs든 순회하면서 방문한 곳은 체크하고 끝에 도달하면(=하나의 그래프가 끝나면) 리턴하면 됨.
    //방문된 곳은 애초에 dfs를 수행하지 않음.
    //dfs를 완전히 수행한 횟수가 그래프의 수임.

    public static void main(String[] args) {
        Network2 module = new Network2();
        int result = module.solution(3,
                new int[][]{{1, 1, 0}, {1,1,0}, {0,0,1}});
        System.out.println(result);
    }

    int dfs(int i, int[][] computers, boolean[] visited)
    {
        //이미 전에 방문했었으면 어떤 그룹에 속해있는 것임.
        if(visited[i])
            return 0;


        for(int j = 0; j< computers.length; ++j)
        {
            //자기자신이 아니고, 연결되어있는 컴퓨터이고, 방문하지 않았다면
            if(i != j && computers[i][j] == 1 && !visited[j])
            {
                //방문했다고 표시
                visited[i] = true;
                //분신에게 일시키기
                dfs(j, computers, visited);

            }
        }

        //더이상 길이 없음
        visited[i] = true;
        return 1;

    }
    public int solution(int n, int[][] computers) {

        int sum = 0;
        boolean[] checked = new boolean[n];
        for(int i =0; i<n; ++i)
        {
            sum += dfs(i, computers, checked);
        }

        return sum;
    }

}
