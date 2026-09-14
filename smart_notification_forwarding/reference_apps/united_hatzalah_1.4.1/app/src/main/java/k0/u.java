package k0;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class u extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f5275a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5276b;

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5275a = new Rect();
        this.f5276b = true;
    }

    public u(int i, int i3) {
        super(i, i3);
        this.f5275a = new Rect();
        this.f5276b = true;
    }

    public u(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f5275a = new Rect();
        this.f5276b = true;
    }

    public u(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f5275a = new Rect();
        this.f5276b = true;
    }

    public u(u uVar) {
        super((ViewGroup.LayoutParams) uVar);
        this.f5275a = new Rect();
        this.f5276b = true;
    }
}
