package F1;

/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f745b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f746c;

    public /* synthetic */ n(Object obj, int i) {
        this.f745b = i;
        this.f746c = obj;
    }

    @Override // F1.l
    public final void a() {
        switch (this.f745b) {
            case 0:
                synchronized (((q) this.f746c).f757f) {
                    try {
                        if (((q) this.f746c).f761k.get() > 0 && ((q) this.f746c).f761k.decrementAndGet() > 0) {
                            ((q) this.f746c).f753b.y("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        q qVar = (q) this.f746c;
                        if (qVar.f763m != null) {
                            qVar.f753b.y("Unbind from service.", new Object[0]);
                            q qVar2 = (q) this.f746c;
                            qVar2.f752a.unbindService(qVar2.f762l);
                            q qVar3 = (q) this.f746c;
                            qVar3.f758g = false;
                            qVar3.f763m = null;
                            qVar3.f762l = null;
                        }
                        ((q) this.f746c).d();
                        return;
                    } finally {
                    }
                }
            default:
                q qVar4 = (q) ((p) this.f746c).f750b;
                qVar4.f753b.y("unlinkToDeath", new Object[0]);
                qVar4.f763m.asBinder().unlinkToDeath(qVar4.f760j, 0);
                qVar4.f763m = null;
                qVar4.f758g = false;
                return;
        }
    }
}
