package com.simple.parcer.doublegis;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;

public class Main {
    private static String projectList = "http://catalog.api.2gis.ru/project/list?";
    private static String rubricURL = "http://catalog.api.2gis.ru/rubricator?where=";
    private static String searchingRubricURL = "http://catalog.api.2gis.ru/searchinrubric?";
    private static String versionKey = "version=1.3&key=ruxpxz1715";


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


    public static void main(String[] args) {
        System.out.println("Parser started..");
        if (args == null || args.length == 0) {
            printProjects();
        } else if (args.length == 1) {
            printRubrics(args[0]);
        } else if (args.length == 2) {
            searchingRubric(args[0], args[1]);
        }


    }

    private static void searchingRubric(String projectName, String rubric) {
        try {
            Reader r = new InputStreamReader(getJSONData(searchingRubricURL +  "what=" + rubric + "&where="+projectName+ "&page=1&pagesize=50&sort=relevance&" + versionKey));

            System.out.println(searchingRubricURL +  "what=" + rubric + "&where="+projectName+ "&page=1&pagesize=30&sort=relevance&" + versionKey);

            System.out.println(r.toString());

            Gson gson = new Gson();
            SearchRubricsServerResponse serverResponse = gson.fromJson(r, SearchRubricsServerResponse.class);

            System.out.println(serverResponse);

            if (serverResponse.getError_code() == null) {

                System.out.println("" + serverResponse.getResult().size());

                for (DoubleGISFirmtModel model : serverResponse.getResult()) {

                    System.out.println(model);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printRubrics(String projectName) {
        try {
            Reader r = new InputStreamReader(getJSONData(rubricURL + projectName + "&" + versionKey));

            System.out.println(rubricURL + projectName + "&" + versionKey);

            System.out.println(r.toString());

            Gson gson = new Gson();
            RubricsServerResponse serverResponse = gson.fromJson(r, RubricsServerResponse.class);

            System.out.println(serverResponse);

            if (serverResponse.getError_code() == null) {

                System.out.println("" + serverResponse.getResult().size());

                for (DoubleGISRubricModel model : serverResponse.getResult()) {

                    System.out.println(model);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printProjects() {
        try {
            Gson gson = new Gson();

            Reader r = new InputStreamReader(getJSONData(projectList + versionKey));

            System.out.println(r.toString());

            ProjectServerResponse serverResponse = gson.fromJson(r, ProjectServerResponse.class);

            System.out.println(serverResponse);

            if (serverResponse.getError_code() == null) {

                System.out.println("" + serverResponse.getResult().size());

                for (DoubleGISProjectModel model : serverResponse.getResult()) {

                    System.out.println(model);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}