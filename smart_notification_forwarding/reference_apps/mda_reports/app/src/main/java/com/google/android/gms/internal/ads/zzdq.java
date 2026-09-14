package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class zzdq {
    private static final String[] zzwr = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzwn = "googleads.g.doubleclick.net";
    private String zzwo = "/pagead/ads";
    private String zzwp = "ad.doubleclick.net";
    private String[] zzwq = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdg zzws;

    public zzdq(zzdg zzdgVar) {
        this.zzws = zzdgVar;
    }

    private final Uri zza(Uri uri, String str) {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdt("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzdt("Query parameter already exists: ms");
            }
            if (!zza) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf("&adurl");
                if (indexOf == -1) {
                    indexOf = uri2.indexOf("?adurl");
                }
                if (indexOf == -1) {
                    return uri.buildUpon().appendQueryParameter("ms", str).build();
                }
                int i = indexOf + 1;
                return Uri.parse(uri2.substring(0, i) + "ms=" + str + "&" + uri2.substring(i));
            }
            String uri3 = uri.toString();
            int indexOf2 = uri3.indexOf(";adurl");
            if (indexOf2 != -1) {
                int i2 = indexOf2 + 1;
                return Uri.parse(uri3.substring(0, i2) + "dc_ms=" + str + ";" + uri3.substring(i2));
            }
            String encodedPath = uri.getEncodedPath();
            int indexOf3 = uri3.indexOf(encodedPath);
            return Uri.parse(uri3.substring(0, encodedPath.length() + indexOf3) + ";dc_ms=" + str + ";" + uri3.substring(indexOf3 + encodedPath.length()));
        } catch (UnsupportedOperationException unused) {
            throw new zzdt("Provided Uri is not in a valid state");
        }
    }

    private final boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzwp);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final Uri zza(Uri uri, Context context) {
        return zza(uri, this.zzws.zzb(context));
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) {
        try {
            return zza(uri, this.zzws.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzdt("Provided Uri is not in a valid state");
        }
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzws.zza(motionEvent);
    }

    public final boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.zzwq) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final zzdg zzbw() {
        return this.zzws;
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzwr) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
