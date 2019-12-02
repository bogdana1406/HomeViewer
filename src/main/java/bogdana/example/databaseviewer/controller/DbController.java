package bogdana.example.databaseviewer.controller;

import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.model.tree.MyTree;
import bogdana.example.databaseviewer.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path="/db")
@CrossOrigin
public class DbController {

    @Autowired
    NodeService nodeService;

    @Autowired
    MyNode startNode;

    @Autowired
    MyTree tree;

    @GetMapping(path = "/ex")
    public String check() {
        return "welcome";
    }

    @GetMapping(path = "/node")
    public MyNode getInitialNode() {
        startNode.setName("SCHEMA");
        startNode.setType("schema");
        tree.setRoot(startNode);
        return startNode;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewNode(@RequestBody MyNode node) throws SQLException {
        System.out.println(node.getName() + "   " + node.getType() + " " + node.getParentName());

        MyNode myNode = nodeService.parceNodeChildren(node);
        List<MyNode> children = myNode.getChildren();

        MyNode root = tree.getRoot();
        MyNode rootBranch = root.findNodeById(node.getId());
        rootBranch.setChildren(children);

        System.out.println("structura");
        tree.printTree(root, " ");
//        startNode.addChild(myNode);
//        for (MyNode child: children) {
//            System.out.println(child.getName() + " " + child.getId());
//        }

        return new ResponseEntity<MyNode>(myNode, HttpStatus.CREATED);

//        return new ResponseEntity<MyTree>(tree, HttpStatus.CREATED);

    }

}
