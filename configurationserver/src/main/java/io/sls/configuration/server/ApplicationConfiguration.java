package io.sls.configuration.server;

import io.sls.configuration.jackson.JacksonContextResolver;
import io.sls.permission.interceptor.PermissionRequestInterceptor;
import io.sls.permission.interceptor.PermissionResponseInterceptor;
import io.sls.persistence.interceptor.DocumentDescriptorInterceptor;
import io.sls.server.exception.IllegalArgumentExceptionMapper;
import io.sls.server.rest.providers.URIMessageBodyProvider;
import io.sls.staticresources.impl.interceptor.ContentTypeInterceptor;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ginccc
 */
public class ApplicationConfiguration extends Application {
    private final Set<Class<?>> CLASSES;

    public ApplicationConfiguration() {
        Set<Class<?>> tmp = new LinkedHashSet<>();

        tmp.add(ContentTypeInterceptor.class);
        tmp.add(PermissionRequestInterceptor.class);
        tmp.add(PermissionResponseInterceptor.class);
        tmp.add(DocumentDescriptorInterceptor.class);
        tmp.add(IllegalArgumentExceptionMapper.class);

        tmp.add(JacksonContextResolver.class);
        tmp.add(URIMessageBodyProvider.class);

        CLASSES = Collections.unmodifiableSet(tmp);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return CLASSES;
    }
}