package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.l7.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class l7<MessageType extends l7<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends u5<MessageType, BuilderType> {
    private static Map<Object, l7<?, ?>> zzd = new ConcurrentHashMap();
    protected ga zzb = ga.a();
    private int zzc = -1;

    /* loaded from: classes.dex */
    protected static class a<T extends l7<T, ?>> extends y5<T> {
        public a(T t10) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<MessageType extends l7<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends w5<MessageType, BuilderType> {

        /* renamed from: f, reason: collision with root package name */
        private final MessageType f5445f;

        /* renamed from: g, reason: collision with root package name */
        protected MessageType f5446g;

        /* renamed from: h, reason: collision with root package name */
        protected boolean f5447h = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(MessageType messagetype) {
            this.f5445f = messagetype;
            this.f5446g = (MessageType) messagetype.q(e.f5451d, null, null);
        }

        private static void p(MessageType messagetype, MessageType messagetype2) {
            l9.a().c(messagetype).h(messagetype, messagetype2);
        }

        private final BuilderType q(byte[] bArr, int i10, int i11, y6 y6Var) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            try {
                l9.a().c(this.f5446g).g(this.f5446g, bArr, 0, i11, new c6(y6Var));
                return this;
            } catch (x7 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
            } catch (IndexOutOfBoundsException unused) {
                throw x7.a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.w5
        public /* synthetic */ Object clone() {
            b bVar = (b) this.f5445f.q(e.f5452e, null, null);
            bVar.l((l7) j());
            return bVar;
        }

        @Override // com.google.android.gms.internal.measurement.a9
        public final /* synthetic */ y8 k() {
            return this.f5445f;
        }

        @Override // com.google.android.gms.internal.measurement.w5
        public final /* synthetic */ w5 m(byte[] bArr, int i10, int i11) {
            return q(bArr, 0, i11, y6.a());
        }

        @Override // com.google.android.gms.internal.measurement.w5
        public final /* synthetic */ w5 n(byte[] bArr, int i10, int i11, y6 y6Var) {
            return q(bArr, 0, i11, y6Var);
        }

        @Override // com.google.android.gms.internal.measurement.w5
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public final BuilderType l(MessageType messagetype) {
            if (this.f5447h) {
                r();
                this.f5447h = false;
            }
            p(this.f5446g, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void r() {
            MessageType messagetype = (MessageType) this.f5446g.q(e.f5451d, null, null);
            p(messagetype, this.f5446g);
            this.f5446g = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.x8
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public MessageType j() {
            if (this.f5447h) {
                return this.f5446g;
            }
            MessageType messagetype = this.f5446g;
            l9.a().c(messagetype).d(messagetype);
            this.f5447h = true;
            return this.f5446g;
        }

        @Override // com.google.android.gms.internal.measurement.x8
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public final MessageType g() {
            MessageType messagetype = (MessageType) j();
            if (messagetype.i()) {
                return messagetype;
            }
            throw new ea(messagetype);
        }
    }

    /* loaded from: classes.dex */
    static final class c implements g7<c> {
        @Override // com.google.android.gms.internal.measurement.g7
        public final va a() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.g7
        public final cb b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.g7
        public final boolean c() {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.g7
        public final boolean d() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.g7
        public final x8 i(x8 x8Var, y8 y8Var) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.g7
        public final c9 m(c9 c9Var, c9 c9Var2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.g7
        public final int zza() {
            throw new NoSuchMethodError();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends l7<MessageType, BuilderType> implements a9 {
        protected e7<c> zzc = e7.c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final e7<c> A() {
            if (this.zzc.n()) {
                this.zzc = (e7) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* loaded from: classes.dex */
    public enum e {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5448a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5449b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5450c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5451d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f5452e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5453f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5454g = 7;

        /* renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ int[] f5455h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f5455h.clone();
        }
    }

    /* loaded from: classes.dex */
    public static class f<ContainingType extends y8, Type> extends z6<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends l7<?, ?>> T n(Class<T> cls) {
        l7<?, ?> l7Var = zzd.get(cls);
        if (l7Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                l7Var = zzd.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (l7Var == null) {
            l7Var = (T) ((l7) na.c(cls)).q(e.f5453f, null, null);
            if (l7Var == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, l7Var);
        }
        return (T) l7Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> u7<E> o(u7<E> u7Var) {
        int size = u7Var.size();
        return u7Var.b(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static v7 p(v7 v7Var) {
        int size = v7Var.size();
        return v7Var.b(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object r(y8 y8Var, String str, Object[] objArr) {
        return new m9(y8Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object s(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends l7<?, ?>> void t(Class<T> cls, T t10) {
        zzd.put(cls, t10);
    }

    protected static final <T extends l7<T, ?>> boolean u(T t10, boolean z10) {
        byte byteValue = ((Byte) t10.q(e.f5448a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b10 = l9.a().c(t10).b(t10);
        if (z10) {
            t10.q(e.f5449b, b10 ? t10 : null, null);
        }
        return b10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static s7 x() {
        return p7.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static v7 y() {
        return l8.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> u7<E> z() {
        return k9.j();
    }

    @Override // com.google.android.gms.internal.measurement.y8
    public final int b() {
        if (this.zzc == -1) {
            this.zzc = l9.a().c(this).e(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.y8
    public final /* synthetic */ x8 d() {
        b bVar = (b) q(e.f5452e, null, null);
        bVar.l(this);
        return bVar;
    }

    @Override // com.google.android.gms.internal.measurement.y8
    public final /* synthetic */ x8 e() {
        return (b) q(e.f5452e, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return l9.a().c(this).c(this, (l7) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.y8
    public final void h(v6 v6Var) {
        l9.a().c(this).f(this, x6.O(v6Var));
    }

    public int hashCode() {
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int a10 = l9.a().c(this).a(this);
        this.zza = a10;
        return a10;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final boolean i() {
        return u(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final /* synthetic */ y8 k() {
        return (l7) q(e.f5453f, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.u5
    final int l() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.u5
    final void m(int i10) {
        this.zzc = i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object q(int i10, Object obj, Object obj2);

    public String toString() {
        return z8.a(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends l7<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType v() {
        return (BuilderType) q(e.f5452e, null, null);
    }

    public final BuilderType w() {
        BuilderType buildertype = (BuilderType) q(e.f5452e, null, null);
        buildertype.l(this);
        return buildertype;
    }
}
