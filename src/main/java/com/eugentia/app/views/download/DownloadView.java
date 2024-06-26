package com.eugentia.app.views.download;

import com.eugentia.app.components.ExcelComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

import java.text.SimpleDateFormat;
import java.util.Date;

@PageTitle("Download")
@Route(value = "download", layout = MainLayout.class)
@RolesAllowed("USER")
public class DownloadView extends VerticalLayout {

    public DownloadView() {
        ExcelComponent component = new ExcelComponent("Click to download");
        SimpleDateFormat sDate = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String name = "invHistory-" + sDate.format(new Date()) + ".xlsx";
        component.setFileName(name);
        add(component);
    }
}