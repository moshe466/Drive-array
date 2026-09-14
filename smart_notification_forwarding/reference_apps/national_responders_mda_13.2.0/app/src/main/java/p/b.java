package p;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        if (r8 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0044, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0042, code lost:
    
        if (r8 == 2) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0268 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0522 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x035e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bb  */
    /* JADX WARN: Type inference failed for: r1v42, types: [p.e] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [p.e] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(p.f r38, m.d r39, int r40, int r41, p.c r42) {
        /*
            Method dump skipped, instructions count: 1347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.b.a(p.f, m.d, int, int, p.c):void");
    }

    public static void b(f fVar, m.d dVar, ArrayList<e> arrayList, int i10) {
        c[] cVarArr;
        int i11;
        int i12;
        if (i10 == 0) {
            i11 = fVar.F0;
            cVarArr = fVar.I0;
            i12 = 0;
        } else {
            int i13 = fVar.G0;
            cVarArr = fVar.H0;
            i11 = i13;
            i12 = 2;
        }
        for (int i14 = 0; i14 < i11; i14++) {
            c cVar = cVarArr[i14];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f12910a)) {
                a(fVar, dVar, i10, i12, cVar);
            }
        }
    }
}
