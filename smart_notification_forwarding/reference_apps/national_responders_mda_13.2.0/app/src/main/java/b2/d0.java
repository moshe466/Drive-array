package b2;

import android.content.Intent;

/* loaded from: classes.dex */
final class d0 extends e0 {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Intent f3955f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.internal.k f3956g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(Intent intent, com.google.android.gms.common.api.internal.k kVar, int i10) {
        this.f3955f = intent;
        this.f3956g = kVar;
    }

    @Override // b2.e0
    public final void a() {
        Intent intent = this.f3955f;
        if (intent != null) {
            this.f3956g.startActivityForResult(intent, 2);
        }
    }
}
