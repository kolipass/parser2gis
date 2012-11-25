/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * This example, like all Swing examples, exists in a package:
 * in this case, the "start" package.
 * If you are using an IDE, such as NetBeans, this should work
 * seamlessly.  If you are compiling and running the examples
 * from the command-line, this may be confusing if you aren't
 * used to using named packages.  In most cases,
 * the quick and dirty solution is to delete or comment out
 * the "package" line from all the source files and the code
 * should work as expected.  For an explanation of how to
 * use the Swing examples as-is from the command line, see
 * http://docs.oracle.com/javase/javatutorials/tutorial/uiswing/start/compile.html#package
 */

/*
 * HelloWorldSwing.java requires no other files.
 */

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;

public class HelloWorldSwing {
    public static InputStream getJSONData(String url) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        URI uri;
        InputStream data = null;
        try {
            uri = new URI(url);
            HttpGet method = new HttpGet(uri);
            org.apache.http.HttpResponse response = httpClient.execute(method);
            data = response.getEntity().getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {
                "api_version",
                "response_code modified",
                "error_message",
                "error_code"
        };

        try{
            System.out.println("Json Parser started..");
            Gson gson = new Gson();
            Reader r = new InputStreamReader(getJSONData("http://catalog.api.2gis.ru/project/list?version=1.3&key=ruxpxz1715"));
            System.out.println(r.toString());
            ServerResponse serverResponse = gson.fromJson(r, ServerResponse.class);
            System.out.println(serverResponse);
            System.out.println( ""+serverResponse.getResult().size());
            for(DoubleGISProjectModel model : serverResponse.getResult()){
                System.out.println(model);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

//        String json = "{\"api_version\":\"1.3\",\"response_code\":\"403\",\"error_message\":\"Authorization error (invalid key)\",\"error_code\":\"forbidden\"}";
//        Gson gson = new Gson();
//        ServerResponse objSample = gson.fromJson(json, ServerResponse.class);

//    String[][] data = {
//            {"addins", "02.11.2006 19:15", "Folder", ""},
//            {"AppPatch", "03.10.2006 14:10", "Folder", ""},
//            {"assembly", "02.11.2006 14:20", "Folder", ""},
//            {"Boot", "13.10.2007 10:46", "Folder", ""},
//            {"Branding", "13.10.2007 12:10", "Folder", ""},
//            {"Cursors", "23.09.2006 16:34", "Folder", ""},
//            {"Debug", "07.12.2006 17:45", "Folder", ""},
//            {"Fonts", "03.10.2006 14:08", "Folder", ""},
//            {"Help", "08.11.2006 18:23", "Folder", ""},
//            {"explorer.exe", "18.10.2006 14:13", "File", "2,93MB"},
//            {"helppane.exe", "22.08.2006 11:39", "File", "4,58MB"},
//            {"twunk.exe", "19.08.2007 10:37", "File", "1,08MB"},
//            {"nsreg.exe", "07.08.2007 11:14", "File", "2,10MB"},
//            {"avisp.exe", "17.12.2007 16:58", "File", "12,67MB"},
//    };

        JTable table = new JTable();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}