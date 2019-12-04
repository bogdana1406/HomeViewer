package bogdana.example.databaseviewer.service;

import bogdana.example.databaseviewer.connection.MyConnection;
import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadTablesToDatabase implements NodeRepository {

    @Autowired
    MyConnection myConnection;



    @Override
    public MyNode parsChildrenToNode(MyNode parentNode) throws SQLException {

        if (myConnection == null) {
            myConnection = new MyConnection();
        }
        Connection conn = myConnection.getConnection();

        DatabaseMetaData meta = conn.getMetaData();
        String[] types = { "TABLE" };
        String databaseName = parentNode.getParentName();
        System.out.println("databaseName    " + databaseName);

        ResultSet resultSet = meta.getTables(databaseName, null, null, types);
        String tableName;
        // из дерева получаем узел (ребенка) с названием БД, а у него узел таблиц
//        MyNode dbTableNode = parentNode.getChild(databaseName).getChild("TableNodes");
        while (resultSet.next()) {
            // пока в resultSet содежаться таблицы создаем новый узел
            MyNode tableNode = new MyNode();
            // получаем имя таблицы
            tableName = resultSet.getString("TABLE_NAME");
            // устанавливаем новому узлу имя, соответсвующее названию таблицы
            tableNode.setName(tableName);

            tableNode.setType("table");
            // добавляем в узел БД узел таблицы (каждой)
            parentNode.addChild(tableNode);
        }
        return parentNode;

    }
}
