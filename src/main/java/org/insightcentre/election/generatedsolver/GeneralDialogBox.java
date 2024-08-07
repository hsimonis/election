package org.insightcentre.election.generatedsolver;
import org.insightcentre.election.GeneratedJfxApp;
import org.insightcentre.election.datamodel.Scenario;
import framework.gui.JfxSolverDialogBox;
import framework.solver.AbstractSolver;
import javafx.scene.control.TextField;
public class GeneralDialogBox extends JfxSolverDialogBox {
    Scenario base;

    GeneralDialogBox(GeneratedJfxApp app, Scenario base, AbstractSolver solver){
        super(app,solver);
        this.base = base;
    }

     class IntegerTextField extends TextField {

     @Override
     public void replaceText(int start, int end, String text) {
         if (validate(text)) {
             super.replaceText(start, end, text);
         }
     }

     @Override
     public void replaceSelection(String replacement) {
         if (validate(replacement)) {
             super.replaceSelection(replacement);
         }
     }

     boolean validate(String text) {
         return text.matches("-?[0-9]*");
     }
}

     class DoubleTextField extends TextField {

     @Override
     public void replaceText(int start, int end, String text) {
         if (validate(text)) {
             super.replaceText(start, end, text);
         }
     }

     @Override
     public void replaceSelection(String replacement) {
         if (validate(replacement)) {
             super.replaceSelection(replacement);
         }
     }

     boolean validate(String text) {
         return text.matches("[\\.0-9]*");
     }
}

    class DateTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        if (validate(replacement)) {
            super.replaceSelection(replacement);
        }
    }

    boolean validate(String text) {
        return text.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]");
    }
}

}
