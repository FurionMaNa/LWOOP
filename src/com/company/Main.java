package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ContentHandler;
import java.util.Enumeration;

public class Main {

    private static final int WIDTH=1000;
    private static final int HEIGHT=900;
    private static FiguraClass figura;
    private static JTextField jTextForX;
    private static JTextField jTextForY;
    private static JTextField jTextForSize;
    private static ButtonGroup buttonGroup;
    private static String selectButton=null;
    private static JFrame jFrame;

    public static void main(String[] args) {
        jFrame=new JFrame("Лабораторная работа");
        jFrame.setLayout(new GridLayout(1,1,10,10));
        jFrame.setSize(WIDTH,HEIGHT);
        jFrame.setBackground(Color.GRAY);
        JPanel jPanel=new JPanel();
        GridLayout gridLayoutForText=new GridLayout(0,4,5,5);
        JPanel jPanelForText=new JPanel(gridLayoutForText);
        GridLayout gridLayoutForElem=new GridLayout(2,0,5,5);
        JPanel jPanelForX=new JPanel(gridLayoutForElem);
        JPanel jPanelForY=new JPanel(gridLayoutForElem);
        JPanel jPanelForSize=new JPanel(gridLayoutForElem);
        JPanel jPanelForSelect=new JPanel(gridLayoutForElem);
        Label labelX=new Label("Введи координату по x:");
        Label labelY=new Label("Введи координату по y:");
        Label labelSize=new Label("Введи размер фигуры:");
        Label labelSelect=new Label("Выбери фигуру для рисования:");
        jTextForX=new JTextField(5);
        jTextForY=new JTextField(5);
        jTextForSize=new JTextField(5);
        JButton jButton=new JButton("Нарисовать");
        buttonGroup=new ButtonGroup();
        JRadioButton jRadioButtonSquare=new JRadioButton("Квадрат",true);
        buttonGroup.add(jRadioButtonSquare);
        JRadioButton jRadioButtonCircle=new JRadioButton("Круг",false);
        buttonGroup.add(jRadioButtonCircle);
        JPanel jPanelRadio=new JPanel();
        jPanelRadio.add(jRadioButtonSquare);
        jPanelRadio.add(jRadioButtonCircle);
        jPanelForX.add(labelX);
        jPanelForX.add(jTextForX);
        jPanelForText.add(jPanelForX);
        jPanelForY.add(labelY);
        jPanelForY.add(jTextForY);
        jPanelForText.add(jPanelForY);
        jPanelForSize.add(labelSize);
        jPanelForSize.add(jTextForSize);
        jPanelForText.add(jPanelForSize);
        jPanelForSelect.add(labelSelect);
        jPanelForSelect.add(jPanelRadio);
        jPanelForText.add(jPanelForSelect);
        jPanel.add(jPanelForText);
        jPanel.add(jButton);
        jFrame.getContentPane().add(jPanel);
        JPanel panelDraw = new PanelDraw();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel.add(panelDraw);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        panelDraw.update(panelDraw.getGraphics());
        jButton.addActionListener(e -> {
            for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {
                    selectButton=button.getText();
                }
            }
            panelDraw.update(panelDraw.getGraphics());
        });

    }

    private static class PanelDraw extends JPanel{

        public PanelDraw() {
            setPreferredSize(new Dimension(Main.WIDTH,Main.HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            if(selectButton!=null) {
                try {
                    if (selectButton.equals("Квадрат")) {
                        figura = new SquareClass(Integer.parseInt(jTextForX.getText()), Integer.parseInt(jTextForY.getText()), Integer.parseInt(jTextForSize.getText()), g);
                    } else {
                        figura = new CircleClass(Integer.parseInt(jTextForX.getText()), Integer.parseInt(jTextForY.getText()), Integer.parseInt(jTextForSize.getText()), g);
                    }
                    figura.Draw();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(jFrame, "Укажи параметры фигуры!!!!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

}
