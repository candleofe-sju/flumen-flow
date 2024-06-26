package com.eugentia.app.views.greeting;

import com.eugentia.app.components.GreetingComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Simple Greeting")
@Route(value = "simple-greeting", layout = MainLayout.class)
@RolesAllowed("USER")
public class SimpleGreetingView extends VerticalLayout {
    public SimpleGreetingView() {
        setClassName("simple-greeting-view");
        setSizeFull();

        GreetingComponent component = new GreetingComponent();
        add(component);
        component.getElement().setProperty("name", "Java");
    }
}