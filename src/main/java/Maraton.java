import java.util.Arrays;

public class Maraton {

    //참가자 배열 1과 완주한 사람 배열2가 주어졌을때 완주하지 못한사람은 한명이다.
    //그 한명을 구하라.
    //그냥 둘다 정렬하고 다른부분 체크해보면 됨.

//    public static void main(String[] args) {
//        Maraton module= new Maraton();
//        System.out.println(module.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
//                new String[]{"josipa", "filipa", "marina","nikola"}));
//    }


    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i =0; i<participant.length; ++i)
        {
            if(i >= completion.length)
            {
                answer = participant[i];
                break;
            }

            if(!participant[i].equals(completion[i]))
            {
                answer = participant[i];
                break;
            }

        }
        return answer;
    }

}
