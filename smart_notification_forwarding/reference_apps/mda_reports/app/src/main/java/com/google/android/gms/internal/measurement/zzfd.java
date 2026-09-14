package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhy zzb = zzhy.zza();
    private int zzc = -1;

    /* loaded from: classes.dex */
    public static class zza<T extends zzfd<T, ?>> extends zzdp<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
        protected MessageType a;
        protected boolean b = false;
        private final MessageType zzc;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.a = (MessageType) messagetype.a(zze.zzd, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgz.zza().zza((zzgz) messagetype).zzb(messagetype, messagetype2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzdn
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzeg zzegVar, zzeq zzeqVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            try {
                zzgz.zza().zza((zzgz) this.a).zza(this.a, zzel.zza(zzegVar), zzeqVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzeq zzeqVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            try {
                zzgz.zza().zza((zzgz) this.a).zza(this.a, bArr, 0, i2 + 0, new zzdt(zzeqVar));
                return this;
            } catch (zzfo e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzfo.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a() {
            MessageType messagetype = (MessageType) this.a.a(zze.zzd, null, null);
            zza(messagetype, this.a);
            this.a = messagetype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzdn
        public /* synthetic */ Object clone() {
            zzb zzbVar = (zzb) this.zzc.a(zze.zze, null, null);
            zzbVar.a((zzb) zzt());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2) {
            return zzb(bArr, 0, i2, zzeq.zza());
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2, zzeq zzeqVar) {
            return zzb(bArr, 0, i2, zzeqVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final BuilderType a(MessageType messagetype) {
            if (this.b) {
                a();
                this.b = false;
            }
            zza(this.a, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final boolean zzbl() {
            return zzfd.a(this.a, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final /* synthetic */ zzgo zzbt() {
            return this.zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        /* renamed from: zzp */
        public final /* synthetic */ zzdn clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public MessageType zzt() {
            if (this.b) {
                return this.a;
            }
            MessageType messagetype = this.a;
            zzgz.zza().zza((zzgz) messagetype).zzc(messagetype);
            this.b = true;
            return this.a;
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public final MessageType zzu() {
            MessageType messagetype = (MessageType) zzt();
            if (messagetype.zzbl()) {
                return messagetype;
            }
            throw new zzhw(messagetype);
        }
    }

    /* loaded from: classes.dex */
    static final class zzc implements zzey<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgn zza(zzgn zzgnVar, zzgo zzgoVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgt zza(zzgt zzgtVar, zzgt zzgtVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzim zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzip zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgq {
        protected zzew<zzc> zzc = zzew.zza();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzew<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzew) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* loaded from: classes.dex */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzl = {zza, zzb, zzc, zzd, zze, zzf, zzg};
        public static final int zzh = 1;
        public static final int zzi = 2;
        private static final /* synthetic */ int[] zzm = {zzh, zzi};
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzn = {zzj, zzk};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* loaded from: classes.dex */
    public static class zzf<ContainingType extends zzgo, Type> extends zzer<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzfd<?, ?>> T a(Class<T> cls) {
        zzfd<?, ?> zzfdVar = zzd.get(cls);
        if (zzfdVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfdVar = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfdVar == null) {
            zzfdVar = (T) ((zzfd) zzib.a(cls)).a(zze.zzf, (Object) null, (Object) null);
            if (zzfdVar == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzfdVar);
        }
        return (T) zzfdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzfl<E> a(zzfl<E> zzflVar) {
        int size = zzflVar.size();
        return zzflVar.zza(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfm a(zzfm zzfmVar) {
        int size = zzfmVar.size();
        return zzfmVar.zza(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzgo zzgoVar, String str, Object[] objArr) {
        return new zzhb(zzgoVar, str, objArr);
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
    public static <T extends zzfd<?, ?>> void a(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static final <T extends zzfd<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zze.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzgz.zza().zza((zzgz) t).zzd(t);
        if (z) {
            t.a(zze.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfj c() {
        return zzfg.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfm d() {
        return zzgc.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzfl<E> e() {
        return zzhc.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    final int a() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzdl
    final void a(int i) {
        this.zzc = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType b() {
        return (BuilderType) a(zze.zze, (Object) null, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzfd) a(zze.zzf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzgz.zza().zza((zzgz) this).zza(this, (zzfd<MessageType, BuilderType>) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        this.zza = zzgz.zza().zza((zzgz) this).zza(this);
        return this.zza;
    }

    public String toString() {
        return zzgp.a(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final void zza(zzen zzenVar) {
        zzgz.zza().zza((zzgz) this).zza((zzhd) this, (zzis) zzep.zza(zzenVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final boolean zzbl() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbm() {
        BuilderType buildertype = (BuilderType) a(zze.zze, (Object) null, (Object) null);
        buildertype.a(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final int zzbn() {
        if (this.zzc == -1) {
            this.zzc = zzgz.zza().zza((zzgz) this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ zzgn zzbr() {
        zzb zzbVar = (zzb) a(zze.zze, (Object) null, (Object) null);
        zzbVar.a((zzb) this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ zzgn zzbs() {
        return (zzb) a(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final /* synthetic */ zzgo zzbt() {
        return (zzfd) a(zze.zzf, (Object) null, (Object) null);
    }
}
