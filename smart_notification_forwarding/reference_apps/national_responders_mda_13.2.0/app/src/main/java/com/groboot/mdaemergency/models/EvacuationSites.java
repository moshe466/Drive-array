package com.groboot.mdaemergency.models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/* loaded from: classes.dex */
public class EvacuationSites {
    public Hashtable<Integer, String> EvacuationSites;
    public Hashtable<Integer, String> Refrigerators;
    public Hashtable<Integer, String> SiteCategories;
    public List<String> Deliveries = new ArrayList();
    public KvfTable SiteTypes = new KvfTable();
    public KvfTable Sites = new KvfTable();
    public Boolean EnabledTyping = Boolean.FALSE;

    public EvacuationSites() {
    }

    public EvacuationSites(Hashtable<Integer, String> hashtable) {
        this.EvacuationSites = hashtable;
    }

    public Hashtable<Integer, String> getListBySourceType(int i10) {
        return i10 == 1 ? this.EvacuationSites : this.Refrigerators;
    }
}
