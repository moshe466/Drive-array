package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f0;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class ViewPager extends RelativeLayout {

    /* renamed from: f, reason: collision with root package name */
    a f8405f;

    /* renamed from: g, reason: collision with root package name */
    c6.h f8406g;

    /* renamed from: h, reason: collision with root package name */
    int f8407h;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i10);
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b(Fragment fragment, Boolean bool) {
        int i10;
        int i11;
        f0 o10 = this.f8406g.f4425a.o();
        if (bool != null) {
            if (bool.booleanValue()) {
                i10 = R.animator.show_left;
                i11 = R.animator.hide_right;
            } else {
                i10 = R.animator.show_right;
                i11 = R.animator.hide_left;
            }
            o10.q(i10, i11);
        }
        o10.o(R.id.container, fragment);
        o10.i();
    }

    public void a(a aVar) {
        this.f8405f = aVar;
    }

    public void setAdapter(c6.h hVar) {
        this.f8406g = hVar;
    }

    public void setCurrentItem(int i10) {
        Boolean valueOf;
        int i11 = this.f8407h;
        if (i11 == i10) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(i11 > i10);
        }
        this.f8407h = i10;
        b(this.f8406g.a(i10), valueOf);
        a aVar = this.f8405f;
        if (aVar != null) {
            aVar.a(this.f8407h);
        }
    }
}
