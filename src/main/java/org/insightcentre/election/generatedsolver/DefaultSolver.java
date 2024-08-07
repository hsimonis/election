package org.insightcentre.election.generatedsolver;
import org.insightcentre.election.datamodel.Scenario;
import framework.solver.AbstractSolver;
 // basically a buffer to avoid having to generate the old style parameters in new code
public abstract class DefaultSolver extends AbstractSolver {
protected Scenario base;
DefaultSolver(Scenario base,String[] options){
super(options);
this.base = base;
}
}
