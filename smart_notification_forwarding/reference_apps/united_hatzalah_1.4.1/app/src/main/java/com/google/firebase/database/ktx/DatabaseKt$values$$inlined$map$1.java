package com.google.firebase.database.ktx;

import S2.d;
import S2.e;
import kotlin.jvm.internal.j;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;
import y2.InterfaceC0789e;

/* loaded from: classes.dex */
public final class DatabaseKt$values$$inlined$map$1 implements d {
    final /* synthetic */ d $this_unsafeTransform$inlined;

    /* renamed from: com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2<T> implements e {
        final /* synthetic */ e $this_unsafeFlow;

        @InterfaceC0789e(c = "com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1$2", f = "Database.kt", l = {223}, m = "emit")
        /* renamed from: com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1$2$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends AbstractC0787c {
            Object L$0;
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

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        @Override // S2.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r5, w2.InterfaceC0763d r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r6
                com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1$2$1 r0 = (com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1$2$1 r0 = new com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1$2$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                x2.a r1 = x2.EnumC0779a.f6740a
                int r0 = r0.label
                if (r0 == 0) goto L31
                r5 = 1
                if (r0 != r5) goto L29
                a.AbstractC0228a.C(r6)
                s2.i r5 = s2.C0684i.f6340a
                return r5
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                a.AbstractC0228a.C(r6)
                com.google.firebase.database.DataSnapshot r5 = (com.google.firebase.database.DataSnapshot) r5
                kotlin.jvm.internal.j.h()
                r5 = 0
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w2.d):java.lang.Object");
        }

        public final Object emit$$forInline(Object obj, InterfaceC0763d interfaceC0763d) {
            new AnonymousClass1(interfaceC0763d);
            j.h();
            throw null;
        }
    }

    public DatabaseKt$values$$inlined$map$1(d dVar) {
        this.$this_unsafeTransform$inlined = dVar;
    }

    @Override // S2.d
    public Object collect(e eVar, InterfaceC0763d interfaceC0763d) {
        j.h();
        throw null;
    }

    public Object collect$$forInline(e eVar, InterfaceC0763d interfaceC0763d) {
        new AbstractC0787c(interfaceC0763d) { // from class: com.google.firebase.database.ktx.DatabaseKt$values$$inlined$map$1.1
            int label;
            /* synthetic */ Object result;

            @Override // y2.AbstractC0785a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return DatabaseKt$values$$inlined$map$1.this.collect(null, this);
            }
        };
        j.h();
        throw null;
    }
}
