package com.eugentia.app.views.math;

import com.eugentia.app.components.MathComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Math")
@Route(value = "math-view", layout = MainLayout.class)
@RolesAllowed("USER")
public class MathView extends VerticalLayout {

    public MathView() {
        addClassNames("math-view");
        MathComponent component = new MathComponent();
        component.setSizeFull();
        add(component);
    }
}
