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
package aklimuk.thread.counter.part5.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The logic is executed in 10 threads. An {@link AtomicInteger} is used in the
 * counter.
 * <p>
 * Expected: The counter always reaches value 1000 (10 threads x 100 increments
 * each).
 * </p>
 * <p>
 * Actual: The counter always reaches value 1000. OK.
 * </p>
 * 
 * @author <a href="mailto:aklimuk@gmail.com">Alexander Klimuk</a>
 */
public class Main {

	public static void main(String[] args) {
		int threadNum = 10;

		Thread[] threads = new Thread[threadNum];

		// Create threads
		for (int i = 0; i < threads.length; i++) {
			Worker worker = new Worker(i + 1);
			threads[i] = new Thread(worker);
		}

		// Start threads
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}

}
