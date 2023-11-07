import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, RuntimeException {
        var app = new Application();
        try {
            var reader = new BufferedReader(new FileReader(args[0]));
            String command;
            while ((command = reader.readLine()) != null && !command.isEmpty()) {
                switch (command) {
                    case "Draw":
                        app.addDoc(new DrawingDocument());
                        break;
                    case "Text":
                        app.addDoc(new TextDocument());
                        break;
                    case "Present":
                        app.present();
                        break;
                    default:
                        System.out.println("Invalid command: " + command);
                }
            }
        } catch (Exception e){
            e.printStackTrace(System.err);
        }
    }
}