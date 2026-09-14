package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class zzgc implements IInterface {
    private final IBinder zzaav;
    private final String zzaaw;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgc(IBinder iBinder, String str) {
        this.zzaav = iBinder;
        this.zzaaw = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzaav.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzaav;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzaav.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel c() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzaaw);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i, Parcel parcel) {
        try {
            this.zzaav.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
