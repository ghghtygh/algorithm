class Solution {
    public static class Player {
        private final int videoLength;
        private int pos;
        private final int opStart;
        private final int opEnd;
        private final int offset = 10;

        public Player(String videoLength, String pos, String opStart, String opEnd) {
            this.videoLength = convertToInt(videoLength);
            this.pos = convertToInt(pos);
            this.opStart = convertToInt(opStart);
            this.opEnd = convertToInt(opEnd);
            this.pos = isOpening() ? this.opEnd : this.pos;
        }

        private static int convertToInt(String input) {
            String[] arr = input.split(":");
            return (Integer.parseInt(arr[0])) * 60 + Integer.parseInt(arr[1]);
        }

        public void next() {
            this.pos = Math.min(pos + offset, videoLength);
            this.pos = isOpening() ? opEnd : pos;
        }

        public void prev() {
            this.pos = Math.max(pos - offset, 0);
            this.pos = isOpening() ? opEnd : pos;
        }

        public boolean isOpening() {
            return pos >= opStart && pos <= opEnd;
        }

        public String getResult() {
            int hour = pos / 60;
            int second = pos % 60;
            return String.format("%02d:%02d", hour, second);
        }
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Player player = new Player(video_len, pos, op_start, op_end);
        for (String command : commands) {
            if ("prev".equals(command)) {
                player.prev();
            } else {
                player.next();
            }
        }

        return player.getResult();
    }
}