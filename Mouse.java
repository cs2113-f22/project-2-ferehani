import java.util.*;
import java.util.Random;

public class Mouse extends Creature{

    int action;

public Mouse(int x, int y, City cty, Random rnd){
    super(x, y, cty, rnd);
    this.lab = 'b';
    this.action = 0;
}

public void takeAction(){
       this.action++;
       
        if(this.action == 20){
           city.addMouse(); 
        }
        if(this.action == 30){
            this.dead = true;
        }
    
    }

public void turnaround(){
    Random r = new Random();
    double t = Math.random();
    if (t >= 0.2){
    this.setDir(r.nextInt(NUM_DIRS));
}
}


public void step(){
    this.turnaround();
    this.jump(1);
}

}