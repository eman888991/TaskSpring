package InjectingValuesPropertiesFile;

public class Database {
    private String url;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void saveData(Vehicle vehicle) {
        System.out.println("Object Name: "+vehicle.getClass()+ " url: "+url + "password : "+password  + " username: "+username );
    }
}
