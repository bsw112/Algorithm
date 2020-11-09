import java.lang.reflect.Array;
import java.util.*;

public class PlaneTicket2 {


    /*
    https://programmers.co.kr/learn/courses/30/lessons/43164

    조건 1. 모든 도시를 거친다.
    조건 2. 티켓을 다 쓴다. (answer.length == tickets.length + 1)

    깊이탐색을 하면서(결국엔 모든 경우의 수를 탐색) 조건 1과 2를 모두 만족하는 루트를 찾는다.
    너비탐색은 마치 개미굴에 물을 붓듯이 처음부터 모든 경로를 탐색하려하므로 시간이 더 오래걸릴 듯.

    깊이탐색을 하면서 막다른 길이면 쓴 티켓을 다시 안쓴 상태로 되돌려야한다
     */



    public static void main(String[] args) {

        String[][] input = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
                {"ATL", "SFO"}};


        String[] arr = new PlaneTicket2().solution(input);
        for (String s : arr) {
            System.out.println(s);

        }
    }

    //재귀는 분신술이다.
    // 문제 -> A -> B -> C -> D
    // A <- B <- C <- D 결과
    // 중간에 for문을 돌려 재귀를 호출하면 분기가 생기겠지.

    //재귀를 이용한다는 것 자체가 스택을 이용한다는것.
    //재귀를 이용한 dfs랑 스택을 이용한 dfs의 차이점은
    //재귀를 이용하면 반복횟수가 횔씬많다는 것이다.
    //스택을 이용하면 막다른길에 도달했을때 바로 분기점으로 뛰어넘어가지만
    //재귀는 되돌리기하는 것처럼 하나하나 와인딩된다.
    //때문에 어떤 경로(단순히 탐색경로 말고)를 출력할 필요가 있을때는 재귀를 쓰는게 좋다.
    public boolean dfs(String start, String[][] tickets, ArrayList<Boolean> checked, ArrayList<String> answer, int endSize, int count)
    {
        //일단 경로에 넣자.
        answer.add(start);

        //만약 모든 티켓을 사용했다면
        if(answer.size() >= endSize +1)
            return true;


        for(int i = 0; i<tickets.length; ++i) {

            //start와 티켓의 출발지가 같고, 사용하지 않은 티켓이면
            if(tickets[i][0].equals(start) && !checked.get(i))
            {
                //사용했다고 표시
                checked.set(i, true);
                //자식노드(그래프니까 인접노드)로 하여금 현재 사용한 티켓의 목적지를 출발지로 하는 티켓을 찾아서 똑같은 로직을 반복하도록 한다.
                boolean result = dfs(tickets[i][1], tickets, checked, answer, endSize,count +1);

                //만약 if(answer.size() >= endSize +1)에 결려서 true를 리턴했다면 끝
                if(result)
                    return true;
                //아니면 현재 사용한 티켓을 사용하지 않은 상태로 만든다. (무른다)
                else
                    checked.set(i, false);

            }

        }

        //만약 모든티켓을 사용하지 않았다면
        answer.remove(answer.size() - 1);
        return false;


    }


    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, (a, b) -> {
            String Astr = a[0] + a[1];
            String Bstr = b[0] + b[1];
            return Astr.compareTo(Bstr);
        });

        //reserve와 같은효과 (capacity)
       // ArrayList<Boolean> checked = new ArrayList<Boolean>(tickets.length);

        //리스트 초기화와 동시에 배열방 확보
        ArrayList<Boolean> checked = new ArrayList<Boolean>(Arrays.asList(new Boolean[tickets.length]));
        Collections.fill(checked, false);



        String[] answer = {};
        ArrayList<String> path = new ArrayList<>();
        dfs("ICN", tickets, checked, path, tickets.length, 0);
        return path.toArray(answer);
    }


}
