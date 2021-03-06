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
package aklimuk.thread.formatter.part3.syncsection;

/**
 * Simulates an application. Uses a lock to synchronize its work with other
 * threads.
 * 
 * @author <a href="mailto:aklimuk@gmail.com">Alexander Klimuk</a>
 */
public class SyncWorker implements Runnable {

	private Object lock;

	/**
	 * Number to format.
	 */
	private int num;

	/**
	 * Prefix is used to distinguish the output position of each thread. Each
	 * thread has its own prefix.
	 */
	private String prefix;

	public SyncWorker(int printPosition, int num, Object lock) {
		this.num = num;
		this.lock = lock;
		prefix = "";
		for (int i = 0; i < printPosition; i++) {
			prefix = prefix + "          ";
		}
	}

	@Override
	public void run() {
		Formatter formatter = new Formatter();
		for (int i = 1; i <= 10; i++) {
			// Simulate some work
			work();

			String formattedText;

			// Use the lock to synchronize access to the formatter
			synchronized (lock) {
				formattedText = formatter.format(num);
			}

			// Print the formatted text
			System.out.println(prefix + formattedText);
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
