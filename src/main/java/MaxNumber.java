import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/42840

public class MaxNumber {
    
    //https://programmers.co.kr/learn/courses/30/lessons/42746
    //못품

    public static void main(String[] args) {

        MaxNumber module = new MaxNumber();
        System.out.println(module.solution(new int[]{6,10,2}));

    }

    public String solution(int[] numbers) {

        List<Integer> numberCopy = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        //compartor가 양수를 반환하면 swap한다.
        Collections.sort(numberCopy, (a,b) ->{
            String src = a.toString();
            String dst = b.toString();

            int length = Math.max(src.length(), dst.length());
            for(int i =0; i<length; ++i)
            {
                //길이는 다르지만 완전히 같을때
                //src가 dst보다 짧을때
                if(i >= src.length())
                {
                    //만약 src의 마지막 자리수보다 dst의 현재 자리수가 더 크면 스왑.
                    //dst가 더크면
                    if(src.charAt(src.length() -1) - '0' < dst.charAt(i) - '0')
                        return 1;
                    else
                        return -1;
                }
                //dst가 src보다 짧을때
                if(i >= dst.length())
                {
                    //src가 더 크면
                    if(dst.charAt(dst.length() -1) - '0' < src.charAt(i) - '0')
                        return -1;
                    else
                        return 1;

                }

                //자리수별 비교
                //src가 더 크면 스왑안함.
                if(src.charAt(i) - '0' > dst.charAt(i) - '0')
                {
                    return -1;
                }
            }

            return 1;
        });


        StringBuilder builder = new StringBuilder();
        for(Integer value : numberCopy) builder.append(value);
        return builder.toString();
    }
}
