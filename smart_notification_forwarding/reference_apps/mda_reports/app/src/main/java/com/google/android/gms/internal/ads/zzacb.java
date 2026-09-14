package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzacb extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzcvf = new ArrayList();
    private final zzaca zzcvq;

    public zzacb(zzaca zzacaVar) {
        zzaci zzaciVar;
        IBinder iBinder;
        this.zzcvq = zzacaVar;
        try {
            this.text = this.zzcvq.getText();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            this.text = "";
        }
        try {
            for (zzaci zzaciVar2 : zzacaVar.zzqx()) {
                if (!(zzaciVar2 instanceof IBinder) || (iBinder = (IBinder) zzaciVar2) == null) {
                    zzaciVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaciVar = queryLocalInterface instanceof zzaci ? (zzaci) queryLocalInterface : new zzack(iBinder);
                }
                if (zzaciVar != null) {
                    this.zzcvf.add(new zzacj(zzaciVar));
                }
            }
        } catch (RemoteException e2) {
            zzayu.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzcvf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }
}
