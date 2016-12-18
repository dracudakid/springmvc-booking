package com.mgmtp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tan Dat on 16/12/2016.
 */
@Entity
@Table(name = "vacation_type")
public class VacationType {
    private int id;
    private String name;
    private String description;
    private boolean dependOnStartWorkingDate;
    private List<Request> requests;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "depend_on_start_working_date")
    public boolean isDependOnStartWorkingDate() {
        return dependOnStartWorkingDate;
    }

    public void setDependOnStartWorkingDate(boolean dependOnStartWorkingDate) {
        this.dependOnStartWorkingDate = dependOnStartWorkingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacationType that = (VacationType) o;

        if (id != that.id) return false;
        if (dependOnStartWorkingDate != that.dependOnStartWorkingDate) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dependOnStartWorkingDate ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "vacationType")
    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
