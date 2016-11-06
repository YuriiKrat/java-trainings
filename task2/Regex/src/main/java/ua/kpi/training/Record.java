package ua.kpi.training;

import java.util.*;

/**
 * This class represents single record in notebook
 *
 * @author Yurii Krat
 * @version 1.0, 06.11.2016
 */
public class Record {

    /**
     * The last name of person
     */
    private String lastName;

    /**
     * The first name of person
     */
    private String firstName;

    /**
     * The name of person which consists of last name and first letter of first name with dot
     */
    private String name;

    /**
     * The patronymic of person
     */
    private String patronymic;

    /**
     * The nickname of person
     */
    private String nickname;

    /**
     * The comment applied to person
     */
    private String comment;


    /**
     * Set of person's groups
     */
    private Set<Group> groups;

    /**
     * The home phone of person
     */
    private String homePhone;

    /**
     * The mobile phone of person
     */
    private String mobilePhone;

    /**
     * Additional mobile phone of person
     */
    private String mobilePhone2;

    /**
     * The email address of person
     */
    private String email;

    /**
     * The skype address of person
     */
    private String skype;

    /**
     * The address of person
     */
    private Address address;

    /**
     * The address of person which consists of index, city, street,
     * house number and flat number
     */
    private String fullAddress;

    /**
     * The date of creation the record
     */
    private Date createDate;

    /**
     * The last date record was modified
     */
    private Date lastModifiedDate;

    public Record() {
        createDate = new Date();
        lastModifiedDate = new Date();
    }

    /**
     *
     * @param str string been validated
     * @param regex applied regular expression
     * @return true if string has correct format, otherwise false
     */
    public boolean validate(String str, String regex) {
        if (str.matches(regex)) {
            return true;
        }
        return false;
    }

    public String getMobilePhone2() {
        return mobilePhone2;
    }

    public void setMobilePhone2(String mobilePhone2) {
        this.mobilePhone2 = mobilePhone2;
    }

    /**
     * Sets person's groups
     * @param groups string with group names
     */
    public void setGroups(String groups) {
        this.groups = new HashSet<>();
        String[] groupsArr = splitGroups(groups);
        for (String group: groupsArr) {
            if(group.equals("friends")) {
                this.groups.add(Group.FRIENDS);
            } else if(group.equals("relatives")) {
                this.groups.add(Group.RELATIVES);
            } else {
                this.groups.add(Group.COLLEAGUES);
            }
        }

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = lastName + " " + firstName.charAt(0) + ".";
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress() {
        this.fullAddress = address.getIndex() + " " + address.getCity() +
                ", " + address.getStreet() + " street, " + address.getHouseNumber() +
                "/" + address.getFlatNumber();
    }

    /**
     * Splits string with groups to array
     * @param groups person's groups
     * @return array of groups
     */
    private String[] splitGroups(String groups) {
        return groups.split("\\s");
    }

    @Override
    public String toString() {
        return "Record{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", groups=" + groups +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", mobilePhone2='" + mobilePhone2 + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", fullAddress='" + fullAddress + '\'' +
                ", createDate=" + createDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
