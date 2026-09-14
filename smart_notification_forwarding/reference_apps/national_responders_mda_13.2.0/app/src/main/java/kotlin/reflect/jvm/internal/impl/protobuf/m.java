package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private d f11443a;

    /* renamed from: b, reason: collision with root package name */
    private g f11444b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f11445c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile q f11446d;

    protected void a(q qVar) {
        if (this.f11446d != null) {
            return;
        }
        synchronized (this) {
            if (this.f11446d != null) {
                return;
            }
            try {
                if (this.f11443a != null) {
                    qVar = qVar.i().d(this.f11443a, this.f11444b);
                }
                this.f11446d = qVar;
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        return this.f11445c ? this.f11446d.a() : this.f11443a.size();
    }

    public q c(q qVar) {
        a(qVar);
        return this.f11446d;
    }

    public q d(q qVar) {
        q qVar2 = this.f11446d;
        this.f11446d = qVar;
        this.f11443a = null;
        this.f11445c = true;
        return qVar2;
    }
}
