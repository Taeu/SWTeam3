/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class ComplainDetail {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty industry;
    private final StringProperty sub;
    private final StringProperty time;
    private final StringProperty content;
    private final StringProperty title;

    public ComplainDetail(String id, String industry, String name, String sub, String time, String title, String content) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.industry = new SimpleStringProperty(industry);
        this.sub = new SimpleStringProperty(sub);
        this.time = new SimpleStringProperty(time);
        this.content = new SimpleStringProperty(content);
        this.title = new SimpleStringProperty(title);
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getIndustry() {
        return industry.get();
    }

    public String getSub() {
        return sub.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getContent() {
        return content.get();
    }

    public String getTitle() {
        return title.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setIndustry(String industry) {
        this.industry.set(industry);
    }

    public void setSub(String sub) {
        this.sub.set(sub);
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty industryProperty() {
        return industry;
    }

    public StringProperty subProperty() {
        return sub;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public StringProperty contentProperty() {
        return content;
    }

    public StringProperty titleProperty() {
        return title;
    }
}
