package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.logging.type.LogSeverity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
/* loaded from: classes.dex */
public final class zzazx extends zzbag implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzdwx = new HashMap();
    private final zzbay zzdwy;
    private final boolean zzdwz;
    private int zzdxa;
    private int zzdxb;
    private MediaPlayer zzdxc;
    private Uri zzdxd;
    private int zzdxe;
    private int zzdxf;
    private int zzdxg;
    private int zzdxh;
    private int zzdxi;
    private zzbax zzdxj;
    private boolean zzdxk;
    private int zzdxl;
    private zzbah zzdxm;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzdwx.put(-1004, "MEDIA_ERROR_IO");
            zzdwx.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzdwx.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzdwx.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzdwx.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzdwx.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzdwx.put(1, "MEDIA_ERROR_UNKNOWN");
        zzdwx.put(1, "MEDIA_INFO_UNKNOWN");
        zzdwx.put(Integer.valueOf(LogSeverity.ALERT_VALUE), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzdwx.put(701, "MEDIA_INFO_BUFFERING_START");
        zzdwx.put(702, "MEDIA_INFO_BUFFERING_END");
        zzdwx.put(Integer.valueOf(LogSeverity.EMERGENCY_VALUE), "MEDIA_INFO_BAD_INTERLEAVING");
        zzdwx.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzdwx.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzdwx.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzdwx.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzazx(Context context, boolean z, boolean z2, zzbaw zzbawVar, zzbay zzbayVar) {
        super(context);
        this.zzdxa = 0;
        this.zzdxb = 0;
        setSurfaceTextureListener(this);
        this.zzdwy = zzbayVar;
        this.zzdxk = z;
        this.zzdwz = z2;
        this.zzdwy.zzb(this);
    }

    private final void zzat(boolean z) {
        zzavs.zzed("AdMediaPlayerView release");
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzyf();
            this.zzdxj = null;
        }
        MediaPlayer mediaPlayer = this.zzdxc;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzdxc.release();
            this.zzdxc = null;
            zzct(0);
            if (z) {
                this.zzdxb = 0;
                this.zzdxb = 0;
            }
        }
    }

    private final void zzct(int i) {
        if (i == 3) {
            this.zzdwy.zzyi();
            this.b.zzyi();
        } else if (this.zzdxa == 3) {
            this.zzdwy.zzyj();
            this.b.zzyj();
        }
        this.zzdxa = i;
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzdxc;
        if (mediaPlayer == null) {
            zzayu.zzez("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        }
    }

    private final void zzxp() {
        zzavs.zzed("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzdxd == null || surfaceTexture == null) {
            return;
        }
        zzat(false);
        try {
            com.google.android.gms.ads.internal.zzq.zzlg();
            this.zzdxc = new MediaPlayer();
            this.zzdxc.setOnBufferingUpdateListener(this);
            this.zzdxc.setOnCompletionListener(this);
            this.zzdxc.setOnErrorListener(this);
            this.zzdxc.setOnInfoListener(this);
            this.zzdxc.setOnPreparedListener(this);
            this.zzdxc.setOnVideoSizeChangedListener(this);
            this.zzdxg = 0;
            if (this.zzdxk) {
                this.zzdxj = new zzbax(getContext());
                this.zzdxj.zza(surfaceTexture, getWidth(), getHeight());
                this.zzdxj.start();
                SurfaceTexture zzyg = this.zzdxj.zzyg();
                if (zzyg != null) {
                    surfaceTexture = zzyg;
                } else {
                    this.zzdxj.zzyf();
                    this.zzdxj = null;
                }
            }
            this.zzdxc.setDataSource(getContext(), this.zzdxd);
            com.google.android.gms.ads.internal.zzq.zzlh();
            this.zzdxc.setSurface(new Surface(surfaceTexture));
            this.zzdxc.setAudioStreamType(3);
            this.zzdxc.setScreenOnWhilePlaying(true);
            this.zzdxc.prepareAsync();
            zzct(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            String valueOf = String.valueOf(this.zzdxd);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(valueOf);
            zzayu.zzd(sb.toString(), e);
            onError(this.zzdxc, 1, 0);
        }
    }

    private final void zzxq() {
        if (this.zzdwz && zzxr() && this.zzdxc.getCurrentPosition() > 0 && this.zzdxb != 3) {
            zzavs.zzed("AdMediaPlayerView nudging MediaPlayer");
            zzd(0.0f);
            this.zzdxc.start();
            int currentPosition = this.zzdxc.getCurrentPosition();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
            while (zzxr() && this.zzdxc.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis() - currentTimeMillis <= 250) {
            }
            this.zzdxc.pause();
            zzxs();
        }
    }

    private final boolean zzxr() {
        int i;
        return (this.zzdxc == null || (i = this.zzdxa) == -1 || i == 0 || i == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i) {
        zzbah zzbahVar = this.zzdxm;
        if (zzbahVar != null) {
            zzbahVar.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getCurrentPosition() {
        if (zzxr()) {
            return this.zzdxc.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getDuration() {
        if (zzxr()) {
            return this.zzdxc.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzdxc;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzdxc;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzdxg = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzavs.zzed("AdMediaPlayerView completion");
        zzct(5);
        this.zzdxb = 5;
        zzawb.zzdsr.post(new zzazy(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzdwx.get(Integer.valueOf(i));
        String str2 = zzdwx.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzayu.zzez(sb.toString());
        zzct(-1);
        this.zzdxb = -1;
        zzawb.zzdsr.post(new zzbab(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzdwx.get(Integer.valueOf(i));
        String str2 = zzdwx.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzavs.zzed(sb.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzdxe
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.zzdxf
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.zzdxe
            if (r2 <= 0) goto L88
            int r2 = r5.zzdxf
            if (r2 <= 0) goto L88
            com.google.android.gms.internal.ads.zzbax r2 = r5.zzdxj
            if (r2 != 0) goto L88
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L48
            if (r1 != r2) goto L48
            int r0 = r5.zzdxe
            int r1 = r0 * r7
            int r2 = r5.zzdxf
            int r3 = r6 * r2
            if (r1 >= r3) goto L3d
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            goto L88
        L3d:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L69
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L89
        L48:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L5a
            int r0 = r5.zzdxf
            int r0 = r0 * r6
            int r2 = r5.zzdxe
            int r0 = r0 / r2
            if (r1 != r3) goto L58
            if (r0 <= r7) goto L58
            goto L67
        L58:
            r1 = r0
            goto L89
        L5a:
            if (r1 != r2) goto L6b
            int r1 = r5.zzdxe
            int r1 = r1 * r7
            int r2 = r5.zzdxf
            int r1 = r1 / r2
            if (r0 != r3) goto L68
            if (r1 <= r6) goto L68
        L67:
            goto L69
        L68:
            r6 = r1
        L69:
            r1 = r7
            goto L89
        L6b:
            int r2 = r5.zzdxe
            int r4 = r5.zzdxf
            if (r1 != r3) goto L78
            if (r4 <= r7) goto L78
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L79
        L78:
            r1 = r4
        L79:
            if (r0 != r3) goto L86
            if (r2 <= r6) goto L86
            int r7 = r5.zzdxf
            int r7 = r7 * r6
            int r0 = r5.zzdxe
            int r1 = r7 / r0
            goto L89
        L86:
            r6 = r2
            goto L89
        L88:
            r6 = r0
        L89:
            r5.setMeasuredDimension(r6, r1)
            com.google.android.gms.internal.ads.zzbax r7 = r5.zzdxj
            if (r7 == 0) goto L93
            r7.zzm(r6, r1)
        L93:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r7 != r0) goto Lac
            int r7 = r5.zzdxh
            if (r7 <= 0) goto L9f
            if (r7 != r6) goto La5
        L9f:
            int r7 = r5.zzdxi
            if (r7 <= 0) goto La8
            if (r7 == r1) goto La8
        La5:
            r5.zzxq()
        La8:
            r5.zzdxh = r6
            r5.zzdxi = r1
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazx.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzavs.zzed("AdMediaPlayerView prepared");
        zzct(2);
        this.zzdwy.zzer();
        zzawb.zzdsr.post(new zzazz(this));
        this.zzdxe = mediaPlayer.getVideoWidth();
        this.zzdxf = mediaPlayer.getVideoHeight();
        int i = this.zzdxl;
        if (i != 0) {
            seekTo(i);
        }
        zzxq();
        int i2 = this.zzdxe;
        int i3 = this.zzdxf;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzayu.zzey(sb.toString());
        if (this.zzdxb == 3) {
            play();
        }
        zzxs();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzavs.zzed("AdMediaPlayerView surface created");
        zzxp();
        zzawb.zzdsr.post(new zzbaa(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzavs.zzed("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzdxc;
        if (mediaPlayer != null && this.zzdxl == 0) {
            this.zzdxl = mediaPlayer.getCurrentPosition();
        }
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzyf();
        }
        zzawb.zzdsr.post(new zzbac(this));
        zzat(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzavs.zzed("AdMediaPlayerView surface changed");
        boolean z = this.zzdxb == 3;
        boolean z2 = this.zzdxe == i && this.zzdxf == i2;
        if (this.zzdxc != null && z && z2) {
            int i3 = this.zzdxl;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbax zzbaxVar = this.zzdxj;
        if (zzbaxVar != null) {
            zzbaxVar.zzm(i, i2);
        }
        zzawb.zzdsr.post(new zzbad(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzdwy.zzc(this);
        this.a.zza(surfaceTexture, this.zzdxm);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzavs.zzed(sb.toString());
        this.zzdxe = mediaPlayer.getVideoWidth();
        this.zzdxf = mediaPlayer.getVideoHeight();
        if (this.zzdxe == 0 || this.zzdxf == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzavs.zzed(sb.toString());
        zzawb.zzdsr.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzazw
            private final int zzdtf;
            private final zzazx zzdww;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdww = this;
                this.zzdtf = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdww.a(this.zzdtf);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void pause() {
        zzavs.zzed("AdMediaPlayerView pause");
        if (zzxr() && this.zzdxc.isPlaying()) {
            this.zzdxc.pause();
            zzct(4);
            zzawb.zzdsr.post(new zzbae(this));
        }
        this.zzdxb = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void play() {
        zzavs.zzed("AdMediaPlayerView play");
        if (zzxr()) {
            this.zzdxc.start();
            zzct(3);
            this.a.zzxu();
            zzawb.zzdsr.post(new zzbaf(this));
        }
        this.zzdxb = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzavs.zzed(sb.toString());
        if (!zzxr()) {
            this.zzdxl = i;
        } else {
            this.zzdxc.seekTo(i);
            this.zzdxl = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzry zzd = zzry.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzdxd = parse;
            this.zzdxl = 0;
            zzxp();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbag
    public final void stop() {
        zzavs.zzed("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzdxc;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzdxc.release();
            this.zzdxc = null;
            zzct(0);
            this.zzdxb = 0;
        }
        this.zzdwy.onStop();
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzazx.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
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

    @Override // com.google.android.gms.internal.ads.zzbag
    public final String zzxo() {
        String str = this.zzdxk ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbag, com.google.android.gms.internal.ads.zzbbd
    public final void zzxs() {
        zzd(this.b.getVolume());
    }
}
