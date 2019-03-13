package ser321.assign3.xhuan127.server;

import ser321.assign2.lindquis.client.*;

import java.rmi.server.*;
import java.rmi.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Set;

/*
 * Copyright 2019 Xiaolou Huang,
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: demonstrate use of MessageGui class for students to use as a
 * basis for solving Ser321 Spring 2019 Homework Problems.
 * The class SampleClient can be used by students in constructing their 
 * controller for solving homework problems. The view class is MessageGui.
 *
 * This problem set uses a swing user interface to implement (secure) messaging.
 * Messages are communicated to/from message clients, via a common well-known.
 * server.
 * Messages can be sent in clear text, or using password based encryption 
 * (last assignment). For secure messages, the message receiver must enter
 * the password (encrypted).
 * The Message tab has two panes. left pane contains a JList of messages
 * for the user. The right pane is a JTextArea, which can display the
 * contents of a selected message. This pane is also used to compose
 * messages that are to be sent.
 *
 * Ser321 Principles of Distributed Software System
 * @author Xiaolou Huang, xhuan127@asu.edu, Software Engineering.
 * @version February 2019
 */
public class Server {
    
    public Server() {
        
    }
    
    public static void main(String args[]) {
        try{
            String hostId = "localhost";
            String regPort = "2222";
            if (args.length >= 2) {
                hostId = args[0];
                regPort = args[1];
            }
            
            // register server to RMI registry
            Server_MessageLibraryInterface server = new Server_MessageLibrary("Messages.json");
            Naming.rebind("rmi://" + hostId + ":" + regPort + "/Server", server);
            System.out.println("Server bound in registry as: " + "rmi://" + hostId + ":" + regPort + "/Server");
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
    
