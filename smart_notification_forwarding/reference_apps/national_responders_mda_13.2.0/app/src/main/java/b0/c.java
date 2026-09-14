package b0;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected int f3908a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f3909b;

    /* renamed from: c, reason: collision with root package name */
    private int f3910c;

    /* renamed from: d, reason: collision with root package name */
    private int f3911d;

    public c() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i10) {
        return i10 + this.f3909b.getInt(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i10) {
        if (i10 < this.f3911d) {
            return this.f3909b.getShort(this.f3910c + i10);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i10, ByteBuffer byteBuffer) {
        short s10;
        this.f3909b = byteBuffer;
        if (byteBuffer != null) {
            this.f3908a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f3910c = i11;
            s10 = this.f3909b.getShort(i11);
        } else {
            s10 = 0;
            this.f3908a = 0;
            this.f3910c = 0;
        }
        this.f3911d = s10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i10) {
        int i11 = i10 + this.f3908a;
        return i11 + this.f3909b.getInt(i11) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(int i10) {
        int i11 = i10 + this.f3908a;
        return this.f3909b.getInt(i11 + this.f3909b.getInt(i11));
    }
}
