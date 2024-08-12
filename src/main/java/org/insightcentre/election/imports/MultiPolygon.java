package org.insightcentre.election.imports;

import java.util.ArrayList;
import java.util.List;

public class MultiPolygon {
    List<Polygon> polygons;

    public MultiPolygon(List<Polygon> polygons){
        this.polygons = new ArrayList<>(polygons);
    }

    public List<Polygon> getPolygons(){
        return polygons;
    }

    public Point centroid(){
        double cx = polygons.stream().flatMap(x->x.getPoints().stream()).mapToDouble(Point::getX).average().orElse(0.0);
        double cy = polygons.stream().flatMap(x->x.getPoints().stream()).mapToDouble(Point::getY).average().orElse(0.0);
        return new Point(cx,cy);
    }
}
