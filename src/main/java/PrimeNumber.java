import java.util.ArrayList;
import java.util.LinkedList;

public class PrimeNumber {


    //https://programmers.co.kr/learn/courses/30/lessons/42839
    //한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
    //모든 경우의 수를 가진 table을 만들어서 그 table을 순회하면서 소수인거를 찾아내면된다.

    void MakeTable(LinkedList<Character> dataset, String currNum, ArrayList<String> rainbowTable) {
        if (dataset.isEmpty()) {
            if(!rainbowTable.contains(currNum))
                rainbowTable.add(currNum);
        }

        //모든 경우의 수를 찾는다. 예를들어 '123' 이면 '1' 이 첫번째 숫자일때 가능한 모든 경우의수를 구하고,
        //'2'가 첫번째 숫자일때 가능한 모든 경우의 수를 구하고 ... 3도 마찬가지.
        for (int i = 0; i < dataset.size(); ++i) {
            String number = currNum + dataset.get(i);
            LinkedList<Character> newDataset = new LinkedList<>(dataset);
            newDataset.remove(i);
            MakeTable(newDataset, number, rainbowTable);
        }
    }

    public static void main(String[] args) {
        PrimeNumber module = new PrimeNumber();
         module.solution("1789");
    }


    public int solution(String numbers) {

        ArrayList<Integer> answerlist = new ArrayList<>();
        ArrayList<String> rainbowTable = new ArrayList<>();
        LinkedList<Character> dataset = new LinkedList<>();
        for (int i = 0; i < numbers.length(); ++i)
            dataset.add(numbers.charAt(i));

        //모든 수를 썼을때 나올 수 있는 경우의 수를 모두 구한다.
        MakeTable(dataset, "", rainbowTable);

        //rainbowTable을 가지고 자리수를 점차 늘려가며 소수인지 확인한다.
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