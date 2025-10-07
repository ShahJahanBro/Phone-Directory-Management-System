package Phone;

import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Harjandar Kumar & Shah Jahan 
 */

public class Main extends  JFrame implements ActionListener{

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                      
    public Object[][] setlogic(LinkedList<String> list){
           
    Object arr1[][] = new Object[list.size()][10];    
    
    String temp = "";

        int count=1;
         for(int i=0;i<list.size();i++){
            String str = list.get(i);
            count=1; 
            for(int j=0;j<str.length();j++){
                if(j==0){
                    arr1[i][j] = (i+1)+"";
                    
                }
                if(str.charAt(j)!=' '){
                    temp+=str.charAt(j);
                    
                    
                }
                 if(str.charAt(j) ==' ' || j==str.length()-1){
                    arr1[i][count] = temp; 
                    temp="";
                    count++;
                }
            }
        }
	count = 1 ;
        return arr1;
    }
    private void initComponents() {
        Directory obj = new Directory();
        Object arr[][] = new Object[1][1];
        obj.readfile();
        arr = setlogic(obj.list);
        Object arr1[] = {"NO","First name","Last name","PNO"};
        jMenuBar = new  JMenuBar();
        jMenu = new  JMenu("Menu");
        search = new  JMenuItem("Search");
        delete = new  JMenuItem("Delete");
        create = new  JMenuItem("create Groups");
        display = new  JMenuItem("Display Groups");
        con = new  JMenuItem("Add Contact");
        edit = new  JMenuItem("Edit");
        
        jMenu.setBackground(Color.GRAY);
        jMenu.setForeground(Color.RED);
        
        
        jMenu.add(search);
        jMenu.add(delete);
        jMenu.add(create);
        jMenu.add(display);
        jMenu.add(con);
        jMenu.add(edit);

        jMenuBar.add(jMenu);

        search.addActionListener(this);
        delete.addActionListener(this);
        create.addActionListener(this);
        display.addActionListener(this);
        con.addActionListener(this);
        edit.addActionListener(this);    
        
        jScrollPane2 = new  JScrollPane();
        jTable2 = new  JTable(arr,arr1);
    
        setJMenuBar(jMenuBar);    
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 102));
        setBackground(getForeground());

        jTable2.setForeground(new java.awt.Color(0, 255, 255));
        jTable2.setBackground(new java.awt.Color(51, 0, 51));
        jScrollPane2.setViewportView(jTable2);
    
         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2,  GroupLayout.DEFAULT_SIZE, 323,Short.MAX_VALUE
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2,  GroupLayout.DEFAULT_SIZE, 189,Short.MAX_VALUE 
        ));
    
        pack();
    }                      
    
        public void actionPerformed(ActionEvent event){
          Search s = new Search();
          Delete d = new Delete();
          GroupName g = new GroupName();
          DisplayGroups dg = new DisplayGroups();
          NewJFrame n = new NewJFrame();
          Edit e = new Edit();
            if(event.getSource() == search){
                s.sframe.setVisible(true);
            }
            if(event.getSource() == delete){
                d.deleteDelete(ABORT);
            }
            if(event.getSource() == create){
                g.initComponents();
            }
            if(event.getSource() == display){
                dg.displaygroup(ABORT);
            }
            if(event.getSource() == con){
                n.setVisible(true);
            }
            if(event.getSource() == edit){
                e.edit();
            }
        }


    public static void main(String args[]) {

        /* create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

                       
    private  JScrollPane jScrollPane2;
    private  JTable jTable2;
    private  JMenuBar jMenuBar;
    private  JMenu jMenu;
    private  JMenuItem search;
    private  JMenuItem delete;
    private  JMenuItem create;             
    private  JMenuItem display;
    private  JMenuItem edit;
    private  JMenuItem con; 
}
