import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileSort {

    public static void main(String[] args) {
        FileSort module = new FileSort();
       String[] strs = module.solution(new String[]{ "MUZI 01.zip","mu zi1.png","A-7-00123" });


        for(String str : strs) System.out.println(str);

    }



    class File {
        String head = "";
        String number = "";
        String tail = "";
    }

    File makeFile(String str)
    {
        boolean isEnterNumber = false;
        boolean isEnterTail = false;

        File file = new File();

        for (int i = 0; i < str.length(); ++i) {
            char currChar = str.charAt(i);
            //대문자를 모두 소문자로
            if(currChar >= 'A' && currChar <= 'Z')
                currChar += 'a' - 'A';

            //전에는 숫자였는데
            if(isEnterNumber)
            {
                //이번엔 숫자가 아니면
                if(currChar < '0' || currChar > '9')
                {
                    //테일이다
                    file.tail += currChar;
                    isEnterTail = true;
                }
            }

            //테일이 아니고, 숫자면
            if (!isEnterTail && currChar >= '0' && currChar <= '9') {
                file.number += currChar;
                isEnterNumber = true;
            }

            if(!isEnterNumber && !isEnterTail)
                file.head += currChar;

        }
        return file;
    }

    public String[] solution(String[] files) {

        Arrays.sort(files, (a, b) -> {
            //파싱
            File fileA = makeFile(a);
            File fileB = makeFile(b);

            int alphabetical = fileA.head.compareTo(fileB.head);

            Integer numA  = Integer.parseInt(fileA.number);
            Integer numB = Integer.parseInt(fileB.number);
            int compareNumber = numA.compareTo(numB);

            if(alphabetical < 0)
               return -1;
            if(alphabetical == 0)
            {
                if(compareNumber < 0)
                    return -1;
            }

            return 0;
        });


        return files;
    }

}
