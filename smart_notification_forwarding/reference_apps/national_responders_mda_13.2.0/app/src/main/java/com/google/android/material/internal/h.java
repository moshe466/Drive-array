package com.google.android.material.internal;

import android.widget.ImageButton;

/* loaded from: classes.dex */
public class h extends ImageButton {

    /* renamed from: f, reason: collision with root package name */
    private int f6933f;

    public final void b(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f6933f = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f6933f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        b(i10, true);
    }
}
