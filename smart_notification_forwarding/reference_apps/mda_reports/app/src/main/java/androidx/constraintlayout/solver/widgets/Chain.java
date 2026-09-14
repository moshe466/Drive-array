package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        ChainHead[] chainHeadArr;
        if (i == 0) {
            int i4 = constraintWidgetContainer.f0;
            chainHeadArr = constraintWidgetContainer.i0;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = constraintWidgetContainer.g0;
            chainHeadArr = constraintWidgetContainer.h0;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4) || !Optimizer.a(constraintWidgetContainer, linearSystem, i, i2, chainHead)) {
                a(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r2.U == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x004a, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0048, code lost:
    
        if (r2.V == 2) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r36, androidx.constraintlayout.solver.LinearSystem r37, int r38, int r39, androidx.constraintlayout.solver.widgets.ChainHead r40) {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.a(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
