package com.eugentia.app.components;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@NpmPackage(value = "katex", version = "0.16.10")
@JsModule("./scripts/lit/math-element.ts")
@Tag("math-element")
public class MathComponent extends HorizontalLayout implements HasSize, HasStyle {
    public MathComponent() {
        setSizeFull();
    }
}