package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f2396a;

    /* renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f2397b;

    /* renamed from: c, reason: collision with root package name */
    ColorStateList f2398c;

    /* renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f2399d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(f fVar) {
        this.f2398c = null;
        this.f2399d = d.f2388l;
        if (fVar != null) {
            this.f2396a = fVar.f2396a;
            this.f2397b = fVar.f2397b;
            this.f2398c = fVar.f2398c;
            this.f2399d = fVar.f2399d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f2397b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i10 = this.f2396a;
        Drawable.ConstantState constantState = this.f2397b;
        return i10 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
