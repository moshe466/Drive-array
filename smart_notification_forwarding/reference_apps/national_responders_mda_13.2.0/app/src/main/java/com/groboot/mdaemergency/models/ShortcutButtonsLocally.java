package com.groboot.mdaemergency.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w6.m;

/* loaded from: classes.dex */
public class ShortcutButtonsLocally<T> extends ArrayList<Feature<T>> {
    static final String TAG = "[ShortcutButtonsLocally]";

    public void addFeature(Feature feature) {
        if (isContains(feature.FeatureID)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("feature ");
            sb2.append(feature.getDescription());
            sb2.append(" exited");
            return;
        }
        add(feature);
        m.E0(this);
        if (m.N() < 10) {
            List<String> L = m.L();
            L.add(feature.FeatureID);
            m.C0(L);
        }
    }

    public boolean isContains(String str) {
        Iterator<Feature<T>> it = iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().FeatureID)) {
                return true;
            }
        }
        return false;
    }

    public void removeFeature(Feature feature) {
        remove(feature);
        m.E0(this);
    }
}
