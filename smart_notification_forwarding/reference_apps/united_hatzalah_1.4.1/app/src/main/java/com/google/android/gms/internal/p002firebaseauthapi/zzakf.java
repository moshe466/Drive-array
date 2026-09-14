package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.firebase.remoteconfig.internal.Code;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakf implements zzams {
    private final zzakb zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzakf(zzakb zzakbVar) {
        zzakb zzakbVar2 = (zzakb) zzalb.zza(zzakbVar, "input");
        this.zza = zzakbVar2;
        zzakbVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final double zza() {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final float zzb() {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzc() {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i3 = this.zzb;
        return (i3 == 0 || i3 == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i3 >>> 3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zze() {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzf() {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzg() {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzh() {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzi() {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final int zzj() {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final long zzk() {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final long zzl() {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final long zzm() {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final long zzn() {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final long zzo() {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final zzajp zzp() {
        zzb(2);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final String zzq() {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final String zzr() {
        zzb(2);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final boolean zzs() {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final boolean zzt() {
        int i;
        if (!this.zza.zzt() && (i = this.zzb) != this.zzc) {
            return this.zza.zzd(i);
        }
        return false;
    }

    private final <T> void zzd(T t3, zzamv<T> zzamvVar, zzakk zzakkVar) {
        int zzj = this.zza.zzj();
        this.zza.zzv();
        int zza = this.zza.zza(zzj);
        this.zza.zza++;
        zzamvVar.zza(t3, this, zzakkVar);
        this.zza.zzb(0);
        r4.zza--;
        this.zza.zzc(zza);
    }

    public static zzakf zza(zzakb zzakbVar) {
        zzakf zzakfVar = zzakbVar.zzc;
        return zzakfVar != null ? zzakfVar : new zzakf(zzakbVar);
    }

    private final <T> T zzb(zzamv<T> zzamvVar, zzakk zzakkVar) {
        T zza = zzamvVar.zza();
        zzd(zza, zzamvVar, zzakkVar);
        zzamvVar.zzd(zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zze(List<Integer> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            int i = this.zzb & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzalf.zza();
                }
                do {
                    zzakzVar.zzc(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi2 = this.zza.zzi();
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
                return;
            }
            int zzj = this.zza.zzj();
            zzc(zzj);
            int zzc = this.zza.zzc() + zzj;
            do {
                zzakzVar.zzc(this.zza.zze());
            } while (this.zza.zzc() < zzc);
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw zzalf.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        int zzj2 = this.zza.zzj();
        zzc(zzj2);
        int zzc2 = this.zza.zzc() + zzj2;
        do {
            list.add(Integer.valueOf(this.zza.zze()));
        } while (this.zza.zzc() < zzc2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzf(List<Long> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzj = this.zza.zzj();
                    zzd(zzj);
                    int zzc = this.zza.zzc() + zzj;
                    do {
                        zzalrVar.zza(this.zza.zzk());
                    } while (this.zza.zzc() < zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzalrVar.zza(this.zza.zzk());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc2 = this.zza.zzc() + zzj2;
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzk()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzg(List<Float> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakx) {
            zzakx zzakxVar = (zzakx) list;
            int i = this.zzb & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzalf.zza();
                }
                do {
                    zzakxVar.zza(this.zza.zzb());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi2 = this.zza.zzi();
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
                return;
            }
            int zzj = this.zza.zzj();
            zzc(zzj);
            int zzc = this.zza.zzc() + zzj;
            do {
                zzakxVar.zza(this.zza.zzb());
            } while (this.zza.zzc() < zzc);
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw zzalf.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        int zzj2 = this.zza.zzj();
        zzc(zzj2);
        int zzc2 = this.zza.zzc() + zzj2;
        do {
            list.add(Float.valueOf(this.zza.zzb()));
        } while (this.zza.zzc() < zzc2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzh(List<Integer> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzakzVar.zzc(this.zza.zzf());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzakzVar.zzc(this.zza.zzf());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzf()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzi(List<Long> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzalrVar.zza(this.zza.zzl());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzalrVar.zza(this.zza.zzl());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzl()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzj(List<Integer> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            int i = this.zzb & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzalf.zza();
                }
                do {
                    zzakzVar.zzc(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi2 = this.zza.zzi();
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
                return;
            }
            int zzj = this.zza.zzj();
            zzc(zzj);
            int zzc = this.zza.zzc() + zzj;
            do {
                zzakzVar.zzc(this.zza.zzg());
            } while (this.zza.zzc() < zzc);
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw zzalf.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        int zzj2 = this.zza.zzj();
        zzc(zzj2);
        int zzc2 = this.zza.zzc() + zzj2;
        do {
            list.add(Integer.valueOf(this.zza.zzg()));
        } while (this.zza.zzc() < zzc2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzk(List<Long> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzj = this.zza.zzj();
                    zzd(zzj);
                    int zzc = this.zza.zzc() + zzj;
                    do {
                        zzalrVar.zza(this.zza.zzn());
                    } while (this.zza.zzc() < zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzalrVar.zza(this.zza.zzn());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc2 = this.zza.zzc() + zzj2;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzn()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzl(List<Integer> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzakzVar.zzc(this.zza.zzh());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzakzVar.zzc(this.zza.zzh());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzh()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzm(List<Long> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzalrVar.zza(this.zza.zzo());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzalrVar.zza(this.zza.zzo());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzo()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzn(List<String> list) {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzo(List<String> list) {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzp(List<Integer> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzakzVar.zzc(this.zza.zzj());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzakzVar.zzc(this.zza.zzj());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzj()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzq(List<Long> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzalrVar.zza(this.zza.zzp());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzalrVar.zza(this.zza.zzp());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Long.valueOf(this.zza.zzp()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    private final Object zza(zzanw zzanwVar, Class<?> cls, zzakk zzakkVar) {
        switch (zzake.zza[zzanwVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzamr.zza().zza((Class) cls), zzakkVar);
            case 11:
                return Integer.valueOf(zzh());
            case Code.UNIMPLEMENTED /* 12 */:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> void zzc(T t3, zzamv<T> zzamvVar, zzakk zzakkVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzamvVar.zza(t3, this, zzakkVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzalf.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final <T> void zzb(T t3, zzamv<T> zzamvVar, zzakk zzakkVar) {
        zzb(2);
        zzd(t3, zzamvVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzb(List<zzajp> list) {
        int zzi;
        if ((this.zzb & 7) != 2) {
            throw zzalf.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzd(List<Integer> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzakzVar.zzc(this.zza.zzd());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzakzVar.zzc(this.zza.zzd());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Integer.valueOf(this.zza.zzd()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final <T> void zzb(List<T> list, zzamv<T> zzamvVar, zzakk zzakkVar) {
        int zzi;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzalf.zza();
        }
        do {
            list.add(zzb(zzamvVar, zzakkVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == i);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zzc(List<Double> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzaki) {
            zzaki zzakiVar = (zzaki) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzj = this.zza.zzj();
                    zzd(zzj);
                    int zzc = this.zza.zzc() + zzj;
                    do {
                        zzakiVar.zza(this.zza.zza());
                    } while (this.zza.zzc() < zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzakiVar.zza(this.zza.zza());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc2 = this.zza.zzc() + zzj2;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Double.valueOf(this.zza.zza()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    private final void zzb(int i) {
        if ((this.zzb & 7) != i) {
            throw zzalf.zza();
        }
    }

    private final <T> T zza(zzamv<T> zzamvVar, zzakk zzakkVar) {
        T zza = zzamvVar.zza();
        zzc(zza, zzamvVar, zzakkVar);
        zzamvVar.zzd(zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final <T> void zza(T t3, zzamv<T> zzamvVar, zzakk zzakkVar) {
        zzb(3);
        zzc(t3, zzamvVar, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    public final void zza(List<Boolean> list) {
        int zzi;
        int zzi2;
        if (list instanceof zzajn) {
            zzajn zzajnVar = (zzajn) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzc = this.zza.zzc() + this.zza.zzj();
                    do {
                        zzajnVar.zza(this.zza.zzu());
                    } while (this.zza.zzc() < zzc);
                    zza(zzc);
                    return;
                }
                throw zzalf.zza();
            }
            do {
                zzajnVar.zza(this.zza.zzu());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi2 = this.zza.zzi();
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
            return;
        }
        int i3 = this.zzb & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
                return;
            }
            throw zzalf.zza();
        }
        do {
            list.add(Boolean.valueOf(this.zza.zzu()));
            if (this.zza.zzt()) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    private static void zzd(int i) {
        if ((i & 7) != 0) {
            throw zzalf.zzg();
        }
    }

    private static void zzc(int i) {
        if ((i & 3) != 0) {
            throw zzalf.zzg();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    @Deprecated
    public final <T> void zza(List<T> list, zzamv<T> zzamvVar, zzakk zzakkVar) {
        int zzi;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzalf.zza();
        }
        do {
            list.add(zza(zzamvVar, zzakkVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                zzi = this.zza.zzi();
            }
        } while (zzi == i);
        this.zzd = zzi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x005f, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0062, code lost:
    
        r7.zza.zzc(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.p002firebaseauthapi.zzalx<K, V> r9, com.google.android.gms.internal.p002firebaseauthapi.zzakk r10) {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.firebase-auth-api.zzakb r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.firebase-auth-api.zzakb r2 = r7.zza
            int r1 = r2.zza(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L39
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5f
            com.google.android.gms.internal.firebase-auth-api.zzakb r5 = r7.zza     // Catch: java.lang.Throwable -> L39
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L5f
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L4a
            if (r4 == r0) goto L3d
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.firebase-auth-api.zzalf r4 = new com.google.android.gms.internal.firebase-auth-api.zzalf     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            throw r4     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
        L39:
            r8 = move-exception
            goto L68
        L3b:
            r4 = move-exception
            goto L52
        L3d:
            com.google.android.gms.internal.firebase-auth-api.zzanw r4 = r9.zzc     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            V r5 = r9.zzd     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            goto L14
        L4a:
            com.google.android.gms.internal.firebase-auth-api.zzanw r4 = r9.zza     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzale -> L3b
            goto L14
        L52:
            boolean r5 = r7.zzt()     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L59
            goto L14
        L59:
            com.google.android.gms.internal.firebase-auth-api.zzalf r8 = new com.google.android.gms.internal.firebase-auth-api.zzalf     // Catch: java.lang.Throwable -> L39
            r8.<init>(r6, r4)     // Catch: java.lang.Throwable -> L39
            throw r8     // Catch: java.lang.Throwable -> L39
        L5f:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.firebase-auth-api.zzakb r8 = r7.zza
            r8.zzc(r1)
            return
        L68:
            com.google.android.gms.internal.firebase-auth-api.zzakb r9 = r7.zza
            r9.zzc(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakf.zza(java.util.Map, com.google.android.gms.internal.firebase-auth-api.zzalx, com.google.android.gms.internal.firebase-auth-api.zzakk):void");
    }

    private final void zza(List<String> list, boolean z3) {
        int zzi;
        int zzi2;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzaln) && !z3) {
                zzaln zzalnVar = (zzaln) list;
                do {
                    zzalnVar.zza(zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        zzi2 = this.zza.zzi();
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
                return;
            }
            do {
                list.add(z3 ? zzr() : zzq());
                if (this.zza.zzt()) {
                    return;
                } else {
                    zzi = this.zza.zzi();
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        throw zzalf.zza();
    }

    private final void zza(int i) {
        if (this.zza.zzc() != i) {
            throw zzalf.zzj();
        }
    }
}
