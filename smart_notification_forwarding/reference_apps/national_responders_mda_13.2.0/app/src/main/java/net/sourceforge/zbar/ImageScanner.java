package net.sourceforge.zbar;

/* loaded from: classes.dex */
public class ImageScanner {

    /* renamed from: a, reason: collision with root package name */
    private long f12441a = create();

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    private native long create();

    private native void destroy(long j10);

    private native long getResults(long j10);

    private static native void init();

    public synchronized void a() {
        long j10 = this.f12441a;
        if (j10 != 0) {
            destroy(j10);
            this.f12441a = 0L;
        }
    }

    public SymbolSet b() {
        return new SymbolSet(getResults(this.f12441a));
    }

    protected void finalize() {
        a();
    }

    public native int scanImage(Image image);

    public native void setConfig(int i10, int i11, int i12);
}
