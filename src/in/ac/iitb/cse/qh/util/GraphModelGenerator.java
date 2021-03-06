package in.ac.iitb.cse.qh.util;

import org.primefaces.model.graphvis.GraphvisEdge;
import org.primefaces.model.graphvis.GraphvisModel;
import org.primefaces.model.graphvis.GraphvisNode;
import org.primefaces.model.graphvis.impl.GraphvisModelImpl;

public class GraphModelGenerator {

	/**
	 * Create a new graph model and fill it randomly
	 * 
	 * @param minNodes : minimum node number
	 * @param maxNodes : maximum node number
	 * @param maxEdges : maximum edge number
	 * 
	 * @return a new GraphvisModel filled
	 */
	public static GraphvisModel generateGraphModel(int minNodes, int maxNodes, int maxEdges){		
		GraphvisModel graphModel = new GraphvisModelImpl();
		fillGraphModel(graphModel, minNodes, maxNodes, maxEdges);
		return graphModel;		
	}
	
	/**
	 * fill randomly a graph model.
	 * 
	 * @param graphModel : the graphModel
	 * @param minNodes : minimum node number
	 * @param maxNodes : maximum node number
	 * @param maxEdges : maximum edge number

	 */
	public static GraphvisModel fillGraphModel(GraphvisModel graphModel, int minNodes, int maxNodes, int maxEdges){
		
		int maxWeight = 3;
		
		//remove all previous nodes
		for(GraphvisNode node : graphModel.getNodes()){
			graphModel.removeNode(node);
		}
		
		long nodesNumber =  minNodes + Math.round(Math.random() * (maxNodes - minNodes) );
		long edgesNumber = Math.round(Math.random() * maxEdges) + 1;
		edgesNumber = nodesNumber * 3;
		if(edgesNumber > maxEdges){
			edgesNumber  = maxEdges;
		}

		System.out.println("Nodes number:" + nodesNumber + " Edeges number:" + edgesNumber);
		
		for(int i = 1; i <= nodesNumber ; i++){
			graphModel.addNode("N" + i, "N" + i);
		}

		for(int i = 1; i < edgesNumber; i++){
			GraphvisNode sourceNode = graphModel.getNode("N" + (Math.round(Math.random() * (nodesNumber - 1)) + 1));
			GraphvisNode targetNode = graphModel.getNode("N" + (Math.round(Math.random() * (nodesNumber - 1)) + 1));									
			GraphvisEdge edge = graphModel.addEdge("" + i + "_" + sourceNode.getId() + "_" + targetNode.getId() , sourceNode, targetNode);
			edge.setWidth((int) (Math.round(Math.random() * maxWeight) + 1));
			edge.setLabel("" + edge.getWidth());
			edge.setDirected(true);
		}

		return graphModel;		
	}
	

	
	

	
}
