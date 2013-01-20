package com.simple.parcer.doublegis;

import com.google.gson.Gson;
import com.simple.parcer.doublegis.Models.DoubleGISFirmtModel;
import com.simple.parcer.doublegis.Models.DoubleGISProjectModel;
import com.simple.parcer.doublegis.Models.DoubleGISRubricModel;
import com.simple.parcer.doublegis.ServerResponses.ProjectServerResponse;
import com.simple.parcer.doublegis.ServerResponses.RubricsServerResponse;
import com.simple.parcer.doublegis.ServerResponses.SearchRubricsServerResponse;
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

/**
 * <OL><DT><B> Содержит точку входа в приложение  И реализует его логику. Запуск с параметрами дает следующий результат:</B>  <p> </p>
 * <DD> <LI>Без параметров. Выведет список всех проектов(городов)     </p>   <p>
 * <LI>(1 параметр, название проекта) выведет список всех рубрик в городе   </p>   <p>
 * <LI>(2 параметра названия проекта и подрубрика) произведет поиск организаций в подрубрике  </p>   <p>
 * <LI> (3 параметра названия проекта,  подрубрика и выходной файл) производит поиск и пишет результаты поиска * в  ввыходной файл в формате xls    </p> </OL>
 */
public class Main {
    /**
     * Url для доступа к списку проектов  подробнее  <a href="в документации">http://api.2gis.ru/doc/firms/list/project-list/</a>
     */
    private static final String projectList = "http://catalog.api.2gis.ru/project/list?";
    /**
     * Url для доступа к списку рубрик     <a href="в документации">http://api.2gis.ru/doc/firms/list/rubricator/</a>
     */
    private static final String rubricURL = "http://catalog.api.2gis.ru/rubricator?where=";
    /**
     * Url для Поиска фирм по рубрикам     <a href="в документации">http://api.2gis.ru/doc/firms/searches/search/</a>
     */
    private static final String searchingRubricURL = "http://catalog.api.2gis.ru/search?";
    /**
     * Ключ доступа к API и версия API
     */
    private static final String versionKey = "version=1.3&key=ruxpxz1715";


    /**
     * Метод  создает InputStream для последующего преобразования в JSON
     * Не выдает исключений. Если нет соединения, то напишет об этом в консоль и вернет null
     *
     * @param url адрес на страницу с JSON
     * @return InputStream - входной поток, пригодный для приобразования в JSON
     */

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

    /**
     * Точка входа в приложение
     *
     * @param args = null Без параметров. Выведет список всех проектов(городов)     <p>
     *             (1 параметр,название проекта) выведет список всех рубрик в городе     </p>   <p>
     *             (2 параметра названия проекта и подрубрика) произведет поиск организаций в подрубрике     </p>   <p>
     *             (3 параметра названия проекта,подрубрика и выходной файл) производит поиск и пишет результаты поиска * в  ввыходной файл в формате xls   </p>
     */
    public static void main(String[] args) {

        System.out.println("Parser started..");

        if (args == null || args.length == 0) {
            printProjects();
        } else if (args.length == 1) {
            printRubrics(args[0]);
        } else if (args.length == 2) {
            searchingRubric(args[0], args[1], true);
        } else if (args.length == 3) {
            exportXLS(args[2], args[1], searchingRubric(args[0], args[1], false));
        }
    }

    /**
     * Метод сохранения списка моделей в  XLS. По завершению работы сообщает в консоль об успехе либо выводит ошибку
     *
     * @param filepath Путь к файлу. Файл будет пересоздан
     * @param bookName Названия книги внутри файла
     * @param models   Список моделей.
     */

    private static void exportXLS(final String filepath, final String bookName, final List<DoubleGISFirmtModel> models) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(bookName);

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

    /**
     * Метод получения страницы запроса.
     *
     * @param projectName Название города
     * @param rubric      Название рубрики или ключевого слова
     * @param page        Номер страницы
     * @return возвращает модель типа   SearchRubricsServerResponse, содержащую либо ошибку, либо данные со страницы
     */

    private static SearchRubricsServerResponse searchingRubric(String projectName, String rubric, int page) {
        Reader r = new InputStreamReader(getJSONData(searchingRubricURL + "what=" + rubric + "&where=" + projectName + "&page=" + page + "&pagesize=50&sort=relevance&" + versionKey));

        System.out.println(searchingRubricURL + "what=" + rubric + "&where=" + projectName + "&page=" + page + "&pagesize=50&sort=relevance&" + versionKey);

        Gson gson = new Gson();
        return gson.fromJson(r, SearchRubricsServerResponse.class);
    }

    /**
     * Метод поиска по рубрике или ключевому слову. Метод делает задержку потока, если время между загрузками менее 1 секунды Это требуется для соблюдения правил использования демонстрационного ключа
     *
     * @param projectName Название города
     * @param rubric      Название рубрики или ключевого слова
     * @param print       параметр отвечает - печатать или нет в лог лист данных
     * @return позвращается список моделей фирм
     */

    private static List<DoubleGISFirmtModel> searchingRubric(String projectName, String rubric, boolean print) {
        try {
            List<DoubleGISFirmtModel> models = new ArrayList<DoubleGISFirmtModel>();
            SearchRubricsServerResponse serverResponse = null;
            int page = 1;
            do {
                long startTime = System.currentTimeMillis();

                serverResponse = searchingRubric(projectName, rubric, page);

                System.out.println(serverResponse);
                System.out.println("page " + page + " is get");

                if (print) {
                    for (DoubleGISFirmtModel result : serverResponse.getResult()) {
                        System.out.println(result);
                    }
                }
                models.addAll(serverResponse.getResult());
                page++;

                long endTime = System.currentTimeMillis();
                long dif = endTime - startTime;
                if (dif < 1000) {
                    try {
                        System.out.println("sleep " + (1000 - dif));
                        Thread.sleep(1000 - dif);
                    } catch (InterruptedException e) {
                    }
                }
            } while ((serverResponse.getTotal() > models.size()) || (serverResponse.getError_code() != null));

            return models;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    /**
     * Метод    получает и выводит список всех рубрик в городе
     *
     * @param projectName Название города
     */

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

    /**
     * Метод    получает и выводит список всех городов в системе
     */
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

                    System.out.println("" + serverResponse.getProjectModelResult().size());

                    for (DoubleGISProjectModel model : serverResponse.getProjectModelResult()) {

                        System.out.println(model);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}