package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class NetworkSettings {
    public String IP;
    public int keepAliveDuration;
    public int port;
    public int timeout;

    public NetworkSettings() {
    }

    public NetworkSettings(String str, int i10, int i11, int i12) {
        this.IP = str;
        this.port = i10;
        this.timeout = i11;
        this.keepAliveDuration = i12;
    }
}
