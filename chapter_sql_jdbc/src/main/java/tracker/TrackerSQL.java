package tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 29.07.2019
 * @version 1
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS item(id SERIAL  PRIMARY KEY, name VARCHAR (100), description VARCHAR (100))";
    private static final String ADDING_ITEM = "INSERT INTO item (name, description) VALUES (?, ?)";
    private static final String REPLACE_ITEM = "UPDATE item SET name = ?, description = ? WHERE item.id = ?";
    private static final String FIND_ALL_ITEMS = "SELECT * FROM item";
    private static final String DELETE_ITEM = "DELETE FROM item WHERE item.id = ?";
    private static final String FIND_BY_NAME = "SELECT id, name, description FROM item WHERE item.name = ?";
    private static final String FIND_BY_ID = "SELECT * FROM item WHERE item.id = ?";
    private static final String DROP_TABLE = "DROP TABLE item";

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(Objects.requireNonNull(in));
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection != null;
    }

    public boolean createBase() {
        boolean result = false;
        try (Statement st = connection.createStatement()) {
            st.execute(CREATE_TABLE);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = connection.prepareStatement(ADDING_ITEM, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.execute();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                item.setId(String.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement(REPLACE_ITEM)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setInt(3, Integer.parseInt(id));
            st.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement(DELETE_ITEM)) {
            st.setInt(1, Integer.parseInt(id));
            st.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_ITEMS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String desc = rs.getString("description");
                String name = rs.getString("name");
                Item item = new Item(name, desc);
                item.setId(String.valueOf(rs.getInt("id")));
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String desc = rs.getString("description");
                Item item = new Item(name, desc);
                item.setId(String.valueOf(rs.getInt("id")));
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, Integer.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Item(
                        rs.getString("name"),
                        rs.getString("description")
                );
                result.setId(String.valueOf(rs.getInt("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean dropTheTable() {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement(DROP_TABLE)) {
            st.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception{
        connection.close();
    }
}