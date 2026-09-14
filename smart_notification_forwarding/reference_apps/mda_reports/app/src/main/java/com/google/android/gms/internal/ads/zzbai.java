package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbai extends FrameLayout implements zzbah {
    private final zzbaz zzdxu;
    private final FrameLayout zzdxv;
    private final zzaae zzdxw;
    private final zzbbb zzdxx;
    private final long zzdxy;

    @Nullable
    private zzbag zzdxz;
    private boolean zzdya;
    private boolean zzdyb;
    private boolean zzdyc;
    private boolean zzdyd;
    private long zzdye;
    private long zzdyf;
    private String zzdyg;
    private String[] zzdyh;
    private Bitmap zzdyi;
    private ImageView zzdyj;
    private boolean zzdyk;

    public zzbai(Context context, zzbaz zzbazVar, int i, boolean z, zzaae zzaaeVar, zzbaw zzbawVar) {
        super(context);
        this.zzdxu = zzbazVar;
        this.zzdxw = zzaaeVar;
        this.zzdxv = new FrameLayout(context);
        addView(this.zzdxv, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbazVar.zzyo());
        this.zzdxz = zzbazVar.zzyo().zzbkp.zza(context, zzbazVar, i, z, zzaaeVar, zzbawVar);
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar != null) {
            this.zzdxv.addView(zzbagVar, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzchc)).booleanValue()) {
                zzya();
            }
        }
        this.zzdyj = new ImageView(context);
        this.zzdxy = ((Long) zzve.zzoy().zzd(zzzn.zzchg)).longValue();
        this.zzdyd = ((Boolean) zzve.zzoy().zzd(zzzn.zzche)).booleanValue();
        zzaae zzaaeVar2 = this.zzdxw;
        if (zzaaeVar2 != null) {
            zzaaeVar2.zzh("spinner_used", this.zzdyd ? "1" : "0");
        }
        this.zzdxx = new zzbbb(this);
        zzbag zzbagVar2 = this.zzdxz;
        if (zzbagVar2 != null) {
            zzbagVar2.zza(this);
        }
        if (this.zzdxz == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzbaz zzbazVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzbazVar.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbaz zzbazVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzbazVar.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbaz zzbazVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbazVar.zza("onVideoEvent", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzdxu.zza("onVideoEvent", hashMap);
    }

    private final boolean zzyc() {
        return this.zzdyj.getParent() != null;
    }

    private final void zzyd() {
        if (this.zzdxu.zzyn() == null || !this.zzdyb || this.zzdyc) {
            return;
        }
        this.zzdxu.zzyn().getWindow().clearFlags(128);
        this.zzdyb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        long currentPosition = zzbagVar.getCurrentPosition();
        if (this.zzdye == currentPosition || currentPosition <= 0) {
            return;
        }
        zzd("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
        this.zzdye = currentPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void destroy() {
        this.zzdxx.pause();
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar != null) {
            zzbagVar.stop();
        }
        zzyd();
    }

    public final void finalize() {
        try {
            this.zzdxx.pause();
            if (this.zzdxz != null) {
                zzbag zzbagVar = this.zzdxz;
                zzdhd zzdhdVar = zzazd.zzdwi;
                zzbagVar.getClass();
                zzdhdVar.execute(zzbal.a(zzbagVar));
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void onPaused() {
        zzd("pause", new String[0]);
        zzyd();
        this.zzdya = false;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        zzbbb zzbbbVar = this.zzdxx;
        if (z) {
            zzbbbVar.resume();
        } else {
            zzbbbVar.pause();
            this.zzdyf = this.zzdye;
        }
        zzawb.zzdsr.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzbak
            private final zzbai zzdyl;
            private final boolean zzdym;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdyl = this;
                this.zzdym = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdyl.a(this.zzdym);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbah
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzdxx.resume();
            z = true;
        } else {
            this.zzdxx.pause();
            this.zzdyf = this.zzdye;
            z = false;
        }
        zzawb.zzdsr.post(new zzbap(this, z));
    }

    public final void pause() {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.pause();
    }

    public final void play() {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.play();
    }

    public final void seekTo(int i) {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.seekTo(i);
    }

    public final void setVolume(float f) {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.b.setVolume(f);
        zzbagVar.zzxs();
    }

    public final void zza(float f, float f2) {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar != null) {
            zzbagVar.zza(f, f2);
        }
    }

    public final void zzc(String str, String[] strArr) {
        this.zzdyg = str;
        this.zzdyh = strArr;
    }

    public final void zzcv(int i) {
        this.zzdxz.zzcv(i);
    }

    public final void zzcw(int i) {
        this.zzdxz.zzcw(i);
    }

    public final void zzcx(int i) {
        this.zzdxz.zzcx(i);
    }

    public final void zzcy(int i) {
        this.zzdxz.zzcy(i);
    }

    public final void zzcz(int i) {
        this.zzdxz.zzcz(i);
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzdxv.setLayoutParams(layoutParams);
        requestLayout();
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.dispatchTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzer() {
        if (this.zzdxz != null && this.zzdyf == 0) {
            zzd("canplaythrough", "duration", String.valueOf(r0.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzdxz.getVideoWidth()), "videoHeight", String.valueOf(this.zzdxz.getVideoHeight()));
        }
    }

    public final void zzhq() {
        if (this.zzdxz == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzdyg)) {
            zzd("no_src", new String[0]);
        } else {
            this.zzdxz.zzb(this.zzdyg, this.zzdyh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzk(int i, int i2) {
        if (this.zzdyd) {
            int max = Math.max(i / ((Integer) zzve.zzoy().zzd(zzzn.zzchf)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzve.zzoy().zzd(zzzn.zzchf)).intValue(), 1);
            Bitmap bitmap = this.zzdyi;
            if (bitmap != null && bitmap.getWidth() == max && this.zzdyi.getHeight() == max2) {
                return;
            }
            this.zzdyi = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.zzdyk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzm(String str, @Nullable String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzxt() {
        this.zzdxx.resume();
        zzawb.zzdsr.post(new zzban(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzxu() {
        if (this.zzdxu.zzyn() != null && !this.zzdyb) {
            this.zzdyc = (this.zzdxu.zzyn().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzdyc) {
                this.zzdxu.zzyn().getWindow().addFlags(128);
                this.zzdyb = true;
            }
        }
        this.zzdya = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzxv() {
        zzd("ended", new String[0]);
        zzyd();
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzxw() {
        if (this.zzdyk && this.zzdyi != null && !zzyc()) {
            this.zzdyj.setImageBitmap(this.zzdyi);
            this.zzdyj.invalidate();
            this.zzdxv.addView(this.zzdyj, new FrameLayout.LayoutParams(-1, -1));
            this.zzdxv.bringChildToFront(this.zzdyj);
        }
        this.zzdxx.pause();
        this.zzdyf = this.zzdye;
        zzawb.zzdsr.post(new zzbam(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbah
    public final void zzxx() {
        if (this.zzdya && zzyc()) {
            this.zzdxv.removeView(this.zzdyj);
        }
        if (this.zzdyi != null) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
            if (this.zzdxz.getBitmap(this.zzdyi) != null) {
                this.zzdyk = true;
            }
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - elapsedRealtime;
            if (zzavs.zzvs()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzavs.zzed(sb.toString());
            }
            if (elapsedRealtime2 > this.zzdxy) {
                zzayu.zzez("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzdyd = false;
                this.zzdyi = null;
                zzaae zzaaeVar = this.zzdxw;
                if (zzaaeVar != null) {
                    zzaaeVar.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzxy() {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.b.setMuted(true);
        zzbagVar.zzxs();
    }

    public final void zzxz() {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        zzbagVar.b.setMuted(false);
        zzbagVar.zzxs();
    }

    @TargetApi(14)
    public final void zzya() {
        zzbag zzbagVar = this.zzdxz;
        if (zzbagVar == null) {
            return;
        }
        TextView textView = new TextView(zzbagVar.getContext());
        String valueOf = String.valueOf(this.zzdxz.zzxo());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzdxv.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzdxv.bringChildToFront(textView);
    }
}
