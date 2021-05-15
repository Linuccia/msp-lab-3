import org.hibernate.Session;

import java.time.LocalTime;
import java.util.ArrayList;

public class CheckArea {
    private Double x = 0.0;
    private Double y = 0.0;
    private Double r = 1.0;
    private Long startTime;
    private ArrayList <Point> points= new ArrayList<>();
    private Point point = new Point(1.0, 1.0, 1.0, true, LocalTime.now(), 11111L);
    private Point point2 = null;

    public void setX(Double x){this.x = x;}
    public Double getX(){
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
    public Point getPoint(){return this.point;}
    public Point getPoint2(){return this.point2;}
    public void setPoint2(Point p){point2 = p;}

    public void setPoint(Point p){points.add(p);}
    public ArrayList<Point> getPoints(){
        return this.points;
    }


    public Boolean getHit(Double x, Double y, Double r){
        startTime = System.nanoTime();
        if (x >= 0 && y >= 0 && y <= -x/2.0 + r/2){
            return true;
        }
        if (x >= 0 && y <= 0 && x*x + y*y <= r*r/4){
            return true;
        }
        return (x <= 0 && y >= 0 && x >= -r/2 && y <= r);
    }

    public void newPoint(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Point p = new Point(getX(), getY(), getR(), getHit(this.x, this.y, this.r), LocalTime.now(), (System.nanoTime() - startTime));
        setPoint(p);
        session.save(p);
        session.getTransaction().commit();
    }
}
