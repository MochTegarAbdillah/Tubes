package paket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GAMU {
    
    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    public static void main(String[] args) {
        
        new GAMU();

    }

    public GAMU(){
        
        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed (ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch(yourChoice) {
                case "Start": vm.titleToBegin(); story.townGate(); break;
                case "c1": story.selectPosition(nextPosition1); break;
                case "c2": story.selectPosition(nextPosition2);break;
                case "c3": story.selectPosition(nextPosition3);break;
                case "c4": story.selectPosition(nextPosition4);break;
            }

        }
    }
       
}
