import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int op;   
        int userID;
        int country_id;
        String mail = null;
        String name = null;
        String region = null;
        String comuna = null;
        int prefijo = 0;
        int celular = 0;
        String foto = null;
        int profileID = 0;
        int opEliminar = 0;
        ProfileDAO profileDAO = new ProfileDAO();
        do {
            System.out.print("\n\n\tMENU\n" +
                    "---------------\n" +
                    "0 . SALIR'\n" +
                    "1 . CREAR PERFIL\n" +
                    "2 . MOSTRAR PERFIL\n" +
                    "3 . ACTUALIZAR PERFIL'\n" +
                    "4 . ELIMINAR PERFIL\n" +
                    "\t OPCION NUMERO: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("\n\tINGRESA\n\t" + "\tNOMBRE EMAIL: \n\t");
                    mail = sc.next();
                    System.out.print("\n\tNAME: ");
                    name = sc.next();
                    System.out.print("\n\tREGION: ");
                    region = sc.next();
                    System.out.print("\n\tCOMMUNE: ");
                    comuna = sc.next();
                    System.out.print("\n\tNUMERO PREFIJO: ");
                    prefijo = sc.nextInt();
                    System.out.print("\n\tNUMERO CELULAR: ");
                    celular = sc.nextInt();
                    System.out.print("\n\tFOTO: ");
                    foto = sc.next();
                    userID = 4;
                    country_id = 3;
                    profileID = 1;
                    Profile profile = new Profile(profileID, userID, mail, name, country_id, region, comuna, prefijo, celular, foto);
                    boolean existencia = profileDAO.crearProfile(profile);
                    if (existencia) {
                        System.err.print("\n\tPerfil Creado");
                    } else {
                        System.err.print("\n\tIntente nuevamente");                        
                    }
                    break;
                case 2:
                    Profile pro = new Profile();
                    pro = profileDAO.mostrar();
                    System.out.print("\n\tUSUARIO: \n\t" + "\t" + pro.getName());
                    break;
                case 3:
                    System.out.print("\n\tACTUALIZA\n\t" + "\tNOMBRE EMAIL: \n\t");
                    mail = sc.next();
                    System.out.print("\n\tNAME: ");
                    name = sc.next();
                    System.out.print("\n\tREGION: ");
                    region = sc.next();
                    System.out.print("\n\tCOMMUNE: ");
                    comuna = sc.next();
                    System.out.print("\n\tNUMERO PREFIJO: ");
                    prefijo = sc.nextInt();
                    System.out.print("\n\tNUMERO CELULAR: ");
                    celular = sc.nextInt();
                    System.out.print("\n\tFOTO: ");
                    foto = sc.next();
                    userID = 1;
                    country_id = 3;
                    profileID = 1;
                    Profile profileModificado = new Profile(profileID, userID, mail, name, country_id, region, comuna, prefijo, celular, foto);
                    boolean actualizado = profileDAO.Modificar(profileModificado);
                    if (actualizado) {
                        System.err.print("\n\tPerfil actualizado");
                    } else {
                        System.err.print("\n\tIntente nuevamente");                        
                    }    
                    break;
                case 4:
                    System.out.print("\n\tELIMINAR\n\t" + "\tSEGURO? [1]: \n\t");   
                    opEliminar = sc.nextInt();
                    if (opEliminar == 1) {
                        boolean resultado = profileDAO.deleteProfile();
                        if (resultado) {
                            System.err.println("\n\tPROFILE ELIMINADO");
                        }
                    }  
                    break;
                default:
                    break;
            }
        } while (op != 0);
        sc.close();        
    }
}