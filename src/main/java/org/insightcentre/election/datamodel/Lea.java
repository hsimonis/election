// licence details to be added
package org.insightcentre.election.datamodel;
import org.insightcentre.election.datamodel.ApplicationDataset;
import org.insightcentre.election.datamodel.ApplicationObject;
import org.insightcentre.election.datamodel.ApplicationDifference;
import org.insightcentre.election.datamodel.ApplicationWarning;
import org.insightcentre.election.datamodel.Scenario;
import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.MapLocation;
import org.insightcentre.election.datamodel.Area;
import org.insightcentre.election.datamodel.Nuts3;
import org.insightcentre.election.datamodel.Province;
import org.insightcentre.election.datamodel.Shaped;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Lea;
import org.insightcentre.election.datamodel.Distance;
import org.insightcentre.election.datamodel.DistanceError;
import org.insightcentre.election.datamodel.NeighborCounty;
import org.insightcentre.election.datamodel.Solution;
import org.insightcentre.election.datamodel.SolCounty;
import org.insightcentre.election.datamodel.SolTransfer;
import org.insightcentre.election.datamodel.SolConstType;
import org.insightcentre.election.datamodel.DifferenceType;
import org.insightcentre.election.datamodel.WarningType;
import org.insightcentre.election.datamodel.SolutionStatus;
import org.insightcentre.election.datamodel.SolverType;
import org.insightcentre.election.datamodel.XMLLoader;
import java.util.*;
import java.io.*;
import framework.types.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import framework.ApplicationObjectInterface;
import framework.ApplicationDatasetInterface;
import framework.AppearInCollection;

/**
 * 
 * @author generated
*/

public  class Lea extends Shaped{
/**
 *  No-arg constructor for use in TableView
 *
*/

    public Lea(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Lea(ApplicationDataset applicationDataset){
        super(applicationDataset);
        applicationDataset.addLea(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Lea(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Double centroidX,
            Double centroidY,
            String ident,
            String shortName,
            Integer totalPopulation,
            Double xMax,
            Double xMin,
            Double yMax,
            Double yMin,
            Integer nr,
            String shape){
        super(applicationDataset,
            id,
            name,
            centroidX,
            centroidY,
            ident,
            shortName,
            totalPopulation,
            xMax,
            xMin,
            yMax,
            yMin,
            nr,
            shape);
        applicationDataset.addLea(this);
    }

    public Lea(Lea other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.centroidX,
            other.centroidY,
            other.ident,
            other.shortName,
            other.totalPopulation,
            other.xMax,
            other.xMin,
            other.yMax,
            other.yMin,
            other.nr,
            other.shape);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeElectoralDivisionLea(this);
        getApplicationDataset().cascadeDistanceFrom(this);
        getApplicationDataset().cascadeDistanceTo(this);
        getApplicationDataset().cascadeDistanceErrorFrom(this);
        getApplicationDataset().cascadeDistanceErrorTo(this);
        return getApplicationDataset().removeLea(this) && getApplicationDataset().removeShaped(this) && getApplicationDataset().removeArea(this) && getApplicationDataset().removeMapLocation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  override generic toString() method, show all attributes in human readable form
 * @return String details of the format are not clearly defined at the moment
*/

    @Override
    public String toString(){
        return toColumnString();
    }

/**
 *  alternative to the toString() method, experimental at this point
 *  This should be easier to read than toString(), but contain more information than toColumnString()
 * @return String human readable
*/

    public String prettyString(){
        return ""+ " " +getId()+ " " +getName()+ " " +getCentroidX()+ " " +getCentroidY()+ " " +getIdent()+ " " +getShortName()+ " " +getTotalPopulation()+ " " +getXMax()+ " " +getXMin()+ " " +getYMax()+ " " +getYMin()+ " " +getNr()+ " " +getShape();
    }

/**
 *  alternative to the toString() method, used in the table views
 *  this only shows enough fields to identify the object
 *  Normally this is the name attribute, but this can be changed by the display_key fields
 * @return String normally name or other fields defned in display_key
*/

    public String toColumnString(){
        return getName();
    }

/**
 * show object as one element in XML format
 * side effect of writing to file
 * @param out PrintWriter
*/

     public void toXML(PrintWriter out){
         out.println("<lea "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " centroidX=\""+toXMLCentroidX()+"\""+
            " centroidY=\""+toXMLCentroidY()+"\""+
            " ident=\""+toXMLIdent()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " totalPopulation=\""+toXMLTotalPopulation()+"\""+
            " xMax=\""+toXMLXMax()+"\""+
            " xMin=\""+toXMLXMin()+"\""+
            " yMax=\""+toXMLYMax()+"\""+
            " yMin=\""+toXMLYMin()+"\""+
            " nr=\""+toXMLNr()+"\""+
            " shape=\""+toXMLShape()+"\""+" />");
     }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Lea</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Ident</th>"+"<th>CentroidX</th>"+"<th>CentroidY</th>"+"<th>XMin</th>"+"<th>XMax</th>"+"<th>YMin</th>"+"<th>YMax</th>"+"<th>TotalPopulation</th>"+"<th>Nr</th>"+"<th>Shape</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getIdent()+"</td>"+ " " +"<td>"+getCentroidX()+"</td>"+ " " +"<td>"+getCentroidY()+"</td>"+ " " +"<td>"+getXMin()+"</td>"+ " " +"<td>"+getXMax()+"</td>"+ " " +"<td>"+getYMin()+"</td>"+ " " +"<td>"+getYMax()+"</td>"+ " " +"<td>"+getTotalPopulation()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getShape()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Lea item we are looking for
 * @param bList List<Lea> list of items in which we are searching
 * @return Lea entry of list b which is applicationSame() to a
*/

    public static Lea find(Lea a, List<Lea> bList){
        for(Lea b : bList){
            if (b.applicationSame(a)){
                return b;
            }
        }
        return null;
    }

/**
 * find an object from its name; returns null if no such item exists
 * it is not defined which object is returned if multiple have the same name
 * @param base  dataset in which we are searching
 * @param name Lea name of the object we are looking for
 * @return Lea entry of the dataset with the given name; otherwise null
*/

    public static Lea findByName(ApplicationDataset base, String name){
        for(Lea a:base.getListLea()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find an object from its name; create new instance if no such item exists
 * it is not defined which object is returned if multiple have the same name
 * @param base  dataset in which we are searching
 * @param name Lea name of the object we are looking for
 * @return Lea entry of the dataset with the given name
*/

    public static Lea findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Lea a:base.getListLea()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Lea res = new Lea(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Lea first entry in the dataset of this type; null if that does not exists
*/

    public static Lea findFirst(ApplicationDataset base){
        if (base.getListLea().isEmpty()) {
            return null;
        }
        return base.getListLea().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Lea some entry in the dataset of this type; null if that does not exists
*/

    public static Lea findAny(ApplicationDataset base){
        int size=base.getListLea().size();
        if (size > 0) {
             return base.getListLea().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Lea last entry in the dataset of this type; null if that does not exists
*/

    public static Lea findLast(ApplicationDataset base){
        int size=base.getListLea().size();
        if (size > 0) {
             return base.getListLea().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Lea compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Lea b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Lea compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Lea b){
      if(!this.getCentroidX().equals(b.getCentroidX())){
         System.out.println("CentroidX");
        }
      if(!this.getCentroidY().equals(b.getCentroidY())){
         System.out.println("CentroidY");
        }
      if(!this.getIdent().equals(b.getIdent())){
         System.out.println("Ident");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNr().equals(b.getNr())){
         System.out.println("Nr");
        }
      if(!this.getShape().equals(b.getShape())){
         System.out.println("Shape");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
      if(!this.getTotalPopulation().equals(b.getTotalPopulation())){
         System.out.println("TotalPopulation");
        }
      if(!this.getXMax().equals(b.getXMax())){
         System.out.println("XMax");
        }
      if(!this.getXMin().equals(b.getXMin())){
         System.out.println("XMin");
        }
      if(!this.getYMax().equals(b.getYMax())){
         System.out.println("YMax");
        }
      if(!this.getYMin().equals(b.getYMin())){
         System.out.println("YMin");
        }
        return  this.getCentroidX().equals(b.getCentroidX()) &&
          this.getCentroidY().equals(b.getCentroidY()) &&
          this.getIdent().equals(b.getIdent()) &&
          this.getName().equals(b.getName()) &&
          this.getNr().equals(b.getNr()) &&
          this.getShape().equals(b.getShape()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getTotalPopulation().equals(b.getTotalPopulation()) &&
          this.getXMax().equals(b.getXMax()) &&
          this.getXMin().equals(b.getXMin()) &&
          this.getYMax().equals(b.getYMax()) &&
          this.getYMin().equals(b.getYMin());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Lea",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Lea
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      return null;
   }

}
