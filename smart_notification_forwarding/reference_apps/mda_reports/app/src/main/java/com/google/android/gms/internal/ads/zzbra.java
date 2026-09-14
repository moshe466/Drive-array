package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbra extends zzbrl<AppEventListener> implements zzaey {
    public zzbra(Set<zzbsu<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzaey
    public final synchronized void onAppEvent(final String str, final String str2) {
        a(new zzbrn(str, str2) { // from class: com.google.android.gms.internal.ads.zzbrd
            private final String zzcyr;
            private final String zzcyz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = str;
                this.zzcyr = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.zzcyz, this.zzcyr);
            }
        });
    }
}
