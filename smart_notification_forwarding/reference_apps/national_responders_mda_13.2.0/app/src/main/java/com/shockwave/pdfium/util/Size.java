package com.shockwave.pdfium.util;

/* loaded from: classes.dex */
public class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f8618a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8619b;

    public Size(int i10, int i11) {
        this.f8618a = i10;
        this.f8619b = i11;
    }

    public int a() {
        return this.f8619b;
    }

    public int b() {
        return this.f8618a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f8618a == size.f8618a && this.f8619b == size.f8619b;
    }

    public int hashCode() {
        int i10 = this.f8619b;
        int i11 = this.f8618a;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    public String toString() {
        return this.f8618a + "x" + this.f8619b;
    }
}
