package com.belili.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Model_image extends javax.swing.JPanel {
    
    String ruta;
    
    public Model_image(int x, int y, String ruta) {
        
        this.setSize(x, y);
        this.ruta = ruta;
    }
    
    public void paint(Graphics g) {
        
        Dimension height = getSize();
        Image imgExt = new ImageIcon(ruta).getImage();
        g.drawImage(imgExt, 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
}
