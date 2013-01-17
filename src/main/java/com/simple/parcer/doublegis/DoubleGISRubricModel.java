package com.simple.parcer.doublegis;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kolipass
 * Date: 25.11.12
 * Time: 20:48
 * Information about this garbage is coming soon
 */
public class DoubleGISRubricModel {
    String id;
    //    id 	Строка 	Идентификатор рубрики. Пример: 4503719886454906
//    name 	Строка 	Название рубрики. Пример: Аварийные службы
    String name;
    //    alias 	Строка 	Транслитерированое название рубрики. Пример: avarijjnye_sluzhby
    String alias;
    //    parent_id 	Строка 	Идентификатор родительской рубрики, для которой был получен список. Пример: 4503719886460203
    String parent_id;
    //    children 	Массив 	Список дочерних рубрик. Массив объектов с ключами id, name, alias.
    List<DoubleGISRubricModel> children;

    public DoubleGISRubricModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public List<DoubleGISRubricModel> getChildren() {
        return children;
    }

    public void setChildren(List<DoubleGISRubricModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return " name: " + name
                + " id: " + id +
                " alias: " + alias +
                " parent_id: " + parent_id
                + " children: " + children                 ;
    }
}
