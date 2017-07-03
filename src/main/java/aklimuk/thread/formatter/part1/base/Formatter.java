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
package aklimuk.thread.formatter.part1.base;

/**
 * @author <a href="mailto:aklimuk@gmail.com">Alexander Klimuk</a>
 */
public class Formatter {

	private final static char[] BUFFER = new char[8];

	private final static char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public String format(int number) {
		// Fill the buffer with using the last digit of the given number
		for (int i = 0; i < BUFFER.length; i++) {
			int digit = number % 10;
			BUFFER[i] = getCharForDigit(digit);
		}

		return new String(BUFFER);
	}

	private char getCharForDigit(int digit) {
		work();
		return DIGITS[digit];
	}

	/**
	 * Simulates some work.
	 */
	private void work() {
		int[] a = new int[10000000];
		for (int j = 0; j < a.length; j++) {
			a[j] = j;
		}
	}
}
