import java.util.ArrayList;
import java.util.List;

public class Application {
    List<Document> docs = new ArrayList<>();
    void addDoc(Document doc){
        docs.add(doc);
    }
    void present(){
        for (Document doc : docs){
            System.out.println(doc.getName());
        }
    }
}
