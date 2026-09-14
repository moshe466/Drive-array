package q0;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;
import k0.C0480d;

/* loaded from: classes.dex */
public final class h extends q {

    /* renamed from: z, reason: collision with root package name */
    public static final String[] f6086z = {"android:visibility:visibility", "android:visibility:parent"};
    public final int y;

    public h(int i) {
        this.y = i;
    }

    public static void H(x xVar) {
        int visibility = xVar.f6137b.getVisibility();
        HashMap hashMap = xVar.f6136a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = xVar.f6137b;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /* JADX WARN: Type inference failed for: r0v0, types: [q0.D, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static q0.D J(q0.x r8, q0.x r9) {
        /*
            q0.D r0 = new q0.D
            r0.<init>()
            r1 = 0
            r0.f6062a = r1
            r0.f6063b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f6136a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f6064c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f6066e = r6
            goto L33
        L2f:
            r0.f6064c = r3
            r0.f6066e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f6136a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f6065d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f6067f = r2
            goto L56
        L52:
            r0.f6065d = r3
            r0.f6067f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f6064c
            int r9 = r0.f6065d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f6066e
            android.view.ViewGroup r4 = r0.f6067f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f6063b = r1
            r0.f6062a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f6063b = r2
            r0.f6062a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f6067f
            if (r8 != 0) goto L81
            r0.f6063b = r1
            r0.f6062a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.f6066e
            if (r8 != 0) goto L9f
            r0.f6063b = r2
            r0.f6062a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f6065d
            if (r8 != 0) goto L95
            r0.f6063b = r2
            r0.f6062a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f6064c
            if (r8 != 0) goto L9f
            r0.f6063b = r1
            r0.f6062a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.h.J(q0.x, q0.x):q0.D");
    }

    public final ObjectAnimator I(View view, float f4, float f5) {
        if (f4 == f5) {
            return null;
        }
        y.f6139a.O(view, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, y.f6140b, f5);
        ofFloat.addListener(new C0480d(view));
        a(new g(view, 0));
        return ofFloat;
    }

    @Override // q0.q
    public final void e(x xVar) {
        H(xVar);
    }

    @Override // q0.q
    public final void h(x xVar) {
        H(xVar);
        xVar.f6136a.put("android:fade:transitionAlpha", Float.valueOf(y.f6139a.w(xVar.f6137b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (J(o(r3, false), r(r3, false)).f6062a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020b  */
    @Override // q0.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator l(android.view.ViewGroup r24, q0.x r25, q0.x r26) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.h.l(android.view.ViewGroup, q0.x, q0.x):android.animation.Animator");
    }

    @Override // q0.q
    public final String[] q() {
        return f6086z;
    }

    @Override // q0.q
    public final boolean s(x xVar, x xVar2) {
        if (xVar != null || xVar2 != null) {
            if (xVar == null || xVar2 == null || xVar2.f6136a.containsKey("android:visibility:visibility") == xVar.f6136a.containsKey("android:visibility:visibility")) {
                D J3 = J(xVar, xVar2);
                if (J3.f6062a) {
                    if (J3.f6064c == 0 || J3.f6065d == 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
