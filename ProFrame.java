package ita;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
public class ProFrame {
	public static void main(String[] args) {
		JFrame user=new JFrame("Login Type");
		JButton lb=new JButton("LOGIN");
		JButton ab=new JButton("Admin");
		JButton sb=new JButton("SIGN UP");
		lb.setBounds(50, 50, 100, 30);
		ab.setBounds(100, 100,100, 30);
        sb.setBounds(200, 50, 100, 30);
        lb.addActionListener(new ActionListener(){  
    	    public void actionPerformed(ActionEvent e){ 
    	    	user.setVisible(false);
    	    		JFrame l=new JFrame("Login");
    	    		JTextField t1;
    	    		JLabel a1;
    	    		JButton b1,b5;
    	    		a1=new JLabel("UserName : ");
    	    		t1 = new JTextField(""); 
    	            t1.setBounds(150, 40, 200, 30); 
    	            a1.setBounds(30,40,130,30);
    	            b1=new JButton("NEXT");
    	            b1.setBounds(40, 100, 80, 40);
    	            b5=new JButton("BACK");
    	            b5.setBounds(150, 100, 80, 40);
    	            b5.addActionListener(new ActionListener(){  
    	    		    public void actionPerformed(ActionEvent e){
    	    		    l.setVisible(false);
    	    		    user.setVisible(true);
    	    		    }
    	    		    });
    	        	b1.addActionListener(new ActionListener(){  
    	    		    public void actionPerformed(ActionEvent e){
    	    		    	l.setVisible(false);
    	    		    	SaveData ss1=new SaveData();
    	    		    	if(ss1.checkus(t1.getText())==0) {
    	    		    		signup();
    	    		    	}
    	    		    	else {
    	    		    	if(ss1.checkus(t1.getText())!=0) {
    	    		    		JFrame p=new JFrame("PassWord");
    	    		    		JPasswordField t2;
    	    		    		JLabel a2;
    	    		    		JButton b2,b5;
    	    		    		JCheckBox sp = new JCheckBox("Show Password");
    	    		    		a2=new JLabel("password : ");
    	    		    		t2 = new JPasswordField(""); 
    	    		            t2.setBounds(150, 40, 200, 30); 
    	    		            a2.setBounds(30,40,130,30);
    	    		            b2=new JButton("Check and GO");
    	    		            b2.setBounds(40, 100, 200, 40);
    	    		            sp.setBounds(260, 100, 150, 40);
    	    		            b5=new JButton("BACK");
    	        	            b5.setBounds(150, 150, 80, 40);
    	        	            b5.addActionListener(new ActionListener(){  
    	        	    		    public void actionPerformed(ActionEvent e){
    	        	    		    l.setVisible(true);
    	        	    		    p.setVisible(false);
    	        	    		    }
    	        	    		    });
    	    		            sp.addActionListener(new ActionListener(){  
    	    					    public void actionPerformed(ActionEvent e){
    	    					    	if (sp.isSelected()) {
    	    				                t2.setEchoChar((char) 0);
    	    				            } else {
    	    				                t2.setEchoChar('o');
    	    				            }
    	    					    }
    	    					});

    	    		            b2.addActionListener(new ActionListener(){  
    	    		    		    public void actionPerformed(ActionEvent e){
    	    		    		    	SaveData s=new SaveData();
    	    		    		    	if(ss1.checkuspas(t1.getText(), t2.getText())!=0) {
    	    		    		    		s.signup( t1.getText(), t2.getText(), "LOG IN SUCESSFULLY");
    	    		    		    		p.setVisible(false);
    	    		    		    		Editor edit=new Editor(t1.getText());
    	    		    		    	}
    	    		    		    	else {
    	    		    		    		p.setVisible(false);
    	    		    		    		signup();
    	    		    		    	}
    	    		    		    }
    	    		            });
    	    		            p.add(t2);
    	    		            p.add(b5);
    	    		            p.add(a2);
    	    		            p.add(b2);
    	    		            p.add(sp);
    	    		            p.setSize(500, 500);
    	    		            p.setLayout(null);
    	    		            p.setVisible(true);
    	    		    	}
    	    		    	}
    	    		    }
    	    		});
    	            l.add(b1);
    	            l.add(a1);
    	            l.add(b5);
    	            l.add(t1);
    	            l.setSize(400, 200);
    	            l.setLayout(null);
    	            l.setVisible(true);
    	            }
        });
		 sb.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				user.setVisible(false);
				signup();
				}
		 });
		 ab.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				user.setVisible(false);
				JFrame p=new JFrame("PassWord");
	    		JPasswordField t2;
	    		JLabel a2;
	    		JButton b2,b5;
	    		JCheckBox sp = new JCheckBox("Show Password");
	    		a2=new JLabel("password : ");
	    		t2 = new JPasswordField(""); 
	            t2.setBounds(150, 40, 200, 30); 
	            a2.setBounds(30,40,130,30);
	            b2=new JButton("Check and GO");
	            b2.setBounds(40, 100, 200, 40);
	            sp.setBounds(260, 100, 150, 40);
	            b5=new JButton("BACK");
	            b5.setBounds(150, 170, 80, 40);
	            b5.addActionListener(new ActionListener(){  
	    		    public void actionPerformed(ActionEvent e){
	    		    p.setVisible(false);
	    		    user.setVisible(true);
	    		    }
	    		    });
	            sp.addActionListener(new ActionListener(){  
				    public void actionPerformed(ActionEvent e){
				    	if (sp.isSelected()) {
			                t2.setEchoChar((char) 0);
			            } else {
			                t2.setEchoChar('o');
			            }
				    }
				});
	            b2.addActionListener(new ActionListener(){  
	    		    public void actionPerformed(ActionEvent e){
	    		    	if(t2.getText().compareTo("asdfg")==0) {
	    		    	p.setVisible(true);
	    		    		Adduser();
	    		    		}
	    		    	else {
	    		    		JFrame mes=new JFrame("Alert");
		    				JOptionPane.showMessageDialog(mes,"You Entered wrong Password!","Alert",JOptionPane.WARNING_MESSAGE);  
		                           p.setVisible(false);
		                           user.setVisible(true);
	    		    	}
	    		    }
	            });
	            p.add(t2);
	            p.add(a2);
	            p.add(b2);
	            p.add(b5);
	            p.add(sp);
	            p.setSize(500, 500);
	            p.setLayout(null);
	            p.setVisible(true);
				}
		 });
		user.add(ab);
        user.add(sb);
        user.add(lb);
       
        user.setSize(400,200);
        user.setLayout(null);
        user.setVisible(true);
        user.setResizable(false);
	}
public static void Adduser() {
		JFrame how=new JFrame("PERSON DETAILS");
		JTextField t1,t2,t3;
			t1 = new JTextField(); 
	        t1.setBounds(150, 50, 130, 30); 
	        t2 = new JTextField(); 
	        t2.setBounds(150, 120, 130, 30); 
	        t3 = new JTextField(); 
	        t3.setBounds(490, 120, 130, 30); 
	  JButton b1,b2,b3;
	  JLabel l1,l2,l3,l4;
	  l1 = new JLabel("UserName:"); 
      l1.setBounds(50, 50, 100, 30); 
      l2 = new JLabel("Password:"); 
      l2.setBounds(50, 120, 120, 30); 
      l3 = new JLabel("GMail:"); 
      l3.setBounds(420, 120, 70, 30); 
      l4=new JLabel("");
      l4.setBounds(420, 200, 500, 40);
	  b1 = new JButton("Show log in"); 
      b1.setBounds(200, 300, 200, 30); 
      b2 = new JButton("Save"); 
      b2.setBounds(200, 400, 200, 30); 
      b3 = new JButton("Show user detail"); 
      b3.setBounds(200, 350, 200, 30); 
      SaveData sd=new SaveData();
      b2.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) 
          { 
        	  JFrame dia=new JFrame();
        	  JOptionPane.showMessageDialog(dia,"Your Personal Details Are Saved Succesfully!!!");  
      String s1=t1.getText();  
  	String s3=t3.getText();
  	String s2=t2.getText();
  	sd.log(s3, s1, s2);
  	t1.setText("");
  	t2.setText("");
  	t3.setText("");
          }
      });
      b1.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) 
          { 
        	  how.setVisible(true);
        	sd.dispDB(1);  
          }});
      b3.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) 
          { 
        	  how.setVisible(true);
        	sd.dispDB(2);  
          }});
      how.getContentPane().setBackground(Color.white);
      how.add(l4);
      how.add(l3);
      how.add(l2);
      how.add(l1);
      how.add(b1);
      how.add(b2);
      how.add(b3);
      how.add(t1);
      how.add(t2);
      how.add(t3);
      how.getMaximizedBounds();
      how.setSize(700, 700);
      how.setLayout(null);
      how.setVisible(true);     
	}
	public static void signup() {
		JFrame jf=new JFrame("Login");
		 	JTextField t1,t2;
			JPasswordField t3;
			JLabel a1,a2,a3;
			JCheckBox sp = new JCheckBox("Show Password");
			a1=new JLabel("GMail : ");
			t1 = new JTextField(""); 
	        t1.setBounds(200, 50, 200, 30); 
	        a1.setBounds(30,50,150,30);
	        a2=new JLabel("UserName : ");
			t2 = new JTextField(""); 
	        t2.setBounds(200, 100, 200, 30); 
	        a2.setBounds(30,100,150,30);
	        a3=new JLabel("Create PassWord : ");
			t3 = new JPasswordField(""); 
	        t3.setBounds(200, 150, 200, 30); 
	        a3.setBounds(30,150,150,30);
	        sp.setBounds(410, 150, 150, 30);
	        JButton b1=new JButton("Check");
			b1.setBounds(80, 200, 100, 40);
			JButton b2=new JButton("Already have Account");
			b2.setBounds(200, 200, 200, 40);
			sp.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){
			    	if (sp.isSelected()) {
		                t3.setEchoChar((char) 0);
		            } else {
		                t3.setEchoChar('X');
		            }
			    }
			});
			b2.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){
			    	ProFrame a=new ProFrame();
			    	a.main(null);
			    	jf.setVisible(false);
			    }
			});
			b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	jf.setVisible(true);
		    	SaveData s=new SaveData();
		    	if(s.checkemail(t1.getText(),t2.getText())==0) {
		    	Random rand = new Random(); 
				int rand_int1 = rand.nextInt(99999999); 
		    	Nmail e1 =new Nmail();
		    	e1.sendotp(t1.getText(), rand_int1);
		    	JFrame jf1 =new JFrame("OTP");
		    	JTextField t4;
		    	t4 = new JTextField(); 
		        t4.setBounds(20, 50, 80, 30); 
			      JButton jb= new JButton("Check OTP");
			      jb.setBounds(110, 50, 100,30);
			      jb.addActionListener(new ActionListener(){  
					    public void actionPerformed(ActionEvent e){ 
					    	String otp=t4.getText();
					    	int i=Integer.parseInt(otp);
					    	if(rand_int1==i) {
					     		SaveData ins=new SaveData();
					    		ins.log(t1.getText(), t2.getText(), t3.getText());
					    		ins.signup(t2.getText(), t3.getText(), "LOG IN SUCESSFULLY");
					    		String a=t2.getText();
					    		ins.createdb(a);
					    		Editor edi=new Editor(a);
					    		jf1.setVisible(false);
					    		jf.setVisible(false);
					    		e1.sendsucs(t1.getText());
					    	   	}
					    	
					    	else {
					    		SaveData ins=new SaveData();
					    		ins.trytolog(t1.getText(), t2.getText(), t3.getText());
					    		
					    		JFrame mes=new JFrame("Alert");
					    				JOptionPane.showMessageDialog(mes,"You Entered wrong OTP!","Alert",JOptionPane.WARNING_MESSAGE);  
					    	jf1.setVisible(false);
					    	jf.setVisible(true);
					    	}
			    	
					    		
					    }
					    
			      });
		    	
			      jf1.add(t4);
			      jf1.add(jb);
			      jf1.setSize(400, 200);
			      jf1.setLayout(null);
			      jf1.setVisible(true);
			      jf1.setResizable(false);
		    }
		    	else if(s.checkemail(t1.getText(),t2.getText())>0) {
		    		JFrame mes1=new JFrame("Alert");
				JOptionPane.showMessageDialog(mes1,"This username or GMail id is already used","Alert",JOptionPane.WARNING_MESSAGE);  
				jf.setVisible(true);
		    		//aaa.login();
		    }
		    }
			});
			jf.add(b1);
			jf.add(b2);
			jf.add(a1);
			jf.add(t1);
			jf.add(a2);
			jf.add(t2);
			jf.add(a3);
			jf.add(t3);
			jf.add(sp);
			jf.setSize(700,700);
			jf.setLayout(null);
			jf.setVisible(true);
	}
}
