package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* loaded from: classes.dex */
public final class zzbbc extends zzbag implements TextureView.SurfaceTextureListener, zzbca {
    private Surface zzbht;
    private final zzbay zzdwy;
    private final boolean zzdwz;
    private int zzdxe;
    private int zzdxf;
    private int zzdxh;
    private int zzdxi;
    private zzbax zzdxj;
    private final boolean zzdxk;
    private zzbah zzdxm;
    private final zzbaz zzdxu;
    private String[] zzdyh;
    private final zzbaw zzebe;
    private zzbbs zzebf;
    private String zzebg;
    private boolean zzebh;
    private int zzebi;
    private boolean zzebj;
    private boolean zzebk;
    private float zzebl;

    public zzbbc(Context context, zzbay zzbayVar, zzbaz zzbazVar, boolean z, boolean z2, zzbaw zzbawVar) {
        super(context);
        this.zzebi = 1;
        this.zzdwz = z2;
        this.zzdxu = zzbazVar;
        this.zzdwy = zzbayVar;
        this.zzdxk = z;
        this.zzebe = zzbawVar;
        setSurfaceTextureListener(this);
        this.zzdwy.zzb(this);
    }

    private final void zza(float f, boolean z) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.a(f, z);
        } else {
            zzayu.zzez("Trying to set volume before player is initalized.");
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.a(surface, z);
        } else {
            zzayu.zzez("Trying to set surface before player is initalized.");
        }
    }

    private final void zzo(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzebl != f) {
            this.zzebl = f;
            requestLayout();
        }
    }

    private final zzbbs zzyx() {
        return new zzbbs(this.zzdxu.getContext(), this.zzebe);
    }

    private final String zzyy() {
        return com.google.android.gms.ads.internal.zzq.zzkq().zzr(this.zzdxu.getContext(), this.zzdxu.zzyr().zzbma);
    }

    private final boolean zzyz() {
        return (this.zzebf == null || this.zzebh) ? false : true;
    }

    private final boolean zzza() {
        return zzyz() && this.zzebi != 1;
    }

    private final void zzzb() {
        String str;
        if (this.zzebf != null || (str = this.zzebg) == null || this.zzbht == null) {
            return;
        }
        if (str.startsWith("cache:")) {
            zzbcn zzfe = this.zzdxu.zzfe(this.zzebg);
            if (zzfe instanceof zzbcy) {
                this.zzebf = ((zzbcy) zzfe).zzzr();
            } else {
                if (!(zzfe instanceof zzbcz)) {
                    String valueOf = String.valueOf(this.zzebg);
                    zzayu.zzez(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
                zzbcz zzbczVar = (zzbcz) zzfe;
                String zzyy = zzyy();
                ByteBuffer byteBuffer = zzbczVar.getByteBuffer();
                boolean zzzs = zzbczVar.zzzs();
                String url = zzbczVar.getUrl();
                if (url == null) {
                    zzayu.zzez("Stream cache URL is null.");
                    return;
                } else {
                    this.zzebf = zzyx();
                    this.zzebf.zza(new Uri[]{Uri.parse(url)}, zzyy, byteBuffer, zzzs);
                }
            }
        } else {
            this.zzebf = zzyx();
            String zzyy2 = zzyy();
            Uri[] uriArr = new Uri[this.zzdyh.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzdyh;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzebf.zza(uriArr, zzyy2);
        }
        this.zzebf.zza(this);
        zza(this.zzbht, false);
        this.zzebi = this.zzebf.zzzm().getPlaybackState();
        if (this.zzebi == 3) {
            zzzc();
        }
    }

    private final void zzzc() {
        if (this.zzebj) {
            return;
        }
        this.zzebj = true;
        zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbf
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.f();
            }
        });
        zzxs();
        this.zzdwy.zzer();
        if (this.zzebk) {
            play();
        }
    }

    private final void zzzd() {
        zzo(this.zzdxe, this.zzdxf);
    }

    private final void zzze() {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.a(true);
        }
    }

    private final void zzzf() {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzxw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i) {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, int i2) {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzk(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzm("ExoPlayerAdapter error", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z, long j) {
        this.zzdxu.zza(z, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzxt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.onPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d() {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzxu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzxv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f() {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.zzer();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getCurrentPosition() {
        if (zzza()) {
            return (int) this.zzebf.zzzm().zzec();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getDuration() {
        if (zzza()) {
            return (int) this.zzebf.zzzm().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getVideoHeight() {
        return this.zzdxf;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getVideoWidth() {
        return this.zzdxe;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzebl;
        if (f != 0.0f && this.zzdxj == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            float f4 = this.zzebl;
            if (f4 < f3) {
                measuredWidth = (int) (measuredHeight * f4);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzm(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i4 = this.zzdxh;
            if (((i4 > 0 && i4 != measuredWidth) || ((i3 = this.zzdxi) > 0 && i3 != measuredHeight)) && this.zzdwz && zzyz()) {
                zzgk zzzm = this.zzebf.zzzm();
                if (zzzm.zzec() > 0 && !zzzm.zzea()) {
                    zza(0.0f, true);
                    zzzm.zzf(true);
                    long zzec = zzzm.zzec();
                    long currentTimeMillis = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
                    while (zzyz() && zzzm.zzec() == zzec && com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis() - currentTimeMillis <= 250) {
                    }
                    zzzm.zzf(false);
                    zzxs();
                }
            }
            this.zzdxh = measuredWidth;
            this.zzdxi = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzdxk) {
            this.zzdxj = new zzbax(getContext());
            this.zzdxj.zza(surfaceTexture, i, i2);
            this.zzdxj.start();
            SurfaceTexture zzyg = this.zzdxj.zzyg();
            if (zzyg != null) {
                surfaceTexture = zzyg;
            } else {
                this.zzdxj.zzyf();
                this.zzdxj = null;
            }
        }
        this.zzbht = new Surface(surfaceTexture);
        if (this.zzebf == null) {
            zzzb();
        } else {
            zza(this.zzbht, true);
            if (!this.zzebe.zzdze) {
                zzze();
            }
        }
        if (this.zzdxe == 0 || this.zzdxf == 0) {
            zzo(i, i2);
        } else {
            zzzd();
        }
        zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbi
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.b();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzyf();
            this.zzdxj = null;
        }
        if (this.zzebf != null) {
            zzzf();
            Surface surface = this.zzbht;
            if (surface != null) {
                surface.release();
            }
            this.zzbht = null;
            zza((Surface) null, true);
        }
        zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbk
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.a();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzm(i, i2);
        }
        zzawb.zzdsr.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.zzbbl
            private final int zzdtf;
            private final int zzdtg;
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
                this.zzdtf = i;
                this.zzdtg = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.a(this.zzdtf, this.zzdtg);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzdwy.zzc(this);
        this.a.zza(surfaceTexture, this.zzdxm);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzavs.zzed(sb.toString());
        zzawb.zzdsr.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbbn
            private final int zzdtf;
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
                this.zzdtf = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.a(this.zzdtf);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void pause() {
        if (zzza()) {
            if (this.zzebe.zzdze) {
                zzzf();
            }
            this.zzebf.zzzm().zzf(false);
            this.zzdwy.zzyj();
            this.b.zzyj();
            zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbj
                private final zzbbc zzebm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzebm = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzebm.c();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void play() {
        if (!zzza()) {
            this.zzebk = true;
            return;
        }
        if (this.zzebe.zzdze) {
            zzze();
        }
        this.zzebf.zzzm().zzf(true);
        this.zzdwy.zzyi();
        this.b.zzyi();
        this.a.zzxu();
        zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbg
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.d();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void seekTo(int i) {
        if (zzza()) {
            this.zzebf.zzzm().seekTo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzebg = str;
            this.zzdyh = new String[]{str};
            zzzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void stop() {
        if (zzyz()) {
            this.zzebf.zzzm().stop();
            if (this.zzebf != null) {
                zza((Surface) null, true);
                zzbbs zzbbsVar = this.zzebf;
                if (zzbbsVar != null) {
                    zzbbsVar.zza((zzbca) null);
                    this.zzebf.release();
                    this.zzebf = null;
                }
                this.zzebi = 1;
                this.zzebh = false;
                this.zzebj = false;
                this.zzebk = false;
            }
        }
        this.zzdwy.zzyj();
        this.b.zzyj();
        this.zzdwy.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zza(float f, float f2) {
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zza(zzbah zzbahVar) {
        this.zzdxm = zzbahVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        final String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzayu.zzez(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzebh = true;
        if (this.zzebe.zzdze) {
            zzzf();
        }
        zzawb.zzdsr.post(new Runnable(this, sb2) { // from class: com.google.android.gms.internal.ads.zzbbh
            private final String zzcyr;
            private final zzbbc zzebm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzebm = this;
                this.zzcyr = sb2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebm.a(this.zzcyr);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzebg = str;
            this.zzdyh = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzb(final boolean z, final long j) {
        if (this.zzdxu != null) {
            zzazd.zzdwi.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.zzbbm
                private final boolean zzdym;
                private final zzbbc zzebm;
                private final long zzebn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzebm = this;
                    this.zzdym = z;
                    this.zzebn = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzebm.a(this.zzdym, this.zzebn);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zzcv(int i) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.zzzp().zzdc(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zzcw(int i) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.zzzp().zzdd(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zzcx(int i) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.zzzp().zzcx(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zzcy(int i) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.zzzp().zzcy(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void zzcz(int i) {
        zzbbs zzbbsVar = this.zzebf;
        if (zzbbsVar != null) {
            zzbbsVar.zzcz(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzda(int i) {
        if (this.zzebi != i) {
            this.zzebi = i;
            if (i == 3) {
                zzzc();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zzebe.zzdze) {
                zzzf();
            }
            this.zzdwy.zzyj();
            this.b.zzyj();
            zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbe
                private final zzbbc zzebm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzebm = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzebm.e();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzn(int i, int i2) {
        this.zzdxe = i;
        this.zzdxf = i2;
        zzzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final String zzxo() {
        String str = this.zzdxk ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbag, com.google.android.gms.internal.ads.zzbbd
    public final void zzxs() {
        zza(this.b.getVolume(), false);
    }
}
