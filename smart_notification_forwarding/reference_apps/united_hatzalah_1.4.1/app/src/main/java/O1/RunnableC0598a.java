package o1;

/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0598a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5911a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f5912b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f5913c;

    public /* synthetic */ RunnableC0598a(j jVar, boolean z3, int i) {
        this.f5911a = i;
        this.f5912b = jVar;
        this.f5913c = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5911a) {
            case 0:
                this.f5912b.c().edit().putBoolean("is_image_overlay_mode_enabled", this.f5913c).apply();
                return;
            case 1:
                this.f5912b.c().edit().putBoolean("is_blur_overlay_mode_enabled", this.f5913c).apply();
                return;
            case 2:
                this.f5912b.c().edit().putBoolean("is_color_overlay_mode_enabled", this.f5913c).apply();
                return;
            case 3:
                j jVar = this.f5912b;
                if (!jVar.f5940m && !jVar.f5941n && !jVar.f5942o && !this.f5913c) {
                    jVar.l();
                    return;
                } else {
                    jVar.k();
                    return;
                }
            default:
                this.f5912b.c().edit().putBoolean("is_screenshot_on", this.f5913c).apply();
                return;
        }
    }
}
