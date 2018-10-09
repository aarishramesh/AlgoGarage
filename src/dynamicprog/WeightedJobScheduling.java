package dynamicprog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeightedJobScheduling {

	public static void main(String[] args) {
		int[][] jobTimings = {{1, 3}, {4, 6}, {6, 7}, {5, 8}, {7, 9}, {2, 5}};
		int[] costs = {5, 5, 4, 11, 2, 6};
		System.out.println(weightedJobScheduling(jobTimings, costs));
	}
	
	public static int weightedJobScheduling(int[][] jobTimings, int[] costs) {
		List<Job> jobsList = new ArrayList<Job>();
		for (int i = 0; i < jobTimings.length; i++) {
			Job job = new Job(jobTimings[i][0], jobTimings[i][1], costs[i]);
			jobsList.add(job);
		}
		jobsList.sort(new JobComparator());
		
		int[] result = new int[costs.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = jobsList.get(i).cost;
		}
		
		int max = 0;
		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (jobsList.get(i).startTime >= jobsList.get(j).endTime) {
					if (jobsList.get(j).cost + jobsList.get(i).cost > result[i]) {
						result[i] = Math.max(result[i], jobsList.get(j).cost + jobsList.get(i).cost);
						if (max < result[i])
							max = result[i];
					}
				}
			}
		}
		return max;
	}
	
	static class Job {
		int startTime;
		int endTime;
		int cost;
		
		Job(int startTime, int endTime, int cost) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.cost = cost;
		}
	}
	
	static class JobComparator implements Comparator<Job> {

		@Override
		public int compare(Job arg0, Job arg1) {
			if (arg0.endTime < arg1.endTime) {
				return -1;
			}
			return 1;
		}
		
	}
}
