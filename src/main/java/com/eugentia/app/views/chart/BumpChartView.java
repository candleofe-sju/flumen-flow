package com.eugentia.app.views.chart;

import com.eugentia.app.components.BumpChartComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Bump Chart")
@Route(value = "bump-chart", layout = MainLayout.class)
@RolesAllowed("USER")
public class BumpChartView extends VerticalLayout {
    public BumpChartView() {
        setClassName("bump-chart-view");
        setSizeFull();

        BumpChartComponent component = new BumpChartComponent();
        add(component);
    }
}