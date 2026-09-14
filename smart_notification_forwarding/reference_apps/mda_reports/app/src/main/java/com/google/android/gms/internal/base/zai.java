package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class zai extends Drawable.ConstantState {
    int a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zai(zai zaiVar) {
        if (zaiVar != null) {
            this.a = zaiVar.a;
            this.b = zaiVar.b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zae(this);
    }
}
