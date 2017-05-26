import java.util.Arrays;

public class GameState {

    private final static int STRIKE = 2;
    private final static int SPARE = 1;
   
    private int[] play;
    private int[] score;
    
    private int frame;
    
    private int bowlsThisFrame = 0;
    
    private boolean finalFrame;
    
    public GameState() {
        this.play = new int[1];
        this.score = new int[1];
        this.frame = 0;
        this.finalFrame = false;
    }
    
    public int score(int score) {
        this.bowlsThisFrame++;
        
        if (this.frame > 0) {
            if (this.play[this.frame - 1] == STRIKE) {
                this.score[this.frame - 1] += score;   
            }  
            
            if (this.play[this.frame - 1] == SPARE && bowlsThisFrame == 1) {
                this.score[this.frame - 1] += score;
            }
        }

        if (this.frame > 1) {
            if (this.finalFrame == false) {
                if (this.play[this.frame - 2] == STRIKE && score == 10) {
                    this.score[this.frame - 2] += score;   
                }
                
                if (this.frame > 9 && 
                    this.play[this.frame - 2] == STRIKE &&
                    this.play[this.frame - 1] == STRIKE &&
                    score != 10) 
                {
                    this.score[this.frame - 2] += score;
                }
            }
        }

        if (this.frame < 10) {
            this.score[this.frame] += score;
        }
        
        if (this.frame == 10) {
            this.finalFrame = true;
        }
        
        return 1;
    }
    
    public void score(String score) {
        if (score.equals("X")) {
            if (this.frame < 10) {
                this.play[this.frame] = STRIKE;
            }
            this.score(10); 
        } else if (score.equals("/")) {
            if (this.frame < 10) {
                   this.play[this.frame] = SPARE;
            }
            this.score(10 - this.score[this.frame]);
        } else if (score.equals("-")) {
            this.play[this.frame] = 0;
            this.score(0);
        } else {
            try {
                this.score(Integer.valueOf(score));   
            } catch (NumberFormatException e) {
                this.score(0);
            }
        }
    }
    
    public int finalScore() {
        int acc = 0;
        for(int i=0; i<this.score.length; i++) {
            acc += this.score[i];
        }
        
        return acc;
    }
    
    public void next() {
        if (this.frame < 9) {
            this.score = Arrays.copyOf(this.score, this.score.length + 1);
            this.play = Arrays.copyOf(this.play, this.play.length + 1);   
        }
        
        this.bowlsThisFrame = 0;
        this.frame++;
    }
    
    public String toString() {
        String score = Arrays.toString(this.score);
        String play = Arrays.toString(this.play);
    
        return "score: " +
            score +
            " frame: " +
            this.frame +
            " play: " +
            play;
    }
}
