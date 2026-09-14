package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class ZombieEventManager implements EventRegistrationZombieListener {
    private static ZombieEventManager defaultInstance = new ZombieEventManager();
    final HashMap<EventRegistration, List<EventRegistration>> globalEventRegistrations = new HashMap<>();

    private ZombieEventManager() {
    }

    public static ZombieEventManager getInstance() {
        return defaultInstance;
    }

    private void unRecordEventRegistration(EventRegistration eventRegistration) {
        EventRegistration clone;
        List<EventRegistration> list;
        synchronized (this.globalEventRegistrations) {
            try {
                List<EventRegistration> list2 = this.globalEventRegistrations.get(eventRegistration);
                boolean z3 = true;
                int i = 0;
                int i3 = 0;
                if (list2 != null) {
                    while (true) {
                        if (i3 < list2.size()) {
                            if (list2.get(i3) == eventRegistration) {
                                list2.remove(i3);
                                i3 = 1;
                                break;
                            }
                            i3++;
                        } else {
                            i3 = 0;
                            break;
                        }
                    }
                    if (list2.isEmpty()) {
                        this.globalEventRegistrations.remove(eventRegistration);
                    }
                }
                if (i3 == 0 && eventRegistration.isUserInitiated()) {
                    z3 = false;
                }
                Utilities.hardAssert(z3);
                if (!eventRegistration.getQuerySpec().isDefault() && (list = this.globalEventRegistrations.get((clone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()))))) != null) {
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
                        this.globalEventRegistrations.remove(clone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void onZombied(EventRegistration eventRegistration) {
        unRecordEventRegistration(eventRegistration);
    }

    public void recordEventRegistration(EventRegistration eventRegistration) {
        synchronized (this.globalEventRegistrations) {
            try {
                List<EventRegistration> list = this.globalEventRegistrations.get(eventRegistration);
                if (list == null) {
                    list = new ArrayList<>();
                    this.globalEventRegistrations.put(eventRegistration, list);
                }
                list.add(eventRegistration);
                if (!eventRegistration.getQuerySpec().isDefault()) {
                    EventRegistration clone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
                    List<EventRegistration> list2 = this.globalEventRegistrations.get(clone);
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                        this.globalEventRegistrations.put(clone, list2);
                    }
                    list2.add(eventRegistration);
                }
                eventRegistration.setIsUserInitiated(true);
                eventRegistration.setOnZombied(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zombifyForRemove(EventRegistration eventRegistration) {
        synchronized (this.globalEventRegistrations) {
            try {
                List<EventRegistration> list = this.globalEventRegistrations.get(eventRegistration);
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
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
