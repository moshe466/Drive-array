package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.RoomDatabase;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationMemoryDataBase.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/TranslationMemoryDataBase;", "Landroidx/room/RoomDatabase;", "()V", "swearWordRuleDao", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/SwearWordRuleDao;", "getSwearWordRuleDao", "()Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/SwearWordRuleDao;", "translationMemoryDao", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/TranslationMemoryDao;", "getTranslationMemoryDao", "()Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/TranslationMemoryDao;", "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class TranslationMemoryDataBase extends RoomDatabase {
    private static final String SOURCE_PATH = "translation_memory.db";
    private static TranslationMemoryDataBase myInstance;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock lock = new ReentrantLock();

    public abstract SwearWordRuleDao getSwearWordRuleDao();

    public abstract TranslationMemoryDao getTranslationMemoryDao();

    /* compiled from: TranslationMemoryDataBase.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/TranslationMemoryDataBase$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "SOURCE_PATH", JsonProperty.USE_DEFAULT_NAME, "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "myInstance", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/TranslationMemoryDataBase;", "checkMyInstanceNullConcurrent", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "createMyInstance", "getInstance", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ TranslationMemoryDataBase getInstance$default(Companion companion, Context context, File file, int i, Object obj) {
            if ((i & 2) != 0) {
                file = null;
            }
            return companion.getInstance(context, file);
        }

        public final TranslationMemoryDataBase getInstance(Context context, File directory) {
            Intrinsics.checkNotNullParameter(context, "context");
            TranslationMemoryDataBase translationMemoryDataBase = TranslationMemoryDataBase.myInstance;
            return translationMemoryDataBase == null ? checkMyInstanceNullConcurrent(context, directory) : translationMemoryDataBase;
        }

        static /* synthetic */ TranslationMemoryDataBase checkMyInstanceNullConcurrent$default(Companion companion, Context context, File file, int i, Object obj) {
            if ((i & 2) != 0) {
                file = null;
            }
            return companion.checkMyInstanceNullConcurrent(context, file);
        }

        private final TranslationMemoryDataBase checkMyInstanceNullConcurrent(Context context, File directory) {
            ReentrantLock reentrantLock = TranslationMemoryDataBase.lock;
            reentrantLock.lock();
            try {
                TranslationMemoryDataBase translationMemoryDataBase = TranslationMemoryDataBase.myInstance;
                if (translationMemoryDataBase == null) {
                    translationMemoryDataBase = TranslationMemoryDataBase.INSTANCE.createMyInstance(context, directory);
                }
                return translationMemoryDataBase;
            } finally {
                reentrantLock.unlock();
            }
        }

        static /* synthetic */ TranslationMemoryDataBase createMyInstance$default(Companion companion, Context context, File file, int i, Object obj) {
            if ((i & 2) != 0) {
                file = null;
            }
            return companion.createMyInstance(context, file);
        }

        private final TranslationMemoryDataBase createMyInstance(Context context, File directory) {
            TranslationMemoryDataBase.myInstance = (TranslationMemoryDataBase) new DataBaseCreator().createDataBase(context, directory, TranslationMemoryDataBase.SOURCE_PATH, TranslationMemoryDataBase.class);
            TranslationMemoryDataBase translationMemoryDataBase = TranslationMemoryDataBase.myInstance;
            Intrinsics.checkNotNull(translationMemoryDataBase);
            return translationMemoryDataBase;
        }
    }
}
