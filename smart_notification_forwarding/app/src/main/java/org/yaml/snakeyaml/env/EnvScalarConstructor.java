package org.yaml.snakeyaml.env;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.constructor.AbstractConstruct;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.MissingEnvironmentVariableException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
public class EnvScalarConstructor extends Constructor {
    public static final Tag ENV_TAG = new Tag("!ENV");
    public static final Pattern ENV_FORMAT = Pattern.compile("^\\$\\{\\s*((?<name>\\w+)((?<separator>:?(-|\\?))(?<value>\\S+)?)?)\\s*\\}$");

    public EnvScalarConstructor() {
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    public EnvScalarConstructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(typeDescription, collection, loaderOptions);
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    /* loaded from: classes2.dex */
    private class ConstructEnv extends AbstractConstruct {
        private ConstructEnv() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            Matcher matcher = EnvScalarConstructor.ENV_FORMAT.matcher(EnvScalarConstructor.this.constructScalar((ScalarNode) node));
            matcher.matches();
            String group = matcher.group("name");
            String group2 = matcher.group("value");
            String group3 = matcher.group("separator");
            EnvScalarConstructor envScalarConstructor = EnvScalarConstructor.this;
            if (group2 == null) {
                group2 = JsonProperty.USE_DEFAULT_NAME;
            }
            return envScalarConstructor.apply(group, group3, group2, envScalarConstructor.getEnv(group));
        }
    }

    public String apply(String str, String str2, String str3, String str4) {
        if (str4 != null && !str4.isEmpty()) {
            return str4;
        }
        if (str2 == null) {
            return JsonProperty.USE_DEFAULT_NAME;
        }
        if (str2.equals("?") && str4 == null) {
            throw new MissingEnvironmentVariableException("Missing mandatory variable " + str + ": " + str3);
        }
        if (str2.equals(":?")) {
            if (str4 == null) {
                throw new MissingEnvironmentVariableException("Missing mandatory variable " + str + ": " + str3);
            }
            if (str4.isEmpty()) {
                throw new MissingEnvironmentVariableException("Empty mandatory variable " + str + ": " + str3);
            }
        }
        return str2.startsWith(":") ? (str4 == null || str4.isEmpty()) ? str3 : JsonProperty.USE_DEFAULT_NAME : str4 == null ? str3 : JsonProperty.USE_DEFAULT_NAME;
    }

    public String getEnv(String str) {
        return System.getenv(str);
    }
}
