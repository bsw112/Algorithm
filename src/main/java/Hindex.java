import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hindex {

    //https://programmers.co.kr/learn/courses/30/lessons/42747
    // 답이 반드시 citations안에 있다고 할 수 없다.
    /*
    input                       1 7 0 1 6 4
    decend order                7 6 4 1 1 0
    number of above             1 2 3 4 5 6   (자신을 포함해서 data 이상인 것의 갯수)
    hindex                      1 2 3 1 1 0   (min(data, number og above)

     */

    public static void main(String[] args) {
        Hindex module = new Hindex();
        System.out.println(module.solution(new int[]{3,0,6,1,5}));
    }


    public int solution(int[] citations) {

       //인용횟수가 가장 많은게 앞에
        Integer[] citationsCopy = Arrays.stream(citations).boxed().toArray( Integer[]::new );
      Arrays.sort(citationsCopy, Collections.reverseOrder());

        int oldHindex = 0;
         for (int i = 0; i<citationsCopy.length; ++i)
         {
             int hIndex = Math.min(i +1 , citationsCopy[i]);
             if(oldHindex >= hIndex)
                 break;
             oldHindex = hIndex;
         }

        return oldHindex;

    }
}
