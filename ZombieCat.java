import java.util.*;
import java.util.Random;

public class ZombieCat extends Cat {
    
     int action;
    public ZombieCat(int x, int y, City cty, Random rnd){
        super(x, y, cty, rnd);
        this.lab = 'r';
        this.action = 0;
}
    public void takeAction(){
    this.action++;   

    Creature catt = null;
    double fgrid = 999999;
    for(Creature ca: city.creatures){
        if(ca instanceof Mouse){
            double fdist = this.getGridPoint().dist(ca.getGridPoint());
            if(fdist <= 40){
                this.lab = 'K';

            }
            if( catt == null || fdist <= fgrid){
                fgrid = fdist;
                catt = ca;
            }
            else if(fdist <= fgrid){
                catt = ca;
            }
        }
    }
}

// public void turnaround(){
//     Random r = new Random();
//     double t = Math.random();
//     if (t >= 0.05){
//     this.setDir(D.nextInt(NUM_DIRS));
// }

public void step(){
    this.turnaround();
    this.jump(3);

}
}









