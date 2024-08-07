package org.insightcentre.election.imports;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static org.insightcentre.election.logging.LogShortcut.severe;

public class BoundingBox {
    double x1;
    double y1;
    double x2;
    double y2;

    public BoundingBox(double x1,double y1,double x2,double y2){
        this.x1= x1;
        this.y1= y1;
        this.x2= x2;
        this.y2= y2;
    }

    public BoundingBox(String text){
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();

        JSONObject obj = new JSONObject(text);
        if (obj.has("shape")){
            JSONArray arr = obj.getJSONArray("shape");
            for(int i=0;i<arr.length();i++){
                JSONArray poly = arr.getJSONArray(i);
                for(int j=0;j<poly.length();j++){
                    if (j%2 ==0){
                        xList.add(poly.getDouble(j));
                    } else {
                        yList.add(poly.getDouble(j));
                    }
                }
            }

        } else if (obj.has("multi")){
            JSONArray arr = obj.getJSONArray("multi");
            for(int i=0;i<arr.length();i++){
                JSONArray arr1 = arr.getJSONArray(i);
                for(int k=0;k<arr1.length();k++) {
                    JSONArray poly = arr1.getJSONArray(k);
                    for (int j = 0; j < poly.length(); j++) {
                        if (j % 2 == 0) {
                            xList.add(poly.getDouble(j));
                        } else {
                            yList.add(poly.getDouble(j));
                        }
                    }
                }
            }

        } else {
            severe("Bad shape "+text);
        }
        x1 = xList.stream().mapToDouble(x->x).min().orElse(0.0);
        x2 = xList.stream().mapToDouble(x->x).max().orElse(0.0);
        y1 = yList.stream().mapToDouble(x->x).min().orElse(0.0);
        y2 = yList.stream().mapToDouble(x->x).max().orElse(0.0);

    }

    public boolean contains(double x,double y){
        return x1<=x && x<= x2 && y1<= y && y <= y2;
    }

    public double getX1() {
        return x1;
    }
    public double getY1(){
        return y1;
    }
    public double getX2() {
        return x2;
    }
    public double getY2(){
        return y2;
    }
}
