package qio;

import org.junit.jupiter.api.*;
import qio.mock.MockServletContext;
import qio.model.Doodad;
import qio.model.Thingamabob;
import qio.repo.DoodadRepo;
import qio.support.DbMediator;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class QioTest {

    Qio qio;

    @BeforeAll
    public void setup() {
        try {
            ServletContext servletContext = new MockServletContext();
            qio = new Qio.Injector()
                    .devMode(true)//tells Qio to initialize h2
                    .withDataEnabled(true)//is needed when accessing a database
                    .asEmbedded(true)//yes, as we are using the maven jetty plugin
                    .withContext(servletContext)//qio needs this to store information to be used later
                    .withWebResources(new String[]{})//any directory within webapps that will serve static content
                    .withPropertyFiles(new String[]{"app.props"})//our properties files
                    .inject();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @AfterAll
    public void tearDown() throws Exception {
        DbMediator dbMediator = (DbMediator) qio.getBean("dbmediator");
        dbMediator.dropDb();
    }

    @Test
    public void injectionTest(){
        Thingamabob thingamabob = (Thingamabob) qio.getBean("thingamabob");
        assertNotNull(thingamabob.getDoodad());
    }

    @Test
    public void persistenceTest(){
        DoodadRepo doodadRepo = (DoodadRepo) qio.getBean("doodadrepo");
        Doodad doodad = new Doodad(1, "Doodad Une!");
        doodadRepo.save(doodad);
        assertTrue(doodadRepo.getCount() == 1);
    }

    @Test
    public void yListTest(){
        DoodadRepo doodadRepo = (DoodadRepo) qio.getBean("doodadrepo");
        assertTrue(doodadRepo.getList().size() == 1);
    }

    @Test
    public void zListTest(){
        DoodadRepo doodadRepo = (DoodadRepo) qio.getBean("doodadrepo");
        doodadRepo.delete(1);
        assertTrue(doodadRepo.getList().size() == 0);
    }
}
