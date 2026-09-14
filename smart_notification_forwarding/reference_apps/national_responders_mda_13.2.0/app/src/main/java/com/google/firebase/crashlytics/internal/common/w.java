package com.google.firebase.crashlytics.internal.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import w3.v;

/* loaded from: classes.dex */
class w implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final File f7245a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7246b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7247c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, File file) {
        this.f7246b = str;
        this.f7247c = str2;
        this.f7245a = file;
    }

    private byte[] d() {
        byte[] bArr = new byte[8192];
        try {
            InputStream a10 = a();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (a10 == null) {
                        byteArrayOutputStream.close();
                        if (a10 != null) {
                            a10.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int read = a10.read(bArr);
                            if (read <= 0) {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                a10.close();
                                return byteArray;
                            }
                            gZIPOutputStream.write(bArr, 0, read);
                        } finally {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (a10 != null) {
                    try {
                        a10.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused4) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.b0
    public InputStream a() {
        if (this.f7245a.exists() && this.f7245a.isFile()) {
            try {
                return new FileInputStream(this.f7245a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.common.b0
    public String b() {
        return this.f7247c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.b0
    public v.c.b c() {
        byte[] d10 = d();
        if (d10 != null) {
            return v.c.b.a().b(d10).c(this.f7246b).a();
        }
        return null;
    }
}
