import org.hibernate.Session;

import java.time.LocalTime;
import java.util.ArrayList;

public class CheckArea {
    private Integer x = 0;
    private Double y = 0.0;
    private Double r = 1.0;
    private Boolean hit = false;
    private Long startTime;
    private ArrayList <Point> points= new ArrayList<>();

    public void setX(Integer x){this.x = x;}
    public Integer getX(){
        return x;
    }
    public void setY(Double y){this.y = y;}
    public Double getY(){
        return y;
    }
    public void setR(Double r){this.r = r;}
    public Double getR(){
        return r;
    }

    public void setPoint(Point p){points.add(p);}
    public ArrayList<Point> getPoints(){
        return this.points;
    }


    public void setHit(){
        startTime = System.nanoTime();
        if (x >= 0 && y >= 0 && y <= -x/2.0 + r/2){
            hit = true;
            return;
        }
        if (x >= 0 && y <= 0 && x*x + y*y <= r*r/4){
            hit = true;
            return;
        }
        hit = (x <= 0 && y >= 0 && x >= -r/2 && y <= r);
    }
    public Boolean getHit(){
        setHit();
        return hit;
    }

    public void newPoint(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Point p = new Point(getX(), getY(), getR(), getHit(), LocalTime.now(), (System.nanoTime() - startTime));
        setPoint(p);
        session.save(p);
        session.getTransaction().commit();
    }
}
