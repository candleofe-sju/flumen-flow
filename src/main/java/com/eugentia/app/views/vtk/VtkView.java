package com.eugentia.app.views.vtk;

import com.eugentia.app.components.VtkComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("VTK")
@PreserveOnRefresh
@Route(value = "vtk", layout = MainLayout.class)
@RolesAllowed("USER")
public class VtkView extends VerticalLayout {

    public VtkView() {
        addClassName("vtk-view");

        VtkComponent component = new VtkComponent();
        add(component);
    }
}
