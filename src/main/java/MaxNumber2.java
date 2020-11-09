import java.util.Arrays;


public class MaxNumber2 {

 //https://programmers.co.kr/learn/courses/30/lessons/42746
    //실패.

    public static void main(String[] args) {

        MaxNumber2 module = new MaxNumber2();
        System.out.println(module.solution(new int[]{3, 30, 34, 5, 9}));
    }

    class DigitSum {
        String number = "";
        String original = "";

    }

    public String solution(int[] numbers) {

        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }

        int maxLength = 0;
        for (String number : str) {
            if (maxLength < number.length())
                maxLength = number.length();
        }

        //배열초기화
        DigitSum[] digitSums = new DigitSum[str.length];
        for (int i = 0; i <digitSums.length; i++) {
            DigitSum digitSum = new DigitSum();
            digitSum.number = "";
            digitSum.original = str[i];
            digitSums[i] = digitSum;
        }

        //자리수 맞추기
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < str.length; ++j) {
                //마지막자리수를 반복하는게 아닌가봄!
                digitSums[j].number += str[j].charAt(Math.min(i, str[j].length() -1));
            }
        }

        //내림차순
        Arrays.sort(digitSums, (a,b) -> b.number.compareTo(a.number));
        StringBuilder answer = new StringBuilder();
        for (DigitSum tmp : digitSums) {
            answer.append(tmp.original);
        }
        return digitSums[0].original.equals("0") ? "0" : answer.toString();
    }


}




