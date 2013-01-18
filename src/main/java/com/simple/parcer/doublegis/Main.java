package com.simple.parcer.doublegis;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Internet is off");
            return null;
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
        } else if (args.length == 3) {
            exportXML(args[2], searchingRubric(args[0], args[1]));
        }


    }

    private static void exportXML(String filepath, List<DoubleGISFirmtModel> models) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Firms");

        int rownum = 0;
        for (DoubleGISFirmtModel model : models) {
            Row row = sheet.createRow(rownum++);
            int i = 0;
            Cell id = row.createCell(i++);
            id.setCellValue(model.getId());
            Cell name = row.createCell(i++);
            name.setCellValue(model.getName());
            Cell lat = row.createCell(i++);
            lat.setCellValue(model.getLat());
            Cell lon = row.createCell(i++);
            lon.setCellValue(model.getLon());
            Cell adr = row.createCell(i++);
            adr.setCellValue(model.getAddress());
            Cell city = row.createCell(i++);
            city.setCellValue(model.getCity_name());
            Cell firmc = row.createCell(i++);
            firmc.setCellValue(model.getFirmscount());
        }


        try {
            FileOutputStream out =
                    new FileOutputStream(new File(filepath));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static SearchRubricsServerResponse searchingRubric(String projectName, String rubric, int page) {
        Reader r = new InputStreamReader(getJSONData(searchingRubricURL + "what=" + rubric + "&where=" + projectName + "&page=" + page + "&pagesize=50&sort=relevance&" + versionKey));

//        System.out.println(searchingRubricURL + "what=" + rubric + "&where=" + projectName + "&page=" + page + "&pagesize=30&sort=relevance&" + versionKey);

        Gson gson = new Gson();
        return gson.fromJson(r, SearchRubricsServerResponse.class);
    }

    private static List<DoubleGISFirmtModel> searchingRubric(String projectName, String rubric) {
        try {
            List<DoubleGISFirmtModel> models = new ArrayList<DoubleGISFirmtModel>();
            SearchRubricsServerResponse serverResponse = null;
            int page = 1;
            do {
                System.out.println("page " + page);
                serverResponse = searchingRubric(projectName, rubric, page);
                models.addAll(serverResponse.getResult());
                page++;
            } while ((serverResponse.getTotal() > models.size()) || (serverResponse.error_code != null));


            return models;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    private static void printRubrics(String projectName) {
        try {
            InputStream inputStream = getJSONData(rubricURL + projectName + "&" + versionKey);
            if (inputStream != null) {
                Reader r = new InputStreamReader(inputStream);

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
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printProjects() {
        try {
            Gson gson = new Gson();
            InputStream inputStream = getJSONData(projectList + versionKey);
            if (inputStream != null) {
                Reader r = new InputStreamReader(inputStream);
                System.out.println(projectList + versionKey);
                System.out.println(r.toString());

                ProjectServerResponse serverResponse = gson.fromJson(r, ProjectServerResponse.class);

                System.out.println(serverResponse);

                if (serverResponse.getError_code() == null) {

                    System.out.println("" + serverResponse.getResult().size());

                    for (DoubleGISProjectModel model : serverResponse.getResult()) {

                        System.out.println(model);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}