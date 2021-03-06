/*
 * Copyright (C) 2016 Björn Büttner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.idrinth.waraddonclient.implementation.model;

public class Tag {

    private String name;

    private java.util.HashMap<String, Addon> list = new java.util.HashMap();

    private javax.swing.JCheckBoxMenuItem item;

    /**
     *
     * @param name
     */
    public Tag(String name) {
        this.name = name;
        item = new javax.swing.JCheckBoxMenuItem();
        item.setText(name);
        item.setSelected(true);
        item.addActionListener((java.awt.event.ActionEvent evt) -> {
            de.idrinth.waraddonclient.factory.Interface.build().newFilter();
        });
    }

    /**
     *
     * @return javax.swing.JCheckBoxMenuItem
     */
    public javax.swing.JCheckBoxMenuItem getMenu() {
        return item;
    }

    /**
     *
     * @return boolean
     */
    public boolean isActive() {
        return item.isSelected();
    }

    /**
     *
     * @return boolean
     */
    public boolean hasMembers() {
        return !list.isEmpty();
    }

    /**
     *
     * @param addon
     */
    public void addMember(Addon addon) {
        list.put(addon.getName(), addon);
    }

    /**
     *
     */
    public void checkMembers() {
        list.keySet().stream().filter((addon) -> (!list.get(addon).hasTag(name))).forEach((addon) -> {
            list.remove(addon);
        });
    }
}
