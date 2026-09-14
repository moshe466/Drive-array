package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import org.yaml.snakeyaml.DumperOptions;

/* loaded from: classes.dex */
public class YAMLFactoryBuilder extends TSFBuilder<YAMLFactory, YAMLFactoryBuilder> {
    protected int _formatGeneratorFeatures;
    protected StringQuotingChecker _quotingChecker;
    protected DumperOptions.Version _version;

    /* JADX INFO: Access modifiers changed from: protected */
    public YAMLFactoryBuilder() {
        this._formatGeneratorFeatures = YAMLFactory.DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
    }

    public YAMLFactoryBuilder(YAMLFactory yAMLFactory) {
        super(yAMLFactory);
        this._formatGeneratorFeatures = yAMLFactory._yamlGeneratorFeatures;
        this._version = yAMLFactory._version;
        this._quotingChecker = yAMLFactory._quotingChecker;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature feature) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature feature, YAMLGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        for (YAMLGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = feature2.getMask() | this._formatGeneratorFeatures;
        }
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature feature) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature feature, YAMLGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        for (YAMLGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = (~feature2.getMask()) & this._formatGeneratorFeatures;
        }
        return this;
    }

    public YAMLFactoryBuilder configure(YAMLGenerator.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public YAMLFactoryBuilder stringQuotingChecker(StringQuotingChecker stringQuotingChecker) {
        this._quotingChecker = stringQuotingChecker;
        return this;
    }

    public YAMLFactoryBuilder yamlVersionToWrite(DumperOptions.Version version) {
        this._version = version;
        return this;
    }

    public int formatGeneratorFeaturesMask() {
        return this._formatGeneratorFeatures;
    }

    public DumperOptions.Version yamlVersionToWrite() {
        return this._version;
    }

    public StringQuotingChecker stringQuotingChecker() {
        StringQuotingChecker stringQuotingChecker = this._quotingChecker;
        return stringQuotingChecker != null ? stringQuotingChecker : StringQuotingChecker.Default.instance();
    }

    @Override // com.fasterxml.jackson.core.TSFBuilder
    public YAMLFactory build() {
        return new YAMLFactory(this);
    }
}
