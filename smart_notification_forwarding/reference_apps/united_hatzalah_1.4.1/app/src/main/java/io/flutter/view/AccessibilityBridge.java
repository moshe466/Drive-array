package io.flutter.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.AccessibilityStringBuilder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static final int BOLD_TEXT_WEIGHT_ADJUSTMENT = 300;
    private static final float DEFAULT_TRANSITION_ANIMATION_SCALE = 1.0f;
    private static final float DISABLED_TRANSITION_ANIMATION_SCALE = 0.0f;
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    private final AccessibilityChannel accessibilityChannel;
    private int accessibilityFeatureFlags;
    private SemanticsNode accessibilityFocusedSemanticsNode;
    private final AccessibilityManager accessibilityManager;
    private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    private boolean accessibleNavigation;
    private final ContentObserver animationScaleObserver;
    private final ContentResolver contentResolver;
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    private String defaultLocale;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    private final List<Integer> flutterNavigationStack;
    private final Map<Integer, SemanticsNode> flutterSemanticsTree;
    private SemanticsNode hoveredObject;
    private SemanticsNode inputFocusedSemanticsNode;
    private boolean isReleased;
    private SemanticsNode lastInputFocusedSemanticsNode;
    private Integer lastLeftFrameInset;
    private OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    private int previousRouteId;
    private final View rootAccessibilityView;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    private static final int SCROLLABLE_ACTIONS = ((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value;
    private static final int FOCUSABLE_FLAGS = ((((((((((Flag.HAS_CHECKED_STATE.value | Flag.IS_CHECKED.value) | Flag.IS_SELECTED.value) | Flag.IS_TEXT_FIELD.value) | Flag.IS_FOCUSED.value) | Flag.HAS_ENABLED_STATE.value) | Flag.IS_ENABLED.value) | Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.value) | Flag.HAS_TOGGLED_STATE.value) | Flag.IS_TOGGLED.value) | Flag.IS_FOCUSABLE.value) | Flag.IS_SLIDER.value;
    private static int FIRST_RESOURCE_ID = 267386881;
    private static int EMPTY_STRING_INDEX = -1;
    static int systemAction = (Action.DID_GAIN_ACCESSIBILITY_FOCUS.value & Action.DID_LOSE_ACCESSIBILITY_FOCUS.value) & Action.SHOW_ON_SCREEN.value;

    /* renamed from: io.flutter.view.AccessibilityBridge$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$view$AccessibilityStringBuilder$StringAttributeType;

        static {
            int[] iArr = new int[AccessibilityStringBuilder.StringAttributeType.values().length];
            $SwitchMap$io$flutter$view$AccessibilityStringBuilder$StringAttributeType = iArr;
            try {
                iArr[AccessibilityStringBuilder.StringAttributeType.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$view$AccessibilityStringBuilder$StringAttributeType[AccessibilityStringBuilder.StringAttributeType.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64),
        NO_ANNOUNCE(128);

        final int value;

        AccessibilityFeature(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes.dex */
    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(UserVerificationMethods.USER_VERIFY_HANDPRINT),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(UserVerificationMethods.USER_VERIFY_NONE),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(UserMetadata.MAX_INTERNAL_KEY_SIZE),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(AccessibilityBridge.MIN_ENGINE_GENERATED_NODE_ID),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152),
        FOCUS(4194304),
        SCROLL_TO_OFFSET(8388608),
        EXPAND(16777216),
        COLLAPSE(33554432);

        public final int value;

        Action(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes.dex */
    public static class CustomAccessibilityAction {
        private String hint;
        private String label;
        private int resourceId = -1;
        private int id = -1;
        private int overrideId = -1;
    }

    /* loaded from: classes.dex */
    public enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(UserVerificationMethods.USER_VERIFY_HANDPRINT),
        IS_HEADER(UserVerificationMethods.USER_VERIFY_NONE),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(UserMetadata.MAX_INTERNAL_KEY_SIZE),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(AccessibilityBridge.MIN_ENGINE_GENERATED_NODE_ID),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728),
        HAS_SELECTED_STATE(268435456),
        HAS_REQUIRED_STATE(536870912),
        IS_REQUIRED(1073741824);

        final int value;

        Flag(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes.dex */
    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z3, boolean z4);
    }

    /* loaded from: classes.dex */
    public static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        private int actions;
        private float bottom;
        private int currentValueLength;
        private List<CustomAccessibilityAction> customAccessibilityActions;
        private String decreasedValue;
        private List<AccessibilityStringBuilder.StringAttribute> decreasedValueAttributes;
        private long flags;
        private Rect globalRect;
        private float[] globalTransform;
        private int headingLevel;
        private String hint;
        private List<AccessibilityStringBuilder.StringAttribute> hintAttributes;
        private String identifier;
        private String increasedValue;
        private List<AccessibilityStringBuilder.StringAttribute> increasedValueAttributes;
        private float[] inverseTransform;
        private String label;
        private List<AccessibilityStringBuilder.StringAttribute> labelAttributes;
        private float left;
        private String linkUrl;
        private String locale;
        private int maxValueLength;
        private CustomAccessibilityAction onLongPressOverride;
        private CustomAccessibilityAction onTapOverride;
        private SemanticsNode parent;
        private int platformViewId;
        private int previousActions;
        private long previousFlags;
        private String previousLabel;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        private int previousTextSelectionBase;
        private int previousTextSelectionExtent;
        private String previousValue;
        private float right;
        private int scrollChildren;
        private float scrollExtentMax;
        private float scrollExtentMin;
        private int scrollIndex;
        private float scrollPosition;
        private TextDirection textDirection;
        private int textSelectionBase;
        private int textSelectionExtent;
        private String tooltip;
        private float top;
        private float[] transform;
        private String value;
        private List<AccessibilityStringBuilder.StringAttribute> valueAttributes;
        private int id = -1;
        private int previousNodeId = -1;
        private boolean hadPreviousConfig = false;
        private List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        private List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        private boolean inverseTransformDirty = true;
        private boolean globalGeometryDirty = true;

        public SemanticsNode(AccessibilityBridge accessibilityBridge) {
            this.accessibilityBridge = accessibilityBridge;
        }

        public static /* synthetic */ int access$2212(SemanticsNode semanticsNode, int i) {
            int i3 = semanticsNode.textSelectionExtent + i;
            semanticsNode.textSelectionExtent = i3;
            return i3;
        }

        public static /* synthetic */ int access$2220(SemanticsNode semanticsNode, int i) {
            int i3 = semanticsNode.textSelectionExtent - i;
            semanticsNode.textSelectionExtent = i3;
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator<SemanticsNode> it = this.childrenInTraversalOrder.iterator();
            while (it.hasNext()) {
                it.next().collectRoutes(list);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str = this.label;
            if (str == null && this.previousLabel == null) {
                return false;
            }
            if (str != null && str.equals(this.previousLabel)) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didScroll() {
            if (!Float.isNaN(this.scrollPosition) && !Float.isNaN(this.previousScrollPosition) && this.previousScrollPosition != this.scrollPosition) {
                return true;
            }
            return false;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, AccessibilityBridge.DISABLED_TRANSITION_ANIMATION_SCALE);
                }
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        private String getEffectiveLocale() {
            String str = this.locale;
            if (str == null || str.isEmpty()) {
                return this.accessibilityBridge.defaultLocale;
            }
            return this.locale;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        private CharSequence getHint() {
            return new AccessibilityStringBuilder().addString(this.hint).addAttributes(this.hintAttributes).addLocale(getEffectiveLocale()).build();
        }

        private CharSequence getLabel() {
            return new AccessibilityStringBuilder().addString(this.label).addAttributes(this.labelAttributes).addUrl(this.linkUrl).addLocale(getEffectiveLocale()).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            Iterator<SemanticsNode> it = this.childrenInTraversalOrder.iterator();
            while (it.hasNext()) {
                String routeName = it.next().getRouteName();
                if (routeName != null && !routeName.isEmpty()) {
                    return routeName;
                }
            }
            return null;
        }

        private List<AccessibilityStringBuilder.StringAttribute> getStringAttributesFromBuffer(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i = byteBuffer.getInt();
            if (i == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = byteBuffer.getInt();
                int i5 = byteBuffer.getInt();
                AccessibilityStringBuilder.StringAttributeType stringAttributeType = AccessibilityStringBuilder.StringAttributeType.values()[byteBuffer.getInt()];
                int i6 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityStringBuilder$StringAttributeType[stringAttributeType.ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                        AccessibilityStringBuilder.LocaleStringAttribute localeStringAttribute = new AccessibilityStringBuilder.LocaleStringAttribute();
                        localeStringAttribute.start = i4;
                        localeStringAttribute.end = i5;
                        localeStringAttribute.type = stringAttributeType;
                        localeStringAttribute.locale = StandardCharsets.UTF_8.decode(byteBuffer2).toString();
                        arrayList.add(localeStringAttribute);
                    }
                } else {
                    byteBuffer.getInt();
                    AccessibilityStringBuilder.SpellOutStringAttribute spellOutStringAttribute = new AccessibilityStringBuilder.SpellOutStringAttribute();
                    spellOutStringAttribute.start = i4;
                    spellOutStringAttribute.end = i5;
                    spellOutStringAttribute.type = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getTextFieldHint() {
            CharSequence[] charSequenceArr = {getLabel(), getHint()};
            CharSequence charSequence = null;
            for (int i = 0; i < 2; i++) {
                CharSequence charSequence2 = charSequenceArr[i];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    if (charSequence != null && charSequence.length() != 0) {
                        charSequence = TextUtils.concat(charSequence, ", ", charSequence2);
                    } else {
                        charSequence = charSequence2;
                    }
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getValue() {
            return new AccessibilityStringBuilder().addString(this.value).addAttributes(this.valueAttributes).addLocale(getEffectiveLocale()).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence[] charSequenceArr = {getValue(), getLabel(), getHint()};
            CharSequence charSequence = null;
            for (int i = 0; i < 3; i++) {
                CharSequence charSequence2 = charSequenceArr[i];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    if (charSequence != null && charSequence.length() != 0) {
                        charSequence = TextUtils.concat(charSequence, ", ", charSequence2);
                    } else {
                        charSequence = charSequence2;
                    }
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadAction(Action action) {
            if ((action.value & this.previousActions) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadFlag(Flag flag) {
            if ((this.previousFlags & flag.value) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasAction(Action action) {
            if ((action.value & this.actions) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasFlag(Flag flag) {
            if ((this.flags & flag.value) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr, boolean z3) {
            float f4 = fArr[3];
            boolean z4 = false;
            float f5 = fArr[0] / f4;
            float f6 = fArr[1] / f4;
            if (f5 < this.left || f5 >= this.right || f6 < this.top || f6 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode semanticsNode : this.childrenInHitTestOrder) {
                if (!semanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                    semanticsNode.ensureInverseTransform();
                    float[] fArr3 = fArr;
                    Matrix.multiplyMV(fArr2, 0, semanticsNode.inverseTransform, 0, fArr3, 0);
                    SemanticsNode hitTest = semanticsNode.hitTest(fArr2, z3);
                    if (hitTest != null) {
                        return hitTest;
                    }
                    fArr = fArr3;
                }
            }
            if (z3 && this.platformViewId != -1) {
                z4 = true;
            }
            if (!isFocusable() && !z4) {
                return null;
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (!hasFlag(Flag.IS_FOCUSABLE) && (this.actions & (~AccessibilityBridge.SCROLLABLE_ACTIONS)) == 0 && (this.flags & AccessibilityBridge.FOCUSABLE_FLAGS) == 0 && (((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty())))) {
                return false;
            }
            return true;
        }

        private void log(String str, boolean z3) {
        }

        private float max(float f4, float f5, float f6, float f7) {
            return Math.max(f4, Math.max(f5, Math.max(f6, f7)));
        }

        private float min(float f4, float f5, float f6, float f7) {
            return Math.min(f4, Math.min(f5, Math.min(f6, f7)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            if (semanticsNode != null && semanticsNode.getAncestor(predicate) != null) {
                return true;
            }
            return false;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f4 = fArr[3];
            fArr[0] = fArr[0] / f4;
            fArr[1] = fArr[1] / f4;
            fArr[2] = fArr[2] / f4;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z3) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z3 = true;
            }
            if (z3) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                if (this.transform == null) {
                    this.transform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = {this.left, this.top, AccessibilityBridge.DISABLED_TRANSITION_ANIMATION_SCALE, AccessibilityBridge.DEFAULT_TRANSITION_ANIMATION_SCALE};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            int i = -1;
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                semanticsNode.previousNodeId = i;
                i = semanticsNode.id;
                semanticsNode.updateRecursively(this.globalTransform, set, z3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateWith(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getLong();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            this.identifier = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.label = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            this.value = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            this.increasedValue = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            this.decreasedValue = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            this.hint = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            this.tooltip = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.linkUrl = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.locale = AccessibilityBridge.getStringFromBuffer(byteBuffer, strArr);
            this.headingLevel = byteBuffer.getInt();
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i = 0; i < 16; i++) {
                this.transform[i] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i3 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i4 = 0; i4 < i3; i4++) {
                SemanticsNode orCreateSemanticsNode = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode.parent = this;
                this.childrenInTraversalOrder.add(orCreateSemanticsNode);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                SemanticsNode orCreateSemanticsNode2 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode2.parent = this;
                this.childrenInHitTestOrder.add(orCreateSemanticsNode2);
            }
            int i6 = byteBuffer.getInt();
            if (i6 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i6);
            } else {
                list.clear();
            }
            for (int i7 = 0; i7 < i6; i7++) {
                CustomAccessibilityAction orCreateAccessibilityAction = this.accessibilityBridge.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (orCreateAccessibilityAction.overrideId == Action.TAP.value) {
                    this.onTapOverride = orCreateAccessibilityAction;
                } else if (orCreateAccessibilityAction.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = orCreateAccessibilityAction;
                } else {
                    this.customAccessibilityActions.add(orCreateAccessibilityAction);
                }
                this.customAccessibilityActions.add(orCreateAccessibilityAction);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i) {
            if (i != 1) {
                if (i != 2) {
                    return UNKNOWN;
                }
                return LTR;
            }
            return RTL;
        }
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel, AccessibilityManager accessibilityManager, ContentResolver contentResolver, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this(view, accessibilityChannel, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, MIN_ENGINE_GENERATED_NODE_ID), platformViewsAccessibilityDelegate);
    }

    public static /* synthetic */ int access$1172(AccessibilityBridge accessibilityBridge, int i) {
        int i3 = i & accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i3;
        return i3;
    }

    public static /* synthetic */ int access$1176(AccessibilityBridge accessibilityBridge, int i) {
        int i3 = i | accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i3;
        return i3;
    }

    private AccessibilityEvent createTextChangedEvent(int i, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i3 = 0;
        while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
            i3++;
        }
        if (i3 >= str.length() && i3 >= str2.length()) {
            return null;
        }
        obtainAccessibilityEvent.setFromIndex(i3);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i3 && length2 >= i3 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        obtainAccessibilityEvent.setRemovedCount((length - i3) + 1);
        obtainAccessibilityEvent.setAddedCount((length2 - i3) + 1);
        return obtainAccessibilityEvent;
    }

    private boolean doesLayoutInDisplayCutoutModeRequireLeftInset() {
        int i;
        Activity activity = ViewUtils.getActivity(this.rootAccessibilityView.getContext());
        if (activity != null && activity.getWindow() != null) {
            i = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
            if (i == 2 || i == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    private Rect getBoundsInScreen(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.rootAccessibilityView.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i));
        if (customAccessibilityAction == null) {
            CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
            customAccessibilityAction2.id = i;
            customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i;
            this.customAccessibilityActions.put(Integer.valueOf(i), customAccessibilityAction2);
            return customAccessibilityAction2;
        }
        return customAccessibilityAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode == null) {
            SemanticsNode semanticsNode2 = new SemanticsNode(this);
            semanticsNode2.id = i;
            this.flutterSemanticsTree.put(Integer.valueOf(i), semanticsNode2);
            return semanticsNode2;
        }
        return semanticsNode;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private static List<AccessibilityStringBuilder.StringAttribute> getStringAttributesFromBuffer(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        int i = byteBuffer.getInt();
        if (i == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = byteBuffer.getInt();
            int i5 = byteBuffer.getInt();
            AccessibilityStringBuilder.StringAttributeType stringAttributeType = AccessibilityStringBuilder.StringAttributeType.values()[byteBuffer.getInt()];
            int i6 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityStringBuilder$StringAttributeType[stringAttributeType.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    AccessibilityStringBuilder.LocaleStringAttribute localeStringAttribute = new AccessibilityStringBuilder.LocaleStringAttribute();
                    localeStringAttribute.start = i4;
                    localeStringAttribute.end = i5;
                    localeStringAttribute.type = stringAttributeType;
                    localeStringAttribute.locale = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            } else {
                byteBuffer.getInt();
                AccessibilityStringBuilder.SpellOutStringAttribute spellOutStringAttribute = new AccessibilityStringBuilder.SpellOutStringAttribute();
                spellOutStringAttribute.start = i4;
                spellOutStringAttribute.end = i5;
                spellOutStringAttribute.type = stringAttributeType;
                arrayList.add(spellOutStringAttribute);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringFromBuffer(ByteBuffer byteBuffer, String[] strArr) {
        int i = byteBuffer.getInt();
        if (i == EMPTY_STRING_INDEX) {
            return null;
        }
        return strArr[i];
    }

    private void handleTouchExploration(float f4, float f5, boolean z3) {
        SemanticsNode hitTest;
        if (!this.flutterSemanticsTree.isEmpty() && (hitTest = getRootSemanticsNode().hitTest(new float[]{f4, f5, DISABLED_TRANSITION_ANIMATION_SCALE, DEFAULT_TRANSITION_ANIMATION_SCALE}, z3)) != this.hoveredObject) {
            if (hitTest != null) {
                sendAccessibilityEvent(hitTest.id, 128);
            }
            SemanticsNode semanticsNode = this.hoveredObject;
            if (semanticsNode != null) {
                sendAccessibilityEvent(semanticsNode.id, UserVerificationMethods.USER_VERIFY_HANDPRINT);
            }
            this.hoveredObject = hitTest;
        }
    }

    private boolean isImportant(SemanticsNode semanticsNode) {
        if (semanticsNode.hasFlag(Flag.SCOPES_ROUTE)) {
            return false;
        }
        if (semanticsNode.getValueLabelHint() == null && (semanticsNode.actions & (~systemAction)) == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$0(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$1(SemanticsNode semanticsNode) {
        return semanticsNode.hasFlag(Flag.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i, int i3) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i3);
        obtainAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtainAccessibilityEvent.setSource(this.rootAccessibilityView, i);
        return obtainAccessibilityEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, UserVerificationMethods.USER_VERIFY_HANDPRINT);
            this.hoveredObject = null;
        }
    }

    private void onWindowNameChange(SemanticsNode semanticsNode) {
        String routeName = semanticsNode.getRouteName();
        if (routeName == null) {
            routeName = StringUtils.SPACE;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setAccessibilityPaneTitle(routeName);
            return;
        }
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
        obtainAccessibilityEvent.getText().add(routeName);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private boolean performCursorMoveAction(SemanticsNode semanticsNode, int i, Bundle bundle, boolean z3) {
        String str;
        int i3 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z4 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i4 = semanticsNode.textSelectionBase;
        int i5 = semanticsNode.textSelectionExtent;
        predictCursorMovement(semanticsNode, i3, z3, z4);
        if (i4 != semanticsNode.textSelectionBase || i5 != semanticsNode.textSelectionExtent) {
            if (semanticsNode.value != null) {
                str = semanticsNode.value;
            } else {
                str = "";
            }
            AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, UserMetadata.MAX_INTERNAL_KEY_SIZE);
            obtainAccessibilityEvent.getText().add(str);
            obtainAccessibilityEvent.setFromIndex(semanticsNode.textSelectionBase);
            obtainAccessibilityEvent.setToIndex(semanticsNode.textSelectionExtent);
            obtainAccessibilityEvent.setItemCount(str.length());
            sendAccessibilityEvent(obtainAccessibilityEvent);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 4 || i3 == 8 || i3 == 16) {
                    return true;
                }
                return false;
            }
            if (z3) {
                Action action = Action.MOVE_CURSOR_FORWARD_BY_WORD;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action, Boolean.valueOf(z4));
                    return true;
                }
            }
            if (!z3) {
                Action action2 = Action.MOVE_CURSOR_BACKWARD_BY_WORD;
                if (semanticsNode.hasAction(action2)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action2, Boolean.valueOf(z4));
                    return true;
                }
                return false;
            }
            return false;
        }
        if (z3) {
            Action action3 = Action.MOVE_CURSOR_FORWARD_BY_CHARACTER;
            if (semanticsNode.hasAction(action3)) {
                this.accessibilityChannel.dispatchSemanticsAction(i, action3, Boolean.valueOf(z4));
                return true;
            }
        }
        if (!z3) {
            Action action4 = Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (semanticsNode.hasAction(action4)) {
                this.accessibilityChannel.dispatchSemanticsAction(i, action4, Boolean.valueOf(z4));
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean performSetText(SemanticsNode semanticsNode, int i, Bundle bundle) {
        String str;
        if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) {
            str = bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        } else {
            str = "";
        }
        this.accessibilityChannel.dispatchSemanticsAction(i, Action.SET_TEXT, str);
        semanticsNode.value = str;
        semanticsNode.valueAttributes = null;
        return true;
    }

    private void predictCursorMovement(SemanticsNode semanticsNode, int i, boolean z3, boolean z4) {
        if (semanticsNode.textSelectionExtent >= 0 && semanticsNode.textSelectionBase >= 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 8 || i == 16) {
                            if (z3) {
                                semanticsNode.textSelectionExtent = semanticsNode.value.length();
                            } else {
                                semanticsNode.textSelectionExtent = 0;
                            }
                        }
                    } else if (z3 && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                        if (!matcher.find()) {
                            semanticsNode.textSelectionExtent = semanticsNode.value.length();
                        } else {
                            SemanticsNode.access$2212(semanticsNode, matcher.start(1));
                        }
                    } else if (!z3 && semanticsNode.textSelectionExtent > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                        if (matcher2.find()) {
                            semanticsNode.textSelectionExtent = matcher2.start(1);
                        } else {
                            semanticsNode.textSelectionExtent = 0;
                        }
                    }
                } else if (z3 && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                    matcher3.find();
                    if (!matcher3.find()) {
                        semanticsNode.textSelectionExtent = semanticsNode.value.length();
                    } else {
                        SemanticsNode.access$2212(semanticsNode, matcher3.start(1));
                    }
                } else if (!z3 && semanticsNode.textSelectionExtent > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                    if (matcher4.find()) {
                        semanticsNode.textSelectionExtent = matcher4.start(1);
                    }
                }
            } else if (z3 && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                SemanticsNode.access$2212(semanticsNode, 1);
            } else if (!z3 && semanticsNode.textSelectionExtent > 0) {
                SemanticsNode.access$2220(semanticsNode, 1);
            }
            if (!z4) {
                semanticsNode.textSelectionBase = semanticsNode.textSelectionExtent;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowContentChangeEvent(int i) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i, 2048);
        obtainAccessibilityEvent.setContentChangeTypes(1);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private void setAccessibilityPaneTitle(String str) {
        this.rootAccessibilityView.setAccessibilityPaneTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessibleNavigation(boolean z3) {
        if (this.accessibleNavigation == z3) {
            return;
        }
        this.accessibleNavigation = z3;
        if (z3) {
            this.accessibilityFeatureFlags |= AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
        } else {
            this.accessibilityFeatureFlags &= ~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
        }
        sendLatestAccessibilityFlagsToFlutter();
    }

    private void setBoldTextFlag() {
        int i;
        View view = this.rootAccessibilityView;
        if (view != null && view.getResources() != null) {
            i = this.rootAccessibilityView.getResources().getConfiguration().fontWeightAdjustment;
            if (i != Integer.MAX_VALUE && i >= BOLD_TEXT_WEIGHT_ADJUSTMENT) {
                this.accessibilityFeatureFlags |= AccessibilityFeature.BOLD_TEXT.value;
            } else {
                this.accessibilityFeatureFlags &= ~AccessibilityFeature.BOLD_TEXT.value;
            }
            sendLatestAccessibilityFlagsToFlutter();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.flutter.util.Predicate, java.lang.Object] */
    private boolean shouldSetCollectionInfo(final SemanticsNode semanticsNode) {
        if (semanticsNode.scrollChildren > 0) {
            if (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate() { // from class: io.flutter.view.b
                @Override // io.flutter.util.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$shouldSetCollectionInfo$0;
                    lambda$shouldSetCollectionInfo$0 = AccessibilityBridge.lambda$shouldSetCollectionInfo$0(AccessibilityBridge.SemanticsNode.this, (AccessibilityBridge.SemanticsNode) obj);
                    return lambda$shouldSetCollectionInfo$0;
                }
            }) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Object())) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        semanticsNode.parent = null;
        if (semanticsNode.platformViewId != -1 && (num = this.embeddedAccessibilityFocusedNodeId) != null && this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) == this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), MIN_ENGINE_GENERATED_NODE_ID);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        if (semanticsNode.platformViewId != -1 && (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) != null) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.id, MIN_ENGINE_GENERATED_NODE_ID);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int length;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        setAccessibleNavigation(true);
        if (i >= MIN_ENGINE_GENERATED_NODE_ID) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(i);
        }
        if (i == -1) {
            AccessibilityNodeInfo obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(obtainAccessibilityNodeInfo);
            if (this.flutterSemanticsTree.containsKey(0)) {
                obtainAccessibilityNodeInfo.addChild(this.rootAccessibilityView, 0);
            }
            obtainAccessibilityNodeInfo.setImportantForAccessibility(false);
            return obtainAccessibilityNodeInfo;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode != null) {
            if (semanticsNode.platformViewId != -1 && this.platformViewsAccessibilityDelegate.usesVirtualDisplay(semanticsNode.platformViewId)) {
                View platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId);
                if (platformViewById != null) {
                    return this.accessibilityViewEmbedder.getRootNode(platformViewById, semanticsNode.id, semanticsNode.getGlobalRect());
                }
                return null;
            }
            AccessibilityNodeInfo obtainAccessibilityNodeInfo2 = obtainAccessibilityNodeInfo(this.rootAccessibilityView, i);
            int i5 = Build.VERSION.SDK_INT;
            obtainAccessibilityNodeInfo2.setImportantForAccessibility(isImportant(semanticsNode));
            CharSequence charSequence = "";
            obtainAccessibilityNodeInfo2.setViewIdResourceName("");
            if (semanticsNode.identifier != null) {
                obtainAccessibilityNodeInfo2.setViewIdResourceName(semanticsNode.identifier);
            }
            obtainAccessibilityNodeInfo2.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
            obtainAccessibilityNodeInfo2.setClassName("android.view.View");
            obtainAccessibilityNodeInfo2.setSource(this.rootAccessibilityView, i);
            obtainAccessibilityNodeInfo2.setFocusable(semanticsNode.isFocusable());
            SemanticsNode semanticsNode2 = this.inputFocusedSemanticsNode;
            if (semanticsNode2 != null) {
                if (semanticsNode2.id == i) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                obtainAccessibilityNodeInfo2.setFocused(z6);
            }
            SemanticsNode semanticsNode3 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode3 != null) {
                if (semanticsNode3.id == i) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                obtainAccessibilityNodeInfo2.setAccessibilityFocused(z5);
            }
            Flag flag = Flag.IS_TEXT_FIELD;
            if (semanticsNode.hasFlag(flag)) {
                obtainAccessibilityNodeInfo2.setPassword(semanticsNode.hasFlag(Flag.IS_OBSCURED));
                if (!semanticsNode.hasFlag(Flag.IS_READ_ONLY)) {
                    obtainAccessibilityNodeInfo2.setClassName("android.widget.EditText");
                }
                obtainAccessibilityNodeInfo2.setEditable(!semanticsNode.hasFlag(r9));
                if (semanticsNode.textSelectionBase != -1 && semanticsNode.textSelectionExtent != -1) {
                    obtainAccessibilityNodeInfo2.setTextSelection(semanticsNode.textSelectionBase, semanticsNode.textSelectionExtent);
                }
                SemanticsNode semanticsNode4 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode4 != null && semanticsNode4.id == i) {
                    obtainAccessibilityNodeInfo2.setLiveRegion(1);
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                    obtainAccessibilityNodeInfo2.addAction(UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                    obtainAccessibilityNodeInfo2.addAction(UserVerificationMethods.USER_VERIFY_NONE);
                    i4 = 1;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                    obtainAccessibilityNodeInfo2.addAction(UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    i4 |= 2;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                    obtainAccessibilityNodeInfo2.addAction(UserVerificationMethods.USER_VERIFY_NONE);
                    i4 |= 2;
                }
                obtainAccessibilityNodeInfo2.setMovementGranularities(i4);
                if (semanticsNode.maxValueLength >= 0) {
                    if (semanticsNode.value == null) {
                        length = 0;
                    } else {
                        length = semanticsNode.value.length();
                    }
                    int unused = semanticsNode.currentValueLength;
                    int unused2 = semanticsNode.maxValueLength;
                    obtainAccessibilityNodeInfo2.setMaxTextLength((length - semanticsNode.currentValueLength) + semanticsNode.maxValueLength);
                }
            }
            if (semanticsNode.hasAction(Action.SET_SELECTION)) {
                obtainAccessibilityNodeInfo2.addAction(131072);
            }
            if (semanticsNode.hasAction(Action.COPY)) {
                obtainAccessibilityNodeInfo2.addAction(16384);
            }
            if (semanticsNode.hasAction(Action.CUT)) {
                obtainAccessibilityNodeInfo2.addAction(MIN_ENGINE_GENERATED_NODE_ID);
            }
            if (semanticsNode.hasAction(Action.PASTE)) {
                obtainAccessibilityNodeInfo2.addAction(32768);
            }
            if (semanticsNode.hasAction(Action.SET_TEXT)) {
                obtainAccessibilityNodeInfo2.addAction(2097152);
            }
            if (semanticsNode.hasFlag(Flag.IS_BUTTON)) {
                obtainAccessibilityNodeInfo2.setClassName("android.widget.Button");
            }
            if (semanticsNode.hasFlag(Flag.IS_IMAGE)) {
                obtainAccessibilityNodeInfo2.setClassName("android.widget.ImageView");
            }
            if (semanticsNode.hasAction(Action.DISMISS)) {
                obtainAccessibilityNodeInfo2.setDismissable(true);
                obtainAccessibilityNodeInfo2.addAction(1048576);
            }
            if (semanticsNode.parent != null) {
                obtainAccessibilityNodeInfo2.setParent(this.rootAccessibilityView, semanticsNode.parent.id);
            } else {
                obtainAccessibilityNodeInfo2.setParent(this.rootAccessibilityView);
            }
            if (semanticsNode.previousNodeId != -1) {
                obtainAccessibilityNodeInfo2.setTraversalAfter(this.rootAccessibilityView, semanticsNode.previousNodeId);
            }
            Rect globalRect = semanticsNode.getGlobalRect();
            if (semanticsNode.parent != null) {
                Rect globalRect2 = semanticsNode.parent.getGlobalRect();
                Rect rect = new Rect(globalRect);
                rect.offset(-globalRect2.left, -globalRect2.top);
                obtainAccessibilityNodeInfo2.setBoundsInParent(rect);
            } else {
                obtainAccessibilityNodeInfo2.setBoundsInParent(globalRect);
            }
            obtainAccessibilityNodeInfo2.setBoundsInScreen(getBoundsInScreen(globalRect));
            obtainAccessibilityNodeInfo2.setVisibleToUser(true);
            if (semanticsNode.hasFlag(Flag.HAS_ENABLED_STATE) && !semanticsNode.hasFlag(Flag.IS_ENABLED)) {
                z3 = false;
            } else {
                z3 = true;
            }
            obtainAccessibilityNodeInfo2.setEnabled(z3);
            if (semanticsNode.hasAction(Action.TAP)) {
                if (semanticsNode.onTapOverride != null) {
                    obtainAccessibilityNodeInfo2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode.onTapOverride.hint));
                    obtainAccessibilityNodeInfo2.setClickable(true);
                } else {
                    obtainAccessibilityNodeInfo2.addAction(16);
                    obtainAccessibilityNodeInfo2.setClickable(true);
                }
            } else if (semanticsNode.hasFlag(Flag.IS_SLIDER)) {
                obtainAccessibilityNodeInfo2.addAction(16);
                obtainAccessibilityNodeInfo2.setClickable(true);
            }
            if (semanticsNode.hasAction(Action.LONG_PRESS)) {
                if (semanticsNode.onLongPressOverride != null) {
                    obtainAccessibilityNodeInfo2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode.onLongPressOverride.hint));
                    obtainAccessibilityNodeInfo2.setLongClickable(true);
                } else {
                    obtainAccessibilityNodeInfo2.addAction(32);
                    obtainAccessibilityNodeInfo2.setLongClickable(true);
                }
            }
            Action action = Action.SCROLL_LEFT;
            if (semanticsNode.hasAction(action) || semanticsNode.hasAction(Action.SCROLL_UP) || semanticsNode.hasAction(Action.SCROLL_RIGHT) || semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                obtainAccessibilityNodeInfo2.setScrollable(true);
                if (semanticsNode.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                    if (!semanticsNode.hasAction(action) && !semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                        if (shouldSetCollectionInfo(semanticsNode)) {
                            obtainAccessibilityNodeInfo2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode.scrollChildren, 0, false));
                        } else {
                            obtainAccessibilityNodeInfo2.setClassName("android.widget.ScrollView");
                        }
                    } else if (shouldSetCollectionInfo(semanticsNode)) {
                        obtainAccessibilityNodeInfo2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode.scrollChildren, false));
                    } else {
                        obtainAccessibilityNodeInfo2.setClassName("android.widget.HorizontalScrollView");
                    }
                }
                if (semanticsNode.hasAction(action) || semanticsNode.hasAction(Action.SCROLL_UP)) {
                    obtainAccessibilityNodeInfo2.addAction(4096);
                }
                if (semanticsNode.hasAction(Action.SCROLL_RIGHT) || semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    obtainAccessibilityNodeInfo2.addAction(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                }
            }
            Action action2 = Action.INCREASE;
            if (semanticsNode.hasAction(action2) || semanticsNode.hasAction(Action.DECREASE)) {
                obtainAccessibilityNodeInfo2.setClassName("android.widget.SeekBar");
                if (semanticsNode.hasAction(action2)) {
                    obtainAccessibilityNodeInfo2.addAction(4096);
                }
                if (semanticsNode.hasAction(Action.DECREASE)) {
                    obtainAccessibilityNodeInfo2.addAction(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                }
            }
            if (semanticsNode.hasFlag(Flag.IS_LIVE_REGION)) {
                obtainAccessibilityNodeInfo2.setLiveRegion(1);
            }
            if (semanticsNode.hasFlag(flag)) {
                obtainAccessibilityNodeInfo2.setText(semanticsNode.getValue());
                if (i5 >= 28) {
                    obtainAccessibilityNodeInfo2.setHintText(semanticsNode.getTextFieldHint());
                }
            } else if (!semanticsNode.hasFlag(Flag.SCOPES_ROUTE)) {
                CharSequence valueLabelHint = semanticsNode.getValueLabelHint();
                if (i5 < 28 && semanticsNode.tooltip != null) {
                    if (valueLabelHint != null) {
                        charSequence = valueLabelHint;
                    }
                    valueLabelHint = ((Object) charSequence) + "\n" + semanticsNode.tooltip;
                }
                if (valueLabelHint != null) {
                    obtainAccessibilityNodeInfo2.setContentDescription(valueLabelHint);
                }
            }
            if (i5 >= 28 && semanticsNode.tooltip != null) {
                obtainAccessibilityNodeInfo2.setTooltipText(semanticsNode.tooltip);
                if (semanticsNode.getValueLabelHint() == null) {
                    obtainAccessibilityNodeInfo2.setContentDescription(semanticsNode.tooltip);
                }
            }
            boolean hasFlag = semanticsNode.hasFlag(Flag.HAS_CHECKED_STATE);
            boolean hasFlag2 = semanticsNode.hasFlag(Flag.HAS_TOGGLED_STATE);
            if (!hasFlag && !hasFlag2) {
                z4 = false;
            } else {
                z4 = true;
            }
            obtainAccessibilityNodeInfo2.setCheckable(z4);
            if (hasFlag) {
                obtainAccessibilityNodeInfo2.setChecked(semanticsNode.hasFlag(Flag.IS_CHECKED));
                if (semanticsNode.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                    obtainAccessibilityNodeInfo2.setClassName("android.widget.RadioButton");
                } else {
                    obtainAccessibilityNodeInfo2.setClassName("android.widget.CheckBox");
                }
            } else if (hasFlag2) {
                obtainAccessibilityNodeInfo2.setChecked(semanticsNode.hasFlag(Flag.IS_TOGGLED));
                obtainAccessibilityNodeInfo2.setClassName("android.widget.Switch");
            }
            obtainAccessibilityNodeInfo2.setSelected(semanticsNode.hasFlag(Flag.IS_SELECTED));
            if (i5 >= 36 && semanticsNode.hasFlag(Flag.HAS_EXPANDED_STATE)) {
                if (semanticsNode.hasFlag(Flag.IS_EXPANDED)) {
                    i3 = 3;
                } else {
                    i3 = 1;
                }
                obtainAccessibilityNodeInfo2.setExpandedState(i3);
                if (semanticsNode.hasAction(Action.EXPAND)) {
                    obtainAccessibilityNodeInfo2.addAction(262144);
                }
                if (semanticsNode.hasAction(Action.COLLAPSE)) {
                    obtainAccessibilityNodeInfo2.addAction(524288);
                }
            }
            if (i5 >= 28) {
                if (semanticsNode.headingLevel <= 0) {
                    z7 = false;
                }
                obtainAccessibilityNodeInfo2.setHeading(z7);
            }
            SemanticsNode semanticsNode5 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode5 != null && semanticsNode5.id == i) {
                obtainAccessibilityNodeInfo2.addAction(128);
            } else {
                obtainAccessibilityNodeInfo2.addAction(64);
            }
            if (semanticsNode.customAccessibilityActions != null) {
                for (CustomAccessibilityAction customAccessibilityAction : semanticsNode.customAccessibilityActions) {
                    obtainAccessibilityNodeInfo2.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
                }
            }
            for (SemanticsNode semanticsNode6 : semanticsNode.childrenInTraversalOrder) {
                if (!semanticsNode6.hasFlag(Flag.IS_HIDDEN)) {
                    if (semanticsNode6.platformViewId != -1) {
                        View platformViewById2 = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode6.platformViewId);
                        if (!this.platformViewsAccessibilityDelegate.usesVirtualDisplay(semanticsNode6.platformViewId) && platformViewById2 != null) {
                            platformViewById2.setImportantForAccessibility(0);
                            obtainAccessibilityNodeInfo2.addChild(platformViewById2);
                        }
                    }
                    obtainAccessibilityNodeInfo2.addChild(this.rootAccessibilityView, semanticsNode6.id);
                }
            }
            return obtainAccessibilityNodeInfo2;
        }
        return null;
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType != 8) {
            if (eventType != 128) {
                if (eventType != 32768) {
                    if (eventType == MIN_ENGINE_GENERATED_NODE_ID) {
                        this.embeddedInputFocusedNodeId = null;
                        this.embeddedAccessibilityFocusedNodeId = null;
                        return true;
                    }
                    return true;
                }
                this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
                this.accessibilityFocusedSemanticsNode = null;
                return true;
            }
            this.hoveredObject = null;
            return true;
        }
        this.embeddedInputFocusedNodeId = recordFlutterId;
        this.inputFocusedSemanticsNode = null;
        return true;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
        } else {
            SemanticsNode semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.id);
            }
            Integer num = this.embeddedInputFocusedNodeId;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.id);
        }
        Integer num2 = this.embeddedAccessibilityFocusedNodeId;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public boolean getAccessibleNavigation() {
        return this.accessibleNavigation;
    }

    public int getHoveredObjectId() {
        return this.hoveredObject.id;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        return onAccessibilityHoverEvent(motionEvent, false);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i3, Bundle bundle) {
        if (i >= MIN_ENGINE_GENERATED_NODE_ID) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i, i3, bundle);
            if (performAction && i3 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode == null) {
            return false;
        }
        switch (i3) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.LONG_PRESS);
                return true;
            case 64:
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap hashMap = new HashMap();
                hashMap.put("type", "didGainFocus");
                hashMap.put("nodeId", Integer.valueOf(semanticsNode.id));
                this.accessibilityChannel.channel.send(hashMap);
                sendAccessibilityEvent(i, 32768);
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i, 4);
                }
                return true;
            case 128:
                SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode2 != null && semanticsNode2.id == i) {
                    this.accessibilityFocusedSemanticsNode = null;
                }
                Integer num = this.embeddedAccessibilityFocusedNodeId;
                if (num != null && num.intValue() == i) {
                    this.embeddedAccessibilityFocusedNodeId = null;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i, MIN_ENGINE_GENERATED_NODE_ID);
                return true;
            case UserVerificationMethods.USER_VERIFY_HANDPRINT /* 256 */:
                return performCursorMoveAction(semanticsNode, i, bundle, true);
            case UserVerificationMethods.USER_VERIFY_NONE /* 512 */:
                return performCursorMoveAction(semanticsNode, i, bundle, false);
            case 4096:
                Action action = Action.SCROLL_UP;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action);
                } else {
                    Action action2 = Action.SCROLL_LEFT;
                    if (semanticsNode.hasAction(action2)) {
                        this.accessibilityChannel.dispatchSemanticsAction(i, action2);
                    } else {
                        Action action3 = Action.INCREASE;
                        if (semanticsNode.hasAction(action3)) {
                            semanticsNode.value = semanticsNode.increasedValue;
                            semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                            sendAccessibilityEvent(i, 4);
                            this.accessibilityChannel.dispatchSemanticsAction(i, action3);
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            case UserMetadata.MAX_INTERNAL_KEY_SIZE /* 8192 */:
                Action action4 = Action.SCROLL_DOWN;
                if (semanticsNode.hasAction(action4)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action4);
                } else {
                    Action action5 = Action.SCROLL_RIGHT;
                    if (semanticsNode.hasAction(action5)) {
                        this.accessibilityChannel.dispatchSemanticsAction(i, action5);
                    } else {
                        Action action6 = Action.DECREASE;
                        if (semanticsNode.hasAction(action6)) {
                            semanticsNode.value = semanticsNode.decreasedValue;
                            semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                            sendAccessibilityEvent(i, 4);
                            this.accessibilityChannel.dispatchSemanticsAction(i, action6);
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.PASTE);
                return true;
            case MIN_ENGINE_GENERATED_NODE_ID /* 65536 */:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.CUT);
                return true;
            case 131072:
                HashMap hashMap2 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    hashMap2.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    hashMap2.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                } else {
                    hashMap2.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap2.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                }
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.SET_SELECTION, hashMap2);
                SemanticsNode semanticsNode3 = this.flutterSemanticsTree.get(Integer.valueOf(i));
                semanticsNode3.textSelectionBase = ((Integer) hashMap2.get("base")).intValue();
                semanticsNode3.textSelectionExtent = ((Integer) hashMap2.get("extent")).intValue();
                return true;
            case 262144:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.EXPAND);
                return true;
            case 524288:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.COLLAPSE);
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DISMISS);
                return true;
            case 2097152:
                return performSetText(semanticsNode, i, bundle);
            case 16908342:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i3 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction == null) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                return true;
        }
    }

    public void release() {
        this.isReleased = true;
        this.platformViewsAccessibilityDelegate.detachAccessibilityBridge();
        setOnAccessibilityChangeListener(null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler(null);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, MIN_ENGINE_GENERATED_NODE_ID);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void sendAccessibilityEvent(int i, int i3) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i, i3));
        }
    }

    public void setLocale(String str) {
        this.defaultLocale = str;
    }

    public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener onAccessibilityChangeListener) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener;
    }

    public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            orCreateAccessibilityAction.label = getStringFromBuffer(byteBuffer, strArr);
            orCreateAccessibilityAction.hint = getStringFromBuffer(byteBuffer, strArr);
        }
    }

    public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        SemanticsNode semanticsNode;
        String str;
        SemanticsNode semanticsNode2;
        float f4;
        float f5;
        View platformViewById;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            SemanticsNode orCreateSemanticsNode = getOrCreateSemanticsNode(byteBuffer.getInt());
            orCreateSemanticsNode.updateWith(byteBuffer, strArr, byteBufferArr);
            if (!orCreateSemanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                if (orCreateSemanticsNode.hasFlag(Flag.IS_FOCUSED)) {
                    this.inputFocusedSemanticsNode = orCreateSemanticsNode;
                }
                if (orCreateSemanticsNode.hadPreviousConfig) {
                    arrayList.add(orCreateSemanticsNode);
                }
                if (orCreateSemanticsNode.platformViewId != -1 && !this.platformViewsAccessibilityDelegate.usesVirtualDisplay(orCreateSemanticsNode.platformViewId) && (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(orCreateSemanticsNode.platformViewId)) != null) {
                    platformViewById.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        SemanticsNode rootSemanticsNode = getRootSemanticsNode();
        ArrayList arrayList2 = new ArrayList();
        if (rootSemanticsNode != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            rootSemanticsNode.updateRecursively(fArr, hashSet, false);
            rootSemanticsNode.collectRoutes(arrayList2);
        }
        int size = arrayList2.size();
        SemanticsNode semanticsNode3 = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            SemanticsNode semanticsNode4 = (SemanticsNode) obj;
            if (!this.flutterNavigationStack.contains(Integer.valueOf(semanticsNode4.id))) {
                semanticsNode3 = semanticsNode4;
            }
        }
        if (semanticsNode3 == null && !arrayList2.isEmpty()) {
            semanticsNode3 = (SemanticsNode) arrayList2.get(arrayList2.size() - 1);
        }
        if (semanticsNode3 != null && (semanticsNode3.id != this.previousRouteId || arrayList2.size() != this.flutterNavigationStack.size())) {
            this.previousRouteId = semanticsNode3.id;
            onWindowNameChange(semanticsNode3);
        }
        this.flutterNavigationStack.clear();
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            this.flutterNavigationStack.add(Integer.valueOf(((SemanticsNode) obj2).id));
        }
        Iterator<Map.Entry<Integer, SemanticsNode>> it = this.flutterSemanticsTree.entrySet().iterator();
        while (it.hasNext()) {
            SemanticsNode value = it.next().getValue();
            if (!hashSet.contains(value)) {
                willRemoveSemanticsNode(value);
                it.remove();
            }
        }
        sendWindowContentChangeEvent(0);
        int size3 = arrayList.size();
        int i4 = 0;
        while (i4 < size3) {
            Object obj3 = arrayList.get(i4);
            i4++;
            SemanticsNode semanticsNode5 = (SemanticsNode) obj3;
            if (semanticsNode5.didScroll()) {
                AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode5.id, 4096);
                float f6 = semanticsNode5.scrollPosition;
                float f7 = semanticsNode5.scrollExtentMax;
                if (Float.isInfinite(semanticsNode5.scrollExtentMax)) {
                    if (f6 > SCROLL_POSITION_CAP_FOR_INFINITY) {
                        f6 = 70000.0f;
                    }
                    f7 = 100000.0f;
                }
                if (Float.isInfinite(semanticsNode5.scrollExtentMin)) {
                    f4 = f7 + SCROLL_EXTENT_FOR_INFINITY;
                    if (f6 < -70000.0f) {
                        f6 = -70000.0f;
                    }
                    f5 = f6 + SCROLL_EXTENT_FOR_INFINITY;
                } else {
                    f4 = f7 - semanticsNode5.scrollExtentMin;
                    f5 = f6 - semanticsNode5.scrollExtentMin;
                }
                if (!semanticsNode5.hadAction(Action.SCROLL_UP) && !semanticsNode5.hadAction(Action.SCROLL_DOWN)) {
                    if (semanticsNode5.hadAction(Action.SCROLL_LEFT) || semanticsNode5.hadAction(Action.SCROLL_RIGHT)) {
                        obtainAccessibilityEvent.setScrollX((int) f5);
                        obtainAccessibilityEvent.setMaxScrollX((int) f4);
                    }
                } else {
                    obtainAccessibilityEvent.setScrollY((int) f5);
                    obtainAccessibilityEvent.setMaxScrollY((int) f4);
                }
                if (semanticsNode5.scrollChildren > 0) {
                    obtainAccessibilityEvent.setItemCount(semanticsNode5.scrollChildren);
                    obtainAccessibilityEvent.setFromIndex(semanticsNode5.scrollIndex);
                    Iterator it2 = semanticsNode5.childrenInHitTestOrder.iterator();
                    int i5 = 0;
                    while (it2.hasNext()) {
                        if (!((SemanticsNode) it2.next()).hasFlag(Flag.IS_HIDDEN)) {
                            i5++;
                        }
                    }
                    obtainAccessibilityEvent.setToIndex((semanticsNode5.scrollIndex + i5) - 1);
                }
                sendAccessibilityEvent(obtainAccessibilityEvent);
            }
            if (semanticsNode5.hasFlag(Flag.IS_LIVE_REGION) && semanticsNode5.didChangeLabel()) {
                sendWindowContentChangeEvent(semanticsNode5.id);
            }
            SemanticsNode semanticsNode6 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode6 != null && semanticsNode6.id == semanticsNode5.id) {
                Flag flag = Flag.IS_SELECTED;
                if (!semanticsNode5.hadFlag(flag) && semanticsNode5.hasFlag(flag)) {
                    AccessibilityEvent obtainAccessibilityEvent2 = obtainAccessibilityEvent(semanticsNode5.id, 4);
                    obtainAccessibilityEvent2.getText().add(semanticsNode5.label);
                    sendAccessibilityEvent(obtainAccessibilityEvent2);
                }
            }
            SemanticsNode semanticsNode7 = this.inputFocusedSemanticsNode;
            if (semanticsNode7 != null && semanticsNode7.id == semanticsNode5.id && ((semanticsNode2 = this.lastInputFocusedSemanticsNode) == null || semanticsNode2.id != this.inputFocusedSemanticsNode.id)) {
                this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
                sendAccessibilityEvent(obtainAccessibilityEvent(semanticsNode5.id, 8));
            } else if (this.inputFocusedSemanticsNode == null) {
                this.lastInputFocusedSemanticsNode = null;
            }
            SemanticsNode semanticsNode8 = this.inputFocusedSemanticsNode;
            if (semanticsNode8 != null && semanticsNode8.id == semanticsNode5.id) {
                Flag flag2 = Flag.IS_TEXT_FIELD;
                if (semanticsNode5.hadFlag(flag2) && semanticsNode5.hasFlag(flag2) && ((semanticsNode = this.accessibilityFocusedSemanticsNode) == null || semanticsNode.id == this.inputFocusedSemanticsNode.id)) {
                    String str2 = "";
                    if (semanticsNode5.previousValue != null) {
                        str = semanticsNode5.previousValue;
                    } else {
                        str = "";
                    }
                    if (semanticsNode5.value != null) {
                        str2 = semanticsNode5.value;
                    }
                    AccessibilityEvent createTextChangedEvent = createTextChangedEvent(semanticsNode5.id, str, str2);
                    if (createTextChangedEvent != null) {
                        sendAccessibilityEvent(createTextChangedEvent);
                    }
                    if (semanticsNode5.previousTextSelectionBase != semanticsNode5.textSelectionBase || semanticsNode5.previousTextSelectionExtent != semanticsNode5.textSelectionExtent) {
                        AccessibilityEvent obtainAccessibilityEvent3 = obtainAccessibilityEvent(semanticsNode5.id, UserMetadata.MAX_INTERNAL_KEY_SIZE);
                        obtainAccessibilityEvent3.getText().add(str2);
                        obtainAccessibilityEvent3.setFromIndex(semanticsNode5.textSelectionBase);
                        obtainAccessibilityEvent3.setToIndex(semanticsNode5.textSelectionExtent);
                        obtainAccessibilityEvent3.setItemCount(str2.length());
                        sendAccessibilityEvent(obtainAccessibilityEvent3);
                    }
                }
            }
        }
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel, final AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.accessibleNavigation = false;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() { // from class: io.flutter.view.AccessibilityBridge.1
            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void announce(String str) {
                if (Build.VERSION.SDK_INT >= 36) {
                    Log.w(AccessibilityBridge.TAG, "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
                }
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onFocus(int i) {
                AccessibilityBridge.this.sendAccessibilityEvent(i, 8);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onLongPress(int i) {
                AccessibilityBridge.this.sendAccessibilityEvent(i, 2);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onTap(int i) {
                AccessibilityBridge.this.sendAccessibilityEvent(i, 1);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onTooltip(String str) {
                if (Build.VERSION.SDK_INT < 28) {
                    AccessibilityEvent obtainAccessibilityEvent = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                    obtainAccessibilityEvent.getText().add(str);
                    AccessibilityBridge.this.sendAccessibilityEvent(obtainAccessibilityEvent);
                }
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void setLocale(String str) {
                AccessibilityBridge.this.setLocale(str);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateCustomAccessibilityActions(byteBuffer, strArr);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer byteBuffer2 : byteBufferArr) {
                    byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.updateSemantics(byteBuffer, strArr, byteBufferArr);
            }
        };
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.2
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public void onAccessibilityStateChanged(boolean z3) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (!z3) {
                        AccessibilityBridge.this.setAccessibleNavigation(false);
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(null);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                    } else {
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z3, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                    }
                }
            }
        };
        this.accessibilityStateChangeListener = accessibilityStateChangeListener;
        ContentObserver contentObserver = new ContentObserver(new Handler()) { // from class: io.flutter.view.AccessibilityBridge.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z3) {
                onChange(z3, null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z3, Uri uri) {
                if (AccessibilityBridge.this.isReleased) {
                    return;
                }
                if (Settings.Global.getFloat(AccessibilityBridge.this.contentResolver, "transition_animation_scale", AccessibilityBridge.DEFAULT_TRANSITION_ANIMATION_SCALE) == AccessibilityBridge.DISABLED_TRANSITION_ANIMATION_SCALE) {
                    AccessibilityBridge.access$1176(AccessibilityBridge.this, AccessibilityFeature.DISABLE_ANIMATIONS.value);
                } else {
                    AccessibilityBridge.access$1172(AccessibilityBridge.this, ~AccessibilityFeature.DISABLE_ANIMATIONS.value);
                }
                AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
            }
        };
        this.animationScaleObserver = contentObserver;
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel;
        this.accessibilityManager = accessibilityManager;
        this.contentResolver = contentResolver;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate;
        accessibilityStateChangeListener.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.4
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public void onTouchExplorationStateChanged(boolean z3) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (!z3) {
                        AccessibilityBridge.this.setAccessibleNavigation(false);
                        AccessibilityBridge.this.onTouchExplorationExit();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager.isEnabled(), z3);
                    }
                }
            }
        };
        this.touchExplorationStateChangeListener = touchExplorationStateChangeListener;
        touchExplorationStateChangeListener.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        this.accessibilityFeatureFlags |= AccessibilityFeature.NO_ANNOUNCE.value;
        contentObserver.onChange(false);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, contentObserver);
        if (Build.VERSION.SDK_INT >= 31) {
            setBoldTextFlag();
        }
        platformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i) {
        return AccessibilityNodeInfo.obtain(view, i);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent, boolean z3) {
        if (!this.accessibilityManager.isTouchExplorationEnabled() || this.flutterSemanticsTree.isEmpty()) {
            return false;
        }
        SemanticsNode hitTest = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), DISABLED_TRANSITION_ANIMATION_SCALE, DEFAULT_TRANSITION_ANIMATION_SCALE}, z3);
        if (hitTest != null && hitTest.platformViewId != -1) {
            if (z3) {
                return false;
            }
            return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(hitTest.id, motionEvent);
        }
        if (motionEvent.getAction() != 9 && motionEvent.getAction() != 7) {
            if (motionEvent.getAction() == 10) {
                onTouchExplorationExit();
            } else {
                Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
        } else {
            handleTouchExploration(motionEvent.getX(), motionEvent.getY(), z3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }

    public AccessibilityEvent obtainAccessibilityEvent(int i) {
        return AccessibilityEvent.obtain(i);
    }
}
