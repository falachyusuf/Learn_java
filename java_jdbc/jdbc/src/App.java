import daos.RegionDAO;
import models.Region;
import tools.DbConnection;

public class App {
    public static void main(String[] args) throws Exception {
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());


        RegionDAO rdao = new RegionDAO(connection.getConnection());
        // // How to get all data
        for(Region region : rdao.getAll()){
            System.out.println(region.getId());
            System.out.println(region.getName());
        }

        // // How to insert data
        // Region region = new Region(1, "waktu indonesia timur");
        // System.out.println(rdao.insert(region));

        // // How to get data by id
        // Region region = rdao.getById(1);
        // System.out.println(region.getId());
        // System.out.println(region.getName());

        // // How to update data
        // System.out.println(rdao.update(1, "WIT"));

        //  // How to delete data
        // System.out.println(rdao.delete(1));
    }
}
