
import java.util.*;

class Solution {
    static class Song {
		int idx;
		String genre;
		int play;

		int genreIdx = 1;

		public Song(int idx, String genre, int play) {
			this.idx = idx;
			this.genre = genre;
			this.play = play;
		}
	}
    public int[] solution(String[] genres, int[] plays) {

		Map<String, Integer> genreMap = new HashMap<>();
		List<Song> songList = new ArrayList<>();

		for (int i = 0; i < genres.length; i++) {
			genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
			songList.add(new Song(i, genres[i], plays[i]));
		}

		Collections.sort(songList, (o1, o2) -> {

			int compareGenre = genreMap.get(o2.genre) - genreMap.get(o1.genre);
			if (compareGenre != 0) {
				return compareGenre;
			}

			int comparePlay = o2.play - o1.play;
			if (comparePlay != 0) {
				return comparePlay;
			}

			return o1.idx - o2.idx;

		});

		for (int i = 1; i < songList.size(); i++) {
			Song now = songList.get(i);
			Song prev = songList.get(i - 1);
			
            if (now.genre.equals(prev.genre)) {
				now.genreIdx = prev.genreIdx + 1;
			}
            
			if (now.genreIdx > 2) {
				songList.remove(now);
			}
		}
		return songList.stream()
			.mapToInt(song -> song.idx)
			.toArray();
	}
}