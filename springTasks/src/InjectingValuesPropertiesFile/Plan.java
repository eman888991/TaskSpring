package InjectingValuesPropertiesFile;

public class Plan implements Vehicle {


    Database database;
    public void setDatabase(Database database) {
        this.database = database;
    }
    public Database getDatabase() {
        return database;
    }
    @Override
    public void saveToDatabase(Vehicle vehicle) {
        database.saveData(vehicle);
    }
}
