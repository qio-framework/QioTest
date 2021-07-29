package qio.service;

import qio.annotate.Service;
import qio.model.web.ResponseData;

@Service
public class DoodadService {
    public String getThing(Integer id, String doodad, ResponseData data) {
        data.put("success", true);
        return "/pages/mock.jsp";
    }
}
