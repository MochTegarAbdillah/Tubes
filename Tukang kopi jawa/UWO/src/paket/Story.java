package paket;

import paket2.Monster_gob;
import paket2.Weapon_Golok;
import paket2.Weapon_GolokSuper;
import paket2.superMonster;

public class Story {

    GAMU game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    superMonster monster;

    int cincinEmas;

    public Story(GAMU g, UI userInterface, VisibilityManager vManager){

        game = g;
        ui = userInterface;
        vm = vManager;    
    }
    public void defaultSetup(){

        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.curwWeapon = new Weapon_Golok();
        ui.weaponNameLabel.setText(player.curwWeapon.name);

        cincinEmas = 0;
    }
    public void selectPosition(String nextPosition){

        switch(nextPosition){
        case "Pangkalan G*jek" : townGate(); break;
        case "talkGuard": talkGuard(); break;
        case "attackGuard": attackGuard(); break;
        case "Sebrangjalan": crossRoad(); break;
        case "Kidul": Kidul(); break;
        case "Kulon": Kulon(); break;
        case "Kaler": Kaler(); break;   
        case "fight": fight(); break;
        case "playerAttack": playerAttack(); break;
        case "monsterAttack": monsterAttack(); break;
        case "Win": Win(); break;
        case "Lose": Lose(); break;
        case "ending": ending(); break;
        case "toTitle": toTitle(); break;
        }
    }

    public void townGate(){
        ui.mainTextArea.setText("Kamu sedang berada di pangkalan G*jek. \nSeorang driver sedang berdiri didepan mu. \n\napa yang akan kamu lakukan?");
        ui.choice1.setText("Ngobrol sama abang G*jek nya");
        ui.choice2.setText("Serang abang G*jek nya");
        ui.choice3.setText("Biarin aja lah");
        ui.choice4.setText(" ");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "Sebrangjalan";
        game.nextPosition4 = " ";   
    }
    public void talkGuard(){

        if(cincinEmas==0) {

            ui.mainTextArea.setText("Driver: wei bang. \nkeknya lu bukan orang sini nih. \n\nsorry2 nih ye, kita gabisa kasi jalan buat lu karena lu baru disini");
            ui.choice1.setText(">");
            ui.choice2.setText(" ");
            ui.choice3.setText(" ");
            ui.choice4.setText(" ");

            game.nextPosition1 = "Pangkalan G*jek";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }
        else if(cincinEmas==1){
            ending();
        }
        
    }
    public void attackGuard(){
        ui.mainTextArea.setText("Driver: Weh nantangin ni anak. \nDriver pun memanggil kawan nya lalu memukuli mu beramai-ramai, dan kamu pun menyerah. \n\n(Kamu menerima 3 damage)");
        player.hp = player.hp -3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Pangkalan G*jek";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void crossRoad(){
        ui.mainTextArea.setText("Kamu berada di sebrang pangkalan ojek. \nkalo kamu milih arah Wetan, kamu balik lagi ke pangkalan.");
        ui.choice1.setText("Pergi ke arah Kidul");
        ui.choice2.setText("Pergi ke arah Kulon");
        ui.choice3.setText("pergi ke arah Kaler ");
        ui.choice4.setText("pergi ke arah Wetan");

        game.nextPosition1 = "Kidul";
        game.nextPosition2 = "Kulon";
        game.nextPosition3 = "Kaler";
        game.nextPosition4 = "Pangkalan G*jek";
    }
    public void Kidul(){
        ui.mainTextArea.setText("Ada warkop nih. \nkamu milih buat ngopi dan sebat dulu. \n\n(Hp kamu nambah deh 2)");
        player.hp = player.hp + 2;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Pergi ke arah Wetan");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Sebrangjalan";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void Kulon(){
        ui.mainTextArea.setText("Kamu jalan melewati rumah warga, lalu menemukan sebuah Golok Super!\n\n(Kamu mendapatkan sebuah Golok Super)");
        
        player.curwWeapon = new Weapon_GolokSuper();
        ui.weaponNameLabel.setText(player.curwWeapon.name);

        ui.choice1.setText("Pergi ke arah kaler");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Sebrangjalan";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void Kaler(){

        monster = new Monster_gob();

        ui.mainTextArea.setText("Kamu bertemu dengan " + monster.name + "!");
        ui.choice1.setText("Gelud");
        ui.choice2.setText("Lumpat");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "Sebrangjalan";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void fight() {
        
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat mau apa kamu?");
        ui.choice1.setText("Gelud");
        ui.choice2.setText("Lumpat");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "Sebrangjalan";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void playerAttack() {

        int playerDamage = new java.util.Random().nextInt(player.curwWeapon.damage);

        ui.mainTextArea.setText("Kamu menyerang "  + monster.name + "dan mendapatkan " + playerDamage + "damage!");

        monster.hp = monster.hp - playerDamage;

        ui.choice1.setText(">");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        if(monster.hp>0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }
        else if(monster.hp<1) {
            game.nextPosition1 = "Win";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }
    }
    public void monsterAttack() {

        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        if(player.hp>0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }
        else if(player.hp<1) {
            game.nextPosition1 = "Lose";
            game.nextPosition2 = " ";
            game.nextPosition3 = " ";
            game.nextPosition4 = " ";
        }
    }
    public void Win() {

        ui.mainTextArea.setText("Kamu mengalahkan " + monster.name + "!\n The mamak menjatuhkan cincin emas pasar baru!\n\n(Kamu mendapatkan cincin dari pasar baru!");

        cincinEmas = 1;

        ui.choice1.setText("pergi ke arah Wetan");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Sebrangjalan";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void Lose() {

        ui.mainTextArea.setText("Kamu bonyok!\n\n<masuk RS>");

        ui.choice1.setText("To the Title Screen");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void ending() {

        ui.mainTextArea.setText("Driver: wih apaan tuh cincin emas");

        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }
    public void toTitle() {

        defaultSetup();
        vm.showTitleScreen();
    }
}