package x2;

import a2.f;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b2.c;
import b2.l0;
import b2.p;

/* loaded from: classes.dex */
public class a extends b2.h<g> implements w2.f {
    public static final /* synthetic */ int J = 0;
    private final boolean F;
    private final b2.e G;
    private final Bundle H;
    private final Integer I;

    public a(Context context, Looper looper, boolean z10, b2.e eVar, Bundle bundle, f.b bVar, f.c cVar) {
        super(context, looper, 44, eVar, bVar, cVar);
        this.F = true;
        this.G = eVar;
        this.H = bundle;
        this.I = eVar.g();
    }

    public static Bundle q0(b2.e eVar) {
        eVar.f();
        Integer g10 = eVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", eVar.a());
        if (g10 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g10.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // b2.c
    protected final Bundle F() {
        if (!D().getPackageName().equals(this.G.d())) {
            this.H.putString("com.google.android.gms.signin.internal.realClientPackageName", this.G.d());
        }
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final String J() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // b2.c
    protected final String K() {
        return "com.google.android.gms.signin.service.START";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.f
    public final void d(b2.j jVar, boolean z10) {
        try {
            ((g) I()).x0(jVar, ((Integer) p.k(this.I)).intValue(), z10);
        } catch (RemoteException unused) {
        }
    }

    @Override // b2.c
    public final int h() {
        return com.google.android.gms.common.e.f5095a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.f
    public final void l() {
        try {
            ((g) I()).z(((Integer) p.k(this.I)).intValue());
        } catch (RemoteException unused) {
        }
    }

    @Override // b2.c, a2.a.f
    public final boolean r() {
        return this.F;
    }

    @Override // w2.f
    public final void s() {
        t(new c.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.f
    public final void u(f fVar) {
        p.l(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b10 = this.G.b();
            ((g) I()).y0(new j(1, new l0(b10, ((Integer) p.k(this.I)).intValue(), "<<default account>>".equals(b10.name) ? w1.a.a(D()).b() : null)), fVar);
        } catch (RemoteException e10) {
            try {
                fVar.o0(new l(1, new com.google.android.gms.common.a(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final /* synthetic */ IInterface x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder);
    }
}
