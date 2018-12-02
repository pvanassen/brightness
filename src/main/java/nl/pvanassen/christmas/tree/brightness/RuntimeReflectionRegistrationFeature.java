package nl.pvanassen.christmas.tree.brightness;

import com.oracle.svm.core.annotate.AutomaticFeature;
import io.micronaut.discovery.DiscoveryClient;
import io.micronaut.management.health.indicator.HealthIndicator;
import nl.pvanassen.christmas.tree.brightness.client.GraphiteDatapoint;
import nl.pvanassen.christmas.tree.brightness.client.GraphiteResponse;
import org.graalvm.nativeimage.Feature;
import org.graalvm.nativeimage.RuntimeReflection;

@AutomaticFeature
class RuntimeReflectionRegistrationFeature implements Feature {

    public void beforeAnalysis(BeforeAnalysisAccess access) {
        RuntimeReflection.register(DiscoveryClient.class);
        RuntimeReflection.register(DiscoveryClient[].class);
        RuntimeReflection.register(HealthIndicator[].class);
        RuntimeReflection.register(GraphiteResponse.class);
        RuntimeReflection.register(GraphiteDatapoint.class);
        RuntimeReflection.register(GraphiteResponse.class.getDeclaredConstructors());
        RuntimeReflection.register(GraphiteDatapoint.class.getDeclaredConstructors());
        RuntimeReflection.register(GraphiteResponse[].class);
        RuntimeReflection.register(true, GraphiteResponse.class.getFields());
        RuntimeReflection.register(true, GraphiteDatapoint.class.getFields());
    }
}