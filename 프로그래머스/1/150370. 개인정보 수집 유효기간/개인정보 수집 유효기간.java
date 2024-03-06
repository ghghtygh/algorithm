import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

class Solution {

        private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        private static LocalDate parse(String dt) {
            return LocalDate.parse(dt, DATE_TIME_FORMATTER);
        }

        public int[] solution(String today, String[] terms, String[] privacies) {

            List<Integer> answerList = new ArrayList<>();
            LocalDate todayDt = parse(today);
            Map<String, Integer> termsMap = new HashMap<>();

            for (String term : terms) {
                StringTokenizer st = new StringTokenizer(term);
                termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < privacies.length; i++) {
                StringTokenizer st = new StringTokenizer(privacies[i]);
                if (isOver(todayDt, st.nextToken(), termsMap.get(st.nextToken()))) {
                    answerList.add(i + 1);
                }
            }

            return answerList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        public static boolean isOver(LocalDate today, String collected, int term) {
            LocalDate collectedDt = parse(collected);
            return today.isAfter(collectedDt.plusMonths(term).minusDays(1));
        }

    }