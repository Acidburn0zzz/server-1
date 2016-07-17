/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.hboxd.store;

public interface _Store {

    /**
     * Get the Unique ID for the store for this server
     * 
     * @return a String containing the ID
     */
    public String getId();

    public String getType();

    /**
     * Get the label assigned to this store
     * 
     * @return a String for this store's label
     */
    public String getLabel();

    public String getLocation();

    /**
     * Get the root container for this store
     * 
     * @return a StoreItem that is a container, at the root of the store
     */
    public _StoreItem getContainer();

    public _StoreItem getItem(String path);

    public boolean isValid();

}
