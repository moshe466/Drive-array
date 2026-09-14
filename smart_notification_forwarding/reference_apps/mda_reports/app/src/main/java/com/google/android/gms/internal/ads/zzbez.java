package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* loaded from: classes.dex */
public final class zzbez extends MutableContextWrapper {
    private Activity zzdvo;
    private Context zzehs;
    private Context zzyv;

    public zzbez(Context context) {
        super(context);
        setBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.zzehs.getSystemService(str);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        this.zzyv = context.getApplicationContext();
        this.zzdvo = context instanceof Activity ? (Activity) context : null;
        this.zzehs = context;
        super.setBaseContext(this.zzyv);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        Activity activity = this.zzdvo;
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.setFlags(268435456);
            this.zzyv.startActivity(intent);
        }
    }

    public final Activity zzyn() {
        return this.zzdvo;
    }

    public final Context zzzv() {
        return this.zzehs;
    }
}
