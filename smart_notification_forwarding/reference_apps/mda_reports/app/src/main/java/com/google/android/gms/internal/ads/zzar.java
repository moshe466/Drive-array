package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzar {
    private final int zzcg;
    private final List<zzk> zzch;
    private final int zzci;
    private final InputStream zzcj;

    public zzar(int i, List<zzk> list) {
        this(i, list, -1, null);
    }

    public zzar(int i, List<zzk> list, int i2, InputStream inputStream) {
        this.zzcg = i;
        this.zzch = list;
        this.zzci = i2;
        this.zzcj = inputStream;
    }

    public final InputStream getContent() {
        return this.zzcj;
    }

    public final int getContentLength() {
        return this.zzci;
    }

    public final int getStatusCode() {
        return this.zzcg;
    }

    public final List<zzk> zzp() {
        return Collections.unmodifiableList(this.zzch);
    }
}
