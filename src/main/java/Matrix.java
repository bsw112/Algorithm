public class Matrix {

    //행렬곱구현.
    //루프가 까다롭다.

    public static void main(String[] args) {
        Matrix module = new Matrix();
        module.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
    }


    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        //상위의 for문은 더 큰 범위의 for문임을 숙지하자.
        //문제를 쪼개서 구조화해야한다.
        /*
        for ( arr1을 순회하며)
         for ( arr1 한 행과 arr2 한 행에 대한 결과를 내기 위해선 arr2[0] 길이만큼의 반복)
          for( 각 원소끼리 곱하는 것은 arr1[0]의 길이만큼씩 일어난다)
         */
        for (int i = 0; i < arr1.length; ++i)
            for (int j = 0; j < arr2[0].length; ++j)
                for(int k =0; k < arr1[0].length; ++k)
        {
            answer[i][j] += arr1[i][k] * arr2[k][j];
        }

        return answer;
    }


}
