import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, RuntimeException {
        var fileView = new FileView();
        try {
            var reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length <= 1){
                    System.out.println("Invalid command.");
                    continue;
                }
                TextView textView = fileView.getTextViewByName(tokens[0]);
                if (textView == null){
                    String name = tokens[0];
                    String text = line.substring(name.length()+1);
                    fileView.addTextView(new TextView(name, text));
                    continue;
                }
                var command = tokens[1];
                switch (command) {
                    case "add":
                        if (tokens.length == 2) {
                            System.out.println("Invalid " + command + " command.");
                            break;
                        }
                        for (int i = 2; i < tokens.length; i++) {
                            String formatName = tokens[i];
                            switch (formatName) {
                                case "scrollBar":
                                    textView.addFormat(new ScrollBarFormat());
                                    break;
                                case "thickBlackBorder":
                                    textView.addFormat(new ThickBlackBorderFormat());
                                    break;
                                default:
                                    System.out.println("Invalid " + formatName + " format.");
                            }
                        }
                        break;
                    case "display":
                        textView.display();
                        break;
                    default:
                        System.out.println("Invalid creation command.");
                }
            }
        } catch (Exception e){
            e.printStackTrace(System.err);
        }
    }
}