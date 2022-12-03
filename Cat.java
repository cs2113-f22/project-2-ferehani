import java.util.*;
import java.util.Random;



public class Cat extends Creature{
    
    int action;

    public Cat(int x, int y, City cty, Random rnd){
        super(x, y, cty, rnd);
        this.lab = 'y';
        this.action = 0;
    }

public void takeAction(){
    this.action++;
    Mouse m = null;
    if(m != null && m.getY() == this.getY() && m.getX() == this.getX()){
        m.isDead();
        this.action = 0;
    }
    if(this.action >= 50){
        this.dead = true;
        city.addZombieCat();     }   

    Creature catt = null;
    double fgrid = 999999;
    for(Creature ca: city.creatures){
        if(ca instanceof Mouse){
            double fdist = this.getGridPoint().dist(ca.getGridPoint());
            if(fdist <= 20){
                this.lab = 'c';
            if(ca.getY() < this.getY()){
                setDir(0);
            }
            else if(ca.getY() > this.getY()){
                setDir(2);
            }
            if(ca.getX() < this.getX()){
                setDir(3);

            }
            else if(ca.getX() > this.getX()){
                setDir(1);
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

}

public void turnaround(){
    Random r = new Random();
    double t = Math.random();
    if (t >= 0.05){
    this.setDir(r.nextInt(NUM_DIRS));
}
}
public void step(){
    this.turnaround();
    this.jump(2);

}


}