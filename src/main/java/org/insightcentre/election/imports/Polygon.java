package org.insightcentre.election.imports;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    List<Point> points;

    public Polygon(List<Point> points){
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints(){
        return points;
    }

    public int getNrPoints(){
        return points.size();
    }

    public Point centroid(){
        double x =points.stream().mapToDouble(Point::getX).average().orElse(0.0);
        double y =points.stream().mapToDouble(Point::getY).average().orElse(0.0);
        return new Point(x,y);
    }
}
