package com.eugentia.app.views;

import com.eugentia.app.data.entity.User;
import com.eugentia.app.security.AuthenticatedUser;
import com.eugentia.app.views.about.AboutView;
import com.eugentia.app.views.addressform.AddressFormView;
import com.eugentia.app.views.barcode.BarcodeView;
import com.eugentia.app.views.canvas.CanvasView;
import com.eugentia.app.views.chat.ChatView;
import com.eugentia.app.views.checkoutform.CheckoutFormView;
import com.eugentia.app.views.collaborativemasterdetail.CollaborativeMasterDetailView;
import com.eugentia.app.views.creditcardform.CreditCardFormView;
import com.eugentia.app.views.dashboard.DashboardView;
import com.eugentia.app.views.datagrid.DataGridView;
import com.eugentia.app.views.download.DownloadView;
import com.eugentia.app.views.feed.FeedView;
import com.eugentia.app.views.fileDownload.DynamicFileDownloadingDemo;
import com.eugentia.app.views.greeting.SimpleGreetingView;
import com.eugentia.app.views.gridwithfilters.GridwithFiltersView;
import com.eugentia.app.views.helloworld.HelloWorldView;
import com.eugentia.app.views.imagegallery.ImageGalleryView;
import com.eugentia.app.views.itemlabel.ItemLabelView;
import com.eugentia.app.views.locale.LocaleView;
import com.eugentia.app.views.longrunning.LongRunningView;
import com.eugentia.app.views.map.MapView;
import com.eugentia.app.views.masterdetail.MasterDetailView;
import com.eugentia.app.views.math.MathView;
import com.eugentia.app.views.pageeditor.PageEditorView;
import com.eugentia.app.views.pdf.*;
import com.eugentia.app.views.personform.PersonFormView;
import com.eugentia.app.views.react.RgbaColorPickerView;
import com.eugentia.app.views.registration.RegistrationView;
import com.eugentia.app.views.spreadsheet.SpreadsheetView;
import com.eugentia.app.views.three.WebglBufferGeometryInstancingView;
import com.eugentia.app.views.uploaddownload.UploadDownloadView;
import com.eugentia.app.views.vtk.VtkView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.io.ByteArrayInputStream;
import java.util.Optional;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private final AuthenticatedUser authenticatedUser;
    private final AccessAnnotationChecker accessChecker;
    private H1 viewTitle;
    private SideNav nav;

    public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
        this.accessChecker = accessChecker;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        Span appName = new Span("flumen");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Header header = new Header(appName);
        header.addClassName("header");

        TextField search = new TextField();
        search.setValueChangeMode(ValueChangeMode.LAZY);
        search.addValueChangeListener(this::searchValueChanged);
        search.setClearButtonVisible(true);
        search.setPlaceholder("Search");
        search.addClassName("main-search");
        search.setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, search, scroller, createFooter());
    }

    private SideNav createNavigation() {
        nav = new SideNav();

        if (accessChecker.hasAccess(AboutView.class)) {
            nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.HOME_SOLID.create()));
        }

        if (accessChecker.hasAccess(HelloWorldView.class)) {
            nav.addItem(new SideNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        }

        if (accessChecker.hasAccess(DashboardView.class)) {
            nav.addItem(new SideNavItem("Dashboard", DashboardView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));
        }

        if (accessChecker.hasAccess(FeedView.class)) {
            nav.addItem(new SideNavItem("Feed", FeedView.class, LineAwesomeIcon.LIST_SOLID.create()));
        }

        if (accessChecker.hasAccess(DataGridView.class)) {
            nav.addItem(new SideNavItem("Data Grid", DataGridView.class, LineAwesomeIcon.TH_SOLID.create()));
        }

        if (accessChecker.hasAccess(MasterDetailView.class)) {
            nav.addItem(new SideNavItem("Master-Detail", MasterDetailView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));
        }

        if (accessChecker.hasAccess(CollaborativeMasterDetailView.class)) {
            nav.addItem(new SideNavItem("Collaborative Master-Detail", CollaborativeMasterDetailView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));
        }

        if (accessChecker.hasAccess(PersonFormView.class)) {
            nav.addItem(new SideNavItem("Person Form", PersonFormView.class, LineAwesomeIcon.USER.create()));
        }

        if (accessChecker.hasAccess(AddressFormView.class)) {
            nav.addItem(new SideNavItem("Address Form", AddressFormView.class, LineAwesomeIcon.MAP_MARKER_SOLID.create()));
        }

        if (accessChecker.hasAccess(CreditCardFormView.class)) {
            nav.addItem(new SideNavItem("Credit Card Form", CreditCardFormView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        }

        if (accessChecker.hasAccess(MapView.class)) {
            nav.addItem(new SideNavItem("Map", MapView.class, LineAwesomeIcon.MAP.create()));
        }

        if (accessChecker.hasAccess(SpreadsheetView.class)) {
            nav.addItem(new SideNavItem("Spreadsheet", SpreadsheetView.class, LineAwesomeIcon.FILE_EXCEL.create()));
        }

        if (accessChecker.hasAccess(ChatView.class)) {
            nav.addItem(new SideNavItem("Chat", ChatView.class, LineAwesomeIcon.COMMENTS.create()));
        }

        if (accessChecker.hasAccess(PageEditorView.class)) {
            nav.addItem(new SideNavItem("Page Editor", PageEditorView.class, LineAwesomeIcon.EDIT.create()));
        }

        if (accessChecker.hasAccess(ImageGalleryView.class)) {
            nav.addItem(new SideNavItem("Image Gallery", ImageGalleryView.class, LineAwesomeIcon.TH_LIST_SOLID.create()));
        }

        if (accessChecker.hasAccess(CheckoutFormView.class)) {
            nav.addItem(new SideNavItem("Checkout Form", CheckoutFormView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        }

        if (accessChecker.hasAccess(GridwithFiltersView.class)) {
            nav.addItem(new SideNavItem("Grid with Filters", GridwithFiltersView.class, LineAwesomeIcon.FILTER_SOLID.create()));
        }

        SideNavItem commonItem = CommonItems();

        if (!commonItem.getItems().isEmpty())
            nav.addItem(commonItem);

        SideNavItem pdfExamples = PDFExamples();

        if (!pdfExamples.getItems().isEmpty())
            nav.addItem(pdfExamples);

        SideNavItem threeJsItem = ThreeJSItems();

        if (!threeJsItem.getItems().isEmpty())
            nav.addItem(threeJsItem);

        return nav;
    }

    private SideNavItem CommonItems() {
        SideNavItem item = new SideNavItem("Common Items");

        if (accessChecker.hasAccess(BarcodeView.class)) {
            item.addItem(new SideNavItem("Barcode", BarcodeView.class, LineAwesomeIcon.BOX_OPEN_SOLID.create()));
        }

        if (accessChecker.hasAccess(CanvasView.class)) {
            item.addItem(new SideNavItem("Canvas", CanvasView.class, LineAwesomeIcon.CHART_LINE_SOLID.create()));
        }

        if (accessChecker.hasAccess(ItemLabelView.class)) {
            item.addItem(new SideNavItem("Item Label", ItemLabelView.class, LineAwesomeIcon.PLUS_SOLID.create()));
        }

        if (accessChecker.hasAccess(LocaleView.class)) {
            item.addItem(new SideNavItem("Locale", LocaleView.class, LineAwesomeIcon.CIRCLE_SOLID.create()));
        }

        if (accessChecker.hasAccess(LongRunningView.class)) {
            item.addItem(new SideNavItem("Long Running", LongRunningView.class, LineAwesomeIcon.PERCENT_SOLID.create()));
        }

        if (accessChecker.hasAccess(MathView.class)) {
            item.addItem(new SideNavItem("Math", MathView.class, LineAwesomeIcon.CIRCLE_SOLID.create()));
        }

        if (accessChecker.hasAccess(RegistrationView.class)) {
            nav.addItem(new SideNavItem("Registration", RegistrationView.class, LineAwesomeIcon.USER.create()));
        }

        if (accessChecker.hasAccess(SimpleGreetingView.class)) {
            item.addItem(new SideNavItem("Simple Greeting", SimpleGreetingView.class, LineAwesomeIcon.CHILD_SOLID.create()));
        }

        if (accessChecker.hasAccess(VtkView.class)) {
            item.addItem(new SideNavItem("VTK", VtkView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));
        }

        if (accessChecker.hasAccess(DownloadView.class)) {
            item.addItem(new SideNavItem("Download", DownloadView.class, LineAwesomeIcon.DOWNLOAD_SOLID.create()));
        }

        if (accessChecker.hasAccess(DynamicFileDownloadingDemo.class)) {
            item.addItem(new SideNavItem("Dynamic File Downloading", DynamicFileDownloadingDemo.class, LineAwesomeIcon.DOWNLOAD_SOLID.create()));
        }

        if (accessChecker.hasAccess(DynamicFileDownloadingDemo.class)) {
            item.addItem(new SideNavItem("File Download", DynamicFileDownloadingDemo.class, LineAwesomeIcon.DOWNLOAD_SOLID.create()));
        }

        if (accessChecker.hasAccess(UploadDownloadView.class)) {
            item.addItem(new SideNavItem("Upload and Download", UploadDownloadView.class, LineAwesomeIcon.DOWNLOAD_SOLID.create()));
        }

        if (accessChecker.hasAccess(RgbaColorPickerView.class)) {
            item.addItem(new SideNavItem("RGBA Color Picker", RgbaColorPickerView.class, LineAwesomeIcon.BOX_SOLID.create()));
        }

        return item;
    }

    private SideNavItem PDFExamples() {
        SideNavItem item = new SideNavItem("PDF Examples");

        if (accessChecker.hasAccess(BasicPdfViewerExample.class)) {
            item.addItem(new SideNavItem("Basic Example", BasicPdfViewerExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(AdjustZoomPdfViewerExample.class)) {
            item.addItem(new SideNavItem("Zoom example", AdjustZoomPdfViewerExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(ThumbnailsViewerOpenExample.class)) {
            item.addItem(new SideNavItem("Thumbnail viewer open example", ThumbnailsViewerOpenExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(ThumbnailsListenerExample.class)) {
            item.addItem(new SideNavItem("Thumbnail listener example", ThumbnailsListenerExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(SelectPagePdfViewerExample.class)) {
            item.addItem(new SideNavItem("Select Page", SelectPagePdfViewerExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(CustomAutoFitZoomLabelsExample.class)) {
            item.addItem(new SideNavItem("Custom label for auto and page fit options", CustomAutoFitZoomLabelsExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(WithoutDownloadExample.class)) {
            item.addItem(new SideNavItem("Without download option", WithoutDownloadExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(CustomTitleExample.class)) {
            item.addItem(new SideNavItem("Custom title", CustomTitleExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(WithPrintOptionExample.class)) {
            item.addItem(new SideNavItem("With print option", WithPrintOptionExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(RenderingInteractiveFormsExample.class)) {
            item.addItem(new SideNavItem("Rendering interactive forms", RenderingInteractiveFormsExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(WithoutZoomDropdownExample.class)) {
            item.addItem(new SideNavItem("Without zoom dropdown", WithoutZoomDropdownExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        if (accessChecker.hasAccess(SourceChangeExample.class)) {
            item.addItem(new SideNavItem("Source change", SourceChangeExample.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        }

        return item;
    }

    private SideNavItem ThreeJSItems() {
        SideNavItem item = new SideNavItem("ThreeJS Item");
        if (accessChecker.hasAccess(WebglBufferGeometryInstancingView.class)) {
            item.addItem(new SideNavItem("Webgl BufferGeometryInstancing", WebglBufferGeometryInstancingView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));
        }

        return item;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        Optional<User> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();

            Avatar avatar = new Avatar(user.getName());
            StreamResource resource = new StreamResource("profile-pic",
                    () -> new ByteArrayInputStream(user.getProfilePicture()));
            avatar.setImageResource(resource);
            avatar.setThemeName("xsmall");
            avatar.getElement().setAttribute("tabindex", "-1");

            MenuBar userMenu = new MenuBar();
            userMenu.setThemeName("tertiary-inline contrast");

            MenuItem userName = userMenu.addItem("");
            Div div = new Div();
            div.add(avatar);
            div.add(user.getName());
            div.add(new Icon("lumo", "dropdown"));
            Element element = div.getElement();
            Style style = element.getStyle();
            style.set("display", "flex");
            style.set("align-items", "center");
            style.set("gap", "var(--lumo-space-s)");
            userName.add(div);
            userName.getSubMenu().addItem("Sign out", e -> {
                authenticatedUser.logout();
            });

            layout.add(userMenu);
        } else {
            Anchor loginLink = new Anchor("login", "Sign in");
            layout.add(loginLink);
        }

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

    /**
     * Filter the side navigation items
     *
     * @param filter
     */
    private void sideNavItemFilter(String filter) {
        nav.getChildren().forEach(navItem -> {
            boolean matches = ((SideNavItem) navItem).getLabel().toLowerCase().contains(filter.toLowerCase());
            navItem.setVisible(matches);
        });
    }

    /**
     * Handle a ValueChanged event of TextField
     *
     * @param e Value change listener event
     */
    private void searchValueChanged(AbstractField.ComponentValueChangeEvent<TextField, String> e) {
        sideNavItemFilter(e.getValue());
    }
}
