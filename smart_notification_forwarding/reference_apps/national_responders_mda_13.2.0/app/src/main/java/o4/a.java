package o4;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<T> f12491a;

    /* renamed from: b, reason: collision with root package name */
    private final T f12492b;

    public T a() {
        return this.f12492b;
    }

    public Class<T> b() {
        return this.f12491a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f12491a, this.f12492b);
    }
}
