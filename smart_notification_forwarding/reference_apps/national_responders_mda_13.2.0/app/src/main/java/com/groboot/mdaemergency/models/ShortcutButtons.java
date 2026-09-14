package com.groboot.mdaemergency.models;

import android.content.Context;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.enums.a;
import com.groboot.mdaemergency.enums.b;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.poc.Device;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class ShortcutButtons extends ArrayList<Feature> {
    public static final int MAX_SHORTCUT = 10;
    public static final int SHORTCUT_IN_ROW = 5;
    static final String TAG = "[Shortcut]";
    Context context;

    public ShortcutButtons(Context context) {
        this.context = context;
        if (m.m() == a.POC) {
            PocShortcut();
            return;
        }
        if (d.v().f7635e == null) {
            return;
        }
        addStaticShortcut();
        for (Feature feature : d.v().f7635e) {
            if (feature.FeatureID != null) {
                add(feature);
            }
        }
        if (m.M() != null) {
            Iterator<Feature<T>> it = m.M().iterator();
            while (it.hasNext()) {
                add((Feature) it.next());
            }
        }
    }

    private void PocShortcut() {
        if (m.m() == a.POC) {
            add(getEventsFeature());
            for (Feature feature : d.v().f7635e) {
                if (feature.FeatureType == Feature.eFeatureType.PTT.getId() || feature.IconID == 24) {
                    add(feature);
                }
            }
            if (!m.t() || Device.isTC25()) {
                return;
            }
            add(getStatusFeature());
        }
    }

    private void addStaticShortcut() {
        if (m.t() && !Device.isTC25()) {
            add(getStatusFeature());
        }
        Context context = this.context;
        if (context == null) {
            context = l0.v();
        }
        Feature.eFeatureType efeaturetype = Feature.eFeatureType.Settings;
        add(new Feature(efeaturetype.shortcutId, context.getString(R.string.settings), 2, efeaturetype, false));
    }

    private Feature getBikeFeature() {
        Feature.eFeatureType efeaturetype = Feature.eFeatureType.Bike;
        return new Feature(efeaturetype.shortcutId, this.context.getString(R.string.bike), 28, efeaturetype, false);
    }

    private Feature getEventsFeature() {
        Feature.eFeatureType efeaturetype = Feature.eFeatureType.Events;
        return new Feature(efeaturetype.shortcutId, this.context.getString(R.string.event_log), 29, efeaturetype, false);
    }

    private Feature getStatusFeature() {
        AppUser k10 = m.k();
        if (k10 == null) {
            return null;
        }
        b statusAvailability = !com.groboot.mdaemergency.a.m(this.context) ? b.NOT_AVAILABLE : k10.getLocation().getStatusAvailability();
        Feature.eFeatureType efeaturetype = Feature.eFeatureType.Availability;
        Feature feature = new Feature(efeaturetype.shortcutId, statusAvailability.getTitle(), statusAvailability.getNum(), efeaturetype, true);
        feature.setIsAdded(true);
        return feature;
    }

    public static ArrayList<String> saveToLocalData(List<Feature> list) {
        Feature next;
        ArrayList<String> arrayList = new ArrayList<>();
        if (list.size() >= 10) {
            list = list.subList(0, 10);
        }
        Iterator<Feature> it = list.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.FeatureID);
        }
        return arrayList;
    }

    private void updateList(List<Feature> list) {
        clear();
        addAll(list);
        if (m.M() != null) {
            addAll(m.M());
        }
        addStaticShortcut();
    }

    public void addEmptyItemIfNeeded(int i10) {
        int i11 = i10 % 5;
        if (i11 > 0 || i10 == 5 || i10 == 0) {
            for (int i12 = 0; i12 < 5 - i11; i12++) {
                add(i10 + i12, null);
            }
        }
    }

    public void checkUpdateList(List<Feature> list) {
        if (m.m() == a.POC) {
            return;
        }
        updateList(list);
        sortByShortcutId(m.L());
    }

    public void setItems(List<Feature> list) {
        clear();
        updateShortcut(list);
    }

    public void sortByShortcutId(List<String> list) {
        String str;
        int indexOf;
        if (list == null || list.isEmpty()) {
            if (list != null || size() <= 0 || size() < 5) {
                return;
            }
            m.C0(saveToLocalData(subList(0, 5)));
            return;
        }
        for (String str2 : list) {
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Feature feature = (Feature) it.next();
                if (feature != null && (str = feature.FeatureID) != null && str.equals(str2) && (indexOf = list.indexOf(feature.FeatureID)) > -1) {
                    remove(feature);
                    if (size() < indexOf) {
                        indexOf = size();
                    }
                    add(indexOf, feature);
                }
            }
        }
        addEmptyItemIfNeeded(list.size() > size() ? size() : list.size());
    }

    public void updateShortcut(List<Feature> list) {
        updateList(list);
    }
}
