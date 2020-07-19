
package com.gui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class feel_process extends javax.swing.JFrame {

    public feel_process(String Path, String Path1)throws Exception {
        initComponents();
     try {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:2016/project","root","root");
                Statement stmt1=conn.createStatement();
                Statement stmt2=conn.createStatement();
                Statement stmt3=conn.createStatement();
                Statement stmt4=conn.createStatement();
                Statement stmt5=conn.createStatement();
                Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
                Scanner fip2= new Scanner(new File(Path1));
                String strqrylove=  "Select * from love";
                String strqryHappy= "Select * from Happy";
                String strqryTense= "Select * from Tense";
                String strqryAnger= "Select * from Anger";
                String strqrySad=   "Select * from Sad";
                
                ResultSet rslove=   stmt1.executeQuery(strqrylove);
                ResultSet rsHappy=  stmt2.executeQuery(strqryHappy);
                ResultSet rsTense=  stmt3.executeQuery(strqryTense);
                ResultSet rsAnger=  stmt4.executeQuery(strqryAnger);
                ResultSet rsSad=    stmt5.executeQuery(strqrySad);
                
                ArrayList<String> Love=new ArrayList<>();
                ArrayList<String> Happy=new ArrayList<>();
                ArrayList<String> Tense=new ArrayList<>();
                ArrayList<String> Anger=new ArrayList<>();
                ArrayList<String> Sad=new ArrayList<>();
                while (rslove.next()) 
                {      
                    Love.add(rslove.getString(1).trim());                                 
                }
                while (rsHappy.next()) 
                {      
                    Happy.add(rsHappy.getString(1).trim());                                 
                }
                while (rsTense.next()) 
                {      
                    Tense.add(rsTense.getString(1).trim());                                 
                }
                while (rsAnger.next()) 
                {      
                    Anger.add(rsAnger.getString(1).trim());                                 
                }
                while (rsSad.next()) 
                {      
                    Sad.add(rsSad.getString(1).trim());                                 
                }
                
                while(fip1.hasNextLine()&&fip2.hasNextLine())
                {
                    int countl=0;
                    int counth=0;
                    int countt=0;
                    int counta=0;
                    int counts=0;
                    int allcount=0;
                    String str="";
                    String strArrays="";
                    int flag=1;
                   String s1=fip1.nextLine();
                    String s2=fip2.nextLine();
                    jTextArea1.append("\n");
                    jTextArea1.append(s1+"\t"+":->");
                    
                    String []strArray=s2.split("\\W+");
                    int j = 0;
                    while (Love.size() > j)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Love.get(j);
                            if(Love.get(j).equals(strArrays))
                            {    
                                
                                if(countl==0)
                                {
                                    //jTextArea1.append("Love"+",");
                                    countl++;
                                    allcount++;
                                }
                                
                            }
                            
                        }
			
			j++;
                    }
                    
                    int k = 0;
                    while (Happy.size() > k)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Happy.get(k);
                            if(Happy.get(k).equals(strArrays))
                            {    
                                
                                if(counth==0)
                                {
                                    //jTextArea1.append("Happy"+",");
                                    counth++;
                                    allcount++;
                                }
                            }
                        }
			k++;
                    }
                    
                    int l = 0;
                    while (Tense.size() > l)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Happy.get(l);
                            if(Happy.get(l).equals(strArrays))
                            {    
                                
                                if(countt==0)
                                {
                                  //  jTextArea1.append("Tense"+",");
                                    countt++;
                                    allcount++;
                                }
                            }
                        }
			l++;
                    }

                     int m=0;
                    while (Anger.size() > m)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Anger.get(m);
                            if(Anger.get(m).equals(strArrays))
                            {   
                                
                                if(counta==0)
                                {
                                   // jTextArea1.append("Anger"+",");
                                    counta++;
                                    allcount++;
                                }
                            }
                        }
			m++;
                    }
                     int n=0;
                    while (Sad.size() > n)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Anger.get(n);
                            if(Sad.get(n).equals(strArrays))
                            {   
                                
                                if(counta==0)
                                {
                                   // jTextArea1.append("Sad"+",");
                                    counta++;
                                    allcount++;
                                }
                                
                            }
                        }
			n++;
                    }
                    if(allcount==0)
                    {
                        jTextArea1.append("Emotionless");
                    }
                    else
                    {
                        if(countl > counth && countl > countt && countl > counta && countl > counts)
                        {
                            jTextArea1.append("Love");
                        }
                        else if(counth > countl && counth > countt && counth > counta && counth > counts)
                        {
                            jTextArea1.append("Happy");
                        }
                        else if(countt > countl && countt > counth && countt > counta && countt > counts)
                        {
                            jTextArea1.append("Tense");
                        }
                        else if(counta > countl && counta > counth && counta > countt && counta > counts)
                        {
                            jTextArea1.append("Anger");
                        }
                        else if(counts > countl && counts > counth && counts > countt && counts > counta)
                        {
                            jTextArea1.append("Sad");
                        }
                        
                        else if(countl== counth)
                        {
                            jTextArea1.append("Love"+","+"Happy");
                        }
                        else if(countl== countt)
                        {
                            jTextArea1.append("Love"+","+"Tense");
                        }
                        else if(countl== counta)
                        {
                            jTextArea1.append("Love"+","+"Anger");
                        }
                        else if(countl== counts)
                        {
                            jTextArea1.append("Love"+","+"Sad");
                        }
                        else if(counth== countl)
                        {
                            jTextArea1.append("Love"+","+"Happy");
                        }
                        else if(counth== countt)
                        {
                            jTextArea1.append("Happy"+","+"Tense");
                        }
                        else if(counth== counta)
                        {
                            jTextArea1.append("Happy"+","+"Anger");
                        }
                        else if(counth== counts)
                        {
                            jTextArea1.append("Happy"+","+"Sad");
                        }
                        else if(counta== counth)
                        {
                            jTextArea1.append("Anger"+","+"Happy");
                        }
                        else if(counta== countt)
                        {
                            jTextArea1.append("Anger"+","+"Tense");
                        }
                        else if(countl== counta)
                        {
                            jTextArea1.append("Love"+","+"Anger");
                        }
                        else if(counta== counts)
                        {
                            jTextArea1.append("Anger"+","+"Sad");
                        }
                        else if(counts== counth)
                        {
                            jTextArea1.append("Sad"+","+"Happy");
                        }
                        else if(counts== countt)
                        {
                            jTextArea1.append("Sad"+","+"Tense");
                        }
                        else if(counts== counta)
                        {
                            jTextArea1.append("sad"+","+"Anger");
                        }
                        else if(counta== counts)
                        {
                            jTextArea1.append("Anger"+","+"Sad");
                        }
                    }
                }
                
                
            } catch (Exception e) {
            e.printStackTrace();
        }   
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Prediction of emotions");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("DATA PROCESSING");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel1)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(feel_process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feel_process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feel_process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feel_process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Process(textarea).setVisible(true);
            }
        });
    }
private javax.swing.JTextField jTextField1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
