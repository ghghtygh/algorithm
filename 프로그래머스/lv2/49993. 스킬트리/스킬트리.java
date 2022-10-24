import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skill_trees) {

		char[] skillChars = skill.toCharArray();
		return (int)Arrays.stream(skill_trees).filter((skillTree) -> isValid(skillChars, skillTree)).count();
	}

	public boolean isValid(char[] skillChars, String skillTree) {

		int[] arr = convertTreeToIntArr(skillChars, skillTree);

		int prev = -1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < 0) {
				continue;
			}

			if (arr[i] < prev) {
				return false;
			}

			if (i > 0 && arr[i - 1] < 0) {
				return false;
			}

			prev = arr[i];
		}

		return true;
	}

	public int[] convertTreeToIntArr(char[] skillChars, String skillTree) {

		int[] arr = new int[skillChars.length];
		for (int i = 0; i < skillChars.length; i++) {
			arr[i] = skillTree.indexOf(skillChars[i]);
		}
		return arr;
	}
}