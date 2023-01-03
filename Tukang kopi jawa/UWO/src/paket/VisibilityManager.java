package paket;

public class VisibilityManager {

    UI ui;
    
    public VisibilityManager(UI usersInterface) {

        ui = usersInterface;

    }

    public void showTitleScreen() {

        //buat menampilkan layar utama
        ui.titleNamePanel.setVisible(true);
        ui.startButtoPanel.setVisible(true);

        //buat menyembunyikan layar game
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void titleToBegin() {

        //buat menyembunyikan layar utama
        ui.titleNamePanel.setVisible(false);
        ui.startButtoPanel.setVisible(false);

        //buat menampilkan layar game
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }

}
