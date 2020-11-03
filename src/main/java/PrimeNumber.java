import java.util.ArrayList;
import java.util.LinkedList;

public class PrimeNumber {


    //https://programmers.co.kr/learn/courses/30/lessons/42839

    void MakeTable(LinkedList<Character> dataset, String currNum, ArrayList<String> rainbowTable) {
        if (dataset.isEmpty()) {
            if(!rainbowTable.contains(currNum))
                rainbowTable.add(currNum);
        }

        for (int i = 0; i < dataset.size(); ++i) {
            String number = currNum + dataset.get(i);
            LinkedList<Character> newDataset = new LinkedList<>(dataset);
            newDataset.remove(i);
            MakeTable(newDataset, number, rainbowTable);
        }
    }


    public int solution(String numbers) {

        ArrayList<Integer> answerlist = new ArrayList<>();
        ArrayList<String> rainbowTable = new ArrayList<>();
        LinkedList<Character> dataset = new LinkedList<>();
        for (int i = 0; i < numbers.length(); ++i)
            dataset.add(numbers.charAt(i));

        MakeTable(dataset, "", rainbowTable);

        for (int i = 1; i <= numbers.length(); ++i) {
            for (String num : rainbowTable) {
                int result = Integer.parseInt(num.substring(0, i));

                //2는 유일한 짝수 소수다.
                if(result == 2)
                {
                    if(!answerlist.contains(2))
                        answerlist.add(2);
                }

                //1은 소수가 아니다. 짝수는 2를 제외하고 소수가 될 수 없다.
                if (result == 1 || result == 0 || result % 2 == 0)
                    continue;


                boolean isPrimeNum = true;
                //소수인지 확인
                //result는 항상 홀수이기 때문에 k += 2 씩 넘는다.
                //Math.sqrt(result) 로 최적화할때는  < 가 아니라 <= 다.
                for (int k = 3; k <= Math.sqrt(result); k +=2) {
                    if (result % k == 0)
                        isPrimeNum = false;
                }
                if (isPrimeNum) {
                    if (!answerlist.contains(result)) {
                        answerlist.add(result);
                        System.out.print(result + " ");
                    }
                }

            }
        }

        System.out.println();

        return answerlist.size();
    }
}