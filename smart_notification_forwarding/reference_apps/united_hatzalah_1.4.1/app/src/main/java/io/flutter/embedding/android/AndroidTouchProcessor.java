package io.flutter.embedding.android;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AndroidTouchProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BYTES_PER_FIELD = 8;
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
    private static final int TOOL_TYPE_BITS = 3;
    private static final int TOOL_TYPE_MASK = 7;
    private int cachedVerticalScrollFactor;
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* loaded from: classes.dex */
    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    /* loaded from: classes.dex */
    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    /* loaded from: classes.dex */
    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(FlutterRenderer flutterRenderer, boolean z3) {
        this.renderer = flutterRenderer;
        this.trackMotionEvents = z3;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i, int i3, int i4, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i, i3, i4, matrix, byteBuffer, null);
    }

    private float getHorizontalScrollFactor(Context context) {
        float scaledHorizontalScrollFactor;
        if (Build.VERSION.SDK_INT >= 26) {
            scaledHorizontalScrollFactor = ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
            return scaledHorizontalScrollFactor;
        }
        return getVerticalScrollFactorPre26(context);
    }

    private int getPointerChangeForAction(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 6;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 6;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 7) {
            return 3;
        }
        if (i == 3) {
            return 0;
        }
        return i == 8 ? 3 : -1;
    }

    private int getPointerChangeForPanZoom(int i) {
        if (i == 4) {
            return 7;
        }
        if (i == 5) {
            return 8;
        }
        return (i == 6 || i == 0) ? 9 : -1;
    }

    private int getPointerDeviceTypeForToolType(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i != 3) {
            return i != 4 ? 5 : 3;
        }
        return 1;
    }

    private float getVerticalScrollFactor(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return getVerticalScrollFactorAbove26(context);
        }
        return getVerticalScrollFactorPre26(context);
    }

    private float getVerticalScrollFactorAbove26(Context context) {
        float scaledVerticalScrollFactor;
        scaledVerticalScrollFactor = ViewConfiguration.get(context).getScaledVerticalScrollFactor();
        return scaledVerticalScrollFactor;
    }

    private int getVerticalScrollFactorPre26(Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }

    private int uniquePointerIdByType(MotionEvent motionEvent, int i) {
        return (motionEvent.getToolType(i) & 7) | (motionEvent.getPointerId(i) << 3);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent, Context context) {
        boolean z3;
        boolean isFromSource = motionEvent.isFromSource(2);
        if (motionEvent.getActionMasked() != 7 && motionEvent.getActionMasked() != 8) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!isFromSource || !z3) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, allocateDirect, context);
        if (allocateDirect.position() % 288 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i, int i3, int i4, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        int i5;
        int i6;
        long j2;
        long j3;
        double d2;
        double d4;
        double d5;
        double d6;
        InputDevice.MotionRange motionRange;
        int i7 = -1;
        if (i3 == -1) {
            return;
        }
        int uniquePointerIdByType = uniquePointerIdByType(motionEvent, i);
        int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i));
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        if (pointerDeviceTypeForToolType == 1) {
            i6 = 0;
            j2 = 0;
            long buttonState = motionEvent.getButtonState() & 31;
            if (buttonState == 0) {
                i5 = 1;
                if (motionEvent.getSource() == 8194 && i3 == 4) {
                    this.ongoingPans.put(Integer.valueOf(uniquePointerIdByType), fArr);
                }
            } else {
                i5 = 1;
            }
            j3 = buttonState;
        } else {
            i5 = 1;
            i6 = 0;
            j2 = 0;
            j3 = pointerDeviceTypeForToolType == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.ongoingPans.containsKey(Integer.valueOf(uniquePointerIdByType));
        if (containsKey) {
            int pointerChangeForPanZoom = getPointerChangeForPanZoom(i3);
            if (pointerChangeForPanZoom == -1) {
                return;
            } else {
                i7 = pointerChangeForPanZoom;
            }
        }
        long id = this.trackMotionEvents ? this.motionEventTracker.track(motionEvent).getId() : j2;
        int i8 = motionEvent.getActionMasked() == 8 ? i5 : i6;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(id);
        byteBuffer.putLong(eventTime);
        if (containsKey) {
            byteBuffer.putLong(i7);
            byteBuffer.putLong(4L);
        } else {
            byteBuffer.putLong(i3);
            byteBuffer.putLong(pointerDeviceTypeForToolType);
        }
        byteBuffer.putLong(i8);
        byteBuffer.putLong(uniquePointerIdByType);
        byteBuffer.putLong(j2);
        if (containsKey) {
            float[] fArr2 = this.ongoingPans.get(Integer.valueOf(uniquePointerIdByType));
            byteBuffer.putDouble(fArr2[i6]);
            byteBuffer.putDouble(fArr2[i5]);
        } else {
            byteBuffer.putDouble(fArr[i6]);
            byteBuffer.putDouble(fArr[i5]);
        }
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putLong(j3);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d2 = 0.0d;
            d4 = 1.0d;
        } else {
            d2 = motionRange.getMin();
            d4 = motionRange.getMax();
        }
        byteBuffer.putDouble(d2);
        byteBuffer.putDouble(d4);
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i));
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } else {
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        byteBuffer.putDouble(motionEvent.getSize(i));
        byteBuffer.putDouble(motionEvent.getToolMajor(i));
        byteBuffer.putDouble(motionEvent.getToolMinor(i));
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i));
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i));
        } else {
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        byteBuffer.putLong(i4);
        if (i8 == i5) {
            if (context != null) {
                d5 = getHorizontalScrollFactor(context);
                d6 = getVerticalScrollFactor(context);
            } else {
                d5 = 48.0d;
                d6 = 48.0d;
            }
            byteBuffer.putDouble(d5 * (-motionEvent.getAxisValue(10, i)));
            byteBuffer.putDouble(d6 * (-motionEvent.getAxisValue(9, i)));
        } else {
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        if (containsKey) {
            float[] fArr3 = this.ongoingPans.get(Integer.valueOf(uniquePointerIdByType));
            byteBuffer.putDouble(fArr[i6] - fArr3[i6]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
        } else {
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        byteBuffer.putLong(0L);
        if (containsKey && i7 == 9) {
            this.ongoingPans.remove(Integer.valueOf(uniquePointerIdByType));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent, Matrix matrix) {
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z3 = actionMasked == 0 || actionMasked == 5;
        boolean z4 = !z3 && (actionMasked == 1 || actionMasked == 6);
        int i = (z4 && getPointerDeviceTypeForToolType(motionEvent.getToolType(motionEvent.getActionIndex())) == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((pointerCount + i) * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z3) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else if (z4) {
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (i3 != motionEvent.getActionIndex() && motionEvent.getToolType(i3) == 1) {
                    addPointerForIndex(motionEvent, i3, 5, 1, matrix, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
            if (i != 0) {
                addPointerForIndex(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, allocateDirect);
            }
        } else {
            for (int i4 = 0; i4 < pointerCount; i4++) {
                addPointerForIndex(motionEvent, i4, pointerChangeForAction, 0, matrix, allocateDirect);
            }
        }
        if (allocateDirect.position() % 288 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary");
    }
}
