/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spider;

/**
 *
 * @author mohammedachrafelkhamlichi
 */
import javax.swing.*;
//import java.awt.event.*;
import java.awt.GridLayout;
//import java.awt.FlowLayout;
//import java.awt.BorderLayout;
//import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;

//import javax.imageio.ImageIO;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.io.File;

//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


//import java.awt.Point;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class mafenetrex extends JFrame   {
    public boolean tourDesBlancs = true ;
    public int NbrPiecesTotal = 0;
    public String pieceCapturee = "XX";
    public IHMImages PionCapture ; 
    public int derniereCaseAbscisse ;
    public int derniereCaseOrdonnee ;
    public boutongrille[][] listeCases ;
    public boolean partieEnCours = true ; 
    public JPanel P1 ;
    public JLabel texte1 ;

  
    public mafenetrex(){
        
        setTitle("Jeu d'arraignee");
        //setSize(700,700);
        setVisible(true);
        setBackground(Color.magenta);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout( new GridLayout(2,1) );
               
        P1 = new JPanel();
        P1.setPreferredSize(new Dimension(465, 100));
        texte1 = new JLabel("Vous êtes en train de jouer");
        Font font = new Font("Arial", Font.BOLD, 20); // Create a new Font object with Arial font, bold style, and size 20
        texte1.setFont(font); // Set the font of texte1 to the newly created Font object


        
     
        JPanel P2 = new JPanel();
        P2.setPreferredSize(new Dimension(465, 465));
        
        

        listeCases = new boutongrille[3][3];
        for (int i = 0 ; i<3 ; i++){
            for (int j = 0 ; j<3 ; j++) {
                listeCases[i][j] = new boutongrille(this , i , j);
                }}
  
        P2.setLayout( new GridLayout(3,3, 5, 5) );
        /* ----------------------------------------------------------------- */
        /* ----------------------------------------------------------------- */    
        P1.add("Center",texte1);       
        for (int i = 0 ; i<3 ; i++)
            for (int j = 0 ; j<3 ; j++)
                P2.add(listeCases[i][j]);
        /* ----------------------------------------------------------------- */
        /* ----------------------------------------------------------------- */      
        
        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(layout);
        
        add(P1);
        //add(Box.createVerticalStrut(10));
        add(P2);
        /* ----------------------------------------------------------------- */
        /* ----------------------------------------------------------------- */
        pack(); 
        setSize(465,565);
        setResizable(false);
    }
    public boolean testerVoisinage(boutongrille BG){
        int x = BG.abscisse ;
        int y = BG.ordonnee ;
        int x0 = derniereCaseAbscisse ;
        int y0 = derniereCaseOrdonnee ;
        if ((x == x0) && ( y == y0 ))
            return true ; 
        if ( ((x == x0) && (y == y0 + 1)) || ((x == x0) && (y == y0 - 1)) )
            return true ; 
        else if ( ((x == x0 + 1) && (y == y0 )) || ((x == x0 - 1) && (y == y0 )) )
            return true ;
        else if ( ((x == x0 + 1) && (y == y0 + 1)) || ((x == x0 - 1) && (y == y0 - 1)) || ((x == x0 - 1) && (y == y0 + 1)) || ((x == x0 + 1) && (y == y0 - 1)) )
            return true ;
        else
            return false ;
    }
    
    // La fonction testerVoisinageV2 est celle qui permet de passer au 2ème cas expliqué sur le rapport
    /*
    public int testerVoisinageV2(boutongrille BG){
        int x = BG.abscisse ;
        int y = BG.ordonnee ;
        int x0 = derniereCaseAbscisse ;
        int y0 = derniereCaseOrdonnee ;
        if ((x == x0) && ( y == y0 ))
            return 2 ; 
        if ( ((x == x0) && (y == y0 + 1)) || ((x == x0) && (y == y0 - 1)) )
            return 1 ; 
        else if ( ((x == x0 + 1) && (y == y0 )) || ((x == x0 - 1) && (y == y0 )) )
            return 1 ;
        else if ( ((x == x0 + 1) && (y == y0 + 1)) || ((x == x0 - 1) && (y == y0 - 1)) || ((x == x0 - 1) && (y == y0 + 1)) || ((x == x0 + 1) && (y == y0 - 1)) )
            return 1 ;
        else
            return 0 ;
    }
    */
    // Fonction que permet de tester si un joueur a gagné
    public void finDePartie(){

        for (int i = 0 ; i<3 ; i++){
            if ( (!(listeCases[i][0].PieceEnCase.equals("XX"))) && (listeCases[i][0].PieceEnCase.equals(listeCases[i][1].PieceEnCase)) && (listeCases[i][0].PieceEnCase.equals(listeCases[i][2].PieceEnCase))  ){
                partieEnCours = false ;
                if (listeCases[i][0].PieceEnCase.equals("PB"))
                    texte1.setText("Le jeu est terminé, les Blancs ont gagné !!");
                else
                    texte1.setText("Le jeu est terminé, les Noirs ont gagné !!");
                }
            
            if ( (!(listeCases[0][i].PieceEnCase.equals("XX"))) && (listeCases[0][i].PieceEnCase.equals(listeCases[1][i].PieceEnCase)) && (listeCases[0][i].PieceEnCase.equals(listeCases[2][i].PieceEnCase))  ){
                partieEnCours = false ;
                if (listeCases[0][i].PieceEnCase.equals("PB"))
                    texte1.setText("Le jeu est terminé, les Blancs ont gagné !!");
                else
                    texte1.setText("Le jeu est terminé, les Noirs ont gagné !!");
                }
            }
                
        if (!(listeCases[1][1].PieceEnCase.equals("XX"))) {
            if ( (listeCases[0][0].PieceEnCase.equals(listeCases[1][1].PieceEnCase)) && (listeCases[0][0].PieceEnCase.equals(listeCases[2][2].PieceEnCase))  ){
                partieEnCours = false ;
                if (listeCases[1][1].PieceEnCase.equals("PB"))
                    texte1.setText("Le jeu est terminé, les Blancs ont gagné !!");
                else
                    texte1.setText("Le jeu est terminé, les Noirs ont gagné !!");
                }
            if ( (listeCases[0][2].PieceEnCase.equals(listeCases[1][1].PieceEnCase)) && (listeCases[1][1].PieceEnCase.equals(listeCases[2][0].PieceEnCase))  ){
                partieEnCours = false ;
                if (listeCases[1][1].PieceEnCase.equals("PB"))
                    texte1.setText("Le jeu est terminé, les Blancs ont gagné !!");
                else
                    texte1.setText("Le jeu est terminé, les Noirs ont gagné !!");
            }
        }
    }

}


