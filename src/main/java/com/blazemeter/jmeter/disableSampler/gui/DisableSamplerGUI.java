package com.blazemeter.jmeter.disableSampler.gui;

import com.blazemeter.jmeter.disableSampler.DisableSampler;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.*;
import java.awt.*;

/**
     ZubovaDP - 2024
     */

    public class DisableSamplerGUI extends AbstractSamplerGui {
        private JTextField ObjectNameForDisable = null;
        private ButtonGroup OperationType = new ButtonGroup();
        public DisableSamplerGUI(){
            init();
        }

        @Override
        public void configure(TestElement element) {
            super.configure(element);
            ObjectNameForDisable.setText(element.getPropertyAsString(DisableSampler.pObjectNameForDisable));
        }

        private void init() {
            JPanel mainPanel = new JPanel(new GridBagLayout());
            ObjectNameForDisable = new JTextField(100);
            JLabel lObjectNameForDisable = new JLabel("Object name: ");

            JLabel lSamplerName = new JLabel("<html><strong><h1>Visibility Control Sampler</h1></strong></html>");

            JLabel lProjectOwner = new JLabel("Zubova - Greenatom");
            JLabel lEmptyLabel = new JLabel(" ");
            lProjectOwner.setForeground(Color.gray);
            lProjectOwner.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
            JLabel lProjectDescription = new JLabel("\n\nThis plugin allows you to manage visibility of test plan elements such as HTTPSampler, test Action and DebugSampler");
            lProjectDescription.setForeground(Color.darkGray);
            lProjectDescription.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);

            JRadioButton EnableAllButton = new JRadioButton("Enable all objects", false);
            EnableAllButton.setActionCommand("Enable all objects");
            OperationType.add(EnableAllButton);
            JRadioButton DisableAllButton = new JRadioButton("Disable all objects", true);
            DisableAllButton.setActionCommand("Disable all objects");
            OperationType.add(DisableAllButton);
            JRadioButton ToggleOfAvailabilityButton = new JRadioButton("Toggle of availability", true);
            ToggleOfAvailabilityButton.setActionCommand("Toggle of availability");
            OperationType.add(ToggleOfAvailabilityButton);


            GroupLayout layout = new GroupLayout(mainPanel);
            mainPanel.setLayout(layout);

            layout.setHorizontalGroup(
                    layout.createParallelGroup(Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(lSamplerName))
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(lObjectNameForDisable)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(ObjectNameForDisable))
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(EnableAllButton)
                                    .addComponent(DisableAllButton)
                                    .addComponent(ToggleOfAvailabilityButton))
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(lEmptyLabel))
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(lEmptyLabel))
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(lProjectDescription))
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(lProjectOwner)));
            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                    .addComponent(lSamplerName))
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                    .addComponent(lObjectNameForDisable, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ObjectNameForDisable, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
                                            GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup()
                                    .addComponent(EnableAllButton)
                                    .addComponent(DisableAllButton)
                                    .addComponent(ToggleOfAvailabilityButton))
                            .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(lEmptyLabel))
                            .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(lEmptyLabel))
                            .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(lProjectDescription))
                            .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(lProjectOwner)));

            //toggleOfAvailability.add(ltoggleOfAvailability);
            //mainPanel.add(ltoggleOfAvailability);
           // enableAll.add(lenableAll);
            //mainPanel.add(lenableAll);
           // objectName.add(lobjectName);
            //mainPanel.add(lobjectName);
            add(mainPanel);
        }

        @Override
        public TestElement createTestElement() {
            TestElement sampler = new DisableSampler();
            modifyTestElement(sampler);
            return sampler;
        }

        @Override
        public String getLabelResource() {
            return this.getClass().getSimpleName();
        }

        @Override
        public void modifyTestElement(TestElement sampler) {
            super.configureTestElement(sampler);
            if(sampler instanceof DisableSampler){
                DisableSampler testSampler = (DisableSampler) sampler;
                testSampler.setProperty(DisableSampler.pObjectNameForDisable,ObjectNameForDisable.getText());
                testSampler.setProperty(DisableSampler.pOperationType,OperationType.getSelection().getActionCommand().toString());
            }
        }

        @Override
        public String getStaticLabel() {
            return "Visibility Control Sampler (GA)";
        }

        private void initFields(){
            ObjectNameForDisable.setText("");
        }

        @Override
        public void clearGui() {
            super.clearGui();
            initFields();
        }
    }