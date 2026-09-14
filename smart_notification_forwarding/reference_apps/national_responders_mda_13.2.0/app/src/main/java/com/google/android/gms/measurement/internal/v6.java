package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* loaded from: classes.dex */
final class v6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f6552f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Uri f6553g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6554h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f6555i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ s6 f6556j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v6(s6 s6Var, boolean z10, Uri uri, String str, String str2) {
        this.f6556j = s6Var;
        this.f6552f = z10;
        this.f6553g = uri;
        this.f6554h = str;
        this.f6555i = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6556j.b(this.f6552f, this.f6553g, this.f6554h, this.f6555i);
    }
}
