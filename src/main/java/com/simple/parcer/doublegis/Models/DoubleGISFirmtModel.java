package com.simple.parcer.doublegis.Models;

/**
 * Модель фирм
 * <p/>
 * Url для доступа к списку проектов  подробнее  <a href="в документации">http://api.2gis.ru/doc/firms/list/project-list/</a>
 */
public class DoubleGISFirmtModel {
    /**
     * id 	Строка 	Уникальный идентификатор филиала. Пример: 141265769336625.
     */
    String id;
    /**
     * Название филиала. Пример: Сибакадемстрой Недвижимость, агентство недвижимости.
     */
    String name;

    /**
     * Долгота координаты места расположения филиала. Система координат WGS84. Отсутствует в выдаче, если у филиала нет адреса. Пример: 82.9117574728652
     */
    String lon;
    /**
     * Широта координаты места расположения филиала. Система координат WGS84. Отсутствует в выдаче, если у филиала нет адреса. Пример: 55.0346747796494
     */
    String lat;
    /**
     *
     */
    String firmscount;
    /**
     * Yникальный хэш, требуется для передачи в запрос на получение профиля филиала.
     */
    String hash;
    /**
     * Город, к которому относится филиал.
     */
    String city_name;
    /**
     * Адрес организации
     */
    String address;


    public DoubleGISFirmtModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFirmscount() {
        return firmscount;
    }

    public void setFirmscount(String firmscount) {
        this.firmscount = firmscount;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return " name: " + name
                + " id: " + id +
                " address:" + address +
                " city_name: " + city_name +
                " firmscount: " + firmscount +
                " hash: " + hash +
                " lat: " + lat +
                " long: " + lon;
    }
}
