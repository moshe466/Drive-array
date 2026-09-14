package q2;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 extends i.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f13479a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ z2.m f13480b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(n0 n0Var, Object obj, z2.m mVar) {
        this.f13479a = obj;
        this.f13480b = mVar;
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final void U(Status status) {
        com.google.android.gms.common.api.internal.w.a(status, this.f13479a, this.f13480b);
    }
}
