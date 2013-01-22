package chapter19.practice6;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class Frameworks {
    private static final Map<ApplicationServer, Set<Database>> supportPairs = new EnumMap<>(ApplicationServer.class);
    static {
        for (ApplicationServer applicationServer : ApplicationServer.values()) {
            Set<Database> databases = null;
            switch (applicationServer) {
            case GlassFish:
                databases = EnumSet.of(Database.DB2, Database.MySQL, Database.Oracle, Database.PostgreSQL);
                break;
            case JBoss:
                databases = EnumSet.of(Database.DB2, Database.PostgreSQL);
                break;
            case Tomcat:
                databases = EnumSet.of(Database.MySQL);
                break;
            default:
                databases = Collections.emptySet();
            }
            supportPairs.put(applicationServer, databases);
        }
    }

    public static boolean isSupport(ApplicationServer applicationServer, Database database) {
        return supportPairs.get(applicationServer).contains(database);
    }

}
