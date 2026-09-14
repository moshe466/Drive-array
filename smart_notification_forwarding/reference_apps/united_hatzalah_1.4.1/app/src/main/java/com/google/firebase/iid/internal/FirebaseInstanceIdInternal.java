package com.google.firebase.iid.internal;

import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public interface FirebaseInstanceIdInternal {

    /* loaded from: classes.dex */
    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    void deleteToken(String str, String str2);

    String getId();

    String getToken();

    Task<String> getTokenTask();
}
