package com.groboot.mdaemergency.models;

import java.util.Date;
import x5.m;

/* loaded from: classes.dex */
public class PlayMessage {
    public Date date;
    public boolean isPlayed;
    public m message;

    public boolean equalsDuration(m mVar) {
        return Math.abs(this.message.c() - mVar.d()) < 2000;
    }
}
