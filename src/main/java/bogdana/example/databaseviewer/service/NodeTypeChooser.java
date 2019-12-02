package bogdana.example.databaseviewer.service;

import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.repository.NodeRepository;

public class NodeTypeChooser {

    public NodeRepository choose(MyNode node) {

        NodeRepository nodeRepository = null;
        String typeNode = node.getType();
//        System.out.println("Type node is    " + typeNode);
        switch (typeNode) {
            case ("schema"):
                nodeRepository = new LoadDatabases();
                break;

            case ("database"):
                nodeRepository = new LoadNodesToDatabase();
                break;
//
            case ("tables"):
                nodeRepository = new LoadTablesToDatabase();
                break;

//            default:
//                nodeRepository = new TreeServiceLoaderDefault();
//                break;
        }
        return nodeRepository;
    }
}
