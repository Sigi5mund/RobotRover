public class Position {

    private Integer x;
    private Integer y;
    private Cardinal d;

    public Position(Integer x, Integer y, Cardinal d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Cardinal getD() {
        return d;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setD(Cardinal d) {
        this.d = d;
    }
}
