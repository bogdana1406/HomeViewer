package bogdana.example.databaseviewer.model.tree;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MyTree {

    @Autowired
    MyNode root;

    public MyTree() {
    }

    public MyTree(MyNode root) {
        this.root = root;
    }

    public MyNode getRoot() {
        return root;
    }

    public void setRoot(MyNode root) {
        this.root = root;
    }

    public void printTree(MyNode root, String appender) {
        System.out.println(appender + root.getName());
        root.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

    public void printTreeStructure(MyNode root) {
        System.out.println(root.getName());
//        System.out.println(root.getText());
        if (root.getAttributes() != null) {
            Map<String, String> attributes = root.getAttributes();
            for (String attr: attributes.keySet()) {
                System.out.print(attr + " = " + attributes.get(attr) + "  ");
            }
            System.out.println();

        }
        List<MyNode> children = root.getChildren();
        for (MyNode child: children) {
            printTreeStructure(child);
        }
    }

}
