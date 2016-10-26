package FoodDelivery;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends Frame implements ActionListener{
   static TextField tt1,tt2;
    Label ll1,ll2,ll3;
    static Button bb1;
    static Checkbox cb;
    String id="dipen",pas="ved";
    Font f;
    static Boolean fg=false;
    Login()
    {
        setSize(400,190);
        setTitle("Login");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocation(400,270);
        addWindowListener(new WindowAdapter() { 
                        @Override
                        public void windowClosing(WindowEvent we)
                        {
                            if(!fg)
                             dispose();
                       }
              });
        //add(fg);
        f=new Font("Georgia",Font.BOLD,14);
        setFont(f);
        tt1=new TextField();
        tt1.setBounds(110,40,150,30);
        
        tt2=new TextField();
        tt2.setBounds(110,80,150,30);
        tt2.setEchoChar('*');
        ll1=new Label("Username:");
        ll1.setBounds(25,40,80,20);
        
        ll2=new Label("Password:");
        ll2.setBounds(25,80,80,20);
        ll3=new Label("");
        ll3.setBounds(30,110,250,20);
        ll3.setForeground(Color.red);
        bb1=new Button("Login");
        bb1.setBounds(280,125,100,50);
        bb1.setForeground(Color.BLUE);
                
        cb=new Checkbox("Remember Me",false);
        cb.setBounds(40,130,150,20);
        cb.setEnabled(true);
        
        
        bb1.addActionListener(this);
        add(tt1);
        add(cb);
        add(tt2);
        add(ll3);
        add(ll2);
        add(ll1);
        add(bb1);
    }
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
         new Login();
            
    }
    

    @Override
    public  void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bb1){
            
        
        if(id.equals(tt1.getText()) && pas.equals(tt2.getText())){
         
            tt1.setEnabled(false);
            tt2.setEnabled(false);
            bb1.setEnabled(false);
            cb.setState(true);
            fg=true;
            new Database();
         }
        else{
           
            ll3.setText("Incorrect Username or Password");
            tt1.setText("");
            tt2.setText("");
        }
        }
    }
    
}
