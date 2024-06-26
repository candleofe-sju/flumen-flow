package com.eugentia.app.views.react;

import com.eugentia.app.components.RgbaColorPickerComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("RGBA Color Picker")
@Route(value = "rgba-color-picker", layout = MainLayout.class)
@RolesAllowed("USER")
@Tag("rgba-color-picker")
public class RgbaColorPickerView extends VerticalLayout {

    public RgbaColorPickerView() {
        var rgbaColorPickerComponent = new RgbaColorPickerComponent();
        add(rgbaColorPickerComponent);
        setPadding(true);
        setSizeFull();
    }
}
