import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Solution {
     public static class Location {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;

            Location location = (Location)o;

            if (x != location.x)
                return false;
            return y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public void moveLocation(Location location) {
            x += location.getX();
            y += location.getY();
        }

        public Location clone() {
            return new Location(this.x, this.y);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Location{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

    public static Location[] directions = {
        new Location(0, 1),
        new Location(1, 1),
        new Location(1, 0),
        new Location(1, -1),
        new Location(0, -1),
        new Location(-1, -1),
        new Location(-1, 0),
        new Location(-1, 1),
    };

    public int solution(int[] arrows) {
        int answer = 0;
        Location location = new Location(0, 0);
        Map<Location, Set<Integer>> locationMap = new HashMap<>();
        locationMap.put(location.clone(), new HashSet<>());

        for (int arrow : arrows) {

            int prev = arrow >= 4 ? arrow - 4 : arrow + 4;
            Location prevLocation = location.clone(); // 옮기기 전 좌표
            locationMap.get(prevLocation).add(prev); // 반대로 온 길

            location.moveLocation(directions[arrow]); // 좌표 옮김

            Set<Integer> tmp; // 옮긴 후

            boolean skip = false;
            if (!locationMap.containsKey(location)) { // 아예 처음 방문
                tmp = new HashSet<>();
                tmp.add(arrow);
                locationMap.put(location.clone(), tmp);
            } else { // 방문한적 있음
                if (!locationMap.get(location).contains(arrow)) { // 이 방향으로는 첫 방문
                    // 다른 방향에서의 방문만
                    locationMap.get(location).add(arrow);
                    answer += 1;
                } else {
                    skip = true;
                }
            }

            if (!skip && arrow % 2 == 1) {
                prevLocation.moveLocation(directions[arrow - 1]);
                if (locationMap.get(prevLocation) != null
                    && locationMap.get(prevLocation).contains((arrow == 1 ? 7 : arrow - 2))) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}