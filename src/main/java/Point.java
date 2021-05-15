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
    private Double x;
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


    public Point(Double x, Double y, Double r, Boolean hit, LocalTime time, Long runtime){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.time = time;
        this.runtime = runtime;
    }

    public Double getX(){
        return x;
    }
    public void setX(Double x){this.x = x;}

    public Double getY(){
        return y;
    }
    public void setY(Double y){this.y = y;}

    public Double getR(){
        return r;
    }
    public void setR(Double r){this.r = r;}

    public Boolean getHit(){
        return hit;
    }
    public void setHit(Boolean hit){this.hit = hit;}

    public LocalTime getTime(){
        return time;
    }
    public void setTime(LocalTime time){this.time = time;}

    public Long getRuntime(){
        return runtime;
    }
    public void setRuntime(Long runtime){this.runtime = runtime;}
}
