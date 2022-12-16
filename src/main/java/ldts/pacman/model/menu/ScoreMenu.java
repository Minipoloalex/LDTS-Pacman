package ldts.pacman.model.menu;

import ldts.pacman.file.manipulation.ResourceFileReader;
import ldts.pacman.file.manipulation.ResourceFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreMenu {
    private final String filePath;
    private List<String> lines;
    public ScoreMenu() throws IOException {
        this("/scores.txt");
    }
    public ScoreMenu(String filePath) throws IOException {
        this.filePath = filePath;
        this.lines = new ResourceFileReader().readLines(filePath);
    }
    public List<String> getLines() {
        return lines;
    }
    public void addScore(String name, int scoreToAdd) throws IOException {
        if (lines.size() < 2) throw new IOException("File was empty");
        if (lines.size() > 12) throw new IOException("File had too many lines");

        lines = getNewLines(name, scoreToAdd);
        new ResourceFileWriter().writeLines(filePath, lines);
    }
    private List<String> getNewLines(String name, int scoreToAdd){
        String header = lines.get(0);
        String footer = lines.get(lines.size() - 1);

        List<String> newLines = new ArrayList<>();
        newLines.add(header);

        boolean newLineAdded = false;
        int i = 1;
        for ( ; i < lines.size() - 1; i++) {
            if(getScore(lines.get(i)) < scoreToAdd && !newLineAdded) {
                newLines.add("  " + i + ". " + scoreToAdd + " - " + name);
                newLineAdded = true;
            }
            if (newLineAdded) {
                newLines.add(lines.get(i).replaceFirst(Integer.toString(i),
                        Integer.toString(i + 1)));
            }
            else newLines.add(lines.get(i));
        }
        if (!newLineAdded) {
            lines.add("  " + i + ". " + scoreToAdd + " - " + name);
        }
        if (newLines.size() > 10) newLines.remove(newLines.size() - 1);

        newLines.add(footer);
        return newLines;
    }
    private int getScore(String line) {
        int firstSpace = line.indexOf(" ");
        int secondSpace = line.indexOf(" ", firstSpace + 1);
        int thirdSpace = line.indexOf(" ", secondSpace + 1);
        int fourthSpace = line.indexOf(" ", thirdSpace + 1);
        int fifthSpace = line.indexOf(" ", fourthSpace + 1);
        return Integer.parseInt(line.substring(fourthSpace + 1, fifthSpace));
    }
}
