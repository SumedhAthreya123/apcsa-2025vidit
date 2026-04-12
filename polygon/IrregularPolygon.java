package polygon;

import java.awt.geom.*; 
import java.util.ArrayList; 
import gpdraw.*; 

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

   
    public IrregularPolygon() {}

   
    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        double total = 0.0;
        int n = myPolygon.size();

        if (n < 2) return 0.0;

        for (int i = 0; i < n; i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % n); 
            total += current.distance(next);
        }

        return total;
    }

    public double area() {
        
        double area = 0.0;
        int n = myPolygon.size();

        if (n < 3) return 0.0;

        for (int i = 0; i < n; i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % n); 
            area += (current.x * next.y) - (next.x * current.y);
        }

        return Math.abs(area) / 2.0;
    }

    public void draw() {
        try {
            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            int n = myPolygon.size();

            if (n == 0) return;

          
            Point2D.Double first = myPolygon.get(0);
            pen.up();
            pen.move(first.x, first.y);
            pen.down();

          
            for (int i = 1; i < n; i++) {
                Point2D.Double point = myPolygon.get(i);
                pen.move(point.x, point.y);
            }

            
            pen.move(first.x, first.y);

        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}