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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magnet.plugin.r2m.ui.tab;

import com.magnet.plugin.r2m.constants.FormConfig;

import javax.swing.*;

public class HeaderPanelLabel extends BasePanel {

    private JLabel key;
    private JLabel value;

    {
        key = new JLabel();
        value = new JLabel();

        key.setText("Key");
        value.setText("Value");

        key.setFont(baseFont);
        value.setFont(baseFont);

        GroupLayout jPanel2Layout = new GroupLayout(this);
        this.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createSequentialGroup()
                .addComponent(key, GroupLayout.DEFAULT_SIZE, FormConfig.CUSTOM_PREF_SIZE, Short.MAX_VALUE)
                .addComponent(value, GroupLayout.DEFAULT_SIZE, FormConfig.CUSTOM_PREF_SIZE, Short.MAX_VALUE)
        .addGap(30));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(key)
                .addComponent(value));
    }
}
