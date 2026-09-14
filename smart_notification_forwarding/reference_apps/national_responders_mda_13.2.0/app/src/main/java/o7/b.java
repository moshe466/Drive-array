package o7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import o7.b;

/* loaded from: classes.dex */
public abstract class b {
    public static final int[] A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int[] L;
    public static final int[] M;
    public static final int[] N;
    public static final int[] O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
    public static final int[] U;
    public static final int[] V;
    public static final int[] W;
    public static final int[] X;
    public static final int[] Y;
    public static final int[] Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final int[] f12514a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final int[] f12515b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final int[] f12516c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final int[] f12517d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final int[] f12518e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final int[] f12519f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final int[] f12520g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f12521h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final int[] f12522i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final int f12523j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final int f12524k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final int f12525l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final int f12526m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final int f12527n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f12528o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final int f12529p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final int f12530q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final int f12531r0;

    /* renamed from: s, reason: collision with root package name */
    private static int f12532s;

    /* renamed from: s0, reason: collision with root package name */
    public static final int f12533s0;

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f12534t;

    /* renamed from: t0, reason: collision with root package name */
    public static final int f12535t0;

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f12536u;

    /* renamed from: u0, reason: collision with root package name */
    public static final int f12537u0;

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f12538v;

    /* renamed from: v0, reason: collision with root package name */
    private static final j f12539v0;

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f12540w;

    /* renamed from: w0, reason: collision with root package name */
    private static final k f12541w0;

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f12542x;

    /* renamed from: x0, reason: collision with root package name */
    private static final o7.a f12543x0;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f12544y;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f12545z;

    /* renamed from: a, reason: collision with root package name */
    private DatagramSocket f12546a;

    /* renamed from: b, reason: collision with root package name */
    private SocketAddress f12547b;

    /* renamed from: c, reason: collision with root package name */
    private String f12548c;

    /* renamed from: d, reason: collision with root package name */
    private String f12549d;

    /* renamed from: f, reason: collision with root package name */
    private o7.a f12551f;

    /* renamed from: i, reason: collision with root package name */
    private Lock f12554i;

    /* renamed from: j, reason: collision with root package name */
    private Lock f12555j;

    /* renamed from: k, reason: collision with root package name */
    private Lock f12556k;

    /* renamed from: l, reason: collision with root package name */
    private Lock f12557l;

    /* renamed from: m, reason: collision with root package name */
    private Lock f12558m;

    /* renamed from: n, reason: collision with root package name */
    private Lock f12559n;

    /* renamed from: o, reason: collision with root package name */
    private Lock f12560o;

    /* renamed from: p, reason: collision with root package name */
    private h f12561p;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, k> f12550e = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private j f12552g = f12539v0;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f12553h = new byte[F];

    /* renamed from: q, reason: collision with root package name */
    private long f12562q = 0;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f12563r = true;

    /* loaded from: classes.dex */
    static class a implements j {
        a() {
        }

        @Override // o7.j
        public void a(com.google.gson.n nVar) {
        }
    }

    /* renamed from: o7.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0265b implements k {
        C0265b() {
        }

        @Override // o7.k
        public void a(int i10) {
        }

        @Override // o7.k
        public void b(byte[] bArr) {
        }
    }

    /* loaded from: classes.dex */
    static class c extends o7.a {
        c() {
        }

        @Override // o7.a
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j10) {
        }

        @Override // o7.a
        public boolean c(String str) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f12564f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f12565g;

        d(String str, int i10) {
            this.f12564f = str;
            this.f12565g = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(AtomicBoolean atomicBoolean) {
            b.this.F(atomicBoolean.get());
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            ScheduledFuture<?> schedule;
            v7.b.c("AUDPVoice", "step 1");
            try {
                b.this.f12546a = new DatagramSocket();
            } catch (SocketException e10) {
                v7.b.b("AUDPVoiceApi", e10);
            }
            v7.b.c("AUDPVoice", "step 2");
            try {
                b.this.f12547b = new InetSocketAddress(this.f12564f, this.f12565g);
                b.this.f12546a.connect(b.this.f12547b);
                try {
                    b.this.f12557l.lock();
                    if (b.this.f12561p != null) {
                        b.this.f12561p.a(r2);
                    }
                    b.this.f12557l.unlock();
                } finally {
                }
            } catch (SocketException e11) {
                v7.b.b("AUDPVoiceApi", e11);
            }
            v7.b.c("AUDPVoice", "step 3");
            byte[] bArr = new byte[500];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 500);
            int i10 = b.S;
            byte[] bArr2 = new byte[i10];
            byte[] bArr3 = new byte[b.f12525l0];
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> schedule2 = newSingleThreadScheduledExecutor.schedule(new Runnable() { // from class: o7.d
                @Override // java.lang.Runnable
                public final void run() {
                    b.d.c();
                }
            }, 0L, TimeUnit.MILLISECONDS);
            v7.b.c("AUDPVoice", "step 4");
            ScheduledFuture<?> scheduledFuture = schedule2;
            byte[] bArr4 = bArr3;
            while (b.this.f12563r) {
                try {
                    v7.b.c("AUDPVoice", "receivePacket");
                    b.this.f12546a.receive(datagramPacket);
                    v7.b.c("AUDPVoice", "receivePacket success");
                } catch (Exception e12) {
                    v7.b.a("AUDPVoice", "failed ip:" + this.f12564f + " port:" + this.f12565g + " " + e12.getMessage());
                    try {
                        b.this.f12557l.lock();
                        if (b.this.f12561p != null) {
                            b.this.f12561p.a(false);
                        }
                        while (b.this.f12563r) {
                            try {
                                int hashCode = b.this.f12546a.hashCode();
                                v7.b.c("AUDPVoiceApi", "thread RECEIVE failed on channel " + String.valueOf(hashCode));
                                synchronized (this) {
                                    try {
                                        if (hashCode == b.this.f12546a.hashCode() || !b.this.f12546a.isConnected()) {
                                            b.this.f12546a.close();
                                            b.this.f12546a = new DatagramSocket();
                                            b.this.f12546a.connect(b.this.f12547b);
                                            b.this.q(1, b.f12541w0);
                                        }
                                        try {
                                            b.this.f12557l.lock();
                                            if (b.this.f12561p != null) {
                                                try {
                                                    b.this.f12561p.a(r2);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            }
                                            try {
                                                b.this.f12557l.unlock();
                                                break;
                                            } catch (SocketException e13) {
                                                e = e13;
                                                v7.b.b("AUDPVoiceApi", e);
                                                try {
                                                    Thread.sleep(1000L);
                                                } catch (InterruptedException unused) {
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } finally {
                                        th = th;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        }
                                    }
                                }
                            } catch (SocketException e14) {
                                e = e14;
                            }
                        }
                    } finally {
                    }
                }
                try {
                    b.this.f12560o.lock();
                    b.this.f12562q = System.currentTimeMillis();
                    b.this.f12560o.unlock();
                    final AtomicBoolean atomicBoolean = new AtomicBoolean(z10);
                    Runnable runnable = new Runnable() { // from class: o7.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.d.this.d(atomicBoolean);
                        }
                    };
                    if (datagramPacket.getLength() == b.T) {
                        v7.b.c("AUDPVoice", "receivePacket: INCOMING_PTT_LENGTH");
                        if (b.this.f12551f.c(b.this.f12549d)) {
                            System.arraycopy(datagramPacket.getData(), b.O[0], bArr2, 0, i10);
                            b.this.z(bArr2);
                            v7.b.c("AUDPVoiceApi", "Played a voice packet for channel " + b.this.f12549d);
                        }
                        scheduledFuture.cancel(false);
                        schedule = newSingleThreadScheduledExecutor.schedule(runnable, 5000L, TimeUnit.MILLISECONDS);
                    } else if (datagramPacket.getLength() == b.f12537u0) {
                        v7.b.c("AUDPVoice", "receivePacket: DETAILED_INCOMING_PTT_LENGTH");
                        String a10 = m7.a.a(m7.a.b(bArr, b.f12515b0), b.f12529p0);
                        byte[] b10 = m7.a.b(bArr, b.W);
                        try {
                            b.this.f12554i.lock();
                            atomicBoolean.set(b.this.f12551f.c(b.this.f12549d));
                            if (!Arrays.equals(bArr4, b10)) {
                                try {
                                    if (!scheduledFuture.isCancelled()) {
                                        b.this.F(atomicBoolean.get());
                                    }
                                    if (atomicBoolean.get()) {
                                        b bVar = b.this;
                                        bVar.A(bVar.f12549d);
                                    }
                                    b.this.f12551f.b(bArr, b.this.f12549d, a10);
                                    bArr4 = b10;
                                } catch (Exception e15) {
                                    v7.b.b("AUDPVoiceApi", e15);
                                }
                            }
                            if (atomicBoolean.get()) {
                                System.arraycopy(datagramPacket.getData(), b.X[0], bArr2, 0, i10);
                                b.this.z(bArr2);
                                v7.b.c("AUDPVoiceApi", "Played a voice packet for channel " + b.this.f12549d);
                            }
                            b.this.f12554i.unlock();
                            scheduledFuture.cancel(false);
                            schedule = newSingleThreadScheduledExecutor.schedule(runnable, 5000L, TimeUnit.MILLISECONDS);
                        } catch (Throwable th4) {
                            b.this.f12554i.unlock();
                            throw th4;
                        }
                    } else {
                        if (datagramPacket.getLength() == b.J) {
                            v7.b.c("AUDPVoice", "receivePacket: REQUEST_LENGTH");
                            scheduledFuture.cancel(false);
                            b.this.F(atomicBoolean.get());
                        } else if (datagramPacket.getLength() == b.D) {
                            v7.b.c("AUDPVoice", "receivePacket: REQUEST_ID_LENGTH");
                            b.this.q(1, b.f12541w0);
                        } else {
                            v7.b.c("AUDPVoice", "receivePacket: ITCPCallBack");
                            k kVar = (k) b.this.f12550e.remove(Integer.valueOf(Integer.valueOf(m7.a.e(bArr, m7.a.f12022a)).intValue()));
                            if (kVar != null) {
                                try {
                                    int d10 = m7.a.d(bArr, m7.a.f12023b);
                                    if (d10 == 0) {
                                        kVar.b(bArr);
                                    } else {
                                        kVar.a(d10);
                                    }
                                } catch (Exception e16) {
                                    v7.b.b("AUDPVoiceApi", e16);
                                }
                            }
                        }
                        v7.b.c("AUDPVoice", "continue");
                    }
                    scheduledFuture = schedule;
                    v7.b.c("AUDPVoice", "continue");
                } catch (Throwable th5) {
                    b.this.f12560o.unlock();
                    throw th5;
                }
            }
            v7.b.c("AUDPVoice", "end");
            newSingleThreadScheduledExecutor.shutdownNow();
        }
    }

    static {
        ic.c.i(b.class.getSimpleName());
        f12532s = 0;
        int[] iArr = {0, 31};
        f12534t = iArr;
        int[] iArr2 = {32, 63};
        f12536u = iArr2;
        int[] iArr3 = {64, 79};
        f12538v = iArr3;
        int[] iArr4 = {80, 80};
        f12540w = iArr4;
        int[] iArr5 = {81, 108};
        f12542x = iArr5;
        int[] iArr6 = {0, 1};
        f12544y = iArr6;
        int[] iArr7 = {2, 3};
        f12545z = iArr7;
        int[] iArr8 = {4, 103};
        A = iArr8;
        int i10 = (iArr[1] - iArr[0]) + 1;
        B = i10;
        int i11 = (iArr2[1] - iArr2[0]) + 1;
        C = i11;
        int i12 = (iArr3[1] - iArr3[0]) + 1;
        D = i12;
        int i13 = (iArr4[1] - iArr4[0]) + 1;
        E = i13;
        F = (iArr5[1] - iArr5[0]) + 1;
        int i14 = (iArr6[1] - iArr6[0]) + 1;
        G = i14;
        int i15 = (iArr7[1] - iArr7[0]) + 1;
        H = i15;
        int i16 = (iArr8[1] - iArr8[0]) + 1;
        I = i16;
        J = i10 + i11 + i12 + i13;
        K = i14 + i15 + i16;
        int[] iArr9 = {0, 1};
        L = iArr9;
        int[] iArr10 = {2, 3};
        M = iArr10;
        int[] iArr11 = {4, 15};
        N = iArr11;
        int[] iArr12 = {16, 115};
        O = iArr12;
        int i17 = (iArr9[1] - iArr9[0]) + 1;
        P = i17;
        int i18 = (iArr10[1] - iArr10[0]) + 1;
        Q = i18;
        int i19 = (iArr11[1] - iArr11[0]) + 1;
        R = i19;
        int i20 = (iArr12[1] - iArr12[0]) + 1;
        S = i20;
        T = i17 + i18 + i19 + i20;
        int[] iArr13 = {0, 1};
        U = iArr13;
        int[] iArr14 = {2, 3};
        V = iArr14;
        int[] iArr15 = {4, 15};
        W = iArr15;
        int[] iArr16 = {16, 115};
        X = iArr16;
        int[] iArr17 = {116, 127};
        Y = iArr17;
        int[] iArr18 = {128, 139};
        Z = iArr18;
        int[] iArr19 = {140, 159};
        f12514a0 = iArr19;
        int[] iArr20 = {160, 171};
        f12515b0 = iArr20;
        int[] iArr21 = {172, 191};
        f12516c0 = iArr21;
        int[] iArr22 = {192, 221};
        f12517d0 = iArr22;
        f12518e0 = new int[]{222, 229};
        f12519f0 = new int[]{230, 237};
        f12520g0 = new int[]{238, 239};
        f12521h0 = new int[]{240, 247};
        int[] iArr23 = {222, 249};
        f12522i0 = iArr23;
        int i21 = (iArr13[1] - iArr13[0]) + 1;
        f12523j0 = i21;
        int i22 = (iArr14[1] - iArr14[0]) + 1;
        f12524k0 = i22;
        int i23 = (iArr15[1] - iArr15[0]) + 1;
        f12525l0 = i23;
        int i24 = (iArr17[1] - iArr17[0]) + 1;
        f12526m0 = i24;
        int i25 = (iArr18[1] - iArr18[0]) + 1;
        f12527n0 = i25;
        int i26 = (iArr19[1] - iArr19[0]) + 1;
        f12528o0 = i26;
        int i27 = (iArr20[1] - iArr20[0]) + 1;
        f12529p0 = i27;
        int i28 = (iArr21[1] - iArr21[0]) + 1;
        f12530q0 = i28;
        int i29 = (iArr22[1] - iArr22[0]) + 1;
        f12531r0 = i29;
        int i30 = (iArr16[1] - iArr16[0]) + 1;
        f12533s0 = i30;
        int i31 = (iArr23[1] - iArr23[0]) + 1;
        f12535t0 = i31;
        f12537u0 = i21 + i22 + i23 + i24 + i25 + i26 + i27 + i28 + i29 + i30 + i31;
        f12539v0 = new a();
        f12541w0 = new C0265b();
        f12543x0 = new c();
    }

    public b(String str, int i10, String str2, String str3) {
        this.f12548c = str2;
        this.f12549d = str3;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock reentrantReadWriteLock2 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock reentrantReadWriteLock3 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock reentrantReadWriteLock4 = new ReentrantReadWriteLock();
        this.f12554i = reentrantReadWriteLock.readLock();
        this.f12555j = reentrantReadWriteLock.writeLock();
        this.f12556k = reentrantReadWriteLock2.readLock();
        reentrantReadWriteLock2.writeLock();
        this.f12557l = reentrantReadWriteLock3.readLock();
        this.f12558m = reentrantReadWriteLock3.writeLock();
        this.f12559n = reentrantReadWriteLock4.readLock();
        this.f12560o = reentrantReadWriteLock4.writeLock();
        new Thread(new d(str, i10)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z10) {
        if (z10) {
            t(this.f12549d);
        }
        try {
            try {
                this.f12556k.lock();
                this.f12552g.a(null);
            } catch (Exception e10) {
                v7.b.b("AUDPVoiceApi", e10);
            }
        } finally {
            this.f12556k.unlock();
        }
    }

    private static void u(byte[] bArr, int[] iArr, byte[] bArr2) {
        int i10 = 0;
        int i11 = iArr[0];
        while (i11 <= iArr[1]) {
            bArr[i11] = bArr2[i10];
            i11++;
            i10++;
        }
    }

    private static void v(byte[] bArr, int[] iArr, int i10) {
        for (int i11 = iArr[1]; i11 >= iArr[0]; i11--) {
            bArr[i11] = (byte) (i10 & 255);
            i10 >>= 8;
        }
    }

    private static void w(byte[] bArr, int[] iArr, String str) {
        int length = str.length();
        int i10 = 0;
        for (int i11 = iArr[0]; i11 <= iArr[1]; i11++) {
            bArr[i11] = (byte) (i10 < length ? str.charAt(i10) : (char) 0);
            i10++;
        }
    }

    public abstract void A(String str);

    public void B(byte[] bArr) {
        int i10 = K;
        byte[] bArr2 = new byte[i10];
        int[] iArr = f12544y;
        int i11 = f12532s;
        f12532s = i11 + 1;
        v(bArr2, iArr, i11);
        v(bArr2, f12545z, 0);
        u(bArr2, A, bArr);
        synchronized (this) {
            try {
                this.f12546a.send(new DatagramPacket(bArr2, i10));
                v7.b.c("AUDPVoiceApi", "sendVoicePacket #{} SENT {} bytes");
            } catch (Exception e10) {
                v7.b.b("AUDPVoiceApi", e10);
                this.f12546a.close();
            }
        }
    }

    public void C(h hVar) {
        try {
            this.f12558m.lock();
            this.f12561p = hVar;
        } finally {
            this.f12558m.unlock();
        }
    }

    public void D(String str) {
        if (str != null) {
            String[] split = str.split(":");
            if (split.length == 3) {
                String[] split2 = split[1].split(",");
                if (split2.length == 2) {
                    double doubleValue = Double.valueOf(split2[0]).doubleValue();
                    double doubleValue2 = Double.valueOf(split2[1]).doubleValue();
                    short shortValue = Short.valueOf(split[0]).shortValue();
                    ByteBuffer.wrap(this.f12553h).putDouble(doubleValue).putDouble(doubleValue2).putShort(shortValue).putLong(Long.valueOf(split[2]).longValue());
                }
            }
        }
    }

    public void E(o7.a aVar) {
        try {
            this.f12555j.lock();
            if (aVar == null) {
                aVar = f12543x0;
            }
            this.f12551f = aVar;
        } finally {
            this.f12555j.unlock();
        }
    }

    public int q(int i10, k kVar) {
        return r(i10, kVar, x());
    }

    public int r(int i10, k kVar, int i11) {
        byte[] bArr;
        if (3 == i10) {
            bArr = new byte[J + F];
            u(bArr, f12542x, this.f12553h);
        } else {
            bArr = new byte[J];
        }
        w(bArr, f12538v, String.valueOf(i11));
        w(bArr, f12534t, this.f12549d);
        w(bArr, f12536u, this.f12548c);
        v(bArr, f12540w, i10);
        this.f12550e.put(Integer.valueOf(i11), kVar);
        synchronized (this) {
            try {
                this.f12546a.send(new DatagramPacket(bArr, bArr.length));
                v7.b.c("AUDPVoiceApi", "callTCPVoiceApi SENT request Id " + i11 + " type " + String.valueOf(i10) + " for " + this.f12549d + " via port " + this.f12546a.getLocalSocketAddress().toString());
            } catch (Exception e10) {
                v7.b.b("AUDPVoiceApi", e10);
                this.f12546a.close();
            }
        }
        return i11;
    }

    public void s() {
        this.f12563r = false;
        this.f12546a.close();
    }

    protected abstract void t(String str);

    public int x() {
        int nextInt;
        do {
            nextInt = new Random().nextInt(1000000000);
        } while (this.f12550e.containsKey(Integer.valueOf(nextInt)));
        return nextInt;
    }

    public long y() {
        try {
            this.f12559n.lock();
            return this.f12562q;
        } finally {
            this.f12559n.unlock();
        }
    }

    protected abstract void z(byte[] bArr);
}
