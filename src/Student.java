public class Student {
    private String name;
    private String phone;
    private String email;
    private String postalZip;
    private String country;

    // Constructor
    public Student(String name, String phone, String email, String postalZip, String country) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.postalZip = postalZip;
        this.country = country;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public String getCountry() {
        return country;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student:" +
                "\nName: " + name +
                "\nPhone: " + phone +
                "\nEmail: " + email +
                "\nPostal Zip: " + postalZip +
                "\nCountry: " + country + "\n";
    }
}
