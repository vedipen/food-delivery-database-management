package FoodDelivery;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database extends Frame implements ActionListener{
     /* @param args the command line arguments
     */
    Label statusl,orderIDl,titlel;
    TextField statust,orderIDt;
    Button b1,b2,b3;
    static Button logout;
    static Button b4;
    TextArea ta;
    Image img;
       Database()
       {         
           setSize(500,580);
           setVisible(true);
           setLayout(null);
           setTitle("Students Record");
           setResizable(false);
           Font fn=new Font("Georgia",Font.BOLD,12);
           setFont(fn);
           setForeground(Color.black);
           setBackground(Color.gray);
           setLocation(600,130);
           
           statusl=new Label("Status:");
           statusl.setBounds(40,450,50,30);
           
           orderIDl=new Label("Order ID:");
           orderIDl.setBounds(190,450,70,30);
           
           statust=new TextField();
           statust.setBounds(90,450,90,30);
           
           orderIDt=new TextField();
           orderIDt.setBounds(260,450,90,30);
           
           b1=new Button("ADD record");
           b1.setBounds(40,500,100,50);
           
           b2=new Button("DELETE record");
           b2.setBounds(150,500,100,50);
           
           b3=new Button("DISPLAY record");
           b3.setBounds(260,500,100,50);
           
           b4=new Button("UPDATE record");
           b4.setBounds(370,500,100,50);
           
           ta=new TextArea();
           ta.setBounds(50,80,400,350);
           ta.setBackground(Color.LIGHT_GRAY);
           ta.setFocusable(false);
           
           logout=new Button("Logout");
           logout.setBounds(380,450,90,30);
             
           logout.setForeground(Color.black);
           logout.setBackground(Color.orange);
           
             titlel=new Label("Sr.No              Order ID                Status");
             titlel.setBounds(100,50,400,30);
             titlel.setForeground(Color.ORANGE);
             
           add(statusl);
           add(orderIDl);
           add(statust);
           add(orderIDt);
           add(b1);
           add(b2);
           add(b3);
           add(b4);
           add(logout);
           add(ta);
           add(titlel);
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
           b4.addActionListener(this);
           logout.addActionListener(this);  
       }
           
       public void display(){
           int i=1;
           try {
               ta.setForeground(Color.BLUE);
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root");
             Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=stmt.executeQuery("select * from users");
              rs.beforeFirst();
        ta.setText("");
        while(rs.next()){
           ta.append("\t"+i+"\t"+rs.getString(1)+"\t"+"             "+rs.getString(2)+"\n");
                   i++;
                }     
                rs.close();
                        con.close();
            } catch (Exception ex) {
            }
       }
    

    @Override
    public void actionPerformed(ActionEvent e){
       
       int i=1;
        if(e.getSource()==b1)
        {
             try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root");
             Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             stmt.executeUpdate("insert into users values("+(Integer.parseInt(orderIDt.getText()))+",'"+statust.getText()+"')");
          } catch (Exception ex) {}
            orderIDt.setText("");
            statust.setText("");
            orderIDt.setFocusable(true); 
        }
        
         if(e.getSource()==b2)
        {
             try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user?user=root");
             Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                int executeUpdate = stmt.executeUpdate("delete from users where orderID="+orderIDt.getText());
          } catch (Exception ex) {}
            statust.setText(" ");
            orderIDt.setText(" ");
            orderIDt.setFocusable(true); 
        }
         
           if(e.getSource()==b4)
           {
                    b4.setEnabled(false);
                    logout.setEnabled(false);
                    new Update(statust.getText(),orderIDt.getText());
                    orderIDt.setText(" ");
                    statust.setText(" ");
           }
             
            if(e.getSource()==logout)
            {
                       addWindowListener(new WindowAdapter() { 
                        @Override
                        public void windowClosing(WindowEvent we)
                        {
                        
                             dispose();
                       }
                        });
                          Login.tt1.setEnabled(true);
                          Login.tt2.setEnabled(true);
                          Login.bb1.setEnabled(true);
                          Login.cb.setState(false);
                               Login.tt2.setText("");
                               Login.fg=false;
                             dispose();                           
            }   
               
           display(); 
        }                       
 }
