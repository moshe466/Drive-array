package W0;

import F0.C0047j2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class i implements AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public static final int f2465d = Math.min(32, Runtime.getRuntime().availableProcessors());

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2466a;

    /* renamed from: b, reason: collision with root package name */
    public final MessageDigest f2467b;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadPoolExecutor f2468c;

    public i(byte[] bArr) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(4);
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        int i = f2465d;
        this.f2468c = new ThreadPoolExecutor(i, i, 0L, timeUnit, arrayBlockingQueue, callerRunsPolicy);
        this.f2466a = bArr;
        this.f2467b = MessageDigest.getInstance("SHA-256");
    }

    public static ByteBuffer c(int i, ByteBuffer byteBuffer, int i3) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i3);
        duplicate.position(i);
        return duplicate.slice();
    }

    public final void a(Y0.b bVar, C0047j2 c0047j2) {
        long size = bVar.size();
        long j2 = 4095;
        long j3 = 4096;
        int i = (int) ((size + 4095) / 4096);
        final byte[][] bArr = new byte[i];
        final Phaser phaser = new Phaser(1);
        final int i3 = 0;
        long j4 = 0;
        while (j4 < size) {
            int min = (int) (Math.min(4194304 + j4, size) - j4);
            long j5 = min;
            int i4 = (int) ((j5 + j2) / j3);
            final ByteBuffer allocate = ByteBuffer.allocate(i4 * 4096);
            bVar.b(j4, allocate, min);
            allocate.rewind();
            Runnable runnable = new Runnable() { // from class: W0.h
                @Override // java.lang.Runnable
                public final void run() {
                    MessageDigest messageDigest;
                    i iVar = i.this;
                    try {
                        try {
                            messageDigest = (MessageDigest) iVar.f2467b.clone();
                        } catch (NoSuchAlgorithmException e4) {
                            throw new IllegalStateException("Failed to obtain an instance of a previously available message digest", e4);
                        }
                    } catch (CloneNotSupportedException unused) {
                        messageDigest = MessageDigest.getInstance("SHA-256");
                    }
                    ByteBuffer byteBuffer = allocate;
                    int capacity = byteBuffer.capacity();
                    int i5 = i3;
                    int i6 = 0;
                    while (i6 < capacity) {
                        int i7 = i6 + 4096;
                        ByteBuffer c4 = i.c(i6, byteBuffer, i7);
                        messageDigest.reset();
                        byte[] bArr2 = iVar.f2466a;
                        if (bArr2 != null) {
                            messageDigest.update(bArr2);
                        }
                        messageDigest.update(c4);
                        bArr[i5] = messageDigest.digest();
                        i5++;
                        i6 = i7;
                    }
                    phaser.arriveAndDeregister();
                }
            };
            phaser.register();
            this.f2468c.execute(runnable);
            i3 += i4;
            j4 += j5;
            j2 = 4095;
            j3 = 4096;
        }
        phaser.arriveAndAwaitAdvance();
        for (int i5 = 0; i5 < i; i5++) {
            byte[] bArr2 = bArr[i5];
            c0047j2.d(bArr2, 0, bArr2.length);
        }
    }

    public final byte[] b(Y0.b bVar, Y0.b bVar2, a aVar) {
        long j2;
        long j3;
        Y0.b aVar2;
        int i = aVar.f2447b;
        long j4 = 4096;
        if (bVar.size() % 4096 == 0) {
            long size = bVar.size();
            ByteBuffer allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            aVar.b(0L, allocate, i);
            allocate.flip();
            p3.h.E(allocate, size);
            c cVar = new c(bVar, bVar2, new a(allocate, true));
            MessageDigest messageDigest = this.f2467b;
            int digestLength = messageDigest.getDigestLength();
            ArrayList arrayList = new ArrayList();
            long j5 = cVar.f2449b;
            do {
                j2 = 4095;
                j3 = digestLength;
                j5 = ((j5 + 4095) / 4096) * j3;
                arrayList.add(Long.valueOf(((j5 + 4095) / 4096) * 4096));
            } while (j5 > 4096);
            int size2 = arrayList.size();
            int[] iArr = new int[size2 + 1];
            iArr[0] = 0;
            int i3 = 0;
            while (i3 < arrayList.size()) {
                int i4 = i3 + 1;
                iArr[i4] = Math.toIntExact(((Long) arrayList.get((arrayList.size() - i3) - 1)).longValue()) + iArr[i3];
                i3 = i4;
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(iArr[size2]);
            int i5 = size2 - 1;
            int i6 = i5;
            while (i6 >= 0) {
                long j6 = j4;
                int i7 = i6 + 1;
                long j7 = j2;
                C0047j2 c0047j2 = new C0047j2(c(iArr[i6], allocate2, iArr[i7]), 8);
                if (i6 == i5) {
                    a(cVar, c0047j2);
                    aVar2 = cVar;
                } else {
                    ByteBuffer c4 = c(iArr[i7], allocate2.asReadOnlyBuffer(), iArr[i6 + 2]);
                    c4.getClass();
                    aVar2 = new a(c4, true);
                    a(aVar2, c0047j2);
                }
                int size3 = (int) ((((aVar2.size() + j7) / j6) * j3) % j6);
                if (size3 > 0) {
                    int i8 = 4096 - size3;
                    c0047j2.d(new byte[i8], 0, i8);
                }
                i6--;
                j2 = j7;
                j4 = j6;
            }
            ByteBuffer c5 = c(0, allocate2.asReadOnlyBuffer(), 4096);
            messageDigest.reset();
            byte[] bArr = this.f2466a;
            if (bArr != null) {
                messageDigest.update(bArr);
            }
            messageDigest.update(c5);
            return messageDigest.digest();
        }
        throw new IllegalStateException("APK Signing Block size not a multiple of 4096: " + bVar.size());
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f2468c.shutdownNow();
    }
}
