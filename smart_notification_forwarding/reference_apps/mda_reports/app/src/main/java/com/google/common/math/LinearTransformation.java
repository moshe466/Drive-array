package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class LinearTransformation {

    /* loaded from: classes2.dex */
    public static final class LinearTransformationBuilder {
        private final double x1;
        private final double y1;

        private LinearTransformationBuilder(double d, double d2) {
            this.x1 = d;
            this.y1 = d2;
        }

        public LinearTransformation and(double d, double d2) {
            Preconditions.checkArgument(DoubleUtils.c(d) && DoubleUtils.c(d2));
            double d3 = this.x1;
            if (d != d3) {
                return withSlope((d2 - this.y1) / (d - d3));
            }
            Preconditions.checkArgument(d2 != this.y1);
            return new VerticalLinearTransformation(this.x1);
        }

        public LinearTransformation withSlope(double d) {
            Preconditions.checkArgument(!Double.isNaN(d));
            return DoubleUtils.c(d) ? new RegularLinearTransformation(d, this.y1 - (this.x1 * d)) : new VerticalLinearTransformation(this.x1);
        }
    }

    /* loaded from: classes2.dex */
    private static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation a = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            return Double.NaN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class RegularLinearTransformation extends LinearTransformation {
        final double a;
        final double b;

        @LazyInit
        LinearTransformation c;

        RegularLinearTransformation(double d, double d2) {
            this.a = d;
            this.b = d2;
            this.c = null;
        }

        RegularLinearTransformation(double d, double d2, LinearTransformation linearTransformation) {
            this.a = d;
            this.b = d2;
            this.c = linearTransformation;
        }

        private LinearTransformation createInverse() {
            double d = this.a;
            return d != 0.0d ? new RegularLinearTransformation(1.0d / d, (this.b * (-1.0d)) / d, this) : new VerticalLinearTransformation(this.b, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.c;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.c = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return this.a == 0.0d;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.a;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.a), Double.valueOf(this.b));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            return (d * this.a) + this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class VerticalLinearTransformation extends LinearTransformation {
        final double a;

        @LazyInit
        LinearTransformation b;

        VerticalLinearTransformation(double d) {
            this.a = d;
            this.b = null;
        }

        VerticalLinearTransformation(double d, LinearTransformation linearTransformation) {
            this.a = d;
            this.b = linearTransformation;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.a, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.b;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.b = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.a));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            throw new IllegalStateException();
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.a;
    }

    public static LinearTransformation horizontal(double d) {
        Preconditions.checkArgument(DoubleUtils.c(d));
        return new RegularLinearTransformation(0.0d, d);
    }

    public static LinearTransformationBuilder mapping(double d, double d2) {
        Preconditions.checkArgument(DoubleUtils.c(d) && DoubleUtils.c(d2));
        return new LinearTransformationBuilder(d, d2);
    }

    public static LinearTransformation vertical(double d) {
        Preconditions.checkArgument(DoubleUtils.c(d));
        return new VerticalLinearTransformation(d);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);
}
