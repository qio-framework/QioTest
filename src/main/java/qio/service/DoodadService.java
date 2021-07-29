package qio.service;

import qio.annotate.Service;
import qio.model.web.ResponseData;

@Service
public class DoodadService {

    public String getObject(ResponseData data) {
        data.put("success", true);
        return "[redirect]/mock";
    }

    public String getThing(Integer id, String doodad, ResponseData data) {
        return "/pages/mock.jsp";
    }
}
