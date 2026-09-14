package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import g.AbstractC0424a;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final int f2769a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2770b;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4644t);
        this.f2770b = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f2769a = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
