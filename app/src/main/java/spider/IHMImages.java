/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spider;

/**
 *
 * @author mohammedachrafelkhamlichi
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

// Classe qui permet d'afficher un pion (format image PNG ) dans une case (format JPanel )

public class IHMImages extends JPanel {

    String URLPB;
    String URLPN;

    public Image PBPhoto;
    public Image PNPhoto;
    public boolean TrBnc ; // Déterminer si c'est le tour des blancs ou non
    public Image PhotoPiece ;
    
    // Constructeur d'un JPanel qui permettra d'afficher l'image d'un pion, sa couleur dépendra bien de la valeur de trB qui vaut true si c'est le tour des blancs
    public IHMImages(boolean trB) {
        setBackground(Color.LIGHT_GRAY);
        TrBnc = trB ;
        
        URLPB = "../app/src/main/icones/PB.png";
        URLPN = "../app/src/main/icones/PN.png";
        try {
            PBPhoto = ImageIO.read(new File(URLPB));
            PNPhoto = ImageIO.read(new File(URLPN));  
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        
        Dimension size = new Dimension(100, 100);
        setPreferredSize(size); 
        if (TrBnc)
            PhotoPiece = PBPhoto ;
        else
            PhotoPiece = PNPhoto ;
    }

    @Override
    // Fonction qui permet de dessiner l'image de pion
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(PhotoPiece, 0, 0, 100, 100, this);
    }

}

