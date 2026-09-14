package com.google.firebase.firestore;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FirestoreMultiDbComponent implements FirebaseAppLifecycleListener, FirebaseFirestore.InstanceRegistry {
    private final FirebaseApp app;
    private final InternalAuthProvider authProvider;
    private final Context context;
    private final Map<String, FirebaseFirestore> instances = new HashMap();
    private final GrpcMetadataProvider metadataProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirestoreMultiDbComponent(@NonNull Context context, @NonNull FirebaseApp firebaseApp, @Nullable InternalAuthProvider internalAuthProvider, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.context = context;
        this.app = firebaseApp;
        this.authProvider = internalAuthProvider;
        this.metadataProvider = grpcMetadataProvider;
        this.app.addLifecycleEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized FirebaseFirestore a(@NonNull String str) {
        FirebaseFirestore firebaseFirestore;
        firebaseFirestore = this.instances.get(str);
        if (firebaseFirestore == null) {
            firebaseFirestore = FirebaseFirestore.a(this.context, this.app, this.authProvider, str, this, this.metadataProvider);
            this.instances.put(str, firebaseFirestore);
        }
        return firebaseFirestore;
    }

    @Override // com.google.firebase.FirebaseAppLifecycleListener
    public synchronized void onDeleted(String str, FirebaseOptions firebaseOptions) {
        for (Map.Entry<String, FirebaseFirestore> entry : this.instances.entrySet()) {
            entry.getValue().d();
            this.instances.remove(entry.getKey());
        }
    }

    @Override // com.google.firebase.firestore.FirebaseFirestore.InstanceRegistry
    public synchronized void remove(@NonNull String str) {
        this.instances.remove(str);
    }
}
