package com.eugentia.app.views.pdf;

import com.eugentia.app.views.MainLayout;
import com.vaadin.componentfactory.pdfviewer.PdfViewer;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Thumbnails Listener")
@Route(value = "thumbnails-listener", layout = MainLayout.class)
@RolesAllowed("USER")
public class ThumbnailsListenerExample extends VerticalLayout {

    public ThumbnailsListenerExample() {
        setSizeFull();

        PdfViewer pdfViewer = new PdfViewer();
        pdfViewer.setSizeFull();
        StreamResource resource = new StreamResource("example.pdf", () -> getClass().getResourceAsStream("/pdf/example.pdf"));
        pdfViewer.setSrc(resource);
        pdfViewer.addThumbnailClickedListener(e -> {
            Notification.show("Selected page on thumbnail click: " + e.getSelectedPage());
        });
        add(pdfViewer);
    }

}
