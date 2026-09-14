package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class Transaction {
    private final FirebaseFirestore firestore;
    private final com.google.firebase.firestore.core.Transaction transaction;

    /* loaded from: classes2.dex */
    public interface Function<TResult> {
        @Nullable
        TResult apply(@NonNull Transaction transaction);
    }

    public Transaction(com.google.firebase.firestore.core.Transaction transaction, FirebaseFirestore firebaseFirestore) {
        this.transaction = (com.google.firebase.firestore.core.Transaction) Preconditions.checkNotNull(transaction);
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    public static /* synthetic */ DocumentSnapshot a(Transaction transaction, Task task) {
        if (!task.isSuccessful()) {
            throw task.getException();
        }
        List list = (List) task.getResult();
        if (list.size() != 1) {
            throw Assert.fail("Mismatch in docs returned from document lookup.", new Object[0]);
        }
        MaybeDocument maybeDocument = (MaybeDocument) list.get(0);
        if (maybeDocument instanceof Document) {
            return DocumentSnapshot.a(transaction.firestore, (Document) maybeDocument, false, false);
        }
        if (maybeDocument instanceof NoDocument) {
            return DocumentSnapshot.a(transaction.firestore, maybeDocument.getKey(), false, false);
        }
        throw Assert.fail("BatchGetDocumentsRequest returned unexpected document type: " + maybeDocument.getClass().getCanonicalName(), new Object[0]);
    }

    private Task<DocumentSnapshot> getAsync(DocumentReference documentReference) {
        return this.transaction.lookup(Collections.singletonList(documentReference.a())).continueWith(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$1.lambdaFactory$(this));
    }

    private Transaction update(@NonNull DocumentReference documentReference, @NonNull UserData.ParsedUpdateData parsedUpdateData) {
        this.firestore.a(documentReference);
        this.transaction.update(documentReference.a(), parsedUpdateData);
        return this;
    }

    @NonNull
    public Transaction delete(@NonNull DocumentReference documentReference) {
        this.firestore.a(documentReference);
        this.transaction.delete(documentReference.a());
        return this;
    }

    @NonNull
    public DocumentSnapshot get(@NonNull DocumentReference documentReference) {
        this.firestore.a(documentReference);
        try {
            return (DocumentSnapshot) Tasks.await(getAsync(documentReference));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof FirebaseFirestoreException) {
                throw ((FirebaseFirestoreException) e2.getCause());
            }
            throw new RuntimeException(e2.getCause());
        }
    }

    @NonNull
    public Transaction set(@NonNull DocumentReference documentReference, @NonNull Object obj) {
        return set(documentReference, obj, SetOptions.a);
    }

    @NonNull
    public Transaction set(@NonNull DocumentReference documentReference, @NonNull Object obj, @NonNull SetOptions setOptions) {
        this.firestore.a(documentReference);
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        this.transaction.set(documentReference.a(), setOptions.a() ? this.firestore.b().parseMergeData(obj, setOptions.getFieldMask()) : this.firestore.b().parseSetData(obj));
        return this;
    }

    @NonNull
    public Transaction update(@NonNull DocumentReference documentReference, @NonNull FieldPath fieldPath, @Nullable Object obj, Object... objArr) {
        return update(documentReference, this.firestore.b().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }

    @NonNull
    public Transaction update(@NonNull DocumentReference documentReference, @NonNull String str, @Nullable Object obj, Object... objArr) {
        return update(documentReference, this.firestore.b().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    @NonNull
    public Transaction update(@NonNull DocumentReference documentReference, @NonNull Map<String, Object> map) {
        return update(documentReference, this.firestore.b().parseUpdateData(map));
    }
}
