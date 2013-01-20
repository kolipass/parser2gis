package com.simple.parcer.doublegis.ServerResponses;

/**
 * Общий случай ответа от сервера. От данного объекта наследуются все остальные ответы
 */
public class ServerResponse {
    /**
     * Версия API, с которой идет работа. Возможные значения: 1.3.
     */
    protected String api_version;
    /**
     * Код ответа API.
     * 200 	Успешный запрос.</p>
     * 400 	Ошибка в запросе.</p>
     * 403 	Доступ запрещен.</p>
     * 404 	По запросу ничего не найдено.</p>
     * 500 	Внутренняя ошибка сервера.</p>
     * 503 	Сервис временно не доступен.</p>
     */
    protected String response_code;

    /**
     * Описание ошибки.
     * <p/>
     * Пример: API version must be set. Supported versions are: 1.3
     */

    protected String error_message;

    /**
     * Код ошибки, см. Коды ошибок.
     * methodNotFound 	Запрошенный метод API не существует.</p>
     * withoutResult 	Результаты по запросу не найдены.</p>
     * incorrectGeography 	Некорректно задано значение поля «Где?» или других полей, отвечающих за географию.</p>
     * forbidden 	Доступ к API запрещен для ключа, указанного в запросе.</p>
     * unauthorized 	Ключ, указанный в запросе, не существует.</p>
     * unsupportedVersion 	Указанная версия API не поддерживается.</p>
     * versionIsRequired 	Не задана версия API.</p>
     * unsupportedOutput 	Указанное значение output не поддерживается.</p>
     * incorrectCallback 	Некорректно задан параметр callback
     * whatIsEmpty 	Не заполнено поле «Что?»
     * whatTooShort 	В поле «Что?» слишком мало символов.</p>
     * whatTooLarge 	В поле «Что?» слишком много символов.</p>
     * wherePointIsEmpty 	Не указана точка (при поиске по точке).</p>
     * whereIsEmpty 	Не заполнено поле «Где?»
     * whereTooShort 	В поле «Где?» слишком мало символов.</p>
     * whereTooLarge 	В поле «Где?» слишком много символов.</p>
     * conflictingParams 	В запросе присутствуют взаимоисключаемые параметры.</p>
     * incorrectLimit 	Некорректно задан параметр limit.</p>
     * incorrectRadius 	Некорректно задан параметр radius.</p>
     * incorrectPoint 	Некорректно задан параметр point.</p>
     * incorrectOrder 	Некорректно задан параметр order.</p>
     * incorrectRubricOrder 	Некорректно задан параметр sort.</p>
     * incorrectPage 	екорректно задан параметр page.</p>
     * incorrectPageSize 	Некорректно задан параметр pagesize.</p>
     * incorrectProject 	Некорректно задан проект.</p>
     * incorrectEncoding 	Запрос передан в неправильной кодировке.</p>
     * firmRequired 	Не задан идентификатор фирмы.</p>
     * firmIdInvalid 	Некорректно задан идентификатор фирмы.</p>
     * geometryRequired 	Не задан идентификатор геометрии.</p>
     * geometryIdInvalid 	Некорректно задаан идентификатор геометрии.</p>
     * rubricIdInvalid 	Некорректно задан идентификатор рубрики.</p>
     * hashRequired 	Не задан обязательный параметр hash.</p>
     * hashInvalid 	Некорректно задан параметр hash.</p>
     * serviceUnavailable 	Сервис временно недоступен.</p>
     * worktimeInvalid 	Неправильно задан фильтр worktime.</p>
     * idsRequired 	В запросе отсутствует список идентификаторов.</p>
     * incorrectFormat 	Некорректно задан параметр format.</p>
     * tooManyIds 	В запросе передано слишком много идентификаторов.</p>
     */

    protected String error_code;
    /**
     * Конструктор пустой, так требует json фабрика
     */

    /**
     * геттер результатов
     *
     * @return возвращает список результатов
     */


    /**
     * Cеттер
     *
     * @param result устанавливает результаты
     */


    /**
     * геттер версии API
     *
     * @return возвращает v API
     */
    public String getApi_version() {
        return api_version;
    }

    /**
     * Сетер версии
     *
     * @param api_version
     */

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    /**
     * геттер кода ответа
     *
     * @return возвращает код ответа
     */
    public String getResponse_code() {
        return response_code;
    }

    /**
     * утанавливает код ответа
     *
     * @param response_code код ответа
     */
    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    /**
     * геттер сообщения ошибки
     *
     * @return возвращает сообщение ошибки
     */
    public String getError_message() {
        return error_message;
    }

    /**
     * СЕттер сообщения об ошибке
     *
     * @param error_message сообщение ошибки
     */
    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    /**
     * геттер кода ошибки
     *
     * @return возвращает код ошибки
     */
    public String getError_code() {
        return error_code;
    }

    /**
     * СЕттер кода об ошибке
     *
     * @param error_code код ошибки
     */
    public void setError_code(String error_code) {
        this.error_code = error_code;
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
                " error_message " + error_message;
    }
}