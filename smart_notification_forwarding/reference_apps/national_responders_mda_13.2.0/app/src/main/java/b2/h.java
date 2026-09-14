package b2;

import a2.a;
import a2.f;
import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class h<T extends IInterface> extends c<T> implements a.f, h0 {
    private final Set D;
    private final Account E;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public h(Context context, Looper looper, int i10, e eVar, f.b bVar, f.c cVar) {
        this(context, looper, i10, eVar, (com.google.android.gms.common.api.internal.f) bVar, (com.google.android.gms.common.api.internal.o) cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, Looper looper, int i10, e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.o oVar) {
        this(context, looper, i.b(context), com.google.android.gms.common.b.p(), i10, eVar, (com.google.android.gms.common.api.internal.f) p.k(fVar), (com.google.android.gms.common.api.internal.o) p.k(oVar));
    }

    protected h(Context context, Looper looper, i iVar, com.google.android.gms.common.b bVar, int i10, e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.o oVar) {
        super(context, looper, iVar, bVar, i10, fVar == null ? null : new f0(fVar), oVar == null ? null : new g0(oVar), eVar.h());
        this.E = eVar.a();
        this.D = p0(eVar.c());
    }

    private final Set p0(Set set) {
        Set<Scope> o02 = o0(set);
        Iterator<Scope> it = o02.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return o02;
    }

    @Override // b2.c
    protected final Executor B() {
        return null;
    }

    @Override // b2.c
    protected final Set<Scope> H() {
        return this.D;
    }

    @Override // a2.a.f
    public Set<Scope> c() {
        return r() ? this.D : Collections.emptySet();
    }

    protected Set<Scope> o0(Set<Scope> set) {
        return set;
    }

    @Override // b2.c
    public final Account z() {
        return this.E;
    }
}
