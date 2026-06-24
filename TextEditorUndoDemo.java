import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditorUndoDemo {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        StringBuilder document = new StringBuilder();

        typeWord("Hello", history, document);
        typeWord("world", history, document);
        typeWord("Java", history, document);
        typeWord("stack", history, document);

        undo(history, document);
        undo(history, document);
    }

    private static void typeWord(String word, Deque<String> history, StringBuilder document) {
        history.push(word);
        if (document.length() > 0) {
            document.append(' ');
        }
        document.append(word);
        System.out.println("Action: Type \"" + word + "\"");
        System.out.println("Current text: " + document);
        System.out.println();
    }

    private static void undo(Deque<String> history, StringBuilder document) {
        System.out.println("Action: Undo");
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            history.pop();
            rebuildDocument(history, document);
            System.out.println("Current text: " + document);
        }
        System.out.println();
    }

    private static void rebuildDocument(Deque<String> history, StringBuilder document) {
        document.setLength(0);
        String[] words = history.toArray(new String[0]);
        for (int i = words.length - 1; i >= 0; i--) {
            if (document.length() > 0) {
                document.append(' ');
            }
            document.append(words[i]);
        }
    }
}
