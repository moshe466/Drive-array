package net.sourceforge.zbar;

/* loaded from: classes.dex */
public class Image {

    /* renamed from: a, reason: collision with root package name */
    private long f12440a;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    public Image() {
        this.f12440a = create();
    }

    public Image(int i10, int i11, String str) {
        this();
        setSize(i10, i11);
        setFormat(str);
    }

    private native long create();

    private native void destroy(long j10);

    private static native void init();

    public synchronized void a() {
        long j10 = this.f12440a;
        if (j10 != 0) {
            destroy(j10);
            this.f12440a = 0L;
        }
    }

    protected void finalize() {
        a();
    }

    public native void setCrop(int i10, int i11, int i12, int i13);

    public native void setData(byte[] bArr);

    public native void setFormat(String str);

    public native void setSize(int i10, int i11);
}
