package io.flutter.plugins.sharedpreferences;

import F2.l;
import L2.i;
import P2.C0161k0;
import P2.E;
import P2.G;
import P2.O;
import R.C0179d;
import R.InterfaceC0177b;
import R.InterfaceC0183h;
import R.P;
import R.U;
import R.V;
import T.c;
import W2.d;
import android.content.Context;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.s;

/* loaded from: classes.dex */
public final class SharedPreferencesPluginKt {
    static final /* synthetic */ i[] $$delegatedProperties;
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String JSON_LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!";
    public static final String LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    public static final String TAG = "SharedPreferencesPlugin";
    private static final H2.a sharedPreferencesDataStore$delegate;

    static {
        n nVar = new n(SharedPreferencesPluginKt.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        s.f5313a.getClass();
        $$delegatedProperties = new i[]{nVar};
        d dVar = O.f1623b;
        C0161k0 c0161k0 = new C0161k0();
        dVar.getClass();
        sharedPreferencesDataStore$delegate = new T.d(SHARED_PREFERENCES_NAME, null, T.a.f2247a, G.b(T.b.F(dVar, c0161k0)));
    }

    public static final InterfaceC0183h getSharedPreferencesDataStore(Context context) {
        U.d dVar;
        j.e(context, "<this>");
        H2.a aVar = sharedPreferencesDataStore$delegate;
        i property = $$delegatedProperties[0];
        T.d dVar2 = (T.d) aVar;
        dVar2.getClass();
        j.e(property, "property");
        U.d dVar3 = dVar2.f2264f;
        if (dVar3 == null) {
            synchronized (dVar2.f2263e) {
                try {
                    if (dVar2.f2264f == null) {
                        Context applicationContext = context.getApplicationContext();
                        InterfaceC0177b interfaceC0177b = dVar2.f2260b;
                        l lVar = dVar2.f2261c;
                        j.d(applicationContext, "applicationContext");
                        List migrations = (List) lVar.invoke(applicationContext);
                        E e4 = dVar2.f2262d;
                        c cVar = new c(0, applicationContext, dVar2);
                        j.e(migrations, "migrations");
                        V v2 = new V(new U(cVar));
                        if (interfaceC0177b == null) {
                            interfaceC0177b = new A.n(9);
                        }
                        dVar2.f2264f = new U.d(new U.d(new P(v2, T.b.B(new C0179d(migrations, null)), interfaceC0177b, e4)));
                    }
                    dVar = dVar2.f2264f;
                    j.b(dVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return dVar;
        }
        return dVar3;
    }

    public static final boolean preferencesFilter(String key, Object obj, Set<String> set) {
        j.e(key, "key");
        if (set == null) {
            if (!(obj instanceof Boolean) && !(obj instanceof Long) && !(obj instanceof String) && !(obj instanceof Double)) {
                return false;
            }
            return true;
        }
        return set.contains(key);
    }

    public static final Object transformPref(Object obj, SharedPreferencesListEncoder listEncoder) {
        j.e(listEncoder, "listEncoder");
        if (obj instanceof String) {
            String str = (String) obj;
            if (N2.n.M(str, LIST_PREFIX)) {
                if (N2.n.M(str, JSON_LIST_PREFIX)) {
                    return obj;
                }
                String substring = str.substring(40);
                j.d(substring, "substring(...)");
                List<String> decode = listEncoder.decode(substring);
                j.b(decode);
                return decode;
            }
            if (N2.n.M(str, DOUBLE_PREFIX)) {
                String substring2 = str.substring(40);
                j.d(substring2, "substring(...)");
                return Double.valueOf(Double.parseDouble(substring2));
            }
            return obj;
        }
        return obj;
    }
}
