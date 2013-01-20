package com.simple.parcer.doublegis.ServerResponses;

import com.simple.parcer.doublegis.Models.DoubleGISRubricModel;

import java.util.List;

/**
 * Модель ответа  от сервера при запросе списка рурик
 * Осуществляет выбор рубрик, для которых указанная рубрика является родительской. Функция дополняет поисковую строку. Использование рекомендовано только для проектов, уже использующих рубрикатор, как элемент навигации. Получение фирм в рубрике осуществлется методом «Поиск фирм в рубрике».
 * <p/>
 * URL: http://catalog.api.2gis.ru/rubricator
 * Url для доступа к списку рубрик     <a href="в документации">http://api.2gis.ru/doc/firms/list/rubricator/</a>
 */
public class RubricsServerResponse extends ServerResponse {
    /**
     * Строка 	Идентификатор родительской рубрики или пустая строка, если родительской рубрики нет.
     */
    protected String parent_id;
    /**
     * Число  Общее колличество	Количество рубрик.
     */
    protected int total;
    /**
     * колличество	Количество рубрик в ответе.
     */
    protected int rubric_count;
    /**
     * колличество	Количество фирм в ответе.
     */
    protected int firm_count;

    /**
     * Список рубрик с потомками, см. Параметры рубрики.
     */
    private List<DoubleGISRubricModel> result;

    public RubricsServerResponse() {
    }

    /**
     * геттер id родиетля
     *
     * @return id родителя
     */

    public String getParent_id() {
        return parent_id;
    }

    /**
     * сеттер id родиетля
     *
     * @param parent_id id родителя
     */
    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
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

    public int getRubric_count() {
        return rubric_count;
    }

    public void setRubric_count(int rubric_count) {
        this.rubric_count = rubric_count;
    }

    public int getFirm_count() {
        return firm_count;
    }

    public void setFirm_count(int firm_count) {
        this.firm_count = firm_count;
    }


    /**
     * геттер результатов
     *
     * @return возвращает список результатов
     */

    public List<DoubleGISRubricModel> getResult() {
        return result;
    }

    /**
     * Cеттер
     *
     * @param result устанавливает результаты
     */
    public void setResult(List<DoubleGISRubricModel> result) {
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
                " firm_count " + firm_count +
                " parent_id " + parent_id +
                " rubric_count " + rubric_count +
                " total " + total
//                +                " result "+ result
                ;
    }
}
