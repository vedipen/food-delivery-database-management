package FoodDelivery;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update extends Frame implements ActionListener{
    Label lu1,lu2,lu3,lu4;
    TextField tu1,tu2,tu3,tu4;
    String status,orderID;
    Button up;
     Update(String status,String orderID) {
         setSize(320,120);
         setVisible(true);
         setResizable(false);
         setTitle("Update Record");
         setLayout(null);
         Font fm=new Font("Georgia",Font.BOLD,13);
         setFont(fm);
         setLocation(640,400);
         addWindowListener(new WindowAdapter() { 
                        @Override
                        public void windowClosing(WindowEvent we)
                        {
                             Database.b4.setEnabled(true);
                             dispose();
                       }
              });
         this.status=status;
         this.orderID=orderID;
         tu1=new TextField();
         tu1.setBounds(120,40,100,30);
        
        tu2=new TextField();
        tu2.setBounds(120,70,100,30);
        
        
        lu1=new Label("Status:");
        lu1.setBounds(25,40,80,20);
        
        lu2=new Label("Order ID:");
        lu2.setBounds(25,70,80,20);

         up=new Button("UPDATE");
         up.setBounds(230,40,70,60);
         up.setForeground(Color.MAGENTA);
         add(lu1);
         add(lu2);
         add(tu1);
         add(tu2);
         add(up);
         up.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root");
             Statement stmt1= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             Statement stmt2= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             stmt1.executeUpdate("update users set status='"+tu1.getText()+"' where status='"+status+"'");
             stmt2.executeUpdate("update users set orderID="+(Integer.parseInt(tu2.getText()))+" where orderID="+orderID);
          } catch (Exception ex) {
   
                                 }
            tu1.setText("");
            tu2.setText("");
            tu1.setFocusable(true);
            
            Database.b4.setEnabled(true);
            Database.logout.setEnabled(true);
            dispose();            
    }        
}
