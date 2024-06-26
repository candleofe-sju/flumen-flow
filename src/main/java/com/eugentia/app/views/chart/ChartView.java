package com.eugentia.app.views.chart;

import com.eugentia.app.components.ChartComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Chart")
@Route(value = "chart", layout = MainLayout.class)
@RolesAllowed("USER")
public class ChartView extends VerticalLayout {
    public ChartView() {
        setClassName("chart-view");
        setSizeFull();

        ChartComponent component = new ChartComponent();
        add(component);
    }
}