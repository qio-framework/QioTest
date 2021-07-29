package qio.web;

import qio.service.DoodadService;
import qio.annotate.HttpHandler;
import qio.annotate.Inject;
import qio.annotate.Variable;
import qio.annotate.verbs.Get;
import qio.annotate.verbs.Post;
import qio.model.web.ResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@HttpHandler
public class DoodadHandler {

    @Inject
    DoodadService doodadService;

    @Get("/")
    public String hello(HttpServletRequest request,
                        HttpServletResponse response,
                        ResponseData data){
        return "/pages/index.jsp";
    }

    @Get("/doodads")
    public String getList(HttpServletRequest request,
                          HttpServletResponse response,
                          ResponseData data){
        return doodadService.getList(data);
    }

    @Get("/doodads/create")
    public String getCreate(HttpServletRequest req,
                            HttpServletResponse resp,
                            ResponseData data){
        return doodadService.getCreate(data);
    }

    @Post("/doodads/save")
    public String saveDoodad(HttpServletRequest req,
                           HttpServletResponse resp,
                           ResponseData data){
        return doodadService.saveDoodad(req, data);
    }

    @Get("/doodads/edit/{{id}}")
    public String getEdit(HttpServletRequest req,
                          HttpServletResponse resp,
                          ResponseData data,
                          @Variable Integer id){
        return doodadService.getEdit(id, data);
    }

    @Post("/doodads/update/{{id}}")
    public String updateDoodad(HttpServletRequest req,
                             HttpServletResponse resp,
                             ResponseData data,
                             @Variable Integer id){
        return doodadService.updateDoodad(id, req, data);
    }

    @Post("/doodads/delete/{{id}}")
    public String deleteDoodad(HttpServletRequest req,
                             HttpServletResponse resp,
                             ResponseData data,
                             @Variable Integer id){
        return doodadService.deleteDoodad(id, data);
    }


}
