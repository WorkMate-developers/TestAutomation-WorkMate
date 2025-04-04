package utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;

public class DatabaseUtils extends LoggerUtils {

    public static final String sEnvironment = System.getProperty("environment");
    public static final List<String> DATABASE_PARAMS = PropertiesUtils.getDatabaseParameters(sEnvironment);

    private static final String DB_URL = DATABASE_PARAMS.get(0);
    private static final String DB_USER = DATABASE_PARAMS.get(1);
    private static final String DB_PASS = DATABASE_PARAMS.get(2);

    private Connection connection = null;

    protected Connection openConnection() {
        try {
            log.info("Connecting to database {}", DB_URL);
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            Assert.fail("Cannot open connection to database on " + DB_URL + ", error: " + e.getMessage());
        }
        return this.connection;
    }

    protected void closeConnection() {
        if(this.connection != null) {
            try {
                if(!this.connection.isClosed()) {
                    DbUtils.close(this.connection);
                }
            } catch (SQLException e) {
                Assert.fail("Failed to close the DB connection: " + DB_URL);
            }
        }
    }

    protected String executeSqlStatement(String sqlStatement) {
        String queryResponse = null;
        QueryRunner queryRunner = new QueryRunner();
        ScalarHandler<String> scalarHandler = new ScalarHandler<>();
        try {
            queryResponse = queryRunner.query(this.connection, sqlStatement, scalarHandler);
        } catch (SQLException e) {
            Assert.fail("SQL query: " + sqlStatement + " failed with error: " + e.getMessage());
        }
        return queryResponse;
    }
}
