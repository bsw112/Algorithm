import java.util.*;

public class BestAlbum {

    //https://programmers.co.kr/learn/courses/30/lessons/42579
    //어려운문제는 아니다. 맵을 정렬하는 방법을 이번에 알았다.
    //문제에 반드시 장르당 곡이 2개이상이라고는 안했으니 그부분은 예외처리 해줘야한다.

    public static void main(String[] args) {
        BestAlbum module = new BestAlbum();
        module.solution(new String[]{"classic", "pop", "classic","classic", "pop"}, new int[]{
                500, 600, 150, 800, 2500
        });
    }

    class Song {
        Integer playCnt = 0;
        int index = 0;
    }

    public int[] solution(String[] genres, int[] plays) {

        //맵을 정렬하기 위해 입력한 순서가 보장되는 링크드해쉬맵을 쓴다.
        LinkedHashMap<String, ArrayList<Song>> songsForGenre = new LinkedHashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Song song = new Song();
            song.index = i;
            song.playCnt = plays[i];
            if (songsForGenre.get(genres[i]) == null)
                songsForGenre.put(genres[i], new ArrayList<>(List.of(song)));
            else {
                songsForGenre.get(genres[i]).add(song);
            }
        }


        songsForGenre = sortMap(songsForGenre);

        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, ArrayList<Song>> entry : songsForGenre.entrySet())
        {
            if(entry.getValue().size() > 0)
                answer.add(entry.getValue().get(0).index);
            if(entry.getValue().size() > 1)
                answer.add(entry.getValue().get(1).index);

        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    LinkedHashMap<String, ArrayList<Song>> sortMap(Map<String, ArrayList<Song>> map) {
        LinkedList<Map.Entry<String, ArrayList<Song>>> entries = new LinkedList<>(map.entrySet());
        //카테고리별 플레이카운트를 기준으로 내림차순정렬
        Collections.sort(entries, (a, b) -> {
            Integer sumGenreA = 0;
            Integer sumGenreB = 0;
            for (Song song : a.getValue())
                sumGenreA += song.playCnt;
            for (Song song : b.getValue())
                sumGenreB += song.playCnt;
            return sumGenreB.compareTo(sumGenreA);
        });

        //카테고리 안에서 Song을 내림차순 정렬
        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).getValue().sort((a,b) ->{
                return b.playCnt.compareTo(a.playCnt);
            });
        }

        LinkedHashMap<String, ArrayList<Song>> result = new LinkedHashMap<String, ArrayList<Song>>();
        for (Map.Entry<String, ArrayList<Song>> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
