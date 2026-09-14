package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class j4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6132a;

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f6133b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6134c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f6135d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ e4 f6136e;

    public j4(e4 e4Var, String str, Bundle bundle) {
        this.f6136e = e4Var;
        b2.p.g(str);
        this.f6132a = str;
        this.f6133b = new Bundle();
    }

    private final String c(Bundle bundle) {
        String str;
        JSONArray jSONArray = new JSONArray();
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str2);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        str = "s";
                    } else if (obj instanceof Long) {
                        str = "l";
                    } else if (obj instanceof Double) {
                        str = "d";
                    } else {
                        this.f6136e.h().F().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONObject.put("t", str);
                    jSONArray.put(jSONObject);
                } catch (JSONException e10) {
                    this.f6136e.h().F().b("Cannot serialize bundle value to SharedPreferences", e10);
                }
            }
        }
        return jSONArray.toString();
    }

    public final Bundle a() {
        if (!this.f6134c) {
            this.f6134c = true;
            String string = this.f6136e.E().getString(this.f6132a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i10);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            char c10 = 65535;
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode == 115 && string3.equals("s")) {
                                        c10 = 0;
                                    }
                                } else if (string3.equals("l")) {
                                    c10 = 2;
                                }
                            } else if (string3.equals("d")) {
                                c10 = 1;
                            }
                            if (c10 == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (c10 == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (c10 != 2) {
                                this.f6136e.h().F().b("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f6136e.h().F().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f6135d = bundle;
                } catch (JSONException unused2) {
                    this.f6136e.h().F().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f6135d == null) {
                this.f6135d = this.f6133b;
            }
        }
        return this.f6135d;
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f6136e.E().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f6132a);
        } else {
            edit.putString(this.f6132a, c(bundle));
        }
        edit.apply();
        this.f6135d = bundle;
    }
}
