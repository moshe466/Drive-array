package com.groboot.mdaemergency.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public class KvfTable extends ArrayList<Kvf> {
    private static final long serialVersionUID = 1;

    /* loaded from: classes.dex */
    public class FilterComparator implements Comparator<Kvf> {
        boolean desc;

        public FilterComparator(boolean z10) {
            this.desc = z10;
        }

        @Override // java.util.Comparator
        public int compare(Kvf kvf, Kvf kvf2) {
            return this.desc ? kvf.filter - kvf2.filter : kvf2.filter - kvf.filter;
        }
    }

    public KvTable filter(int i10) {
        return filter(new int[]{i10});
    }

    public KvTable filter(Kv kv) {
        return filter(kv.key);
    }

    public KvTable filter(int[] iArr) {
        String str;
        KvTable kvTable = new KvTable();
        for (int i10 : iArr) {
            Iterator<Kvf> it = iterator();
            while (it.hasNext()) {
                Kvf next = it.next();
                if (next.filter == i10 && (str = next.value) != null) {
                    kvTable.add((KvTable) new Kv(next.key, str));
                }
            }
        }
        return kvTable;
    }

    public KvTable filterNegative(int i10) {
        String str;
        KvTable kvTable = new KvTable();
        Iterator<Kvf> it = iterator();
        while (it.hasNext()) {
            Kvf next = it.next();
            if (next.filter != i10 && (str = next.value) != null) {
                kvTable.add((KvTable) new Kv(next.key, str));
            }
        }
        return kvTable;
    }

    public Kvf find(Kv kv) {
        Iterator<Kvf> it = iterator();
        while (it.hasNext()) {
            Kvf next = it.next();
            if (next.key == kv.key) {
                return next;
            }
        }
        return new Kvf();
    }

    public KvTable getAll() {
        KvTable kvTable = new KvTable();
        Iterator<Kvf> it = iterator();
        while (it.hasNext()) {
            Kvf next = it.next();
            kvTable.add((KvTable) new Kv(next.key, next.value));
        }
        return kvTable;
    }

    public Kvf getByKey(int i10) {
        for (int i11 = 0; i11 < size(); i11++) {
            if (i10 == get(i11).key) {
                return get(i11);
            }
        }
        return new Kvf();
    }

    public Kv getFirstByValue(String str) {
        for (int i10 = 0; i10 < size(); i10++) {
            if (str.equals(get(i10).value)) {
                return get(i10);
            }
        }
        return null;
    }

    public boolean hasValue() {
        return size() > 0;
    }

    public void sortByFilter(boolean z10) {
        Collections.sort(this, new FilterComparator(z10));
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        Iterator<Kvf> it = iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().toString() + ", ";
        }
        return str.length() > 2 ? str.substring(0, str.length() - 2) : str;
    }
}
