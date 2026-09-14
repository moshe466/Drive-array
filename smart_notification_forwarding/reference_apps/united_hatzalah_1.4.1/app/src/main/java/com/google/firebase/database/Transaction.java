package com.google.firebase.database;

import com.google.firebase.database.snapshot.Node;

/* loaded from: classes.dex */
public class Transaction {

    /* loaded from: classes.dex */
    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z3, DataSnapshot dataSnapshot);
    }

    /* loaded from: classes.dex */
    public static class Result {
        private Node data;
        private boolean success;

        public Node getNode() {
            return this.data;
        }

        public boolean isSuccess() {
            return this.success;
        }

        private Result(boolean z3, Node node) {
            this.success = z3;
            this.data = node;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Result abort() {
        return new Result(false, null);
    }

    public static Result success(MutableData mutableData) {
        return new Result(true, mutableData.getNode());
    }
}
