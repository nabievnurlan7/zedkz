package info.qazaq.qazaqinfo.domain.model;

import info.qazaq.qazaqinfo.data.entity.Employment;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class DomainModel
{
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;
    private String photo;
    private Employment employment;

    public DomainModel() {
    }

    public DomainModel(int id,
                     String first_name,
                     String last_name,
                     String email,
                     String photo,
                     String gender,
                       String ip_address)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.photo = photo;
        this.gender = gender;
        this.ip_address = ip_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }
}