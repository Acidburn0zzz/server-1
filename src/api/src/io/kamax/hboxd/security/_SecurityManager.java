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

package io.kamax.hboxd.security;

import io.kamax.hbox.comm.Request;
import io.kamax.hbox.comm.SecurityAction;
import io.kamax.hbox.comm.SecurityItem;
import io.kamax.hbox.comm.in.UserIn;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.event._Event;
import io.kamax.hbox.exception.HyperboxException;
import io.kamax.hboxd.exception.security.SecurityException;
import io.kamax.hboxd.persistence._SecurityPersistor;
import java.util.List;

public interface _SecurityManager {

    public _User init(_SecurityPersistor persistor) throws HyperboxException;

    public void start() throws HyperboxException;

    public void stop();

    public void authenticate(String login, char[] password);

    public void authorize(Request req) throws SecurityException;

    public boolean isAuthorized(_User u, _Event ev);

    public void authorize(SecurityItem item, SecurityAction action);

    public boolean isAuthorized(SecurityItem item, SecurityAction action);

    public void authorize(SecurityItem item, SecurityAction action, String itemId);

    public boolean isAuthorized(SecurityItem item, SecurityAction action, String itemId);

    public List<_User> listUsers();

    public _User getUser(String usrId);

    public _User addUser(UserIn uIn);

    public void removeUser(String usrId);

    public _User modifyUser(UserIn uIn);

    public void setUserPassword(String userId, char[] password);

    public void set(_User usr, SecurityItem itemType, SecurityAction action, boolean isAllowed);

    public void removePermission(_User usr);

    public void remove(_User usr, SecurityItem itemType, SecurityAction action);

    public void set(_User usr, SecurityItem itemType, SecurityAction action, String itemId, boolean isAllowed);

    public void remove(_User usr, SecurityItem itemType, SecurityAction action, String itemId);

    public List<_ActionPermission> listActionPermissions(_User usr);

    public List<_ItemPermission> listItemPermissions(_User usr);

    /**
     * List possible permissions for the given entity by using its entity type and ID
     * 
     * @param entityTypeId The Entity Type ID to lookup - See {@link EntityType} for default values
     * @param entityId The Entity ID to lookup
     * @return List of possible Permission IDs
     */
    public List<_EntityPermission> listPermission(String entityTypeId, String entityId);

    /**
     * List user permissions for the given entity by using its entity type and ID
     * 
     * @param entityTypeId The Entity Type ID - See {@link EntityType} for default values
     * @param entityId The Entity ID
     * @param usr The User to lookup the permission for
     * @return List of possible Permission IDs
     */
    public List<_UserPermission> listPermission(String entityTypeId, String entityId, _User usr);

}
