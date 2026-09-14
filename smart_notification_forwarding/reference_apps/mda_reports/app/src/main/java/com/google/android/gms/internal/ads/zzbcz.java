package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class zzbcz extends zzbcn implements zznz<zznl> {
    private String url;
    private ByteBuffer zzako;
    private final zzbaw zzebe;
    private boolean zzedo;
    private final zzbcw zzedu;
    private final zzbcf zzedv;
    private boolean zzedw;
    private final Object zzedx;
    private boolean zzedy;

    public zzbcz(zzbaz zzbazVar, zzbaw zzbawVar) {
        super(zzbazVar);
        this.zzebe = zzbawVar;
        this.zzedu = new zzbcw();
        this.zzedv = new zzbcf();
        this.zzedx = new Object();
    }

    private final void zzyb() {
        int a = (int) this.zzedu.a();
        int zzl = (int) this.zzedv.zzl(this.zzako);
        int position = this.zzako.position();
        int round = Math.round(zzl * (position / a));
        boolean z = round > 0;
        int zzzn = zzbbs.zzzn();
        int zzzo = zzbbs.zzzo();
        String str = this.url;
        zza(str, a(str), position, a, round, zzl, z, zzzn, zzzo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbcn
    public final String a(String str) {
        String valueOf = String.valueOf(super.a(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void abort() {
        this.zzedo = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzedx) {
            if (this.zzako != null && !this.zzedw) {
                this.zzako.flip();
                this.zzedw = true;
            }
            this.zzedo = true;
        }
        return this.zzako;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final /* synthetic */ void zza(zznl zznlVar, zznq zznqVar) {
        zznl zznlVar2 = zznlVar;
        if (zznlVar2 instanceof zzns) {
            this.zzedu.a((zzns) zznlVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final /* bridge */ /* synthetic */ void zzc(zznl zznlVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zznz
    public final /* bridge */ /* synthetic */ void zze(zznl zznlVar) {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:? -> B:50:0x013a). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbcn
    public final boolean zzfi(String str) {
        String str2;
        this.url = str;
        String a = a(str);
        String str3 = "error";
        int i = 0;
        try {
            zznl zznsVar = new zzns(this.b, null, this, this.zzebe.zzdzh, this.zzebe.zzdzj, true, null);
            if (this.zzebe.zzdzn) {
                try {
                    zznsVar = new zzbbr(this.a, zznsVar, null, null);
                } catch (Exception e) {
                    e = e;
                    String canonicalName = e.getClass().getCanonicalName();
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(":");
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    zzayu.zzez(sb3.toString());
                    zza(str, a, str3, sb2);
                    return false;
                }
            }
            zznsVar.zza(new zznq(Uri.parse(str)));
            zzbaz zzbazVar = this.c.get();
            if (zzbazVar != null) {
                zzbazVar.zza(a, this);
            }
            Clock zzkx = com.google.android.gms.ads.internal.zzq.zzkx();
            long currentTimeMillis = zzkx.currentTimeMillis();
            long longValue = ((Long) zzve.zzoy().zzd(zzzn.zzcgy)).longValue();
            long longValue2 = ((Long) zzve.zzoy().zzd(zzzn.zzcgx)).longValue();
            this.zzako = ByteBuffer.allocate(this.zzebe.zzdzg);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = currentTimeMillis;
            while (true) {
                int read = zznsVar.read(bArr, i, Math.min(this.zzako.remaining(), i2));
                if (read == -1) {
                    this.zzedy = true;
                    zzb(str, a, (int) this.zzedv.zzl(this.zzako));
                    return true;
                }
                synchronized (this.zzedx) {
                    try {
                        if (this.zzedo) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.zzako.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzako.remaining() <= 0) {
                                zzyb();
                                return true;
                            }
                            if (this.zzedo) {
                                int limit = this.zzako.limit();
                                StringBuilder sb4 = new StringBuilder(35);
                                sb4.append("Precache abort at ");
                                sb4.append(limit);
                                sb4.append(" bytes");
                                throw new IOException(sb4.toString());
                            }
                            long currentTimeMillis2 = zzkx.currentTimeMillis();
                            if (currentTimeMillis2 - j >= longValue) {
                                zzyb();
                                j = currentTimeMillis2;
                            }
                            if (currentTimeMillis2 - currentTimeMillis > 1000 * longValue2) {
                                StringBuilder sb5 = new StringBuilder(49);
                                sb5.append("Timeout exceeded. Limit: ");
                                sb5.append(longValue2);
                                sb5.append(" sec");
                                throw new IOException(sb5.toString());
                            }
                            str3 = str2;
                            i2 = 8192;
                            i = 0;
                        } catch (Exception e2) {
                            e = e2;
                            str3 = str2;
                            String canonicalName2 = e.getClass().getCanonicalName();
                            String message2 = e.getMessage();
                            StringBuilder sb6 = new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length());
                            sb6.append(canonicalName2);
                            sb6.append(":");
                            sb6.append(message2);
                            String sb22 = sb6.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb22).length());
                            sb32.append("Failed to preload url ");
                            sb32.append(str);
                            sb32.append(" Exception: ");
                            sb32.append(sb22);
                            zzayu.zzez(sb32.toString());
                            zza(str, a, str3, sb22);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final boolean zzzs() {
        return this.zzedy;
    }
}
