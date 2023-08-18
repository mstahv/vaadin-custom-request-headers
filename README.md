# Example project how to customise XHR object in a Vaadin app

This is an example of the infamous hack how XHRs have been customized during the AJAX era, adapted to Vaadin. Modifies the XHR object in the browser to add a custom header to all requests.

DISCLAIMER: Although this works and the hack has been used "always", before putting this into production I encourage you to stop and think if there is a better way to achieve your goal.

To run the project, run `mvn jetty:run` and open [http://localhost:8080](http://localhost:8080) in browser.

To update to the latest available Vaadin release, issue `mvn 
versions:update-properties`

Some useful links:
- [Feature overview](https://vaadin.com/flow)
- [Documentation](https://vaadin.com/docs/flow/Overview.html)
- [Tutorials](https://vaadin.com/tutorials?q=tag:Flow) 
- [Component Java integrations and examples](https://vaadin.com/components)