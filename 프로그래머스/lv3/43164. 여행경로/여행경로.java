
class Solution {

	int ticketCnt;
	boolean[] isVisited;
	final static String FIRST_AIRPORT = "ICN";

	String routeStr;
	String[] routeArr;

	String[][] tickets;

	public String[] solution(String[][] tickets) {

		this.ticketCnt = tickets.length;
		this.isVisited = new boolean[this.ticketCnt];

		StringBuilder sb = new StringBuilder(FIRST_AIRPORT);
		for (int i = 0; i < ticketCnt; i++) {
			sb.append("ZZZ");
		}
		routeStr = sb.toString();
		routeArr = new String[] {};
		this.tickets = tickets;

		dfs(FIRST_AIRPORT, 0, new String[ticketCnt + 1]);

		return routeArr;
	}

	private void dfs(String nowAirport, int depth, String[] route) {

		route[depth] = nowAirport;
		// System.out.println("#depth" + depth + " >> " + nowAirport);

		if (depth >= ticketCnt) {
			StringBuilder sb = new StringBuilder();
			for (String str : route) {
				sb.append(str);
			}
			String newRouteStr = sb.toString();

			if (newRouteStr.compareTo(routeStr) <= 0) {
				routeStr = newRouteStr;
				routeArr = route.clone();
			}
			return;
		}

		for (int i = 0; i < ticketCnt; i++) {
			if (!isVisited[i] && nowAirport.equals(tickets[i][0])) {
				isVisited[i] = true;
				dfs(tickets[i][1], depth + 1, route);
				isVisited[i] = false;
			}
		}

	}
}