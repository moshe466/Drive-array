package io.flutter.plugins.imagepicker;

import o1.j;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5075a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5076b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5077c;

    public /* synthetic */ b(Object obj, int i, int i3) {
        this.f5075a = i3;
        this.f5076b = obj;
        this.f5077c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5075a) {
            case 0:
                ImagePickerDelegate.b((ImagePickerDelegate) this.f5076b, this.f5077c);
                return;
            case 1:
                ImagePickerDelegate.h((ImagePickerDelegate) this.f5076b, this.f5077c);
                return;
            default:
                ((j) this.f5076b).c().edit().putInt("color_value", this.f5077c).apply();
                return;
        }
    }
}
