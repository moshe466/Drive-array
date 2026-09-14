package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbws {
    private Bundle extras;
    private zzaca zzcvq;
    private List<?> zzeim;
    private double zzeip;
    private float zzejb;

    @Nullable
    private IObjectWrapper zzffd;
    private int zzflz;
    private zzxb zzfma;
    private View zzfmb;
    private zzxy zzfmc;
    private zzbdi zzfmd;

    @Nullable
    private zzbdi zzfme;
    private View zzfmf;
    private IObjectWrapper zzfmg;
    private zzaci zzfmh;
    private zzaci zzfmi;
    private String zzfmj;

    @Nullable
    private String zzfmm;
    private SimpleArrayMap<String, zzabu> zzfmk = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzfml = new SimpleArrayMap<>();
    private List<zzxy> zzcwf = Collections.emptyList();

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzejb = f;
    }

    public static zzbws zza(zzall zzallVar) {
        try {
            zzxb videoController = zzallVar.getVideoController();
            zzaca zzrh = zzallVar.zzrh();
            View view = (View) zzar(zzallVar.zzsu());
            String headline = zzallVar.getHeadline();
            List<?> images = zzallVar.getImages();
            String body = zzallVar.getBody();
            Bundle extras = zzallVar.getExtras();
            String callToAction = zzallVar.getCallToAction();
            View view2 = (View) zzar(zzallVar.zzsv());
            IObjectWrapper zzri = zzallVar.zzri();
            String store = zzallVar.getStore();
            String price = zzallVar.getPrice();
            double starRating = zzallVar.getStarRating();
            zzaci zzrg = zzallVar.zzrg();
            zzbws zzbwsVar = new zzbws();
            zzbwsVar.zzflz = 2;
            zzbwsVar.zzfma = videoController;
            zzbwsVar.zzcvq = zzrh;
            zzbwsVar.zzfmb = view;
            zzbwsVar.zzn("headline", headline);
            zzbwsVar.zzeim = images;
            zzbwsVar.zzn("body", body);
            zzbwsVar.extras = extras;
            zzbwsVar.zzn("call_to_action", callToAction);
            zzbwsVar.zzfmf = view2;
            zzbwsVar.zzfmg = zzri;
            zzbwsVar.zzn("store", store);
            zzbwsVar.zzn(FirebaseAnalytics.Param.PRICE, price);
            zzbwsVar.zzeip = starRating;
            zzbwsVar.zzfmh = zzrg;
            return zzbwsVar;
        } catch (RemoteException e) {
            zzayu.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzbws zza(zzalq zzalqVar) {
        try {
            zzxb videoController = zzalqVar.getVideoController();
            zzaca zzrh = zzalqVar.zzrh();
            View view = (View) zzar(zzalqVar.zzsu());
            String headline = zzalqVar.getHeadline();
            List<?> images = zzalqVar.getImages();
            String body = zzalqVar.getBody();
            Bundle extras = zzalqVar.getExtras();
            String callToAction = zzalqVar.getCallToAction();
            View view2 = (View) zzar(zzalqVar.zzsv());
            IObjectWrapper zzri = zzalqVar.zzri();
            String advertiser = zzalqVar.getAdvertiser();
            zzaci zzrj = zzalqVar.zzrj();
            zzbws zzbwsVar = new zzbws();
            zzbwsVar.zzflz = 1;
            zzbwsVar.zzfma = videoController;
            zzbwsVar.zzcvq = zzrh;
            zzbwsVar.zzfmb = view;
            zzbwsVar.zzn("headline", headline);
            zzbwsVar.zzeim = images;
            zzbwsVar.zzn("body", body);
            zzbwsVar.extras = extras;
            zzbwsVar.zzn("call_to_action", callToAction);
            zzbwsVar.zzfmf = view2;
            zzbwsVar.zzfmg = zzri;
            zzbwsVar.zzn("advertiser", advertiser);
            zzbwsVar.zzfmi = zzrj;
            return zzbwsVar;
        } catch (RemoteException e) {
            zzayu.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    private static zzbws zza(zzxb zzxbVar, zzaca zzacaVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaci zzaciVar, String str6, float f) {
        zzbws zzbwsVar = new zzbws();
        zzbwsVar.zzflz = 6;
        zzbwsVar.zzfma = zzxbVar;
        zzbwsVar.zzcvq = zzacaVar;
        zzbwsVar.zzfmb = view;
        zzbwsVar.zzn("headline", str);
        zzbwsVar.zzeim = list;
        zzbwsVar.zzn("body", str2);
        zzbwsVar.extras = bundle;
        zzbwsVar.zzn("call_to_action", str3);
        zzbwsVar.zzfmf = view2;
        zzbwsVar.zzfmg = iObjectWrapper;
        zzbwsVar.zzn("store", str4);
        zzbwsVar.zzn(FirebaseAnalytics.Param.PRICE, str5);
        zzbwsVar.zzeip = d;
        zzbwsVar.zzfmh = zzaciVar;
        zzbwsVar.zzn("advertiser", str6);
        zzbwsVar.setMediaContentAspectRatio(f);
        return zzbwsVar;
    }

    private static <T> T zzar(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzbws zzb(zzall zzallVar) {
        try {
            return zza(zzallVar.getVideoController(), zzallVar.zzrh(), (View) zzar(zzallVar.zzsu()), zzallVar.getHeadline(), zzallVar.getImages(), zzallVar.getBody(), zzallVar.getExtras(), zzallVar.getCallToAction(), (View) zzar(zzallVar.zzsv()), zzallVar.zzri(), zzallVar.getStore(), zzallVar.getPrice(), zzallVar.getStarRating(), zzallVar.zzrg(), null, 0.0f);
        } catch (RemoteException e) {
            zzayu.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzbws zzb(zzalq zzalqVar) {
        try {
            return zza(zzalqVar.getVideoController(), zzalqVar.zzrh(), (View) zzar(zzalqVar.zzsu()), zzalqVar.getHeadline(), zzalqVar.getImages(), zzalqVar.getBody(), zzalqVar.getExtras(), zzalqVar.getCallToAction(), (View) zzar(zzalqVar.zzsv()), zzalqVar.zzri(), null, null, -1.0d, zzalqVar.zzrj(), zzalqVar.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzayu.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    public static zzbws zzb(zzalr zzalrVar) {
        try {
            return zza(zzalrVar.getVideoController(), zzalrVar.zzrh(), (View) zzar(zzalrVar.zzsu()), zzalrVar.getHeadline(), zzalrVar.getImages(), zzalrVar.getBody(), zzalrVar.getExtras(), zzalrVar.getCallToAction(), (View) zzar(zzalrVar.zzsv()), zzalrVar.zzri(), zzalrVar.getStore(), zzalrVar.getPrice(), zzalrVar.getStarRating(), zzalrVar.zzrg(), zzalrVar.getAdvertiser(), zzalrVar.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzayu.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    private final synchronized String zzfy(String str) {
        return this.zzfml.get(str);
    }

    public final synchronized void destroy() {
        if (this.zzfmd != null) {
            this.zzfmd.destroy();
            this.zzfmd = null;
        }
        if (this.zzfme != null) {
            this.zzfme.destroy();
            this.zzfme = null;
        }
        this.zzffd = null;
        this.zzfmk.clear();
        this.zzfml.clear();
        this.zzfma = null;
        this.zzcvq = null;
        this.zzfmb = null;
        this.zzeim = null;
        this.extras = null;
        this.zzfmf = null;
        this.zzfmg = null;
        this.zzfmh = null;
        this.zzfmi = null;
        this.zzfmj = null;
    }

    public final synchronized String getAdvertiser() {
        return zzfy("advertiser");
    }

    public final synchronized String getBody() {
        return zzfy("body");
    }

    public final synchronized String getCallToAction() {
        return zzfy("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzfmj;
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getHeadline() {
        return zzfy("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzeim;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzejb;
    }

    public final synchronized List<zzxy> getMuteThisAdReasons() {
        return this.zzcwf;
    }

    public final synchronized String getPrice() {
        return zzfy(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized double getStarRating() {
        return this.zzeip;
    }

    public final synchronized String getStore() {
        return zzfy("store");
    }

    public final synchronized zzxb getVideoController() {
        return this.zzfma;
    }

    public final synchronized void setImages(List<zzabu> list) {
        this.zzeim = list;
    }

    public final synchronized void setStarRating(double d) {
        this.zzeip = d;
    }

    public final synchronized void zza(zzaca zzacaVar) {
        this.zzcvq = zzacaVar;
    }

    public final synchronized void zza(zzaci zzaciVar) {
        this.zzfmh = zzaciVar;
    }

    public final synchronized void zza(@Nullable zzxy zzxyVar) {
        this.zzfmc = zzxyVar;
    }

    public final synchronized void zza(String str, zzabu zzabuVar) {
        if (zzabuVar == null) {
            this.zzfmk.remove(str);
        } else {
            this.zzfmk.put(str, zzabuVar);
        }
    }

    public final synchronized void zzab(View view) {
        this.zzfmf = view;
    }

    public final synchronized int zzaja() {
        return this.zzflz;
    }

    public final synchronized View zzajb() {
        return this.zzfmb;
    }

    @Nullable
    public final zzaci zzajc() {
        List<?> list = this.zzeim;
        if (list != null && list.size() != 0) {
            Object obj = this.zzeim.get(0);
            if (obj instanceof IBinder) {
                return zzach.zzm((IBinder) obj);
            }
        }
        return null;
    }

    @Nullable
    public final synchronized zzxy zzajd() {
        return this.zzfmc;
    }

    public final synchronized View zzaje() {
        return this.zzfmf;
    }

    public final synchronized zzbdi zzajf() {
        return this.zzfmd;
    }

    @Nullable
    public final synchronized zzbdi zzajg() {
        return this.zzfme;
    }

    @Nullable
    public final synchronized IObjectWrapper zzajh() {
        return this.zzffd;
    }

    public final synchronized SimpleArrayMap<String, zzabu> zzaji() {
        return this.zzfmk;
    }

    @Nullable
    public final synchronized String zzajj() {
        return this.zzfmm;
    }

    public final synchronized SimpleArrayMap<String, String> zzajk() {
        return this.zzfml;
    }

    public final synchronized void zzaq(IObjectWrapper iObjectWrapper) {
        this.zzffd = iObjectWrapper;
    }

    public final synchronized void zzb(zzaci zzaciVar) {
        this.zzfmi = zzaciVar;
    }

    public final synchronized void zzb(zzxb zzxbVar) {
        this.zzfma = zzxbVar;
    }

    public final synchronized void zzdj(int i) {
        this.zzflz = i;
    }

    public final synchronized void zzf(List<zzxy> list) {
        this.zzcwf = list;
    }

    public final synchronized void zzfw(String str) {
        this.zzfmj = str;
    }

    public final synchronized void zzfx(@Nullable String str) {
        this.zzfmm = str;
    }

    public final synchronized void zzi(zzbdi zzbdiVar) {
        this.zzfmd = zzbdiVar;
    }

    public final synchronized void zzj(zzbdi zzbdiVar) {
        this.zzfme = zzbdiVar;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzfml.remove(str);
        } else {
            this.zzfml.put(str, str2);
        }
    }

    public final synchronized zzaci zzrg() {
        return this.zzfmh;
    }

    public final synchronized zzaca zzrh() {
        return this.zzcvq;
    }

    public final synchronized IObjectWrapper zzri() {
        return this.zzfmg;
    }

    public final synchronized zzaci zzrj() {
        return this.zzfmi;
    }
}
