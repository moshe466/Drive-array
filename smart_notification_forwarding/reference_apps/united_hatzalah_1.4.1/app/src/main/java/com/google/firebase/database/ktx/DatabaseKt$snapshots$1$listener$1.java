package com.google.firebase.database.ktx;

import P2.G;
import R2.p;
import T.b;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class DatabaseKt$snapshots$1$listener$1 implements ValueEventListener {
    final /* synthetic */ p $$this$callbackFlow;
    final /* synthetic */ Query $this_snapshots;

    public DatabaseKt$snapshots$1$listener$1(Query query, p pVar) {
        this.$this_snapshots = query;
        this.$$this$callbackFlow = pVar;
    }

    public static final void onDataChange$lambda$0(p $this$callbackFlow, DataSnapshot snapshot) {
        j.e($this$callbackFlow, "$$this$callbackFlow");
        j.e(snapshot, "$snapshot");
        b.P($this$callbackFlow, snapshot);
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError error) {
        j.e(error, "error");
        G.e(this.$$this$callbackFlow, "Error getting Query snapshot", error.toException());
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot snapshot) {
        j.e(snapshot, "snapshot");
        this.$this_snapshots.getRepo().scheduleNow(new com.google.firebase.database.b(this.$$this$callbackFlow, snapshot, 3));
    }
}
