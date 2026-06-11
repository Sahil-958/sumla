/*
 * Copyright (C) 2014 Andrew Comminos
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

package se.lublin.mumla.service.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import se.lublin.humla.model.Server;
import se.lublin.mumla.Settings;
import se.lublin.mumla.app.ServerConnectTask;
import se.lublin.mumla.db.MumlaDatabase;
import se.lublin.mumla.db.MumlaSQLiteDatabase;

public class ReconnectBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_RECONNECT = "se.lublin.mumla.action.RECONNECT";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_RECONNECT.equals(intent.getAction())) {
            Settings settings = Settings.getInstance(context);
            long pinnedId = settings.getPinnedServerId();
            if (pinnedId != -1) {
                MumlaDatabase database = new MumlaSQLiteDatabase(context);
                Server server = database.getServer(pinnedId);
                if (server != null) {
                    ServerConnectTask connectTask = new ServerConnectTask(context, database);
                    connectTask.execute(server);
                }
            }
        }
    }
}
