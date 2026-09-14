package com.groboot.mdaemergency.models;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Kvf extends Kv implements Serializable {
    private static final long serialVersionUID = 1;
    public int filter;

    public Kvf() {
        this.filter = 0;
    }

    public Kvf(int i10, String str, int i11) {
        super(i10, str);
        this.filter = 0;
        this.filter = i11;
    }

    @Override // com.groboot.mdaemergency.models.Kv
    /* renamed from: clone */
    public Kvf mo1clone() {
        return new Kvf(this.key, this.value, this.filter);
    }

    @Override // com.groboot.mdaemergency.models.Kv
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Kvf kvf = (Kvf) obj;
        if (this.key != kvf.key) {
            return false;
        }
        String str = this.value;
        if (str == null ? kvf.value == null : str.equals(kvf.value)) {
            return this.filter == kvf.filter;
        }
        return false;
    }

    @Override // com.groboot.mdaemergency.models.Kv
    public int hashCode() {
        int i10 = this.key * 31;
        String str = this.value;
        return i10 + (str != null ? str.hashCode() : 0) + this.filter;
    }

    public void set(int i10, String str, int i11) {
        super.set(i10, str);
        this.filter = i11;
    }

    public void set(Kvf kvf) {
        super.set((Kv) kvf);
        this.filter = kvf.filter;
    }

    public Kv toKv() {
        return new Kv(this.key, this.value);
    }
}
