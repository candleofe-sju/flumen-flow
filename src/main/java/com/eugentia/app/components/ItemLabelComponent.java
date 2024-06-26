package com.eugentia.app.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.Element;

@JsModule(value = "./views/react/item-label.tsx")
@Tag("item-label")
// wrapper is needed as an element to set svg-code as 'innerHTML'
public class ItemLabelComponent extends Component implements HasSize, HasStyle {
    public ItemLabelComponent() {
        setSizeFull();
    }
}
