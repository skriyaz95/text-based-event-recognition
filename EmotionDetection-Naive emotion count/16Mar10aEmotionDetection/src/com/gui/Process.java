package com.gui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Process extends javax.swing.JFrame {
//String Path=null;
    public  Process(String Path)throws Exception {
        initComponents();
        String Path2=Path;
        jTextField2.setText(Path2);
        Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
        try
        {
            while(fip1.hasNextLine())
                {
                    String str="";
                    String strArrays="";
                    int flag=1;
                    String s1=fip1.nextLine();
                    jTextArea1.append(s1);
                    jTextArea1.append("\n");
                }
        }
        catch(Exception e)
        {
//            e.printStackTrace();
            String Message=e.getMessage().toString();
            System.out.println(Message);
        }
//        return Path2;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Love_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Happy_button = new javax.swing.JButton();
        Tense_Button = new javax.swing.JButton();
        Anger_Button = new javax.swing.JButton();
        Sad_Button = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Showing Words");

        Love_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Love_Button.setText("Love");
        Love_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Love_ButtonActionPerformed(evt);
            }
        });

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

        Happy_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Happy_button.setText("Happy");
        Happy_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Happy_buttonActionPerformed(evt);
            }
        });

        Tense_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Tense_Button.setText("Tense");
        Tense_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tense_ButtonActionPerformed(evt);
            }
        });

        Anger_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Anger_Button.setText("Anger");
        Anger_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Anger_ButtonActionPerformed(evt);
            }
        });

        Sad_Button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Sad_Button.setText("Sad");
        Sad_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sad_ButtonActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setEnabled(false);
        jTextField2.setOpaque(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Love_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(Happy_button)
                                .addGap(40, 40, 40)
                                .addComponent(Tense_Button)
                                .addGap(18, 18, 18)
                                .addComponent(Anger_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Sad_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Happy_button)
                    .addComponent(Tense_Button)
                    .addComponent(Anger_Button)
                    .addComponent(Sad_Button)
                    .addComponent(Love_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Love_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Love_ButtonActionPerformed
    try {
                jTextArea1.setText("");
                String Path=jTextField2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emotion","root","root");
                Statement stmt1=conn.createStatement();
                Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
                String strqrylove=  "Select * from love";
                ResultSet rslove=   stmt1.executeQuery(strqrylove);
                ArrayList<String> Love=new ArrayList<>();
                while (rslove.next()) 
                {      
                    Love.add(rslove.getString(1).trim());                                 
                }
//                jTextArea1.append("\n");
                while(fip1.hasNextLine())
                {
                    int countl=0;
                    int allcount=0;
                    String str="";
                    String strArrays="";
                    int flag=1;
                    String s1=fip1.nextLine();
                    jTextArea1.append("\n");
                    jTextArea1.append(s1+"\t"+":->");
                    String []strArray=s1.split("\\W+");
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
                                    jTextArea1.append(strAList+",");
                                    countl++;
                            }
                        }
			j++;
                    }
                    if(countl==0)
                    {
                               jTextArea1.append("There is no Love Emotion");
                    }
                }

        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage().toString();
            e.printStackTrace();
        }
//    
    }//GEN-LAST:event_Love_ButtonActionPerformed

    private void Sad_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sad_ButtonActionPerformed
    try {
                jTextArea1.setText("");
                String Path=jTextField2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emotion","root","root");
                Statement stmt1=conn.createStatement();
                Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
                String strqrysad=  "Select * from sad";
                ResultSet rssad=   stmt1.executeQuery(strqrysad);
                ArrayList<String> sad=new ArrayList<>();
                while (rssad.next()) 
                {      
                    sad.add(rssad.getString(1).trim());                                 
                }
                while(fip1.hasNextLine())
                {
                    int countl=0;
                    String str="";
                    String strArrays="";
                    int flag=1;
                    String s1=fip1.nextLine();
                    jTextArea1.append("\n");
                    jTextArea1.append(s1+"\t"+":->");
                    String []strArray=s1.split("\\W+");
                    int j = 0;
                    while (sad.size() > j)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=sad.get(j);
                            if(sad.get(j).equals(strArrays))
                            {    
                                    jTextArea1.append("Sad"+",");
                                    countl++;
                            }
                            
                        }
			
			j++;
                    }
                    if(countl==0)
                    {
                            jTextArea1.append("There is no Sad Emotion");
                    }
                    }
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage().toString();
            e.printStackTrace();
        }

    }//GEN-LAST:event_Sad_ButtonActionPerformed

    private void Happy_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Happy_buttonActionPerformed
    try {
                jTextArea1.setText("");
                String Path=jTextField2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emotion","root","root");
                Statement stmt1=conn.createStatement();
                Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
                String strqryHappy=  "Select * from Happy";
                ResultSet rsHappy=   stmt1.executeQuery(strqryHappy);
                ArrayList<String> Happy=new ArrayList<>();
                while (rsHappy.next()) 
                {      
                    Happy.add(rsHappy.getString(1).trim());                                 
                }
                while(fip1.hasNextLine())
                {
                    int countl=0;
                    String str="";
                    String strArrays="";
                    int flag=1;
                    String s1=fip1.nextLine();
                    jTextArea1.append("\n");
                    jTextArea1.append(s1+"\t"+":->");
//                    
                    String []strArray=s1.split("\\W+");
                    int j = 0;
                    while (Happy.size() > j)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Happy.get(j);
                            if(Happy.get(j).equals(strArrays))
                            {    
                                    jTextArea1.append(Happy.get(j)+",");
                                    countl++;
                            }
                        }
			
			j++;
                    }
                    if(countl==0)
                        {
                               jTextArea1.append("There is no Happy Emotion");
                        }
                    }   
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage().toString();
            e.printStackTrace();
        }

    }//GEN-LAST:event_Happy_buttonActionPerformed

    private void Tense_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tense_ButtonActionPerformed
    try {
                 jTextArea1.setText("");
                String Path=jTextField2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emotion","root","root");
                Statement stmt1=conn.createStatement();
                Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
                String strqryTense=  "Select * from Tense";
                ResultSet rsTense=   stmt1.executeQuery(strqryTense);
                ArrayList<String> Tense=new ArrayList<>();
                while (rsTense.next()) 
                {      
                    Tense.add(rsTense.getString(1).trim());                                 
                }
                while(fip1.hasNextLine())
                {
                    int countl=0;
                    String str="";
                    String strArrays="";
                    int flag=1;
                    String s1=fip1.nextLine();
                    jTextArea1.append("\n");
                    jTextArea1.append(s1+"\t"+":->");
                    String []strArray=s1.split("\\W+");
                    int j = 0;
                    while (Tense.size() > j)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Tense.get(j);
                            if(Tense.get(j).equals(strArrays))
                            {    
                                
                                
                                    jTextArea1.append(Tense.get(j)+",");
                                    countl++;
//                                    allcount++;
                                
                                
                            }
                            
                        }
			
			j++;
                    }
                    if(countl==0)
                        {
                               jTextArea1.append("There is no Tense Emotion");
                        }
                    }   
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage().toString();
            e.printStackTrace();
        }

    }//GEN-LAST:event_Tense_ButtonActionPerformed

    private void Anger_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Anger_ButtonActionPerformed
    try {
                 jTextArea1.setText("");
                String Path=jTextField2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emotion","root","root");
                Statement stmt1=conn.createStatement();
                Scanner fip1=new Scanner(new File(Path)); //file here from which you want to remove the stop words
                String strqryAnger=  "Select * from Anger";
                ResultSet rsAnger=   stmt1.executeQuery(strqryAnger);
                ArrayList<String> Anger=new ArrayList<>();
                while (rsAnger.next()) 
                {      
                    Anger.add(rsAnger.getString(1).trim());                                 
                }
                while(fip1.hasNextLine())
                {
                    int countl=0;
                    String str="";
                    String strArrays="";
                    int flag=1;
                    String s1=fip1.nextLine();
                    jTextArea1.append("\n");
                    jTextArea1.append(s1+"\t"+":->");
                    String []strArray=s1.split("\\W+");
                    int j = 0;
                    while (Anger.size() > j)
                    {
                        int size = strArray.length;
                        for (int i=0; i<size; i++)
                        {
                            
                            strArrays=strArray[i];
                            String strAList=Anger.get(j);
                            if(Anger.get(j).equals(strArrays))
                            {    

                                jTextArea1.append(Anger.get(j)+",");
                                countl++;
                            }
                        }
			j++;
                    }
                    if(countl==0)
                        {
                               jTextArea1.append("There is no Anger Emotion");
                        }
                    }   
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage().toString();
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_Anger_ButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
//         jTextField2.setVisible(false);
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Process.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JButton Anger_Button;
    private javax.swing.JButton Happy_button;
    public javax.swing.JButton Love_Button;
    private javax.swing.JButton Sad_Button;
    private javax.swing.JButton Tense_Button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
