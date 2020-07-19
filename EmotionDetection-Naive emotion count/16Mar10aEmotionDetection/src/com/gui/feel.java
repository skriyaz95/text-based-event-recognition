
package com.gui;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.awt.Component;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author shaik riyaz
 */
public class feel extends javax.swing.JFrame {
File file,file1,file2;
    /**
     * Creates new form main
     */
    public feel() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Remove_stop_words = new javax.swing.JButton();
        Remove_parts_of_speech = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home\n");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Testing the Naive Emotion Count Classifier");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Choose File :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("View Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bullet-wajik-3-blue.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Remove_stop_words.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Remove_stop_words.setText("RemoveStopWords");
        Remove_stop_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_stop_wordsActionPerformed(evt);
            }
        });

        Remove_parts_of_speech.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Remove_parts_of_speech.setText("Apply Parts of Speech");
        Remove_parts_of_speech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_parts_of_speechActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(Remove_stop_words)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Remove_parts_of_speech)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)))))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(Remove_stop_words)
                        .addComponent(Remove_parts_of_speech))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fi = new JFileChooser();
        Component jPanel1 = null;
        fi.showOpenDialog(jPanel1);
        File file = fi.getSelectedFile();
        String path = file.getAbsolutePath();
        jTextField1.setText(path);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try 
        {
                String path = jTextField1.getText();   
                String path1= "AfterPOS.txt";
                feel_process feel_process = new feel_process(path,path1);
                feel_process.setVisible(true);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try {
            String path = jTextField1.getText();    
            String cLine;
            
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while ((cLine = br.readLine()) != null) {
                jTextArea1.append(cLine + "\n");
            }
//            jTextArea1.setText("unhappy");
            String content= jTextArea1.getText();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Remove_stop_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_stop_wordsActionPerformed
        // TODO add your handling code here:
    try{
            String str,clean;
//            JFileChooser fi = new JFileChooser();
            String fname = jTextField1.getText();
//              String fname = file.getAbsolutePath();
            //    FileWriter fw = new FileWriter("D:/Offices file/Mugilan/JPJ1244-Effective Pattern Discovery/datasets/new.txt");
            //               BufferedWriter bwf=new BufferedWriter(fw);
            file1= new File("AfterStopWords.txt");
         
            if (!file1.exists()) 
            {
                 file1.createNewFile();
            }
            FileWriter wr= new FileWriter(file1);
            FileReader  fr=new FileReader(fname);
            BufferedReader br=new BufferedReader(fr);
           while((str=br.readLine())!=null)
            {
                str = str.replaceAll("[^a-zA-Z0-9\\s]", "");
                str= str.toLowerCase();
                //Pattern stopWords = Pattern.compile(stop, Pattern.CASE_INSENSITIVE);
               Pattern stopWords = Pattern.compile("\\b(?:taken|zero|i|what|these|that|their|the|a|able|about|above|abroad|according|accordingly|across|actually|after|afterwards|again|against|ago|ahead|aint|all|allow|allows|almost|alone|along|alongside|already|also|although|always|am|amid|amidst|among|amongst|an|and|another|any|anybody|anyhow|anyone|anything|anyway|anyways|anywhere|apart|appear|appreciate|appropriate|are|arent|around|as|aside|asking|associate|at|available|away|awfully|backbackward|backwards|be|became|because|become|becomes|becoming|been|before|beforehand|begin|behind|being|believe|below|beside|besides|best|better|between|beyond|both|brief|but|by|came|can|cannot|cant|cant|caption|cause|causes|certain|certainly|changes|clearly|cmon|come|comes|concerning|consequently|consider|considering|contain|containing|contains|corresponding|could|couldnt|course|currently|dare|darent|definitely|described|despite|does|doesnt|doing|done|dont|did|didnt|different|directly|do|down|downwards|during|each|eight|eighty|either|else|elsewhere|end|ending|enough|entirely|especially|etc|even|ever|evermore|every|everybody|everyone|everything|everywhere|ex|exactly|example|except|fairly|far|farther|few|fewer|fifth|first|five|followed|following|follows|for|found|four|from|forever|former|formerly|forth|forward|further|furthermore|get|gets|getting|given|gives|go|gotten|greetings|goes|going|gone|got|had|hadnt|half|happens|hardly|has|hasnt|have|havent|having|he|hed|hell|hello|help|hence|her|here|hereafter|hereby|herein|heres|hereupon|hers|herself|hes|hi|him|himself|his|hit|her|hopefully|how|however|hundred||id|if|ignored|ill|im|immediate|in|inc|indeed|indicate|indicated|indicates|inner|inside|instead|into|inward|is|isnt|it|itd|itll|its|itself|ive|just|keep|keeps|kept|know|known|knows|last|lately|later|latter|latterly|least|less|lest|let|lets|like|liked|likely|likewise|little|look|looking|looks|low|lower|made|mainly|make|makes|many|may|maybe|maynt|me|mean|meantime|meanwhile|merely|might|mine|minus|miss|more|moreover|most|mostly|mr|mrs|much|must|mustnt|my|myself|name|namely|near|nearly|necessary|ne|neednt|needs|neither|never|neverf|neverless|nevertheless|new|next|nine|ninety|no|nobody|non|none|nonetheless|nor|normally|not|nothing|notwithstanding|novel|now|nowhere|obviously|of|off|often|oh|ok|okay|old|on|once|one|ones|ones|only|onto|opposite|or|other|others|otherwise|ought|oughtnt|our|ours|ourselves|out|outside|over|overall|own|particular|particularly|past|per|perhaps|placed|please|plus|possible|presumably|probably|provided|provides|que|quite|rather|really|reasonably|recent|recently|regarding|regardless|regards|relatively|respectively|right|round|said|same|saw|say|second|secondly|see|seeing|seem|seemed|seeming|seems|seen|self|selves|sensible|sent|serious|seriously|seven|several|shall|shant|she|shed|shell|shes|should|shouldnt|since|six|so|some|somebody|someday|somehow|someone|something|sometime|sometimes|somewhat|somewhere|soon|sorry|specified|specify|specifying|still|sub|such|sure|take|taken|taking|tell|tends|than|thank|thanks|thanx|that|thatll|thats|thats|thatve|the|their|theirs|them|themselves|then|thence|there|thereafter|thereby|thered|therefore|therein|therell|therere|theres|theres|thereupon|thereve|these|they|theyd|theyll|theyre|theyve|thing|things|think|third|thirty|this|thorough|thoroughly|those|though|three|through|throughout|thru|thus|till|to|toge|ther|too|took|toward|towards|tried|tries|truly|try|trying|twice|two|under|underneath|undoing|unfort|unately|unless|unlike|unlikely|until|unto|up|upon|upwards|us|use|used|useful|uses|using|usually|value|various|versus|very|via|vs|want|wants|was|wasnt|way|we|wed|welcome|well|went|were|werent|weve|what|whatever|whatll|whats|whatve|when|whence|whenever|where|whereafter|whereas|whereby|wherein|wheres|whereupon|wherever|whether|which|whichever|while|whilst|whither|who|whod|whoever|whole|wholl|whom|whomever|whos|whose|why|will|willing|wish|with|within|without|wonder|wont|would|wouldnt|yes|yet|you|youd|youll|your|youre|yours|yourself|yourselves|youve|zero|...)\\b\\s", Pattern.CASE_INSENSITIVE);
              //  Pattern stopWords = Pattern.compile("\\b(?:taken|zero|i|what|these|that|their|the|a|able|about|above|abroad|according|accordingly|accross|actually|after|afterwords|again|against|ago|ahead|aint|all|allow|allows almost|alone|along|alongside|already|)\\b\\s",Pattern.CASE_INSENSITIVE);
                Matcher matcher = stopWords.matcher(str);
               clean = matcher.replaceAll(" ");
                wr.write(clean+"\n");
                jTextArea1.append("\n"+clean+"\n");
            }
            //        bwf.close();
           wr.close();
            br.close();
        }
        catch(Exception e){
        System.out.println(e.getMessage());
}
        // TODO add your handling code here:
    

    }//GEN-LAST:event_Remove_stop_wordsActionPerformed

    private void Remove_parts_of_speechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_parts_of_speechActionPerformed
       /*try
       {
            String str,clean;
           // String fname = jTextField1.getText();
            
            FileReader  fr=new FileReader("AfterStopWords.txt");
            file2= new File("AfterPOS.txt");
            if (!file2.exists()) 
            {
                 file2.createNewFile();
            }
            FileWriter wr= new FileWriter(file2);
            BufferedReader br=new BufferedReader(fr);
            while((str=br.readLine())!=null)
            {
                Pattern stopWords = Pattern.compile("\\b(?:people|history|way|art|world|information|map	|two|family|government|health|system|computer"
                        + "|meat|year|thanks|music|person|reading|method|data|food|understanding|theory|law|bird|literature|problem|software|control"
                        + "|knowledge|power|ability|economics|love|internet|television|science|library|nature|fact|product|idea|temperature|investment"
                        + "|area|society|activity|story|industry|media|advantage|advertisement|advice|agenda|apology|authorization|bill|brand|budget"
                        + "|commission|comparison|competition|competitor|confirmation|costs|creditor|customer|deadline|debt|debtor|decision|decrease"
                        + "|deficit|delivery|department|description|difference|disadvantage|distribution|employee|employer|enquiry|environment|equipment"
                        + "|estimate|experience|explanation|facilities|factory|feedback|goal|goods|growth|guarantee|improvement|increase|industry"
                        + "|instructions|interest|inventory|invoice|knowledge|limit|loss|margin|market|message|mistake|objective|offer|opinion"
                        + "|option|order|output|payment|penalty|permission|possibility|product|production|profit|promotion|purchase|reduction"
                        + "|refund|reminder|repairs|report|responsibility|result|retailer|rise|risk|salary|sales|schedule|share|signature|stock"
                        + "|success|suggestion|supply|support|target|transport|turnover|wholesaler|i|a|without|useless|and|about|an|are|the|at"
                        + "|for|it|to|is|in|of|which|on|will|was|what|when|where|from|this|that|there|with|have|most|into|could|should|us"
                        + "|among|be|...)\\b\\s*", Pattern.CASE_INSENSITIVE);
                Matcher matcher = stopWords.matcher(str);
                clean = matcher.replaceAll(" ");
                wr.write("\n"+clean+"\n\t");
                jTextArea1.append("\n"+clean+"\n\t");
            }
            //        bwf.close();
            br.close();
            wr.close();
        }
        catch(Exception e){
        System.out.println(e.getMessage());
    }//GEN-LAST:event_Remove_parts_of_speechActionPerformed
    */
    try{
        String str;
        MaxentTagger tagger = new MaxentTagger(
                "taggers/english-left3words-distsim.tagger");
         String fname = "AfterStopWords.txt";
         file1= new File("AfterPOS.txt");
            if (!file1.exists()) 
            {
                 file1.createNewFile();
            }
            FileWriter wr = new FileWriter(file1);
            FileReader  fr=new FileReader(fname);
            BufferedReader br=new BufferedReader(fr);
            while((str=br.readLine())!=null)
            {
                 String tagged = tagger.tagString(str);
                  jTextArea1.append("\n"+tagged+"\n\t");
                String []strArray = tagged.split("\\W+");
               // ArrayList<String> cleaned =new ArrayList<>();
                 ArrayList<String> list = new ArrayList<String>();  

                  for(int i=0;i<strArray.length;i++)
                    {
                        if (strArray[i].substring(strArray[i].lastIndexOf("_")+1).startsWith("J")||strArray[i].substring(strArray[i].lastIndexOf("_")+1).startsWith("V"))
                         {
                             list.add(strArray[i].split("_")[0]);
                          }
                     }
                     for(int i=0;i<list.size();i++)
                     {
                          System.out.println(list.get(i));
                          wr.write(list.get(i)+" ");
                     }
                     wr.write("\n");
            }
             wr.close();
            br.close();
 
    }
    catch(Exception e)
    {
        
    }}
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
            java.util.logging.Logger.getLogger(feel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Remove_parts_of_speech;
    private javax.swing.JButton Remove_stop_words;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
