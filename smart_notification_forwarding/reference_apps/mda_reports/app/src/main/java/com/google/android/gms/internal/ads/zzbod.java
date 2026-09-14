package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class zzbod {
    private final zzczu zzfgl;
    private Bundle zzfhf;

    @Nullable
    private final String zzfhg;

    @Nullable
    private final zzczs zzfhh;
    private final Context zzup;

    /* loaded from: classes.dex */
    public static class zza {
        private zzczu zzfgl;
        private Bundle zzfhf;

        @Nullable
        private String zzfhg;

        @Nullable
        private zzczs zzfhh;
        private Context zzup;

        public final zza zza(zzczs zzczsVar) {
            this.zzfhh = zzczsVar;
            return this;
        }

        public final zza zza(zzczu zzczuVar) {
            this.zzfgl = zzczuVar;
            return this;
        }

        public final zzbod zzahh() {
            return new zzbod(this);
        }

        public final zza zzbz(Context context) {
            this.zzup = context;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzfhf = bundle;
            return this;
        }

        public final zza zzfs(String str) {
            this.zzfhg = str;
            return this;
        }
    }

    private zzbod(zza zzaVar) {
        this.zzup = zzaVar.zzup;
        this.zzfgl = zzaVar.zzfgl;
        this.zzfhf = zzaVar.zzfhf;
        this.zzfhg = zzaVar.zzfhg;
        this.zzfhh = zzaVar.zzfhh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a(Context context) {
        return this.zzfhg != null ? context : this.zzup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zza a() {
        return new zza().zzbz(this.zzup).zza(this.zzfgl).zzfs(this.zzfhg).zze(this.zzfhf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzczu b() {
        return this.zzfgl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzczs c() {
        return this.zzfhh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Bundle d() {
        return this.zzfhf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String e() {
        return this.zzfhg;
    }
}
