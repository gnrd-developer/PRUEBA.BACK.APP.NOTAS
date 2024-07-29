public class Profile {
    private int id;
    private int usuario_id;
    private String mail;
    private String name; 
    private int country_id; 
    private String region; 
    private String commune; 
    private int phone_prefix_id; 
    private int phone; 
    private String photo;
    public Profile() {
    }
    public Profile(int id, int usuario_id, String mail, String name, int country_id, String region, String commune,
            int phone_prefix_id, int phone, String photo) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.mail = mail;
        this.name = name;
        this.country_id = country_id;
        this.region = region;
        this.commune = commune;
        this.phone_prefix_id = phone_prefix_id;
        this.phone = phone;
        this.photo = photo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCountry_id() {
        return country_id;
    }
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getCommune() {
        return commune;
    }
    public void setCommune(String commune) {
        this.commune = commune;
    }
    public int getPhone_prefix_id() {
        return phone_prefix_id;
    }
    public void setPhone_prefix_id(int phone_prefix_id) {
        this.phone_prefix_id = phone_prefix_id;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
}