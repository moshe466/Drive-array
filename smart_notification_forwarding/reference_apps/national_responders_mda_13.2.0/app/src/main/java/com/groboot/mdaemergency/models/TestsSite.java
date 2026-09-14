package com.groboot.mdaemergency.models;

import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class TestsSite {
    private int count;
    public Kv site;

    public TestsSite() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestsSite(Kv kv, int i10) {
        this();
        k.e(kv, "_site");
        setSite(new Kv(kv.key, kv.value));
        this.count = i10;
    }

    public /* synthetic */ TestsSite(Kv kv, int i10, int i11, g gVar) {
        this(kv, (i11 & 2) != 0 ? 0 : i10);
    }

    public final int getCount() {
        return this.count;
    }

    public final Kv getSite() {
        Kv kv = this.site;
        if (kv != null) {
            return kv;
        }
        k.o("site");
        return null;
    }

    public final void setCount(int i10) {
        this.count = i10;
    }

    public final void setSite(Kv kv) {
        k.e(kv, "<set-?>");
        this.site = kv;
    }
}
