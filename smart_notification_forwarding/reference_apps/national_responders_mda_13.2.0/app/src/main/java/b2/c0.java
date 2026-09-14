package b2;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
final class c0 extends e0 {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Intent f3948f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Activity f3949g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f3950h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Intent intent, Activity activity, int i10) {
        this.f3948f = intent;
        this.f3949g = activity;
        this.f3950h = i10;
    }

    @Override // b2.e0
    public final void a() {
        Intent intent = this.f3948f;
        if (intent != null) {
            this.f3949g.startActivityForResult(intent, this.f3950h);
        }
    }
}
