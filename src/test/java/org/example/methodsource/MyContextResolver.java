package org.example.methodsource;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

class MyContextResolver extends TypeBasedParameterResolver<MyContext> {

    @Override
    public MyContext resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return new MyContext();
    }

}