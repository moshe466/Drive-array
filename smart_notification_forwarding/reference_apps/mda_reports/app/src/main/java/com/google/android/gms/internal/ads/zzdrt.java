package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import com.google.android.gms.internal.ads.zzdrt.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zzdrt<MessageType extends zzdrt<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdqa<MessageType, BuilderType> {
    private static Map<Object, zzdrt<?, ?>> zzhmm = new ConcurrentHashMap();
    protected zzdur zzhmk = zzdur.zzbcf();
    private int zzhml = -1;

    /* loaded from: classes.dex */
    public static class zza<T extends zzdrt<T, ?>> extends zzdqb<T> {
        private final T zzhmo;

        public zza(T t) {
            this.zzhmo = t;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zzdrt<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdpz<MessageType, BuilderType> {
        protected MessageType a;
        protected boolean b = false;
        private final MessageType zzhmo;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzhmo = messagetype;
            this.a = (MessageType) messagetype.a(zze.zzhmv, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzdtp.zzbbm().zzba(messagetype).zzf(messagetype, messagetype2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.ads.zzdpz
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzdqw zzdqwVar, zzdrg zzdrgVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            try {
                zzdtp.zzbbm().zzba(this.a).zza(this.a, zzdqz.zza(zzdqwVar), zzdrgVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzdrg zzdrgVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            try {
                zzdtp.zzbbm().zzba(this.a).zza(this.a, bArr, 0, i2 + 0, new zzdqf(zzdrgVar));
                return this;
            } catch (zzdse e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzdse.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a() {
            MessageType messagetype = (MessageType) this.a.a(zze.zzhmv, null, null);
            zza(messagetype, this.a);
            this.a = messagetype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzdpz
        public /* synthetic */ Object clone() {
            zzb zzbVar = (zzb) this.zzhmo.a(zze.zzhmw, null, null);
            zzbVar.a((zzdrt) zzbae());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdtg
        public final boolean isInitialized() {
            return zzdrt.a(this.a, false);
        }

        @Override // com.google.android.gms.internal.ads.zzdpz
        public final /* synthetic */ zzdpz zza(byte[] bArr, int i, int i2, zzdrg zzdrgVar) {
            return zzb(bArr, 0, i2, zzdrgVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdpz
        /* renamed from: zzaxj */
        public final /* synthetic */ zzdpz clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzdtg
        public final /* synthetic */ zzdte zzazz() {
            return this.zzhmo;
        }

        @Override // com.google.android.gms.internal.ads.zzdpz
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType a(MessageType messagetype) {
            if (this.b) {
                a();
                this.b = false;
            }
            zza(this.a, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.ads.zzdtd
        /* renamed from: zzbac, reason: merged with bridge method [inline-methods] */
        public MessageType zzbae() {
            if (this.b) {
                return this.a;
            }
            MessageType messagetype = this.a;
            zzdtp.zzbbm().zzba(messagetype).zzan(messagetype);
            this.b = true;
            return this.a;
        }

        @Override // com.google.android.gms.internal.ads.zzdtd
        /* renamed from: zzbad, reason: merged with bridge method [inline-methods] */
        public final MessageType zzbaf() {
            MessageType messagetype = (MessageType) zzbae();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzdup(messagetype);
        }
    }

    /* loaded from: classes.dex */
    static final class zzc implements zzdro<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final zzdtd zza(zzdtd zzdtdVar, zzdte zzdteVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final zzdtj zza(zzdtj zzdtjVar, zzdtj zzdtjVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final int zzae() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final zzdvf zzazo() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final zzdvm zzazp() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final boolean zzazq() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzdro
        public final boolean zzazr() {
            throw new NoSuchMethodError();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzdrt<MessageType, BuilderType> implements zzdtg {
        protected zzdrm<zzc> zzhmr = zzdrm.zzazm();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzdrm<zzc> e() {
            if (this.zzhmr.isImmutable()) {
                this.zzhmr = (zzdrm) this.zzhmr.clone();
            }
            return this.zzhmr;
        }
    }

    /* loaded from: classes.dex */
    public enum zze {
        public static final int zzhms = 1;
        public static final int zzhmt = 2;
        public static final int zzhmu = 3;
        public static final int zzhmv = 4;
        public static final int zzhmw = 5;
        public static final int zzhmx = 6;
        public static final int zzhmy = 7;
        private static final /* synthetic */ int[] zzhmz = {zzhms, zzhmt, zzhmu, zzhmv, zzhmw, zzhmx, zzhmy};
        public static final int zzhna = 1;
        public static final int zzhnb = 2;
        private static final /* synthetic */ int[] zzhnc = {zzhna, zzhnb};
        public static final int zzhnd = 1;
        public static final int zzhne = 2;
        private static final /* synthetic */ int[] zzhnf = {zzhnd, zzhne};

        public static int[] zzbah() {
            return (int[]) zzhmz.clone();
        }
    }

    /* loaded from: classes.dex */
    public static class zzf<ContainingType extends zzdte, Type> extends zzdrh<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdrt<T, ?>> T a(T t, zzdqk zzdqkVar) {
        return (T) zza(zza(zzb(t, zzdqkVar, zzdrg.zzazh())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdrt<T, ?>> T a(T t, zzdqk zzdqkVar, zzdrg zzdrgVar) {
        return (T) zza(zzb(t, zzdqkVar, zzdrgVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdrt<T, ?>> T a(T t, byte[] bArr) {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzdrg.zzazh()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdrt<T, ?>> T a(T t, byte[] bArr, zzdrg zzdrgVar) {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzdrgVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzdrt<?, ?>> T a(Class<T> cls) {
        zzdrt<?, ?> zzdrtVar = zzhmm.get(cls);
        if (zzdrtVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzdrtVar = zzhmm.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzdrtVar == null) {
            zzdrtVar = (T) ((zzdrt) zzduy.a(cls)).a(zze.zzhmx, (Object) null, (Object) null);
            if (zzdrtVar == null) {
                throw new IllegalStateException();
            }
            zzhmm.put(cls, zzdrtVar);
        }
        return (T) zzdrtVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzdrz a(zzdrz zzdrzVar) {
        int size = zzdrzVar.size();
        return zzdrzVar.zzfd(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzdsb<E> a(zzdsb<E> zzdsbVar) {
        int size = zzdsbVar.size();
        return zzdsbVar.zzfd(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzdte zzdteVar, String str, Object[] objArr) {
        return new zzdtr(zzdteVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
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
    public static <T extends zzdrt<?, ?>> void a(Class<T> cls, T t) {
        zzhmm.put(cls, t);
    }

    protected static final <T extends zzdrt<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zze.zzhms, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaz = zzdtp.zzbbm().zzba(t).zzaz(t);
        if (z) {
            t.a(zze.zzhmt, zzaz ? t : null, null);
        }
        return zzaz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzdrz c() {
        return zzdrw.zzbai();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzdsb<E> d() {
        return zzdts.zzbbp();
    }

    private static <T extends zzdrt<T, ?>> T zza(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzdse(new zzdup(t).getMessage()).zzl(t);
    }

    private static <T extends zzdrt<T, ?>> T zza(T t, zzdqw zzdqwVar, zzdrg zzdrgVar) {
        T t2 = (T) t.a(zze.zzhmv, null, null);
        try {
            zzdua zzba = zzdtp.zzbbm().zzba(t2);
            zzba.zza(t2, zzdqz.zza(zzdqwVar), zzdrgVar);
            zzba.zzan(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzdse) {
                throw ((zzdse) e.getCause());
            }
            throw new zzdse(e.getMessage()).zzl(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzdse) {
                throw ((zzdse) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzdrt<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzdrg zzdrgVar) {
        T t2 = (T) t.a(zze.zzhmv, null, null);
        try {
            zzdua zzba = zzdtp.zzbbm().zzba(t2);
            zzba.zza(t2, bArr, 0, i2, new zzdqf(zzdrgVar));
            zzba.zzan(t2);
            if (t2.zzhhk == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzdse) {
                throw ((zzdse) e.getCause());
            }
            throw new zzdse(e.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzdse.a().zzl(t2);
        }
    }

    private static <T extends zzdrt<T, ?>> T zzb(T t, zzdqk zzdqkVar, zzdrg zzdrgVar) {
        try {
            zzdqw zzaxv = zzdqkVar.zzaxv();
            T t2 = (T) zza(t, zzaxv, zzdrgVar);
            try {
                zzaxv.zzfh(0);
                return t2;
            } catch (zzdse e) {
                throw e.zzl(t2);
            }
        } catch (zzdse e2) {
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqa
    final int a() {
        return this.zzhml;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzdqa
    final void a(int i) {
        this.zzhml = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzdrt<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType b() {
        return (BuilderType) a(zze.zzhmw, (Object) null, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzdrt) a(zze.zzhmx, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzdtp.zzbbm().zzba(this).equals(this, (zzdrt) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzhhk;
        if (i != 0) {
            return i;
        }
        this.zzhhk = zzdtp.zzbbm().zzba(this).hashCode(this);
        return this.zzhhk;
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    public final boolean isInitialized() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return zzdtf.a(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final int zzazu() {
        if (this.zzhml == -1) {
            this.zzhml = zzdtp.zzbbm().zzba(this).zzax(this);
        }
        return this.zzhml;
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final /* synthetic */ zzdtd zzazx() {
        zzb zzbVar = (zzb) a(zze.zzhmw, (Object) null, (Object) null);
        zzbVar.a(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final /* synthetic */ zzdtd zzazy() {
        return (zzb) a(zze.zzhmw, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    public final /* synthetic */ zzdte zzazz() {
        return (zzdrt) a(zze.zzhmx, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final void zzb(zzdrb zzdrbVar) {
        zzdtp.zzbbm().zzba(this).zza(this, zzdrf.zza(zzdrbVar));
    }
}
