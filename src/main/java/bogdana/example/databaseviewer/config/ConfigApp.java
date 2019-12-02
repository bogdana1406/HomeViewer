package bogdana.example.databaseviewer.config;

import bogdana.example.databaseviewer.connection.MyConnection;
import bogdana.example.databaseviewer.model.tree.MyNode;
import bogdana.example.databaseviewer.model.tree.MyTree;
import bogdana.example.databaseviewer.service.NodeTypeChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    public MyNode myNode() {
        return new MyNode();
    }

    @Bean
    public MyTree myTree() {
        return new MyTree();
    }

    @Bean
    public MyConnection myConnection() {
        return new MyConnection();
    }

    @Bean
    public NodeTypeChooser nodeLoaderChooser() {
        return new NodeTypeChooser();
    }

}
