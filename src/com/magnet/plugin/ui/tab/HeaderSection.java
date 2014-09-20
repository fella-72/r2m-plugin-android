/*
 * Copyright (c) 2014 Magnet Systems, Inc.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magnet.plugin.ui.tab;

import com.magnet.plugin.api.models.RequestHeaderModel;
import com.magnet.plugin.constants.FormConfig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HeaderSection extends ExtendedJPanel {

    private JLabel jLabel4;
    private JLabel jLabel5;
    private JSeparator jSeparator1;
    private JButton jButton1;

    public List<RequestHeaderModel> getHeaders() {
        List<RequestHeaderModel> headerList = new ArrayList<RequestHeaderModel>();
        for (HeaderPanel panel : headers) {
            headerList.add(panel.getHeader());
        }
        return headerList;
    }

    private List<HeaderPanel> headers = new ArrayList<HeaderPanel>();

    private GroupLayout.ParallelGroup customGroupHorizontal;
    private GroupLayout.SequentialGroup customGroupVertical;

    {
        jLabel4 = new JLabel();
        jSeparator1 = new JSeparator();
        jSeparator1.setOpaque(false);
        jLabel5 = new JLabel();
        jButton1 = new JButton();

        setLabelPanel(new HeaderPanelLabel());

        jLabel4.setText("Header");
        jLabel5.setText("Add new");
        jButton1.setText("+");

        jLabel4.setFont(baseFont);
        jLabel5.setFont(baseFont);
        jButton1.setFont(baseFont);

        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                addHeader(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        customGroupHorizontal = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        customGroupVertical = layout.createSequentialGroup();

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGap(FormConfig.CUSTOM_GAP)
                                        .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jSeparator1)
                                        .addComponent(jLabel5)
                                        .addComponent(jButton1))
                                .addComponent(getLabelPanel(), GroupLayout.Alignment.CENTER)
                                .addGroup(customGroupHorizontal))));

        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel4)
                                        .addComponent(jSeparator1, FormConfig.SEPARATOR_CUSTOM_SIZE, FormConfig.SEPARATOR_CUSTOM_SIZE, FormConfig.SEPARATOR_CUSTOM_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jButton1)
                        )
                        .addComponent(getLabelPanel())
                        .addGroup(customGroupVertical)
        );

    }

    private void addHeader(ActionEvent evt) {
        RequestHeaderModel header = new RequestHeaderModel();
        HeaderPanel panel = new HeaderPanel(this, header);
        headers.add(panel);
        ActionListener listener = new HeaderAction(panel);
        panel.setListener(listener);

        customGroupHorizontal.addComponent(panel);
        customGroupVertical.addComponent(panel);

        this.visibleLabelPanel();
        this.revalidate();
        this.validate();
        this.repaint();
    }

    private class HeaderAction implements ActionListener {

        private final HeaderPanel panel;

        private HeaderAction(HeaderPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            headers.remove(panel);
            deleteThisPanel();
        }

        private void deleteThisPanel() {
            panel.getParrentPanel().remove(panel);
            panel.getParrentPanel().removePanel(panel);
            panel.getParrentPanel().visibleLabelPanel();
            panel.getParrentPanel().revalidate();
            panel.getParrentPanel().validate();
            panel.getParrentPanel().repaint();
        }
    }

}