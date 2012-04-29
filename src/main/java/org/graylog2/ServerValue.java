/**
 * Copyright 2011, 2012 Lennart Koopmann <lennart@socketfeed.com>
 *
 * This file is part of Graylog2.
 *
 * Graylog2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog2.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.graylog2;

/**
 * ServerValue.java: Jan 16, 2011 1:35:00 PM
 *
 * Filling the server_values collection
 *
 * @author Lennart Koopmann <lennart@socketfeed.com>
 */
public class ServerValue {

    private final GraylogServer graylogServer;

    public ServerValue(GraylogServer graylogServer) {
        this.graylogServer = graylogServer;
    }

    public void setStartupTime(int timestamp) {
        set("startup_time", timestamp);
    }

    public void setPID(int pid) {
        set("pid", pid);
    }

    public void setJREInfo(String info) {
        set("jre", info);
    }

    public void setAvailableProcessors(int processors) {
        set("available_processors", processors);
    }

    public void setGraylog2Version(String version) {
        set("graylog2_version", version);
    }

    public void setLocalHostname(String hostname) {
        set("local_hostname", hostname);
    }

    public void writeThroughput(int current, int highest) {
        graylogServer.getMongoBridge().writeThroughput(current, highest);
    }

    public void writeMessageQueueCurrentSize(int size) {
        set("message_queue_current_size", size);
    }
    
    public void writeMessageQueueBatchSize(int size) {
        set("message_queue_batch_size", size);
    }

    public void writeMessageQueuePollFrequency(int freq) {
        set("message_queue_poll_freq", freq);
    }

    public void writeMessageRetentionLastPerformed(int when) {
        set("message_retention_last_performed", when);
    }

    public void ping() {
        set("ping", Tools.getUTCTimestamp());
    }

    private void set(String key, Object value) {
        graylogServer.getMongoBridge().setSimpleServerValue(key, value);
    }

}