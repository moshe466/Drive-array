package d9;

import java.util.NoSuchElementException;
import m8.g0;

/* loaded from: classes.dex */
public final class b extends g0 {

    /* renamed from: f, reason: collision with root package name */
    private final int f8749f;

    /* renamed from: g, reason: collision with root package name */
    private final int f8750g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8751h;

    /* renamed from: i, reason: collision with root package name */
    private int f8752i;

    public b(int i10, int i11, int i12) {
        this.f8749f = i12;
        this.f8750g = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f8751h = z10;
        this.f8752i = z10 ? i10 : i11;
    }

    @Override // m8.g0
    public int b() {
        int i10 = this.f8752i;
        if (i10 != this.f8750g) {
            this.f8752i = this.f8749f + i10;
        } else {
            if (!this.f8751h) {
                throw new NoSuchElementException();
            }
            this.f8751h = false;
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f8751h;
    }
}
