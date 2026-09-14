package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Segment {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    Segment f;
    Segment g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment a() {
        this.d = true;
        return new Segment(this.a, this.b, this.c, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment b() {
        return new Segment((byte[]) this.a.clone(), this.b, this.c, false, true);
    }

    public final void compact() {
        Segment segment = this.g;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.e) {
            int i = this.c - this.b;
            if (i > (8192 - segment.c) + (segment.d ? 0 : segment.b)) {
                return;
            }
            writeTo(this.g, i);
            pop();
            SegmentPool.a(this);
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.g;
        segment2.f = this.f;
        this.f.g = segment2;
        this.f = null;
        this.g = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        segment.g = this;
        segment.f = this.f;
        this.f.g = segment;
        this.f = segment;
        return segment;
    }

    public final Segment split(int i) {
        Segment a;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            a = a();
        } else {
            a = SegmentPool.a();
            System.arraycopy(this.a, this.b, a.a, 0, i);
        }
        a.c = a.b + i;
        this.b += i;
        this.g.push(a);
        return a;
    }

    public final void writeTo(Segment segment, int i) {
        if (!segment.e) {
            throw new IllegalArgumentException();
        }
        int i2 = segment.c;
        if (i2 + i > 8192) {
            if (segment.d) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.c -= segment.b;
            segment.b = 0;
        }
        System.arraycopy(this.a, this.b, segment.a, segment.c, i);
        segment.c += i;
        this.b += i;
    }
}
