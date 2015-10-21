package model;

import java.util.ArrayList;
import java.util.List;

import controller.Traverser;

public class Scene {

	private List<Data> myDataList = new ArrayList<Data>();
	private Traverser myTraverser;
	
	Scene(){
		Data myAllData = new Data();
		myDataList.add(myAllData);
	}

	
	/**
	 * Sets the Data object, passing information to Data from the front-end to
	 * the back-end.
	 */
	public void setData(int id, Data data) {
		myDataList.add(id, data);
//		myAllData = data;
	}

	/**
	 * Gets the Data object, containing information to be passed from back-end
	 * to front-end.
	 *
	 * @return
	 */
	public Data getData(int id) {
		return myDataList.get(id);
	}
	
	public List<Data> getAllData() {
		return myDataList;
	}
	
	/**
	 * Traverses command tree
	 *
	 * @return
	 */
	public Data traverse(int id) {
		Data myCurrData = myDataList.get(id);
		myCurrData = myTraverser.traverse(myTree, myCurrData);
		myDataList.add(id, myCurrData);
		return myCurrData;
	}
}
