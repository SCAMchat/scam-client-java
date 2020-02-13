package main;

import javax.swing.JFrame;
import javax.swing.AbstractAction;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Interface extends JFrame{
    Panel contentPane;
    JTextArea text;
    JTextField inputField;
    JTextField URIfield;
    String content="";
    MainProgram main;
    
    public Interface(MainProgram m){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	main=m;
        setBounds(100,100,500,500);
        setVisible(true);
        contentPane= new Panel(new java.awt.BorderLayout(0,0));
        contentPane.setBackground(Color.BLACK);
        text=new JTextArea();
        text.setBackground(new Color(50,50,50));
        text.setForeground(Color.WHITE);
        text.setEditable(false);
        contentPane.add(text,java.awt.BorderLayout.CENTER);
        inputField=new JTextField();
        inputField.setEditable(true);
        inputField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"enterPressed");
        inputField.getActionMap().put("enterPressed", new EnterAction());
        contentPane.add(inputField,java.awt.BorderLayout.SOUTH);
        
        URIfield=new JTextField();
        URIfield.setEditable(true);
        URIfield.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"enterPressedURI");
        URIfield.getActionMap().put("enterPressedURI", new EnterURIAction());
        contentPane.add(URIfield,java.awt.BorderLayout.NORTH);

        setContentPane(contentPane);
    }
    
    public void addLine(String s){
        content+=s+"\n";
        text.setText(content);
    }
    
    class EnterAction extends AbstractAction{
        
    	public EnterAction() {
    		
    	}
    	
    	public void actionPerformed(ActionEvent e){
    		main.send(inputField.getText());
    		inputField.setText("");
    	}
    	
    }
    
    class EnterURIAction extends AbstractAction{
        
    	public EnterURIAction() {
    		
    	}
    	
    	public void actionPerformed(ActionEvent e){
    		main.setURI(URIfield.getText());
    	}
    	
    }
    
}
