package G;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f778a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f779b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f780c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f781d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f782e;

    public /* synthetic */ e(String str, Context context, Object obj, int i, int i3) {
        this.f778a = i3;
        this.f779b = str;
        this.f780c = context;
        this.f782e = obj;
        this.f781d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f778a) {
            case 0:
                Object[] objArr = {(d) this.f782e};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                return h.b(this.f779b, this.f780c, Collections.unmodifiableList(arrayList), this.f781d);
            default:
                try {
                    return h.b(this.f779b, this.f780c, (ArrayList) this.f782e, this.f781d);
                } catch (Throwable unused) {
                    return new g(-3);
                }
        }
    }
}
