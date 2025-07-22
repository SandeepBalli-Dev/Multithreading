package com.example.multithreading.threadpool.forkjoinpool;

import java.util.concurrent.RecursiveTask;

public class ComputeTask extends RecursiveTask<Integer> {

	int start;
	int end;

	public ComputeTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {

		if (end - start < 4) {
			int totalSum = 0;
			for (int i = start; i <= end; i++) {
				totalSum += i;
			}
			return totalSum;
		} else {

			int mid = (start + end) / 2;

			ComputeTask leftTask = new ComputeTask(start, mid);
			ComputeTask rightTask = new ComputeTask(mid + 1, end);

			leftTask.fork();
			rightTask.fork();

			int leftResult = leftTask.join();
			int rightResult = rightTask.join();

			return leftResult + rightResult;

		}
	}

}
