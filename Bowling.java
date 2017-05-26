import java.util.Arrays;

public class Bowling {
    
    public static int answer(String frames) {
        String cleanFrames = frames.replace("||","|");
        String[] parts = cleanFrames.split(""); 
        GameState myGame = new GameState();
       
        for (int i=0; i < parts.length; i++) {
            if (parts[i].equals("|")) {
                myGame.next();
                continue;
            }

            myGame.score(parts[i]);
        }
        
        return myGame.finalScore();
    }
}
