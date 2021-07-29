package qio.repo;

import qio.model.Doodad;
import qio.Qio;
import qio.annotate.DataStore;
import qio.annotate.Inject;

import java.util.ArrayList;
import java.util.List;

@DataStore
public class DoodadRepo {

    @Inject
    Qio qio;

    public Long getCount() {
        String sql = "select count(*) from doodads";
        Long count = qio.getLong(sql, new Object[]{});
        return count;
    }

    public Doodad get(int id){
        String sql = "select * from doodads where id = [+]";
        Doodad doodad = (Doodad) qio.get(sql, new Object[]{ id }, Doodad.class);
        return doodad;
    }

    public List<Doodad> getList(){
        String sql = "select * from doodads";
        List<Doodad> doodads = (ArrayList) qio.getList(sql, new Object[]{}, Doodad.class);
        return doodads;
    }

    public boolean save(Doodad doodad){
        String sql = "insert into doodads (name) values ('[+]')";
        qio.save(sql, new Object[] {
                doodad.getName()
        });
        return true;
    }

    public boolean update(Doodad doodad) {
        String sql = "update doodads set name = '[+]' where id = [+]";
        qio.update(sql, new Object[] {
                doodad.getName(),
                doodad.getId()
        });
        return true;
    }

    public boolean delete(long id){
        String sql = "delete from doodads where id = [+]";
        qio.delete(sql, new Object[] { id });
        return true;
    }

}
