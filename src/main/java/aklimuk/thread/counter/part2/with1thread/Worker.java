/*
 * Copyright 2017 Alexander Klimuk
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package aklimuk.thread.counter.part2.with1thread;

/**
 * Simulates an application.
 * 
 * @author <a href="mailto:aklimuk@gmail.com">Alexander Klimuk</a>
 */
public class Worker implements Runnable {

	/**
	 * Prefix is used to distinguish the output position of each thread. Each
	 * thread has its own prefix.
	 */
	private String prefix;

	public Worker(int printPosition) {
		prefix = "";
		for (int i = 0; i < printPosition; i++) {
			prefix = prefix + "          ";
		}
	}

	@Override
	public void run() {
		Counter cnt = new Counter();
		for (int i = 1; i <= 100; i++) {
			// Simulate some work
			work();

			// Increase the counter
			int oldValue = cnt.getValue();
			int newValue = oldValue + 1;
			cnt.setValue(newValue);

			// Print the counter
			System.out.println(prefix + cnt.getValue());
		}
	}

	/**
	 * Simulates some work.
	 */
	private void work() {
		int[] a = new int[10000000];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}
}
