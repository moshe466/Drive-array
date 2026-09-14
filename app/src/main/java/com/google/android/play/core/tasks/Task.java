package com.google.android.play.core.tasks;

public class Task<TResult> {
    public Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> listener) {
        return this;
    }

    public Task<TResult> addOnFailureListener(OnFailureListener listener) {
        return this;
    }
}
