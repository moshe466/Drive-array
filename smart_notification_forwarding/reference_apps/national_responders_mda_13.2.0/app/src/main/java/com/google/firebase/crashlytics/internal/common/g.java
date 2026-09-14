package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicLong f7086a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    private static String f7087b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(x xVar) {
        byte[] bArr = new byte[10];
        e(bArr);
        d(bArr);
        c(bArr);
        String E = h.E(xVar.a());
        String y10 = h.y(bArr);
        Locale locale = Locale.US;
        f7087b = String.format(locale, "%s-%s-%s-%s", y10.substring(0, 12), y10.substring(12, 16), y10.subSequence(16, 20), E.substring(0, 12)).toUpperCase(locale);
    }

    private static byte[] a(long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j10);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j10);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void c(byte[] bArr) {
        byte[] b10 = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b10[0];
        bArr[9] = b10[1];
    }

    private void d(byte[] bArr) {
        byte[] b10 = b(f7086a.incrementAndGet());
        bArr[6] = b10[0];
        bArr[7] = b10[1];
    }

    private void e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a10 = a(time / 1000);
        bArr[0] = a10[0];
        bArr[1] = a10[1];
        bArr[2] = a10[2];
        bArr[3] = a10[3];
        byte[] b10 = b(time % 1000);
        bArr[4] = b10[0];
        bArr[5] = b10[1];
    }

    public String toString() {
        return f7087b;
    }
}
