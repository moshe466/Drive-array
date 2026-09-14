package androidx.transition;

import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;

@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
class Styleable {

    @StyleableRes
    static final int[] a = {android.R.attr.targetClass, android.R.attr.targetId, android.R.attr.excludeId, android.R.attr.excludeClass, android.R.attr.targetName, android.R.attr.excludeName};

    @StyleableRes
    static final int[] b = {android.R.attr.fromScene, android.R.attr.toScene, android.R.attr.transition};

    @StyleableRes
    static final int[] c = {android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startDelay, android.R.attr.matchOrder};

    @StyleableRes
    static final int[] d = {android.R.attr.resizeClip};

    @StyleableRes
    static final int[] e = {android.R.attr.transitionVisibilityMode};

    @StyleableRes
    static final int[] f = {android.R.attr.fadingMode};

    @StyleableRes
    static final int[] g = {android.R.attr.reparent, android.R.attr.reparentWithOverlay};

    @StyleableRes
    static final int[] h = {android.R.attr.slideEdge};

    @StyleableRes
    static final int[] i = {android.R.attr.transitionOrdering};

    @StyleableRes
    static final int[] j = {android.R.attr.minimumHorizontalAngle, android.R.attr.minimumVerticalAngle, android.R.attr.maximumAngle};

    @StyleableRes
    static final int[] k = {android.R.attr.patternPathData};

    /* loaded from: classes.dex */
    interface ArcMotion {

        @StyleableRes
        public static final int MAXIMUM_ANGLE = 2;

        @StyleableRes
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;

        @StyleableRes
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    /* loaded from: classes.dex */
    interface ChangeBounds {

        @StyleableRes
        public static final int RESIZE_CLIP = 0;
    }

    /* loaded from: classes.dex */
    interface ChangeTransform {

        @StyleableRes
        public static final int REPARENT = 0;

        @StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    /* loaded from: classes.dex */
    interface Fade {

        @StyleableRes
        public static final int FADING_MODE = 0;
    }

    /* loaded from: classes.dex */
    interface PatternPathMotion {

        @StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    /* loaded from: classes.dex */
    interface Slide {

        @StyleableRes
        public static final int SLIDE_EDGE = 0;
    }

    /* loaded from: classes.dex */
    interface Transition {

        @StyleableRes
        public static final int DURATION = 1;

        @StyleableRes
        public static final int INTERPOLATOR = 0;

        @StyleableRes
        public static final int MATCH_ORDER = 3;

        @StyleableRes
        public static final int START_DELAY = 2;
    }

    /* loaded from: classes.dex */
    interface TransitionManager {

        @StyleableRes
        public static final int FROM_SCENE = 0;

        @StyleableRes
        public static final int TO_SCENE = 1;

        @StyleableRes
        public static final int TRANSITION = 2;
    }

    /* loaded from: classes.dex */
    interface TransitionSet {

        @StyleableRes
        public static final int TRANSITION_ORDERING = 0;
    }

    /* loaded from: classes.dex */
    interface TransitionTarget {

        @StyleableRes
        public static final int EXCLUDE_CLASS = 3;

        @StyleableRes
        public static final int EXCLUDE_ID = 2;

        @StyleableRes
        public static final int EXCLUDE_NAME = 5;

        @StyleableRes
        public static final int TARGET_CLASS = 0;

        @StyleableRes
        public static final int TARGET_ID = 1;

        @StyleableRes
        public static final int TARGET_NAME = 4;
    }

    /* loaded from: classes.dex */
    interface VisibilityTransition {

        @StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    private Styleable() {
    }
}
