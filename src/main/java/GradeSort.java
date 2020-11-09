import java.util.*;

public class GradeSort {


    public static void main(String[] args) {
        GradeSort module = new GradeSort();
        module.solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"});
    }

    class Grade {
        String serial = "";
        String grade = "";
    }


    Grade makeGrad(String grade) {
        String[] tmpA = grade.split(" ");
        Grade gradeA = new Grade();
        gradeA.serial = tmpA[0];
        gradeA.grade = tmpA[1];
        return gradeA;
    }

    int compareGrade(String gradeA, String gradeB) {
        char[] additional = new char[]{'?', '-', '0', '+'};

        Character alphabetA = gradeA.charAt(0);
        Character alphabetB = gradeB.charAt(0);
        //알파벳 b가 더 작으면 알파벳a가 더 큰거니 양수리턴
        int abcally = alphabetB.compareTo(alphabetA);

        if (abcally == 0) {
            //0은 F를 뜻함
            Integer additionA = 0;
            Integer additionB = 0;
            for (int i = 0; i < additional.length; ++i) {
                if (gradeA.contains(additional[i] + ""))
                    additionA = i;

                if (gradeB.contains(additional[i] + ""))
                    additionB = i;
            }

            return additionA.compareTo(additionB);
        }

        return abcally;
    }

    public String[] solution(String[] grades) {



        //이름순 정렬
        Arrays.sort(grades, (a, b) -> {

            Grade gradeA = makeGrad(a);
            Grade gradeB = makeGrad(b);
            return gradeA.serial.compareTo(gradeB.serial);
        });

        ArrayList<Grade> answer = new ArrayList<>();

        //그룹별로 가장큰거 찾기
        //가장 좋은 학점만 남기고 중복을 지운다.
        Grade maxGrade = makeGrad(grades[0]);
        for (int i = 1; i < grades.length; ++i) {
            Grade currGrade = makeGrad(grades[i]);
            //그룹전환
            if(!maxGrade.serial.equals(currGrade.serial))
            {
                answer.add(maxGrade);
                maxGrade = currGrade;
                continue;
            }
            //비교
            if (compareGrade(currGrade.grade, maxGrade.grade) > 0)
            {
                maxGrade = currGrade;
            }

            if(i == grades.length -1)
            {
                answer.add(maxGrade);
            }
        }



        //성적순 정렬.
        answer.sort((a, b)-> compareGrade(a.grade, b.grade));
        Collections.reverse(answer);


        ArrayList<String> result = new ArrayList<>();
        for (Grade grade : answer)
            result.add(gradeToString(grade));

        String[] tmp = {};
        return result.toArray(tmp);
    }


    String gradeToString(Grade grade) {
        return grade.serial + " " + grade.grade;
    }
}
