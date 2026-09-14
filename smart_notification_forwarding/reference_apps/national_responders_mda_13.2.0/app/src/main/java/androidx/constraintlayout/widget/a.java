package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: o, reason: collision with root package name */
    private int f1773o;

    /* renamed from: p, reason: collision with root package name */
    private int f1774p;

    /* renamed from: q, reason: collision with root package name */
    private p.a f1775q;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
    
        if (r7 == 6) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        if (r7 == 6) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        if (r7 == 6) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t(p.e r6, int r7, boolean r8) {
        /*
            r5 = this;
            r5.f1774p = r7
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 1
            r1 = 0
            r2 = 6
            r3 = 5
            r4 = 17
            if (r7 >= r4) goto L16
            int r7 = r5.f1773o
            if (r7 != r3) goto L13
        L10:
            r5.f1774p = r1
            goto L28
        L13:
            if (r7 != r2) goto L28
        L15:
            goto L1c
        L16:
            int r7 = r5.f1773o
            if (r8 == 0) goto L22
            if (r7 != r3) goto L1f
        L1c:
            r5.f1774p = r0
            goto L28
        L1f:
            if (r7 != r2) goto L28
            goto L10
        L22:
            if (r7 != r3) goto L25
            goto L10
        L25:
            if (r7 != r2) goto L28
            goto L15
        L28:
            boolean r7 = r6 instanceof p.a
            if (r7 == 0) goto L33
            p.a r6 = (p.a) r6
            int r7 = r5.f1774p
            r6.x1(r7)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.a.t(p.e, int, boolean):void");
    }

    public boolean getAllowsGoneWidget() {
        return this.f1775q.r1();
    }

    public int getMargin() {
        return this.f1775q.t1();
    }

    public int getType() {
        return this.f1773o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.c
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        this.f1775q = new p.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.U0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == j.f1951d1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == j.f1943c1) {
                    this.f1775q.w1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == j.f1959e1) {
                    this.f1775q.y1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1788i = this.f1775q;
        s();
    }

    @Override // androidx.constraintlayout.widget.c
    public void n(p.e eVar, boolean z10) {
        t(eVar, this.f1773o, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1775q.w1(z10);
    }

    public void setDpMargin(int i10) {
        this.f1775q.y1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f1775q.y1(i10);
    }

    public void setType(int i10) {
        this.f1773o = i10;
    }
}
