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
package aklimuk.thread.counter.part4.syncsection;

/**
 * @author <a href="mailto:aklimuk@gmail.com">Alexander Klimuk</a>
 */
public class Counter {

	private static Integer value = new Integer(0);

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer newValue) {
		value = newValue;
	}

}
