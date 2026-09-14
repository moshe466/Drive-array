package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class zzbrm {

    @Nullable
    private final zzcxq zzffr;
    private final Set<zzbsu<zzty>> zzfib;
    private final Set<zzbsu<zzbov>> zzfic;
    private final Set<zzbsu<zzbpe>> zzfid;
    private final Set<zzbsu<zzbqg>> zzfie;
    private final Set<zzbsu<zzbqb>> zzfif;
    private final Set<zzbsu<zzbow>> zzfig;
    private final Set<zzbsu<zzbpa>> zzfih;
    private final Set<zzbsu<AdMetadataListener>> zzfii;
    private final Set<zzbsu<AppEventListener>> zzfij;
    private zzbou zzfik;
    private zzclp zzfil;

    /* loaded from: classes.dex */
    public static class zza {
        private zzcxq zzffr;
        private Set<zzbsu<zzty>> zzfib = new HashSet();
        private Set<zzbsu<zzbov>> zzfic = new HashSet();
        private Set<zzbsu<zzbpe>> zzfid = new HashSet();
        private Set<zzbsu<zzbqg>> zzfie = new HashSet();
        private Set<zzbsu<zzbqb>> zzfif = new HashSet();
        private Set<zzbsu<zzbow>> zzfig = new HashSet();
        private Set<zzbsu<AdMetadataListener>> zzfii = new HashSet();
        private Set<zzbsu<AppEventListener>> zzfij = new HashSet();
        private Set<zzbsu<zzbpa>> zzfih = new HashSet();

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfij.add(new zzbsu<>(appEventListener, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfii.add(new zzbsu<>(adMetadataListener, executor));
            return this;
        }

        public final zza zza(zzbov zzbovVar, Executor executor) {
            this.zzfic.add(new zzbsu<>(zzbovVar, executor));
            return this;
        }

        public final zza zza(zzbow zzbowVar, Executor executor) {
            this.zzfig.add(new zzbsu<>(zzbowVar, executor));
            return this;
        }

        public final zza zza(zzbpa zzbpaVar, Executor executor) {
            this.zzfih.add(new zzbsu<>(zzbpaVar, executor));
            return this;
        }

        public final zza zza(zzbpe zzbpeVar, Executor executor) {
            this.zzfid.add(new zzbsu<>(zzbpeVar, executor));
            return this;
        }

        public final zza zza(zzbqb zzbqbVar, Executor executor) {
            this.zzfif.add(new zzbsu<>(zzbqbVar, executor));
            return this;
        }

        public final zza zza(zzbqg zzbqgVar, Executor executor) {
            this.zzfie.add(new zzbsu<>(zzbqgVar, executor));
            return this;
        }

        public final zza zza(zzcxq zzcxqVar) {
            this.zzffr = zzcxqVar;
            return this;
        }

        public final zza zza(zzty zztyVar, Executor executor) {
            this.zzfib.add(new zzbsu<>(zztyVar, executor));
            return this;
        }

        public final zza zza(@Nullable zzwc zzwcVar, Executor executor) {
            if (this.zzfij != null) {
                zzcos zzcosVar = new zzcos();
                zzcosVar.zzb(zzwcVar);
                this.zzfij.add(new zzbsu<>(zzcosVar, executor));
            }
            return this;
        }

        public final zzbrm zzahw() {
            return new zzbrm(this);
        }
    }

    private zzbrm(zza zzaVar) {
        this.zzfib = zzaVar.zzfib;
        this.zzfid = zzaVar.zzfid;
        this.zzfie = zzaVar.zzfie;
        this.zzfic = zzaVar.zzfic;
        this.zzfif = zzaVar.zzfif;
        this.zzfig = zzaVar.zzfig;
        this.zzfih = zzaVar.zzfih;
        this.zzfii = zzaVar.zzfii;
        this.zzfij = zzaVar.zzfij;
        this.zzffr = zzaVar.zzffr;
    }

    public final zzclp zza(Clock clock) {
        if (this.zzfil == null) {
            this.zzfil = new zzclp(clock);
        }
        return this.zzfil;
    }

    public final Set<zzbsu<zzbov>> zzahm() {
        return this.zzfic;
    }

    public final Set<zzbsu<zzbqb>> zzahn() {
        return this.zzfif;
    }

    public final Set<zzbsu<zzbow>> zzaho() {
        return this.zzfig;
    }

    public final Set<zzbsu<zzbpa>> zzahp() {
        return this.zzfih;
    }

    public final Set<zzbsu<AdMetadataListener>> zzahq() {
        return this.zzfii;
    }

    public final Set<zzbsu<AppEventListener>> zzahr() {
        return this.zzfij;
    }

    public final Set<zzbsu<zzty>> zzahs() {
        return this.zzfib;
    }

    public final Set<zzbsu<zzbpe>> zzaht() {
        return this.zzfid;
    }

    public final Set<zzbsu<zzbqg>> zzahu() {
        return this.zzfie;
    }

    @Nullable
    public final zzcxq zzahv() {
        return this.zzffr;
    }

    public final zzbou zzc(Set<zzbsu<zzbow>> set) {
        if (this.zzfik == null) {
            this.zzfik = new zzbou(set);
        }
        return this.zzfik;
    }
}
