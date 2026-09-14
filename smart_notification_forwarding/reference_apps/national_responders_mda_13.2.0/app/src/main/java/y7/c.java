package y7;

/* loaded from: classes.dex */
public abstract class c<T> {
    public final c8.a a(e8.c<? super T> cVar) {
        return b(cVar, g8.a.f9912c, g8.a.f9910a, g8.a.a());
    }

    public final c8.a b(e8.c<? super T> cVar, e8.c<? super Throwable> cVar2, e8.a aVar, e8.c<? super c8.a> cVar3) {
        g8.b.a(cVar, "onNext is null");
        g8.b.a(cVar2, "onError is null");
        g8.b.a(aVar, "onComplete is null");
        g8.b.a(cVar3, "onSubscribe is null");
        h8.a aVar2 = new h8.a(cVar, cVar2, aVar, cVar3);
        c(aVar2);
        return aVar2;
    }

    public final void c(d<? super T> dVar) {
        g8.b.a(dVar, "observer is null");
        try {
            d<? super T> e10 = j8.a.e(this, dVar);
            g8.b.a(e10, "Plugin returned null Observer");
            d(e10);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th) {
            d8.b.b(th);
            j8.a.c(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void d(d<? super T> dVar);
}
