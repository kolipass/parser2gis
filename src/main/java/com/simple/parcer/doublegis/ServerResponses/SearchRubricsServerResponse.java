package com.simple.parcer.doublegis.ServerResponses;

import com.simple.parcer.doublegis.Models.DoubleGISFirmtModel;

import java.util.List;

/**
 * * Модель ответа  от сервера при запросе списка фирм через поиск по рубрике
 * Осуществляет поиск фирм по заданному запросу и выдает список найденных результатов разбитых на страницы.
 * <p/>
 * URL: http://catalog.api.2gis.ru/search
 * Url для Поиска фирм по рубрикам     <a href="в документации">http://api.2gis.ru/doc/firms/searches/search/</a>
 */
public class SearchRubricsServerResponse extends ServerResponse {
    /**
     * Общее колличество рубрик
     */
    protected Integer total;

    /**
     * Список рубрик с потомками, см. Параметры рубрики.
     */
    protected List<DoubleGISFirmtModel> result;

    public SearchRubricsServerResponse() {
    }

    /**
     * геттер общего колличества фирм по запросу
     *
     * @return возвращает колличество фирм
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Cеттер
     *
     * @param total устанавливает общее колличество фирм
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * геттер результатов
     *
     * @return возвращает список результатов
     */
    public List<DoubleGISFirmtModel> getResult() {
        return result;
    }

    /**
     * Cеттер
     *
     * @param result устанавливает результаты
     */
    public void setResult(List<DoubleGISFirmtModel> result) {
        this.result = result;
    }

    /**
     * Преобразует поля в строку
     *
     * @return возвращает строку с данными полей
     */
    public String toString() {
        return "api_version " + api_version +
                " response_code " + response_code +
                " error_code " + error_code +
                " error_message " + error_message +
                " response_code " + response_code +
                " total " + total
//                +                " result "+ result
                ;
    }
}
