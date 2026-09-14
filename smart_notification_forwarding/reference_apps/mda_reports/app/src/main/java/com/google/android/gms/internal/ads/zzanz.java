package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzanz extends zzaoo {
    private final Map<String, String> zzcsd;
    private String zzdez;
    private long zzdfa;
    private long zzdfb;
    private String zzdfc;
    private String zzdfd;
    private final Context zzup;

    public zzanz(zzbdi zzbdiVar, Map<String, String> map) {
        super(zzbdiVar, "createCalendarEvent");
        this.zzcsd = map;
        this.zzup = zzbdiVar.zzyn();
        this.zzdez = zzdq("description");
        this.zzdfc = zzdq("summary");
        this.zzdfa = zzdr("start_ticks");
        this.zzdfb = zzdr("end_ticks");
        this.zzdfd = zzdq(FirebaseAnalytics.Param.LOCATION);
    }

    private final String zzdq(String str) {
        return TextUtils.isEmpty(this.zzcsd.get(str)) ? "" : this.zzcsd.get(str);
    }

    private final long zzdr(String str) {
        String str2 = this.zzcsd.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent a() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(SettingsJsonConstants.PROMPT_TITLE_KEY, this.zzdez);
        data.putExtra("eventLocation", this.zzdfd);
        data.putExtra("description", this.zzdfc);
        long j = this.zzdfa;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdfb;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.zzup == null) {
            zzds("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzkq();
        if (!zzawb.zzas(this.zzup).zzqe()) {
            zzds("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzkq();
        AlertDialog.Builder zzar = zzawb.zzar(this.zzup);
        Resources resources = com.google.android.gms.ads.internal.zzq.zzku().getResources();
        zzar.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzar.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzar.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzaoc(this));
        zzar.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaob(this));
        zzar.create().show();
    }
}
