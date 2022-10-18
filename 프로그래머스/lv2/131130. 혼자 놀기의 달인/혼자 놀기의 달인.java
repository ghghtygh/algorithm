import java.util.*;


class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groups = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int now = i;
            int cnt = 0;
            while (!visited[now]) {
                cnt++;
                visited[now] = true;
                now = cards[now] - 1;
            }
            groups.add(cnt);
        }
        Collections.sort(groups, Comparator.reverseOrder());
        return (groups.size() == 1) ? 0 : groups.get(0) * groups.get(1);
    }
}

/*
1 2 3 4 5 6 7 8
8 6 3 7 2 5 1 4

1 -> 8 -> 4 -> 7 -> 1 == 4
2 -> 6 -> 5 -> 2 == 3


1 2 3 4 5 6 7 8
8 6 3 7 2 5 1 4


4 * 4 = 16
3 * 5 = 15

1 2 3 4
2 3 4 1


1 2 3 4 5 6 7 8
2 3 4 5 1 7 8 6

1 -> 2 -> 3 -> 4 -> 5 -> 1 == 5
6 -> 7 -> 8 -> 6 == 3
>> 15

1 2 3 4 5 1
6 7 8 6
----------------
1 2 3 5 1 == 4
4 5 == 1
6 7 8 6 == 3
-----------------
4 5 1 2 3 4 == 5
6 7 8 6 == 3
>> 15
------------------


*/