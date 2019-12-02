package bogdana.example.databaseviewer.service;

import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.repository.NodeRepository;

import java.sql.SQLException;

public class LoadNodesToDatabase implements NodeRepository {
    @Override
    public MyNode parsChildrenToNode(MyNode parentNode) throws SQLException {
        MyNode tableNode = new MyNode();
        tableNode.setName("TableNodes");
        tableNode.setType("tables");
        // узел Views
        MyNode viewNode = new MyNode();
        viewNode.setName("ViewsNodes");
        viewNode.setType("views");
        // узел Stored_Procedures
        MyNode procedureNode = new MyNode();
        procedureNode.setName("Stored_Procedures_Nodes");
        procedureNode.setType("storedProcedures");
        // узел Functions
        MyNode functionNode = new MyNode();
        functionNode.setName("FunctionsNodes");
        functionNode.setType("functions");
        parentNode.addChild(tableNode);
        parentNode.addChild(viewNode);
        parentNode.addChild(procedureNode);
        parentNode.addChild(functionNode);

        return parentNode;
    }

}
