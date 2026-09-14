package com.google.firebase.database;

import F0.AbstractC0008a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class ChildEvent {

    /* loaded from: classes.dex */
    public static final class Added extends ChildEvent {
        private final String previousChildName;
        private final DataSnapshot snapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Added(DataSnapshot snapshot, String str) {
            super(null);
            j.e(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.previousChildName = str;
        }

        public static /* synthetic */ Added copy$default(Added added, DataSnapshot dataSnapshot, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                dataSnapshot = added.snapshot;
            }
            if ((i & 2) != 0) {
                str = added.previousChildName;
            }
            return added.copy(dataSnapshot, str);
        }

        public final DataSnapshot component1() {
            return this.snapshot;
        }

        public final String component2() {
            return this.previousChildName;
        }

        public final Added copy(DataSnapshot snapshot, String str) {
            j.e(snapshot, "snapshot");
            return new Added(snapshot, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Added)) {
                return false;
            }
            Added added = (Added) obj;
            return j.a(this.snapshot, added.snapshot) && j.a(this.previousChildName, added.previousChildName);
        }

        public final String getPreviousChildName() {
            return this.previousChildName;
        }

        public final DataSnapshot getSnapshot() {
            return this.snapshot;
        }

        public int hashCode() {
            int hashCode = this.snapshot.hashCode() * 31;
            String str = this.previousChildName;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Added(snapshot=");
            sb.append(this.snapshot);
            sb.append(", previousChildName=");
            return AbstractC0008a.s(sb, this.previousChildName, ')');
        }
    }

    /* loaded from: classes.dex */
    public static final class Changed extends ChildEvent {
        private final String previousChildName;
        private final DataSnapshot snapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Changed(DataSnapshot snapshot, String str) {
            super(null);
            j.e(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.previousChildName = str;
        }

        public static /* synthetic */ Changed copy$default(Changed changed, DataSnapshot dataSnapshot, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                dataSnapshot = changed.snapshot;
            }
            if ((i & 2) != 0) {
                str = changed.previousChildName;
            }
            return changed.copy(dataSnapshot, str);
        }

        public final DataSnapshot component1() {
            return this.snapshot;
        }

        public final String component2() {
            return this.previousChildName;
        }

        public final Changed copy(DataSnapshot snapshot, String str) {
            j.e(snapshot, "snapshot");
            return new Changed(snapshot, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Changed)) {
                return false;
            }
            Changed changed = (Changed) obj;
            return j.a(this.snapshot, changed.snapshot) && j.a(this.previousChildName, changed.previousChildName);
        }

        public final String getPreviousChildName() {
            return this.previousChildName;
        }

        public final DataSnapshot getSnapshot() {
            return this.snapshot;
        }

        public int hashCode() {
            int hashCode = this.snapshot.hashCode() * 31;
            String str = this.previousChildName;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Changed(snapshot=");
            sb.append(this.snapshot);
            sb.append(", previousChildName=");
            return AbstractC0008a.s(sb, this.previousChildName, ')');
        }
    }

    /* loaded from: classes.dex */
    public static final class Moved extends ChildEvent {
        private final String previousChildName;
        private final DataSnapshot snapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Moved(DataSnapshot snapshot, String str) {
            super(null);
            j.e(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.previousChildName = str;
        }

        public static /* synthetic */ Moved copy$default(Moved moved, DataSnapshot dataSnapshot, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                dataSnapshot = moved.snapshot;
            }
            if ((i & 2) != 0) {
                str = moved.previousChildName;
            }
            return moved.copy(dataSnapshot, str);
        }

        public final DataSnapshot component1() {
            return this.snapshot;
        }

        public final String component2() {
            return this.previousChildName;
        }

        public final Moved copy(DataSnapshot snapshot, String str) {
            j.e(snapshot, "snapshot");
            return new Moved(snapshot, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Moved)) {
                return false;
            }
            Moved moved = (Moved) obj;
            return j.a(this.snapshot, moved.snapshot) && j.a(this.previousChildName, moved.previousChildName);
        }

        public final String getPreviousChildName() {
            return this.previousChildName;
        }

        public final DataSnapshot getSnapshot() {
            return this.snapshot;
        }

        public int hashCode() {
            int hashCode = this.snapshot.hashCode() * 31;
            String str = this.previousChildName;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Moved(snapshot=");
            sb.append(this.snapshot);
            sb.append(", previousChildName=");
            return AbstractC0008a.s(sb, this.previousChildName, ')');
        }
    }

    /* loaded from: classes.dex */
    public static final class Removed extends ChildEvent {
        private final DataSnapshot snapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Removed(DataSnapshot snapshot) {
            super(null);
            j.e(snapshot, "snapshot");
            this.snapshot = snapshot;
        }

        public static /* synthetic */ Removed copy$default(Removed removed, DataSnapshot dataSnapshot, int i, Object obj) {
            if ((i & 1) != 0) {
                dataSnapshot = removed.snapshot;
            }
            return removed.copy(dataSnapshot);
        }

        public final DataSnapshot component1() {
            return this.snapshot;
        }

        public final Removed copy(DataSnapshot snapshot) {
            j.e(snapshot, "snapshot");
            return new Removed(snapshot);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Removed) && j.a(this.snapshot, ((Removed) obj).snapshot);
        }

        public final DataSnapshot getSnapshot() {
            return this.snapshot;
        }

        public int hashCode() {
            return this.snapshot.hashCode();
        }

        public String toString() {
            return "Removed(snapshot=" + this.snapshot + ')';
        }
    }

    public /* synthetic */ ChildEvent(f fVar) {
        this();
    }

    private ChildEvent() {
    }
}
