package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.IllegalResourceException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.UnauthorizedResourceException;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: EngineProvider.kt */
@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineProvider;", JsonProperty.USE_DEFAULT_NAME, "engineFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineFactory;", "engineSpecFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineSpecFactory;", "languageDirectionManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineFactory;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineSpecFactory;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;)V", "activeEngines", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", "engineMap", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", JsonProperty.USE_DEFAULT_NAME, "createNewEngine", "dir", "getLoadedEngines", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "forcePivot", JsonProperty.USE_DEFAULT_NAME, "tryLoadEngines", "directions", "inverseDirections", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EngineProvider {
    private final List<Engine> activeEngines;
    private final EngineFactory engineFactory;
    private final Map<LanguageDirection, Engine> engineMap;
    private final EngineSpecFactory engineSpecFactory;
    private final LanguageDirectionManager languageDirectionManager;
    private final ReentrantLock lock;

    @Inject
    public EngineProvider(EngineFactory engineFactory, EngineSpecFactory engineSpecFactory, LanguageDirectionManager languageDirectionManager) {
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(engineSpecFactory, "engineSpecFactory");
        Intrinsics.checkNotNullParameter(languageDirectionManager, "languageDirectionManager");
        this.engineFactory = engineFactory;
        this.engineSpecFactory = engineSpecFactory;
        this.languageDirectionManager = languageDirectionManager;
        this.engineMap = new LinkedHashMap();
        this.activeEngines = new ArrayList();
        this.lock = new ReentrantLock();
    }

    public static /* synthetic */ List getLoadedEngines$default(EngineProvider engineProvider, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return engineProvider.getLoadedEngines(str, str2, z);
    }

    public final List<Engine> getLoadedEngines(String sourceLanguage, String targetLanguage, boolean forcePivot) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        List<LanguageDirection> translationPath = this.languageDirectionManager.getTranslationPath(new LanguageDirection(sourceLanguage, targetLanguage), forcePivot);
        if (!(!translationPath.isEmpty())) {
            throw new IllegalStateException(("Not Available Direction from " + sourceLanguage + " to " + targetLanguage).toString());
        }
        List<LanguageDirection> translationPath2 = this.languageDirectionManager.getTranslationPath(new LanguageDirection(targetLanguage, sourceLanguage), forcePivot);
        for (LanguageDirection languageDirection : translationPath) {
            Engine engine = this.engineMap.get(languageDirection);
            boolean z = false;
            if (engine != null && engine.isReusable()) {
                z = true;
            }
            if (!z) {
                createNewEngine(languageDirection);
            }
        }
        return tryLoadEngines(translationPath, translationPath2);
    }

    private final List<Engine> tryLoadEngines(List<LanguageDirection> directions, List<LanguageDirection> inverseDirections) {
        for (int i = 1; i < 3; i++) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = directions.iterator();
                while (it.hasNext()) {
                    Engine engine = this.engineMap.get((LanguageDirection) it.next());
                    if (engine != null) {
                        arrayList.add(engine);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it2 = inverseDirections.iterator();
                while (it2.hasNext()) {
                    Engine engine2 = this.engineMap.get((LanguageDirection) it2.next());
                    if (engine2 != null) {
                        arrayList3.add(engine2);
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj : arrayList3) {
                    Engine engine3 = (Engine) obj;
                    if (this.activeEngines.contains(engine3) && !arrayList2.contains(engine3)) {
                        arrayList4.add(obj);
                    }
                }
                List plus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                List<Engine> list = this.activeEngines;
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : list) {
                    if (!plus.contains((Engine) obj2)) {
                        arrayList5.add(obj2);
                    }
                }
                Iterator it3 = arrayList5.iterator();
                while (it3.hasNext()) {
                    ((Engine) it3.next()).clear();
                }
                ArrayList<Engine> arrayList6 = new ArrayList();
                for (Object obj3 : plus) {
                    if (!this.activeEngines.contains((Engine) obj3)) {
                        arrayList6.add(obj3);
                    }
                }
                for (Engine engine4 : arrayList6) {
                    try {
                        engine4.load();
                    } catch (IllegalResourceException e) {
                        clear();
                        throw e;
                    } catch (ResourceAccessException e2) {
                        if (i >= 2) {
                            clear();
                            throw e2;
                        }
                        engine4.clear();
                        createNewEngine(engine4.getLanguageDirection());
                        booleanRef.element = true;
                    } catch (UnauthorizedResourceException e3) {
                        clear();
                        throw e3;
                    }
                }
                this.activeEngines.clear();
                this.activeEngines.addAll(plus);
                if (!booleanRef.element) {
                    return arrayList2;
                }
                this.activeEngines.clear();
                List<Engine> list2 = this.activeEngines;
                ArrayList arrayList7 = new ArrayList();
                for (Object obj4 : plus) {
                    if (((Engine) obj4).isLoaded()) {
                        arrayList7.add(obj4);
                    }
                }
                list2.addAll(arrayList7);
                reentrantLock.unlock();
            } finally {
                reentrantLock.unlock();
            }
        }
        return CollectionsKt.emptyList();
    }

    private final void createNewEngine(LanguageDirection dir) {
        Engine createEngine = this.engineFactory.createEngine(this.engineSpecFactory.create(dir.getSrcLang(), dir.getTgtLang()));
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Engine engine = this.engineMap.get(dir);
            if (engine != null) {
                engine.clear();
            }
            this.engineMap.put(dir, createEngine);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.engineMap.values().iterator();
            while (it.hasNext()) {
                ((Engine) it.next()).clear();
            }
            this.activeEngines.clear();
            this.engineMap.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
