package io.flutter.plugins.sharedpreferences;

import N2.n;
import P2.G;
import S2.d;
import S2.e;
import S2.z;
import U.f;
import a.AbstractC0228a;
import android.content.Context;
import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import s2.C0684i;
import t2.AbstractC0707i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

/* loaded from: classes.dex */
public final class SharedPreferencesPlugin implements FlutterPlugin, SharedPreferencesAsyncApi {
    private SharedPreferencesBackend backend;
    private Context context;
    private SharedPreferencesListEncoder listEncoder;

    public SharedPreferencesPlugin() {
        this.listEncoder = new ListEncoder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dataStoreSetString(String str, String str2, InterfaceC0763d interfaceC0763d) {
        f K3 = T.b.K(str);
        Context context = this.context;
        if (context != null) {
            Object m4 = AbstractC0228a.m(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context), new SharedPreferencesPlugin$dataStoreSetString$2(K3, str2, null), interfaceC0763d);
            if (m4 == EnumC0779a.f6740a) {
                return m4;
            }
            return C0684i.f6340a;
        }
        j.i("context");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b6, code lost:
    
        if (r12 == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b8, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        if (r12 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00b6 -> B:11:0x00b9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getPrefs(java.util.List<java.lang.String> r11, w2.InterfaceC0763d r12) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.getPrefs(java.util.List, w2.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getValueByKey(final f fVar, InterfaceC0763d interfaceC0763d) {
        Context context = this.context;
        if (context != null) {
            final d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
            return z.f(new d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1

                /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass2<T> implements e {
                    final /* synthetic */ f $key$inlined;
                    final /* synthetic */ e $this_unsafeFlow;

                    @InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit", v = 1)
                    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends AbstractC0787c {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(InterfaceC0763d interfaceC0763d) {
                            super(interfaceC0763d);
                        }

                        @Override // y2.AbstractC0785a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(e eVar, f fVar) {
                        this.$this_unsafeFlow = eVar;
                        this.$key$inlined = fVar;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // S2.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r5, w2.InterfaceC0763d r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            x2.a r1 = x2.EnumC0779a.f6740a
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L37
                            if (r2 != r3) goto L2f
                            java.lang.Object r5 = r0.L$3
                            S2.e r5 = (S2.e) r5
                            java.lang.Object r5 = r0.L$1
                            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1 r5 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                            a.AbstractC0228a.C(r6)
                            goto L59
                        L2f:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L37:
                            a.AbstractC0228a.C(r6)
                            S2.e r6 = r4.$this_unsafeFlow
                            U.h r5 = (U.h) r5
                            U.f r2 = r4.$key$inlined
                            java.lang.Object r5 = r5.b(r2)
                            r2 = 0
                            r0.L$0 = r2
                            r0.L$1 = r2
                            r0.L$2 = r2
                            r0.L$3 = r2
                            r2 = 0
                            r0.I$0 = r2
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L59
                            return r1
                        L59:
                            s2.i r5 = s2.C0684i.f6340a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w2.d):java.lang.Object");
                    }
                }

                @Override // S2.d
                public Object collect(e eVar, InterfaceC0763d interfaceC0763d2) {
                    Object collect = d.this.collect(new AnonymousClass2(eVar, fVar), interfaceC0763d2);
                    if (collect == EnumC0779a.f6740a) {
                        return collect;
                    }
                    return C0684i.f6340a;
                }
            }, interfaceC0763d);
        }
        j.i("context");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readAllKeys(InterfaceC0763d interfaceC0763d) {
        Context context = this.context;
        if (context != null) {
            final d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
            return z.f(new d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1

                /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass2<T> implements e {
                    final /* synthetic */ e $this_unsafeFlow;

                    @InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit", v = 1)
                    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends AbstractC0787c {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(InterfaceC0763d interfaceC0763d) {
                            super(interfaceC0763d);
                        }

                        @Override // y2.AbstractC0785a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(e eVar) {
                        this.$this_unsafeFlow = eVar;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // S2.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r5, w2.InterfaceC0763d r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            x2.a r1 = x2.EnumC0779a.f6740a
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L37
                            if (r2 != r3) goto L2f
                            java.lang.Object r5 = r0.L$3
                            S2.e r5 = (S2.e) r5
                            java.lang.Object r5 = r0.L$1
                            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1 r5 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                            a.AbstractC0228a.C(r6)
                            goto L5b
                        L2f:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L37:
                            a.AbstractC0228a.C(r6)
                            S2.e r6 = r4.$this_unsafeFlow
                            U.h r5 = (U.h) r5
                            java.util.Map r5 = r5.a()
                            java.util.Set r5 = r5.keySet()
                            r2 = 0
                            r0.L$0 = r2
                            r0.L$1 = r2
                            r0.L$2 = r2
                            r0.L$3 = r2
                            r2 = 0
                            r0.I$0 = r2
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L5b
                            return r1
                        L5b:
                            s2.i r5 = s2.C0684i.f6340a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w2.d):java.lang.Object");
                    }
                }

                @Override // S2.d
                public Object collect(e eVar, InterfaceC0763d interfaceC0763d2) {
                    Object collect = d.this.collect(new AnonymousClass2(eVar), interfaceC0763d2);
                    if (collect == EnumC0779a.f6740a) {
                        return collect;
                    }
                    return C0684i.f6340a;
                }
            }, interfaceC0763d);
        }
        j.i("context");
        throw null;
    }

    private final void setUp(BinaryMessenger binaryMessenger, Context context) {
        this.context = context;
        try {
            SharedPreferencesAsyncApi.Companion.setUp(binaryMessenger, this, "data_store");
            this.backend = new SharedPreferencesBackend(binaryMessenger, context, this.listEncoder);
        } catch (Exception e4) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesPlugin", e4);
        }
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> list, SharedPreferencesPigeonOptions options) {
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$clear$1(this, list, null));
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> list, SharedPreferencesPigeonOptions options) {
        j.e(options, "options");
        return (Map) G.v(new SharedPreferencesPlugin$getAll$1(this, list, null));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.internal.r, java.lang.Object] */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        ?? obj = new Object();
        G.v(new SharedPreferencesPlugin$getBool$1(key, this, obj, null));
        return (Boolean) obj.f5312a;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.internal.r, java.lang.Object] */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        ?? obj = new Object();
        G.v(new SharedPreferencesPlugin$getDouble$1(key, this, obj, null));
        return (Double) obj.f5312a;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.internal.r, java.lang.Object] */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        ?? obj = new Object();
        G.v(new SharedPreferencesPlugin$getInt$1(key, this, obj, null));
        return (Long) obj.f5312a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> list, SharedPreferencesPigeonOptions options) {
        j.e(options, "options");
        return AbstractC0707i.q0(((Map) G.v(new SharedPreferencesPlugin$getKeys$prefs$1(this, list, null))).keySet());
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        j.e(key, "key");
        j.e(options, "options");
        String string = getString(key, options);
        if (string != null && !n.M(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX) && n.M(string, SharedPreferencesPluginKt.LIST_PREFIX) && (list = (List) SharedPreferencesPluginKt.transformPref(string, this.listEncoder)) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof String) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.internal.r, java.lang.Object] */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public String getString(String key, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        ?? obj = new Object();
        G.v(new SharedPreferencesPlugin$getString$1(key, this, obj, null));
        return (String) obj.f5312a;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        String string = getString(key, options);
        if (string == null) {
            return null;
        }
        if (n.M(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX)) {
            return new StringListResult(string, StringListLookupResultType.JSON_ENCODED);
        }
        if (n.M(string, SharedPreferencesPluginKt.LIST_PREFIX)) {
            return new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED);
        }
        return new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        j.d(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        j.d(applicationContext, "getApplicationContext(...)");
        setUp(binaryMessenger, applicationContext);
        new LegacySharedPreferencesPlugin().onAttachedToEngine(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        j.e(binding, "binding");
        SharedPreferencesAsyncApi.Companion companion = SharedPreferencesAsyncApi.Companion;
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        j.d(binaryMessenger, "getBinaryMessenger(...)");
        companion.setUp(binaryMessenger, null, "data_store");
        SharedPreferencesBackend sharedPreferencesBackend = this.backend;
        if (sharedPreferencesBackend != null) {
            sharedPreferencesBackend.tearDown();
        }
        this.backend = null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean z3, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$setBool$1(key, this, z3, null));
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(value, "value");
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$setDeprecatedStringList$1(this, key, e0.a.d(SharedPreferencesPluginKt.LIST_PREFIX, this.listEncoder.encode(value)), null));
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double d2, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$setDouble$1(key, this, d2, null));
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(value, "value");
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$setEncodedStringList$1(this, key, value, null));
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long j2, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$setInt$1(key, this, j2, null));
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        j.e(key, "key");
        j.e(value, "value");
        j.e(options, "options");
        G.v(new SharedPreferencesPlugin$setString$1(this, key, value, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin(SharedPreferencesListEncoder listEncoder) {
        this();
        j.e(listEncoder, "listEncoder");
        this.listEncoder = listEncoder;
    }
}
