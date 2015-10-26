package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import command.CommandInterface;
import controller.ParseTreeNode;
import controller.Parser;
import controller.Traverser;
import model.data.Data;
public class SlogoScene extends Observable {

    private List<Data> myDataList = new ArrayList<Data>();
    private Traverser myTraverser;
    private List<ParseTreeNode<CommandInterface>> myTree;
    private Parser myParser;

    public SlogoScene () {
        Data myAllData = new Data();
        myDataList.add(myAllData);
        myParser = new Parser();
        myTraverser = new Traverser();
    }

    /**
     * Sets the Data object, passing information to Data from the front-end to
     * the back-end.
     */
    public void setData (int id, Data data) {
        myDataList.set(id, data);
        setChanged();
        notifyObservers();
    }

    public ForObserverInterface getObserverData (int id) {
        return myDataList.get(id);
    }

    public DataTurtleInterface getTurtleData (int id) {
        return myDataList.get(id);
    }

    public ColorDataInterface ColorData (int id) {
        return myDataList.get(id);
    }

    public List<Data> getAllData () {
        return myDataList;
    }

    /**
     * Traverses command tree
     *
     * @return
     */
    public ForObserverInterface traverse (int id) {
        Data myCurrData = myDataList.get(id);

        if (!myTree.isEmpty()) {
            myTraverser.traverse(myTree, myCurrData);

        }
        System.out.println(id);
        setData(id, myCurrData);
        return myCurrData;
    }

    /**
     * Parses the commands
     *
     * @param s
     */
    public void parse (String s, int id) {
        Data myCurrData = myDataList.get(id);
        myTree = myParser.parse(s, myCurrData);
    }

    public Parser getParser () {
        return myParser;
    }

    public Traverser getTraverser () {
        return myTraverser;
    }
}
