package bogdana.example.databaseviewer.service;

import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class NodeService {

    @Autowired
    NodeTypeChooser nodeTypeChooser;

    public MyNode parceNodeChildren(MyNode node) throws SQLException {
        NodeRepository chooseNodeClass = nodeTypeChooser.choose(node);
        MyNode myNode = chooseNodeClass.parsChildrenToNode(node);
        return myNode;
    }
}
