import java.util.ArrayList;
import java.util.LinkedList;

public class PlaneTicket {

    class Ticket{
        String mSrc;
        String mDst;
    }

    String mCurrentSrc = "ICN";

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        ArrayList<String> result = new ArrayList<>();
        LinkedList<Ticket> ticketList = new LinkedList<Ticket>();

        for(String[] ticket : tickets)
        {
            Ticket newTicket = new Ticket();
            newTicket.mSrc = ticket[0];
            newTicket.mDst = ticket[1];
            ticketList.add(newTicket);
        }

        while(!ticketList.isEmpty())
        {
            //현재 Src와 같은 src인 티켓을 찾는다.
            ArrayList<Ticket> foundedList = new ArrayList<>();
            for(Ticket ticket : ticketList)
            {
                if(ticket.mSrc.equals(mCurrentSrc))
                    foundedList.add(ticket);
            }

            if(foundedList.isEmpty())
                break;

            //찾은 것 중에서 알파벳순으로 가장 작은것 구함
            Ticket founded = foundedList.get(0);
            for(int i = 1; i<foundedList.size(); ++i)
            {
                Ticket toCompare =  foundedList.get(i);
                founded = toCompare.mDst.compareTo(founded.mDst) < 0 ? toCompare : founded;
            }

            //현재 src 찾은 티켓의 dst로
            mCurrentSrc = founded.mDst;
            //찾은것은 목록에서 제거
            ticketList.remove(founded);
            //결과에 출발지 추가
            result.add(founded.mSrc);
            //마지막에는 목적지도 추가
            if(ticketList.isEmpty())
                result.add(founded.mDst);
        }


        return result.toArray(answer);
    }

}
