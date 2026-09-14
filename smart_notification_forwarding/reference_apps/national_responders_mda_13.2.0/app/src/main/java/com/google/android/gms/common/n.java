package com.google.android.gms.common;

import android.os.RemoteException;
import b2.t1;
import b2.u1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class n extends t1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f5108a;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(byte[] bArr) {
        b2.p.a(bArr.length == 25);
        this.f5108a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] p(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // b2.u1
    public final int b() {
        return this.f5108a;
    }

    @Override // b2.u1
    public final j2.a c() {
        return j2.b.z(z());
    }

    public final boolean equals(Object obj) {
        j2.a c10;
        if (obj != null && (obj instanceof u1)) {
            try {
                u1 u1Var = (u1) obj;
                if (u1Var.b() == this.f5108a && (c10 = u1Var.c()) != null) {
                    return Arrays.equals(z(), (byte[]) j2.b.p(c10));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5108a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] z();
}
