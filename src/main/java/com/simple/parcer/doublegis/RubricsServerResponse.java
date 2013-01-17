package com.simple.parcer.doublegis;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kolipass
 * Date: 25.11.12
 * Time: 17:54
 * Information about this garbage is coming soon
 */
public class RubricsServerResponse {
    //    api_version 	Строка 	Версия API, с которой идет работа. Возможные значения: 1.3
    String api_version;
    /**
     * response_code:
     * 200 	Успешный запрос.
     * 400 	Ошибка в запросе.
     * 403 	Доступ запрещен.
     * 404 	По запросу ничего не найдено.
     * 500 	Внутренняя ошибка сервера.
     * 503 	Сервис временно не доступен.
     */
    String response_code;
    /**
     * api_version 	Строка 	Версия API, с которой идет работа. Возможные значения: 1.3
     * response_code 	Строка 	Код ответа API. Подробнее см. Коды ответов.
     * В случае успешного ответа
     * parent_id 	Строка 	Идентификатор родительской рубрики или пустая строка, если родительской рубрики нет.
     * total 	Число 	Количество рубрик в ответе.
     * <p/>
     * В случае ошибки
     * error_code 	Строка 	Код ошибки, см. Коды ошибок.
     * error_message 	Строка
     * <p/>
     * <p/>
     * /**
     * error_code:
     * methodNotFound 	Запрошенный метод API не существует.
     * withoutResult 	Результаты по запросу не найдены.
     * incorrectGeography 	Некорректно задано значение поля «Где?» или других полей, отвечающих за географию.
     * forbidden 	Доступ к API запрещен для ключа, указанного в запросе.
     * unauthorized 	Ключ, указанный в запросе, не существует.
     * unsupportedVersion 	Указанная версия API не поддерживается.
     * versionIsRequired 	Не задана версия API.
     * unsupportedOutput 	Указанное значение output не поддерживается.
     * incorrectCallback 	Некорректно задан параметр callback
     * whatIsEmpty 	Не заполнено поле «Что?»
     * whatTooShort 	В поле «Что?» слишком мало символов.
     * whatTooLarge 	В поле «Что?» слишком много символов.
     * wherePointIsEmpty 	Не указана точка (при поиске по точке).
     * whereIsEmpty 	Не заполнено поле «Где?»
     * whereTooShort 	В поле «Где?» слишком мало символов.
     * whereTooLarge 	В поле «Где?» слишком много символов.
     * conflictingParams 	В запросе присутствуют взаимоисключаемые параметры.
     * incorrectLimit 	Некорректно задан параметр limit.
     * incorrectRadius 	Некорректно задан параметр radius.
     * incorrectPoint 	Некорректно задан параметр point.
     * incorrectOrder 	Некорректно задан параметр order.
     * incorrectRubricOrder 	Некорректно задан параметр sort.
     * incorrectPage 	екорректно задан параметр page.
     * incorrectPageSize 	Некорректно задан параметр pagesize.
     * incorrectProject 	Некорректно задан проект.
     * incorrectEncoding 	Запрос передан в неправильной кодировке.
     * firmRequired 	Не задан идентификатор фирмы.
     * firmIdInvalid 	Некорректно задан идентификатор фирмы.
     * geometryRequired 	Не задан идентификатор геометрии.
     * geometryIdInvalid 	Некорректно задаан идентификатор геометрии.
     * rubricIdInvalid 	Некорректно задан идентификатор рубрики.
     * hashRequired 	Не задан обязательный параметр hash.
     * hashInvalid 	Некорректно задан параметр hash.
     * serviceUnavailable 	Сервис временно недоступен.
     * worktimeInvalid 	Неправильно задан фильтр worktime.
     * idsRequired 	В запросе отсутствует список идентификаторов.
     * incorrectFormat 	Некорректно задан параметр format.
     * tooManyIds 	В запросе передано слишком много идентификаторов.
     */

    String error_code;
    String error_message;
    //   Строка 	Идентификатор родительской рубрики или пустая строка, если родительской рубрики нет.
    String parent_id;
    //    //       Число 	Количество рубрик в ответе.
    int total;
    int rubric_count;

    int firm_count;

    // result 	Массив 	Список рубрик с потомками, см. Параметры рубрики.
    List<DoubleGISRubricModel> result;

    public RubricsServerResponse() {
    }

    public void setResult(List<DoubleGISRubricModel> result) {
        this.result = result;
    }

    public List<DoubleGISRubricModel> getResult() {
        return result;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
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
