package com.groboot.mdaemergency.models;

import w6.l0;

/* loaded from: classes.dex */
public class Ksv {
    public String key;
    public String value;

    public Ksv() {
        this.key = "";
        this.value = "";
    }

    public Ksv(String str, String str2) {
        this.key = "";
        this.value = "";
        this.key = str;
        this.value = str2;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Ksv m0clone() {
        return new Ksv(this.key, this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ksv ksv = (Ksv) obj;
        if (this.key != ksv.key) {
            return false;
        }
        String str = this.value;
        String str2 = ksv.value;
        return str == null ? str2 == null : str.equals(str2);
    }

    public boolean hasValue() {
        return (l0.l0(this.value) && l0.l0(this.key)) ? false : true;
    }

    public void set(Ksv ksv) {
        if (ksv == null) {
            ksv = new Ksv();
        }
        set(ksv.key, ksv.value);
    }

    public void set(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
