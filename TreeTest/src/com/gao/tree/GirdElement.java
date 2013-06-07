package com.gao.tree;

public class GirdElement {
	private String gridId;
	private String gridName ;
	private boolean hasParent; 
	private boolean hasChild ;
	private String parent;
	private int level;
	private boolean expanded;


	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public boolean isHasParent() {
		return hasParent;
	}

	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}


	//private OutlineElement outlineElement;
	
	
	public GirdElement(String gridId, String gridName,
			boolean hasParent, boolean hasChild, String parent, int level,
			boolean expanded) {
		super();
		this.gridId = gridId;
		this.gridName = gridName;
		this.hasParent = hasParent;
		this.hasChild = hasChild;
		this.parent = parent;
		this.level = level;
		this.expanded = expanded;
	}
	
	
	
	
	

}
