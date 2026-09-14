package io.flutter.plugins.sharedpreferences;

import F2.p;
import P2.E;
import S2.d;
import S2.e;
import S2.z;
import U.f;
import a.AbstractC0228a;
import android.content.Context;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1", f = "SharedPreferencesPlugin.kt", l = {201}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class SharedPreferencesPlugin$getString$1 extends AbstractC0793i implements p {
    final /* synthetic */ String $key;
    final /* synthetic */ r $value;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getString$1(String str, SharedPreferencesPlugin sharedPreferencesPlugin, r rVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.$key = str;
        this.this$0 = sharedPreferencesPlugin;
        this.$value = rVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SharedPreferencesPlugin$getString$1(this.$key, this.this$0, this.$value, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SharedPreferencesPlugin$getString$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Context context;
        r rVar;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                rVar = (r) this.L$2;
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            final f K3 = T.b.K(this.$key);
            context = this.this$0.context;
            if (context != null) {
                final d data = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context).getData();
                d dVar = new d() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1

                    /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass2<T> implements e {
                        final /* synthetic */ f $preferencesKey$inlined;
                        final /* synthetic */ e $this_unsafeFlow;

                        @InterfaceC0789e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit", v = 1)
                        /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                            this.$preferencesKey$inlined = fVar;
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
                                boolean r0 = r6 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1
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
                                io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1$2$1 r5 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
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
                                U.f r2 = r4.$preferencesKey$inlined
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
                            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getString$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w2.d):java.lang.Object");
                        }
                    }

                    @Override // S2.d
                    public Object collect(e eVar, InterfaceC0763d interfaceC0763d) {
                        Object collect = d.this.collect(new AnonymousClass2(eVar, K3), interfaceC0763d);
                        if (collect == EnumC0779a.f6740a) {
                            return collect;
                        }
                        return C0684i.f6340a;
                    }
                };
                r rVar2 = this.$value;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = rVar2;
                this.label = 1;
                Object f4 = z.f(dVar, this);
                if (f4 == enumC0779a) {
                    return enumC0779a;
                }
                rVar = rVar2;
                obj = f4;
            } else {
                j.i("context");
                throw null;
            }
        }
        rVar.f5312a = obj;
        return C0684i.f6340a;
    }
}
