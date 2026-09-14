package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.a0;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final View f6722a;

    /* renamed from: b, reason: collision with root package name */
    private int f6723b;

    /* renamed from: c, reason: collision with root package name */
    private int f6724c;

    /* renamed from: d, reason: collision with root package name */
    private int f6725d;

    /* renamed from: e, reason: collision with root package name */
    private int f6726e;

    public d(View view) {
        this.f6722a = view;
    }

    private void e() {
        View view = this.f6722a;
        a0.Z(view, this.f6725d - (view.getTop() - this.f6723b));
        View view2 = this.f6722a;
        a0.Y(view2, this.f6726e - (view2.getLeft() - this.f6724c));
    }

    public int a() {
        return this.f6725d;
    }

    public void b() {
        this.f6723b = this.f6722a.getTop();
        this.f6724c = this.f6722a.getLeft();
        e();
    }

    public boolean c(int i10) {
        if (this.f6726e == i10) {
            return false;
        }
        this.f6726e = i10;
        e();
        return true;
    }

    public boolean d(int i10) {
        if (this.f6725d == i10) {
            return false;
        }
        this.f6725d = i10;
        e();
        return true;
    }
}
