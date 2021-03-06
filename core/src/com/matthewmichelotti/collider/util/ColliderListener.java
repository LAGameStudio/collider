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

import com.matthewmichelotti.collider.ColliderEvent;

/**
 * An Event Listener interface for handling events generated by
 * a {@link com.matthewmichelotti.collider.Collider}.
 *
 * @see ColliderProcess
 * @author Matthew Michelotti
 */
public interface ColliderListener {

	/**
	 * Handle a collision event, called when two interactable HitBoxes
	 * collide.
	 * @param evt The collision event.
	 */
	public void collision(ColliderEvent evt);

	/**
	 * Handle a separation event, called when two interactable HitBoxes
	 * separate.
	 * @param evt The separation event.
	 */
	public void separation(ColliderEvent evt);
}
