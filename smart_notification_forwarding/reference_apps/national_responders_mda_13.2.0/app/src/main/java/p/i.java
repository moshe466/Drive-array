package p;

import java.util.ArrayList;
import java.util.Arrays;
import q.o;

/* loaded from: classes.dex */
public class i extends e implements h {

    /* renamed from: w0, reason: collision with root package name */
    public e[] f12998w0 = new e[4];

    /* renamed from: x0, reason: collision with root package name */
    public int f12999x0 = 0;

    @Override // p.h
    public void a(f fVar) {
    }

    @Override // p.h
    public void b() {
        this.f12999x0 = 0;
        Arrays.fill(this.f12998w0, (Object) null);
    }

    @Override // p.h
    public void c(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i10 = this.f12999x0 + 1;
        e[] eVarArr = this.f12998w0;
        if (i10 > eVarArr.length) {
            this.f12998w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f12998w0;
        int i11 = this.f12999x0;
        eVarArr2[i11] = eVar;
        this.f12999x0 = i11 + 1;
    }

    public void o1(ArrayList<o> arrayList, int i10, o oVar) {
        for (int i11 = 0; i11 < this.f12999x0; i11++) {
            oVar.a(this.f12998w0[i11]);
        }
        for (int i12 = 0; i12 < this.f12999x0; i12++) {
            q.i.a(this.f12998w0[i12], i10, arrayList, oVar);
        }
    }

    public int p1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.f12999x0; i13++) {
            e eVar = this.f12998w0[i13];
            if (i10 == 0 && (i12 = eVar.f12980t0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = eVar.f12982u0) != -1) {
                return i11;
            }
        }
        return -1;
    }
}
