package bogdana.example.databaseviewer.service;

import bogdana.example.databaseviewer.connection.MyConnection;
import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class LoadDatabases implements NodeRepository {

    @Autowired
    MyConnection myConnection;

    @Override
    public MyNode parsChildrenToNode(MyNode parentNode) throws SQLException {
        if (myConnection == null) {
            myConnection = new MyConnection();
        }
        Connection conn = myConnection.getConnection();

        DatabaseMetaData meta = conn.getMetaData();
        String databaseName;
        ResultSet resultSet = meta.getCatalogs();

        while (resultSet.next()) {
//            System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
            // для каждой БД создаем новый узел
            MyNode dataBaseNode = new MyNode();
            // получаем имя БД
            databaseName = resultSet.getString("TABLE_CAT");
            // устанавливаем название узла, соответственно названию БД
            dataBaseNode.setName(databaseName);
            dataBaseNode.setType("database");
            // к startNode (который установлен как корень дерева) добавляем узкл, с названием БД
            parentNode.addChild(dataBaseNode);
        }
//        resultSet.close();
        // возвращаем корень дерева (startNode)
        return parentNode;
    }
}
