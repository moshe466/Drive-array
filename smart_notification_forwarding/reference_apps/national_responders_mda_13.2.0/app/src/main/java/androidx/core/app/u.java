package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class u implements Iterable<Intent> {

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<Intent> f2305f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private final Context f2306g;

    /* loaded from: classes.dex */
    public interface a {
        Intent D();
    }

    private u(Context context) {
        this.f2306g = context;
    }

    public static u j(Context context) {
        return new u(context);
    }

    public u c(Intent intent) {
        this.f2305f.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u f(Activity activity) {
        Intent D = activity instanceof a ? ((a) activity).D() : null;
        if (D == null) {
            D = i.a(activity);
        }
        if (D != null) {
            ComponentName component = D.getComponent();
            if (component == null) {
                component = D.resolveActivity(this.f2306g.getPackageManager());
            }
            g(component);
            c(D);
        }
        return this;
    }

    public u g(ComponentName componentName) {
        int size = this.f2305f.size();
        try {
            Context context = this.f2306g;
            while (true) {
                Intent b10 = i.b(context, componentName);
                if (b10 == null) {
                    return this;
                }
                this.f2305f.add(size, b10);
                context = this.f2306g;
                componentName = b10.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2305f.iterator();
    }

    public void l() {
        s(null);
    }

    public void s(Bundle bundle) {
        if (this.f2305f.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f2305f.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.h(this.f2306g, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f2306g.startActivity(intent);
    }
}
