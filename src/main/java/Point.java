import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "x", nullable = false)
    private Integer x;
    @Column(name = "y", nullable = false)
    private Double y;
    @Column(name = "r", nullable = false)
    private Double r;
    @Column(name = "hit", nullable = false)
    private Boolean hit;
    @Column(name = "currenttime", nullable = false)
    private LocalTime time;
    @Column(name = "runtime", nullable = false)
    private Long runtime;


    public Point(Integer x, Double y, Double r, Boolean hit, LocalTime time, Long runtime){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.time = time;
        this.runtime = runtime;
    }

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
    public void setHit(boolean hit){this.hit = hit;}
    public boolean getHit(){
        return hit;
    }
    public LocalTime getTime(){
        return time;
    }
    public Long getRuntime(){
        return runtime;
    }
}
