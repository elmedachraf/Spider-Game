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
import java.awt.event.*;
//import java.awt.GridLayout;
//import java.awt.FlowLayout;
//import java.awt.BorderLayout;
import java.awt.Color;

public class boutongrille extends JPanel implements MouseListener {
    public int NbrPieceCase = 0 ;
    public mafenetrex mywindow ;
    public String PieceEnCase = "XX";
    public IHMImages monPion ;
    public int abscisse ;
    public int ordonnee ;

    
    public boutongrille(mafenetrex cha, int i, int j){
        mywindow = cha ;
        abscisse = i ;
        ordonnee = j ;
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(this);
        setSize(150,150);
    }
    public void mousePressed(MouseEvent e) {
        if (mywindow.partieEnCours ){
        // Phase de placement
            if (mywindow.NbrPiecesTotal <= 5){ // Vérifier si on est en phase de placement
                if (NbrPieceCase == 0){
                    mywindow.derniereCaseAbscisse = abscisse ;
                    mywindow.derniereCaseOrdonnee = ordonnee ;
                    monPion = new IHMImages(mywindow.tourDesBlancs );
                    add( monPion );
                    if (mywindow.tourDesBlancs)
                        PieceEnCase = "PB";
                    else
                        PieceEnCase = "PN";
                    NbrPieceCase = 1 ;
                    boolean alpha = mywindow.tourDesBlancs ; 
                    mywindow.tourDesBlancs = !alpha ;
                    mywindow.NbrPiecesTotal++ ;
                    mywindow.finDePartie();
                    
                    repaint();
                    revalidate(); 
                }
            }
            // Phase de déplacement
            else{
                // Capturer une pièce
                if ((NbrPieceCase == 1) && (mywindow.pieceCapturee.equals("XX") ) ){
                    if ( ((mywindow.tourDesBlancs) && (PieceEnCase.equals("PB") )) || ((!(mywindow.tourDesBlancs)) && (PieceEnCase.equals("PN") )) ){
                        mywindow.pieceCapturee = PieceEnCase ;
                        mywindow.PionCapture = monPion ;
                        PieceEnCase = "XX";
                        NbrPieceCase = 0 ;
                        remove(monPion);
                        mywindow.derniereCaseAbscisse = abscisse ;
                        mywindow.derniereCaseOrdonnee = ordonnee ;
                        repaint();
                        revalidate(); 
                    }
                }
                // Déposer une pièce
                else if ((NbrPieceCase == 0) && (!(mywindow.pieceCapturee.equals("XX")) ) ){
                    if (mywindow.testerVoisinage(this)){ // Vérifier si on a sélectionner une case voisine
                        PieceEnCase = mywindow.pieceCapturee ;
                        monPion = mywindow.PionCapture ;
                        add( monPion );
                        NbrPieceCase = 1 ;
                        mywindow.pieceCapturee = "XX";
                        mywindow.PionCapture = null ;
                        boolean alpha = mywindow.tourDesBlancs ; 
                        mywindow.tourDesBlancs = !alpha ;
                        mywindow.finDePartie();
                        repaint();
                        revalidate(); 
                    } 
                    /*
                    if ((mywindow.testerVoisinageV2(this) == 1) || (mywindow.testerVoisinageV2(this) == 2)){
                        PieceEnCase = mywindow.pieceCapturee ;
                        monPion = mywindow.PionCapture ;
                        add( monPion );
                        NbrPieceCase = 1 ;
                        mywindow.pieceCapturee = "XX";
                        mywindow.PionCapture = null ;
                        mywindow.finDePartie();
                        repaint();
                        revalidate(); 
                        if (mywindow.testerVoisinageV2(this) == 1){
                            boolean alpha = mywindow.tourDesBlancs ; 
                            mywindow.tourDesBlancs = !alpha ;
                        }
                        
                    }*/
                }

            }  
        }
        
    }


    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {} 

    public void mouseClicked(MouseEvent e) {}
    
        
}


