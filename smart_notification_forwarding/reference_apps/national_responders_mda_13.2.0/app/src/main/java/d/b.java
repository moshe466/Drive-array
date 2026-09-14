package d;

import android.content.Context;
import android.content.Intent;
import d.a;
import d9.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l8.n;
import l8.t;
import m8.k0;
import m8.l0;
import m8.y;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class b extends d.a<String[], Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8621a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            k.e(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            k.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    @Override // d.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        return f8621a.a(strArr);
    }

    @Override // d.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0139a<Map<String, Boolean>> b(Context context, String[] strArr) {
        int d10;
        int a10;
        Map h10;
        k.e(context, "context");
        k.e(strArr, "input");
        boolean z10 = true;
        if (strArr.length == 0) {
            h10 = l0.h();
            return new a.C0139a<>(h10);
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (!(androidx.core.content.a.a(context, strArr[i10]) == 0)) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (!z10) {
            return null;
        }
        d10 = k0.d(strArr.length);
        a10 = f.a(d10, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
        for (String str : strArr) {
            n a11 = t.a(str, Boolean.TRUE);
            linkedHashMap.put(a11.c(), a11.d());
        }
        return new a.C0139a<>(linkedHashMap);
    }

    @Override // d.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int i10, Intent intent) {
        Map<String, Boolean> h10;
        List n10;
        List u02;
        Map<String, Boolean> p10;
        Map<String, Boolean> h11;
        Map<String, Boolean> h12;
        if (i10 != -1) {
            h12 = l0.h();
            return h12;
        }
        if (intent == null) {
            h11 = l0.h();
            return h11;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            h10 = l0.h();
            return h10;
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i11 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i11 == 0));
        }
        n10 = m8.k.n(stringArrayExtra);
        u02 = y.u0(n10, arrayList);
        p10 = l0.p(u02);
        return p10;
    }
}
