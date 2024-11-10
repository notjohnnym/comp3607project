/*
 * Client
 */

package comp3607project;


import javax.swing.*;
import java.io.File;

public class JudgePortal extends javax.swing.JFrame {

    private JudgeSystem judgeSystem;
    private Invoker invoker = new Invoker();

    /**
     * Creates new form judgePortal
     */
    public JudgePortal() 
    {
        initComponents();
    }

    public JudgePortal (JudgeSystem system)
    {
        initComponents();
        this.judgeSystem = system;

        outputButton.setVisible(false);
        evaluateButton.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        submissionPanel = new javax.swing.JPanel();
        mainSubmissionLabel = new javax.swing.JLabel();
        uploadSubmissionLabel = new javax.swing.JLabel();
        zipFileLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        evaluateButton = new javax.swing.JButton();
        outputButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainLabel.setText("Automated Judge System");

        mainSubmissionLabel.setText("Select a Zip File");

        uploadSubmissionLabel.setText("Selected file: ");

        zipFileLabel.setText("...");
        

        browseButton.setText("Browse Files");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        evaluateButton.setText("Evaluate ZIP File");
        evaluateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluateButtonActionPerformed(evt);
            }
        });

        outputButton.setText("Generate Results PDF");
        outputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputButtonActionPerformed(evt);
            }
        });

        submissionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());  

        javax.swing.GroupLayout submissionPanelLayout = new javax.swing.GroupLayout(submissionPanel);
        submissionPanel.setLayout(submissionPanelLayout);
        submissionPanelLayout.setHorizontalGroup(
            submissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(submissionPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(submissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(submissionPanelLayout.createSequentialGroup()
                        .addComponent(uploadSubmissionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zipFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(submissionPanelLayout.createSequentialGroup()
                        .addGroup(submissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(evaluateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(outputButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, submissionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainSubmissionLabel)
                .addGap(152, 152, 152))
        );
        submissionPanelLayout.setVerticalGroup(
            submissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(submissionPanelLayout.createSequentialGroup()
                .addComponent(mainSubmissionLabel)
                .addGap(18, 18, 18)
                .addGroup(submissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadSubmissionLabel)
                    .addComponent(zipFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(submissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton)
                    .addComponent(outputButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(evaluateButton)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(submissionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(mainLabel)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLabel)
                .addGap(18, 18, 18)
                .addComponent(submissionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
    
            


    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:

        
        evaluateButton.setVisible(true);
        
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("ZIP files", "zip"));
        
        int returnValue = fileChooser.showOpenDialog(this);
        
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            zipFileLabel.setText(selectedFile.getAbsolutePath());

            evaluateButton.setVisible(true);
        }
    }                                            

    private void evaluateButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                               

        // TODO add your handling code here:
        outputButton.setVisible(true);
        
        
        String filePath = zipFileLabel.getText();

        mainSubmissionLabel.setText("Evaluating the submission of the file");

        Command unzipFilesCommand = new CommandUnzipFiles (judgeSystem, filePath);
        invoker.setCommand(unzipFilesCommand);
        invoker.pressButton();

        Command runTestsCommand = new CommandRunTests (judgeSystem, filePath);
        invoker.setCommand(runTestsCommand);
        invoker.pressButton();
    }                                              

    private void outputButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                             
        // TODO add your handling code here
        Command producePDFCommand = new CommandProducePDF (judgeSystem);

        mainSubmissionLabel.setText("Generating the results PDF...");

        invoker.setCommand(producePDFCommand);
        invoker.pressButton();

    }                                            

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
            java.util.logging.Logger.getLogger(JudgePortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JudgePortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JudgePortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JudgePortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {   
                JudgeSystem judgeSystem = new JudgeSystem();
                new JudgePortal(judgeSystem).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton browseButton;
    private javax.swing.JButton evaluateButton;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel mainSubmissionLabel;
    private javax.swing.JButton outputButton;
    private javax.swing.JPanel submissionPanel;
    private javax.swing.JLabel uploadSubmissionLabel;
    private javax.swing.JLabel zipFileLabel;
    // End of variables declaration                   
}

