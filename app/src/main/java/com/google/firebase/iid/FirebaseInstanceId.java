package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;

public class FirebaseInstanceId {
    public static FirebaseInstanceId getInstance() {
        return new FirebaseInstanceId();
    }

    public Task<InstanceIdResult> getInstanceId() {
        return FirebaseMessaging.getInstance().getToken().continueWith(task -> new InstanceIdResult() {
            @Override
            public String getId() {
                try {
                    return task.isSuccessful() ? task.getResult() : "";
                } catch (Exception e) {
                    return "";
                }
            }

            @Override
            public String getToken() {
                try {
                    return task.isSuccessful() ? task.getResult() : "";
                } catch (Exception e) {
                    return "";
                }
            }
        });
    }

    public String getToken() {
        try {
            return Tasks.await(FirebaseMessaging.getInstance().getToken());
        } catch (Exception e) {
            return "";
        }
    }
}
