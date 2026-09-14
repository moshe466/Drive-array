package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.b;
import java.util.Map;

/* loaded from: classes.dex */
public final class w extends c2.a {
    public static final Parcelable.Creator<w> CREATOR = new x();

    /* renamed from: f, reason: collision with root package name */
    Bundle f7477f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f7478g;

    public w(Bundle bundle) {
        this.f7477f = bundle;
    }

    public Map<String, String> g() {
        if (this.f7478g == null) {
            this.f7478g = b.a.a(this.f7477f);
        }
        return this.f7478g;
    }

    public String j() {
        return this.f7477f.getString("from");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        x.c(this, parcel, i10);
    }
}
