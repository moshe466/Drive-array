package net.sourceforge.zbar;

/* loaded from: classes.dex */
public class Symbol {

    /* renamed from: a, reason: collision with root package name */
    private long f12442a;

    /* renamed from: b, reason: collision with root package name */
    private int f12443b;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Symbol(long j10) {
        this.f12442a = j10;
    }

    private native void destroy(long j10);

    private native int getType(long j10);

    private static native void init();

    public synchronized void a() {
        long j10 = this.f12442a;
        if (j10 != 0) {
            destroy(j10);
            this.f12442a = 0L;
        }
    }

    public int b() {
        if (this.f12443b == 0) {
            this.f12443b = getType(this.f12442a);
        }
        return this.f12443b;
    }

    protected void finalize() {
        a();
    }

    public native String getData();

    public native byte[] getDataBytes();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long next();
}
