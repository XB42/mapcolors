// A Java program to implement greedy algorithm for graph coloring
import java.io.*;
import java.util.*;
import java.util.LinkedList;

// This class represents an undirected graph using adjacency list
class Graph
{
   private int V;   // No. of vertices
   private static LinkedList<Integer> adj[]; //Adjacency List
   int result[];

   //Constructor
   Graph(int v)
   {
       V = v;
       adj = new LinkedList[v];
       for (int i=0; i<v; ++i)
           adj[i] = new LinkedList();
   }

   //Function to add an edge into the graph
   void addEdge(int v,int w)
   {
       adj[v].add(w);
       adj[w].add(v); //Graph is undirected
   }

   // Assigns colors (starting from 0) to all vertices and
   // prints the assignment of colors
   int greedyColoring()
   {
        result = new int[V];

       // Initialize all vertices as unassigned
       Arrays.fill(result, -1);

       // Assign the first color to first vertex
       result[0]  = 0;

       // A temporary array to store the available colors. False
       // value of available[cr] would mean that the color cr is
       // assigned to one of its adjacent vertices
       boolean available[] = new boolean[V];

       // Initially, all colors are available
       Arrays.fill(available, true);
       int max = 0;

       // Assign colors to remaining V-1 vertices
       for (int u = 1; u < V; u++)
       {
           // Process all adjacent vertices and flag their colors
           // as unavailable
           Iterator<Integer> it = adj[u].iterator() ;
           while (it.hasNext())
           {
               int i = it.next();
               if (result[i] != -1)
                   available[result[i]] = false;
           }

           // Find the first available color
           int cr;
           for (cr = 0; cr < V; cr++){
               if (available[cr])
               {
                   break;
                 }
           }
           if(cr>max) max = cr;

           result[u] = cr; // Assign the found color

           // Reset the values back to true for the next iteration
           Arrays.fill(available, true);
       }

       // print the result
       //if(max<4||max>7)System.out.println(max);
       return max;
       //for (int u = 0; u < V; u++)
         //  System.out.println("Vertex " + u + " --->  Color "
          //                     + result[u]);
   }

   // Driver method
   public static void main(String args[])
   {
       final int SIZE = 500;
       int a,b=0,t;
       System.out.print("\f");
       double avg=0,no , total = 0;
       int foctr = 0, fictr = 0, ctr = 0, sectr=0,sictr=0,tctr=0;
       ArrayList<Integer> vertlist = new ArrayList<Integer>();
       Random rand = new Random();

       for( t=0;t<10000;t++)
         {
          Graph g1 = new Graph(SIZE);

         for(int v=0;v<SIZE;v++)
         {

         for(int i=0; i<= (2 + rand.nextInt(3));i++)
         {


           b= rand.nextInt(SIZE);

           if(v!=b){
               g1.addEdge(v,b);


             if((v>=3 ?(b<=v*3-6): false) || (v>3 ? (b<=2*v - 4) : false))
             {

               int pos =adj[v].indexOf((Integer)b);
               adj[v].remove(pos);
             }
           }
           else
           i--;

          }
       }

        no = g1.greedyColoring();
        total ++;
        if(no ==3)tctr++;
        else if(no==4)foctr++;
        else if(no ==5)fictr++;
        else if(no ==6)sictr++;
        else if(no ==7)sectr++;
        else ctr++;

        avg += no;
       }



       avg/=t-1;


        System.out.println("average\t"+avg);
        System.out.println("threes\t"+tctr);
       System.out.println("fours\t"+foctr);
       System.out.println("fives\t"+fictr);
       System.out.println("sixes\t"+sictr);
       System.out.println("sevens\t"+sectr);
       System.out.println("others\t"+ctr);
    }


} 
