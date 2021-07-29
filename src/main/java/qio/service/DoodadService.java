package qio.service;

import qio.model.Doodad;
import qio.repo.DoodadRepo;
import qio.Qio;
import qio.annotate.Inject;
import qio.annotate.Service;
import qio.model.web.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DoodadService {

    @Inject
    DoodadRepo doodadRepo;

    public String getList(ResponseData data) {
        List<Doodad> doodads = doodadRepo.getList();
        data.put("doodads", doodads);
        return "/pages/doodad/list.jsp";
    }

    public String getCreate(ResponseData data) {
        return "/pages/doodad/create.jsp";
    }

    public String saveDoodad(HttpServletRequest req, ResponseData data) {
        String name = req.getParameter("name");
        if(name == null ||
                name.equals("")){
            data.put("message", "Name on Doodad cannot be blank!");
            return "[redirect]/create";
        }
        Doodad doodad = new Doodad();
        doodad.setName(name);
        doodadRepo.save(doodad);
        data.put("message", "Successfully added doodad!");
        return "[redirect]/doodads";
    }

    public String getEdit(Integer id, ResponseData data) {
        Doodad doodad = doodadRepo.get(id);
        data.put("doodad", doodad);
        return "/pages/doodad/edit.jsp";
    }

    public String updateDoodad(Integer id, HttpServletRequest req, ResponseData data) {
        Doodad doodad = doodadRepo.get(id);
        doodad.setName(req.getParameter("name"));
        doodadRepo.update(doodad);
        data.put("message", "Successfully updated doodad!");
        return "[redirect]/doodads/edit/" + doodad.getId();
    }

    public String deleteDoodad(Integer id, ResponseData data) {
        doodadRepo.delete(id);
        data.put("message", "Successfully deleted doodad!");
        return "[redirect]/doodads";
    }
}
