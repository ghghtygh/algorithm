import static java.util.Collections.*;

import java.util.*;

class Solution {
    static class Song {
        private final int index;
        private final int count;

        public Song(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public int getCount() {
            return count;
        }
    }

    static class Genres {
        private int playCount;
        private final List<Song> songs;

        public Genres(int playCount, List<Song> songs) {
            this.playCount = playCount;
            this.songs = songs;
        }

        public void addSong(Song song) {
            this.songs.add(song);
        }

        public void addCount(int playCount) {
            this.playCount += playCount;
        }

        public int getPlayCount() {
            return this.playCount;
        }

        public List<Song> getSongs() {
            return this.songs;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genres> genresCntMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Genres gnr = genresCntMap.getOrDefault(genres[i], new Genres(0, new ArrayList<>()));
            Song song = new Song(i, plays[i]);
            gnr.addCount(plays[i]);
            gnr.addSong(song);
            genresCntMap.put(genres[i], gnr);
        }

        return genresCntMap.values()
            .stream()
            .sorted((o1, o2) -> o2.getPlayCount() - o1.getPlayCount())
            .flatMap(genres1 -> genres1.getSongs()
                .stream()
                .sorted((o1, o2) -> o2.getCount() - o1.getCount())
                .limit(2)
            )
            .mapToInt(Song::getIndex)
            .toArray();
    }
}