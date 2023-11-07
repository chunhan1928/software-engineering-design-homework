import java.util.ArrayList;
import java.util.List;

public class TextView{
    public String name;
    public String text;
    public List<Format> formats = new ArrayList<>();
    public TextView(String name, String text){
        this.name = name;
        this.text = text;
    }

    public void addFormat(Format format){
        formats.add(format);
    }
    public void display(){
        System.out.print(text);
        for (Format format : formats){
            System.out.print(" " + format.getName());
        }
        System.out.println();
    }
}