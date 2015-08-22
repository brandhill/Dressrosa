/*
Subarray Sum Closest
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
Challenge
O(nlogn) time
*/
/*
Array.sort() time O(nlogn)
*/
public class SubSumCloSol {
	public static List<Integer> subarraySumClosest(int[] nums) {
		List<Integer> rst = new ArrayList<Integer>();
		if (nums.length == 0) {
			return rst;
		}
		
		int len = nums.length;
		Element[] sums = new Element[len + 1];
		sums[0] = new Element(0, -1);
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			sums[i + 1] = new Element(sum, i);
		}
		
		Arrays.sort(sums);
		int min = Math.abs(sums[0].getValue() - sums[1].getValue());
		int start = Math.min(sums[0].getIndex(), sums[1].getIndex()) + 1;
		int end = Math.max(sums[0].getIndex(), sums[1].getIndex());
		for (int i = 1; i < len; i++) {
			int diff = Math.abs(sums[i].getValue() - sums[i + 1].getValue());
			if (diff < min) {
				min = diff;
				start = Math.min(sums[i].getIndex(), sums[i + 1].getIndex()) + 1;
				end = Math.max(sums[i].getIndex(), sums[i + 1].getIndex());
			}
		}
		rst.add(start);
		rst.add(end);
		return rst;
	}
	
	public static class Element implements Comparable<Element> {
		int val;
		int index;
		public Element(int v, int i) {
			val = v;
			index = i;
		}
		
		public int compareTo(Element other) {
			return this.val - other.val;
		}
		
		public int getIndex() {
			return index;
		}
		
		public int getValue() {
			return val;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-3, 1, 1, -3, 5};
		System.out.print(subarraySumClosest(nums));
	}
}
/*
 * outputs:
 * [1, 3]
 */
