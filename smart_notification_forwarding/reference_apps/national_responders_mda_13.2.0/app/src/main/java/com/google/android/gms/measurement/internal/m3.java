package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class m3 extends com.google.android.gms.internal.measurement.a implements v2.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // v2.c
    public final void I(v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(6, i10);
    }

    @Override // v2.c
    public final void J(q qVar, String str, String str2) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, qVar);
        i10.writeString(str);
        i10.writeString(str2);
        p(5, i10);
    }

    @Override // v2.c
    public final List<n9> K(String str, String str2, String str3, boolean z10) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        i10.writeString(str3);
        com.google.android.gms.internal.measurement.v.d(i10, z10);
        Parcel n10 = n(15, i10);
        ArrayList createTypedArrayList = n10.createTypedArrayList(n9.CREATOR);
        n10.recycle();
        return createTypedArrayList;
    }

    @Override // v2.c
    public final void V(q qVar, v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, qVar);
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(1, i10);
    }

    @Override // v2.c
    public final String W(v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        Parcel n10 = n(11, i10);
        String readString = n10.readString();
        n10.recycle();
        return readString;
    }

    @Override // v2.c
    public final void Y(Bundle bundle, v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, bundle);
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(19, i10);
    }

    @Override // v2.c
    public final void e0(long j10, String str, String str2, String str3) {
        Parcel i10 = i();
        i10.writeLong(j10);
        i10.writeString(str);
        i10.writeString(str2);
        i10.writeString(str3);
        p(10, i10);
    }

    @Override // v2.c
    public final void g0(n9 n9Var, v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, n9Var);
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(2, i10);
    }

    @Override // v2.c
    public final void i0(v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(18, i10);
    }

    @Override // v2.c
    public final List<ha> j0(String str, String str2, String str3) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        i10.writeString(str3);
        Parcel n10 = n(17, i10);
        ArrayList createTypedArrayList = n10.createTypedArrayList(ha.CREATOR);
        n10.recycle();
        return createTypedArrayList;
    }

    @Override // v2.c
    public final void l0(ha haVar, v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, haVar);
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(12, i10);
    }

    @Override // v2.c
    public final List<ha> m0(String str, String str2, v9 v9Var) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        Parcel n10 = n(16, i10);
        ArrayList createTypedArrayList = n10.createTypedArrayList(ha.CREATOR);
        n10.recycle();
        return createTypedArrayList;
    }

    @Override // v2.c
    public final List<n9> r(String str, String str2, boolean z10, v9 v9Var) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        com.google.android.gms.internal.measurement.v.d(i10, z10);
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        Parcel n10 = n(14, i10);
        ArrayList createTypedArrayList = n10.createTypedArrayList(n9.CREATOR);
        n10.recycle();
        return createTypedArrayList;
    }

    @Override // v2.c
    public final void r0(ha haVar) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, haVar);
        p(13, i10);
    }

    @Override // v2.c
    public final void t(v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(4, i10);
    }

    @Override // v2.c
    public final byte[] v(q qVar, String str) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, qVar);
        i10.writeString(str);
        Parcel n10 = n(9, i10);
        byte[] createByteArray = n10.createByteArray();
        n10.recycle();
        return createByteArray;
    }

    @Override // v2.c
    public final void x(v9 v9Var) {
        Parcel i10 = i();
        com.google.android.gms.internal.measurement.v.c(i10, v9Var);
        p(20, i10);
    }
}
