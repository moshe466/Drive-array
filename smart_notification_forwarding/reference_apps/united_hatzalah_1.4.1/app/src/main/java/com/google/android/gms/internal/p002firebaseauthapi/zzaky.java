package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.firebase-auth-api.zzaky.zza;
import com.google.android.gms.internal.p002firebaseauthapi.zzaky;
import e0.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zzaky<MessageType extends zzaky<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzajf<MessageType, BuilderType> {
    private static Map<Class<?>, zzaky<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzann zzb = zzann.zzc();

    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzaky<MessageType, BuilderType> implements zzame {
        protected zzakr<zze> zzc = zzakr.zzb();

        public final zzakr<zze> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzakr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* loaded from: classes.dex */
    public static class zzc<T extends zzaky<T, ?>> extends zzajg<T> {
        public zzc(T t3) {
        }
    }

    /* loaded from: classes.dex */
    public static class zzd<ContainingType extends zzamc, Type> extends zzakl<ContainingType, Type> {
    }

    /* loaded from: classes.dex */
    public static final class zze implements zzakt<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzanw zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzaod zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzamf zza(zzamf zzamfVar, zzamc zzamcVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzaml zza(zzaml zzamlVar, zzaml zzamlVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* loaded from: classes.dex */
    public enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    private final int zzb(zzamv<?> zzamvVar) {
        if (zzamvVar == null) {
            return zzamr.zza().zza((zzamr) this).zza(this);
        }
        return zzamvVar.zza(this);
    }

    public static <E> zzalc<E> zzp() {
        return zzamq.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzamr.zza().zza((zzamr) this).zzb(this, (zzaky) obj);
    }

    public int hashCode() {
        if (zzu()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzamh.zza(this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
    public final /* synthetic */ zzamc zzg() {
        return (zzaky) zza(zzf.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajf
    public final int zzi() {
        return this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
    public final boolean zzj() {
        return zzb(this, true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final int zzl() {
        return zza((zzamv) null);
    }

    public final <MessageType2 extends zzaky<MessageType2, BuilderType2>, BuilderType2 extends zza<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (BuilderType2) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    public final MessageType zzo() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final /* synthetic */ zzamf zzq() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final /* synthetic */ zzamf zzr() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    public final void zzs() {
        zzamr.zza().zza((zzamr) this).zzd(this);
        zzt();
    }

    public final void zzt() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean zzu() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    private final int zza() {
        return zzamr.zza().zza((zzamr) this).zzb(this);
    }

    private static <T extends zzaky<T, ?>> T zzb(T t3, zzajp zzajpVar, zzakk zzakkVar) {
        zzakb zzc2 = zzajpVar.zzc();
        T t4 = (T) zza(t3, zzc2, zzakkVar);
        zzc2.zzb(0);
        return t4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajf
    public final int zza(zzamv zzamvVar) {
        if (zzu()) {
            int zzb2 = zzb((zzamv<?>) zzamvVar);
            if (zzb2 >= 0) {
                return zzb2;
            }
            throw new IllegalStateException(a.c(zzb2, "serialized size must be non-negative, was "));
        }
        if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        }
        int zzb3 = zzb((zzamv<?>) zzamvVar);
        zzb(zzb3);
        return zzb3;
    }

    /* loaded from: classes.dex */
    public static abstract class zza<MessageType extends zzaky<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzaje<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (!messagetype.zzu()) {
                this.zza = (MessageType) messagetype.zzo();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaje
        public /* synthetic */ Object clone() {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzf();
            return zzaVar;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzu()) {
                zzi();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaje
        /* renamed from: zzb */
        public final /* synthetic */ zzaje clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final MessageType zze() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzj()) {
                return messagetype;
            }
            throw new zzanl(messagetype);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            if (!this.zza.zzu()) {
                return this.zza;
            }
            this.zza.zzs();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
        public final /* synthetic */ zzamc zzg() {
            return this.zzb;
        }

        public final void zzh() {
            if (!this.zza.zzu()) {
                zzi();
            }
        }

        public void zzi() {
            MessageType messagetype = (MessageType) this.zzb.zzo();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
        public final boolean zzj() {
            return zzaky.zzb(this.zza, false);
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzamr.zza().zza((zzamr) messagetype).zza(messagetype, messagetype2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajf
    public final void zzb(int i) {
        if (i >= 0) {
            this.zzd = (i & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException(a.c(i, "serialized size must be non-negative, was "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zzaky<T, ?>> boolean zzb(T t3, boolean z3) {
        byte byteValue = ((Byte) t3.zza(zzf.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zze2 = zzamr.zza().zza((zzamr) t3).zze(t3);
        if (z3) {
            t3.zza(zzf.zzb, zze2 ? t3 : null, null);
        }
        return zze2;
    }

    private static <T extends zzaky<T, ?>> T zza(T t3) {
        if (t3 == null || zzb(t3, true)) {
            return t3;
        }
        zzalf zza2 = new zzanl(t3).zza();
        zza2.getClass();
        throw zza2;
    }

    public static <T extends zzaky<?, ?>> T zza(Class<T> cls) {
        T t3 = (T) zzc.get(cls);
        if (t3 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t3 = (T) zzc.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (t3 != null) {
            return t3;
        }
        T t4 = (T) ((zzaky) zzanp.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
        if (t4 != null) {
            zzc.put(cls, t4);
            return t4;
        }
        throw new IllegalStateException();
    }

    public static <T extends zzaky<T, ?>> T zza(T t3, zzajp zzajpVar, zzakk zzakkVar) {
        return (T) zza(zzb(t3, zzajpVar, zzakkVar));
    }

    public static <T extends zzaky<T, ?>> T zza(T t3, InputStream inputStream, zzakk zzakkVar) {
        zzakb zzakdVar;
        if (inputStream == null) {
            byte[] bArr = zzalb.zzb;
            zzakdVar = zzakb.zza(bArr, 0, bArr.length, false);
        } else {
            zzakdVar = new zzakd(inputStream);
        }
        return (T) zza(zza(t3, zzakdVar, zzakkVar));
    }

    public static <T extends zzaky<T, ?>> T zza(T t3, byte[] bArr, zzakk zzakkVar) {
        return (T) zza(zza(t3, bArr, 0, bArr.length, zzakkVar));
    }

    private static <T extends zzaky<T, ?>> T zza(T t3, zzakb zzakbVar, zzakk zzakkVar) {
        T t4 = (T) t3.zzo();
        try {
            zzamv zza2 = zzamr.zza().zza((zzamr) t4);
            zza2.zza(t4, zzakf.zza(zzakbVar), zzakkVar);
            zza2.zzd(t4);
            return t4;
        } catch (zzalf e4) {
            if (e4.zzl()) {
                throw new zzalf(e4);
            }
            throw e4;
        } catch (zzanl e5) {
            zzalf zza3 = e5.zza();
            zza3.getClass();
            throw zza3;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzalf) {
                throw ((zzalf) e6.getCause());
            }
            throw new zzalf(e6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof zzalf) {
                throw ((zzalf) e7.getCause());
            }
            throw e7;
        }
    }

    private static <T extends zzaky<T, ?>> T zza(T t3, byte[] bArr, int i, int i3, zzakk zzakkVar) {
        if (i3 == 0) {
            return t3;
        }
        T t4 = (T) t3.zzo();
        try {
            zzamv zza2 = zzamr.zza().zza((zzamr) t4);
            zza2.zza(t4, bArr, 0, i3, new zzajk(zzakkVar));
            zza2.zzd(t4);
            return t4;
        } catch (zzalf e4) {
            if (e4.zzl()) {
                throw new zzalf(e4);
            }
            throw e4;
        } catch (zzanl e5) {
            zzalf zza3 = e5.zza();
            zza3.getClass();
            throw zza3;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzalf) {
                throw ((zzalf) e6.getCause());
            }
            throw new zzalf(e6);
        } catch (IndexOutOfBoundsException unused) {
            zzalf zzj = zzalf.zzj();
            zzj.getClass();
            throw zzj;
        }
    }

    public static <E> zzalc<E> zza(zzalc<E> zzalcVar) {
        return zzalcVar.zza(zzalcVar.size() << 1);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static Object zza(zzamc zzamcVar, String str, Object[] objArr) {
        return new zzamt(zzamcVar, str, objArr);
    }

    public static <T extends zzaky<?, ?>> void zza(Class<T> cls, T t3) {
        t3.zzt();
        zzc.put(cls, t3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(zzakg zzakgVar) {
        zzamr.zza().zza((zzamr) this).zza((zzamv) this, (zzaof) zzakj.zza(zzakgVar));
    }
}
