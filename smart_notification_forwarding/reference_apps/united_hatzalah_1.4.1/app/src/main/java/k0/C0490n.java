package k0;

import F0.AbstractC0083t;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: k0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0490n extends AbstractC0083t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5263b;

    public C0490n(t tVar, int i) {
        this.f5263b = i;
        new Rect();
        this.f662a = tVar;
    }

    @Override // F0.AbstractC0083t
    public final int h(View view) {
        int right;
        int i;
        switch (this.f5263b) {
            case 0:
                u uVar = (u) view.getLayoutParams();
                ((t) this.f662a).getClass();
                right = view.getRight() + ((u) view.getLayoutParams()).f5275a.right;
                i = ((ViewGroup.MarginLayoutParams) uVar).rightMargin;
                break;
            default:
                u uVar2 = (u) view.getLayoutParams();
                ((t) this.f662a).getClass();
                right = view.getBottom() + ((u) view.getLayoutParams()).f5275a.bottom;
                i = ((ViewGroup.MarginLayoutParams) uVar2).bottomMargin;
                break;
        }
        return right + i;
    }

    @Override // F0.AbstractC0083t
    public final int i(View view) {
        int left;
        int i;
        switch (this.f5263b) {
            case 0:
                u uVar = (u) view.getLayoutParams();
                ((t) this.f662a).getClass();
                left = view.getLeft() - ((u) view.getLayoutParams()).f5275a.left;
                i = ((ViewGroup.MarginLayoutParams) uVar).leftMargin;
                break;
            default:
                u uVar2 = (u) view.getLayoutParams();
                ((t) this.f662a).getClass();
                left = view.getTop() - ((u) view.getLayoutParams()).f5275a.top;
                i = ((ViewGroup.MarginLayoutParams) uVar2).topMargin;
                break;
        }
        return left - i;
    }

    @Override // F0.AbstractC0083t
    public final int j() {
        int i;
        int t3;
        switch (this.f5263b) {
            case 0:
                t tVar = (t) this.f662a;
                i = tVar.f5273f;
                t3 = tVar.t();
                break;
            default:
                t tVar2 = (t) this.f662a;
                i = tVar2.f5274g;
                t3 = tVar2.r();
                break;
        }
        return i - t3;
    }

    @Override // F0.AbstractC0083t
    public final int k() {
        switch (this.f5263b) {
            case 0:
                return ((t) this.f662a).s();
            default:
                return ((t) this.f662a).u();
        }
    }

    @Override // F0.AbstractC0083t
    public final int l() {
        int s3;
        int t3;
        switch (this.f5263b) {
            case 0:
                t tVar = (t) this.f662a;
                s3 = tVar.f5273f - tVar.s();
                t3 = tVar.t();
                break;
            default:
                t tVar2 = (t) this.f662a;
                s3 = tVar2.f5274g - tVar2.u();
                t3 = tVar2.r();
                break;
        }
        return s3 - t3;
    }
}
