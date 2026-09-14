package M0;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1386a;

    public /* synthetic */ a(int i) {
        this.f1386a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        if (r0 != false) goto L18;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            int r0 = r5.f1386a
            switch(r0) {
                case 0: goto L89;
                case 1: goto L73;
                case 2: goto L5f;
                case 3: goto L52;
                case 4: goto L49;
                case 5: goto L3c;
                default: goto L5;
            }
        L5:
            k0.h r6 = (k0.C0484h) r6
            k0.h r7 = (k0.C0484h) r7
            androidx.recyclerview.widget.RecyclerView r0 = r6.f5245d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L11
            r3 = r2
            goto L12
        L11:
            r3 = r1
        L12:
            androidx.recyclerview.widget.RecyclerView r4 = r7.f5245d
            if (r4 != 0) goto L18
            r4 = r2
            goto L19
        L18:
            r4 = r1
        L19:
            if (r3 == r4) goto L1e
            if (r0 != 0) goto L26
            goto L28
        L1e:
            boolean r0 = r6.f5242a
            boolean r3 = r7.f5242a
            if (r0 == r3) goto L2a
            if (r0 == 0) goto L28
        L26:
            r1 = -1
            goto L3b
        L28:
            r1 = r2
            goto L3b
        L2a:
            int r0 = r7.f5243b
            int r2 = r6.f5243b
            int r0 = r0 - r2
            if (r0 == 0) goto L33
            r1 = r0
            goto L3b
        L33:
            int r6 = r6.f5244c
            int r7 = r7.f5244c
            int r6 = r6 - r7
            if (r6 == 0) goto L3b
            r1 = r6
        L3b:
            return r1
        L3c:
            g1.k r6 = (g1.k) r6
            java.lang.String r6 = r6.f4699a
            g1.k r7 = (g1.k) r7
            java.lang.String r7 = r7.f4699a
            int r6 = a.AbstractC0228a.d(r6, r7)
            return r6
        L49:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = (java.lang.String) r7
            int r6 = a.AbstractC0228a.d(r6, r7)
            return r6
        L52:
            g1.k r6 = (g1.k) r6
            java.lang.String r6 = r6.f4699a
            g1.k r7 = (g1.k) r7
            java.lang.String r7 = r7.f4699a
            int r6 = a.AbstractC0228a.d(r6, r7)
            return r6
        L5f:
            X0.a r6 = (X0.a) r6
            X0.a r7 = (X0.a) r7
            long r0 = r6.f2580f
            long r6 = r7.f2580f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L6d
            r6 = 1
            goto L72
        L6d:
            if (r6 >= 0) goto L71
            r6 = -1
            goto L72
        L71:
            r6 = 0
        L72:
            return r6
        L73:
            W0.g r6 = (W0.g) r6
            W0.g r7 = (W0.g) r7
            java.lang.Object r6 = r6.f2458a
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r7 = r7.f2458a
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            int r6 = r6 - r7
            return r6
        L89:
            W0.g r6 = (W0.g) r6
            W0.g r7 = (W0.g) r7
            java.lang.Object r6 = r6.f2458a
            java.lang.Character r6 = (java.lang.Character) r6
            char r6 = r6.charValue()
            java.lang.Object r7 = r7.f2458a
            java.lang.Character r7 = (java.lang.Character) r7
            char r7 = r7.charValue()
            int r6 = r6 - r7
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.a.compare(java.lang.Object, java.lang.Object):int");
    }
}
