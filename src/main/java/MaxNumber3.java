import java.util.Arrays;
import java.util.Comparator;

public class MaxNumber3 {

    // //https://programmers.co.kr/learn/courses/30/lessons/42746
    // 처음에는 자리수의 합을 생각했는데, 그런 근거없이 되지않을까? 하는 느낌이 드는건 안되니까 하지말자.
    // 문자열비교의 특징 (앞자리에서부터 비교)를 이용하면됨.
    // 입력받은 숫자들의 자리수를 일치시켜야되는데, 만약 13 13555 가 있으면 13131 13555 로 일치시켜야함.
    // 왜냐하면 132 13 일때 13213이 정답임. 즉, 132의 마지막자리 2와 13의 첫번째자리 1을 비교해서 132가 먼저와야함.
    // 테스트케이스를 생각할때 더 크고 복잡한수로 생각했어야했다.

    public static void main(String[] args) {

        MaxNumber3 module = new MaxNumber3();
        System.out.println(module.solution(new int[]{546, 12120, 4444, 888,57454}));
    }

    class StringPair
    {
        String original;
        String number;
    }

    public String solution(int[] numbers) {
        StringPair[] strPair = new StringPair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            StringPair tmp = new StringPair();
            tmp.original = Integer.toString(numbers[i]);
            tmp.number = "";
            strPair[i] = tmp;
        }

        //자리수 맞추기 (최대 6자리수)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < strPair.length; ++j) {
                strPair[j].number += strPair[j].original.charAt(i % strPair[j].original.length());
            }
        }

        Arrays.sort(strPair, (a,b) -> b.number.compareTo(a.number));


        StringBuilder builder = new StringBuilder();
        for(StringPair s : strPair) builder.append(s.original);

        return strPair[0].original.equals("0") ? "0" : builder.toString();
    }

}
