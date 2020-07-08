/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author luisa
 */
public class ComponentePregunta extends JPanel implements ActionListener {

    private JLabel cuestion;
    private JRadioButton[] rbRespuestas;
    private JButton aceptar;
    private String respuestas[] = {"respuesta1","respuesta2","respuesta3","respuesta4"};
    private ButtonGroup bg;
    private Container cndrRB;
    private int acierto;
    private int pocicionRespuesta;
    
    public ComponentePregunta(){
        setLayout(new BorderLayout());
        cuestion = new JLabel("¿Cual es tu cuestion?");
        generaRB();
        addElemts();
        respCorrecta();
    }
    
    
    public void respCorrecta(){
        if(rbRespuestas[pocicionRespuesta].isSelected()){
            acierto++;
        }
    }
    
    
    private void addElemts(){
        add(cuestion,BorderLayout.NORTH);
        cndrRB = new  Container();
        cndrRB.setLayout(new GridLayout(1,4,5,1));
        for(JRadioButton i:rbRespuestas){
            cndrRB.add(i);
        }
        add(cndrRB,BorderLayout.SOUTH);
        
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        add(aceptar,BorderLayout.EAST);
    }
    
    private void generaRB(){
        bg = new ButtonGroup();
        rbRespuestas = new JRadioButton[4];
        for(int i=0;i<4;i++){
            rbRespuestas[i]= new JRadioButton(respuestas[i]);
            bg.add(rbRespuestas[i]);
        
        }

    }
    
    public int getContadorAciertos(){
        return acierto;
    }
    
    public void setAciertos(int valor){
        acierto = valor;
    }
    
    public int getpocicionRespuesta(){
        return pocicionRespuesta;
    }
    public void setCualEsRespuesta(int pr){
        this.pocicionRespuesta = pr;
    }

    public String[] getVerRespuestas() {
        return respuestas;
    }

    public int getAciert() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }
    
     public void setPregunta(String pregunta){
        cuestion.setText(pregunta);
    }
     
    public void setRespuestas(String array[]){
        respuestas=array;
        for(int i=0;i<respuestas.length;i++){
            rbRespuestas[i].setText(respuestas[i]);
        }
    }
    
    public void desactivarRB()
    {
        for(int i=0;i<4;i++){
            rbRespuestas[i].setEnabled(false);
        }
    }

    
    /*public static void main(String []args){
        JFrame window = new JFrame();
        ComponentePregunta pnl = new ComponentePregunta();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(100,100);
        window.setVisible(true);
        window.add(pnl);
        
        
        
        //window.add(cuadrito,BorderLayout.CENTER);
        
    }*/

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == aceptar)
        {
            //System.out.println("wenas");
            desactivarRB();
        }
    }
    
}
