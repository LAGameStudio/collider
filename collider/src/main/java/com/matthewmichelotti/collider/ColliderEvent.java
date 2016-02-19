/*
 * Copyright 2013-2016 Matthew D. Michelotti
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

package com.matthewmichelotti.collider;

/**
 * A collision or seperation event between two HitBoxes.
 *
 * @author Matthew Michelotti
 */
public final class ColliderEvent {
	private HitBox a, b;
	private boolean collided;

	public static ColliderEvent newCollide(HitBox a, HitBox b) {
		return new ColliderEvent(a, b, true);
	}

	public static ColliderEvent newSeparation(HitBox a, HitBox b) {
		return new ColliderEvent(a, b, false);
	}
	
	ColliderEvent(HitBox a, HitBox b, boolean collided) {
		if(a == null || b == null) throw new RuntimeException();
		this.a = a;
		this.b = b;
		this.collided = collided;
	}

	public ColliderEvent swap() {
		return new ColliderEvent(b, a, collided);
	}
	
	/**
	 * Returns the time of the event.
	 * This is the same as calling {@link Collider#getTime()}.
	 * @return The time of the event.
	 */
	public double getTime() {return a.getTime();}
	
	/**
	 * Returns true if this is a collision event.
	 * @return True if this is a collision event.
	 */
	public boolean isCollision() {return collided;}
	
	/**
	 * Returns true if this is a separation event.
	 * @return True if this is a separation event.
	 */
	public boolean isSeparation() {return !collided;}
	
	/**
	 * Returns the first HitBox involved in this event.
	 * @return The first HitBox involved in this event.
	 */
	public HitBox getFirstHitbox() {return a;}
	
	/**
	 * Returns the second HitBox involved in this event.
	 * @return The second HitBox involved in this event.
	 */
	public HitBox getSecondHitbox() {return b;}

	public Object getFirst() {return a.getOwner();}
	public Object getSecond() {return b.getOwner();}
	
	/**
	 * Given one of the HitBoxes involved in this event, this is a convenience method
	 * for obtaining the other involved HitBox.
	 * Like using <code>(hitBox == getFirst()) ? getSecond() : getFirst()</code>.
	 * @param hitBox One of the HitBoxes involved in this event.
	 * @return The other HitBox involved in this event.
	 */
	public HitBox getOther(HitBox hitBox) {
		if(a == hitBox) return b;
		else if(b == hitBox) return a;
		else throw new IllegalArgumentException();
	}
}
