package bogdana.example.databaseviewer.repository;

import bogdana.example.databaseviewer.model.tree.MyNode;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface NodeRepository {
    MyNode parsChildrenToNode(MyNode parentNode) throws SQLException;
}
