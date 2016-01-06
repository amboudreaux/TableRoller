/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author aaron
 */
public class TableRollerGUI extends javax.swing.JFrame
  {

  public static Random generator;
  public static String[][] daggerAttackChart;

  /**
   * Creates new form TableRollerGUI
   */
  public TableRollerGUI()
    {
    initComponents();
    generator = new Random();
    
    daggerAttackChart = new String[151][20];
    loadWeaponCharts();
    }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    TabPanel = new javax.swing.JTabbedPane();
    PlanetGenPanel = new javax.swing.JPanel();
    numPlanetsSpinner = new javax.swing.JSpinner();
    numPlanetsLabel = new javax.swing.JLabel();
    planetGenButton = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    planetGenTextArea = new javax.swing.JTextArea();
    planetSaveButton = new javax.swing.JButton();
    rollmasterWeaponPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    RMActionTypeCB = new javax.swing.JComboBox<>();
    jLabel3 = new javax.swing.JLabel();
    RMWeaponSelectCB = new javax.swing.JComboBox<>();
    jLabel4 = new javax.swing.JLabel();
    RMWeaponSkillBonus = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    RMSpecialItemBonus = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    RMBonus = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    RMActivityNotUsed = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    RMDefenseBonus = new javax.swing.JTextField();
    RMRollButton = new javax.swing.JButton();
    RMResultScrollPane = new javax.swing.JScrollPane();
    RMResultTextArea = new javax.swing.JTextArea();
    jLabel2 = new javax.swing.JLabel();
    RMTargetArmor = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Table Roller");

    numPlanetsSpinner.setValue(1);

    numPlanetsLabel.setText("Planets to Generate:");

    planetGenButton.setText("Generate!");
    planetGenButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        planetGenButtonMouseClicked(evt);
      }
    });

    planetGenTextArea.setColumns(20);
    planetGenTextArea.setRows(5);
    jScrollPane1.setViewportView(planetGenTextArea);

    planetSaveButton.setText("Save Generated Planets");
    planetSaveButton.setEnabled(false);
    planetSaveButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        planetSaveButtonMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout PlanetGenPanelLayout = new javax.swing.GroupLayout(PlanetGenPanel);
    PlanetGenPanel.setLayout(PlanetGenPanelLayout);
    PlanetGenPanelLayout.setHorizontalGroup(
      PlanetGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
      .addGroup(PlanetGenPanelLayout.createSequentialGroup()
        .addComponent(planetSaveButton)
        .addGap(0, 226, Short.MAX_VALUE))
      .addGroup(PlanetGenPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(numPlanetsLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(numPlanetsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(planetGenButton)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    PlanetGenPanelLayout.setVerticalGroup(
      PlanetGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PlanetGenPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PlanetGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(numPlanetsLabel)
          .addComponent(numPlanetsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(planetGenButton))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(planetSaveButton))
    );

    TabPanel.addTab("Planet Gen", PlanetGenPanel);

    jLabel1.setText("Type of Action:");

    RMActionTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Snap", "Normal", "Deliberate" }));
    RMActionTypeCB.setSelectedIndex(1);

    jLabel3.setText("Weapon:");

    RMWeaponSelectCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dagger" }));

    jLabel4.setText("Skill Bonus:");

    RMWeaponSkillBonus.setEditable(false);
    RMWeaponSkillBonus.setText("0");

    jLabel5.setText("Special Item Bonus:");

    RMSpecialItemBonus.setEditable(false);
    RMSpecialItemBonus.setText("0");

    jLabel6.setText("Penalties/Bonuses:");

    RMBonus.setText("0");

    jLabel7.setText("Activity Not Used:");

    RMActivityNotUsed.setText("0");

    jLabel8.setText("Defense Bonus:");

    RMDefenseBonus.setText("0");

    RMRollButton.setText("ROLL!");
    RMRollButton.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        RMRollButtonMouseClicked(evt);
      }
    });

    RMResultTextArea.setColumns(20);
    RMResultTextArea.setRows(5);
    RMResultScrollPane.setViewportView(RMResultTextArea);

    jLabel2.setText("Target Armor:");

    RMTargetArmor.setText("1");
    RMTargetArmor.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        RMTargetArmorActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout rollmasterWeaponPanelLayout = new javax.swing.GroupLayout(rollmasterWeaponPanel);
    rollmasterWeaponPanel.setLayout(rollmasterWeaponPanelLayout);
    rollmasterWeaponPanelLayout.setHorizontalGroup(
      rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(RMResultScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(RMRollButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
            .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RMActionTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RMTargetArmor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RMWeaponSkillBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RMSpecialItemBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(RMWeaponSelectCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RMBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RMActivityNotUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RMDefenseBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 40, Short.MAX_VALUE)))
        .addContainerGap())
    );
    rollmasterWeaponPanelLayout.setVerticalGroup(
      rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(rollmasterWeaponPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(RMActionTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(RMTargetArmor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(RMWeaponSelectCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(RMWeaponSkillBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5)
          .addComponent(RMSpecialItemBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(RMBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7)
          .addComponent(RMActivityNotUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(rollmasterWeaponPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(RMDefenseBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(40, 40, 40)
        .addComponent(RMRollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(RMResultScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        .addContainerGap())
    );

    TabPanel.addTab("Rollmaster Weapon", rollmasterWeaponPanel);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(TabPanel)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(TabPanel)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /*
    This function calls generatePlanet a number of times equal to the value in the
    numPlanetsSpinner.
   */
    private void planetGenButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_planetGenButtonMouseClicked
    {//GEN-HEADEREND:event_planetGenButtonMouseClicked
      planetSaveButton.setEnabled(true);
      String output = "";
      int numPlanets = Integer.parseInt(numPlanetsSpinner.getValue().toString());

      //always generate at least 1 planet
      numPlanets = (numPlanets < 1) ? 1 : numPlanets;

      JFileChooser fileChooser = new JFileChooser("masterFiles");
      fileChooser.setDialogTitle("Select Master File");
      String defaultFilename = "masterFiles\\PlanetGenList.txt";
      fileChooser.setSelectedFile(new File(defaultFilename));

      int selection = fileChooser.showOpenDialog(null);

      if (selection == JFileChooser.APPROVE_OPTION)
        {
        File masterFile = fileChooser.getSelectedFile();
        //output += "Generating " + numPlanets + " planets!\n";
        for (int i = 0; i < numPlanets; i++)
          {
          output += "Planet " + i + ":\n" + generatePlanet(masterFile) + "\n";
          }
        }

      planetGenTextArea.setText(output);
    }//GEN-LAST:event_planetGenButtonMouseClicked

  /*
    This function writes the generated planets to a text file.
    
    TODO: Allow user to specify filename.
   */
    private void planetSaveButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_planetSaveButtonMouseClicked
    {//GEN-HEADEREND:event_planetSaveButtonMouseClicked
      JFileChooser fileChooser = new JFileChooser(".");
      fileChooser.setDialogTitle("Save");

      int selection = fileChooser.showSaveDialog(null);

      if (selection == JFileChooser.APPROVE_OPTION)
        {
        try
          {
          File filename = fileChooser.getSelectedFile();
          FileWriter outFile = new FileWriter(filename + ".txt");
          outFile.write(planetGenTextArea.getText());
          outFile.close();
          }
        catch (IOException ex)
          {
          Logger.getLogger(TableRollerGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }//GEN-LAST:event_planetSaveButtonMouseClicked

    private void RMRollButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RMRollButtonMouseClicked
      //pull info from the combo boxes and text areas
      String actionType = RMActionTypeCB.getSelectedItem().toString();
      String weapon = RMWeaponSelectCB.getSelectedItem().toString();
      int skillBonus = Integer.parseInt(RMWeaponSkillBonus.getText().toString());
      int specialItemBonus = Integer.parseInt(RMSpecialItemBonus.getText().toString());

      int bonus = Integer.parseInt(RMBonus.getText());
      int activity = Integer.parseInt(RMActivityNotUsed.getText());
      int defenseBonus = Integer.parseInt(RMDefenseBonus.getText());
      
      int targetArmor = Integer.parseInt(RMTargetArmor.getText().toString());

      String output = "";

      /*output += "Action Type: " + actionType + "\nWeapon: " + weapon
              + "\nBonus/Penality: " + bonus + "\nActivity Not Used: "
              + activity + "\nDefense Bonus: " + defenseBonus + "\n"; */

      int roll = rollDie(100);

      output += "Base Roll = " + roll + "\n";

      //check for fumble
      if (roll <= 5)
        {
        int fumbleRoll;
        output += "\n\nFUMBLE\n\n";
        do
          {
          fumbleRoll = rollDie(100);
          roll -= fumbleRoll;
          output += "Fumble Roll = " + fumbleRoll + "\n";
          }
        while(fumbleRoll > 96);
        output += "Final base roll = " + roll;
        }//end of fumble
      //check for open-ended high roll
      else if (roll >= 96)
        {
        int highRoll;
        output += "\n\nOpen Ended High\n\n";
        do
          {
          highRoll = rollDie(100);
          roll += highRoll;
          output += "High Roll = " + highRoll + "\n";
          }
        while(highRoll > 96);
        output += "Final base roll = " + roll + "\n";
        }

      roll += skillBonus + specialItemBonus + bonus - activity - defenseBonus;
      output += "Final roll = " + roll + "\n";
      
      roll = (roll < 0) ? 0 : roll;
      roll = (roll > 150) ? 150 : roll;
      
      String result = daggerAttackChart[roll][targetArmor-1];
      output += "Result = " + result + "\n";
      RMResultTextArea.setText(output);
    }//GEN-LAST:event_RMRollButtonMouseClicked

  private void RMTargetArmorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RMTargetArmorActionPerformed
  {//GEN-HEADEREND:event_RMTargetArmorActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RMTargetArmorActionPerformed

  /*
    This function reads in the planet generation master file, which contains the
    filenames of the tables to be rolled on. For each file listed, it calls the
    processPlanetFile function.
    
    TODO: Change hardcoded filename to allow user to choose master file.
   */
  public String generatePlanet(File masterFile)
    {
    String output = "";

    Scanner sc;
    try
      {
      sc = new Scanner(masterFile);

      int numFiles = sc.nextInt();
      sc.nextLine();
      for (int i = 0; i < numFiles; i++)
        {
        String filename = sc.nextLine();
        //output += filename + "\n";

        output += processPlanetFile(filename) + "\n";
        }
      sc.close();
      }
    catch (FileNotFoundException ex)
      {
      Logger.getLogger(TableRollerGUI.class.getName()).log(Level.SEVERE, null, ex);
      }

    return output;
    }//end of generatePlanet

  /*
    This function processes one planet file. The assumed file format is as follows:
    Line 1: Two values
        The number of dice to roll
        The size of die used
    Lines 2-n: One value per line, the table value for a given die roll
   */
  public String processPlanetFile(String filename)
    {
    String output = "";

    try
      {
      Scanner sc = new Scanner(new File(filename));

      String[] line = sc.nextLine().split(" ");
      int numDice = Integer.parseInt(line[0]);
      int dieFaces = Integer.parseInt(line[1]);

      int roll = 0;
      for (int i = 0; i < numDice; i++)
        {
        roll += rollDie(dieFaces);
        }

      //output += "total roll: " + roll + "\n";
      //NOTE: minimum possible value = number of dice rolled
      //Ex: 2d6 - min value is 2
      int maxValue = numDice * dieFaces;

      int row = numDice;
      while (sc.hasNextLine() && row != roll)
        {
        sc.nextLine();
        row++;
        }

      output += sc.nextLine();
      sc.close();
      }
    catch (FileNotFoundException ex)
      {
      Logger.getLogger(TableRollerGUI.class.getName()).log(Level.SEVERE, null, ex);
      }

    return output;
    }//end of processPlanetFile

  /*
    This function rolls a die with the specified number of sides and returns the result.
   */
  public int rollDie(int faces)
    {
    return generator.nextInt(faces) + 1;
    }//end of rollDie
  
  public void loadWeaponCharts()
    {
    //load dagger chart (only one I have for now)
    try
      {
      Scanner sc = new Scanner(new File("tables\\RolemasterDaggerAttack.csv"));

      int row = 1; //chart starts at 1
      while (sc.hasNextLine())
        {
        daggerAttackChart[row++] = sc.nextLine().split(",");
        
        //RMResultTextArea.append(daggerAttackChart[row][0] + "\n");
        }
      
      sc.close();
      }
    catch (FileNotFoundException ex)
      {
      Logger.getLogger(TableRollerGUI.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//end of loadWeaponCharts

  public static void main(String args[])
    {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
      {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
        {
        if ("Nimbus".equals(info.getName()))
          {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
          }
        }
      }
    catch (ClassNotFoundException ex)
      {
      java.util.logging.Logger.getLogger(TableRollerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
    catch (InstantiationException ex)
      {
      java.util.logging.Logger.getLogger(TableRollerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
    catch (IllegalAccessException ex)
      {
      java.util.logging.Logger.getLogger(TableRollerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
      java.util.logging.Logger.getLogger(TableRollerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
      {
      public void run()
        {
        new TableRollerGUI().setVisible(true);
        }
      });
    }//end of main

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel PlanetGenPanel;
  private javax.swing.JComboBox<String> RMActionTypeCB;
  private javax.swing.JTextField RMActivityNotUsed;
  private javax.swing.JTextField RMBonus;
  private javax.swing.JTextField RMDefenseBonus;
  private javax.swing.JScrollPane RMResultScrollPane;
  private javax.swing.JTextArea RMResultTextArea;
  private javax.swing.JButton RMRollButton;
  private javax.swing.JTextField RMSpecialItemBonus;
  private javax.swing.JTextField RMTargetArmor;
  private javax.swing.JComboBox<String> RMWeaponSelectCB;
  private javax.swing.JTextField RMWeaponSkillBonus;
  private javax.swing.JTabbedPane TabPanel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel numPlanetsLabel;
  private javax.swing.JSpinner numPlanetsSpinner;
  private javax.swing.JButton planetGenButton;
  private javax.swing.JTextArea planetGenTextArea;
  private javax.swing.JButton planetSaveButton;
  private javax.swing.JPanel rollmasterWeaponPanel;
  // End of variables declaration//GEN-END:variables
    }//end of class
