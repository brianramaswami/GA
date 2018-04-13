import java.util.*;
import java.lang.*;

public class Mate
{
 private    Chromosome MT_father, MT_mother, MT_child1, MT_child2;
 private    int MT_posChild1, MT_posChild2, MT_posLastChild,MT_posFather, MT_posMother,
             MT_numGenes, MT_numChromes;

 public Mate(ArrayList<Chromosome> population, int numGenes, int numChromes)
    {
        MT_numGenes     = numGenes;
        MT_numChromes   = numChromes;
        
        MT_posChild1    = population.size()/2;
        MT_posChild2    = MT_posChild1 + 1;
        MT_posLastChild= population.size() - 1;
        
        for (int i = MT_posLastChild; i >= MT_posChild1; i--)
            population.remove(i);
        
        MT_posFather = 0;
        MT_posMother = 1;
    }
 //Simple Top-Down Pairing
 public ArrayList<Chromosome> Crossover(ArrayList<Chromosome> population, int numPairs)
    {
        for (int j = 0; j < numPairs; j++)
        {
            MT_father       =  population.get(MT_posFather);
            MT_mother       =  population.get(MT_posMother);
            MT_child1       = new Chromosome(MT_numGenes);
            MT_child2       = new Chromosome(MT_numGenes);
            Random rnum     = new Random();
            int crossPoint  = rnum.nextInt(MT_numGenes);

            //left side
            for (int i = 0; i < crossPoint; i++)
                {
                    MT_child1.SetGene(i,MT_father.GetGene(i));
                    MT_child2.SetGene(i,MT_mother.GetGene(i));
                }
    
            //right side 
            for (int i = crossPoint; i < MT_numGenes; i++)
                {
                    MT_child1.SetGene(i, MT_mother.GetGene(i));
                    MT_child2.SetGene(i, MT_father.GetGene(i));
                }
                
            population.add(MT_posChild1,MT_child1);
            population.add(MT_posChild2,MT_child2);
            
            MT_posChild1    = MT_posChild1 + 2;
            MT_posChild2    = MT_posChild2 + 2;
            MT_posFather    = MT_posFather + 2;
            MT_posMother    = MT_posMother + 2;
        }
        return population;
    }


 //Simple Top-Down Double Point Pairing
 public ArrayList<Chromosome> TDDPCrossover(ArrayList<Chromosome> population, int numPairs)
    {
        for (int j = 0; j < numPairs; j++)
        {
            MT_father       =  population.get(MT_posFather);
            MT_mother       =  population.get(MT_posMother);
            MT_child1       = new Chromosome(MT_numGenes);
            MT_child2       = new Chromosome(MT_numGenes);
            Random rnum1     = new Random();
	        Random rnum2    = new Random();
            int crossPoint1  = rnum1.nextInt(MT_numGenes);
	        int crossPoint2  = rnum2.nextInt(MT_numGenes);

            //left side
            for (int i = 0; i < crossPoint1; i++)
                {
                    MT_child1.SetGene(i,MT_father.GetGene(i));
                    MT_child2.SetGene(i,MT_mother.GetGene(i));
                }

	    //center side
            for (int i = crossPoint1; i < crossPoint2; i++)
                {
                    MT_child1.SetGene(i, MT_mother.GetGene(i));
                    MT_child2.SetGene(i, MT_father.GetGene(i));
                }

    
            //right side 
            for (int i = crossPoint2; i < MT_numGenes; i++)
                {
                    MT_child1.SetGene(i,MT_father.GetGene(i));
                    MT_child2.SetGene(i,MT_mother.GetGene(i));
                }
                
            population.add(MT_posChild1,MT_child1);
            population.add(MT_posChild2,MT_child2);
            
            MT_posChild1    = MT_posChild1 + 2;
            MT_posChild2    = MT_posChild2 + 2;
            MT_posFather    = MT_posFather + 2;
            MT_posMother    = MT_posMother + 2;
        }
        return population;
    }

/*
 //Simple Top-Down Tournament Pairing
 public ArrayList<Chromosome> TournamentTSP(ArrayList<Chromosome> population, int numPairs)
    {
        Random rnum1     = new Random();
	    Random rnum2    = new Random();
        int crossPoint1  = rnum1.nextInt(MT_numGenes);
        int crossPoint2  = rnum2.nextInt(MT_numGenes);

        System.out.println(population);
        return population;
 
        // while (numPairs < 16){
        //     // Do Twice:
        //         // randomly select subset of population
        // Random rnum3 = new Random();
        // int n = rnum3.nextInt(crossPoint2)+ crossPoint1;
        }             
    }

    //         for(int i = crossPoint1; i < crossPoint2; i++){


        //         }
               
        //         // select 1 parent at random from subset
        //         // add parents to set of mating pairs
        // }
*/
      
} 
 
 // {
    //     Population tournament = new Population(tournamentSize, false);
    //     // For each place in the tournament get a random individual
    //     for (int i = 0; i < tournamentSize; i++) {
    //         int randomId = (int) (Math.random() * pop.size());
    //         tournament.saveIndividual(i, pop.getIndividual(randomId));
    //     }
    //     // Get the fittest
    //     Individual fittest = tournament.getFittest();
    //     return fittest;
    // }

    // func tournament_selection(pop, k):
    // best = null
    // for i=1 to k
    //     ind = pop[random(1, N)]
    //     if (best == null) or fitness(ind) > fitness(best)
    //         best = ind
    // return best
