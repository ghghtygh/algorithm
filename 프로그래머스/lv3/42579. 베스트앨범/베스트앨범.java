
import java.util.*;
import static java.util.Collections.sort;

class Solution {
public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
        }
        Map<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }


        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            List<Map> list = new ArrayList<>();
//            System.out.println("entry.getValue() = " + entry.getValue());
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(entry.getValue())) {
                    Map<String, Integer> map = new HashMap<>();
                    map.put("index", i);
                    map.put("count", plays[i]);
                    list.add(map);
                }
            }
            sort(list, new Comparator<Map>() {
                @Override
                public int compare(Map o1, Map o2) {
                    return (int) o2.get("count") - (int) o1.get("count");
                }
            });

            resultList.add((int) list.get(0).get("index"));
            if(list.size() > 1){
                resultList.add((int) list.get(1).get("index"));
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
//            System.out.println("resultList.get(i) = " + resultList.get(i));
        }
        return result;
    }
}