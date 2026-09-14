package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2262a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Field f2263b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f2264c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle b(k.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat e10 = aVar.e();
        bundle.putInt("icon", e10 != null ? e10.j() : 0);
        bundle.putCharSequence("title", aVar.i());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", e(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.h());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    public static Bundle c(Notification notification) {
        synchronized (f2262a) {
            if (f2264c) {
                return null;
            }
            try {
                if (f2263b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        f2264c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2263b = declaredField;
                }
                Bundle bundle = (Bundle) f2263b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2263b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                f2264c = true;
                return null;
            }
        }
    }

    private static Bundle d(s sVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] e(s[] sVarArr) {
        if (sVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[sVarArr.length];
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            bundleArr[i10] = d(sVarArr[i10]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, k.a aVar) {
        IconCompat e10 = aVar.e();
        builder.addAction(e10 != null ? e10.j() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
