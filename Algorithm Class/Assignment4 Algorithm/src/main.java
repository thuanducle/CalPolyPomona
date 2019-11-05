import java.util.LinkedList;

class Node {
	double index;
	double actualIndex;
	int listNumber;
	double P;
	double C;
	double R;
	double CP;
	double CC;
	double CR;
}

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = "";
		//This implementation only apply to 3 lists but it could be expand.
		LinkedList<Node> L1 = new LinkedList<Node>();
		LinkedList<Node> L2 = new LinkedList<Node>();
		LinkedList<Node> L3 = new LinkedList<Node>();
	for(double i = 0; i < 10; i++)
	{
		Node node = new Node();
		L1.add(node);
		node.P = 1/(i+2);
		node.C = i * 10;
		node.index = i;
		node.actualIndex = i;
		node.listNumber = 1;
		if(i == 0)
		{
			node.CC = node.C;
			node.CP = node.P;
			node.CR = node.CC/node.CP;
			continue;
		}
		else
		{
			node.CC = L1.get((int) (i-1)).CC + node.C;
			node.CP = L1.get((int) (i-1)).CP + node.P;
			node.CR = node.CC / node.CP;
		}
	}
	for(double i = 0; i < 20; i++)
	{
		Node node = new Node();
		L2.add(node);
		node.P = (i+1)/(i+2);
		node.C = Math.pow(2, i);
		node.index = i;
		node.actualIndex = i;
		node.listNumber = 2;
		if(i == 0)
		{
			node.CC = node.C;
			node.CP = node.P;
			node.CR = node.CC/node.CP;
			continue;
		}
		else
		{
			node.CC = L2.get((int) (i-1)).CC + node.C;
			node.CP = L2.get((int) (i-1)).CP + node.P;
			node.CR = node.CC / node.CP;
		}
	}
	for(double i = 0; i < 10; i++)
	{
		Node node = new Node();
		L3.add(node);
		node.P = (i+2)/(i+5);
		node.C = Math.pow(3, i);
		node.index = i;
		node.actualIndex = i;
		node.listNumber = 3;
		if(i == 0)
		{
			node.CC = node.C;
			node.CP = node.P;
			node.CR = node.CC/node.CP;
			continue;
		}
		else
		{
			node.CC = L3.get((int) (i-1)).CC + node.C;
			node.CP = L3.get((int) (i-1)).CP + node.P;
			node.CR = node.CC / node.CP;
		}
	}
while(true)
{
if(L1.isEmpty() && L2.isEmpty() && L3.isEmpty())
{
	break;
}
double smallR = Double.MAX_VALUE;
Node smallestNode;
//Initialize the smallestNode, this could change later.
if(!L1.isEmpty())
{
	smallestNode = L1.element();
}else if(!L2.isEmpty())
{
	smallestNode = L2.element();
}else {
	smallestNode = L3.element();
}
double listNumber = Double.MAX_VALUE;
//After that, basically loop through everything and find the smallest Node
	for(Node i: L1 )
	{
		if(i.CR < smallR)
		{
			smallR = i.CR;
			smallestNode = i;
		}
	}
	for(Node i: L2)
	{
		if(i.CR < smallR)
		{
			smallR = i.CR;
			smallestNode = i;
		}
	}
	for(Node i: L3)
	{
		if(i.CR < smallR)
		{
			smallR = i.CR;
			smallestNode = i;
		}
	}
	int actualIndex = 0;
	//Guaranteed to find a smallest;
	//After found the smallest, subtract each actualIndex by node.actualIndex
	while(actualIndex <= smallestNode.actualIndex) {
		if(smallestNode.listNumber == 1)
		{
			answer += "L[1]["+ (int)L1.element().index + "] ";
			listNumber = smallestNode.listNumber;
			actualIndex++;
			L1.remove();	
		}else if(smallestNode.listNumber == 2)
		{
			answer += "L[2]["+ (int)L2.element().index + "] ";
			listNumber = smallestNode.listNumber;
			actualIndex++;
			L2.remove();
		}else {
			answer += "L[3]["+ (int)L3.element().index + "] ";
			listNumber = smallestNode.listNumber;
			actualIndex++;
			L3.remove();
		}
	}
	//If list is that of smallestNode, update actual index, recompute the whole tree
	if(listNumber == 1)
	{
	for(int i =0; i < L1.size();i++)
	{
		L1.get(i).actualIndex -= actualIndex;
		L1.get(i).CC -= smallestNode.CC;
		L1.get(i).CP -= smallestNode.CP;
		L1.get(i).CR = (L1.get(i).CC)/(L1.get(i).CP);
	}
	}else if(listNumber == 2)
	{
		for(int i =0; i < L2.size();i++)
		{
			L2.get(i).actualIndex -= actualIndex;
			L2.get(i).CC -= smallestNode.CC;
			L2.get(i).CP -= smallestNode.CP;
			L2.get(i).CR = (L2.get(i).CC)/(L2.get(i).CP);
		}
	}else {
		for(int i =0; i < L3.size();i++)
		{
			L3.get(i).actualIndex -= actualIndex;
			L3.get(i).CC -= smallestNode.CC;
			L3.get(i).CP -= smallestNode.CP;
			L3.get(i).CR = (L3.get(i).CC)/(L3.get(i).CP);
		}
	}
}
System.out.println(answer);		
	}
}
