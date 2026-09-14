package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaot;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzve;

@KeepForSdk
/* loaded from: classes.dex */
public final class AdActivity extends Activity {

    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";

    @KeepForSdk
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzaot zzaaz;

    private final void zzdf() {
        zzaot zzaotVar = this.zzaaz;
        if (zzaotVar != null) {
            try {
                zzaotVar.zzdf();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzaaz.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzaaz != null) {
                z = this.zzaaz.zztm();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzaaz.zzad(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzaaz = zzve.zzov().zzb(this);
        zzaot zzaotVar = this.zzaaz;
        if (zzaotVar == null) {
            e = null;
        } else {
            try {
                zzaotVar.onCreate(bundle);
                return;
            } catch (RemoteException e) {
                e = e;
            }
        }
        zzayu.zze("#007 Could not call remote method.", e);
        finish();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onDestroy();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onPause();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onRestart();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onResume();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onStart();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            if (this.zzaaz != null) {
                this.zzaaz.onStop();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zzdf();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zzdf();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdf();
    }
}
