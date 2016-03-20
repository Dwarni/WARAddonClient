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

public class Version implements java.lang.Runnable {

    private String version = "1.2.0";

    public String getLocalVersion() {
        return version;
    }

    public void run() {
        try {
            Thread.sleep(2500);
        } catch (java.lang.InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
        de.idrinth.waraddonclient.factory.Interface.build().getRemoteVersionLabel().setText(de.idrinth.waraddonclient.factory.RemoteRequest.build().getVersion());
    }
}