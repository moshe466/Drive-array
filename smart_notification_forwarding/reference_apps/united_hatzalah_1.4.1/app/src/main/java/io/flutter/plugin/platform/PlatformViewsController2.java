package io.flutter.plugin.platform;

import android.content.Context;
import android.util.SparseArray;
import android.view.AttachedSurfaceControl;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PlatformViewsController2 implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController2";
    private AndroidTouchProcessor androidTouchProcessor;
    private Context context;
    private FlutterView flutterView;
    private PlatformViewsChannel2 platformViewsChannel;
    private PlatformViewRegistryImpl registry;
    private TextInputPlugin textInputPlugin;
    private FlutterJNI flutterJNI = null;
    private Surface overlayerSurface = null;
    private SurfaceControl overlaySurfaceControl = null;
    final PlatformViewsChannel2.PlatformViewsHandler channelHandler = new PlatformViewsChannel2.PlatformViewsHandler() { // from class: io.flutter.plugin.platform.PlatformViewsController2.1
        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.PlatformViewsHandler
        public void clearFocus(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController2.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController2.TAG, "Clearing focus on an unknown view with id: " + i);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController2.TAG, "Clearing focus on a null view with id: " + i);
                return;
            }
            view.clearFocus();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.PlatformViewsHandler
        public void createPlatformView(PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController2.this.createFlutterPlatformView(platformViewCreationRequest);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.PlatformViewsHandler
        public void dispose(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController2.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController2.TAG, "Disposing unknown platform view with id: " + i);
                return;
            }
            if (platformView.getView() != null) {
                View view = platformView.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            PlatformViewsController2.this.platformViews.remove(i);
            try {
                platformView.dispose();
            } catch (RuntimeException e4) {
                Log.e(PlatformViewsController2.TAG, "Disposing platform view threw an exception", e4);
            }
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController2.this.platformViewParent.get(i);
            if (flutterMutatorView != null) {
                flutterMutatorView.removeAllViews();
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup2 = (ViewGroup) flutterMutatorView.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(flutterMutatorView);
                }
                PlatformViewsController2.this.platformViewParent.remove(i);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.PlatformViewsHandler
        public boolean isSurfaceControlEnabled() {
            return PlatformViewsController2.this.isHcppEnabled();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.PlatformViewsHandler
        public void onTouch(PlatformViewTouch platformViewTouch) {
            int i = platformViewTouch.viewId;
            float f4 = PlatformViewsController2.this.context.getResources().getDisplayMetrics().density;
            PlatformView platformView = (PlatformView) PlatformViewsController2.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController2.TAG, "Sending touch to an unknown view with id: " + i);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController2.TAG, "Sending touch to a null view with id: " + i);
                return;
            }
            view.dispatchTouchEvent(PlatformViewsController2.this.toMotionEvent(f4, platformViewTouch));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.PlatformViewsHandler
        public void setDirection(int i, int i3) {
            PlatformView platformView = (PlatformView) PlatformViewsController2.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController2.TAG, "Setting direction to an unknown view with id: " + i);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController2.TAG, "Setting direction to a null view with id: " + i);
                return;
            }
            view.setLayoutDirection(i3);
        }
    };
    private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    private final SparseArray<PlatformView> platformViews = new SparseArray<>();
    private final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    private final ArrayList<SurfaceControl.Transaction> pendingTransactions = new ArrayList<>();
    private final ArrayList<SurfaceControl.Transaction> activeTransactions = new ArrayList<>();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    private void diposeAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
    }

    private float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlatformViewIfNeeded$0(int i, View view, boolean z3) {
        if (z3) {
            this.platformViewsChannel.invokeViewFocused(i);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i);
        }
    }

    private void lockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.lockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionLocked();
    }

    private void maybeInvokeOnFlutterViewAttached(PlatformView platformView) {
        FlutterView flutterView = this.flutterView;
        if (flutterView == null) {
            Log.i(TAG, "null flutterView");
        } else {
            platformView.onFlutterViewAttached(flutterView);
        }
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f4) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        double d2 = f4;
        pointerCoords.toolMajor = (float) (((Double) list.get(3)).doubleValue() * d2);
        pointerCoords.toolMinor = (float) (((Double) list.get(4)).doubleValue() * d2);
        pointerCoords.touchMajor = (float) (((Double) list.get(5)).doubleValue() * d2);
        pointerCoords.touchMinor = (float) (((Double) list.get(6)).doubleValue() * d2);
        pointerCoords.x = (float) (((Double) list.get(7)).doubleValue() * d2);
        pointerCoords.y = (float) (((Double) list.get(8)).doubleValue() * d2);
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f4) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(parsePointerCoords(it.next(), f4));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(parsePointerProperties(it.next()));
        }
        return arrayList;
    }

    private int toLogicalPixels(double d2, float f4) {
        return (int) Math.round(d2 / f4);
    }

    private int toPhysicalPixels(double d2) {
        return (int) Math.round(d2 * getDisplayDensity());
    }

    private static void translateMotionEvent(MotionEvent motionEvent, MotionEvent.PointerCoords[] pointerCoordsArr) {
        if (pointerCoordsArr.length < 1) {
            return;
        }
        motionEvent.offsetLocation(pointerCoordsArr[0].x - motionEvent.getX(), pointerCoordsArr[0].y - motionEvent.getY());
    }

    private void unlockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.unlockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionUnlocked();
    }

    private static boolean validateDirection(int i) {
        return i == 0 || i == 1;
    }

    public void applyTransactions() {
        SurfaceControl.Transaction h2 = com.lt.plugin.lt_plugin.a.h();
        for (int i = 0; i < this.pendingTransactions.size(); i++) {
            h2 = h2.merge(com.lt.plugin.lt_plugin.a.j(this.pendingTransactions.get(i)));
        }
        h2.apply();
        this.pendingTransactions.clear();
    }

    public void attach(Context context, DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context;
            PlatformViewsChannel2 platformViewsChannel2 = new PlatformViewsChannel2(dartExecutor);
            this.platformViewsChannel = platformViewsChannel2;
            platformViewsChannel2.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        this.textInputPlugin = textInputPlugin;
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(FlutterView flutterView) {
        this.flutterView = flutterView;
        for (int i = 0; i < this.platformViewParent.size(); i++) {
            this.flutterView.addView(this.platformViewParent.valueAt(i));
        }
        for (int i3 = 0; i3 < this.platformViews.size(); i3++) {
            this.platformViews.valueAt(i3).onFlutterViewAttached(this.flutterView);
        }
    }

    public PlatformView createFlutterPlatformView(PlatformViewCreationRequest platformViewCreationRequest) {
        Object obj;
        PlatformViewFactory factory = this.registry.getFactory(platformViewCreationRequest.viewType);
        if (factory != null) {
            if (platformViewCreationRequest.params != null) {
                obj = factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
            } else {
                obj = null;
            }
            PlatformView create = factory.create(this.context, platformViewCreationRequest.viewId, obj);
            View view = create.getView();
            if (view != null) {
                view.setLayoutDirection(platformViewCreationRequest.direction);
                this.platformViews.put(platformViewCreationRequest.viewId, create);
                maybeInvokeOnFlutterViewAttached(create);
                return create;
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
    }

    public FlutterOverlaySurface createOverlaySurface() {
        AttachedSurfaceControl rootSurfaceControl;
        SurfaceControl.Transaction buildReparentTransaction;
        if (this.overlayerSurface == null) {
            SurfaceControl.Builder g3 = com.lt.plugin.lt_plugin.a.g();
            g3.setBufferSize(this.flutterView.getWidth(), this.flutterView.getHeight());
            e.i(g3);
            e.u(g3);
            e.x(g3);
            g3.setHidden(false);
            SurfaceControl e4 = e.e(g3);
            rootSurfaceControl = this.flutterView.getRootSurfaceControl();
            buildReparentTransaction = rootSurfaceControl.buildReparentTransaction(e4);
            buildReparentTransaction.setLayer(e4, 1000);
            buildReparentTransaction.apply();
            this.overlayerSurface = com.lt.plugin.lt_plugin.a.f(e4);
            this.overlaySurfaceControl = e4;
        }
        return new FlutterOverlaySurface(0, this.overlayerSurface);
    }

    public SurfaceControl.Transaction createTransaction() {
        SurfaceControl.Transaction h2 = com.lt.plugin.lt_plugin.a.h();
        this.pendingTransactions.add(h2);
        return h2;
    }

    public void destroyOverlaySurface() {
        Surface surface = this.overlayerSurface;
        if (surface != null) {
            surface.release();
            this.overlayerSurface = null;
            this.overlaySurfaceControl = null;
        }
    }

    public void detach() {
        PlatformViewsChannel2 platformViewsChannel2 = this.platformViewsChannel;
        if (platformViewsChannel2 != null) {
            platformViewsChannel2.setPlatformViewsHandler(null);
        }
        destroyOverlaySurface();
        this.platformViewsChannel = null;
        this.context = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibilityBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge(null);
    }

    public void detachFromView() {
        for (int i = 0; i < this.platformViewParent.size(); i++) {
            this.flutterView.removeView(this.platformViewParent.valueAt(i));
        }
        destroyOverlaySurface();
        this.flutterView = null;
        for (int i3 = 0; i3 < this.platformViews.size(); i3++) {
            this.platformViews.valueAt(i3).onFlutterViewDetached();
        }
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public void disposePlatformView(int i) {
        this.channelHandler.dispose(i);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(int i) {
        PlatformView platformView = this.platformViews.get(i);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    public void hideOverlaySurface() {
        if (this.overlaySurfaceControl == null) {
            return;
        }
        SurfaceControl.Transaction h2 = com.lt.plugin.lt_plugin.a.h();
        h2.setVisibility(this.overlaySurfaceControl, false);
        h2.apply();
    }

    public boolean initializePlatformViewIfNeeded(int i) {
        PlatformView platformView = this.platformViews.get(i);
        if (platformView == null) {
            return false;
        }
        if (this.platformViewParent.get(i) != null) {
            return true;
        }
        View view = platformView.getView();
        if (view != null) {
            if (view.getParent() == null) {
                Context context = this.context;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                flutterMutatorView.setOnDescendantFocusChangeListener(new b(this, i, 1));
                this.platformViewParent.put(i, flutterMutatorView);
                view.setImportantForAccessibility(4);
                flutterMutatorView.addView(view);
                this.flutterView.addView(flutterMutatorView);
                return true;
            }
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
    }

    public boolean isHcppEnabled() {
        FlutterJNI flutterJNI = this.flutterJNI;
        if (flutterJNI == null) {
            return false;
        }
        return flutterJNI.IsSurfaceControlEnabled();
    }

    public void onDetachedFromJNI() {
        diposeAllViews();
    }

    public void onDisplayPlatformView(int i, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        if (initializePlatformViewIfNeeded(i)) {
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i);
            flutterMutatorView.readyToDisplay(flutterMutatorsStack, i3, i4, i5, i6);
            flutterMutatorView.setVisibility(0);
            flutterMutatorView.bringToFront();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
            View view = this.platformViews.get(i).getView();
            if (view != null) {
                view.setLayoutParams(layoutParams);
                view.bringToFront();
            }
        }
    }

    public void onEndFrame() {
        AttachedSurfaceControl rootSurfaceControl;
        SurfaceControl.Transaction h2 = com.lt.plugin.lt_plugin.a.h();
        for (int i = 0; i < this.activeTransactions.size(); i++) {
            h2 = h2.merge(com.lt.plugin.lt_plugin.a.j(this.activeTransactions.get(i)));
        }
        this.activeTransactions.clear();
        this.flutterView.invalidate();
        rootSurfaceControl = this.flutterView.getRootSurfaceControl();
        rootSurfaceControl.applyTransactionOnDraw(h2);
    }

    public void onPreEngineRestart() {
        diposeAllViews();
    }

    public void setFlutterJNI(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public void setRegistry(PlatformViewRegistry platformViewRegistry) {
        this.registry = (PlatformViewRegistryImpl) platformViewRegistry;
    }

    public void showOverlaySurface() {
        if (this.overlaySurfaceControl == null) {
            return;
        }
        SurfaceControl.Transaction h2 = com.lt.plugin.lt_plugin.a.h();
        h2.setVisibility(this.overlaySurfaceControl, true);
        h2.apply();
    }

    public synchronized void swapTransactions() {
        try {
            this.activeTransactions.clear();
            for (int i = 0; i < this.pendingTransactions.size(); i++) {
                this.activeTransactions.add(com.lt.plugin.lt_plugin.a.j(this.pendingTransactions.get(i)));
            }
            this.pendingTransactions.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public MotionEvent toMotionEvent(float f4, PlatformViewTouch platformViewTouch) {
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId));
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, f4).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
        if (pop != null) {
            translateMotionEvent(pop, pointerCoordsArr);
            return pop;
        }
        return MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]), pointerCoordsArr, platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(int i) {
        return false;
    }

    private int toLogicalPixels(double d2) {
        return toLogicalPixels(d2, getDisplayDensity());
    }
}
