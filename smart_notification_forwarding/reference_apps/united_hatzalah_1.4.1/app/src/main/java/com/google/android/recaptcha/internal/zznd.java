package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.recaptcha.internal.zzmx;
import com.google.android.recaptcha.internal.zznd;
import e0.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zznd<MessageType extends zznd<MessageType, BuilderType>, BuilderType extends zzmx<MessageType, BuilderType>> extends zzko<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzpm zzc = zzpm.zzc();

    public static zznj zzA() {
        return zznx.zzf();
    }

    public static zznk zzB() {
        return zzot.zze();
    }

    public static zznk zzC(zznk zznkVar) {
        int size = zznkVar.size();
        return zznkVar.zzd(size + size);
    }

    public static Object zzE(Method method, Object obj, Object... objArr) {
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

    public static Object zzF(zzoi zzoiVar, String str, Object[] objArr) {
        return new zzou(zzoiVar, str, objArr);
    }

    public static void zzI(Class cls, zznd zzndVar) {
        zzndVar.zzH();
        zzb.put(cls, zzndVar);
    }

    public static final boolean zzK(zznd zzndVar, boolean z3) {
        zznd zzndVar2;
        byte byteValue = ((Byte) zzndVar.zzh(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzos.zza().zzb(zzndVar.getClass()).zzl(zzndVar);
        if (z3) {
            if (true != zzl) {
                zzndVar2 = null;
            } else {
                zzndVar2 = zzndVar;
            }
            zzndVar.zzh(2, zzndVar2, null);
        }
        return zzl;
    }

    private final int zzf(zzow zzowVar) {
        return zzos.zza().zzb(getClass()).zza(this);
    }

    private static zznd zzg(zznd zzndVar) {
        if (zzndVar != null && !zzK(zzndVar, true)) {
            throw new zzpk(zzndVar).zza();
        }
        return zzndVar;
    }

    public static zznd zzi(zznd zzndVar, byte[] bArr, int i, int i3, zzmo zzmoVar) {
        if (i3 == 0) {
            return zzndVar;
        }
        zznd zzv = zzndVar.zzv();
        try {
            zzow zzb2 = zzos.zza().zzb(zzv.getClass());
            zzb2.zzi(zzv, bArr, 0, i3, new zzkt(zzmoVar));
            zzb2.zzf(zzv);
            return zzv;
        } catch (zznn e4) {
            if (e4.zzb()) {
                throw new zznn(e4);
            }
            throw e4;
        } catch (zzpk e5) {
            throw e5.zza();
        } catch (IOException e6) {
            if (e6.getCause() instanceof zznn) {
                throw ((zznn) e6.getCause());
            }
            throw new zznn(e6);
        } catch (IndexOutOfBoundsException unused) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static zznc zzs(zzoi zzoiVar, Object obj, zzoi zzoiVar2, zzng zzngVar, int i, zzpw zzpwVar, Class cls) {
        return new zznc(zzoiVar, "", null, new zznb(null, i, zzpwVar, false, false), cls);
    }

    public static /* bridge */ /* synthetic */ zznd zzt(zznd zzndVar, byte[] bArr, int i, int i3, zzmo zzmoVar) {
        return zzi(zzndVar, bArr, 0, i3, zzmoVar);
    }

    public static zznd zzu(Class cls) {
        Map map = zzb;
        zznd zzndVar = (zznd) map.get(cls);
        if (zzndVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzndVar = (zznd) map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzndVar == null) {
            zznd zzndVar2 = (zznd) ((zznd) zzps.zze(cls)).zzh(6, null, null);
            if (zzndVar2 != null) {
                map.put(cls, zzndVar2);
                return zzndVar2;
            }
            throw new IllegalStateException();
        }
        return zzndVar;
    }

    public static zznd zzw(zznd zzndVar, InputStream inputStream) {
        zzli zzlgVar;
        if (inputStream == null) {
            byte[] bArr = zznl.zzb;
            int length = bArr.length;
            zzlgVar = zzli.zzH(bArr, 0, 0, false);
        } else {
            zzlgVar = new zzlg(inputStream, 4096, null);
        }
        int i = zzmo.zzb;
        int i3 = zzos.zza;
        zzmo zzmoVar = zzmo.zza;
        zznd zzv = zzndVar.zzv();
        try {
            zzow zzb2 = zzos.zza().zzb(zzv.getClass());
            zzb2.zzh(zzv, zzlj.zzq(zzlgVar), zzmoVar);
            zzb2.zzf(zzv);
            zzg(zzv);
            return zzv;
        } catch (zznn e4) {
            if (e4.zzb()) {
                throw new zznn(e4);
            }
            throw e4;
        } catch (zzpk e5) {
            throw e5.zza();
        } catch (IOException e6) {
            if (e6.getCause() instanceof zznn) {
                throw ((zznn) e6.getCause());
            }
            throw new zznn(e6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof zznn) {
                throw ((zznn) e7.getCause());
            }
            throw e7;
        }
    }

    public static zznd zzx(zznd zzndVar, byte[] bArr) {
        int i = zzmo.zzb;
        int i3 = zzos.zza;
        zznd zzi = zzi(zzndVar, bArr, 0, bArr.length, zzmo.zza);
        zzg(zzi);
        return zzi;
    }

    public static zzni zzy() {
        return zzne.zzf();
    }

    public static zzni zzz(zzni zzniVar) {
        int size = zzniVar.size();
        return zzniVar.zzd(size + size);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzos.zza().zzb(getClass()).zzk(this, (zznd) obj);
    }

    public final int hashCode() {
        if (!zzL()) {
            int i = this.zza;
            if (i == 0) {
                int zzn = zzn();
                this.zza = zzn;
                return zzn;
            }
            return i;
        }
        return zzn();
    }

    public final String toString() {
        return zzok.zza(this, super.toString());
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final zzoq zzD() {
        return (zzoq) zzh(7, null, null);
    }

    public final void zzG() {
        zzos.zza().zzb(getClass()).zzf(this);
        zzH();
    }

    public final void zzH() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void zzJ(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean zzL() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.recaptcha.internal.zzko
    public final int zza(zzow zzowVar) {
        if (zzL()) {
            int zza = zzowVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException(a.c(zza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i == Integer.MAX_VALUE) {
            int zza2 = zzowVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException(a.c(zza2, "serialized size must be non-negative, was "));
        }
        return i;
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final /* synthetic */ zzoh zzad() {
        return (zzmx) zzh(5, null, null);
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final /* synthetic */ zzoh zzae() {
        zzmx zzmxVar = (zzmx) zzh(5, null, null);
        zzmxVar.zzh(this);
        return zzmxVar;
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final void zze(zzln zzlnVar) {
        zzos.zza().zzb(getClass()).zzj(this, zzlo.zza(zzlnVar));
    }

    public abstract Object zzh(int i, Object obj, Object obj2);

    @Override // com.google.android.recaptcha.internal.zzoj
    public final /* synthetic */ zzoi zzm() {
        return (zznd) zzh(6, null, null);
    }

    public final int zzn() {
        return zzos.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final int zzo() {
        if (zzL()) {
            int zzf = zzf(null);
            if (zzf >= 0) {
                return zzf;
            }
            throw new IllegalStateException(a.c(zzf, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zzf2 = zzf(null);
        if (zzf2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzf2;
            return zzf2;
        }
        throw new IllegalStateException(a.c(zzf2, "serialized size must be non-negative, was "));
    }

    @Override // com.google.android.recaptcha.internal.zzoj
    public final boolean zzp() {
        return zzK(this, true);
    }

    public final zzmx zzq() {
        return (zzmx) zzh(5, null, null);
    }

    public final zzmx zzr() {
        zzmx zzmxVar = (zzmx) zzh(5, null, null);
        zzmxVar.zzh(this);
        return zzmxVar;
    }

    public final zznd zzv() {
        return (zznd) zzh(4, null, null);
    }
}
