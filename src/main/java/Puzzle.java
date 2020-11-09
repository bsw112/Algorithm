import java.util.Arrays;

public class Puzzle {

    //프렌즈 4블록
    public static void main(String[] args) {
        Puzzle module = new Puzzle();
        module.solution(6, 2, new String[]{"AA", "AA", "CC", "AA", "AA", "DD"});
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        boolean[][] checked = new boolean[m][n];


        for (int i = 0; i < m; ++i)
            map[i] = board[i].toCharArray();

        while (true) {
            boolean isEnd = true;
            for(boolean[] arr : checked) Arrays.fill(arr, false);

            //테두리 안해도됨
            for (int i = 0; i < m-1; ++i) {
                for (int j = 0; j < n-1; ++j) {

                    int[][] squar = new int[][]{{i, j}, {i, j + 1}, {i + 1, j}, {i + 1, j + 1}};
                    int cnt = 0;
                    for (int x = 0; x < 4; ++x) {
                        int col = Math.min(m - 1, squar[x][0]);
                        int row = Math.min(n - 1, squar[x][1]);
                        //자기자신을 포함하지 않고 3개면 안됨. 나뺴고 주면만 R이면 나포함해서 다 지워짐

                        if(map[i][j] == 0)
                            break;

                        if (map[col][row] == map[i][j])
                            cnt++;
                    }
                    if (cnt >= 4) {
                        for (int x = 0; x < 4; ++x) {
                            int col = Math.min(m - 1, squar[x][0]);
                            int row = Math.min(n - 1, squar[x][1]);
                            checked[col][row] = true;
                            isEnd = false;
                        }

                    }
                }
            }

            //지울게 없으면 끝
            if (isEnd) {
                for (int i = 0; i < m; ++i)
                    for (int j = 0; j < n; ++j) {
                        if (map[i][j] == 0) {
                            answer++;
                        }
                    }
                break;
            }

            //체크해뒀던거 0으로 만들기
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j) {
                    if (checked[i][j]) {
                        map[i][j] = 0;
                    }
                }

            //떨어뜨리기
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j) {
                    for (int k = i+1; k < m; ++k) {
                        if (map[i][j] != 0 && map[k][j] == 0) {
                            char tmp = map[k][j];
                            map[k][j] = map[i][j];
                            map[i][j] = tmp;
                        }
                    }
                }

            int aa = 3;

        }


        return answer;
    }


}
