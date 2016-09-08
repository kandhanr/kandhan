
package kandhan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class kandhan {

      int width=Toolkit.getDefaultToolkit().getScreenSize().width;
      int height=Toolkit.getDefaultToolkit().getScreenSize().height;  
      JFrame frame=new JFrame("Kandhan Yadav");
      Container c=frame.getContentPane();
      final JPanel west = new JPanel();JPanel north=new JPanel();JPanel center=new JPanel();
      ImageIcon img=new ImageIcon("km.png");ImageIcon img1=new ImageIcon("k1.jpg");
      void disp()
      {
          west.setName("west");north.setName("north");center.setName("center");
          JLabel mid=new JLabel("MRK INSTITUTE OF TECHNOLOGY");mid.setFont(new Font("mistral",Font.PLAIN,30));mid.setForeground(Color.white);
          north.setLayout(new MigLayout());north.setBackground(Color.GRAY);JLabel imgg=new JLabel(img);north.add(imgg,"split 2"); north.add(mid);
          center.setLayout(new MigLayout());center.setBackground(Color.white);
          JLabel cre=new JLabel("<html>Created by Kandhan R<br/>Contect : kandhanramalingam0@gmail.com</html>");
          cre.setFont(new Font("mistral",Font.PLAIN,25));JLabel imgg1=new JLabel(img1);center.add(cre,"wrap 20");center.add(imgg1);
          west.setBackground(Color.white);west.setLayout(new MigLayout());
          JButton slb=new JButton("Students Login");slb.setFont(new Font("mistral",Font.PLAIN,25));slb.setBackground(Color.white);slb.setBorderPainted(false);slb.setFocusable(false);
          JButton stlb=new JButton("Staff's Login");stlb.setFont(new Font("mistral",Font.PLAIN,25));stlb.setBackground(Color.white);stlb.setBorderPainted(false);stlb.setFocusable(false);
          JButton hlb=new JButton("HOD's Login");hlb.setFont(new Font("mistral",Font.PLAIN,25));hlb.setBackground(Color.white);hlb.setBorderPainted(false);hlb.setFocusable(false);
          JButton plb=new JButton("Principal's Login");plb.setFont(new Font("mistral",Font.PLAIN,25));plb.setBackground(Color.white);plb.setBorderPainted(false);plb.setFocusable(false);
          west.add(slb,"wrap 20");west.add(stlb,"wrap 20");west.add(hlb,"wrap 20");west.add(plb,"wrap 20");
          ImageIcon img11=new ImageIcon("k6.jpg");JButton im=new JButton(img11);
          im.setFocusable(false);im.setBorderPainted(false);im.setBackground(Color.white);west.add(im);
          slb.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) 
          {
             stdclick();
          }});
          stlb.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) 
          {
             stfclick();
          }});
          hlb.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) 
          {
             hodclick();
          }});
          plb.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) 
          {
             princlick();
          }});
          im.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) 
          {
            c.remove(c.getComponentAt(400,200));c.setVisible(false);
            c.add(center);c.setVisible(true);
          }});
          c.setLayout(new BorderLayout());
          c.setBackground(Color.white);
          c.add(north,BorderLayout.NORTH);c.add(west,BorderLayout.WEST);c.add(center,BorderLayout.CENTER);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(width,height-40);
          frame.setVisible(true);
        
      }
      void stdclick()
      {
          c.remove(c.getComponentAt(400,200));c.setVisible(false);
          final JPanel loginstd = new JPanel();loginstd.setBackground(Color.white);loginstd.setLayout(new MigLayout());
          ImageIcon img=new ImageIcon("k2.jpg");JLabel sim=new JLabel(img);
          JLabel regno=new JLabel("Register Number  :  ");regno.setFont(new Font("mistral",Font.PLAIN,25));final JTextField rgt=new JTextField(20);
          JButton ok=new JButton("Ok");ok.setBorderPainted(false);JButton create=new JButton("Create");create.setBorderPainted(false);
          ok.setFocusable(false);create.setFocusable(false);
          loginstd.add(sim,"span 1 3");
          loginstd.add(regno,"wrap");loginstd.add(rgt,"wrap");
          loginstd.add(ok,"split 2");loginstd.add(create);
          c.add(loginstd);
          c.setVisible(true);
          ok.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) 
          {
             try 
                {
                    
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    String url="jdbc:odbc:mrkit";
                    Connection con=DriverManager.getConnection(url,"","");
                    java.sql.Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from "+rgt.getText()+"detail"+"");
                    rs.next();
                    JLabel name=new JLabel();name.setText(rs.getString("name"));
                    JLabel dep=new JLabel();dep.setText(rs.getString("dep"));
                    JLabel yr=new JLabel();yr.setText(rs.getString("year"));
                    JLabel Name=new JLabel("Name  : ");Name.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
                    JLabel Dep=new JLabel("Department  : ");Dep.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
                    JLabel Yr=new JLabel("Year  : ");Yr.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
                    JButton backd=new JButton("<< Back");
                    final JPanel dtl=new JPanel();                     
                    dtl.setBackground(Color.white);
                    dtl.setLayout(new MigLayout());
                    dtl.add(Name);dtl.add(name,"wrap");
                    dtl.add(Dep);dtl.add(dep,"wrap");
                    dtl.add(Yr);dtl.add(yr,"wrap 20");
                    int i=1;
                    final JButton[] bu=new JButton[10];
                    ResultSet na=stmt.executeQuery("select sname from dep where yr"+yr.getText()+"='"+dep.getText()+"' ");
                    while(na.next())
                    {
                       bu[i]=new JButton(na.getString("sname"));
                       bu[i].setBackground(Color.white);
                       bu[i].setBorderPainted(false);bu[i].setFocusable(false);
                       dtl.add(bu[i],"wrap");
                       final int j=i;
                       bu[i].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                 final JPanel mark=new JPanel();mark.setBackground(Color.white);
                                 JLabel name=new JLabel(bu[j].getText());final JScrollPane sp = new JScrollPane(mark);
                                 JButton backm=new JButton("<< Back");JButton k=new JButton("Submit");
                                 mark.setLayout(new MigLayout());
                                 JLabel mrk1=new JLabel("MRK INSTITUTE OF TECHNOLOGY");mrk1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,30));
                                 mark.add(mrk1,"wrap 60,gapleft "+width/4+",span 10");
                                 JLabel q1=new JLabel("1.	Whether the staffs comes to the class in time.");
                                 final ButtonGroup bg1 = new ButtonGroup();JRadioButton e1,v1,g1,a1,p1; e1=new JRadioButton("Excelent");e1.setActionCommand("5");v1=new JRadioButton("veryGood");v1.setActionCommand("4");g1=new JRadioButton("Good");g1.setActionCommand("3");a1=new JRadioButton("Average");a1.setActionCommand("2");p1=new JRadioButton("Poor");p1.setActionCommand("1");
                                 bg1.add(e1);bg1.add(v1);bg1.add(g1);bg1.add(a1);bg1.add(p1);e1.setSelected(true);
                                 JLabel q2=new JLabel("2.	Planning and preparation for the class lecture");
                                 final ButtonGroup bg2 = new ButtonGroup();JRadioButton e2,v2,g2,a2,p2; e2=new JRadioButton("Excelent");e2.setActionCommand("5");v2=new JRadioButton("veryGood");v2.setActionCommand("4");g2=new JRadioButton("Good");g2.setActionCommand("3");a2=new JRadioButton("Average");a2.setActionCommand("2");p2=new JRadioButton("Poor");p2.setActionCommand("1");
                                 bg2.add(e2);bg2.add(v2);bg2.add(g2);bg2.add(a2);bg2.add(p2);e2.setSelected(true);
                                 JLabel q3=new JLabel("3.	Communications of students & lecturing    capability");
                                 final ButtonGroup bg3 = new ButtonGroup();JRadioButton e3,v3,g3,a3,p3; e3=new JRadioButton("Excelent");e3.setActionCommand("5");v3=new JRadioButton("veryGood");v3.setActionCommand("4");g3=new JRadioButton("Good");g3.setActionCommand("3");a3=new JRadioButton("Average");a3.setActionCommand("2");p3=new JRadioButton("Poor");p3.setActionCommand("1");
                                 bg3.add(e3);bg3.add(v3);bg3.add(g3);bg3.add(a3);bg3.add(p3);e3.setSelected(true);
                                 JLabel q4=new JLabel("4.	Subject Knowledge");
                                 final ButtonGroup bg4 = new ButtonGroup();JRadioButton e4,v4,g4,a4,p4; e4=new JRadioButton("Excelent");e4.setActionCommand("5");v4=new JRadioButton("veryGood");v4.setActionCommand("4");g4=new JRadioButton("Good");g4.setActionCommand("3");a4=new JRadioButton("Average");a4.setActionCommand("2");p4=new JRadioButton("Poor");p4.setActionCommand("1");
                                 bg4.add(e4);bg4.add(v4);bg4.add(g4);bg4.add(a4);bg4.add(p4);e4.setSelected(true);
                                 JLabel q5=new JLabel("5.	Interaction with the students in classroom");
                                 final ButtonGroup bg5 = new ButtonGroup();JRadioButton e5,v5,g5,a5,p5; e5=new JRadioButton("Excelent");e5.setActionCommand("5");v5=new JRadioButton("veryGood");v5.setActionCommand("4");g5=new JRadioButton("Good");g5.setActionCommand("3");a5=new JRadioButton("Average");a5.setActionCommand("2");p5=new JRadioButton("Poor");p5.setActionCommand("1");
                                 bg5.add(e5);bg5.add(v5);bg5.add(g5);bg5.add(a5);bg5.add(p5);e5.setSelected(true);
                                 JLabel q6=new JLabel("6.	Organization of thoughts");
                                 final ButtonGroup bg6 = new ButtonGroup();JRadioButton e6,v6,g6,a6,p6; e6=new JRadioButton("Excelent");e6.setActionCommand("5");v6=new JRadioButton("veryGood");v6.setActionCommand("4");g6=new JRadioButton("Good");g6.setActionCommand("3");a6=new JRadioButton("Average");a6.setActionCommand("2");p6=new JRadioButton("Poor");p6.setActionCommand("1");
                                 bg6.add(e6);bg6.add(v6);bg6.add(g6);bg6.add(a6);bg6.add(p6);e6.setSelected(true);
                                 JLabel q7=new JLabel("7.	Counselling & Closeness with students");
                                 final ButtonGroup bg7= new ButtonGroup();JRadioButton e7,v7,g7,a7,p7; e7=new JRadioButton("Excelent");e7.setActionCommand("5");v7=new JRadioButton("veryGood");v7.setActionCommand("4");g7=new JRadioButton("Good");g7.setActionCommand("3");a7=new JRadioButton("Average");a7.setActionCommand("2");p7=new JRadioButton("Poor");p7.setActionCommand("1");
                                 bg7.add(e7);bg7.add(v7);bg7.add(g7);bg7.add(a7);bg7.add(p7);e7.setSelected(true);
                                 JLabel q8=new JLabel("8.	Completes the course in time covering all prescribed units");
                                 final ButtonGroup bg8 = new ButtonGroup();JRadioButton e8,v8,g8,a8,p8; e8=new JRadioButton("Excelent");e8.setActionCommand("5");v8=new JRadioButton("veryGood");v8.setActionCommand("4");g8=new JRadioButton("Good");g8.setActionCommand("3");a8=new JRadioButton("Average");a8.setActionCommand("2");p8=new JRadioButton("Poor");p8.setActionCommand("1");
                                 bg8.add(e8);bg8.add(v8);bg8.add(g8);bg8.add(a8);bg8.add(p8);e8.setSelected(true);
                                 JLabel q9=new JLabel("9.	Clearing doubts of the students");
                                 final ButtonGroup bg9 = new ButtonGroup();JRadioButton e9,v9,g9,a9,p9; e9=new JRadioButton("Excelent");e9.setActionCommand("5");v9=new JRadioButton("veryGood");v9.setActionCommand("4");g9=new JRadioButton("Good");g9.setActionCommand("3");a9=new JRadioButton("Average");a9.setActionCommand("2");p9=new JRadioButton("Poor");p9.setActionCommand("1");
                                 bg9.add(e9);bg9.add(v9);bg9.add(g9);bg9.add(a9);bg9.add(p9);e9.setSelected(true);
                                 JLabel q10=new JLabel("10.  Provides adequate study material  or gives necessary Completes the course in time covering all prescribed units text book");
                                 final ButtonGroup bg10 = new ButtonGroup();JRadioButton e10,v10,g10,a10,p10; e10=new JRadioButton("Excelent");e10.setActionCommand("5");v10=new JRadioButton("veryGood");v10.setActionCommand("4");g10=new JRadioButton("Good");g10.setActionCommand("3");a10=new JRadioButton("Average");a10.setActionCommand("2");p10=new JRadioButton("Poor");p10.setActionCommand("1");
                                 bg10.add(e10);bg10.add(v10);bg10.add(g10);bg10.add(a10);bg10.add(p10);e10.setSelected(true);
                                 JLabel q11=new JLabel("11.  Encourages & guides the students  to develop originality & creativity");
                                 final ButtonGroup bg11 = new ButtonGroup();JRadioButton e11,v11,g11,a11,p11; e11=new JRadioButton("Excelent");e11.setActionCommand("5");v11=new JRadioButton("veryGood");v11.setActionCommand("4");g11=new JRadioButton("Good");g11.setActionCommand("3");a11=new JRadioButton("Average");a11.setActionCommand("2");p11=new JRadioButton("Poor");p11.setActionCommand("1");
                                 bg11.add(e11);bg11.add(v11);bg11.add(g11);bg11.add(a11);bg11.add(p11);e11.setSelected(true);
                                 JLabel q12=new JLabel("12.  Takes extra interest in explaining & guiding in the lab classes.");
                                 final ButtonGroup bg12 = new ButtonGroup();JRadioButton e12,v12,g12,a12,p12; e12=new JRadioButton("Excelent");e12.setActionCommand("5");v12=new JRadioButton("veryGood");v12.setActionCommand("4");g12=new JRadioButton("Good");g12.setActionCommand("3");a12=new JRadioButton("Average");a12.setActionCommand("2");p12=new JRadioButton("Poor");p12.setActionCommand("1");
                                 bg12.add(e12);bg12.add(v12);bg12.add(g12);bg12.add(a12);bg12.add(p12);e12.setSelected(true); 
                                 JLabel q13=new JLabel("13.  Draws full attention of the students during lecturing& maintains discipline");
                                 final ButtonGroup bg13 = new ButtonGroup();JRadioButton e13,v13,g13,a13,p13; e13=new JRadioButton("Excelent");e13.setActionCommand("5");v13=new JRadioButton("veryGood");v13.setActionCommand("4");g13=new JRadioButton("Good");g13.setActionCommand("3");a13=new JRadioButton("Average");a13.setActionCommand("2");p13=new JRadioButton("Poor");p13.setActionCommand("1");
                                 bg13.add(e13);bg13.add(v13);bg13.add(g13);bg13.add(a13);bg13.add(p13);e13.setSelected(true);
                                 JLabel q14=new JLabel("14.  Conducts test regularly, evaluates answer scripts with fairness and impartiality and Provides feedback on performance");
                                 final ButtonGroup bg14 = new ButtonGroup();JRadioButton e14,v14,g14,a14,p14; e14=new JRadioButton("Excelent");e14.setActionCommand("5");v14=new JRadioButton("veryGood");v14.setActionCommand("4");g14=new JRadioButton("Good");g14.setActionCommand("3");a14=new JRadioButton("Average");a14.setActionCommand("2");p14=new JRadioButton("Poor");p14.setActionCommand("1");
                                 bg14.add(e14);bg14.add(v14);bg14.add(g14);bg14.add(a14);bg14.add(p14);e14.setSelected(true);
                                 JLabel q15=new JLabel("15.  Solving university Question papers");
                                 final ButtonGroup bg15 = new ButtonGroup();JRadioButton e15,v15,g15,a15,p15; e15=new JRadioButton("Excelent");e15.setActionCommand("5");v15=new JRadioButton("veryGood");v15.setActionCommand("4");g15=new JRadioButton("Good");g15.setActionCommand("3");a15=new JRadioButton("Average");a15.setActionCommand("2");p15=new JRadioButton("Poor");p15.setActionCommand("1");
                                 bg15.add(e15);bg15.add(v15);bg15.add(g15);bg15.add(a15);bg15.add(p15);e15.setSelected(true);
                                 mark.add(q1,"span 10,wrap");mark.add(e1);mark.add(v1);mark.add(g1);mark.add(a1);mark.add(p1,"wrap");
                                 mark.add(q2,"span 10,wrap");mark.add(e2);mark.add(v2);mark.add(g2);mark.add(a2);mark.add(p2,"wrap");
                                 mark.add(q3,"span 10,wrap");mark.add(e3);mark.add(v3);mark.add(g3);mark.add(a3);mark.add(p3,"wrap");
                                 mark.add(q4,"span 10,wrap");mark.add(e4);mark.add(v4);mark.add(g4);mark.add(a4);mark.add(p4,"wrap");
                                 mark.add(q5,"span 10,wrap");mark.add(e5);mark.add(v5);mark.add(g5);mark.add(a5);mark.add(p5,"wrap");
                                 mark.add(q6,"span 10,wrap");mark.add(e6);mark.add(v6);mark.add(g6);mark.add(a6);mark.add(p6,"wrap");
                                 mark.add(q7,"span 10,wrap");mark.add(e7);mark.add(v7);mark.add(g7);mark.add(a7);mark.add(p7,"wrap");
                                 mark.add(q8,"span 10,wrap");mark.add(e8);mark.add(v8);mark.add(g8);mark.add(a8);mark.add(p8,"wrap");
                                 mark.add(q9,"span 10,wrap");mark.add(e9);mark.add(v9);mark.add(g9);mark.add(a9);mark.add(p9,"wrap");
                                 mark.add(q10,"span 10,wrap");mark.add(e10);mark.add(v10);mark.add(g10);mark.add(a10);mark.add(p10,"wrap");
                                 mark.add(q11,"span 10,wrap");mark.add(e11);mark.add(v11);mark.add(g11);mark.add(a11);mark.add(p11,"wrap");
                                 mark.add(q12,"span 10,wrap");mark.add(e12);mark.add(v12);mark.add(g12);mark.add(a12);mark.add(p12,"wrap");
                                 mark.add(q13,"span 10,wrap");mark.add(e13);mark.add(v13);mark.add(g13);mark.add(a13);mark.add(p13,"wrap");
                                 mark.add(q14,"span 10,wrap");mark.add(e14);mark.add(v14);mark.add(g14);mark.add(a14);mark.add(p14,"wrap");
                                 mark.add(q15,"span 10,wrap");mark.add(e15);mark.add(v15);mark.add(g15);mark.add(a15);mark.add(p15,"wrap");
                      
                                mark.add(k,"span 2"); mark.add(backm);
                                 c.remove(dtl);c.setVisible(false);
                                 c.add(sp);c.setVisible(true);
                                 backm.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                      c.remove(sp);c.setVisible(false);
                                      c.add(dtl);c.setVisible(true);
                                    }});
                                 k.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        try
                                        {
                                            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                            String url="jdbc:odbc:mrkit";
                                            Connection con=DriverManager.getConnection(url,"","");
                                            java.sql.Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("insert into "+rgt.getText()+" values('"+bu[j].getText()+"',"
                                            + ""+bg1.getSelection().getActionCommand()+","+bg2.getSelection().getActionCommand()+","
                                            + ""+bg3.getSelection().getActionCommand()+","+bg4.getSelection().getActionCommand()+","
                                            + ""+bg5.getSelection().getActionCommand()+","+bg6.getSelection().getActionCommand()+","
                                            + ""+bg7.getSelection().getActionCommand()+","+bg8.getSelection().getActionCommand()+","
                                            + ""+bg9.getSelection().getActionCommand()+","+bg10.getSelection().getActionCommand()+","
                                            + ""+bg11.getSelection().getActionCommand()+","+bg12.getSelection().getActionCommand()+","
                                            + ""+bg13.getSelection().getActionCommand()+","+bg14.getSelection().getActionCommand()+","+bg15.getSelection().getActionCommand()+")");
                                        }catch(Exception cc)
                                        {
                                            JOptionPane.showMessageDialog(null,"Success");
                                        }
                                    }
                                });
                            }
                        });
                       
                       i++;
                    }
                    dtl.add(backd);
                    backd.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                      c.remove(dtl);c.setVisible(false);
                                      c.add(loginstd);c.setVisible(true);
                                    }});
                    
                    c.remove(loginstd);
                    c.setVisible(false);
                    c.add(dtl);
                    c.setVisible(true);
                } catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(null,"Database error..! (or) Create Your Account");
                }
          }});
      }
      void stfclick()
      {
          c.remove(c.getComponentAt(400,400));c.setVisible(false);
          JPanel loginstf = new JPanel();loginstf.setBackground(Color.white);loginstf.setLayout(new MigLayout());
          ImageIcon img=new ImageIcon("k4.jpg");JLabel sim=new JLabel(img);
          JLabel hn=new JLabel("Name  : ");hn.setFont(new Font("mistral",Font.PLAIN,25));
          JLabel hp=new JLabel("Password  : ");hp.setFont(new Font("mistral",Font.PLAIN,25));
          JTextField hnt=new JTextField(20);JPasswordField hpt=new JPasswordField(20);
          JButton hok=new JButton("Ok");hok.setBorderPainted(false);JButton hcreate=new JButton("Create");hcreate.setBorderPainted(false);
          hok.setFocusable(false);hcreate.setFocusable(false);loginstf.add(sim,"span 1 3");
          loginstf.add(hn);loginstf.add(hnt,"wrap 20");loginstf.add(hp);loginstf.add(hpt,"wrap 20");
          loginstf.add(new JLabel());loginstf.add(hok,"split 2");loginstf.add(hcreate);
          c.add(loginstf);
          c.setVisible(true);
      }
      void hodclick()
      {
          c.remove(c.getComponentAt(400,400));c.setVisible(false);
          JPanel loginhod = new JPanel();loginhod.setBackground(Color.white);loginhod.setLayout(new MigLayout());
          ImageIcon img=new ImageIcon("k7.png");JLabel sim=new JLabel(img);
          JLabel hn=new JLabel("Name  : ");hn.setFont(new Font("mistral",Font.PLAIN,25));
          JLabel hp=new JLabel("Password  : ");hp.setFont(new Font("mistral",Font.PLAIN,25));
          JTextField hnt=new JTextField(20);JPasswordField hpt=new JPasswordField(20);
          JButton hok=new JButton("Ok");JButton hcreate=new JButton("Create");hok.setFocusable(false);hcreate.setFocusable(false);
          hok.setBorderPainted(false);hcreate.setBorderPainted(false);loginhod.add(sim,"span 1 3");
          loginhod.add(hn);loginhod.add(hnt,"wrap 20");loginhod.add(hp);loginhod.add(hpt,"wrap 20");
          loginhod.add(new JLabel());loginhod.add(hok,"split 2");loginhod.add(hcreate);
          c.add(loginhod);
          c.setVisible(true);
      }
      void princlick()
      {
          c.remove(c.getComponentAt(400,200));c.setVisible(false);
          JPanel loginstd = new JPanel();loginstd.setBackground(Color.white);loginstd.setLayout(new MigLayout());
          ImageIcon img=new ImageIcon("k5.jpg");JLabel sim=new JLabel(img);
          JLabel regno=new JLabel("Password  :  ");regno.setFont(new Font("mistral",Font.PLAIN,25));JPasswordField hpt=new JPasswordField(20);
          JButton ok=new JButton("Ok");ok.setBorderPainted(false);ok.setFocusable(false);
          loginstd.add(sim,"span 1 3");loginstd.add(regno);loginstd.add(hpt,"wrap");
          loginstd.add(new JLabel(""));loginstd.add(ok,"split 2");
          
          c.add(loginstd);
          c.setVisible(true);
      }
    public static void main(String[] args) {
        kandhan obj=new kandhan();
        obj.disp();
      
    }
    
}
