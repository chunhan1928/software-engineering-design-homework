import java.util.HashMap;
import java.util.Map;

public class FileView {
    Map<String, TextView> textViews = new HashMap<>();
    void addTextView(TextView textView){
        textViews.put(textView.name, textView);
    }
    TextView getTextViewByName(String name){
        return textViews.get(name);
    }
}
