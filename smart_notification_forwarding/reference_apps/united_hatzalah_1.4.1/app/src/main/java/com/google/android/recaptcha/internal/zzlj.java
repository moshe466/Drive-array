package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlj implements zzov {
    private final zzli zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzlj(zzli zzliVar) {
        byte[] bArr = zznl.zzb;
        this.zza = zzliVar;
        zzliVar.zzc = this;
    }

    private final void zzP(Object obj, zzow zzowVar, zzmo zzmoVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzowVar.zzh(obj, this, zzmoVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zznn("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzow zzowVar, zzmo zzmoVar) {
        zzli zzliVar = this.zza;
        int zzn = zzliVar.zzn();
        if (zzliVar.zza < zzliVar.zzb) {
            int zze = zzliVar.zze(zzn);
            this.zza.zza++;
            zzowVar.zzh(obj, this, zzmoVar);
            this.zza.zzz(0);
            r5.zza--;
            this.zza.zzA(zze);
            return;
        }
        throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    private final void zzR(int i) {
        if (this.zza.zzd() == i) {
        } else {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzS(int i) {
        if ((this.zzb & 7) == i) {
        } else {
            throw new zznm("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzT(int i) {
        if ((i & 3) == 0) {
        } else {
            throw new zznn("Failed to parse the message.");
        }
    }

    private static final void zzU(int i) {
        if ((i & 7) == 0) {
        } else {
            throw new zznn("Failed to parse the message.");
        }
    }

    public static zzlj zzq(zzli zzliVar) {
        zzlj zzljVar = zzliVar.zzc;
        if (zzljVar != null) {
            return zzljVar;
        }
        return new zzlj(zzliVar);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzA(List list) {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = zzn + this.zza.zzd();
                    do {
                        zznxVar.zzg(this.zza.zzo());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zznxVar.zzg(this.zza.zzo());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn2 = this.zza.zzn();
                    zzU(zzn2);
                    int zzd2 = zzn2 + this.zza.zzd();
                    do {
                        list.add(Long.valueOf(this.zza.zzo()));
                    } while (this.zza.zzd() < zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzB(List list) {
        int zzm;
        int i;
        if (list instanceof zzmv) {
            zzmv zzmvVar = (zzmv) list;
            int i3 = this.zzb & 7;
            if (i3 != 2) {
                if (i3 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                do {
                    zzmvVar.zzf(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzmvVar.zzf(this.zza.zzc());
                } while (this.zza.zzd() < zzd);
                return;
            }
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    @Deprecated
    public final void zzC(List list, zzow zzowVar, zzmo zzmoVar) {
        int zzm;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zznm("Protocol message tag had invalid wire type.");
        }
        do {
            Object zze = zzowVar.zze();
            zzP(zze, zzowVar, zzmoVar);
            zzowVar.zzf(zze);
            list.add(zze);
            if (!this.zza.zzC() && this.zzd == 0) {
                zzm = this.zza.zzm();
            } else {
                return;
            }
        } while (zzm == i);
        this.zzd = zzm;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzD(List list) {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zzneVar.zzh(this.zza.zzh());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zzneVar.zzh(this.zza.zzh());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzh()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzE(List list) {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zznxVar.zzg(this.zza.zzp());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zznxVar.zzg(this.zza.zzp());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Long.valueOf(this.zza.zzp()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzF(List list, zzow zzowVar, zzmo zzmoVar) {
        int zzm;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zznm("Protocol message tag had invalid wire type.");
        }
        do {
            Object zze = zzowVar.zze();
            zzQ(zze, zzowVar, zzmoVar);
            zzowVar.zzf(zze);
            list.add(zze);
            if (!this.zza.zzC() && this.zzd == 0) {
                zzm = this.zza.zzm();
            } else {
                return;
            }
        } while (zzm == i);
        this.zzd = zzm;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzG(List list) {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = this.zzb & 7;
            if (i3 != 2) {
                if (i3 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                do {
                    zzneVar.zzh(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzneVar.zzh(this.zza.zzk());
                } while (this.zza.zzd() < zzd);
                return;
            }
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzH(List list) {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = zzn + this.zza.zzd();
                    do {
                        zznxVar.zzg(this.zza.zzt());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zznxVar.zzg(this.zza.zzt());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn2 = this.zza.zzn();
                    zzU(zzn2);
                    int zzd2 = zzn2 + this.zza.zzd();
                    do {
                        list.add(Long.valueOf(this.zza.zzt()));
                    } while (this.zza.zzd() < zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzI(List list) {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zzneVar.zzh(this.zza.zzl());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zzneVar.zzh(this.zza.zzl());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzl()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzJ(List list) {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zznxVar.zzg(this.zza.zzu());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zznxVar.zzg(this.zza.zzu());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Long.valueOf(this.zza.zzu()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z3) {
        String zzr;
        int zzm;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zznu) && !z3) {
                zznu zznuVar = (zznu) list;
                do {
                    zzp();
                    zznuVar.zzb();
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                do {
                    if (z3) {
                        zzr = zzs();
                    } else {
                        zzr = zzr();
                    }
                    list.add(zzr);
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        zzm = this.zza.zzm();
                    }
                } while (zzm == this.zzb);
                i = zzm;
            }
            this.zzd = i;
            return;
        }
        throw new zznm("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzL(List list) {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zzneVar.zzh(this.zza.zzn());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zzneVar.zzh(this.zza.zzn());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzn()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzM(List list) {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zznxVar.zzg(this.zza.zzv());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zznxVar.zzg(this.zza.zzv());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Long.valueOf(this.zza.zzv()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final boolean zzN() {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final boolean zzO() {
        int i;
        if (!this.zza.zzC() && (i = this.zzb) != this.zzc) {
            return this.zza.zzE(i);
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final double zza() {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final float zzb() {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzc() {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i != 0 && i != this.zzc) {
            return i >>> 3;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zze() {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzf() {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzg() {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzh() {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzi() {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzj() {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzk() {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzl() {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzm() {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzn() {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzo() {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final zzle zzp() {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final String zzr() {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final String zzs() {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzt(Object obj, zzow zzowVar, zzmo zzmoVar) {
        zzS(3);
        zzP(obj, zzowVar, zzmoVar);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzu(Object obj, zzow zzowVar, zzmo zzmoVar) {
        zzS(2);
        zzQ(obj, zzowVar, zzmoVar);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzv(List list) {
        int zzm;
        int i;
        if (list instanceof zzkv) {
            zzkv zzkvVar = (zzkv) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zzkvVar.zze(this.zza.zzD());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zzkvVar.zze(this.zza.zzD());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Boolean.valueOf(this.zza.zzD()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzw(List list) {
        int zzm;
        if ((this.zzb & 7) != 2) {
            throw new zznm("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzx(List list) {
        int zzm;
        int i;
        if (list instanceof zzmi) {
            zzmi zzmiVar = (zzmi) list;
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 == 2) {
                    int zzn = this.zza.zzn();
                    zzU(zzn);
                    int zzd = zzn + this.zza.zzd();
                    do {
                        zzmiVar.zzf(this.zza.zzb());
                    } while (this.zza.zzd() < zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zzmiVar.zzf(this.zza.zzb());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 == 2) {
                    int zzn2 = this.zza.zzn();
                    zzU(zzn2);
                    int zzd2 = zzn2 + this.zza.zzd();
                    do {
                        list.add(Double.valueOf(this.zza.zzb()));
                    } while (this.zza.zzd() < zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzy(List list) {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    zzli zzliVar = this.zza;
                    int zzd = zzliVar.zzd() + zzliVar.zzn();
                    do {
                        zzneVar.zzh(this.zza.zzf());
                    } while (this.zza.zzd() < zzd);
                    zzR(zzd);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                zzneVar.zzh(this.zza.zzf());
                if (!this.zza.zzC()) {
                    i = this.zza.zzm();
                } else {
                    return;
                }
            } while (i == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 == 2) {
                    zzli zzliVar2 = this.zza;
                    int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                    do {
                        list.add(Integer.valueOf(this.zza.zzf()));
                    } while (this.zza.zzd() < zzd2);
                    zzR(zzd2);
                    return;
                }
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzz(List list) {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i3 = this.zzb & 7;
            if (i3 != 2) {
                if (i3 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                do {
                    zzneVar.zzh(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzneVar.zzh(this.zza.zzg());
                } while (this.zza.zzd() < zzd);
                return;
            }
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 2) {
                if (i4 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
        }
        this.zzd = i;
    }
}
