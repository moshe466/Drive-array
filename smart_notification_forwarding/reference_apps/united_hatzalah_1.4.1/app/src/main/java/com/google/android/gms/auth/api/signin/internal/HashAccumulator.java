package com.google.android.gms.auth.api.signin.internal;

/* loaded from: classes.dex */
public class HashAccumulator {
    private int zaa = 1;

    public HashAccumulator addObject(Object obj) {
        int hashCode;
        int i = this.zaa * 31;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        this.zaa = i + hashCode;
        return this;
    }

    public int hash() {
        return this.zaa;
    }

    public final HashAccumulator zaa(boolean z3) {
        this.zaa = (this.zaa * 31) + (z3 ? 1 : 0);
        return this;
    }
}
