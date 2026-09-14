package androidx.appcompat.view.menu;

import F0.b3;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import l.InterfaceC0498B;
import l.l;
import l.m;
import l.o;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements l, InterfaceC0498B, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2781b = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public m f2782a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        b3 t3 = b3.t(context, attributeSet, f2781b, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) t3.f470c;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(t3.o(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(t3.o(1));
        }
        t3.v();
    }

    @Override // l.l
    public final boolean a(o oVar) {
        return this.f2782a.q(oVar, null, 0);
    }

    @Override // l.InterfaceC0498B
    public final void b(m mVar) {
        this.f2782a = mVar;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        a((o) getAdapter().getItem(i));
    }
}
