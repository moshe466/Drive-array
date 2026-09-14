package androidx.appcompat.widget;

import F0.G1;
import J.X;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import h.y;
import l.m;
import m.C0540e;
import m.C0548i;
import m.InterfaceC0555l0;
import m.InterfaceC0557m0;
import m.s1;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TypedValue f2868a;

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f2869b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f2870c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f2871d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f2872e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f2873f;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f2874j;

    /* renamed from: k, reason: collision with root package name */
    public InterfaceC0555l0 f2875k;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2874j = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2872e == null) {
            this.f2872e = new TypedValue();
        }
        return this.f2872e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2873f == null) {
            this.f2873f = new TypedValue();
        }
        return this.f2873f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2870c == null) {
            this.f2870c = new TypedValue();
        }
        return this.f2870c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2871d == null) {
            this.f2871d = new TypedValue();
        }
        return this.f2871d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2868a == null) {
            this.f2868a = new TypedValue();
        }
        return this.f2868a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2869b == null) {
            this.f2869b = new TypedValue();
        }
        return this.f2869b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0555l0 interfaceC0555l0 = this.f2875k;
        if (interfaceC0555l0 != null) {
            interfaceC0555l0.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0548i c0548i;
        super.onDetachedFromWindow();
        InterfaceC0555l0 interfaceC0555l0 = this.f2875k;
        if (interfaceC0555l0 != null) {
            y yVar = (y) ((G1) interfaceC0555l0).f218b;
            InterfaceC0557m0 interfaceC0557m0 = yVar.f4918u;
            if (interfaceC0557m0 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0557m0;
                actionBarOverlayLayout.e();
                ActionMenuView actionMenuView = ((s1) actionBarOverlayLayout.f2836e).f5772a.f2986a;
                if (actionMenuView != null && (c0548i = actionMenuView.f2861w) != null) {
                    c0548i.g();
                    C0540e c0540e = c0548i.f5686w;
                    if (c0540e != null && c0540e.b()) {
                        c0540e.i.dismiss();
                    }
                }
            }
            if (yVar.f4922z != null) {
                yVar.f4913o.getDecorView().removeCallbacks(yVar.f4875A);
                if (yVar.f4922z.isShowing()) {
                    try {
                        yVar.f4922z.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                yVar.f4922z = null;
            }
            X x3 = yVar.f4876B;
            if (x3 != null) {
                x3.b();
            }
            m mVar = yVar.z(0).f4864h;
            if (mVar != null) {
                mVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC0555l0 interfaceC0555l0) {
        this.f2875k = interfaceC0555l0;
    }
}
