import java.util.ArrayList;
import java.util.HashSet;

public class PhoneBook {

    //https://programmers.co.kr/learn/courses/30/lessons/42577
    //굳이 해시를 쓰지 않아도 된다.
    //substring을 썼지만, startWith이라는 함수가 있더라..
    //딱히 ArrayList도 필요없고 그냥 phone_book을 이중포문돌리면 된다.

    public static void main(String[] args) {
        PhoneBook module = new PhoneBook();
        System.out.println(module.solution(new String[]{"119", "97674223", "1195524421"}));
    }

    /*
        //이거 신기..
        public boolean solution(String[] phone_book) {
        String text = String.format(" %s", String.join(" ", phone_book));
        String[] arr = text.split(" 119");

     */
    public boolean solution(String[] phone_book) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        for(String src : phone_book)
        {
            if(phoneNumbers.contains(src))
                return false;
            for(String dst : phoneNumbers)
            {
                boolean equal;
                if(src.length() > dst.length())
                    equal = dst.equals(src.substring(0, dst.length()));
                else
                    equal = src.equals(dst.substring(0, src.length()));

                if(equal)
                    return false;
            }
            phoneNumbers.add(src);
        }


        return true;
    }

}
