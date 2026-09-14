package com.google.firebase.database.ktx;

import P2.G;
import R2.p;
import T.b;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.a;
import com.google.firebase.database.ktx.ChildEvent;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class DatabaseKt$childEvents$1$listener$1 implements ChildEventListener {
    final /* synthetic */ p $$this$callbackFlow;
    final /* synthetic */ Query $this_childEvents;

    public DatabaseKt$childEvents$1$listener$1(Query query, p pVar) {
        this.$this_childEvents = query;
        this.$$this$callbackFlow = pVar;
    }

    public static final void onChildAdded$lambda$0(p $this$callbackFlow, DataSnapshot snapshot, String str) {
        j.e($this$callbackFlow, "$$this$callbackFlow");
        j.e(snapshot, "$snapshot");
        b.P($this$callbackFlow, new ChildEvent.Added(snapshot, str));
    }

    public static final void onChildChanged$lambda$1(p $this$callbackFlow, DataSnapshot snapshot, String str) {
        j.e($this$callbackFlow, "$$this$callbackFlow");
        j.e(snapshot, "$snapshot");
        b.P($this$callbackFlow, new ChildEvent.Changed(snapshot, str));
    }

    public static final void onChildMoved$lambda$3(p $this$callbackFlow, DataSnapshot snapshot, String str) {
        j.e($this$callbackFlow, "$$this$callbackFlow");
        j.e(snapshot, "$snapshot");
        b.P($this$callbackFlow, new ChildEvent.Moved(snapshot, str));
    }

    public static final void onChildRemoved$lambda$2(p $this$callbackFlow, DataSnapshot snapshot) {
        j.e($this$callbackFlow, "$$this$callbackFlow");
        j.e(snapshot, "$snapshot");
        b.P($this$callbackFlow, new ChildEvent.Removed(snapshot));
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onCancelled(DatabaseError error) {
        j.e(error, "error");
        G.e(this.$$this$callbackFlow, "Error getting Query childEvent", error.toException());
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildAdded(DataSnapshot snapshot, String str) {
        j.e(snapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new a(this.$$this$callbackFlow, snapshot, str, 3));
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildChanged(DataSnapshot snapshot, String str) {
        j.e(snapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new a(this.$$this$callbackFlow, snapshot, str, 5));
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildMoved(DataSnapshot snapshot, String str) {
        j.e(snapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new a(this.$$this$callbackFlow, snapshot, str, 4));
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildRemoved(DataSnapshot snapshot) {
        j.e(snapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new com.google.firebase.database.b(this.$$this$callbackFlow, snapshot, 2));
    }
}
