package com.eugentia.app.views.about;

import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
@RolesAllowed("USER")
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(true);

        Image img = new Image("images/flumen.svg", "flumen");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("flumen 1.0");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set( "border" , "1px dashed Black" ) ;
    }

}
