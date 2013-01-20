package com.simple.parcer.doublegis.Models;

/**
 * Модель проетков
 * Проект — это агломерация, включающая крупный город и ближайшие населённые пункты. Теперь можно реализовать выбор города, как это сделано в Онлайн-версии 2ГИС, являющейся партнёром API.
 * <p/>
 * URL: http://catalog.api.2gis.ru/project/list
 *  Url для доступа к списку проектов  подробнее  <a href="в документации">http://api.2gis.ru/doc/firms/list/project-list/</a>
 */
public class DoubleGISProjectModel {
    /**
     * Идентификатор проекта. Пример: 32
     */
    int id;

    /**
     * Название проекта. Пример: Москва
     */
    String name;
    /**
     * Буквенный идентификатор проекта. Пример: n_novgorod
     */
    String code;
    /**
     * Язык проекта. Возможные значения: ru
     */
    String language;
    /**
     * * Число 	Минимальный уровень масштаба, для которого есть тайлы проекта. Пример: 9.
     */
    String min_zoomlevel;
    /**
     * Число 	Максимальный уровень масштаба, для которого есть тайлы проекта. Пример: 17.
     */
    String max_zoomlevel;

    /**
     * <p/>
     * Часовой пояс в формате Time Zone Database.
     * <p/>
     * Примеры:
     * <p/>
     * Asia/Novosibirsk
     * Europe/Moscow
     * Indian/Chagos
     */
    String timezone;
    /**
     * Исторический центр главного города, рекомендуется для центрирования проекта. Точка в формате WKT. Пример: POINT(83.062249469999145 54.956108471916146).
     */
    String centroid;
    /**
     * Наличие данных по общественному транспорту: true — данные есть, false — данных нет.
     */
    String transport;
    /**
     * Наличие данных по пробкам: true — данные есть, false — данных нет.
     */
    String traffic;
    /**
     * Присутствие проекта на flamp.ru: true — присутствует, false — не присутствует.
     */
    String flamp;

    /**
     * Уровень масштаба, рекомендуемый для дефолтного отображения всего проекта. Пример: 11.
     */
    String zoomlevel;
    /**
     * Количество фирм в проекте. Пример: 42839.
     */
    String firmscount;
    /**
     * Количество филиалов в проекте. Пример: 60975.
     */
    String filialscount;
    /**
     * Количество рубрик в проекте. Пример: 953.
     */

    String rubricscount;
    /**
     * Количество геообъектов в проекте. Пример: 143452.
     */
    String geoscount;
    /**
     * Количество геообъектов в проекте. Пример: 143452.
     */
    String country_code;


    public DoubleGISProjectModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getMin_zoomlevel() {
        return min_zoomlevel;
    }

    public void setMin_zoomlevel(String min_zoomlevel) {
        this.min_zoomlevel = min_zoomlevel;
    }

    public String getMax_zoomlevel() {
        return max_zoomlevel;
    }

    public void setMax_zoomlevel(String max_zoomlevel) {
        this.max_zoomlevel = max_zoomlevel;
    }

    public String getCentroid() {
        return centroid;
    }

    public void setCentroid(String centroid) {
        this.centroid = centroid;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getFlamp() {
        return flamp;
    }

    public void setFlamp(String flamp) {
        this.flamp = flamp;
    }

    public String getZoomlevel() {
        return zoomlevel;
    }

    public void setZoomlevel(String zoomlevel) {
        this.zoomlevel = zoomlevel;
    }

    public String getFirmscount() {
        return firmscount;
    }

    public void setFirmscount(String firmscount) {
        this.firmscount = firmscount;
    }

    public String getFilialscount() {
        return filialscount;
    }

    public void setFilialscount(String filialscount) {
        this.filialscount = filialscount;
    }

    public String getRubricscount() {
        return rubricscount;
    }

    public void setRubricscount(String rubricscount) {
        this.rubricscount = rubricscount;
    }

    public String getGeoscount() {
        return geoscount;
    }

    public void setGeoscount(String geoscount) {
        this.geoscount = geoscount;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    @Override
    public String toString() {
        return
                " name: " + name
                        + " id: " + id +
                        " code:" + code +
                        " language " + language +
                        " timezone " + timezone +
                        " min_zoomlevel " + min_zoomlevel +
                        " max_zoomlevel " + max_zoomlevel +
                        " centroid " + centroid +
                        " transport " + transport +
                        " traffic " + traffic +
                        " flamp " + flamp +
                        " zoomlevel " + zoomlevel +
                        " firmscount " + firmscount +
                        " filialscount " + filialscount +
                        " rubricscount " + rubricscount +
                        " geoscount " + geoscount +
                        " country_code " + country_code
                ;
    }
}
