package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class Kv {
    public static final int OTHER_KEY = -999;
    public static final String OTHER_TEXT = "אחר";
    public int key;
    public String value;

    public Kv() {
        this.key = -1;
        this.value = "";
    }

    public Kv(int i10, String str) {
        this.key = -1;
        this.value = "";
        this.key = i10;
        this.value = str;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Kv mo1clone() {
        return new Kv(this.key, this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Kv kv = (Kv) obj;
        if (this.key != kv.key) {
            return false;
        }
        String str = this.value;
        String str2 = kv.value;
        return str == null ? str2 == null : str.equals(str2);
    }

    public boolean hasValue() {
        return (this.key == -1 && this.value == "") ? false : true;
    }

    public int hashCode() {
        int i10 = this.key * 31;
        String str = this.value;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public void set(int i10, String str) {
        this.key = i10;
        this.value = str;
    }

    public void set(Kv kv) {
        if (kv == null) {
            kv = new Kv();
        }
        set(kv.key, kv.value);
    }
}
