package com.google.firebase.database.core;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
public class ZombieEventManager implements EventRegistrationZombieListener {
    private static ZombieEventManager defaultInstance = new ZombieEventManager();
    final HashMap<EventRegistration, List<EventRegistration>> a = new HashMap<>();

    private ZombieEventManager() {
    }

    @NotNull
    public static ZombieEventManager getInstance() {
        return defaultInstance;
    }

    private void unRecordEventRegistration(EventRegistration eventRegistration) {
        EventRegistration clone;
        List<EventRegistration> list;
        synchronized (this.a) {
            List<EventRegistration> list2 = this.a.get(eventRegistration);
            int i = 0;
            if (list2 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list2.size()) {
                        break;
                    }
                    if (list2.get(i2) == eventRegistration) {
                        list2.remove(i2);
                        break;
                    }
                    i2++;
                }
                if (list2.isEmpty()) {
                    this.a.remove(eventRegistration);
                }
            }
            if (!eventRegistration.getQuerySpec().isDefault() && (list = this.a.get((clone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()))))) != null) {
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    if (list.get(i) == eventRegistration) {
                        list.remove(i);
                        break;
                    }
                    i++;
                }
                if (list.isEmpty()) {
                    this.a.remove(clone);
                }
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void onZombied(EventRegistration eventRegistration) {
        unRecordEventRegistration(eventRegistration);
    }

    public void recordEventRegistration(EventRegistration eventRegistration) {
        synchronized (this.a) {
            List<EventRegistration> list = this.a.get(eventRegistration);
            if (list == null) {
                list = new ArrayList<>();
                this.a.put(eventRegistration, list);
            }
            list.add(eventRegistration);
            if (!eventRegistration.getQuerySpec().isDefault()) {
                EventRegistration clone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
                List<EventRegistration> list2 = this.a.get(clone);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.a.put(clone, list2);
                }
                list2.add(eventRegistration);
            }
            eventRegistration.setIsUserInitiated(true);
            eventRegistration.setOnZombied(this);
        }
    }

    public void zombifyForRemove(EventRegistration eventRegistration) {
        synchronized (this.a) {
            List<EventRegistration> list = this.a.get(eventRegistration);
            if (list != null && !list.isEmpty()) {
                if (eventRegistration.getQuerySpec().isDefault()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        EventRegistration eventRegistration2 = list.get(size);
                        if (!hashSet.contains(eventRegistration2.getQuerySpec())) {
                            hashSet.add(eventRegistration2.getQuerySpec());
                            eventRegistration2.zombify();
                        }
                    }
                } else {
                    list.get(0).zombify();
                }
            }
        }
    }
}
