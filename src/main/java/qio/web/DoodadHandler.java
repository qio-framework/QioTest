package qio.web;

import qio.annotate.HttpHandler;
import qio.annotate.Inject;
import qio.annotate.Variable;
import qio.annotate.verbs.Get;
import qio.model.web.ResponseData;
import qio.service.DoodadService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@HttpHandler
public class DoodadHandler {

    @Inject
    DoodadService doodadService;

    @Get("/objects")
    public String getThing(HttpServletRequest req,
                            HttpServletResponse resp,
                            ResponseData data){
        return doodadService.getObject(data);
    }


    public DoodadService getDoodadService(){
        return this.doodadService;
    }
}
