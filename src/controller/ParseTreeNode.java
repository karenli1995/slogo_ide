package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTreeNode<Command> {

    public Command data;
    public List<ParseTreeNode<Command>> children;

    public ParseTreeNode() {
        super();
        children = new ArrayList<ParseTreeNode<Command>>();
    }

    public ParseTreeNode(Command data) {
        this();
        setData(data);
    }

    public List<ParseTreeNode<Command>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(List<ParseTreeNode<Command>> children) {
        this.children = children;
    }

    public void addChild(ParseTreeNode<Command> child) {
        children.add(child);
    }

    public void addChildAt(int index, ParseTreeNode<Command> child) throws IndexOutOfBoundsException {
        children.add(index, child);
    }

    public void removeChildren() {
        this.children = new ArrayList<ParseTreeNode<Command>>();
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public ParseTreeNode<Command> getChildAt(int index) throws IndexOutOfBoundsException {
        return children.get(index);
    }

    public Command getData() {
        return this.data;
    }

    public void setData(Command data) {
        this.data = data;
    }

}
