package qio.config;

import qio.annotate.Config;
import qio.annotate.Dependency;
import qio.annotate.Property;
import qio.jdbc.BasicDataSource;
import qio.model.Doodad;

import javax.sql.DataSource;

@Config
public class DoodadConfig {

    @Property("db.url")
    String dbUrl;

    @Property("db.user")
    String dbUser;

    @Property("db.pass")
    String dbPass;

    @Property("db.driver")
    String dbDriver;

    @Dependency
    public Doodad doodadUno(){
        return new Doodad("Doodad Uno!");
    }

    @Dependency
    public DataSource dataSource(){
        return new BasicDataSource.Builder()
                .driver(dbDriver)
                .url(dbUrl)
                .username(dbUser)
                .password(dbPass)
                .build();
    }

}
