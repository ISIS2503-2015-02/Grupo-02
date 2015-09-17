/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaapplication1.JavaApplication1;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pa.sarmiento10
 */
public class InterfazPrincipal extends JFrame implements ActionListener {
    
    private JavaApplication1 jj;
    private JButton boton1;
    private JButton boton2;
     private JTextField txtchoque;
     private JLabel lblchoque;
     private JTextField txtTemperatura;
     private JLabel lblTemperatura;
     private JTextField txtPanico;
     private JLabel lblPanico;
     private JLabel lblid1;
     private JLabel lblid2;
      private JLabel lblLatitud;
       private JLabel lblLongitud;
       private JTextField txtLongitud;
       private JTextField txtLatitud;
     
     private JTextField id1;
      private JTextField id2;
     
     private final static String ENVIAR = "ENVIAR";
     private final static String ENVIAR2 = "ENVIAR2";
    
     public InterfazPrincipal( )
    {
        setTitle( "TBC transportes" );
        
        jj=new JavaApplication1();
boton1=new JButton();
boton2=new JButton();
txtchoque=new JTextField();
lblchoque=new JLabel();
txtTemperatura=new JTextField();
lblTemperatura=new JLabel();
txtPanico=new JTextField();
lblPanico=new JLabel();
id1=new JTextField();
id2=new JTextField();
lblid1=new JLabel();
lblid2=new JLabel();
lblLatitud=new JLabel();
lblLongitud=new JLabel();
txtLatitud=new JTextField();
txtLongitud=new JTextField();



 boton1.setText( "Emergencias" );
        boton1.setActionCommand( ENVIAR );
        boton1.setVisible(true);
        boton1.addActionListener(this);
        
        boton2.setText("Coordenadas");
        boton2.setActionCommand(ENVIAR2);
        boton2.setVisible(true);
        boton2.addActionListener(this);
        
        lblchoque.setText("emergencia");
        lblPanico.setText("valor");
        lblTemperatura.setText("nada");
        lblid1.setText("id1");
        lblid2.setText("id2");
        lblLatitud.setText("Latitud");
        lblLongitud.setText("Longitud");
        

        
        
    setVisible(true);


        setLayout(new GridLayout(20,20));
         add(lblid1);
        add(id1);
        add(lblchoque);
        add(txtchoque);
        add(lblPanico);
        add(txtPanico);
        add(lblTemperatura);
        add(txtTemperatura);
        add(boton1);
       
        add(lblid2);
        add(id2);
        add(lblLatitud);
        add(txtLatitud);
        add(lblLongitud);
        add(txtLongitud);
       add(boton2);

        
        
         //getContentPane().add(boton1,BorderLayout.SOUTH);
         //getContentPane().add(txtchoque,BorderLayout.NORTH);

        setSize( 530, 530 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

       
    }
    
    public static void main( String[] args )
    {

        InterfazPrincipal femp = new InterfazPrincipal( );
        femp.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     String command = evento.getActionCommand( );

        if( command.equals( ENVIAR ) )
        {
           String id= id1.getText();
          String emergencia=  txtchoque.getText();
          String valor=  txtPanico.getText();
            System.out.println(id+"D"+emergencia+"cd"+valor);
        jj.principal(id,emergencia,valor);
        System.out.println("holaaa");
         
        }
    }
}
