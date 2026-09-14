package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public class zznr extends IOException {
    private final int type;
    private final zznq zzbev;

    public zznr(IOException iOException, zznq zznqVar, int i) {
        super(iOException);
        this.zzbev = zznqVar;
        this.type = i;
    }

    public zznr(String str, zznq zznqVar, int i) {
        super(str);
        this.zzbev = zznqVar;
        this.type = 1;
    }

    public zznr(String str, IOException iOException, zznq zznqVar, int i) {
        super(str, iOException);
        this.zzbev = zznqVar;
        this.type = 1;
    }
}
