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
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aaron
 */
public class TableRollerGUI extends javax.swing.JFrame
    {

    public static Random generator;

    /**
     * Creates new form TableRollerGUI
     */
    public TableRollerGUI()
        {
        initComponents();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PlanetGenPanel = new javax.swing.JPanel();
        numPlanetsSpinner = new javax.swing.JSpinner();
        numPlanetsLabel = new javax.swing.JLabel();
        planetGenButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        planetGenTextArea = new javax.swing.JTextArea();
        planetSaveButton = new javax.swing.JButton();

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
                .addContainerGap()
                .addComponent(numPlanetsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numPlanetsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(planetGenButton)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(PlanetGenPanelLayout.createSequentialGroup()
                .addComponent(planetSaveButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PlanetGenPanelLayout.setVerticalGroup(
            PlanetGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlanetGenPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(PlanetGenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPlanetsLabel)
                    .addComponent(numPlanetsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(planetGenButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planetSaveButton))
        );

        jTabbedPane1.addTab("Planet Gen", PlanetGenPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

        //output += "Generating " + numPlanets + " planets!\n";
        for (int i = 0; i < numPlanets; i++)
            {
            output += "Planet " + i + ":\n" + generatePlanet() + "\n";
            }

        planetGenTextArea.setText(output);
    }//GEN-LAST:event_planetGenButtonMouseClicked

    /*
    This function writes the generated planets to a text file.
    
    TODO: Allow user to specify filename.
     */
    private void planetSaveButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_planetSaveButtonMouseClicked
    {//GEN-HEADEREND:event_planetSaveButtonMouseClicked
        try
            {
            FileWriter outFile = new FileWriter("..\\..\\PlanetGen.txt");
            outFile.write(planetGenTextArea.getText());
            outFile.close();

            JOptionPane.showMessageDialog(null, "Planets saved to PlanetGen.txt", "Save Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        catch (IOException ex)
            {
            Logger.getLogger(TableRollerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_planetSaveButtonMouseClicked

    /*
    This function reads in the planet generation master file, which contains the
    filenames of the tables to be rolled on. For each file listed, it calls the
    processPlanetFile function.
    
    TODO: Change hardcoded filename to allow user to choose master file.
     */
    public String generatePlanet()
        {
        String output = "";

        try
            {
            //load planet file
            Scanner sc = new Scanner(new File("tables\\PlanetGenList.txt"));

            int numFiles = sc.nextInt();
            sc.nextLine();

            //output += "PlanetGenList contains " + numFiles + " files\n";
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

        generator = new Random();                
        }//end of main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PlanetGenPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel numPlanetsLabel;
    private javax.swing.JSpinner numPlanetsSpinner;
    private javax.swing.JButton planetGenButton;
    private javax.swing.JTextArea planetGenTextArea;
    private javax.swing.JButton planetSaveButton;
    // End of variables declaration//GEN-END:variables
    }//end of class
