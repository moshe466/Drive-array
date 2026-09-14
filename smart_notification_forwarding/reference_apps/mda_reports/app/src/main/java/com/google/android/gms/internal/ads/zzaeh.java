package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaeh extends UnifiedNativeAd {
    private final zzacj zzcvw;
    private final NativeAd.AdChoicesInfo zzcvx;
    private final zzaeg zzcwe;
    private final List<NativeAd.Image> zzcvv = new ArrayList();
    private final VideoController zzcel = new VideoController();
    private final List<MuteThisAdReason> zzcwf = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(3:2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6)))|24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28))|41|42|(7:44|45|46|47|(2:49|50)|52|53)|58|45|46|47|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bf, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:
    
        com.google.android.gms.internal.ads.zzayu.zzc("", r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[Catch: RemoteException -> 0x00bf, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00bf, blocks: (B:47:0x00aa, B:49:0x00b2), top: B:46:0x00aa }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzaeh(com.google.android.gms.internal.ads.zzaeg r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzcvv = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzcel = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzcwf = r1
            r5.zzcwe = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzaeg r1 = r5.zzcwe     // Catch: android.os.RemoteException -> L5e
            java.util.List r1 = r1.getImages()     // Catch: android.os.RemoteException -> L5e
            if (r1 == 0) goto L62
            java.util.Iterator r1 = r1.iterator()     // Catch: android.os.RemoteException -> L5e
        L29:
            boolean r2 = r1.hasNext()     // Catch: android.os.RemoteException -> L5e
            if (r2 == 0) goto L62
            java.lang.Object r2 = r1.next()     // Catch: android.os.RemoteException -> L5e
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L5e
            if (r3 == 0) goto L50
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L5e
            if (r2 == 0) goto L50
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch: android.os.RemoteException -> L5e
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaci     // Catch: android.os.RemoteException -> L5e
            if (r4 == 0) goto L49
            r2 = r3
            com.google.android.gms.internal.ads.zzaci r2 = (com.google.android.gms.internal.ads.zzaci) r2     // Catch: android.os.RemoteException -> L5e
            goto L51
        L49:
            com.google.android.gms.internal.ads.zzack r3 = new com.google.android.gms.internal.ads.zzack     // Catch: android.os.RemoteException -> L5e
            r3.<init>(r2)     // Catch: android.os.RemoteException -> L5e
            r2 = r3
            goto L51
        L50:
            r2 = r6
        L51:
            if (r2 == 0) goto L29
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.zzcvv     // Catch: android.os.RemoteException -> L5e
            com.google.android.gms.internal.ads.zzacj r4 = new com.google.android.gms.internal.ads.zzacj     // Catch: android.os.RemoteException -> L5e
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L5e
            r3.add(r4)     // Catch: android.os.RemoteException -> L5e
            goto L29
        L5e:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        L62:
            com.google.android.gms.internal.ads.zzaeg r1 = r5.zzcwe     // Catch: android.os.RemoteException -> L91
            java.util.List r1 = r1.getMuteThisAdReasons()     // Catch: android.os.RemoteException -> L91
            if (r1 == 0) goto L95
            java.util.Iterator r1 = r1.iterator()     // Catch: android.os.RemoteException -> L91
        L6e:
            boolean r2 = r1.hasNext()     // Catch: android.os.RemoteException -> L91
            if (r2 == 0) goto L95
            java.lang.Object r2 = r1.next()     // Catch: android.os.RemoteException -> L91
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L91
            if (r3 == 0) goto L83
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L91
            com.google.android.gms.internal.ads.zzwr r2 = com.google.android.gms.internal.ads.zzwu.zzg(r2)     // Catch: android.os.RemoteException -> L91
            goto L84
        L83:
            r2 = r6
        L84:
            if (r2 == 0) goto L6e
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzcwf     // Catch: android.os.RemoteException -> L91
            com.google.android.gms.internal.ads.zzww r4 = new com.google.android.gms.internal.ads.zzww     // Catch: android.os.RemoteException -> L91
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L91
            r3.add(r4)     // Catch: android.os.RemoteException -> L91
            goto L6e
        L91:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        L95:
            com.google.android.gms.internal.ads.zzaeg r1 = r5.zzcwe     // Catch: android.os.RemoteException -> La3
            com.google.android.gms.internal.ads.zzaci r1 = r1.zzrg()     // Catch: android.os.RemoteException -> La3
            if (r1 == 0) goto La7
            com.google.android.gms.internal.ads.zzacj r2 = new com.google.android.gms.internal.ads.zzacj     // Catch: android.os.RemoteException -> La3
            r2.<init>(r1)     // Catch: android.os.RemoteException -> La3
            goto La8
        La3:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        La7:
            r2 = r6
        La8:
            r5.zzcvw = r2
            com.google.android.gms.internal.ads.zzaeg r1 = r5.zzcwe     // Catch: android.os.RemoteException -> Lbf
            com.google.android.gms.internal.ads.zzaca r1 = r1.zzrh()     // Catch: android.os.RemoteException -> Lbf
            if (r1 == 0) goto Lc3
            com.google.android.gms.internal.ads.zzacb r1 = new com.google.android.gms.internal.ads.zzacb     // Catch: android.os.RemoteException -> Lbf
            com.google.android.gms.internal.ads.zzaeg r2 = r5.zzcwe     // Catch: android.os.RemoteException -> Lbf
            com.google.android.gms.internal.ads.zzaca r2 = r2.zzrh()     // Catch: android.os.RemoteException -> Lbf
            r1.<init>(r2)     // Catch: android.os.RemoteException -> Lbf
            r6 = r1
            goto Lc3
        Lbf:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        Lc3:
            r5.zzcvx = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeh.<init>(com.google.android.gms.internal.ads.zzaeg):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: zzrf, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper a() {
        try {
            return this.zzcwe.zzrf();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzcwe.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzayu.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzcwe.destroy();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzcwe.zzrp();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzcvx;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzcwe.getAdvertiser();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzcwe.getBody();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzcwe.getCallToAction();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzcwe.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzcwe.getHeadline();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzcvw;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzcvv;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final UnifiedNativeAd.MediaContent getMediaContent() {
        try {
            if (this.zzcwe.zzrq() != null) {
                return new zzaek(this.zzcwe.zzrq());
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzcwe.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzcwf;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzcwe.getPrice();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzcwe.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzcwe.getStore();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzcwe.getVideoController() != null) {
                this.zzcel.zza(this.zzcwe.getVideoController());
            }
        } catch (RemoteException e) {
            zzayu.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcel;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzcwe.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzcwe.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzayu.zzex("Ad is not custom mute enabled");
                return;
            }
            if (muteThisAdReason == null) {
                this.zzcwe.zza((zzwr) null);
            } else if (muteThisAdReason instanceof zzww) {
                this.zzcwe.zza(((zzww) muteThisAdReason).zzpi());
            } else {
                zzayu.zzex("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzcwe.performClick(bundle);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzcwe.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzcwe.recordImpression(bundle);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzcwe.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzcwe.zza(new zzws(muteThisAdListener));
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzcwe.zza(new zzaeu(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzayu.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzjo() {
        try {
            IObjectWrapper zzri = this.zzcwe.zzri();
            if (zzri != null) {
                return ObjectWrapper.unwrap(zzri);
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            return null;
        }
    }
}
