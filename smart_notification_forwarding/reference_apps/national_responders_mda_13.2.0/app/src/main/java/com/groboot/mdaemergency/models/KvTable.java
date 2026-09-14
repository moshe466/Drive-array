package com.groboot.mdaemergency.models;

import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import w6.l0;

/* loaded from: classes.dex */
public class KvTable extends ArrayList<Kv> {
    private static final long serialVersionUID = 1;

    public void add(int i10, String str) {
        add((KvTable) new Kv(i10, str));
    }

    public void add(KvTable kvTable) {
        Iterator<Kv> it = kvTable.iterator();
        while (it.hasNext()) {
            Kv next = it.next();
            boolean z10 = false;
            Iterator<Kv> it2 = iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (next.key == it2.next().key) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                add((KvTable) next);
            }
        }
    }

    @Override // java.util.ArrayList
    public KvTable clone() {
        KvTable kvTable = new KvTable();
        Iterator<Kv> it = iterator();
        while (it.hasNext()) {
            kvTable.add((KvTable) it.next().mo1clone());
        }
        return kvTable;
    }

    public boolean contains(int i10) {
        return contains(new Kv(i10, ""));
    }

    public boolean contains(Kv kv) {
        return indexOf(kv) > -1;
    }

    public KvTable filter(KvTable kvTable) {
        KvTable clone = clone();
        clone.removeAll(kvTable);
        return clone;
    }

    public Kv getByKey(int i10) {
        for (int i11 = 0; i11 < size(); i11++) {
            if (i10 == get(i11).key) {
                return get(i11);
            }
        }
        return new Kv();
    }

    public Kv getFirstByValue(String str) {
        for (int i10 = 0; i10 < size(); i10++) {
            if (str.equals(get(i10).value)) {
                return get(i10);
            }
        }
        return new Kv();
    }

    public int getPositionByKey(int i10) {
        for (int i11 = 0; i11 < size(); i11++) {
            if (i10 == get(i11).key) {
                return i11;
            }
        }
        return -1;
    }

    public boolean hasValue() {
        return size() > 0;
    }

    public int indexOf(Kv kv) {
        for (int i10 = 0; i10 < size(); i10++) {
            if (kv.key == get(i10).key) {
                return i10;
            }
        }
        return -1;
    }

    public int[] keys() {
        int[] iArr = new int[size()];
        for (int i10 = 0; i10 < size(); i10++) {
            iArr[i10] = get(i10).key;
        }
        return iArr;
    }

    public void remove(Kv kv) {
        if (kv == null) {
            return;
        }
        removeByKey(kv.key);
    }

    public void removeByKey(int i10) {
        for (int i11 = 0; i11 < size(); i11++) {
            if (i10 == get(i11).key) {
                remove(i11);
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        if (!hasValue()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        int i10 = 0;
        Iterator<Kv> it = iterator();
        while (it.hasNext()) {
            Kv next = it.next();
            if (!l0.l0(next.value)) {
                sb2.append(next.value);
                sb2.append(i10 < size + (-2) ? ", " : i10 < size + (-1) ? l0.v().getString(R.string.and) : "");
                i10++;
            }
        }
        return sb2.toString();
    }

    public String[] values() {
        String[] strArr = new String[size()];
        for (int i10 = 0; i10 < size(); i10++) {
            strArr[i10] = get(i10).value;
        }
        return strArr;
    }
}
