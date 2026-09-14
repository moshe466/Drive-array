package m;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f5757a = null;

    /* renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f5758b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5759c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5760d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5761e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f5762f;

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f5762f;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f5759c || this.f5760d) {
                Drawable mutate = buttonDrawable.mutate();
                if (this.f5759c) {
                    mutate.setTintList(this.f5757a);
                }
                if (this.f5760d) {
                    mutate.setTintMode(this.f5758b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    public void b() {
        C0564q c0564q = (C0564q) this.f5762f;
        Drawable checkMarkDrawable = c0564q.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f5759c || this.f5760d) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.f5759c) {
                    mutate.setTintList(this.f5757a);
                }
                if (this.f5760d) {
                    mutate.setTintMode(this.f5758b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(c0564q.getDrawableState());
                }
                c0564q.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.widget.TextView r0 = r8.f5762f
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.content.Context r0 = r1.getContext()
            int[] r3 = g.AbstractC0424a.f4638m
            F0.b3 r7 = F0.b3.t(r0, r9, r3, r10)
            java.lang.Object r0 = r7.f470c
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r1.getContext()
            java.lang.Object r4 = r7.f470c
            r5 = r4
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r4 = r9
            r6 = r10
            J.S.h(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            if (r10 == 0) goto L3e
            int r9 = r0.getResourceId(r9, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L3e
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            android.graphics.drawable.Drawable r9 = a.AbstractC0228a.q(r10, r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            goto L55
        L3b:
            r0 = move-exception
            r9 = r0
            goto L7b
        L3e:
            boolean r9 = r0.hasValue(r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            int r9 = r0.getResourceId(r2, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b
            android.graphics.drawable.Drawable r9 = a.AbstractC0228a.q(r10, r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b
        L55:
            r9 = 2
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L63
            android.content.res.ColorStateList r9 = r7.n(r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonTintList(r9)     // Catch: java.lang.Throwable -> L3b
        L63:
            r9 = 3
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L77
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = m.AbstractC0565q0.c(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonTintMode(r9)     // Catch: java.lang.Throwable -> L3b
        L77:
            r7.v()
            return
        L7b:
            r7.v()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: m.r.c(android.util.AttributeSet, int):void");
    }
}
