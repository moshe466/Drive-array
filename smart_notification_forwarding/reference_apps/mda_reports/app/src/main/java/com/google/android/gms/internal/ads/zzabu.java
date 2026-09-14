package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzabu extends zzach {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzcvm;
    private final double zzcvn;

    public zzabu(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.zzcvm = drawable;
        this.uri = uri;
        this.zzcvn = d;
        this.width = i;
        this.height = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final double getScale() {
        return this.zzcvn;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final IObjectWrapper zzrc() {
        return ObjectWrapper.wrap(this.zzcvm);
    }
}
