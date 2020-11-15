import org.hibernate.Session;

import java.time.LocalTime;
import java.util.ArrayList;

public class CheckArea {
    private int x = -2;
    private double y = -3.0;
    private double r = 1.0;
    private boolean hit = false;
    private Long startTime;
    private ArrayList <Point> points= new ArrayList<>();

    public void setX(int x){this.x = x;}
    public int getX(){
        return x;
    }
    public void setY(double y){this.y = y;}
    public double getY(){
        return y;
    }
    public void setR(double r){this.r = r;}
    public double getR(){
        return r;
    }

    public void setPoint(Point p){points.add(p);}
    public ArrayList<Point> getPoints(){
        return this.points;
    }


    public void setHit(){
        startTime = System.nanoTime();
        if (x >= 0 && y >= 0 && x <= 2*y + r){
            hit = true;
            return;
        }
        if (x <= 0 && y <= 0 && x*x + y*y <= r*r/4){
            hit = true;
            return;
        }
        hit = (x <= 0 && y >= 0 && x <= -r/2 && y <= r);
    }
    public boolean getHit(){
        setHit();
        return hit;
    }

    public void newPoint(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Point p = new Point(getX(), getY(), getR(), getHit(), LocalTime.now(), (System.nanoTime() - startTime)/100);
        setPoint(p);
        session.save(p);
        session.getTransaction().commit();
    }
}
