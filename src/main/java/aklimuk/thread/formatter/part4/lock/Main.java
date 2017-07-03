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
package aklimuk.thread.formatter.part4.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The logic is executed in 10 threads. Formatter contains a static element. A
 * {@link Lock} is used to synchronized access to the formatter.
 * <p>
 * Expected: Each thread produces its own number: 00000000, 11111111, 22222222,
 * etc.
 * </p>
 * <p>
 * Actual: Each thread produces its own number: 00000000, 11111111, 22222222,
 * etc. OK.
 * </p>
 * 
 * @author <a href="mailto:aklimuk@gmail.com">Alexander Klimuk</a>
 */
public class Main {

	public static void main(String[] args) {
		int threadNum = 10;

		Thread[] threads = new Thread[threadNum];

		Lock lock = new ReentrantLock();

		// Create threads
		for (int i = 0; i < threads.length; i++) {
			SyncWorker worker = new SyncWorker(i + 1, i, lock);
			threads[i] = new Thread(worker);
		}

		// Start threads
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}

}
