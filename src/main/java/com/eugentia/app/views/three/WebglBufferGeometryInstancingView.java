package com.eugentia.app.views.three;

import com.eugentia.app.components.WebglBufferGeometryInstancingComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("ThreeJS")
@PreserveOnRefresh
@Route(value = "three", layout = MainLayout.class)
@RolesAllowed("USER")
public class WebglBufferGeometryInstancingView extends VerticalLayout {

    public WebglBufferGeometryInstancingView() {
        addClassName("webgl-buffergeometry-instancing-view");
        var webglBufferGeometryInstancingComponent = new WebglBufferGeometryInstancingComponent();
        add(webglBufferGeometryInstancingComponent);
        setSizeFull();
        setPadding(true);
    }
}