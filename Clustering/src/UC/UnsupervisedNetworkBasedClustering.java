package UC;

import configuration.Configuration_Unsupervised_Network;
import configuration.Configuration_Unsupervised_Base;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import networks.Document_Network_Generation;
import parameters.Parameters_DocumentNetwork_Knn;
import parameters.Parameters_LabelPropagation;
import parameters.Parameters_LabelPropagation_DocTerm;
import parameters.Parameters_MixtureModel;
import parameters.Parameters_SimpleRanking;
import parameters.Parameters_SimpleRanking_Plus_Clustering;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class UnsupervisedNetworkBasedClustering {

    public static void learning(Configuration_Unsupervised_Network config) {
        ArrayList<File> entradas = new ArrayList<>();
        Arquivos.lista(new File(config.getDirEntrada()), entradas);
        for (int i = 0; i < entradas.size(); i++) {
            if (!entradas.get(i).getAbsolutePath().endsWith(".arff")) {
                continue;
            }
            try {
                //carrego o conjunto de dados da entrada
                DataSource conjunto = new DataSource(entradas.get(i).getAbsolutePath());

                //carrega os objetos contidos no conjunto
                Instances objetos = conjunto.getDataSet();

                StringBuilder outputFile = new StringBuilder();
                StringBuilder outputFilePar = new StringBuilder();
                outputFile.append(config.getDirSaida());
                outputFile.append("/");
                outputFile.append(objetos.relationName());
                outputFile.append("_Unsupervised_");

                ExecutorService threads = Executors.newFixedThreadPool(config.getNumThreads());

                HashMap<Integer, Double>[] mappedInstances = new HashMap[objetos.numInstances()];
                mappedInstances = Clusterer.mappingInstances(objetos);
                ArrayList<Neighbor> adjList = new ArrayList<>();
                if (config.isLp()) {
                    outputFilePar = new StringBuilder();
                    outputFilePar.append(outputFile.toString());
                    outputFilePar.append("LabelPropagation_DocDoc_");
                    if (config.isKnn()) {
                        Parameters_DocumentNetwork_Knn knnNetwork = config.getKnn_Parameters();
                        Parameters_LabelPropagation lp_Parameters = config.getLp_Parameters();
                        for (int k = 0; k < knnNetwork.getKs().size(); k++) {;
                            StringBuilder outputFilePar2 = new StringBuilder();
                            outputFilePar2.append(outputFilePar.toString());
                            outputFilePar2.append(knnNetwork.getK(k) + "_");
                            if (lp_Parameters.isAsynchronous()) {
                                outputFilePar2.append("Assynchronous_");
                            }
                            if (lp_Parameters.isSynchronous()) {
                                outputFilePar2.append("Synchronous_");
                            }
                            if (lp_Parameters.isWeighted()) {
                                outputFilePar2.append("Weighted_");
                            }
                            if (lp_Parameters.isUnitary()) {
                                outputFilePar2.append("Unweighted_");
                            }
                            outputFilePar2.append(config.getNumReps());

                            adjList = Document_Network_Generation.generateKnnNetworkCosineAdjList(mappedInstances, knnNetwork.getK(k));
                            LabelPropagation_DocDoc lp = new LabelPropagation_DocDoc(mappedInstances.length, adjList);
                            lp.setAsynchronous(lp_Parameters.isAsynchronous());
                            lp.setSynchronous(lp_Parameters.isSynchronous());
                            lp.setWeighted(lp_Parameters.isWeighted());
                            lp.setUnitary(lp_Parameters.isUnitary());
                            lp.setIteracoes(lp_Parameters.getMaxIteration());
                            Learning(lp, config, outputFilePar2.toString(), objetos, threads);
                        }
                    }
                }
                if (config.isLpDocTerm()) {
                    Parameters_LabelPropagation_DocTerm lpDocTermParameter = new Parameters_LabelPropagation_DocTerm();

                    outputFilePar = new StringBuilder();
                    outputFilePar.append(outputFile.toString());
                    outputFilePar.append("LabelPropagation_DocTerm_");
                    if (lpDocTermParameter.isWeighted()) {
                        outputFilePar.append("Weighted_");
                    } else {
                        outputFilePar.append("Unweighted_");
                    }
                    outputFilePar.append(lpDocTermParameter.getMaxIteration());
                    LabelPropagation_DocTerm lpDocTerm = new LabelPropagation_DocTerm(objetos.numInstances());
                    lpDocTerm.setWeighted(lpDocTermParameter.isWeighted());
                    lpDocTerm.setUnitary(lpDocTermParameter.isUnitary());
                    lpDocTerm.setIteracoes(lpDocTermParameter.getMaxIteration());
                    Learning(lpDocTerm, config, outputFilePar.toString(), objetos, threads);
                }
                if (config.isSimpleRanking()) {
                    outputFilePar = new StringBuilder();
                    outputFilePar.append(outputFile.toString());
                    outputFilePar.append("SimpleRank_");
                    //num k atual, max iteration, minimum cohesion, num repetitions
                    Parameters_SimpleRanking simpleRanking_Parameters= config.getSimpleRanking_Parameters();
                    ArrayList<Integer> ks;
                    if(simpleRanking_Parameters.isAutoIncrementK()){
                        ks = simpleRanking_Parameters.automaticallyGenerate(objetos);
                    }else{
                        ks = simpleRanking_Parameters.getKs();
                    }
                    for(int experimento = 0; experimento < ks.size(); experimento++){
                        
                        StringBuilder outputFilePar2= new StringBuilder();
                        outputFilePar2.append(outputFilePar.toString());
                        outputFilePar2.append(ks.get(experimento)+"_");
                        outputFilePar2.append(simpleRanking_Parameters.getMaxIteration()+"_");
                        outputFilePar2.append(simpleRanking_Parameters.getMinimumDifference()+"_");
                        outputFilePar2.append(config.getNumReps()+"_");
                        
                        
                        for (int alfa = 0; alfa < simpleRanking_Parameters.getAlfa().size(); alfa++) {
                            StringBuilder outputFilePar3 = new StringBuilder();
                            outputFilePar3.append(outputFilePar2.toString());
                            outputFilePar3.append(simpleRanking_Parameters.getAlfa().get(alfa));
                            
                            SimpleRanking simpleRank = new SimpleRanking(objetos.numInstances(), ks.get(experimento));
                            simpleRank.setMinimumDif(simpleRanking_Parameters.getMinimumDifference());
                            simpleRank.setIteracoes(simpleRanking_Parameters.getMaxIteration());
                            simpleRank.setAlfa(simpleRanking_Parameters.getAlfa().get(alfa));
                            Learning(simpleRank, config, outputFilePar3.toString(), objetos,threads);
                        }
                        
                    }
                }
                if (config.isSimpleRankClus()) {
                    outputFilePar = new StringBuilder();
                    outputFilePar.append(outputFile.toString());
                    outputFilePar.append("SimpleRankClus_");
                    //num k atual, max iteration, minimum cohesion, num repetitions
                    Parameters_SimpleRanking_Plus_Clustering simpleRankClus_Parameters= config.getSimpleRankClus_Parameters();
                    ArrayList<Integer> ks;
                    if(simpleRankClus_Parameters.isAutoIncrementK()){
                        ks = simpleRankClus_Parameters.automaticallyGenerate(objetos);
                    }else{
                        ks = simpleRankClus_Parameters.getKs();
                    }
                    for(int experimento = 0; experimento < ks.size(); experimento++){
                        
                        StringBuilder outputFilePar2= new StringBuilder();
                        outputFilePar2.append(outputFilePar.toString());
                        outputFilePar2.append(ks.get(experimento)+"_");
                        outputFilePar2.append(simpleRankClus_Parameters.getMaxIteration()+"_");
                        outputFilePar2.append(simpleRankClus_Parameters.getMinimumDifference()+"_");
                        outputFilePar2.append(config.getNumReps()+"_");
                        
                        
                        for (int alfa = 0; alfa < simpleRankClus_Parameters.getAlfa().size(); alfa++) {
                            StringBuilder outputFilePar3 = new StringBuilder();
                            outputFilePar3.append(outputFilePar2.toString());
                            outputFilePar3.append(simpleRankClus_Parameters.getAlfa().get(alfa));
                            
                            SimpleRanking_Plus_Clustering simpleRankClus = new SimpleRanking_Plus_Clustering (objetos.numInstances(), ks.get(experimento));
                            simpleRankClus.setMinimumDif(simpleRankClus_Parameters.getMinimumDifference());
                            simpleRankClus.setIteracoes(simpleRankClus_Parameters.getMaxIteration());
                            simpleRankClus.setAlfa(simpleRankClus_Parameters.getAlfa().get(alfa));
                            Learning(simpleRankClus, config, outputFilePar3.toString(), objetos,threads);
                        } 
                    }
                }
                if(config.isMixtureModel()){
                    outputFilePar = new StringBuilder();
                    outputFilePar.append(outputFile.toString());
                    outputFilePar.append("MixtureModel_");
                    //num k atual, max iteration, minimum cohesion, num repetitions
                    Parameters_MixtureModel mixtureModel_Parameter = config.getMixture_Model();
                    ArrayList<Integer> ks;
                    if(mixtureModel_Parameter.isAutoIncrementK()){
                        ks = mixtureModel_Parameter.automaticallyGenerate(objetos);
                    }else{
                        ks = mixtureModel_Parameter.getKs();
                    }
                    for(int experimento = 0; experimento < ks.size(); experimento++){
                        
                        StringBuilder outputFilePar2= new StringBuilder();
                        outputFilePar2.append(outputFilePar.toString());
                        outputFilePar2.append(ks.get(experimento)+"_");
                        outputFilePar2.append(mixtureModel_Parameter.getMaxIteration()+"_");
                        outputFilePar2.append(mixtureModel_Parameter.getTolerance()+"_");
                        outputFilePar2.append(config.getNumReps());
                        
                        MixtureModel mixtureModel = new MixtureModel(objetos.numInstances(), ks.get(experimento));
                        mixtureModel.setMinimumDif(mixtureModel_Parameter.getTolerance());
                        mixtureModel.setIteracoes(mixtureModel_Parameter.getMaxIteration());
                        Learning(mixtureModel, config, outputFilePar2.toString(), objetos,threads);
                    }
                }
                
                
                threads.shutdown();

                boolean exit = false;
                while (exit == false) {
                    if (threads.isTerminated()) {
                        System.out.println("Process concluded successfully");
                        exit = true;
                    } else {
                        Thread.sleep(1000);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error when generating file");
                System.exit(0);
            }
        }
    }

    public static void Learning(Clusterer cluster, Configuration_Unsupervised_Base config, String outputFile, Instances data, final ExecutorService threads) {
        
        Results result;
        try {
            final File output = new File(outputFile);
            final File outputResult = new File(output.getAbsolutePath() + ".txt");
            if (outputResult.exists()) {
                return;
            }

            result = new Results(output, config.getNumReps());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean ok = true;
                    for (int rep = 0; rep < config.getNumReps(); rep++) {
                        long begin = System.currentTimeMillis();
                        ok = cluster.buildCluster(data, rep);
                        long end = System.currentTimeMillis();
                        if(ok == false){
                            break;
                        }
                        result.computeEvaluationMeasures(cluster, data, rep, end - begin);
                    }
                    if(ok != false){
                        result.saveResults();
                    }
                }
            });
            threads.execute(thread);

        } catch (Exception e) {
            System.out.println("Error when generating file");
            e.printStackTrace();
        }
    }

}
