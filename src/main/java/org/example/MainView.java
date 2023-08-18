package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(new Paragraph("""
                Click the first button first.
                Investigate server logs and see headers that are printend.
                Then click the second button and and first again.
                See that the new header added to the XHRs.
                """));
        Button button = new Button("Click me",
                event -> add(new Paragraph("Clicked!")));
        add(button);
        Button modifyXhr = new Button("Modify XHR",
                event -> {
                // In this example we'll modify the XHR object
                // to add a custom header to the request
                // in a real world example, probably add this
                // in JS in the host page or some script included in the bundle
                getElement().executeJs("""
                    var originalOpen = XMLHttpRequest.prototype.open;
                    XMLHttpRequest.prototype.open = function() {
                        originalOpen.apply(this, arguments);
                        this.setRequestHeader('Hello', 'World!');
                    };
                """);
                });
        add(modifyXhr);
    }
}
