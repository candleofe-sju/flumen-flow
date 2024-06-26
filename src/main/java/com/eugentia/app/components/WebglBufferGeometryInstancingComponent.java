package com.eugentia.app.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;

@NpmPackage(value = "three", version = "0.165.0")
@PreserveOnRefresh
@JsModule("./scripts/js/webgl-buffergeometry-instancing.js")
@Tag("webgl-buffergeometry-instancing")
public class WebglBufferGeometryInstancingComponent extends VerticalLayout {

    public WebglBufferGeometryInstancingComponent() {
        setSizeFull();
        setPadding(true);
    }
}