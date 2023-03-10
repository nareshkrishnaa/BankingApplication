package main;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Transfer extends javax.swing.JFrame {

    /**
     * Creates new form Transfer
     */
    private String str;
    public Transfer() {
       
        initComponents();
    }
    
    public Transfer(String username) {
        str=username;
        initComponents();
    }
    
    public String getUserName(){
        return this.str;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        benAccNo = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        sendMoney = new javax.swing.JButton();
        back = new javax.swing.JButton();
        pwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transfer");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Benficiary account number :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Enter amount :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Enter Password :");

        sendMoney.setText("Send Money");
        sendMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMoneyActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(amt, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pwd))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(benAccNo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(sendMoney)
                .addGap(28, 28, 28)
                .addComponent(back)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMoneyActionPerformed
          String sender=this.getUserName();
          String senAcc =new String();
          System.out.println(String.format("sender username is %s",sender));
          String benAcc=benAccNo.getText();
          int amount= Integer.valueOf(amt.getText());
          send: try{
            System.out.println("Submit button pressed in Transfer Form");
            
            ConnectionHelper ch =new ConnectionHelper();
            Connection con =ch.getConnection();
            Statement stmt = con.createStatement();
            Statement pwdCheck =con.createStatement();
            Statement accNoCheck =con.createStatement();
            Statement balanceCheck=con.createStatement();
            
            
            
            Statement senAccNo = con.createStatement();
            String senAccNoQuery = String.format("select accNo from customerdetails where emailId='%s'", sender);
            ResultSet saq = senAccNo.executeQuery(senAccNoQuery);
            
            if(saq.next()){
                 senAcc=saq.getString("accNo");
            }
            
            String accNoCheckQuery=String.format("select * from customerdetails where accNo='%s'",benAcc);
            ResultSet rs1 = accNoCheck.executeQuery(accNoCheckQuery);
            int benAccFlag=0;
            if(rs1.next()){
                System.out.println("ben acc no resultset exists");
                benAccFlag=1;
            }
            if(benAccFlag==0){
                System.out.println("ben acc does not exist");
                JOptionPane.showMessageDialog(null, "benificiary acc does not exist");
                break send;
            }
            
            String balanceCheckQuery=String.format("select BankBalance from customerdetails where emailId='%s'",sender);
            ResultSet rs2=balanceCheck.executeQuery(balanceCheckQuery);
            int balFlag=0;
            if(rs2.next()){
                if(rs2.getInt("BankBalance")<amount)
                {
                    System.out.println("Insufficient balance");
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    break send;
                }
            }
            String pwdCheckQuery=String.format("select password from customerdetails where emailId='%s'",sender);
            ResultSet rs=pwdCheck.executeQuery(pwdCheckQuery);
             
            if(rs.next())
                 System.out.println(rs.getString("password")+" "+pwd.getText());
            if((rs.getString("password")).equals(pwd.getText())){
                System.out.println("Password is correct");                
            String query1=String.format("update customerdetails set BankBalance=BankBalance+%s where accNo='%s'",amount,benAcc);
            String query2=String.format("update customerdetails set BankBalance=BankBalance-%s where emailId='%s'",amount,sender);
            String query3=String.format("insert into transaction (accNo,transactions,transactionTime)values('%s',+%s,NOW())", benAcc,amount);
            String query4=String.format("insert into transaction (accNo,transactions,transactionTime)values('%s',-%s,NOW())", senAcc,amount);
            
            System.out.println(query1);
                System.out.println(query2);
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
            stmt.executeUpdate(query4);
            
             JOptionPane.showMessageDialog(null, "Money sent successfully");
             this.dispose();
            
            }
            else{
                System.out.println("Password incorrect");
                JOptionPane.showMessageDialog(null, "Password incorrect");
                break send;
            }
              //System.out.println();
            
            
            
            
        }catch(SQLException ex){
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
// TODO add your handling code here:
    }//GEN-LAST:event_sendMoneyActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amt;
    private javax.swing.JButton back;
    private javax.swing.JTextField benAccNo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JButton sendMoney;
    // End of variables declaration//GEN-END:variables
}
