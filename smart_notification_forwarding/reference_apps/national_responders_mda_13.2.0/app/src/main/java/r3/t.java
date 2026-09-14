package r3;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final Map.Entry f13769f;

    /* renamed from: g, reason: collision with root package name */
    private final o4.a f13770g;

    private t(Map.Entry entry, o4.a aVar) {
        this.f13769f = entry;
        this.f13770g = aVar;
    }

    public static Runnable a(Map.Entry entry, o4.a aVar) {
        return new t(entry, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((o4.b) this.f13769f.getKey()).a(this.f13770g);
    }
}
