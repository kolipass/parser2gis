package com.simple.parcer.doublegis.ServerResponses;

import com.simple.parcer.doublegis.Models.DoubleGISProjectModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель ответа от сервера при запросе списка проектов
 * Проект — это агломерация, включающая крупный город и ближайшие населённые пункты. Теперь можно реализовать выбор города, как это сделано в Онлайн-версии 2ГИС, являющейся партнёром API.
 * <p/>
 * URL: http://catalog.api.2gis.ru/project/list
 * * Url для доступа к списку проектов  подробнее  <a href="в документации">http://api.2gis.ru/doc/firms/list/project-list/</a>
 */
public class ProjectServerResponse extends ServerResponse {
    /**
     * Список моделей
     */
    private List<DoubleGISProjectModel> result;

    /**
     * Конструктор пустой, так требует json фабрика
     */
    public ProjectServerResponse() {
    }

    /**
     * геттер результатов
     *
     * @return возвращает список результатов
     */
    public List<DoubleGISProjectModel> getProjectModelResult() {
        return result;
    }

    /**
     * Cеттер
     *
     * @param result устанавливает результаты
     */
    public void setResult(ArrayList<DoubleGISProjectModel> result) {
        this.result = result;
    }

}
