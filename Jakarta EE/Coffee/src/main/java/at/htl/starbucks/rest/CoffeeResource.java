package at.htl.starbucks.rest;

import at.htl.starbucks.models.Coffee;
import at.htl.starbucks.models.Roaster;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("coffees")
public class CoffeeResource {
    @Inject
    Roaster roaster;

    @Inject
    @Metric(name = "coffe_called")
    Counter count;

    @GET
    @Timed(name = "coffee_processed",
            description = "Metrics to monitor the times of coffee method.",
            unit = MetricUnits.MILLISECONDS,
            absolute = true)
    @Produces(MediaType.APPLICATION_JSON)
    public Coffee coffee(){
        count.inc();
        return this.roaster.roast();
    }
}
