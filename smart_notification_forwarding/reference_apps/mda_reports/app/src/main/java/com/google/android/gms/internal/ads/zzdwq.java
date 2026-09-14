package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class zzdwq implements zzbi, Closeable, Iterator<zzbf> {
    protected zzbe a;
    protected zzdws b;
    private static final zzbf zzhzh = new zzdwp("eof ");
    private static zzdwy zzcr = zzdwy.zzn(zzdwq.class);
    private zzbf zzhzj = null;
    long c = 0;
    long d = 0;
    private List<zzbf> zzhzl = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* renamed from: zzbdm, reason: merged with bridge method [inline-methods] */
    public final zzbf next() {
        zzbf zza;
        zzbf zzbfVar = this.zzhzj;
        if (zzbfVar != null && zzbfVar != zzhzh) {
            this.zzhzj = null;
            return zzbfVar;
        }
        zzdws zzdwsVar = this.b;
        if (zzdwsVar == null || this.c >= this.d) {
            this.zzhzj = zzhzh;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzdwsVar) {
                this.b.zzfc(this.c);
                zza = this.a.zza(this.b, this);
                this.c = this.b.position();
            }
            return zza;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public void close() {
        this.b.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbf zzbfVar = this.zzhzj;
        if (zzbfVar == zzhzh) {
            return false;
        }
        if (zzbfVar != null) {
            return true;
        }
        try {
            this.zzhzj = (zzbf) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzhzj = zzhzh;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzhzl.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzhzl.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzdws zzdwsVar, long j, zzbe zzbeVar) {
        this.b = zzdwsVar;
        this.c = zzdwsVar.position();
        zzdwsVar.zzfc(zzdwsVar.position() + j);
        this.d = zzdwsVar.position();
        this.a = zzbeVar;
    }

    public final List<zzbf> zzbdl() {
        return (this.b == null || this.zzhzj == zzhzh) ? this.zzhzl : new zzdww(this.zzhzl, this);
    }
}
