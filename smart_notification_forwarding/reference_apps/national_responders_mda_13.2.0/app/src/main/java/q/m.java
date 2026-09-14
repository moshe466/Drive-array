package q;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {

    /* renamed from: c, reason: collision with root package name */
    public static int f13395c;

    /* renamed from: a, reason: collision with root package name */
    p f13396a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<p> f13397b = new ArrayList<>();

    public m(p pVar, int i10) {
        this.f13396a = null;
        f13395c++;
        this.f13396a = pVar;
    }

    private long c(f fVar, long j10) {
        p pVar = fVar.f13380d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f13387k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = fVar.f13387k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f13380d != pVar) {
                    j11 = Math.min(j11, c(fVar2, fVar2.f13382f + j10));
                }
            }
        }
        if (fVar != pVar.f13415i) {
            return j11;
        }
        long j12 = j10 - pVar.j();
        return Math.min(Math.min(j11, c(pVar.f13414h, j12)), j12 - pVar.f13414h.f13382f);
    }

    private long d(f fVar, long j10) {
        p pVar = fVar.f13380d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f13387k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = fVar.f13387k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f13380d != pVar) {
                    j11 = Math.max(j11, d(fVar2, fVar2.f13382f + j10));
                }
            }
        }
        if (fVar != pVar.f13414h) {
            return j11;
        }
        long j12 = j10 + pVar.j();
        return Math.max(Math.max(j11, d(pVar.f13415i, j12)), j12 - pVar.f13415i.f13382f);
    }

    public void a(p pVar) {
        this.f13397b.add(pVar);
    }

    public long b(p.f fVar, int i10) {
        long j10;
        p pVar;
        long j11;
        long j12;
        p pVar2 = this.f13396a;
        if (pVar2 instanceof c) {
            if (((c) pVar2).f13412f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(pVar2 instanceof l)) {
                return 0L;
            }
        } else if (!(pVar2 instanceof n)) {
            return 0L;
        }
        f fVar2 = (i10 == 0 ? fVar.f12947d : fVar.f12949e).f13414h;
        f fVar3 = (i10 == 0 ? fVar.f12947d : fVar.f12949e).f13415i;
        boolean contains = pVar2.f13414h.f13388l.contains(fVar2);
        boolean contains2 = this.f13396a.f13415i.f13388l.contains(fVar3);
        long j13 = this.f13396a.j();
        if (!contains || !contains2) {
            if (contains) {
                j12 = d(this.f13396a.f13414h, r13.f13382f);
                j11 = this.f13396a.f13414h.f13382f + j13;
            } else if (contains2) {
                j11 = (-this.f13396a.f13415i.f13382f) + j13;
                j12 = -c(this.f13396a.f13415i, r13.f13382f);
            } else {
                j10 = r13.f13414h.f13382f + this.f13396a.j();
                pVar = this.f13396a;
            }
            return Math.max(j12, j11);
        }
        long d10 = d(this.f13396a.f13414h, 0L);
        long c10 = c(this.f13396a.f13415i, 0L);
        long j14 = d10 - j13;
        p pVar3 = this.f13396a;
        int i11 = pVar3.f13415i.f13382f;
        if (j14 >= (-i11)) {
            j14 += i11;
        }
        int i12 = pVar3.f13414h.f13382f;
        long j15 = ((-c10) - j13) - i12;
        if (j15 >= i12) {
            j15 -= i12;
        }
        float f10 = (float) (pVar3.f13408b.o(i10) > 0.0f ? (((float) j15) / r13) + (((float) j14) / (1.0f - r13)) : 0L);
        long j16 = (f10 * r13) + 0.5f + j13 + (f10 * (1.0f - r13)) + 0.5f;
        pVar = this.f13396a;
        j10 = pVar.f13414h.f13382f + j16;
        return j10 - pVar.f13415i.f13382f;
    }
}
