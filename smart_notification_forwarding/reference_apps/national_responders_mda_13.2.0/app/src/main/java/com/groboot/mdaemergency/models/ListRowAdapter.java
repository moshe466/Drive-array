package com.groboot.mdaemergency.models;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class ListRowAdapter extends ArrayList<RowAdapter> {
    int section = 0;

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(RowAdapter rowAdapter) {
        if (rowAdapter.isSection) {
            this.section++;
        }
        rowAdapter.section = this.section;
        return super.add((ListRowAdapter) rowAdapter);
    }
}
