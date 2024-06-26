package com.eugentia.app.views.fileDownload;

import com.eugentia.app.components.FileDownloadComponent;
import com.eugentia.app.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import jakarta.annotation.security.RolesAllowed;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@PageTitle("File Download")
@Route(value = "file-download", layout = MainLayout.class)
@RolesAllowed("USER")
public class FileDownloadView extends VerticalLayout {

    private FileDownloadComponent component;
    private String fileName = "newInvHistory-";

    public FileDownloadView() {
        Button button = new Button("Click to download");
        button.addClickListener(e -> {
        });

        component = new FileDownloadComponent();
        component.wrapComponent(button);
        component.setResource(setStreamResource());
        add(component);
    }

    private StreamResource setStreamResource() {
        return new StreamResource("foo.txt", () -> new ByteArrayInputStream("foo".getBytes())) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>(super.getHeaders());
                SimpleDateFormat date = new SimpleDateFormat("yyyyMMddhhmmssSSS");
                String name = fileName + date.format(new Date()) + ".txt";
                headers.put("Content-Disposition", "attachment; filename=\"" + name + "\"");
                return headers;
            }
        };
    }
}