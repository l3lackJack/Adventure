import javax.sound.midi.MidiFileFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90);
    Font normalFont = new Font("Times new Roman", Font.PLAIN,28);
    Font littleFont = new Font("Times new Roman", Font.BOLD, 15);
    Font buttonsFont = new Font("Times new roman", Font.PLAIN, 17);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing, armadura, carta, vidaSoldado;
    String playerWeapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Aventura");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);


        startButton = new JButton("Inicio");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);


        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }
    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(275,350,250,115);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Opcion 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(buttonsFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Opcion 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(buttonsFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);


        choice3 = new JButton("Opcion 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(buttonsFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Opcion 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(buttonsFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("Vida:");
        hpLabel.setFont(littleFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(littleFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Arma:");
        weaponLabel.setFont(littleFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(littleFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }

    public void playerSetup(){
        playerHP = 15;
        monsterHP =20;
        playerWeapon = "Sin arma";
        weaponLabelName.setText(playerWeapon);
        hpLabelNumber.setText(""+ playerHP);

        townGate();
    }

    public void townGate(){
        position = "townGate";
        mainTextArea.setText("Estas en la puerta de la ciudad, \nun guardia se encuentra delante tuyo \n\n¿Que haces?");
        choice1.setText("Habla con el guardia");
        choice2.setText("Pegarle al guardia");
        choice3.setText("Irte");
        choice4.setText("");
    }

    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guardia: Hola señor, nunca lo he visto\npor aqui, lo siento pero no puedo dejar\na un extraño entrar el el pueblo");
        choice1.setText("Volver");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guardia: Vas a ver lo que es bueno\n\nEl guardia te ha pegado una paliza \n (Has recibido 3 de daño)");
        playerHP = playerHP-3;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad(){
        position="crossRoad";
        mainTextArea.setText("Estas en un cruce de caminos.\nSi vas al sur volveras a la ciudad");
        choice1.setText("Ir hacia el norte");
        choice2.setText("Ir hacia el este");
        choice3.setText("Ir hacia el sur");
        choice4.setText("Ir hacia el oeste");
    }

    public void north(){
        position = "north";
        mainTextArea.setText("Hay un rio delante tuyo\nBebes agua y descansas al lado del rio\n\n (Recuperas 2 de vida)");
        playerHP = playerHP+2;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText("Volver al cruce");
        choice2.setText("Cruzar el rio");
        choice3.setText("Adentrarse en el bosque");
        choice4.setText("Dormir");
    }

    public void cruzarRio(){
        position = "cruzarRio";
        mainTextArea.setText("La corriente te arrastra\n te golpeas contra una roca y quedas inconciente\n La corriente te arrastra hacia una cascada y mueres");
        playerHP = playerHP-playerHP;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void adentrarseBosque(){
        position = "adentrarseBosque";
        mainTextArea.setText("Te adentras en el bosque y mientras vas caminando encuentras a un guardia herido\n¿Que haces?");
        choice1.setText("Acercarse");
        choice2.setText("Ignorar y seguir adelante");
        choice3.setText("Volver");
        choice4.setText("");
    }

    public void acercarseGuardia(){
        position = "acercarseGuardia";
        mainTextArea.setText("El guardia moribundo te pide porfavor que le entregues esta carta a su general");
        choice1.setText("Acceptar");
        choice2.setText("Ignorar y seguir adelante");
        choice3.setText("");
        choice4.setText("");
    }

    public void acceptarMision(){
        position = "acceptarMision";
        mainTextArea.setText("El guardia te lo agradece y te entrega la carta");
        carta = 1;
        choice1.setText("Subir la montaña");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void subirMontanya(){
        position = "subirMontanya";
        mainTextArea.setText("Mientras subes por la montaña ves que hay dos caminos\nHacia donde quieres ir?");
        choice1.setText("Derecha");
        choice2.setText("Izquierda");
        choice3.setText("Volver");
        choice4.setText("");

    }
    public void cartaEntregada(){
        position = "cartaEntregada";
        mainTextArea.setText(" Guardia: No te olvides de entregar la cartga por favor!");
        choice1.setText("Subir la montaña");
        choice2.setText("Volver al rio");
        choice3.setText("");
        choice4.setText("");
    }

    public void derecha(){
        position="derecha";
        mainTextArea.setText("Vas caminando y encuentras un guardia:\n\nGuardia: Alto!, esto es una zona restringida\n");
        choice1.setText("Traigo una carta importante");
        choice2.setText("Dejame pasar");
        choice3.setText("Irte");
        choice4.setText("");
    }
    public void entregarCarta(){
        position = "entregarCarta";
        mainTextArea.setText("Oh, asi que Henry te ha dicho que entregues esta carta\ndonde esta el ahora mismo?");
        choice1.setText("Esta apunto de morir");
        choice2.setText("No tengo ni idea");
        choice3.setText("Irte");
        choice4.setText("");
    }

    public void forzarEntrada(){
        position = "forzarEntrada";
        mainTextArea.setText("Guardia: No puedes pasar y si intentas algo gracioso\nmoriras!");
        choice1.setText("Atacar");
        choice2.setText("Irte");
        choice3.setText("");
        choice4.setText("");
    }

    public void entregarCartaf2(){
        position = "entregarCartaf2";
        mainTextArea.setText("Guardia: Por favor llevame con el");
        choice1.setText("Guiar guardia");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void henryMuere(){
        mainTextArea.setText("Guardia: Entiendo, porfavor espera que\nentregue esta carta al general");
    }

    public void dormir(){
        position = "dormir";
        mainTextArea.setText("Duermes durante dos horas al despertarte te sientes mucho mejor\n\n (Recibes 5 de vida!)");
        playerHP = playerHP+5;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }


    public void east(){
        position = "east";
        mainTextArea.setText("Has caminado hacia el bosque y has encontrado una Espada Larga\n\n (Has obtenido una Espada Larga)");
        playerWeapon = "Espada Larga";
        weaponLabelName.setText(playerWeapon);
        choice1.setText("Ir al oeste");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void west(){
        position = "west";
        mainTextArea.setText("Has encontrado un goblin");
        choice1.setText("Pelear");
        choice2.setText("Correr");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight(){
        position = "fight";
        mainTextArea.setText("HP Goblin: " + monsterHP + "\n\nQue vas a hacer?");
        choice1.setText("Atacar");
        choice2.setText("Correr");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;
        if (playerWeapon.equals("Sin arma")){
            playerDamage = new java.util.Random().nextInt(5);
        }else if (playerWeapon.equals("Espada Larga")){
            playerDamage = new java.util.Random().nextInt(8);
        }

        mainTextArea.setText("Has atacado al monstruo y le has hecho " + playerDamage + " daño!");
        monsterHP = monsterHP - playerDamage;
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);
        mainTextArea.setText("El monstruo te ha atacado y te ha hecho " + monsterDamage + " de daño");
        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText(""+playerHP);
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void win(){
        position = "win";
        mainTextArea.setText("Has matado al monstruo!! \n\nEl monstruo ha soltado un anillo \n\n (Has obtenido un anillo plateado)");
        silverRing = 1;

        choice1.setText("Ir al hacia el este");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lose(){
        position = "lose";
        mainTextArea.setText("Has muerto \n\n(Game Over)");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void ending(){
        position = "ending";
        mainTextArea.setText("Guardia: Oh has matado ese gobin!?\n Muchas gracias! eres un heroe!\nBienvenido a nuestro pueblo\n\nFIN");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (position){
                case "townGate":
                    switch (yourChoice){
                        case "c1":
                            if (silverRing==1){
                                ending();break;
                            }else{
                                talkGuard(); break;
                            }
                        case "c2": attackGuard();break;
                        case "c3": crossRoad();break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice){
                        case "c1" : townGate(); break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice){
                        case "c1": north();break;
                        case "c2": east();break;
                        case "c3": townGate();break;
                        case "c4": west();break;
                    }
                    break;
                case "north" :
                    switch (yourChoice){
                        case "c1" : crossRoad();break;
                        case "c2" : cruzarRio();break;
                        case "c3" : adentrarseBosque();break;
                        case "c4" : dormir();break;
                    }
                    break;
                case "cruzarRio":
                    switch (yourChoice){
                        case "c1": lose(); break;
                    }
                    break;
                case "dormir":
                    switch (yourChoice){
                        case "c1": north(); break;
                    }
                    break;
                case "adentrarseBosque":
                    switch (yourChoice){
                        case "c1" :
                            if (carta==1){
                             cartaEntregada(); break;
                            }else {
                                acercarseGuardia();
                                break;
                            }
                        case "c2" : subirMontanya();break;
                        case "c3" : north(); break;
                    }
                    break;
                case "subirMontanya":
                    switch (yourChoice){
                        case "c1": break;
                        case "c2": break;
                        case "c3": adentrarseBosque(); break;
                    }break;
                case "acercarseGuardia":
                    switch (yourChoice){
                        case "c1" : acceptarMision();break;
                        case "c2" : subirMontanya(); break;
                    }break;
                case "acceptarMision" :
                    switch (yourChoice){
                        case "c1" : subirMontanya();break;
                    }break;
                case "east":
                    switch (yourChoice){
                        case "c1" :crossRoad();break;
                        case "c2" :break;
                        case "c3" :break;
                        case "c4" :break;
                    }
                    break;
                case "west":
                    switch (yourChoice){
                        case "c1": fight();break;
                        case "c2": crossRoad();break;
                    }
                break;
                    case "fight":
                        switch (yourChoice){
                            case "c1" : playerAttack();break;
                            case "c2" : crossRoad();break;
                        }
                        break;
                case "playerAttack":
                    switch (yourChoice){
                        case "c1":
                            if (monsterHP<1){
                                win();
                            }else {
                                monsterAttack();
                            }
                            break;
                            }
                break;
                case "monsterAttack":
                    switch (yourChoice){
                        case "c1":
                        if (playerHP < 1) {
                            lose();
                        }else {
                            fight();
                        }
                    }
                    break;
                case "win":
                    switch (yourChoice){
                        case "c1": crossRoad();break;
                    }

         }
        }
    }




}

