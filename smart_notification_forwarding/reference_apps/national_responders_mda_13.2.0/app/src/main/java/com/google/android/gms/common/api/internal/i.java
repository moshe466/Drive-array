package com.google.android.gms.common.api.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface i extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends m2.b implements i {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @Override // m2.b
        protected final boolean x0(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                return false;
            }
            Status status = (Status) m2.c.a(parcel, Status.CREATOR);
            m2.c.b(parcel);
            U(status);
            return true;
        }
    }

    void U(Status status);
}
