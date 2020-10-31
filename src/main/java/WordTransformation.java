

public class WordTransformation {

    int minCount = Integer.MAX_VALUE;

    //https://programmers.co.kr/learn/courses/30/lessons/43163
    //이 문제는 변환된 횟수를 리턴해야되기 때문에 스택말고 재귀로 해야한다.

    public static void main(String[] args)
    {
        WordTransformation module = new WordTransformation();
        int result = module.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println(result);
    }

    //a와 b가 불일치하는 캐릭터 수를 리턴. (순서고려)
    int CompareWord(String a, String b)
    {
        int result = 0;
        for(int i =0; i<a.length(); ++i)
        {
            if(a.charAt(i) != b.charAt(i))
                result++;
        }

        return result;

    }

    int dfs(int cnt, String begin, String target, String[] words, boolean[] check)
    {
        //변환에 성공한 경우
        if(begin.equals(target))
            return cnt;

        for(int i =0; i<words.length; ++i)
        {
            int beginToTarget = CompareWord(begin, target);
            int wordToTarget = CompareWord(words[i], target);

            //목표와의 차이가 줄어들고, 현재단어와 1차이 나는 단어고, 전에 방문한적이 없으면
            if(wordToTarget <= beginToTarget && CompareWord(begin, words[i]) == 1 && !check[i])
            {
                check[i] = true;
                int result = dfs(cnt + 1, words[i], target, words, check);
                if(result < minCount)
                    minCount = result;
                check[i] = false;

            }
        }

        //더 작은결과를 위로 리턴
        return minCount;

    }


    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        dfs(0, begin, target, words, new boolean[words.length]);

        return (minCount == Integer.MAX_VALUE) ? 0 : minCount;
    }


}
