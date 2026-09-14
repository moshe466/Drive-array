package bc;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends f {

    /* renamed from: k, reason: collision with root package name */
    final transient byte[][] f4337k;

    /* renamed from: l, reason: collision with root package name */
    final transient int[] f4338l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar, int i10) {
        super(null);
        u.b(cVar.f4298g, 0L, i10);
        o oVar = cVar.f4297f;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = oVar.f4330c;
            int i15 = oVar.f4329b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            oVar = oVar.f4333f;
        }
        this.f4337k = new byte[i13];
        this.f4338l = new int[i13 * 2];
        o oVar2 = cVar.f4297f;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.f4337k;
            bArr[i16] = oVar2.f4328a;
            int i17 = oVar2.f4330c;
            int i18 = oVar2.f4329b;
            i11 += i17 - i18;
            if (i11 > i10) {
                i11 = i10;
            }
            int[] iArr = this.f4338l;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            oVar2.f4331d = true;
            i16++;
            oVar2 = oVar2.f4333f;
        }
    }

    private int I(int i10) {
        int binarySearch = Arrays.binarySearch(this.f4338l, 0, this.f4337k.length, i10 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private f J() {
        return new f(F());
    }

    @Override // bc.f
    public f A() {
        return J().A();
    }

    @Override // bc.f
    public int B() {
        return this.f4338l[this.f4337k.length - 1];
    }

    @Override // bc.f
    public f D(int i10, int i11) {
        return J().D(i10, i11);
    }

    @Override // bc.f
    public f E() {
        return J().E();
    }

    @Override // bc.f
    public byte[] F() {
        int[] iArr = this.f4338l;
        byte[][] bArr = this.f4337k;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.f4338l;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.f4337k[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    @Override // bc.f
    public String G() {
        return J().G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bc.f
    public void H(c cVar) {
        int length = this.f4337k.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f4338l;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            o oVar = new o(this.f4337k[i10], i12, (i12 + i13) - i11, true, false);
            o oVar2 = cVar.f4297f;
            if (oVar2 == null) {
                oVar.f4334g = oVar;
                oVar.f4333f = oVar;
                cVar.f4297f = oVar;
            } else {
                oVar2.f4334g.c(oVar);
            }
            i10++;
            i11 = i13;
        }
        cVar.f4298g += i11;
    }

    @Override // bc.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.B() == B() && x(0, fVar, 0, B())) {
                return true;
            }
        }
        return false;
    }

    @Override // bc.f
    public int hashCode() {
        int i10 = this.f4302g;
        if (i10 != 0) {
            return i10;
        }
        int length = this.f4337k.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < length) {
            byte[] bArr = this.f4337k[i11];
            int[] iArr = this.f4338l;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i12) + i14;
            while (i14 < i16) {
                i13 = (i13 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i12 = i15;
        }
        this.f4302g = i13;
        return i13;
    }

    @Override // bc.f
    public String j() {
        return J().j();
    }

    @Override // bc.f
    public String toString() {
        return J().toString();
    }

    @Override // bc.f
    public byte u(int i10) {
        u.b(this.f4338l[this.f4337k.length - 1], i10, 1L);
        int I = I(i10);
        int i11 = I == 0 ? 0 : this.f4338l[I - 1];
        int[] iArr = this.f4338l;
        byte[][] bArr = this.f4337k;
        return bArr[I][(i10 - i11) + iArr[bArr.length + I]];
    }

    @Override // bc.f
    public String v() {
        return J().v();
    }

    @Override // bc.f
    public boolean x(int i10, f fVar, int i11, int i12) {
        if (i10 < 0 || i10 > B() - i12) {
            return false;
        }
        int I = I(i10);
        while (i12 > 0) {
            int i13 = I == 0 ? 0 : this.f4338l[I - 1];
            int min = Math.min(i12, ((this.f4338l[I] - i13) + i13) - i10);
            int[] iArr = this.f4338l;
            byte[][] bArr = this.f4337k;
            if (!fVar.y(i11, bArr[I], (i10 - i13) + iArr[bArr.length + I], min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            I++;
        }
        return true;
    }

    @Override // bc.f
    public boolean y(int i10, byte[] bArr, int i11, int i12) {
        if (i10 < 0 || i10 > B() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int I = I(i10);
        while (i12 > 0) {
            int i13 = I == 0 ? 0 : this.f4338l[I - 1];
            int min = Math.min(i12, ((this.f4338l[I] - i13) + i13) - i10);
            int[] iArr = this.f4338l;
            byte[][] bArr2 = this.f4337k;
            if (!u.a(bArr2[I], (i10 - i13) + iArr[bArr2.length + I], bArr, i11, min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            I++;
        }
        return true;
    }

    @Override // bc.f
    public f z() {
        return J().z();
    }
}
