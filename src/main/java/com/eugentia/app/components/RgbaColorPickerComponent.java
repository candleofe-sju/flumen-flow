package com.eugentia.app.components;

import com.eugentia.app.views.react.RgbaColor;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;
import com.vaadin.flow.function.SerializableConsumer;
import elemental.json.JsonObject;

@NpmPackage(value = "react-colorful", version = "5.6.1")
@JsModule("./views/react/rgba-color-picker.tsx")
@Tag("rgba-color-picker")
public class RgbaColorPickerComponent extends ReactAdapterComponent {

    public RgbaColorPickerComponent() {
        addPersonDataUpdateListener();
        setColor(new RgbaColor(255, 0, 0, 0.5));
    }

    public RgbaColor getColor() {
        return getState("color", RgbaColor.class);
    }

    public void setColor(RgbaColor color) {
        setState("color", color);
    }

    public void addColorChangeListener(SerializableConsumer<RgbaColor> listener) {
        addStateChangeListener("color", RgbaColor.class, listener);
    }

    public void addPersonDataUpdateListener() {
        getElement().addEventListener("update", event -> {
            JsonObject person = event.getEventData();
            // person update code goes here...
        }).addEventData("event.detail");
    }
}
