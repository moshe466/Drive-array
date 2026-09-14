package U2;

import P2.W;
import P2.X;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2383b = AtomicIntegerFieldUpdater.newUpdater(w.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public W[] f2384a;

    public final void a(W w3) {
        w3.c((X) this);
        W[] wArr = this.f2384a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2383b;
        if (wArr == null) {
            wArr = new W[4];
            this.f2384a = wArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= wArr.length) {
            Object[] copyOf = Arrays.copyOf(wArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(...)");
            wArr = (W[]) copyOf;
            this.f2384a = wArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        wArr[i] = w3;
        w3.f1632b = i;
        c(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (r6.compareTo(r7) < 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final P2.W b(int r9) {
        /*
            r8 = this;
            P2.W[] r0 = r8.f2384a
            kotlin.jvm.internal.j.b(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = U2.w.f2383b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.d(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            kotlin.jvm.internal.j.b(r4)
            r5 = r0[r2]
            kotlin.jvm.internal.j.b(r5)
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.d(r9, r2)
            r8.c(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            P2.W[] r5 = r8.f2384a
            kotlin.jvm.internal.j.b(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            kotlin.jvm.internal.j.b(r6)
            r7 = r5[r4]
            kotlin.jvm.internal.j.b(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            kotlin.jvm.internal.j.b(r4)
            r5 = r5[r2]
            kotlin.jvm.internal.j.b(r5)
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.d(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            kotlin.jvm.internal.j.b(r9)
            r2 = 0
            r9.c(r2)
            r9.f1632b = r3
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: U2.w.b(int):P2.W");
    }

    public final void c(int i) {
        while (i > 0) {
            W[] wArr = this.f2384a;
            kotlin.jvm.internal.j.b(wArr);
            int i3 = (i - 1) / 2;
            W w3 = wArr[i3];
            kotlin.jvm.internal.j.b(w3);
            W w4 = wArr[i];
            kotlin.jvm.internal.j.b(w4);
            if (w3.compareTo(w4) <= 0) {
                return;
            }
            d(i, i3);
            i = i3;
        }
    }

    public final void d(int i, int i3) {
        W[] wArr = this.f2384a;
        kotlin.jvm.internal.j.b(wArr);
        W w3 = wArr[i3];
        kotlin.jvm.internal.j.b(w3);
        W w4 = wArr[i];
        kotlin.jvm.internal.j.b(w4);
        wArr[i] = w3;
        wArr[i3] = w4;
        w3.f1632b = i;
        w4.f1632b = i3;
    }
}
