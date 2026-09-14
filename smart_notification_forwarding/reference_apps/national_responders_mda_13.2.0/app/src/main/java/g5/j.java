package g5;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import y8.k;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9852a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f9853b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final boolean a(Context context, String str) {
            k.e(context, "context");
            k.e(str, "packageName");
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MAIN");
            intentFilter.addCategory("android.intent.category.HOME");
            ArrayList arrayList = new ArrayList();
            arrayList.add(intentFilter);
            ArrayList arrayList2 = new ArrayList();
            context.getPackageManager().getPreferredActivities(arrayList, arrayList2, null);
            if (arrayList2.isEmpty()) {
                return false;
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (k.a(str, ((ComponentName) it.next()).getPackageName())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean b(Context context) {
            k.e(context, "<this>");
            if (j.f9853b != null) {
                Boolean bool = j.f9853b;
                Objects.requireNonNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
                return bool.booleanValue();
            }
            j.f9853b = Boolean.valueOf(a(context, "com.sec.android.app.launcher"));
            Boolean bool2 = j.f9853b;
            Objects.requireNonNull(bool2, "null cannot be cast to non-null type kotlin.Boolean");
            return bool2.booleanValue();
        }
    }
}
