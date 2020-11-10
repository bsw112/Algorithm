import java.util.*;

public class Spy {

    //https://programmers.co.kr/learn/courses/30/lessons/42578
    //dfs로 풀려고 했으나 단순한 수학으로 풀 수 있는 문제.
    // 모자, 옷, 신발이 주어졌을때 조합에서 안입는경우도 고려하려면 그냥 +1을 했으면 됬다.

    public static void main(String[] args) {
        Spy module = new Spy();
        int answer = module.solution(new String[][]{
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        });
        System.out.println(answer);

    }


    int dfs(int mul, int maxDepth, int currDepth, int[] itemsPerEquipment, boolean[] visited) {

        if (currDepth > maxDepth)
            return mul;

        int sum = 0;
        for (int i = 0; i < itemsPerEquipment.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            sum += dfs(mul * itemsPerEquipment[i], maxDepth, currDepth + 1, itemsPerEquipment, visited);
        }

        return sum;

    }

    public int solution(String[][] clothes) {
        Map<String, ArrayList<String>> clothesMap = new HashMap();

        //장비칸별로의 아이템을 표현하는 clothesMap을 준비
        for (int i = 0; i < clothes.length; i++) {
            if (clothesMap.get(clothes[i][1]) == null)
                clothesMap.put(clothes[i][1], new ArrayList<>(List.of(clothes[i][0])));
            else
                clothesMap.get(clothes[i][1]).add(clothes[i][0]);
        }

        int answer = 1;
        for (ArrayList<String> arr : clothesMap.values()) {
            //+1은 안입는경우를 추가히기 위함.
            answer *= arr.size() + 1;
        }
        //모두 안입는경우를 고려하지 않음.
        answer--;



//        //장비칸당 아이템 갯수
//        int[] itemsPerEquipment = new int[clothesMap.size()];
//        int indexForItems = 0;
//        for (ArrayList<String> items : clothesMap.values())
//            itemsPerEquipment[indexForItems++] = items.size();
//
//        int sum = 0;
//        for (int i = 0; i < itemsPerEquipment.length; i++) {
//            sum += dfs(1, i, 0, itemsPerEquipment, new boolean[itemsPerEquipment.length]);
//        }

        return answer;
    }
}
