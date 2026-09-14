package e4;

import com.google.firebase.crashlytics.internal.common.p;
import i1.h;
import z2.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements h {

    /* renamed from: a, reason: collision with root package name */
    private final m f9140a;

    /* renamed from: b, reason: collision with root package name */
    private final p f9141b;

    private a(m mVar, p pVar) {
        this.f9140a = mVar;
        this.f9141b = pVar;
    }

    public static h b(m mVar, p pVar) {
        return new a(mVar, pVar);
    }

    @Override // i1.h
    public void a(Exception exc) {
        c.b(this.f9140a, this.f9141b, exc);
    }
}
