package dummy;


import java.net.InetAddress;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;

@Path("/index")
public class IndexResource {

    @Inject
    Template index; 

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@HeaderParam("User-Agent") String userAgent) {
        String hostName = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            hostName = ia.getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return index.data("userAgent", userAgent, "hostName", hostName);  
    }
}
