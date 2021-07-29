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

    @Get("/object/{{doodad}}/{{id}}")
    public String getThing(HttpServletRequest req,
                            HttpServletResponse resp,
                            ResponseData data,
                            @Variable String doodad,
                            @Variable Integer id){
        return doodadService.getThing(id, doodad, data);
    }


    public DoodadService getDoodadService(){
        return this.doodadService;
    }
}
