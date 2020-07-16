
package UC;

import configuration.Configuration_Unsupervised_VSM;
import configuration.Configuration_Unsupervised_Network;
import configuration.Configuration_Unsupervised_Base;
import Interfaces.Main_Menu;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
    
    public static void main(String[] args) {
        
        if(args.length > 0){
            try{
                FileInputStream file;
                ObjectInputStream obj;
                File arquivo = new File(args[0]);
                if(!arquivo.isFile()){
                    System.out.println("Invalid configuration file.");
                    System.exit(0);
                }
                
                file = new FileInputStream(arquivo);
                obj = new ObjectInputStream(file);
                
                Configuration_Unsupervised_Base config = (Configuration_Unsupervised_Base)obj.readObject();
                
                if(config.getClass().getName().equals("configuration.Configuration_Unsupervised_VSM")){
                    Configuration_Unsupervised_VSM configuration = (Configuration_Unsupervised_VSM)config;
                    UnsupervisedVectorSpacedClustering.learning(configuration);
                }else if(config.getClass().getName().equals("configuration.Configuration_Unsupervised_Network")){
                    Configuration_Unsupervised_Network configuration = (Configuration_Unsupervised_Network)config;
                    UnsupervisedNetworkBasedClustering.learning(configuration);
                }
                
                obj.close();
            }catch(Exception e){
                System.err.println("Houve um erro ao ler o arquivo de configuração");
                e.printStackTrace();
            }  
        }else{
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Main_Menu();
                }
            });
        }
    }   
}
