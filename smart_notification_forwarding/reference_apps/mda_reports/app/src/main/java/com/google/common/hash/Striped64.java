package com.google.common.hash;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

@GwtIncompatible
/* loaded from: classes2.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    static final ThreadLocal<int[]> d = new ThreadLocal<>();
    static final Random e = new Random();
    static final int f = Runtime.getRuntime().availableProcessors();

    @NullableDecl
    volatile transient Cell[] a;
    volatile transient long b;
    volatile transient int c;

    /* loaded from: classes2.dex */
    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;
        volatile long a;

        static {
            try {
                UNSAFE = Striped64.b();
                valueOffset = UNSAFE.objectFieldOffset(Cell.class.getDeclaredField("a"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        Cell(long j) {
            this.a = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j, long j2) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j, j2);
        }
    }

    static {
        try {
            UNSAFE = getUnsafe();
            baseOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("b"));
            busyOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("c"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    static /* synthetic */ Unsafe b() {
        return getUnsafe();
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        Cell[] cellArr = this.a;
        this.b = j;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.a = j;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x009d, code lost:
    
        r16.a = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008d, code lost:
    
        if (r16.a != r9) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x008f, code lost:
    
        r8 = new com.google.common.hash.Striped64.Cell[r10 << 1];
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0094, code lost:
    
        if (r11 >= r10) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0096, code lost:
    
        r8[r11] = r9[r11];
        r11 = r11 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0022 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r17, @org.checkerframework.checker.nullness.compatqual.NullableDecl int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Striped64.a(long, int[], boolean):void");
    }

    final boolean a() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    abstract long b(long j, long j2);
}
