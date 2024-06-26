package com.eugentia.app.views.itemlabel;

import com.eugentia.app.components.ItemLabelComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.Rect;
import com.vaadin.flow.component.svg.elements.Text;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@PageTitle("Item Label")
@Route(value = "item-label", layout = MainLayout.class)
@RolesAllowed("USER")
public class ItemLabelView extends VerticalLayout {
    public ItemLabelView() {
        ItemLabelComponent itemLabelComponent = new ItemLabelComponent();
        add(itemLabelComponent);
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }
}
