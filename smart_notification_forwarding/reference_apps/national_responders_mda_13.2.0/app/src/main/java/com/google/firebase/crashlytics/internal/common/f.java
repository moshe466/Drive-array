package com.google.firebase.crashlytics.internal.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import w3.v;

/* loaded from: classes.dex */
class f implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f7082a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7083b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7084c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, String str2, byte[] bArr) {
        this.f7083b = str;
        this.f7084c = str2;
        this.f7082a = bArr;
    }

    private byte[] d() {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f7082a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    private boolean e() {
        byte[] bArr = this.f7082a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.internal.common.b0
    public InputStream a() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f7082a);
    }

    @Override // com.google.firebase.crashlytics.internal.common.b0
    public String b() {
        return this.f7084c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.b0
    public v.c.b c() {
        byte[] d10 = d();
        if (d10 == null) {
            return null;
        }
        return v.c.b.a().b(d10).c(this.f7083b).a();
    }
}
