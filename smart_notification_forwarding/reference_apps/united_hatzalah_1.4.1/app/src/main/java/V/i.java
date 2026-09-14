package V;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2394a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2395b;

    public i(List list, int i, Throwable th) {
        I.d.c(list, "initCallbacks cannot be null");
        this.f2394a = new ArrayList(list);
        this.f2395b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f2394a;
        int size = arrayList.size();
        int i = 0;
        if (this.f2395b != 1) {
            while (i < size) {
                ((h) arrayList.get(i)).a();
                i++;
            }
        } else {
            while (i < size) {
                ((h) arrayList.get(i)).b();
                i++;
            }
        }
    }
}
