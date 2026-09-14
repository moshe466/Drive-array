package com.google.android.gms.internal.ads;

import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzday {
    private final int maxEntries;
    private final int zzgnq;
    private final LinkedList<zzdbi<?>> zzgnp = new LinkedList<>();
    private final zzdbp zzgnr = new zzdbp();

    public zzday(int i, int i2) {
        this.maxEntries = i;
        this.zzgnq = i2;
    }

    private final void zzapc() {
        while (!this.zzgnp.isEmpty()) {
            if (!(com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis() - this.zzgnp.getFirst().zzgpe >= ((long) this.zzgnq))) {
                return;
            }
            this.zzgnr.zzapt();
            this.zzgnp.remove();
        }
    }

    public final long getCreationTimeMillis() {
        return this.zzgnr.getCreationTimeMillis();
    }

    public final int size() {
        zzapc();
        return this.zzgnp.size();
    }

    public final zzdbi<?> zzaox() {
        this.zzgnr.zzapr();
        zzapc();
        if (this.zzgnp.isEmpty()) {
            return null;
        }
        zzdbi<?> remove = this.zzgnp.remove();
        if (remove != null) {
            this.zzgnr.zzaps();
        }
        return remove;
    }

    public final long zzaoy() {
        return this.zzgnr.zzaoy();
    }

    public final int zzaoz() {
        return this.zzgnr.zzaoz();
    }

    public final String zzapa() {
        return this.zzgnr.zzapk();
    }

    public final zzdbo zzapb() {
        return this.zzgnr.zzapu();
    }

    public final boolean zzb(zzdbi<?> zzdbiVar) {
        this.zzgnr.zzapr();
        zzapc();
        if (this.zzgnp.size() == this.maxEntries) {
            return false;
        }
        this.zzgnp.add(zzdbiVar);
        return true;
    }
}
