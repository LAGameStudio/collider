/*
 * Copyright 2013-2014 Matthew D. Michelotti
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewmichelotti.collider.util;

import com.matthewmichelotti.collider.Collider;
import com.matthewmichelotti.collider.ColliderEvent;
import com.matthewmichelotti.collider.ColliderOpts;

/**
 * A ContProcess implementation wrapped around a Collider.
 *
 * @author Matthew Michelotti
 */
public class ColliderProcess implements ContProcess {
	private Collider collider;
	private ColliderListener listener;

	/**
	 * Constructs a new ColliderProcess.
	 * @param collider The underlying Collider object.
	 * @param listener A listener to handle events from the Collider.
	 */
	public ColliderProcess(Collider collider, ColliderListener listener) {
		if(collider == null || listener == null) throw new IllegalArgumentException();
		this.collider = collider;
		this.listener = listener;
	}

	/**
	 * Constructs a new ColliderProcess.
	 * @param opts A new Collider object will be constructed from these options.
	 * @param listener A listener to handle events from the Collider.
	 */
	public ColliderProcess(ColliderOpts opts, ColliderListener listener) {
		this(new Collider(opts), listener);
	}

	@Override
	public double peekNextEventTime() {
		return collider.peekNextEventTime();
	}

	@Override
	public void stepToTime(double time) {
		ColliderEvent evt = collider.stepToTime(time, false);
		if(evt != null) throw new RuntimeException();
	}

	@Override
	public void resolveEvent() {
		double time = collider.getTime();
		ColliderEvent evt = collider.stepToTime(time);
		if(evt != null) {
			if(evt.isCollision()) listener.collision(evt);
			else if(evt.isSeparation()) listener.separation(evt);
		}
	}
}
