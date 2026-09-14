package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import j2.a;

/* loaded from: classes.dex */
public final class s extends c2.a {
    public static final Parcelable.Creator<s> CREATOR = new t();

    /* renamed from: f, reason: collision with root package name */
    private final String f5118f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5119g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5120h;

    /* renamed from: i, reason: collision with root package name */
    private final Context f5121i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f5122j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12) {
        this.f5118f = str;
        this.f5119g = z10;
        this.f5120h = z11;
        this.f5121i = (Context) j2.b.p(a.AbstractBinderC0212a.n(iBinder));
        this.f5122j = z12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [j2.a, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 1, this.f5118f, false);
        c2.c.c(parcel, 2, this.f5119g);
        c2.c.c(parcel, 3, this.f5120h);
        c2.c.j(parcel, 4, j2.b.z(this.f5121i), false);
        c2.c.c(parcel, 5, this.f5122j);
        c2.c.b(parcel, a10);
    }
}
