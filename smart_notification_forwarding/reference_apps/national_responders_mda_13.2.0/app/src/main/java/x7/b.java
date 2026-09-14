package x7;

import android.bluetooth.BluetoothAdapter;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import com.googlecode.androidilbc.Codec;
import java.util.concurrent.atomic.AtomicInteger;
import x7.h;

/* loaded from: classes.dex */
public class b extends o7.b implements h.a {
    private static AudioTrack D0;
    private final AtomicInteger A0;

    /* renamed from: y0, reason: collision with root package name */
    private AudioManager f15510y0;

    /* renamed from: z0, reason: collision with root package name */
    private h f15511z0;
    private static final ic.b B0 = ic.c.i(b.class.getSimpleName());
    private static Object C0 = new Object();
    private static Object E0 = new Object();

    public b(String str, int i10, String str2, String str3, AudioManager audioManager, h hVar, AtomicInteger atomicInteger) {
        super(str, i10, str2, str3);
        AudioTrack audioTrack = new AudioTrack(j.b().f15530a, 8000, 4, 2, 9600, 1);
        D0 = audioTrack;
        audioTrack.play();
        this.f15510y0 = audioManager;
        this.f15511z0 = hVar;
        this.A0 = atomicInteger;
        G();
    }

    @Override // o7.b
    public void A(String str) {
        synchronized (E0) {
            ic.b bVar = B0;
            bVar.c("preparePlayback({}): 1) is speaker on? {}", str, Boolean.valueOf(this.f15510y0.isSpeakerphoneOn()));
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter.getProfileConnectionState(1) == 2 || defaultAdapter.getProfileConnectionState(2) == 2) {
                bVar.c("preparePlayback(): 2) is BL SCO on? {} counter = {}", Boolean.valueOf(this.f15510y0.isBluetoothScoOn()), Integer.valueOf(this.A0.get()));
                if (this.f15510y0.isBluetoothScoOn() || this.A0.getAndIncrement() != 0) {
                    bVar.b("preparePlayback({}): 3) is BL SCO on? {} counter = {}", str, Boolean.valueOf(this.f15510y0.isBluetoothScoOn()), Integer.valueOf(this.A0.get()));
                } else {
                    try {
                        this.f15510y0.startBluetoothSco();
                        this.f15510y0.setBluetoothScoOn(true);
                    } catch (Exception e10) {
                        B0.c("preparePlayback({}) threw an exception", str, e10);
                        this.A0.decrementAndGet();
                    }
                }
            }
            H();
            B0.b("preparePlayback({}): 4) is speaker on? {} is BL SCO on? {}", str, Boolean.valueOf(this.f15510y0.isSpeakerphoneOn()), Boolean.valueOf(this.f15510y0.isBluetoothScoOn()));
            this.f15510y0.setMode(0);
            v7.b.c("media", "MODE_NORMAL");
        }
        this.f15511z0.a(this);
    }

    public void G() {
        if (D0 == null) {
            return;
        }
        synchronized (C0) {
            I();
            H();
            j.b().g();
        }
        j.b().f();
    }

    public void H() {
        j.b().g();
    }

    public void I() {
        float d10 = j.b().d();
        if (Build.VERSION.SDK_INT >= 21) {
            D0.setVolume(d10);
        } else {
            D0.setStereoVolume(d10, d10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        x7.b.B0.d("phoneCallEnded()", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003a, code lost:
    
        if (r7.A0.get() > 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        java.lang.Thread.sleep(100);
     */
    @Override // x7.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            r7 = this;
            java.lang.Object r0 = x7.b.E0
            monitor-enter(r0)
            ic.b r1 = x7.b.B0     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "phoneCallEnded(): 1) 1) is speaker on? {} is 2) is BL SCO on? {} mBtScoSemaphore {}"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9f
            r4 = 0
            android.media.AudioManager r5 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r5 = r5.isSpeakerphoneOn()     // Catch: java.lang.Throwable -> L9f
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L9f
            r3[r4] = r5     // Catch: java.lang.Throwable -> L9f
            android.media.AudioManager r4 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r4 = r4.isBluetoothScoOn()     // Catch: java.lang.Throwable -> L9f
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L9f
            r5 = 1
            r3[r5] = r4     // Catch: java.lang.Throwable -> L9f
            r4 = 2
            java.util.concurrent.atomic.AtomicInteger r6 = r7.A0     // Catch: java.lang.Throwable -> L9f
            int r6 = r6.get()     // Catch: java.lang.Throwable -> L9f
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L9f
            r3[r4] = r6     // Catch: java.lang.Throwable -> L9f
            r1.b(r2, r3)     // Catch: java.lang.Throwable -> L9f
            java.util.concurrent.atomic.AtomicInteger r1 = r7.A0     // Catch: java.lang.Throwable -> L9f
            int r1 = r1.get()     // Catch: java.lang.Throwable -> L9f
            if (r1 <= 0) goto L7f
        L3c:
            r1 = 100
            java.lang.Thread.sleep(r1)     // Catch: java.lang.InterruptedException -> L42 java.lang.Throwable -> L9f
            goto L4a
        L42:
            r1 = move-exception
            ic.b r2 = x7.b.B0     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "phoneCallEnded()"
            r2.d(r3, r1)     // Catch: java.lang.Throwable -> L9f
        L4a:
            android.media.AudioManager r1 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            r1.startBluetoothSco()     // Catch: java.lang.Throwable -> L9f
            android.media.AudioManager r1 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            r1.setBluetoothScoOn(r5)     // Catch: java.lang.Throwable -> L9f
            ic.b r1 = x7.b.B0     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "phoneCallEnded(): in loop) 1) is speaker on? {} is 2) is BL SCO on? {}"
            android.media.AudioManager r3 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r3 = r3.isSpeakerphoneOn()     // Catch: java.lang.Throwable -> L9f
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L9f
            android.media.AudioManager r4 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r4 = r4.isBluetoothScoOn()     // Catch: java.lang.Throwable -> L9f
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L9f
            r1.c(r2, r3, r4)     // Catch: java.lang.Throwable -> L9f
            android.media.AudioManager r1 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r1 = r1.isBluetoothScoOn()     // Catch: java.lang.Throwable -> L9f
            if (r1 != 0) goto L7f
            java.util.concurrent.atomic.AtomicInteger r1 = r7.A0     // Catch: java.lang.Throwable -> L9f
            int r1 = r1.get()     // Catch: java.lang.Throwable -> L9f
            if (r1 > 0) goto L3c
        L7f:
            r7.H()     // Catch: java.lang.Throwable -> L9f
            ic.b r1 = x7.b.B0     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "phoneCallEnded(): 3) 1) is speaker on? {} is 2) is BL SCO on? {}"
            android.media.AudioManager r3 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r3 = r3.isSpeakerphoneOn()     // Catch: java.lang.Throwable -> L9f
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L9f
            android.media.AudioManager r4 = r7.f15510y0     // Catch: java.lang.Throwable -> L9f
            boolean r4 = r4.isBluetoothScoOn()     // Catch: java.lang.Throwable -> L9f
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L9f
            r1.c(r2, r3, r4)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9f
            return
        L9f:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x7.b.a():void");
    }

    @Override // o7.b
    public void s() {
        super.s();
    }

    @Override // o7.b
    protected void t(String str) {
        this.f15511z0.b(this);
        synchronized (E0) {
            this.f15510y0.setMode(0);
            v7.b.c("media", "MODE_NORMAL");
            ic.b bVar = B0;
            bVar.c("concludePlayback({}): 1) is speaker on? {}", str, Boolean.valueOf(this.f15510y0.isSpeakerphoneOn()));
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter.getProfileConnectionState(1) == 2 || defaultAdapter.getProfileConnectionState(2) == 2) {
                bVar.b("concludePlayback({}): 2) is BL SCO on? {} counter = {}", str, Boolean.valueOf(this.f15510y0.isBluetoothScoOn()), Integer.valueOf(this.A0.get()));
                if (this.A0.get() > 0 && this.A0.decrementAndGet() == 0) {
                    this.f15510y0.setBluetoothScoOn(false);
                    this.f15510y0.stopBluetoothSco();
                }
            }
            bVar.b("concludePlayback({}): 3) is speaker on? {} is BL SCO on? {}", str, Boolean.valueOf(this.f15510y0.isSpeakerphoneOn()), Boolean.valueOf(this.f15510y0.isBluetoothScoOn()));
        }
    }

    @Override // o7.b
    protected void z(byte[] bArr) {
        byte[] bArr2 = new byte[960];
        int decode = Codec.a().decode(bArr, 0, bArr.length, bArr2, 0);
        synchronized (C0) {
            I();
            D0.write(bArr2, 0, decode);
        }
    }
}
