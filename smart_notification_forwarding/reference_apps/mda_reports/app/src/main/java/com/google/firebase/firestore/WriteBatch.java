package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class WriteBatch {
    private final FirebaseFirestore firestore;
    private final ArrayList<Mutation> mutations = new ArrayList<>();
    private boolean committed = false;

    /* loaded from: classes2.dex */
    public interface Function {
        void apply(@NonNull WriteBatch writeBatch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteBatch(FirebaseFirestore firebaseFirestore) {
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    private WriteBatch update(@NonNull DocumentReference documentReference, @NonNull UserData.ParsedUpdateData parsedUpdateData) {
        this.firestore.a(documentReference);
        verifyNotCommitted();
        this.mutations.addAll(parsedUpdateData.toMutationList(documentReference.a(), Precondition.exists(true)));
        return this;
    }

    private void verifyNotCommitted() {
        if (this.committed) {
            throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
        }
    }

    @NonNull
    public Task<Void> commit() {
        verifyNotCommitted();
        this.committed = true;
        return this.mutations.size() > 0 ? this.firestore.a().write(this.mutations) : Tasks.forResult(null);
    }

    @NonNull
    public WriteBatch delete(@NonNull DocumentReference documentReference) {
        this.firestore.a(documentReference);
        verifyNotCommitted();
        this.mutations.add(new DeleteMutation(documentReference.a(), Precondition.NONE));
        return this;
    }

    @NonNull
    public WriteBatch set(@NonNull DocumentReference documentReference, @NonNull Object obj) {
        return set(documentReference, obj, SetOptions.a);
    }

    @NonNull
    public WriteBatch set(@NonNull DocumentReference documentReference, @NonNull Object obj, @NonNull SetOptions setOptions) {
        this.firestore.a(documentReference);
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        verifyNotCommitted();
        this.mutations.addAll((setOptions.a() ? this.firestore.b().parseMergeData(obj, setOptions.getFieldMask()) : this.firestore.b().parseSetData(obj)).toMutationList(documentReference.a(), Precondition.NONE));
        return this;
    }

    @NonNull
    public WriteBatch update(@NonNull DocumentReference documentReference, @NonNull FieldPath fieldPath, @Nullable Object obj, Object... objArr) {
        return update(documentReference, this.firestore.b().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }

    @NonNull
    public WriteBatch update(@NonNull DocumentReference documentReference, @NonNull String str, @Nullable Object obj, Object... objArr) {
        return update(documentReference, this.firestore.b().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    @NonNull
    public WriteBatch update(@NonNull DocumentReference documentReference, @NonNull Map<String, Object> map) {
        return update(documentReference, this.firestore.b().parseUpdateData(map));
    }
}
