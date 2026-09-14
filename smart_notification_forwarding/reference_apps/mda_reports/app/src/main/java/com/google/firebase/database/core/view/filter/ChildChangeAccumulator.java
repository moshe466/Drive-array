package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ChildChangeAccumulator {
    private final Map<ChildKey, Change> changeMap = new HashMap();

    public List<Change> getChanges() {
        return new ArrayList(this.changeMap.values());
    }

    public void trackChildChange(Change change) {
        Map<ChildKey, Change> map;
        Event.EventType eventType = change.getEventType();
        ChildKey childKey = change.getChildKey();
        if (this.changeMap.containsKey(childKey)) {
            Change change2 = this.changeMap.get(childKey);
            Event.EventType eventType2 = change2.getEventType();
            if (eventType == Event.EventType.CHILD_ADDED && eventType2 == Event.EventType.CHILD_REMOVED) {
                this.changeMap.put(change.getChildKey(), Change.childChangedChange(childKey, change.getIndexedNode(), change2.getIndexedNode()));
                return;
            }
            if (eventType == Event.EventType.CHILD_REMOVED && eventType2 == Event.EventType.CHILD_ADDED) {
                this.changeMap.remove(childKey);
                return;
            }
            if (eventType == Event.EventType.CHILD_REMOVED && eventType2 == Event.EventType.CHILD_CHANGED) {
                this.changeMap.put(childKey, Change.childRemovedChange(childKey, change2.getOldIndexedNode()));
                return;
            }
            if (eventType == Event.EventType.CHILD_CHANGED && eventType2 == Event.EventType.CHILD_ADDED) {
                map = this.changeMap;
                change = Change.childAddedChange(childKey, change.getIndexedNode());
            } else {
                Event.EventType eventType3 = Event.EventType.CHILD_CHANGED;
                if (eventType != eventType3 || eventType2 != eventType3) {
                    throw new IllegalStateException("Illegal combination of changes: " + change + " occurred after " + change2);
                }
                map = this.changeMap;
                change = Change.childChangedChange(childKey, change.getIndexedNode(), change2.getOldIndexedNode());
            }
        } else {
            map = this.changeMap;
            childKey = change.getChildKey();
        }
        map.put(childKey, change);
    }
}
