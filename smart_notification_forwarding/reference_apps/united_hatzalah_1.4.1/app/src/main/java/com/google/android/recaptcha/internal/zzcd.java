package com.google.android.recaptcha.internal;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.jvm.internal.j;
import m3.b;
import p3.h;

/* loaded from: classes.dex */
public final class zzcd {
    public zzcd(Context context) {
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.OutputStream, java.io.ByteArrayOutputStream, D2.a] */
    public static final byte[] zza(File file) {
        j.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                int i = (int) length;
                byte[] bArr = new byte[i];
                int i3 = i;
                int i4 = 0;
                while (i3 > 0) {
                    int read = fileInputStream.read(bArr, i4, i3);
                    if (read < 0) {
                        break;
                    }
                    i3 -= read;
                    i4 += read;
                }
                if (i3 > 0) {
                    bArr = Arrays.copyOf(bArr, i4);
                    j.d(bArr, "copyOf(...)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        ?? byteArrayOutputStream = new ByteArrayOutputStream(8193);
                        byteArrayOutputStream.write(read2);
                        b.i(fileInputStream, byteArrayOutputStream);
                        int size = byteArrayOutputStream.size() + i;
                        if (size >= 0) {
                            byte[] a2 = byteArrayOutputStream.a();
                            bArr = Arrays.copyOf(bArr, size);
                            j.d(bArr, "copyOf(...)");
                            System.arraycopy(a2, 0, bArr, i, byteArrayOutputStream.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                fileInputStream.close();
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                h.h(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void zzb(File file, byte[] array) {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete existing encrypted file");
        }
        j.e(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            fileOutputStream.close();
        } finally {
        }
    }
}
