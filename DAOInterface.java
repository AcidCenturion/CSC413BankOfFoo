import java.sql.SQLException;

public interface DAOInterface<T> {
    /**
     * Get whatever kind of object is stored in the db
     */
    T get(int id) throws SQLException;

    /**
     * Add something into the db
     */
    int insert(T e) throws SQLException;

    /**
     * Update an entry in the db
     */
    int update(T e) throws SQLException;

    /**
     * Remove an entry from db
     */
    int delete(T e) throws SQLException;
}
