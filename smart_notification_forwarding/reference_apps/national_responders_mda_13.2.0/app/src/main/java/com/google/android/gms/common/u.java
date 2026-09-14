package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import b2.t1;

/* loaded from: classes.dex */
public final class u extends c2.a {
    public static final Parcelable.Creator<u> CREATOR = new v();

    /* renamed from: f, reason: collision with root package name */
    private final String f5123f;

    /* renamed from: g, reason: collision with root package name */
    private final n f5124g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5125h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f5126i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f5123f = str;
        o oVar = null;
        if (iBinder != null) {
            try {
                j2.a c10 = t1.n(iBinder).c();
                byte[] bArr = c10 == null ? null : (byte[]) j2.b.p(c10);
                if (bArr != null) {
                    oVar = new o(bArr);
                }
            } catch (RemoteException unused) {
            }
        }
        this.f5124g = oVar;
        this.f5125h = z10;
        this.f5126i = z11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str, n nVar, boolean z10, boolean z11) {
        this.f5123f = str;
        this.f5124g = nVar;
        this.f5125h = z10;
        this.f5126i = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.q(parcel, 1, this.f5123f, false);
        n nVar = this.f5124g;
        if (nVar == null) {
            nVar = null;
        }
        c2.c.j(parcel, 2, nVar, false);
        c2.c.c(parcel, 3, this.f5125h);
        c2.c.c(parcel, 4, this.f5126i);
        c2.c.b(parcel, a10);
    }
}
