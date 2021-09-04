package dummy;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;

@Path("/healthz")
public class HealthzResource {

    @Inject
    Template healthz; 

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return healthz.instance();  
    }
}
