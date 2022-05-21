package src;

import org.junit.Test;

public class Tests {

	  @Test
	    void addEdge() {
	        int vertices = 100;
	        Grafo graph = new Grafo(vertices);
	        graph.addEdge("Guate", "Xela", 1);
	        graph.addEdge("Guate", "Ye", 7);
	        graph.addEdge("Mixco", "Ye", 4);
	        graph.addEdge("Guate", "Mixco", 2);
	        graph.addEdge("Ye", "Mixco", 3);
	        graph.addEdge("Xela", "Guate", 1);
	        graph.GenerateMatrix();
	        System.out.println(graph.askForRoute("Xela","Ye"));
	    }

	    @Test
	    void floydWarshall() {
	        int vertices = 100;
	        Grafo graph = new Grafo(vertices);
	        graph.addEdge("Guate", "Xela", 1);
	        graph.addEdge("Guate", "Ye", 7);
	        graph.addEdge("Mixco", "Ye", 4);
	        graph.addEdge("Guate", "Mixco", 2);
	        graph.addEdge("Ye", "Mixco", 3);
	        graph.addEdge("Xela", "Guate", 1);
	        graph.GenerateMatrix();
	        graph.floydWarshallAlgorithm(graph.getMatrix());
	        System.out.println(graph.askForRoute("Xela","Ye"));
	        System.out.println(graph.getCenter());
	    }

	    @Test
	    void getCenter() {
	        int vertices = 100;
	        Grafo graph = new Grafo(vertices);
	        graph.addEdge("Guate", "Xela", 1);
	        graph.addEdge("Guate", "Ye", 7);
	        graph.addEdge("Mixco", "Ye", 4);
	        graph.addEdge("Guate", "Mixco", 2);
	        graph.addEdge("Ye", "Mixco", 3);
	        graph.addEdge("Xela", "Guate", 1);
	        graph.GenerateMatrix();
	        System.out.println(graph.askForRoute("Xela","Ye"));
	        System.out.println(graph.getCenter());
	    }

	    @Test
	    void verifyVertices() {
	    }
	}
}
