public class Line {
    public double getSlope(double x1, double y1, double x2, double y2){
        return (y2 - y1)/(x2 - x1);
    }

    public double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public void parallelTo(double x1, double y1, double x2, double y2){
        if(x1 * y2 == x2 * y1){
            System.out.println("parallel");
        }
        else {
            System.out.println("not parallel");
        }

    }

    public static void main(String[] args) {

    }
}
